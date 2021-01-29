package com.modern.hellodemo.controller;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.modern.hellodemo.emailer.IEmailerService;


@RestController
public class EmailServiceController {
	
	//IEmailerService emailService = new DummyEmailSender();
	
	//Don't create any object with specified type, Let Spring cretae it.
	
	//@Autowired     // at instacnce variable
	IEmailerService emailService;
	
	
	// http://localhost:8081/sendemail
	
	public IEmailerService getEmailService() {
		return emailService;
	}

	@Autowired       // at setter method
	public void setEmailService(IEmailerService dummyEmailSender) {
		this.emailService = dummyEmailSender;
	} 
	
	// Autowired Using Constructor
	@Autowired
	public EmailServiceController(IEmailerService smtpEmailSender) {
		this.emailService = smtpEmailSender;
	}

	// http://localhost:8081/sendemail
	@RequestMapping("/sendemail")
	public String email() throws MessagingException {
				
		emailService.sendEmail("stevejobs@apple.com","Launching of new Apple-Mobile Model", "Body of the email");
				
		return "Email Sent"; 
	
	} 


	// http://localhost:8080/sendemail
	@RequestMapping("/draftEmail")
	public String emailDraft() {
				
		return "Email Draft";
	}
	

}