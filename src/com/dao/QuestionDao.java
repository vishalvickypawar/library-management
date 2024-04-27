package com.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.model.Question;

public class QuestionDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	public void add(Question question) {
		sessionFactory.getCurrentSession().save(question);
	}
	
	@Transactional
	public Question retrieve(String id) {
		String que = "from Question where id='"+id+"'";
		return (Question) sessionFactory.getCurrentSession().createQuery(que).uniqueResult();
	}
	
	@Transactional
	public void update(Question question) {
		sessionFactory.getCurrentSession().update(question);
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Question> getall() {
		String que = "from Question order by date desc";
		return (List<Question>) sessionFactory.getCurrentSession().createQuery(que).list();
	}

	@Transactional
	public void remove(Question question) {
		sessionFactory.getCurrentSession().delete(question);
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Question> getall(int id) {
		String que = "from Question where student_id='"+id+"' order by date desc";
		return (List<Question>) sessionFactory.getCurrentSession().createQuery(que).list();
	}
	
}
