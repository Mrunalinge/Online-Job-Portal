package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import bean.JobSeeker;
import bean.Login;

import dao.LoginLogic;

public class LoginAction implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		// TODO Auto-generated method stub
		
		String uname=arg0.getParameter("username");
		String upass=arg0.getParameter("password");
		
		System.out.println("Username"+uname);
		System.out.println("Password:"+upass);
		
		//Login cred=new Login(uname, upass);
		JobSeeker cred=new JobSeeker(upass, uname);
		
	
		LoginLogic obj=new LoginLogic();
		boolean result=obj.CheckLogin(cred);
		System.out.println(""+result);
		if(result==true){
			System.out.println("true");
		return new ModelAndView("myprofile");
		}
		else
		{
			System.out.println("false");
			return new ModelAndView("register1");
		}
		
		
	}

	
	
}
