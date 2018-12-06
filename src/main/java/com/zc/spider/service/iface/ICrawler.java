package com.zc.spider.service.iface;

import com.zc.spider.pojo.CrawlResultPojo;
import com.zc.spider.pojo.UrlPojo;

public interface ICrawler {
	public CrawlResultPojo crawl(UrlPojo urlPojo,String cookie);
}

