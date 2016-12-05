package com.action;


import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

import bean.User;
import com.dao.UserDao;
import com.dao.UserDaoImpl;
import com.opensymphony.xwork2.ActionSupport;

public class ViewAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	private UserDao userDao = new UserDaoImpl();

	public String FormLogin(){
		HttpServletRequest request = ServletActionContext.getRequest();

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User user = new User(username,password);
		user = userDao.UserLogin(user);

		if(user == null){
			System.out.println("failed");
			return "failed";
		}
		return "success";
	}


}
