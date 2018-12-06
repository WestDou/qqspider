package com.zc.spider.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zc.spider.service.impl.HttpClientCrawlerImpl;

@Controller
@RequestMapping(value = "admin")
public class CrawlController {

	@Autowired
	private HttpClientCrawlerImpl httpClientCrawlerImpl;
	@RequestMapping(value = "crawl")
	private void crawl() {
		httpClientCrawlerImpl.qqCrawl("","",100000000,199930000,"");
		
	}

}
