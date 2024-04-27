package com.dao;


import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.model.Answer;

public class AnswerDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	public void add(Answer answer) {
		sessionFactory.getCurrentSession().save(answer);
	}

	@Transactional
	public Answer retrieve(String id) {
		String que = "from Answer where id='"+id+"'";
		return (Answer) sessionFactory.getCurrentSession().createQuery(que).uniqueResult();
	}

	@Transactional
	public void remove(Answer answer) {
		sessionFactory.getCurrentSession().delete(answer);
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Answer> getall() {
		String que = "from Answer order by date desc";
		return (List<Answer>) sessionFactory.getCurrentSession().createQuery(que).list();
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Answer> getall(int id) {
		String que = "from Answer where staff_id='"+id+"' order by date desc";
		return (List<Answer>) sessionFactory.getCurrentSession().createQuery(que).list();
	}
	
}
