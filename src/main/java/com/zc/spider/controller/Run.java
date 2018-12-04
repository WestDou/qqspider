package com.zc.spider.controller;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zc.spider.pojo.CrawlResultPojo;
import com.zc.spider.pojo.ResponseResult;
import com.zc.spider.pojo.UrlPojo;
import com.zc.spider.service.impl.HttpClientCrawlerImpl;

public class Run {
	public static void main(String[] args) {
		HttpClientCrawlerImpl httpClientCrawlerImpl = new HttpClientCrawlerImpl();
		UrlPojo urlPojo = new UrlPojo();
		urlPojo.setUrl("https://user.qzone.qq.com/proxy/domain/taotao.qq.com/cgi-bin/emotion_cgi_msglist_v6?uin=2423543534&ftype=0&sort=0&pos=0&num=20&replynum=100&g_tk=1696668005&callback=_preloadCallback&code_version=1&format=jsonp&need_private_comment=1&qzonetoken=693b943e7e70a1421a857fc53caea59833ae6f472de42e1183846ec680ef7e7ac3c0586b123990f0f8ea&g_tk=1696668005");
		CrawlResultPojo crawl = httpClientCrawlerImpl.crawl(urlPojo);
		String pageContent = crawl.getPageContent();
//		System.out.println(crawl.getPageContent());
//		Document document = Jsoup.parse(pageContent);
//		Elements elements = document.select("p");
//		for (Element element : elements) {
//			System.out.println(element.ownText());
//		}
		//解析json数据
		pageContent = pageContent.substring(17, pageContent.length()-2);
//		System.out.println(pageContent);
		//封装成javabean
		ResponseResult responseResult = JSON.parseObject(pageContent, ResponseResult.class);
		//如果空间可以直接进去并且空间有说说的话就可以对数据进行统计
		if(responseResult.getMsglist()!=null) {
			System.out.println("һ����"+responseResult.getMsglist().size()+"��˵˵"+responseResult);
		}
		
		
		
	}
}
