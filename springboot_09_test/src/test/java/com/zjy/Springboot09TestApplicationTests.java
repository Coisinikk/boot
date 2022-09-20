package com.zjy;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@SpringBootTest
class Springboot09TestApplicationTests {
    @Autowired
    JavaMailSenderImpl mailSender;
    /*@Test
    void contextLoads() {
        //邮件发送测试
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("邮件通知");
        message.setText("发给臧家瑶的邮件");
        message.setTo("2642497845@qq.com");
        message.setFrom("2642497845@qq.com");
        mailSender.send(message);
    }*/

    @Test
    void contextLoads() throws MessagingException {
        //复杂邮件发送测试
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        //组装
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);
        helper.setSubject("臧家瑶啊");
        helper.setText("<p style='color:red'>臧家瑶啊</p>",true);
        //附件
        helper.addAttachment("local.jpg",new File("E:\\car\\local.jpg"));
        helper.setTo("2642497845@qq.com");
        helper.setFrom("2642497845@qq.com");
        mailSender.send(mimeMessage);
    }

    /**
     *
     * @param
     * @throws MessagingException
     */
    public void sendMail(Boolean html,String subject,String text,String local,String localPath,String user1,String user2) throws MessagingException {
        //复杂邮件发送测试
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        //组装
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,html);
        helper.setSubject(subject);
        helper.setText(text,true);
        //附件
        helper.addAttachment(local,new File(localPath));
        helper.setTo(user1);
        helper.setFrom(user2);
        mailSender.send(mimeMessage);
    }
}
