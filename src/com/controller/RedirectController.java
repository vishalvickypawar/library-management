package com.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dao.AnswerDao;
import com.dao.QuestionDao;
import com.dao.UploadedFileDao;
import com.dao.UploadedVideoDao;
import com.model.Answer;
import com.model.Question;
import com.model.Staff;
import com.model.Student;
import com.model.UploadedFile;
import com.model.UploadedVideo;

@Controller
public class RedirectController {
	@Autowired
	private Student student;
	@Autowired
	private Staff staff;
	@Autowired
	private Question question;
	@Autowired
	private QuestionDao questionDao;
	@Autowired
	private Answer answer;
	@Autowired
	private AnswerDao answerDao;
	@Autowired
	private UploadedFileDao uploadedFileDao;
	@Autowired
	private UploadedVideoDao uploadedVideoDao;
	@Autowired
	HttpSession session;
	@RequestMapping(value="home.do")
	public String home(){
		if(session.getAttribute("user")!=null){
			return "user/home";
		}
		return "home";
	}
	@RequestMapping(value="home-user.do")
	public String homeUser(){
		if(session.getAttribute("user")==null){
			return "home";
		}
		return "user/home";
	}
	@RequestMapping(value="about.do")
	public String about(){
		if(session.getAttribute("user")!=null){
			return "user/about";
		}
		return "about";
	}
	@RequestMapping(value="about-user.do")
	public String aboutUser(){
		if(session.getAttribute("user")==null){
			return "about";
		}
		return "user/about";
	}
	@RequestMapping(value="login.do")
	public String login(){
		if(session.getAttribute("user")!=null){
			return "user/home";
		}
		session.setAttribute("message","");
		session.setAttribute("resubmit-login","false");
		return "login";
	}
	@RequestMapping(value="login-second.do")
	public String loginSecond(){
		if(session.getAttribute("user")!=null){
			return "user/home";
		}
		session.setAttribute("message","");
		session.setAttribute("resubmit-login","false");
		return "login-second";
	}
	@RequestMapping(value="forgot-password.do")
	public String forgotPassword(){
		if(session.getAttribute("user")!=null){
			return "user/home";
		}
		else if(session.getAttribute("username")==null){
			return "login";
		}
		session.setAttribute("message", "");
		return "forgot-password";
	}
	@RequestMapping(value="warning-login.do")
	public String warningLogin(){
		if(session.getAttribute("user")!=null){
			return "user/home";
		}
		return "warning-login";
	}
	@RequestMapping(value="registration.do")
	public String registration(){
		if(session.getAttribute("user")!=null){
			return "user/home";
		}
		session.setAttribute("message","");
		return "registration-option";
	}
	@RequestMapping(value="registration-student.do")
	public String registrationStudent(){
		if(session.getAttribute("user")!=null){
			return "user/home";
		}
		session.setAttribute("message","");
		return "registration-student";
	}
	@RequestMapping(value="registration-staff.do")
	public String registrationStaff(){
		if(session.getAttribute("user")!=null){
			return "user/home";
		}
		session.setAttribute("message","");
		return "registration-staff";
	}
	@RequestMapping(value="profile.do")
	public String profile(){
		if(session.getAttribute("user")==null){
			return "home";
		}
		session.setAttribute("resubmit-profile","false");
		session.setAttribute("message", "");
		if(session.getAttribute("type").equals("student")){
			return "user/student/profile";
		}
		else{
			return "user/staff/profile";
		}
	}
	@RequestMapping(value="avatars.do")
	public String avatars(){
		if(session.getAttribute("user")==null){
			return "home";
		}
		return "user/avatars";
	}
	@RequestMapping(value="change-username.do")
	public String changeUsername(){
		if(session.getAttribute("user")==null){
			return "home";
		}
		session.setAttribute("message","");
		return "user/change-username";
	}
	@RequestMapping(value="change-password.do")
	public String changePassword(){
		if(session.getAttribute("user")==null){
			return "home";
		}
		session.setAttribute("resubmit-chagnepass","false");
		session.setAttribute("message","");
		return "user/change-password";
	}
	@RequestMapping(value="change-info.do")
	public String changeInfo(){
		if(session.getAttribute("user")==null){
			return "home";
		}
		session.setAttribute("resubmit-changeinfo","false");
		if(session.getAttribute("type").equals("student")){
			return "user/student/change-info";
		}
		else{
			return "user/staff/change-info";
		}
	}
	@RequestMapping(value="subjects.do")
	public String subjectsStudent(){
		if(session.getAttribute("user")==null){
			return "home";
		}
		if(session.getAttribute("type").equals("student")){
			return "user/student/subjects";
		}
		else{
			return "user/staff/subjects";
		}
	}
	@RequestMapping(value="subjects-chemistry.do")
	public String subjectsChemistry(){
		if(session.getAttribute("user")==null){
			return "home";
		}
		List<UploadedFile> uploadedFiles = uploadedFileDao.getallchemistry();
		session.setAttribute("files", uploadedFiles);
		session.setAttribute("recent","no");
		return "user/subjects/chemistry";
	}
	@RequestMapping(value="subjects-chemistry-video.do")
	public String subjectsChemistryVideo(){
		if(session.getAttribute("user")==null){
			return "home";
		}
		List<UploadedVideo> uploadedVideos = uploadedVideoDao.getallchemistry();
		session.setAttribute("videos", uploadedVideos);
		session.setAttribute("recent","no");
		return "user/subjects/chemistry-video";
	}
	@RequestMapping(value="subjects-digital-electronics.do")
	public String subjectsDigitalElectronics(){
		if(session.getAttribute("user")==null){
			return "home";
		}
		List<UploadedFile> uploadedFiles = uploadedFileDao.getalldigitalelectronics();
		session.setAttribute("files", uploadedFiles);
		session.setAttribute("recent","no");
		return "user/subjects/digital-electronics";
	}
	@RequestMapping(value="subjects-digital-electronics-video.do")
	public String subjectsDigitalElectronicsVideo(){
		if(session.getAttribute("user")==null){
			return "home";
		}
		List<UploadedVideo> uploadedVideos = uploadedVideoDao.getalldigitalelectronics();
		session.setAttribute("videos", uploadedVideos);
		session.setAttribute("recent","no");
		return "user/subjects/digital-electronics-video";
	}
	@RequestMapping(value="subjects-java.do")
	public String subjectsJava(){
		if(session.getAttribute("user")==null){
			return "home";
		}
		List<UploadedFile> uploadedFiles = uploadedFileDao.getalljava();
		session.setAttribute("files", uploadedFiles);
		session.setAttribute("recent","no");
		return "user/subjects/java";
	}
	@RequestMapping(value="subjects-java-video.do")
	public String subjectsJavaVideo(){
		if(session.getAttribute("user")==null){
			return "home";
		}
		List<UploadedVideo> uploadedVideos = uploadedVideoDao.getalljava();
		session.setAttribute("videos", uploadedVideos);
		session.setAttribute("recent","no");
		return "user/subjects/java-video";
	}
	@RequestMapping(value="subjects-microprocessor.do")
	public String subjectsMicroprocessor(){
		if(session.getAttribute("user")==null){
			return "home";
		}
		List<UploadedFile> uploadedFiles = uploadedFileDao.getallmicroprocessor();
		session.setAttribute("files", uploadedFiles);
		session.setAttribute("recent","no");
		return "user/subjects/microprocessor";
	}
	@RequestMapping(value="subjects-microprocessor-video.do")
	public String subjectsMicroprocessorVideo(){
		if(session.getAttribute("user")==null){
			return "home";
		}
		List<UploadedVideo> uploadedVideos = uploadedVideoDao.getallmicroprocessor();
		session.setAttribute("videos", uploadedVideos);
		session.setAttribute("recent","no");
		return "user/subjects/microprocessor-video";
	}
	@RequestMapping(value="subjects-physics.do")
	public String subjectsPhysics(){
		if(session.getAttribute("user")==null){
			return "home";
		}
		List<UploadedFile> uploadedFiles = uploadedFileDao.getallphysics();
		session.setAttribute("files", uploadedFiles);
		session.setAttribute("recent","no");
		return "user/subjects/physics";
	}
	@RequestMapping(value="subjects-physics-video.do")
	public String subjectsPhysicsVideo(){
		if(session.getAttribute("user")==null){
			return "home";
		}
		List<UploadedVideo> uploadedVideos = uploadedVideoDao.getallphysics();
		session.setAttribute("videos", uploadedVideos);
		session.setAttribute("recent","no");
		return "user/subjects/physics-video";
	}
	@RequestMapping(value="subjects-web-designing.do")
	public String subjectsWebDesigning(){
		if(session.getAttribute("user")==null){
			return "home";
		}
		List<UploadedFile> uploadedFiles = uploadedFileDao.getallwebdesigning();
		session.setAttribute("files", uploadedFiles);
		session.setAttribute("recent","no");
		return "user/subjects/web-designing";
	}
	@RequestMapping(value="subjects-web-designing-video.do")
	public String subjectsWebDesigningVideo(){
		if(session.getAttribute("user")==null){
			return "home";
		}
		List<UploadedVideo> uploadedVideos = uploadedVideoDao.getallwebdesigning();
		session.setAttribute("videos", uploadedVideos);
		session.setAttribute("recent","no");
		return "user/subjects/web-designing-video";
	}
	@RequestMapping(value="subjects-other.do")
	public String subjectsOther(){
		if(session.getAttribute("user")==null){
			return "home";
		}
		List<UploadedFile> uploadedFiles = uploadedFileDao.getallother();
		session.setAttribute("files", uploadedFiles);
		session.setAttribute("recent","no");
		return "user/subjects/other";
	}
	@RequestMapping(value="subjects-other-video.do")
	public String subjectsOtherVideo(){
		if(session.getAttribute("user")==null){
			return "home";
		}
		List<UploadedVideo> uploadedVideos = uploadedVideoDao.getallother();
		session.setAttribute("videos", uploadedVideos);
		session.setAttribute("recent","no");
		return "user/subjects/other-video";
	}
	@RequestMapping(value="upload.do")
	public String upload(){
		if(session.getAttribute("user")==null){
			return "home";
		}
		return "user/staff/upload-option";
	}
	@RequestMapping(value="upload-pdf.do")
	public String uploadPdf(){
		if(session.getAttribute("user")==null){
			return "home";
		}
		session.setAttribute("message", "");
		return "user/staff/upload-pdf";
	}
	@RequestMapping(value="upload-videos.do")
	public String uploadVideos(){
		if(session.getAttribute("user")==null){
			return "home";
		}
		session.setAttribute("resubmit-video","false");
		session.setAttribute("message", "");
		return "user/staff/upload-videos";
	}
	@RequestMapping(value="recent-upload.do")
	public String recentUpload(){
		if(session.getAttribute("user")==null){
			return "home";
		}
		try{
		staff = (Staff) session.getAttribute("user");
		List<UploadedFile> uploadedFiles = uploadedFileDao.getall(staff.getId());
		session.setAttribute("files", uploadedFiles);
		session.setAttribute("recent","yes");
		return "user/staff/recent-upload-pdf";
		}catch(Exception e){
			return "home";
		}
	}
	@RequestMapping(value="recent-upload-video.do")
	public String recentUploadVideo(){
		if(session.getAttribute("user")==null){
			return "home";
		}
		try{
		staff = (Staff) session.getAttribute("user");
		List<UploadedVideo> uploadedVideos = uploadedVideoDao.getall(staff.getId());
		session.setAttribute("videos", uploadedVideos);
		session.setAttribute("recent","yes");
		return "user/staff/recent-upload-video";
		}catch(Exception e){
			return "home";
		}
	}
	@RequestMapping(value="queries.do")
	public String queries(){
		if(session.getAttribute("user")==null){
			return "home";
		}
		List<Question> questions = questionDao.getall();
		session.setAttribute("questions", questions);
		List<Answer> answers = answerDao.getall();
		session.setAttribute("answers", answers);
		
		if(session.getAttribute("type").equals("student")){
			return "user/student/queries";
		}
		else{
			return "user/staff/queries";
		}
	}
	@RequestMapping(value="queries-my.do")
	public String queriesMy(){
		if(session.getAttribute("user")==null){
			return "home";
		}
		
		if(session.getAttribute("type").equals("student")){
			student = (Student) session.getAttribute("user");
			List<Question> questions = questionDao.getall(student.getId());
			session.setAttribute("questions", questions);
			return "user/student/queries-my";
		}
		else{
			staff = (Staff) session.getAttribute("user");
			List<Answer> answers = answerDao.getall(staff.getId());
			session.setAttribute("answers", answers);
			return "user/staff/queries-my";
		}
	}
	@RequestMapping(value="contact.do")
	public String contact(){
		if(session.getAttribute("user")==null){
			session.setAttribute("message", "");
			return "contact";
		}
		session.setAttribute("message", "");
		return "user/contact";
	}
	
	@RequestMapping(value="confirm-delete.do")
	public String confirmDelete(){
		if(session.getAttribute("user")==null){
			return "home";
		}
		return "user/warning-delete";
	}
}
