package com.zc.spider.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.zc.spider.dao.CrawlDao;
import com.zc.spider.pojo.CrawlResultPojo;
import com.zc.spider.pojo.Msg;
import com.zc.spider.pojo.ResponseResult;
import com.zc.spider.pojo.UrlPojo;
import com.zc.spider.service.iface.ICrawler;
@Service
public class HttpClientCrawlerImpl implements ICrawler {
	
	@Autowired
	private CrawlDao crawDao;
	@Override
	public CrawlResultPojo crawl(UrlPojo urlPojo) {
		CrawlResultPojo resultPojo = new CrawlResultPojo();
		if (urlPojo == null) {
			resultPojo.setSuccess(false);
			return resultPojo;
		}
		CloseableHttpClient httpClient = HttpClients.custom().build();
		// 采用get方式
		HttpGet httpGet = new HttpGet(urlPojo.getUrl());
		//将cookie设置进去
		String cookies = "pgv_pvi=435138560; pgv_pvid=4687176740; RK=G45lqAMRGp; ptcz=0714c43c92a82063efca4d0204fe2c6fe2bc45fc97cbdca8bd1918b3c394a1f7; tvfe_boss_uuid=a4d7cb814103c1e8; o_cookie=1836810134; pac_uid=1_1836810134; pgv_si=s7687701504; pgv_info=ssid=s512303782; _qpsvr_localtk=0.06915683482830093; ptisp=ctc; ptui_loginuin=1835901302; pt2gguin=o1835901302; qz_screen=1280x720; 1835901302_todaycount=0; 1835901302_totalcount=2; QZ_FE_WEBP_SUPPORT=1; __Q_w_s__QZN_TodoMsgCnt=1; 3g_guest_id=-8680516557538853000; g_ut=2; zzpaneluin=; zzpanelkey=; Loading=Yes; cpu_performance_v8=15; __Q_w_s_hat_seed=1; uin=o1835901302; skey=@DUAqazqnN; p_uin=o1835901302; pt4_token=M8vDT55kxevVLq-bRwmnU5pg83cUmBe58Rg1YKZV0Ug_; p_skey=yTKbRDMxl2R6wLXjSnRv929T2Syij*V931crVANZNOA_; rv2=80758D68F25535A297DD763955282A2F62AFCE001ED543D9DD; property20=57EB77352B566F1ECC1140D709D28D1EA97DEEC9BABDCA0E98217861BA9EC5045E15632C3BA9E759";
		httpGet.addHeader("cookie", cookies);
		BufferedReader br = null;
		try {
			CloseableHttpResponse response = httpClient.execute(httpGet);
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
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return resultPojo;
	}
	
	public void qqCrawl() {
		for (int i = 169999900; i < 170000000; i++) {
			for (int j = 0;; j+=20) {
				UrlPojo urlPojo = new UrlPojo();
				urlPojo.setUrl(
						"https://user.qzone.qq.com/proxy/domain/taotao.qq.com/cgi-bin/emotion_cgi_msglist_v6?uin="+i+"&ftype=0&sort=0&pos="+j+"&num=20&replynum=100&g_tk=1696668005&callback=_preloadCallback&code_version=1&format=jsonp&need_private_comment=1&qzonetoken=693b943e7e70a1421a857fc53caea59833ae6f472de42e1183846ec680ef7e7ac3c0586b123990f0f8ea&g_tk=1696668005");
				CrawlResultPojo crawl = crawl(urlPojo);
				String pageContent = crawl.getPageContent();
				// 解析json数据
				pageContent = pageContent.substring(17, pageContent.length() - 2);
				// System.out.println(pageContent);
				// 封装成javabean
				ResponseResult responseResult = JSON.parseObject(pageContent, ResponseResult.class);
				// 如果空间可以直接进去并且空间有说说的话就可以对数据进行统计
				if (responseResult.getMsglist() != null) {
					System.out.println("一共有" + responseResult.getMsglist().size() + "条说说" + responseResult);
					ArrayList<Msg> msglist = responseResult.getMsglist();
					for (Msg msg : msglist) {
						crawDao.save(msg);
					}
				}else {
					break;
				}
			}
		}
		
		
		
	}

}
