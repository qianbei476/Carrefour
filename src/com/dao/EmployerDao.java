package com.dao;

import bean.Employer;

public interface EmployerDao {
	public Employer EmployerLogin(Employer e);
	
	public void addEmployer(Employer e);

	public Employer Search(Employer e);
}
