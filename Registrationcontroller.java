package controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import dao.Registration;

public class Registrationcontroller implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		// TODO Auto-generated method stub
		String fname=arg0.getParameter("fname");
		System.out.println("fname:"+fname);
		String lname=arg0.getParameter("lname");
		System.out.println("lname:"+lname);
		String password=arg0.getParameter("password");
		String email=arg0.getParameter("email");
		String telephone=arg0.getParameter("telephone");
		String gender=arg0.getParameter("gender");
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		String dt=arg0.getParameter("birthday");
		Date birthday= formatter.parse(dt);
		
		String location=arg0.getParameter("location");
		String qualification=arg0.getParameter("qualification");
		String industry=arg0.getParameter("industry");
		String skill=arg0.getParameter("skill");
		
		
		Registration reg=new Registration();
		boolean flag= reg.connect(fname, lname, password, email, telephone, gender, birthday, location, qualification, industry, skill);
		
		
		
		return new ModelAndView("login");
	}

}
