package com.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.model.UploadedFile;

public class UploadedFileDao {
	@Autowired
	SessionFactory sessionFactory;
	@Transactional
	public void add(UploadedFile uploadedFile) {
		sessionFactory.getCurrentSession().save(uploadedFile);
	}
	@SuppressWarnings("unchecked")
	@Transactional
	public List<UploadedFile> getallchemistry() {
		String que = "from UploadedFile where subject='chemistry' order by date desc";
		return (List<UploadedFile>) sessionFactory.getCurrentSession().createQuery(que).list();
	}
	@SuppressWarnings("unchecked")
	@Transactional
	public List<UploadedFile> getalldigitalelectronics() {
		String que = "from UploadedFile where subject='digital-electronics' order by date desc";
		return (List<UploadedFile>) sessionFactory.getCurrentSession().createQuery(que).list();
	}
	@SuppressWarnings("unchecked")
	@Transactional
	public List<UploadedFile> getalljava() {
		String que = "from UploadedFile where subject='java' order by date desc";
		return (List<UploadedFile>) sessionFactory.getCurrentSession().createQuery(que).list();
	}
	@SuppressWarnings("unchecked")
	@Transactional
	public List<UploadedFile> getallmicroprocessor() {
		String que = "from UploadedFile where subject='microprocessor' order by date desc";
		return (List<UploadedFile>) sessionFactory.getCurrentSession().createQuery(que).list();
	}
	@SuppressWarnings("unchecked")
	@Transactional
	public List<UploadedFile> getallphysics() {
		String que = "from UploadedFile where subject='physics' order by date desc";
		return (List<UploadedFile>) sessionFactory.getCurrentSession().createQuery(que).list();
	}
	@SuppressWarnings("unchecked")
	@Transactional
	public List<UploadedFile> getallwebdesigning() {
		String que = "from UploadedFile where subject='web-designing' order by date desc";
		return (List<UploadedFile>) sessionFactory.getCurrentSession().createQuery(que).list();
	}
	@SuppressWarnings("unchecked")
	@Transactional
	public List<UploadedFile> getall(int id) {
		String que = "from UploadedFile where staff_id='"+id+"' order by date desc";
		return (List<UploadedFile>) sessionFactory.getCurrentSession().createQuery(que).list();
	}
	@Transactional
	public UploadedFile get(String id) {
		String que = "from UploadedFile where id='"+id+"'";
		return (UploadedFile) sessionFactory.getCurrentSession().createQuery(que).uniqueResult();
	}
	@Transactional
	public void remove(UploadedFile uploadedFile) {
		sessionFactory.getCurrentSession().delete(uploadedFile);
	}
	@SuppressWarnings("unchecked")
	@Transactional
	public List<UploadedFile> getallother() {
		String que = "from UploadedFile where subject='other' order by date desc";
		return (List<UploadedFile>) sessionFactory.getCurrentSession().createQuery(que).list();
	}
}
