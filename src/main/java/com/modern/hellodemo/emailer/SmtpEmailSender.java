package com.modern.hellodemo.emailer;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

//The object gets created by using @Componenet are referred as beans


public class SmtpEmailSender implements IEmailerService {
	
	// Initilize the logger
	private static Log Log = LogFactory.getLog(SmtpEmailSender.class);
	
	private JavaMailSender javaMailSender;
	
	public SmtpEmailSender(JavaMailSender javaMailSender) {
		// TODO Auto-generated constructor stub
			this.javaMailSender = javaMailSender;
	}

	@Override
	public void sendEmail(String EmailID, String subject, String mailContent) throws MessagingException {
		// TODO Auto-generated method stub

		
			Log.info("SMTP-google Mail receiver ID: " +EmailID);
			Log.info("SMTP-google Mail subject: " +subject);
			Log.info("SMTP-google Mail Body: " +mailContent);
			Log.warn("This is just SMTP email sender");
	

			MimeMessage message = javaMailSender.createMimeMessage();
			MimeMessageHelper helper;

			helper = new MimeMessageHelper(message, true); // true indicates
					  				                   // multipart message
			helper.setSubject("This is first message");
			helper.setTo("gauripawale2804@gmail.com");
			helper.setText("<h1> Body </h1>", true); // true indicates html

			// continue using helper for more functionalities
			// like adding attachments, etc. 
			javaMailSender.send(message);
	
		}
}


