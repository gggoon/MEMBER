package com.koreait.ex13.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class MailConfig {

	/*
	   보내는 사람의 이메일 등록 
	   1. 구글 메일만 등록함.
	   2. API용 아이디/비번 만들어서 사용.
	   3. 보안 수주이 낮은 앱 허용 체크 필요.
	     https://support.google.com/a/answer/6260879?hl=ko#zippy= : 보안 수준이 낮은 앱 허용
	     https://support.google.com/a/answer/6260879
	*/
	
	@Bean
	public JavaMailSender javaMailSender() {
		
		JavaMailSenderImpl sender = new JavaMailSenderImpl();
		sender.setHost("smtp.gmail.com");
		sender.setPort(587);
		sender.setUsername("dlrkdrns123@gmail.com");   // 내 구글 아이디
		sender.setPassword("Rhdwl123.");               // 내 구글 비밀번호
		
		Properties properties = new Properties();
		properties.put("mail.smtp.auth", true);
		properties.put("mail.smtp.starttls.enable", true);
		sender.setJavaMailProperties(properties);
		
		return sender;
		
	}
}