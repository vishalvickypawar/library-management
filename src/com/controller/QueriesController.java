package com.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
public class QueriesController {
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
	
	@RequestMapping(value="question.do")
	public String question(Question question,HttpServletRequest request){
		if(session.getAttribute("user")==null){
			return "home";
		}
		String sessionTime = (String) session.getAttribute("questionTime");
		String requestTime = request.getParameter("time");
		if(sessionTime!=null){
			if(sessionTime.equals(requestTime)){
				session.setAttribute("message", "");
				List<Question> questions = questionDao.getall();
				session.setAttribute("questions", questions);
				List<Answer> answers = answerDao.getall();
				session.setAttribute("answers", answers);
				return "user/student/queries";
			}
		}
		session.setAttribute("questionTime",requestTime);
		student = (Student) session.getAttribute("user");
		Date date = new Date();
	    String strDateFormat = "dd/MM/yyyy";
	    DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
	    String formattedDate = dateFormat.format(date);
	    question.setDate(date);
	    question.setFormattedDate(formattedDate);
	    question.setReplies(0);
	    question.setStudent(student);
	    questionDao.add(question);
		return "user/student/successful-question";
	}
	
	@RequestMapping(value="answer.do")
	public String answer(Answer answer, HttpServletRequest request){
		if(session.getAttribute("user")==null){
			return "home";
		}
		String sessionTime = (String) session.getAttribute("answerTime");
		String requestTime = request.getParameter("time");
		if(sessionTime!=null){
			if(sessionTime.equals(requestTime)){
				session.setAttribute("message", "");
				List<Question> questions = questionDao.getall();
				session.setAttribute("questions", questions);
				List<Answer> answers = answerDao.getall();
				session.setAttribute("answers", answers);
				return "user/staff/queries";
			}
		}
		session.setAttribute("answerTime",requestTime);
		staff = (Staff) session.getAttribute("user");
		String id = request.getParameter("question-id");
		question = questionDao.retrieve(id);
		question.setReplies(question.getReplies()+1);
		Date date = new Date();
	    String strDateFormat = "dd/MM/yyyy";
	    DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
	    String formattedDate = dateFormat.format(date);
	    answer.setDate(date);
	    answer.setFormattedDate(formattedDate);
	    answer.setStaff(staff);
	    questionDao.update(question);
	    answer.setQuestion(question);
	    answerDao.add(answer);
		return "user/staff/successful-answer";
	}
	
	@RequestMapping(value="delete-question.do")
	public String deleteQuestion(HttpServletRequest request){
		if(session.getAttribute("user")==null){
			return "home";
		}
		String sessionTime = (String) session.getAttribute("deleteQuestionTime");
		String requestTime = request.getParameter("time");
		if(sessionTime!=null){
			if(sessionTime.equals(requestTime)){
				session.setAttribute("message", "");
				student = (Student) session.getAttribute("user");
				List<Question> questions = questionDao.getall(student.getId());
				session.setAttribute("questions", questions);
				return "user/student/queries-my";
			}
		}
		session.setAttribute("deleteQuestionTime",requestTime);
		question = questionDao.retrieve(request.getParameter("question"));
		for(Answer answer: (List<Answer>) answerDao.getall()){
			if(answer.getQuestion().getId()==question.getId()){
				answerDao.remove(answer);
			}
		}
		questionDao.remove(question);
		student = (Student) session.getAttribute("user");
		List<Question> questions = questionDao.getall(student.getId());
		session.setAttribute("questions", questions);
		return "user/student/queries-my";
	}
	
	@RequestMapping(value="delete-answer.do")
	public String deleteAnswer(HttpServletRequest request){
		if(session.getAttribute("user")==null){
			return "home";
		}
		String sessionTime = (String) session.getAttribute("deleteAnswerTime");
		String requestTime = request.getParameter("time");
		if(sessionTime!=null){
			if(sessionTime.equals(requestTime)){
				session.setAttribute("message", "");
				List<Question> questions = questionDao.getall();
				session.setAttribute("questions", questions);
				List<Answer> answers = answerDao.getall(staff.getId());
				session.setAttribute("answers", answers);
				return "user/staff/queries-my";
			}
		}
		session.setAttribute("deleteAnswerTime",requestTime);
		answer = answerDao.retrieve(request.getParameter("answer"));
		question = answer.getQuestion();
		question.setReplies(question.getReplies()-1);
		questionDao.update(question);
		answerDao.remove(answer);
		staff = (Staff) session.getAttribute("user");
		List<Question> questions = questionDao.getall();
		session.setAttribute("questions", questions);
		List<Answer> answers = answerDao.getall(staff.getId());
		session.setAttribute("answers", answers);
		return "user/staff/queries-my";
	}
	
}
