package com.dao;


import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import bean.Employer;

public class EmployerDaoImpl implements EmployerDao{

	private static SessionFactory sessionFactory;
	
	Session s = null;
	Transaction tx = null;
	
/*	private static ThreadLocal session = new ThreadLocal();*/
	
	public EmployerDaoImpl(){
		
	}
	static {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		sessionFactory = cfg.buildSessionFactory();
	}
/*	public static Session getThreadLocalSession(){
		Session s = (Session) session.get();
		if(s==null){
			s = getSession();
			session.set(s);
		}
		return s;
	}*/
	
/*	public void closeSession(){
		Session s = (Session) session.get();
		if(s!=null){
			s.close();
			session.set(null);
		}
	}*/
	
/*	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}*/
	
	public static Session getSession(){
		return sessionFactory.openSession();
	}
	
	public void addEmployer(Employer e){
		try{
			s = EmployerDaoImpl.getSession();
			tx = s.beginTransaction();
			s.save(e);
			tx.commit();
		}finally{
			if(s!=null){
				s.close();
			}
		}
	}
	
	@SuppressWarnings("unchecked")				//登录，返回employer
	public Employer EmployerLogin(Employer e){
		try{
			s = EmployerDaoImpl.getSession();
			tx = s.beginTransaction();					//hql语法
			String hql = "from Employer e where e.Name='"+e.getName()+"' and e.password='"+e.getPassword()+"'";
			Query query = s.createQuery(hql);		
			//query.setString(0,e.getName());
			//query.setString(1,e.getPassword());
			List<Employer> list = query.list();
			
			if(list.size()>0){
				return list.get(0);
			}
		}finally{
			if(s!=null){
				s.close();
			}
		}
		return null;
	}
	
	public Employer Search(Employer e){		//查看个人信息，返回employer,按名字查询
		try{
			s = EmployerDaoImpl.getSession();
			tx = s.beginTransaction();
			String hql = "from Employer e where e.Name='"+e.getName()+"'";
			Query query = s.createQuery(hql);
			
			@SuppressWarnings("unchecked")
			List<Employer> list = query.list();
			if(list.size()>0){
				return list.get(0);
			}
		}finally{
			if(s!=null){
				s.close();
			}
		}
		return null;
	}
	
	
}
