package com.zc.spider.util;


import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

public class EmailUtils {

	// 发送邮件
	// mail:收件人 mailMsg:邮件内容 subject:邮件标题
	public static void sendMail(String mail, String mailMsg, String subject,
			ArrayList<File> file) throws AddressException, MessagingException {

		// 1.创建session对象，建立java程序到以邮件服务器之间的连接
		Properties pro = new Properties();

		pro.setProperty("mail.transport.protocol", "SMTP");// 设置邮箱服务器协议
		pro.setProperty("mail.host", "smtp.163.com");// 设置发邮件的邮箱服务器地址
		pro.setProperty("mail.smtp.auth", "true");// 验证发件箱的账户名和密码
		// 创建验证器
		Authenticator auth = new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// 第一个参数：账户名 第二个参数：密码 发件人的用户名和密码
				return new PasswordAuthentication("xiaopianzi_heihei@163.com",
						"zc123456");
			}

		};

		// 创建一个程序和邮箱服务器的会话对象Session
		Session session = Session.getInstance(pro, auth);
		// 2创建一个需要发送的邮件对象
		Message message = new MimeMessage(session);// 创建一个message对象，用于设置邮件内容
		message.setFrom(new InternetAddress("xiaopianzi_heihei@163.com"));// 设置发件人
		message.setRecipient(RecipientType.TO, new InternetAddress(mail));// 设置发件方式和接受者
		message.setSubject(subject);// 设置标题

		Multipart mp = new MimeMultipart();
		MimeBodyPart mbpContent = new MimeBodyPart();
		mbpContent.setText(mailMsg,"utf-8");
		mp.addBodyPart(mbpContent);

		/* 往邮件中添加附件 */
		if (file != null) {
			Iterator<File> efile = file.iterator();
			while (efile.hasNext()) {
				MimeBodyPart mbpFile = new MimeBodyPart();
				String fileName = efile.next().toString();
				FileDataSource fds = new FileDataSource(fileName);
				mbpFile.setDataHandler(new DataHandler(fds));
				try {
					mbpFile.setFileName(MimeUtility.encodeWord(fds.getName()));
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				mp.addBodyPart(mbpFile);
			}
			System.out.println("添加成功");
		}

		message.setContent(mp);
		message.setSentDate(new Date());
		// 3.执行发送
		Transport.send(message);

	}
	
	


}
