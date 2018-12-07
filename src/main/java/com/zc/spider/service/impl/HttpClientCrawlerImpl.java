package com.zc.spider.service.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import javax.mail.MessagingException;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.omg.CORBA.Current;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.zc.spider.dao.CrawlDao;
import com.zc.spider.dao.PicDao;
import com.zc.spider.exception.CookieException;
import com.zc.spider.pojo.CrawlResultPojo;
import com.zc.spider.pojo.Msg;
import com.zc.spider.pojo.Pic;
import com.zc.spider.pojo.ResponseResult;
import com.zc.spider.pojo.UrlPojo;
import com.zc.spider.service.iface.ICrawler;
import com.zc.spider.util.EmailUtils;

@Service
public class HttpClientCrawlerImpl implements ICrawler {

	private Logger log = LoggerFactory.getLogger(HttpClientCrawlerImpl.class);

	@Autowired
	private CrawlDao crawDao;
	@Autowired
	private PicDao picDao;

	@Override
	public CrawlResultPojo crawl(UrlPojo urlPojo, String cookie) {
		CrawlResultPojo resultPojo = new CrawlResultPojo();
		if (urlPojo == null) {
			resultPojo.setSuccess(false);
			return resultPojo;
		}
		CloseableHttpClient httpClient = HttpClients.custom().build();
		// 采用get方式
		HttpGet httpGet = new HttpGet(urlPojo.getUrl());
		// 将cookie设置进去
		httpGet.addHeader("cookie", cookie);
		BufferedReader br = null;
		try {
			log.info("正在连接...");
			CloseableHttpResponse response = httpClient.execute(httpGet);
			log.info("获取数据成功...");
			HttpEntity entity = response.getEntity();
			br = new BufferedReader(new InputStreamReader(entity.getContent(), "utf-8"));
			String line = null;
			StringBuilder builder = new StringBuilder();
			while ((line = br.readLine()) != null) {
				builder.append(line);
			}
			resultPojo.setSuccess(true);
			resultPojo.setPageContent(builder.toString());
		} catch (IOException e) {
			log.error("{}", e);
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				log.error("{}", e);
			}
		}
		return resultPojo;
	}

	// 针对的是qq空间的
	public void qqCrawl(String url, String cookie, long start, long end, String pic_path) {
		final long s = start;
		final long e = end;
		for (long i = s; i < e; i++) {
			// 这个变量是用来给图片后面加后缀保证唯一性的
			int pic_num = 1;
			for (int j = 0;; j += 20) {
				UrlPojo urlPojo = new UrlPojo();
				String u1 = url.replaceAll("(?<=uin=).[0-9]*", i + "");
				String new_url = u1.replaceAll("(?<=pos=).{1}", j + "");
				urlPojo.setUrl(new_url);
				CrawlResultPojo crawl = crawl(urlPojo, cookie);
				String pageContent = crawl.getPageContent();
				try {
					// 每次爬完一个页面，休息随机5到10秒
					Thread.sleep((long) Math.random() * 5000 + 5000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					log.error("{}", e);
				}
				// 解析json数据
				pageContent = pageContent.substring(17, pageContent.length() - 2);
				//打印的是全部的json数据
				log.info(pageContent);
				// 封装成javabean
				ResponseResult responseResult = JSON.parseObject(pageContent, ResponseResult.class);
				ArrayList<Msg> msglist = responseResult.getMsglist();
				//判断cookie是否过期
				if(responseResult.getMessage().equals("请先登录空间")) {
						//抛出未登录异常
						throw new CookieException("cookie过期异常");
				}
				// 如果空间可以直接进去并且空间有说说的话就可以对数据进行统计
				if (msglist != null) {
					// log.info("一共有" + responseResult.getMsglist().size() + "条说说" +
					// responseResult);
					for (Msg msg : msglist) {
						crawDao.save(msg);
						// log.info("当前是"+Thread.currentThread().getName()+"正在执行");
						ArrayList<Pic> picList = msg.getPic();
						// 如果存在图片
						if (picList != null) {
							for (Pic pic : picList) {
								pic.setQq_num(msg.getUin());
								picDao.save(pic);
								try {
									log.info("正在下载图片...");
									// 将有图片的自动下载到本地
									download(pic.getUrl2(),
											pic_path + "\\" + pic.getQq_num() + "-" + (pic_num++) + ".jpg");
									log.info(pic.getUrl2());
									log.info("下载图片结束");
								} catch (Exception e1) {
									log.error("{}", e);
								}
							}
						}
					}
				} else {
					break;
				}
			}
		}

	}

	// 根据图片地址下载图片
	public static void download(String _url, String path) throws Exception {
		try {
			URL url = new URL(_url);
			URLConnection con = url.openConnection();
			con.setConnectTimeout(5000);
			InputStream is = con.getInputStream();
			byte[] bs = new byte[1024];
			int len;
			File sf = new File(path);
			OutputStream os = new FileOutputStream(sf);
			while ((len = is.read(bs)) != -1) {
				os.write(bs, 0, len);
			}
			os.close();
			is.close();

		} catch (IOException e) {
		}
	}

	/*
	 * public static void main(String[] args) { try { download(
	 * "http://b306.photo.store.qq.com/psb?/86581b80-c2b3-40f8-98a9-64d98dbf9cdb/Pf.elYlEgQnSkKZWCUYhlfhmtSLZRvP*a4RiJBV*W5Y!/m/dDIBAAAAAAAA&bo=OASABwAAAAAAAJ0!",
	 * "C:\\Users\\18368\\Desktop\\爬取图片\\33.jpg"); } catch (Exception e) { // TODO
	 * Auto-generated catch block e.printStackTrace(); } }
	 */

}
