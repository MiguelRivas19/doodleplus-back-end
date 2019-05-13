package fr.istic.master1.doodleplus_back_end;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class MailTest {

	public static void main (String[] args) {
		Properties prop = new Properties();
		prop.put("mail.smtp.auth", false);
		//prop.put("mail.smtp.starttls.enable", "true");
		prop.put("mail.smtp.host", "localhost");
		prop.put("mail.smtp.port", "25");
		//prop.put("mail.smtp.ssl.trust", "smtp.mailtrap.io");
		 
		Session session = Session.getInstance(prop);

		try {
		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress("miguel.rivas.1189@gmail.com"));
		message.setRecipients(
		  Message.RecipientType.TO, InternetAddress.parse("miguel.rivas.1189@gmail.com"));
		message.setSubject("Mail Subject");
		 
		String msg = "This is my first email using JavaMailer";
		 
		MimeBodyPart mimeBodyPart = new MimeBodyPart();
		mimeBodyPart.setContent(msg, "text/html");
		 
		Multipart multipart = new MimeMultipart();
		multipart.addBodyPart(mimeBodyPart);
		 
		message.setContent(multipart);
		Transport.send(message);
		System.out.println("...done!");

		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
