package com.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.model.Student;

public class StudentDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public void add(Student student) {
		sessionFactory.getCurrentSession().save(student);
	}
	
	@Transactional
	public Student retrieve(String user, String pass) {
		String que = "from Student where user='"+user+"' and pass='"+pass+"'";
		return (Student) sessionFactory.getCurrentSession().createQuery(que).uniqueResult();
	}
	
	@Transactional
	public void update(Student student) {
		sessionFactory.getCurrentSession().update(student);
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Student> getall(){
		String que = "from Student";
		return (List<Student>) sessionFactory.getCurrentSession().createQuery(que).list();
	}

	@Transactional
	public void remove(Student student) {
		sessionFactory.getCurrentSession().delete(student);
	}

	@Transactional
	public Student retrieveSecond(String user) {
		String que = "from Student where user='"+user+"'";
		return (Student) sessionFactory.getCurrentSession().createQuery(que).uniqueResult();
	}
}
