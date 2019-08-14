package com.zhiyou.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailUtil {
	
	public static void setMain(String main,String name){
		//main  收件邮箱地址  
		//name  随机验证码
		
		
		String myEmailAccount = "bzm0531@163.com";
	    String myEmailPassword = "bianziming531";

	    String myEmailSMTPHost = "smtp.163.com";
		  // 1. 创建参数配置, 用于连接邮件服务器的参数配置
        Properties props = new Properties();                    // 参数配置
        props.setProperty("mail.transport.protocol", "smtp");   // 使用的协议（JavaMail规范要求）
        props.setProperty("mail.smtp.host", myEmailSMTPHost);   // 发件人的邮箱的 SMTP 服务器地址
        props.setProperty("mail.smtp.auth", "true");            // 需要请求认证

        final String smtpPort = "465";
        props.setProperty("mail.smtp.port", smtpPort);
        props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.setProperty("mail.smtp.socketFactory.fallback", "false");
        props.setProperty("mail.smtp.socketFactory.port", smtpPort);
        

        // 2. 根据配置创建会话对象, 用于和邮件服务器交互
        Session session = Session.getInstance(props);
//        session.setDebug(true);                                 // 设置为debug模式, 可以查看详细的发送 log

        // 3. 创建一封邮件
        MimeMessage message = createMimeMessage(session, myEmailAccount, main,name);

        // 4. 根据 Session 获取邮件传输对象
        Transport transport;
		try {
			transport = session.getTransport();
		        transport.connect(myEmailAccount, myEmailPassword);

	        // 6. 发送邮件, 发到所有的收件地址, message.getAllRecipients() 获取到的是在创建邮件对象时添加的所有收件人, 抄送人, 密送人
	        transport.sendMessage(message, message.getAllRecipients());

	        // 7. 关闭连接
	        transport.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

       
		
	}
	
	   /**
     * 创建一封只包含文本的简单邮件
     *
     * @param session 和服务器交互的会话
     * @param sendMail 发件人邮箱
     * @param receiveMail 收件人邮箱
     * @return
     * @throws Exception
     */
    public static MimeMessage createMimeMessage(Session session, String sendMail, String receiveMail,String name){
        // 1. 创建一封邮件
        MimeMessage message = new MimeMessage(session);

        // 2. From: 发件人（昵称有广告嫌疑，避免被邮件服务器误认为是滥发广告以至返回失败，请修改昵称）
        try {
			message.setFrom(new InternetAddress("bzm0531@163.com", "智游教育", "UTF-8"));
			 // 3. To: 收件人（可以增加多个收件人、抄送、密送）
	        message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(receiveMail, "智游教育用户", "UTF-8"));

	        // 4. Subject: 邮件主题（标题有广告嫌疑，避免被邮件服务器误认为是滥发广告以至返回失败，请修改标题）
	        message.setSubject("智游教育用户注册验证", "UTF-8");
        } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

       

        // 5. Content: 邮件正文（可以使用html标签）（内容有广告嫌疑，避免被邮件服务器误认为是滥发广告以至返回失败，请修改发送内容）
        Date date =new Date();
		SimpleDateFormat ft = new SimpleDateFormat ("E yyyy.MM.dd  hh:mm:ss a");		 
        String content="您于"+ft.format(date)+"注册智游教育用户，您的验证码为"+name;
        try {
			message.setContent(content, "text/html;charset=UTF-8");
			  // 6. 设置发件时间
	        message.setSentDate(new Date());

	        // 7. 保存设置
	        message.saveChanges();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

      

        return message;
    }

	
	
}
