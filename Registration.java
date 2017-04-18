

package dao;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import bean.JobSeeker;

 

public class Registration {


	SendEmail obj=new SendEmail();
	
	
	public boolean connect(String fname,String lname,String password,String email,String telephone,String gender,Date birthday,String location,String qualification,String industry,String skill) {
	
		JobSeeker jbs=new JobSeeker(fname,lname,password, email,telephone,gender, birthday,location,qualification,industry,skill);
		Session session=null;
		SessionFactory factory;
  	
		factory=new Configuration().configure().buildSessionFactory();
		session=factory.openSession();
		Transaction tr=session.beginTransaction();
		session.save(jbs);
		System.out.println("success");
		tr.commit();
		
		obj.sendMailToUser(email);

		return true;
	}
	
	
}
