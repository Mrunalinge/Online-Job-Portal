package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import bean.Jobs;

public class PostJobLogic {

	
SendEmail obj=new SendEmail();


	
public boolean connect(String designation, double salary, String location,
		String skills, String qualification, String companyname)
{
	//Company comp=new Company(email,password,name,type,location,contact);
	
	Jobs comp=new Jobs(designation, salary, location, skills, qualification, companyname);
	
	Session session=null;
	SessionFactory factory;
	
	factory=new Configuration().configure().buildSessionFactory();
	session=factory.openSession();
	Transaction tr=session.beginTransaction();
	session.save(comp);
	System.out.println("success");
	tr.commit();
	return true;
}
}
