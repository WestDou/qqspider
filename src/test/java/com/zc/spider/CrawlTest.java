package com.zc.spider;

import javax.mail.MessagingException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.zc.spider.service.impl.HttpClientCrawlerImpl;
import com.zc.spider.util.EmailUtils;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { RunApplication.class })
public class CrawlTest {
	private Logger log = LoggerFactory.getLogger(CrawlTest.class);

	@Autowired
	private HttpClientCrawlerImpl httpClientCrawlerImpl;

	@Test
	public void crawlTest() {
		try {
			
			//参数分别为接口url，cookie值，起始，结束，图片的文件夹路径(文件会自动生成)
			httpClientCrawlerImpl.qqCrawl("https://user.qzone.qq.com/proxy/domain/taotao.qq.com/cgi-bin/emotion_cgi_msglist_v6?uin=543354356&ftype=0&sort=0&pos=0&num=20&replynum=100&g_tk=1348799539&callback=_preloadCallback&code_version=1&format=jsonp&need_private_comment=1&qzonetoken=16b7677879ccd05dc03a16b37836a679af2d6df79fd9bcb0fff5ba6ef11a1009c3c62ef977260434ca87&g_tk=1348799539","pgv_pvi=435138560; pgv_pvid=4687176740; RK=G45lqAMRGp; ptcz=0714c43c92a82063efca4d0204fe2c6fe2bc45fc97cbdca8bd1918b3c394a1f7; tvfe_boss_uuid=a4d7cb814103c1e8; o_cookie=1836810134; pac_uid=1_1836810134; pgv_si=s7687701504; pgv_info=ssid=s512303782; _qpsvr_localtk=0.06915683482830093; ptisp=ctc; qz_screen=1280x720; 1835901302_todaycount=0; 1835901302_totalcount=2; QZ_FE_WEBP_SUPPORT=1; __Q_w_s__QZN_TodoMsgCnt=1; 3g_guest_id=-8680516557538853000; g_ut=2; zzpaneluin=; zzpanelkey=; __Q_w_s_hat_seed=1; rv2=8068B98791C4AA8006B8D2FB1A6292B04D5AA4A608980219FA; property20=930EB040D36FCB82E0062EACDAF979C15B3F3CFA2F1D6524A805A4E02DDC9A1C9DF2A9B9C4E992A6; cpu_performance_v8=8; Loading=Yes; ptui_loginuin=2707891305; pt2gguin=o2707891305; uin=o2707891305; skey=@OZIc6qtR4; p_uin=o2707891305; pt4_token=mdXBMWC632kOJMJelZ3kDdbk*6l2-LauFyDAiqmVH5U_; p_skey=VyDN8o5raphfJU2VwOpqSLFB80ia*3k1haGWqwJBMNk_; 2707891305_todaycount=0; 2707891305_totalcount=0",563546543, 1964565666,"C:\\Users\\18368\\Desktop\\爬2");
		}catch (Exception e) {
			try {
				EmailUtils.sendMail("1836810134@qq.com", e.toString(), "异常", null);
			} catch (MessagingException e1) {
				e1.printStackTrace();
			}
		}
	}

}
