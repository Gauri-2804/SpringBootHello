package com.modern.hellodemo.emailer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.mail.javamail.JavaMailSender;


/* This class will be use to configure beans of 
 * DummyEmailSender.java and SmtpEmailSender.java as we may don't have source of these class 
 * but we want to use them as a spring bean
 */

@Configuration
public class MailConfig {
	//IEmailerService emailService = new DummyEmailSender();
	
	@Bean
	@Profile("dev")
	public IEmailerService dummyEmailSender() {
		return new DummyEmailSender();
	}
	
	@Bean
	@Profile("prod")
	//@Primary
	public IEmailerService smtpEmailSender(JavaMailSender javaMailSender) {
		return new SmtpEmailSender(javaMailSender);
	}
}
	

