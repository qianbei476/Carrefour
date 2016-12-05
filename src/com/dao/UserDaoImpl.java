package com.dao;


import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import bean.User;

public class UserDaoImpl implements UserDao{

	private static SessionFactory sessionFactory;

	Session s = null;
	Transaction tx = null;

	public UserDaoImpl(){

	}
	static {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		sessionFactory = cfg.buildSessionFactory();
	}

	public static Session getSession(){
		return sessionFactory.openSession();
	}

	@SuppressWarnings("unchecked")				//登录，返回employer
	public User UserLogin(User user){
		try{
			s = UserDaoImpl.getSession();
			tx = s.beginTransaction();					//hql语法
			String hql = "from User user where user.Name='"+user.getName()+"' and user.password='"+user.getPassword()+"'";
			Query query = s.createQuery(hql);
			//query.setString(0,e.getName());
			//query.setString(1,e.getPassword());
			List<User> list = query.list();

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

	// public void addEmployer(Employer e){
	// 	try{
	// 		s = EmployerDaoImpl.getSession();
	// 		tx = s.beginTransaction();
	// 		s.save(e);
	// 		tx.commit();
	// 	}finally{
	// 		if(s!=null){
	// 			s.close();
	// 		}
	// 	}
	// }



	// public User Search(Employer e){		//查看个人信息，返回employer,按名字查询
	// 	try{
	// 		s = EmployerDaoImpl.getSession();
	// 		tx = s.beginTransaction();
	// 		String hql = "from Employer e where e.Name='"+e.getName()+"'";
	// 		Query query = s.createQuery(hql);
	//
	// 		@SuppressWarnings("unchecked")
	// 		List<Employer> list = query.list();
	// 		if(list.size()>0){
	// 			return list.get(0);
	// 		}
	// 	}finally{
	// 		if(s!=null){
	// 			s.close();
	// 		}
	// 	}
	// 	return null;
	// }


}
