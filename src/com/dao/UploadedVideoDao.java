package com.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.model.UploadedVideo;

public class UploadedVideoDao {
	@Autowired
	SessionFactory sessionFactory;
	@Transactional
	public void add(UploadedVideo uploadedVideo) {
		sessionFactory.getCurrentSession().save(uploadedVideo);
	}
	@SuppressWarnings("unchecked")
	@Transactional
	public List<UploadedVideo> getallchemistry() {
		String que = "from UploadedVideo where subject='chemistry' order by date desc";
		return (List<UploadedVideo>) sessionFactory.getCurrentSession().createQuery(que).list();
	}
	@SuppressWarnings("unchecked")
	@Transactional
	public List<UploadedVideo> getalldigitalelectronics() {
		String que = "from UploadedVideo where subject='digital-electronics' order by date desc";
		return (List<UploadedVideo>) sessionFactory.getCurrentSession().createQuery(que).list();
	}
	@SuppressWarnings("unchecked")
	@Transactional
	public List<UploadedVideo> getalljava() {
		String que = "from UploadedVideo where subject='java' order by date desc";
		return (List<UploadedVideo>) sessionFactory.getCurrentSession().createQuery(que).list();
	}
	@SuppressWarnings("unchecked")
	@Transactional
	public List<UploadedVideo> getallmicroprocessor() {
		String que = "from UploadedVideo where subject='microprocessor' order by date desc";
		return (List<UploadedVideo>) sessionFactory.getCurrentSession().createQuery(que).list();
	}
	@SuppressWarnings("unchecked")
	@Transactional
	public List<UploadedVideo> getallphysics() {
		String que = "from UploadedVideo where subject='physics' order by date desc";
		return (List<UploadedVideo>) sessionFactory.getCurrentSession().createQuery(que).list();
	}
	@SuppressWarnings("unchecked")
	@Transactional
	public List<UploadedVideo> getallwebdesigning() {
		String que = "from UploadedVideo where subject='web-designing' order by date desc";
		return (List<UploadedVideo>) sessionFactory.getCurrentSession().createQuery(que).list();
	}
	@SuppressWarnings("unchecked")
	@Transactional
	public List<UploadedVideo> getall(int id) {
		String que = "from UploadedVideo where staff_id='"+id+"' order by date desc";
		return (List<UploadedVideo>) sessionFactory.getCurrentSession().createQuery(que).list();
	}
	@Transactional
	public UploadedVideo get(String id) {
		String que = "from UploadedVideo where id='"+id+"'";
		return (UploadedVideo) sessionFactory.getCurrentSession().createQuery(que).uniqueResult();
	}
	@Transactional
	public void remove(UploadedVideo uploadedVideo) {
		sessionFactory.getCurrentSession().delete(uploadedVideo);
	}
	@SuppressWarnings("unchecked")
	@Transactional
	public List<UploadedVideo> getallother() {
		String que = "from UploadedVideo where subject='other' order by date desc";
		return (List<UploadedVideo>) sessionFactory.getCurrentSession().createQuery(que).list();
	}
}
