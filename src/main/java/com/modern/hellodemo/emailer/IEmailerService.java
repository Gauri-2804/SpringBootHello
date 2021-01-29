package com.modern.hellodemo.emailer;

import javax.mail.MessagingException;


public interface IEmailerService {
	void sendEmail(String EmailID, String subject, String mailContent) throws MessagingException;
}
