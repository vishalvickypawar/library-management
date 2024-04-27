package com.controller;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
public class AccountController {
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
	
	@RequestMapping(value="login-action.do")
	public String loginAction(HttpServletRequest request){
		if(session.getAttribute("user")!=null){
			return "user/home";
		}
		String user = request.getParameter("user");
		String type = request.getParameter("type");
		if(user=="" || type==null){
			session.setAttribute("message", "Please fill all the information!");
			return "login";
		}
		session.setAttribute("message","Username is incorrect!");
		String result = "login";
		if(type.equals("student")){
			result = setStudent(user);
		}
		else if(type.equals("staff")){
			result = setStaff(user);
		}
		session.setAttribute("type", type);
		return result;
	}
	private String setStudent(String user) {
		student = studentdao.retrieveSecond(user);
		if(student==null){
			return "login";
		}
		session.setAttribute("message","");
		session.setAttribute("username", student.getUser());
		session.setAttribute("profilepic", student.getProfile());
		return "login-second";
	}
	private String setStaff(String user) {
		staff = staffdao.retrieveSecond(user);
		if(staff==null){
			return "login";
		}
		session.setAttribute("message","");
		session.setAttribute("username", staff.getUser());
		session.setAttribute("profilepic", staff.getProfile());
		return "login-second";
	}
	
	@RequestMapping(value="login-second-action.do",method=RequestMethod.POST)
	public String loginSecondAction(HttpServletRequest request){
		if(session.getAttribute("user")!=null){
			return "user/home";
		}
		String sessionTime = (String) session.getAttribute("loginTimeSecond");
		String requestTime = request.getParameter("time");
		if(sessionTime!=null){
			if(sessionTime.equals(requestTime)){
				session.setAttribute("message", "");
				session.setAttribute("user", null);
				return "session-expired";
			}
		}
		session.setAttribute("loginTimeSecond",requestTime);
		String user = request.getParameter("user");
		String pass = request.getParameter("pass");
		if(pass==""){
			session.setAttribute("message", "Please fill all the information!");
			return "login-second";
		}
		String type = (String) session.getAttribute("type");
		session.setAttribute("message","Password is incorrect!");
		String result = "login-second";
		if(type.equals("student")){
			student = studentdao.retrieveSecond(user);
			if(student.getPass().equals(pass)){
				session.setAttribute("user", student);
				result = "user/home";
			}
		}
		else if(type.equals("staff")){
			staff = staffdao.retrieveSecond(user);
			if(staff.getPass().equals(pass)){
				session.setAttribute("user", staff);
				result = "user/home";
			}
		}
		return result;
	}
	
	@RequestMapping(value="logout-action.do")
	public String logoutAction(){
		session.setAttribute("message", "");
		session.setAttribute("user", null);
		return "home";
	}
	
	@RequestMapping(value="delete-account.do")
	public String deleteAccount(HttpServletRequest request){
		if(session.getAttribute("user")==null){
			return "home";
		}
		String sessionTime = (String) session.getAttribute("deleteAccountTime");
		String requestTime = request.getParameter("time");
		if(sessionTime!=null){
			if(sessionTime.equals(requestTime)){
				session.setAttribute("message", "");
				return "home";
			}
		}
		session.setAttribute("deleteAccountTime",requestTime);
		String type = (String) session.getAttribute("type");
		if(type.equals("student")){
			student = (Student) session.getAttribute("user");
			String currentProfile = student.getProfile();
			int id = student.getId();
			if(currentProfile.charAt(0)=='p'){
				File file2 = new File(session.getServletContext().getRealPath("/images")+File.separator+student.getProfile());
				file2.delete();
			}
			List<Question> questions = questionDao.getall();
			for(Question question: questions){
				if(question.getStudent().getId()==id){
					List<Answer> answers = answerDao.getall();
					for(Answer answer: answers){
						if(answer.getQuestion().getId()==question.getId()){
							answerDao.remove(answer);
						}
					}
					questionDao.remove(question);
				}
			}
			studentdao.remove(student);
			session.setAttribute("message", "");
			session.setAttribute("user", null);
		}
		else{
			staff = (Staff) session.getAttribute("user");
			String currentProfile = staff.getProfile();
			int id = staff.getId();
			if(currentProfile.charAt(0)=='p'){
				File file2 = new File(session.getServletContext().getRealPath("/images")+File.separator+staff.getProfile());
				file2.delete();
			}
			List<UploadedFile> uploadedFiles = uploadedfiledao.getall(id);
			for(UploadedFile uploadedFile: uploadedFiles){
				if(uploadedFile.getStaff().getId()==id){
					File file = new File(session.getServletContext().getRealPath("/files")+File.separator+uploadedFile.getFilename());
					file.delete();
					uploadedfiledao.remove(uploadedFile);
				}
			}
			List<UploadedVideo> uploadedVideos = uploadedvideodao.getall(id);
			for(UploadedVideo uploadedVideo: uploadedVideos){
				if(uploadedVideo.getStaff().getId()==id){
					File file = new File(session.getServletContext().getRealPath("/files")+File.separator+uploadedVideo.getFilename());
					file.delete();
					uploadedvideodao.remove(uploadedVideo);
				}
			}
			List<Answer> answers = answerDao.getall();
			for(Answer answer: answers){
				if(answer.getStaff().getId()==id){
					List<Question> questions = questionDao.getall();
					for(Question question: questions){
						if(question.getId()==answer.getQuestion().getId()){
							question.setReplies(question.getReplies()-1);
							questionDao.update(question);
						}
					}
					answerDao.remove(answer);
				}
			}
			staffdao.remove(staff);
			session.setAttribute("message", "");
			session.setAttribute("user", null);
		}
		return "successful-delete";
	}
	
	@RequestMapping(value="registration-student-action.do",method=RequestMethod.POST)
	public String registrationStudentAction(Student student, HttpServletRequest request){
		if(session.getAttribute("user")!=null){
			return "user/home";
		}
		String sessionTime = (String) session.getAttribute("registrationStudentTime");
		String requestTime = request.getParameter("time");
		if(sessionTime!=null){
			if(sessionTime.equals(requestTime)){
				session.setAttribute("message", "");
				session.setAttribute("user", null);
				return "registration-student";
			}
		}
		session.setAttribute("registrationStudentTime",requestTime);
		if(request.getParameter("firstname")=="" || request.getParameter("lastname")=="" || request.getParameter("course")==null || request.getParameter("email")=="" || request.getParameter("contact")=="" || request.getParameter("user")=="" || request.getParameter("pass")=="" || request.getParameter("confirmpass")==""){
			session.setAttribute("message", "Please fill all the information!");
			return "registration-student";
		}
		if(!request.getParameter("pass").equals(request.getParameter("confirmpass"))){
			session.setAttribute("message", "The Fields Password and Confirm Password don't match!");
			return "registration-student";
		}
		List<Student> students = studentdao.getall();
		for(Student s: students){
			if(s.getUser().equals(request.getParameter("user"))){
			session.setAttribute("message", "Username already exists!");
			return "registration-student";
			}
		}
		Date date = new Date();
	    String strDateFormat = "ss";
	    DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
	    String formattedDate = dateFormat.format(date);
	    int n = Integer.parseInt(formattedDate)/2 + 1;
	    if(n<10){
	    	student.setProfile("0"+n+".jpg");
	    }
	    else{
	    	student.setProfile(n+".jpg");
	    }
	    student.setResettime("");
		studentdao.add(student);
		return "successful-registration";
	}
	
	@RequestMapping(value="registration-staff-action.do",method=RequestMethod.POST)
	public String registrationStaffAction(Staff staff, HttpServletRequest request){
		if(session.getAttribute("user")!=null){
			return "user/home";
		}
		String sessionTime = (String) session.getAttribute("registrationStaffTime");
		String requestTime = request.getParameter("time");
		if(sessionTime!=null){
			if(sessionTime.equals(requestTime)){
				session.setAttribute("message", "");
				session.setAttribute("user", null);
				return "registration-staff";
			}
		}
		session.setAttribute("registrationStaffTime",requestTime);
		if(request.getParameter("firstname")=="" || request.getParameter("lastname")=="" || request.getParameter("department")==null || request.getParameter("email")=="" || request.getParameter("contact")=="" || request.getParameter("user")=="" || request.getParameter("pass")=="" || request.getParameter("confirmpass")==""){
			session.setAttribute("message", "Please fill all the information!");
			return "registration-staff";
		}
		if(!request.getParameter("pass").equals(request.getParameter("confirmpass"))){
			session.setAttribute("message", "The Fields Password and Confirm Password don't match!");
			return "registration-staff";
		}
		List<Staff> staffs = staffdao.getall();
		for(Staff s: staffs){
			if(s.getUser().equals(request.getParameter("user"))){
			session.setAttribute("message", "Username already exists!");
			return "registration-staff";
			}
		}
		Date date = new Date();
	    String strDateFormat = "ss";
	    DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
	    String formattedDate = dateFormat.format(date);
	    int n = Integer.parseInt(formattedDate)/2 + 1;
	    if(n<10){
	    	staff.setProfile("0"+n+".jpg");
	    }
	    else{
	    	staff.setProfile(n+".jpg");
	    }
	    staff.setResettime("");
		staffdao.add(staff);
		return "successful-registration";
	}
	
}
