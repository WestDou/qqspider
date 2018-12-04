/*package com.zc.spider.service.impl;

import java.io.IOException;
import java.util.LinkedList;

import org.apache.http.NameValuePair;
import org.apache.http.client.CookieStore;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieSpec;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

import com.zc.spider.pojo.CrawlResultPojo;
import com.zc.spider.pojo.UrlPojo;
import com.zc.spider.service.iface.ICrawler;

public class LoginHttpClientCrawlerImpl implements ICrawler{

	@Override
	public CrawlResultPojo crawl(UrlPojo urlPojo) {
		// TODO Auto-generated method stub
		
		String name = "";
		String password = "";
		//全局请求设置
		RequestConfig globalConfig = RequestConfig.custom().setCookieSpec(CookieSpecs.STANDARD).build();
		CookieStore cookieStore = new BasicCookieStore();
		//创建httpclient上下文
		HttpClientContext context = HttpClientContext.create();
		
		context.setCookieStore(cookieStore);
		
		CloseableHttpClient httpClient = HttpClients.custom().setDefaultRequestConfig(globalConfig)
		        .setDefaultCookieStore(cookieStore).build();
		CloseableHttpResponse res = null;
		
		//创建本地的http内容
		HttpGet get = new HttpGet("");
		try {
			res = httpClient.execute(get, context);
			System.out.println("访问后获取的常规Cookie:===============");
	        for (Cookie c : cookieStore.getCookies()) {
	          System.out.println(c.getName() + ": " + c.getValue());
	        }
	        res.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		LinkedList<NameValuePair> valuePairs = new LinkedList<NameValuePair>();
		valuePairs.add(new BasicNameValuePair("u", name));
		valuePairs.add(new BasicNameValuePair("p", password));
		
		
		return null;
	}
	
	
	

}
*/