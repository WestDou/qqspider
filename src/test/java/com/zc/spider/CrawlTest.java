package com.zc.spider;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.zc.spider.service.impl.HttpClientCrawlerImpl;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= {RunApplication.class})
public class CrawlTest {
	private Logger log = LoggerFactory.getLogger(CrawlTest.class);
	
	@Autowired
	private HttpClientCrawlerImpl httpClientCrawlerImpl;
	

	@Test
	public void crawlTest() {
		httpClientCrawlerImpl.qqCrawl();
	}
	
	
	
	
}
