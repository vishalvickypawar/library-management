package com.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.model.Staff;

public class StaffDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public void add(Staff staff) {
		sessionFactory.getCurrentSession().save(staff);
	}

	@Transactional
	public Staff retrieve(String user, String pass) {
		String que = "from Staff where user='"+user+"' and pass='"+pass+"'";
		return (Staff) sessionFactory.getCurrentSession().createQuery(que).uniqueResult();
	}
	
	@Transactional
	public void update(Staff staff) {
		sessionFactory.getCurrentSession().update(staff);
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Staff> getall(){
		String que = "from Staff";
		return (List<Staff>) sessionFactory.getCurrentSession().createQuery(que).list();
	}

	@Transactional
	public void remove(Staff staff) {
		sessionFactory.getCurrentSession().delete(staff);
	}

	@Transactional
	public Staff retrieveSecond(String user) {
		String que = "from Staff where user='"+user+"'";
		return (Staff) sessionFactory.getCurrentSession().createQuery(que).uniqueResult();
	}
}
