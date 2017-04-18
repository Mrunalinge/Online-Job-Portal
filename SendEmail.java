package dao;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
  
public class SendEmail extends HttpServlet {  
	
	String email=null;
 public static void main(String[] args) {  
  
 }
 
 
 @Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
	// TODO Auto-generated method stub
	super.doGet(req, resp);
}




public void sendMailToUser(String email)
 {
	 
	 
	String to=email;//change accordingly  
	  
	  //Get the session object  
	  Properties props = new Properties();  
	  props.put("mail.smtp.host", "smtp.gmail.com");  
	  props.put("mail.smtp.socketFactory.port", "465");  
	  props.put("mail.smtp.socketFactory.class",  
	            "javax.net.ssl.SSLSocketFactory");  
	  props.put("mail.smtp.auth", "true");  
	  props.put("mail.smtp.port", "465");  
	   
	  Session session = Session.getDefaultInstance(props,  
	   new javax.mail.Authenticator() {  
	   protected PasswordAuthentication getPasswordAuthentication() {  
	   return new PasswordAuthentication("snehal.lokhande17@gmail.com","9881030030");//change accordingly  
	   }  
	  });  
	   
	  //compose message  
	  try {  
	   MimeMessage message = new MimeMessage(session);  
	   message.setFrom(new InternetAddress("snehal.lokhande17@gmail.com"));//change accordingly  
	   message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));  
	   message.setSubject("Hello");  
	//   message.setText("New Job Posted..Please check here : http://localhost:8080/LayoutDemo/jobs.jsp");  
	   message.setText("You hava successfully registered to Career-Hike..");  
		    
	   //send message  
	   Transport.send(message);  
	  
	   System.out.println("message sent successfully");  
	   
	  } catch (MessagingException e) {throw new RuntimeException(e);}  
	   
	}  
  
 
}  