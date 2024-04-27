package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dao.AnswerDao;
import com.dao.QuestionDao;
import com.dao.StaffDao;
import com.dao.StudentDao;
import com.dao.UploadedFileDao;
import com.dao.UploadedVideoDao;
import com.model.Answer;
import com.model.Question;
import com.model.Staff;
import com.model.Student;
import com.model.UploadedFile;
import com.model.UploadedVideo;

@Controller
public class ContactController {
	@Autowired
	private Student student;
	@Autowired
	private Staff staff;
	@Autowired
	private UploadedFile uploadedFile;
	@Autowired
	private UploadedVideo uploadedVideo;
	@Autowired
	private Question question;
	@Autowired
	private Answer answer;
	@Autowired
	private StudentDao studentdao;
	@Autowired
	private StaffDao staffdao;
	@Autowired
	private UploadedFileDao uploadedfiledao;
	@Autowired
	private UploadedVideoDao uploadedvideodao;
	@Autowired
	private QuestionDao questionDao;
	@Autowired
	private AnswerDao answerDao;
	@Autowired
	HttpSession session;
	
	@RequestMapping(value="contact-action.do")
	public String contactAction(HttpServletRequest request){
		if(session.getAttribute("user")==null){
			return "contact";
		}
		String sessionTime = (String) session.getAttribute("contactTime");
		String requestTime = request.getParameter("time");
		if(sessionTime!=null){
			if(sessionTime.equals(requestTime)){
				session.setAttribute("message", "");
				return "user/contact";
			}
		}
		session.setAttribute("contactTime",requestTime);
		String name = request.getParameter("name");
		String city = request.getParameter("city");
		String email = request.getParameter("email");
		String contact = request.getParameter("contact");
		String message = request.getParameter("message");
		if(name=="" || city=="" || email=="" || contact=="" || message==""){
			session.setAttribute("message", "Please fill all the information!");
			return "user/contact";
		}
		String subject = "E-Learning";
		String admin = "vicky.vishal.pawar@gmail.com";
		try{
//		mailing.sendMail(admin, subject,"<h2><u>E-Learning</u></h2><p>Name: "+name+"</p><p>Contact: "+contact+"</p><p><p>Email: "+email+"</p><p>City: "+city+"</p><hr><p>"+message+"</p><hr>");
//		mailing.sendMail(email, subject, "<h2><u>E-Learning</u></h2><p>Thank you for taking the time to contact E-Learning.</p><hr>");
		}catch(Exception e){
			return "user/contact";
		}
		return "user/successful-contact";
	}
	
	@RequestMapping(value="contact-second-action.do")
	public String contactSecondAction(HttpServletRequest request){
		if(session.getAttribute("user")!=null){
			return "user/contact";
		}
		String sessionTime = (String) session.getAttribute("contactTime");
		String requestTime = request.getParameter("time");
		if(sessionTime!=null){
			if(sessionTime.equals(requestTime)){
				session.setAttribute("message", "");
				return "contact";
			}
		}
		session.setAttribute("contactTime",requestTime);
		String name = request.getParameter("name");
		String city = request.getParameter("city");
		String email = request.getParameter("email");
		String contact = request.getParameter("contact");
		String message = request.getParameter("message");
		if(name=="" || city=="" || email=="" || contact=="" || message==""){
			session.setAttribute("message", "Please fill all the information!");
			return "user/contact";
		}
		String subject = "E-Learning";
		String admin = "vicky.vishal.pawar@gmail.com";
		try{
//		mailing.sendMail(admin, subject,"<h2><u>E-Learning</u></h2><p>Name: "+name+"</p><p>Contact: "+contact+"</p><p><p>Email: "+email+"</p><p>City: "+city+"</p><hr><p>"+message+"</p><hr>");
//		mailing.sendMail(email, subject, "<h2><u>E-Learning</u></h2><p>Thank you for taking the time to contact E-Learning.</p><hr>");
		}catch(Exception e){
			return "contact";
		}
		return "successful-contact";
	}
	
}
