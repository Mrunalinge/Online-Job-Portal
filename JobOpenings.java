package dao;
                  
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import bean.Jobs;

public class JobOpenings {

	public static void main(String[] args) {
	
		JobOpenings j=new JobOpenings();
		j.displayJobs();
	}
	
	@SuppressWarnings("unchecked")
	public List<Jobs> displayJobs()
	{
		 
		
		 
		 SessionFactory sessionFactory = new  Configuration().configure().buildSessionFactory();
		 List<Jobs> jobs=null;
		 Jobs job=null;
		Session session = sessionFactory.openSession();
	      Transaction tx = null;
	      try{
	         tx = session.beginTransaction();
	         
	        
	         jobs = session.createQuery("From Jobs").list(); 
	         for (Iterator<Jobs> iterator = jobs.iterator();iterator.hasNext();)
	         {
	            job = iterator.next(); 
	            System.out.print("ID: " + job.getJobid()); 
	            System.out.print("Design:"+job.getDesignation()); 
	            System.out.println("  Salary: " + job.getSalary()); 
	            System.out.println("Company name:"+job.getCompanyname());
	         }
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
		return jobs;
	
	      
		
		
		
		/*Connection conn=null;
		ResultSet rs;
		try{
		Class.forName("com.mysql.jdbc.Driver");

		System.out.println("Driver loaded");
		
		conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/jobportal", "root", "root");
		Statement stmt = conn.createStatement();
		rs = stmt.executeQuery("select * from jobs");
			

		if (rs.next()) 
		{
			String designation=rs.getString(1);
			String salary=rs.getString(2);
			
			String location=rs.getString(3);
			String skills=rs.getString(4);
			
			System.out.println("Designation:"+designation);
			System.out.println("Salary:"+salary);
			System.out.println("location:"+location);
			System.out.println("Skills required:"+skills);
			
			rs.close();
			conn.close();
			System.out.println("Connection done");
		
		} 
		
		} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		System.out.println("class not found");
	}

	catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

*/

	}
}
