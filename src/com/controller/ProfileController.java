package com.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

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
public class ProfileController {
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
	
	@RequestMapping(value="change-username-action.do")
	public String changeUsernameAction(HttpServletRequest request){
		if(session.getAttribute("user")==null){
			return "home";
		}
		String sessionTime = (String) session.getAttribute("changeUsernameTime");
		String requestTime = request.getParameter("time");
		if(sessionTime!=null){
			if(sessionTime.equals(requestTime)){
				session.setAttribute("message", "");
				String type = (String) session.getAttribute("type");
			    if(type.equals("student")){
			    	return "user/student/profile";
			    }
			    else{
			    	return "user/staff/profile";
			    }
			}
		}
		session.setAttribute("changeUsernameTime",requestTime);
		String newuser = request.getParameter("newuser");
		if(newuser==""){
			session.setAttribute("message", "Please fill all the information!");
			return "user/change-username";
		}
		String type = (String) session.getAttribute("type");
		String result = "";
		if(type.equals("student")){
			List<Student> students = studentdao.getall();
			for(Student s: students){
				if(s.getUser().equals(newuser)){
				session.setAttribute("message", "Username already exists!");
				return "user/change-username";
				}
			}
			session.setAttribute("message","");
			student = (Student) session.getAttribute("user");
			student.setUser(newuser);
			studentdao.update(student);
			result = "user/student/profile";
		}
		else{
			List<Staff> staffs = staffdao.getall();
			for(Staff s: staffs){
				if(s.getUser().equals(newuser)){
				session.setAttribute("message", "Username already exists!");
				return "user/change-username";
				}
			}
			session.setAttribute("message","");
			staff = (Staff) session.getAttribute("user");
			staff.setUser(newuser);
			staffdao.update(staff);
			result = "user/staff/profile";
		}
		return result;
	}
	
	@RequestMapping(value="change-password-action.do",method=RequestMethod.POST)
	public String changePasswordAction(HttpServletRequest request){
		if(session.getAttribute("user")==null){
			return "session-expired";
		}
		String sessionTime = (String) session.getAttribute("changePasswordTime");
		String requestTime = request.getParameter("time");
		if(sessionTime!=null){
			if(sessionTime.equals(requestTime)){
				session.setAttribute("message", "");
				String type = (String) session.getAttribute("type");
			    if(type.equals("student")){
			    	return "user/student/profile";
			    }
			    else{
			    	return "user/staff/profile";
			    }
			}
		}
		session.setAttribute("changePasswordTime",requestTime);
		try{
		String type = (String) session.getAttribute("type");
		String curpass = request.getParameter("curpass");
		String newpass = request.getParameter("newpass");
		String newpassconfirm = request.getParameter("newpassconfirm");
		if(curpass=="" || newpass=="" || newpassconfirm==""){
			session.setAttribute("message", "Please fill all the information!");
			return "user/change-password";
		}
		session.setAttribute("message","Passwords don't match!");
		String result = "user/change-password";
		if(type.equals("student")){
			student = (Student) session.getAttribute("user");
			if(student.getPass().equals(curpass) && newpass.equals(newpassconfirm)){
				student.setPass(newpass);
				studentdao.update(student);
				result="user/successful-password";
			}
		}
		else if(type.equals("staff")){
			staff = (Staff) session.getAttribute("user");
			if(staff.getPass().equals(curpass) && newpass.equals(newpassconfirm)){
				staff.setPass(newpass);
				staffdao.update(staff);
				result="user/successful-password";
			}
		}
		return result;
		}catch(Exception e){
			return "home";
		}
	}
	
	@RequestMapping(value="change-info-action.do")
	public String changeInfoAction(HttpServletRequest request){
		if(session.getAttribute("user")==null){
			return "home";
		}
		String sessionTime = (String) session.getAttribute("changeInfoTime");
		String requestTime = request.getParameter("time");
		if(sessionTime!=null){
			if(sessionTime.equals(requestTime)){
				session.setAttribute("message", "");
				String type = (String) session.getAttribute("type");
			    if(type.equals("student")){
			    	return "user/student/profile";
			    }
			    else{
			    	return "user/staff/profile";
			    }
			}
		}
		session.setAttribute("changeInfoTime",requestTime);
		try{
		String type = (String) session.getAttribute("type");
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String email = request.getParameter("email");
		String contact = request.getParameter("contact");
		String result = "user/student/profile";
		if(type.equals("student")){
			String course = request.getParameter("course");
			System.out.println(course);
			student = (Student) session.getAttribute("user");
			if(firstname!="")student.setFirstname(firstname);
			if(lastname!="")student.setLastname(lastname);
			if(course!=null)student.setCourse(course);
			if(email!="")student.setEmail(email);
			if(contact!="")student.setContact(contact);
			studentdao.update(student);
			result = "user/student/profile";
		}
		else if(type.equals("staff")){
			String department = request.getParameter("department");
			staff = (Staff) session.getAttribute("user");
			if(firstname!="")staff.setFirstname(firstname);
			if(lastname!="")staff.setLastname(lastname);
			if(department!=null)staff.setDepartment(department);
			if(email!="")staff.setEmail(email);
			if(contact!="")staff.setContact(contact);
			staffdao.update(staff);
			result = "user/staff/profile";;
		}
		return result;
		}catch(Exception e){
			return "home";
		}
	}
	
	@RequestMapping(value="send-reset-link.do")
	public String sendResetLink(HttpServletRequest request){
		if(session.getAttribute("user")!=null){
			return "user/home";
		}
		String sessionTime = (String) session.getAttribute("resetLinkTime");
		String requestTime = request.getParameter("time");
		if(sessionTime!=null){
			if(sessionTime.equals(requestTime)){
				session.setAttribute("message", "");
				session.setAttribute("user", null);
				return "forgot-password";
			}
		}
		session.setAttribute("resetLinkTime",requestTime);
		if(session.getAttribute("username")==null){
			return "login";
		}
		String user = (String) session.getAttribute("username");
		String type = (String) session.getAttribute("type");
		if(type.equals("student")){
			student = studentdao.retrieveSecond(user);
			String email = student.getEmail();
			String inputEmail = request.getParameter("email");
			if(!email.equals(inputEmail)){
				session.setAttribute("message", "Wrong email address!");
				return "forgot-password";
			}
			student.setResettime(requestTime);
			String link ="http://localhost:8080/E-Learning/reset-password.do?time="+requestTime+"&user="+user+"&type=student";
			String subject = "E-Learning";
			try{
//			mailing.sendMail(email, subject, "<h2><u>E-Learning</u></h2><p><a href='"+link+"'>Click here</a> to reset you password. (The link will be expired in 1 minute.)</p><hr>");
			}catch(Exception e){
				return "forgot-password";
			}
			studentdao.update(student);
		}
		else{
			staff = staffdao.retrieveSecond(user);
			String email = staff.getEmail();
			String inputEmail = request.getParameter("email");
			if(!email.equals(inputEmail)){
				session.setAttribute("message", "Wrong email address!");
				return "forgot-password";
			}
			staff.setResettime(requestTime);
			String link ="http://localhost:8080/E-Learning/reset-password.do?time="+requestTime+"&user="+user+"&type=student";
			String subject = "E-Learning";
			try{
//			mailing.sendMail(email, subject, "<h2><u>E-Learning</u></h2><p><a href='"+link+"'>Click here</a> to reset you password. (The link will be expired in 1 minute.)</p><hr>");
			}catch(Exception e){
				return "forgot-password";
			}
			staffdao.update(staff);
		}
		return "successful-reset-link";
	}
	
	@RequestMapping(value="reset-password.do")
	public String resetPasswordk(HttpServletRequest request){
		try{
		String requestTime = (String) request.getParameter("time");
		Date d = new Date();
		long longCurrentTime = d.getTime();
		String user = (String) request.getParameter("user");
		String type = (String) request.getParameter("type");
		if(type.equals("student")){
			student = studentdao.retrieveSecond(user);
			String resetTime = student.getResettime();
			long longResetTime = Long.parseLong(resetTime);
			if(resetTime=="" || requestTime==""){
				return "warning-link-expired";
			}
			if(!requestTime.equals(resetTime) || (longResetTime+60000)<longCurrentTime){
				student.setResettime("");
				studentdao.update(student);
				return "warning-link-expired";
			}
			studentdao.update(student);
			session.setAttribute("type", "student");
			session.setAttribute("username", user);
		}
		else{
			staff = staffdao.retrieveSecond(user);
			String resetTime = staff.getResettime();
			long longResetTime = Long.parseLong(resetTime);
			if(resetTime=="" || requestTime==""){
				return "warning-link-expired";
			}
			if(!requestTime.equals(resetTime) || (longResetTime+60000)<longCurrentTime){
				staff.setResettime("");
				staffdao.update(staff);
				return "warning-link-expired";
			}
			staffdao.update(staff);
			session.setAttribute("type", "staff");
			session.setAttribute("username", user);
		}
		}catch(Exception e){
			return "warning-link-expired";
		}
		return "reset-password";
	}
	
	@RequestMapping(value="reset-password-action.do",method=RequestMethod.POST)
	public String resetPasswordAction(HttpServletRequest request){
		if(session.getAttribute("username")==null){
			return "login";
		}
		String sessionTime = (String) session.getAttribute("resetPasswordTime");
		String requestTime = request.getParameter("time");
		if(sessionTime!=null){
			if(sessionTime.equals(requestTime)){
				session.setAttribute("message", "");
				String type = (String) session.getAttribute("type");
			    if(type.equals("student")){
			    	return "login";
			    }
			    else{
			    	return "login";
			    }
			}
		}
		session.setAttribute("resetPasswordTime",requestTime);
		try{
		String type = (String) session.getAttribute("type");
		String newpass = request.getParameter("newpass");
		String newpassconfirm = request.getParameter("newpassconfirm");
		if(newpass=="" || newpassconfirm==""){
			session.setAttribute("message", "Please fill all the information!");
			return "reset-password";
		}
		session.setAttribute("message","Passwords don't match!");
		if(type.equals("student")){
			String username = (String) session.getAttribute("username");
			student = studentdao.retrieveSecond(username);
			if(newpass.equals(newpassconfirm)){
				student.setPass(newpass);
				student.setResettime("");
				studentdao.update(student);
				session.setAttribute("message", "");
			}
			else{
				return "reset-password";
			}
		}
		else if(type.equals("staff")){
			String username = (String) session.getAttribute("username");
			staff = staffdao.retrieveSecond(username);
			if(newpass.equals(newpassconfirm)){
				staff.setPass(newpass);
				staff.setResettime("");
				staffdao.update(staff);
				session.setAttribute("message", "");
			}
			else{
				return "reset-password";
			}
		}
		return "successful-password";
		}catch(Exception e){
			return "home";
		}
	}
	
	@RequestMapping(value="profile-remove.do")
	public String profileRemove(HttpServletRequest request){
		if(session.getAttribute("user")==null){
			return "home";
		}
		String sessionTime = (String) session.getAttribute("profileRemoveTime");
		String requestTime = request.getParameter("time");
		if(sessionTime!=null){
			if(sessionTime.equals(requestTime)){
				session.setAttribute("message", "");
				String type = (String) session.getAttribute("type");
			    if(type.equals("student")){
			    	return "user/student/profile";
			    }
			    else{
			    	return "user/staff/profile";
			    }
			}
		}
		session.setAttribute("profileRemoveTime",requestTime);
		try{
		String result = "";
		String type = (String) session.getAttribute("type");
	    if(type.equals("student")){
	    	student = (Student) session.getAttribute("user");
			String currentProfile = student.getProfile();
			if(currentProfile.charAt(0)=='p'){
				File file2 = new File(session.getServletContext().getRealPath("/images")+File.separator+student.getProfile());
				file2.delete();
			}
			student.setProfile("nopic");
			studentdao.update(student);
			result = "user/student/profile";
		}
		else if(type.equals("staff")){
			staff = (Staff) session.getAttribute("user");
			String currentProfile = staff.getProfile();
			if(currentProfile.charAt(0)=='p'){
				File file2 = new File(session.getServletContext().getRealPath("/images")+File.separator+staff.getProfile());
				file2.delete();
			}
			staff.setProfile("nopic");
			staffdao.update(staff);
			result = "user/staff/profile";
		}
	    return result;
		}catch(Exception e){
			return "home";
		}
	}
	
	@RequestMapping(value="profile-picture.do",method=RequestMethod.POST)  
    public String saveimage( @RequestParam CommonsMultipartFile file,HttpSession session,HttpServletRequest request) throws Exception{
		if(session.getAttribute("user")==null){
			return "home";
		}
		String sessionTime = (String) session.getAttribute("profilePictureTime");
		String requestTime = request.getParameter("time");
		if(sessionTime!=null){
			if(sessionTime.equals(requestTime)){
				session.setAttribute("message", "");
				String type = (String) session.getAttribute("type");
				if(type.equals("student")){
					return "user/student/profile";
				}
				else{
					return "user/staff/profile";
				}
			}
		}
		session.setAttribute("profilePictureTime",requestTime);
		try{
		String ext = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
		if(!ext.equalsIgnoreCase(".jpg")&&!ext.equalsIgnoreCase(".jpeg")&&!ext.equalsIgnoreCase(".png")&&!ext.equalsIgnoreCase(".bmp")&&!ext.equalsIgnoreCase(".tiff")&&!ext.equalsIgnoreCase(".gif"))
		{	session.setAttribute("message", "Wrong file type!");
			String type = (String) session.getAttribute("type");
			if(type.equals("student")){
				return "user/student/profile";
			}
			else{
				return "user/staff/profile";
			}
		}
		ServletContext context = session.getServletContext();  
  
	    String uploadPath = context.getRealPath("/images");
	    File file1 = new File(uploadPath);
	    if(!file1.exists()){
	    	file1.mkdirs();
	    }
	    Date date = new Date();
	    String strDateFormat = "dd.MM.yy.hh.mm.ss";
	    DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
	    String formattedDate = dateFormat.format(date);
	    
	    String name = "";
	    String type = (String) session.getAttribute("type");
	    if(type.equals("student")){
			student = (Student) session.getAttribute("user");
			String currentProfile = student.getProfile();
			if(currentProfile.charAt(0)=='p'){
				File file2 = new File(uploadPath+File.separator+student.getProfile());
				file2.delete();
			}
			name = "p" + student.getUser() + formattedDate + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
			student.setProfile(name);
			studentdao.update(student);
		}
		else if(type.equals("staff")){
			staff = (Staff) session.getAttribute("user");
			String currentProfile = staff.getProfile();
			if(currentProfile.charAt(0)=='p'){
				File file2 = new File(uploadPath+File.separator+staff.getProfile());
				file2.delete();
			}
			name = "p" + staff.getUser() + formattedDate + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
			staff.setProfile(name);
			staffdao.update(staff);
		}
	    
	    byte[] bytes = file.getBytes();  
	    BufferedOutputStream stream =new BufferedOutputStream(new FileOutputStream(  
	         new File(uploadPath + File.separator + name)));  
	    stream.write(bytes);  
	    stream.flush();  
	    stream.close();  

		String result = "user/student/profile";
		if(type.equals("student")){
			result = "user/student/profile";
		}
		else if(type.equals("staff")){
			result = "user/staff/profile";
		}
	    return result;
		}catch(Exception e){
			session.setAttribute("message", "Wrong file type!");
			String type = (String) session.getAttribute("type");
			if(type.equals("student")){
				return "user/student/profile";
			}
			else{
				return "user/staff/profile";
			}
		}  
    }
	
}
