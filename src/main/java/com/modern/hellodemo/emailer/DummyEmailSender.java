package com.modern.hellodemo.emailer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
//import org.springframework.context.annotation.Primary;
//import org.springframework.stereotype.Component;

//WHen application gets started, Spring checks @Component annotation and if found
//then it create the instance of the class and store it in ApplicationContext.


public class DummyEmailSender implements IEmailerService{
	
	// Initialize the logger
	private static Log Log = LogFactory.getLog(DummyEmailSender.class);

	//@Override
	public void sendEmail(String EmailID, String subject, String mailContent) {
		// TODO Auto-generated method stub
		
		Log.info("Dummy Mail receiver ID: " +EmailID);
		Log.info("Dummy Mail subject: " +subject);
		Log.info("Dummy Mail Body: " +mailContent);
		Log.warn("This is just Dummy email sender");
	
	}

}

