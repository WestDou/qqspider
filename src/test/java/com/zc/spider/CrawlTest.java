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
@SpringBootTest(classes = { RunApplication.class })
public class CrawlTest {
	private Logger log = LoggerFactory.getLogger(CrawlTest.class);

	@Autowired
	private HttpClientCrawlerImpl httpClientCrawlerImpl;

	@Test
	public void crawlTest() {
		httpClientCrawlerImpl.qqCrawl("https://user.qzone.qq.com/proxy/domain/taotao.qq.com/cgi-bin/emotion_cgi_msglist_v6?uin=2707891305&ftype=0&sort=0&pos=0&num=20&replynum=100&g_tk=1348799539&callback=_preloadCallback&code_version=1&format=jsonp&need_private_comment=1&qzonetoken=a3210c63abcefde146914c8ad536f2c2837fe0600cfec43faa86d90cbca44a735c35a474f8dce3b0ea42&g_tk=1348799539","pgv_pvi=435138560; pgv_pvid=4687176740; RK=G45lqAMRGp; ptcz=0714c43c92a82063efca4d0204fe2c6fe2bc45fc97cbdca8bd1918b3c394a1f7; tvfe_boss_uuid=a4d7cb814103c1e8; o_cookie=1836810134; pac_uid=1_1836810134; pgv_si=s7687701504; pgv_info=ssid=s512303782; _qpsvr_localtk=0.06915683482830093; ptisp=ctc; qz_screen=1280x720; 1835901302_todaycount=0; 1835901302_totalcount=2; QZ_FE_WEBP_SUPPORT=1; __Q_w_s__QZN_TodoMsgCnt=1; 3g_guest_id=-8680516557538853000; g_ut=2; zzpaneluin=; zzpanelkey=; __Q_w_s_hat_seed=1; Loading=Yes; ptui_loginuin=2707891305; pt2gguin=o2707891305; uin=o2707891305; skey=@OZIc6qtR4; p_uin=o2707891305; pt4_token=mdXBMWC632kOJMJelZ3kDdbk*6l2-LauFyDAiqmVH5U_; p_skey=VyDN8o5raphfJU2VwOpqSLFB80ia*3k1haGWqwJBMNk_; 2707891305_todaycount=0; 2707891305_totalcount=0; cpu_performance_v8=4; rv2=80A210D86A689C1FAE800EA6AF28252721DFE19518D1EE14FF; property20=169FC8D7D833AF71E56BDF3A80E78CAD81233973E12F33C89E98912312143FD07EF424B2AAF11A0B",1800645666, 1964565666,"C:\\Users\\18368\\Desktop\\爬2");
	}

}
