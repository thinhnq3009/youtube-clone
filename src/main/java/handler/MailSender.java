package handler;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Properties;

import entity.User;
import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.AddressException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

public class MailSender {
	public static Message getMessage(String to) throws AddressException, MessagingException  {

		final String username = "thinhnq3009@gmail.com";
		final String password = "oaivrxqaduxkbiye";

		Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", "587");
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.starttls.enable", "true"); // TLS

		Session session = Session.getInstance(prop, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress(username));
		message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));

		return message;

	}

	public static void sendMailResetPassword(User user, String link) throws Exception{
		Message message = getMessage(user.getEmail());
		
		String html = getContent(user.getId(), link);
		
		
		message.setSubject("Thay đổi mật khẩu cho tài khoản YouTube");
		message.setContent(html,  "text/html; charset=utf-8");
		Transport.send(message);
		
	}
	
	public static String getContent(long name, String link) throws Exception {
		String newLink = String.format("http://localhost:8079/YoutubeClone/EmailContentProvider?id=%s&l=%s", name, link);
		URL url = new URL(newLink);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");

		// Read the response
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuilder response = new StringBuilder();
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		return response.toString();
	}
}
