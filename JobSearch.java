package dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import bean.Jobs;

public class JobSearch {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public List<Jobs> jobSearchfun(Jobs obj)
	{
		
		 System.out.println("in fun");
		 SessionFactory sessionFactory = new  Configuration().configure().buildSessionFactory();
		 List<Jobs> jobs=null;
		 Jobs job=null;
		Session session = sessionFactory.openSession();
	      Transaction tx = null;
	      try{
	         tx = session.beginTransaction();
	         
	        
	         jobs = (List<Jobs>) session.createQuery("From Jobs j where j.skills="+ obj. getSkills());
	         
	         for (Iterator<Jobs> iterator = jobs.iterator();iterator.hasNext();)
	         {
	        	 System.out.println("in fun");
	            job = iterator.next(); 
	            System.out.println("Company Name:"+job.getCompanyname());
	            System.out.print("ID: " + job.getJobid()); 
	            System.out.print("Design:"+job.getDesignation()); 
	            System.out.println("  Salary: " + job.getSalary()); 
	         }
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
		return (List<Jobs>) job;
	
		
		
		
		
		
		
		
		
		
		
		/*Connection conn;
		System.out.println("Hello");
		Statement stmt=null;
		ResultSet rs;

	//	String skill=request.getParameter("skills");
		try {
			Class.forName("com.mysql.jdbc.Driver");

			System.out.println("Driver loaded");
//			System.out.println(u.getUsername() + "  " + u.getPassword());

			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/jobportal", "root", "root");
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery("select * from jobs where skills="+skills );

			System.out.println("fetch");
			if (rs.next()) {
			
				
				System.out.println("Jobs available:"+rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3));
			}
			}
		catch(Exception e)
		{
			}*/
	}

}
