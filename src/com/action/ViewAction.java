package com.action;


import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

import bean.Employer;
import bean.User;

import com.dao.EmployerDao;
import com.dao.EmployerDaoImpl;
import com.opensymphony.xwork2.ActionSupport;

public class ViewAction extends ActionSupport{
	//private Employer employer;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private EmployerDao employerDao = new EmployerDaoImpl();
	
	public String FormLogin(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		User user = new User(20,username,password);
		
		employer = employerDao.EmployerLogin(employer);
				
		if(employer == null){
			System.out.println("failed");
			return "failed";		
		}
		
		System.out.println("success");
		System.out.println(employer.toString());
				
		return "success";
	}


}