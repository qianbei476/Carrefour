package com.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import bean.Employer;

import com.dao.EmployerDao;
import com.dao.EmployerDaoImpl;
import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;

public class JsonAction extends ActionSupport{

	private static final long serialVersionUID = 1L;

	EmployerDao userDao = new UserDaoImpl();

	@SuppressWarnings("unused")
	private String result;

	public String Search(){

		HttpServletRequest request = ServletActionContext.getRequest();
		String username = request.getParameter("username");
		User user = new User(username);
		user = userDao.Search(user);

		Gson gson = new Gson();
		result = gson.toJson(user);

		return "success";
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

}
