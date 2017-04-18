package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import dao.PostJobLogic;

public class PostJob implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		// TODO Auto-generated method stub
		
		String sal=arg0.getParameter("salary");
	//	int jobid=;
		String designation=arg0.getParameter("designation");
		double salary=Double.parseDouble(sal);
		String location=arg0.getParameter("location");
		String skills=arg0.getParameter("skills");
		String qualification=arg0.getParameter("qualification");
		String companyname=arg0.getParameter("cname");
		
	//	PostJob pj=new PostJob();
		PostJobLogic pj=new PostJobLogic();
		
		pj.connect(designation, salary, location, skills, qualification, companyname);
		
		return new ModelAndView("displayJobs");
	}

}
