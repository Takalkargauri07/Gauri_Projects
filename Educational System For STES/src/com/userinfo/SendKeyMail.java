package com.userinfo;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendKeyMail {
	

	public static void SendOTP(String email,String otpcode){
		String to = email;
		String subject = "OTP Code";
		String msg = "This is the OTP Code for you \t:"+otpcode;
		final String user = "collegeautomation1@gmail.com";
		final String pass = "College@123";// send mail
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587"); // this is optional
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");

		Session session = Session.getInstance(props,
				new javax.mail.Authenticator() {
					@Override
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(user, pass);
					}
				});

		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(user));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(
					to));
			message.setSubject(subject);
			message.setText(msg);
			
			Transport.send(message);
			System.out.println("sending");
			System.out.println("Send successfully");

		} catch (Exception e) {
			System.out.println(e);
		}
		
		 }  
	public static void main(String[] args) {
		SendOTP("jitusunsofttech@gmail.com","123456");
	}
}
