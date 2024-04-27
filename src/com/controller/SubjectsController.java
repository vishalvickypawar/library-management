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
public class SubjectsController {

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
	
	@RequestMapping(value="upload-file-action.do",method=RequestMethod.POST)
	public String uploadFileAction(@RequestParam CommonsMultipartFile file,HttpSession session,HttpServletRequest request) throws Exception{
		if(session.getAttribute("user")==null){
			return "home";
		}
		String sessionTime = (String) session.getAttribute("uploadFileTime");
		String requestTime = request.getParameter("time");
		if(sessionTime!=null){
			if(sessionTime.equals(requestTime)){
				session.setAttribute("message", "");
				return "user/staff/upload-pdf";
			}
		}
		session.setAttribute("uploadFileTime",requestTime);
		try{
		String ext = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
		if(!ext.equalsIgnoreCase(".pdf"))
		{	session.setAttribute("message", "Wrong file type!");
			return "user/staff/upload-pdf";
		}
		ServletContext context = session.getServletContext();
	    String uploadPath = context.getRealPath("/files");
	    File file1 = new File(uploadPath);
	    if(!file1.exists()){
	    	file1.mkdirs();
	    }
	    Date date = new Date();
	    String strDateFormat = "dd.MM.yy.hh.mm.ss";
	    DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
	    String formattedDate = dateFormat.format(date);
	    
	    strDateFormat = "dd/MM/yyyy";
	    dateFormat = new SimpleDateFormat(strDateFormat);
	    String formattedDate1 = dateFormat.format(date);
	    
	    String title = request.getParameter("title");
	    String description = request.getParameter("description");
	    String subject = request.getParameter("subject");
	    if(title=="" || description=="" || subject==null){
	    	session.setAttribute("message", "Please fill all the information!");
	    	return "user/staff/upload-pdf";
	    }
	    staff = (Staff) session.getAttribute("user");
	    String filename = staff.getUser() + formattedDate + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
	    
	    byte[] bytes = file.getBytes();  
	    BufferedOutputStream stream =new BufferedOutputStream(new FileOutputStream(  
	         new File(uploadPath + File.separator + filename)));  
	    stream.write(bytes);  
	    stream.flush();  
	    stream.close();
	    
	    uploadedFile.setTitle(title);
	    uploadedFile.setDescription(description);
	    uploadedFile.setSubject(subject);
	    uploadedFile.setFilename(filename);
	    uploadedFile.setDate(date);
	    uploadedFile.setFormattedDate(formattedDate1);
	    uploadedFile.setStaff(staff);
	    
	    uploadedfiledao.add(uploadedFile);
	    session.setAttribute("filetype", "pdf");
	    
	    return "user/staff/successful-upload";
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
	
	@RequestMapping(value="upload-video-action.do",method=RequestMethod.POST)
	public String uploadVideoAction(@RequestParam CommonsMultipartFile file,HttpSession session,HttpServletRequest request) throws Exception{
		if(session.getAttribute("user")==null){
			return "home";
		}
		String sessionTime = (String) session.getAttribute("uploadVideoTime");
		String requestTime = request.getParameter("time");
		if(sessionTime!=null){
			if(sessionTime.equals(requestTime)){
				session.setAttribute("message", "");
				return "user/staff/upload-videos";
			}
		}
		session.setAttribute("uploadVideoTime",requestTime);
		try{
		String ext = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
		if(!ext.equalsIgnoreCase(".webm")&&!ext.equalsIgnoreCase(".mp4")&&!ext.equalsIgnoreCase(".wmv"))
		{	session.setAttribute("message", "Wrong file type!");
			return "user/staff/upload-videos";
		}
		ServletContext context = session.getServletContext();
	    String uploadPath = context.getRealPath("/files");
	    File file1 = new File(uploadPath);
	    if(!file1.exists()){
	    	file1.mkdirs();
	    }
	    Date date = new Date();
	    String strDateFormat = "dd.MM.yy.hh.mm.ss";
	    DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
	    String formattedDate = dateFormat.format(date);
	    
	    strDateFormat = "dd/MM/yyyy";
	    dateFormat = new SimpleDateFormat(strDateFormat);
	    String formattedDate1 = dateFormat.format(date);
	    
	    String title = request.getParameter("title");
	    String description = request.getParameter("description");
	    String subject = request.getParameter("subject");
	    if(title=="" || description=="" || subject==null){
	    	session.setAttribute("message", "Please fill all the information!");
	    	return "user/staff/upload-videos";
	    }
	    staff = (Staff) session.getAttribute("user");
	    String filename = staff.getUser() + formattedDate + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
	    
	    byte[] bytes = file.getBytes();  
	    BufferedOutputStream stream =new BufferedOutputStream(new FileOutputStream(  
	         new File(uploadPath + File.separator + filename)));  
	    stream.write(bytes);  
	    stream.flush();  
	    stream.close();
	    
	    uploadedVideo.setTitle(title);
	    uploadedVideo.setDescription(description);
	    uploadedVideo.setSubject(subject);
	    uploadedVideo.setFilename(filename);
	    uploadedVideo.setDate(date);
	    uploadedVideo.setFormattedDate(formattedDate1);
	    uploadedVideo.setStaff(staff);
	    
	    uploadedvideodao.add(uploadedVideo);
	    session.setAttribute("filetype", "video");
	    
	    return "user/staff/successful-upload";
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
	
	@RequestMapping(value="view-pdf.do")
	public String viewPdf(HttpServletRequest request){
		if(session.getAttribute("user")==null){
			return "home";
		}
		String id = request.getParameter("file");
		uploadedFile = uploadedfiledao.get(id);
		if(uploadedFile==null)
		{
			String type = (String) session.getAttribute("type");
			if(type.equals("student")){
				return "user/student/subjects";
			}
			else{
				return "user/staff/subjects";
			}
		}
		session.setAttribute("viewfile",uploadedFile);
		return "user/view-pdf";
	}
	
	@RequestMapping(value="view-video.do")
	public String viewVideo(HttpServletRequest request){
		if(session.getAttribute("user")==null){
			return "home";
		}
		String id = request.getParameter("video");
		uploadedVideo = uploadedvideodao.get(id);
		if(uploadedVideo==null)
		{
			String type = (String) session.getAttribute("type");
			if(type.equals("student")){
				return "user/student/subjects";
			}
			else{
				return "user/staff/subjects";
			}
		}
		session.setAttribute("viewvideo",uploadedVideo);
		return "user/view-video";
	}
	
	@RequestMapping(value="delete-file.do")
	public String deleteFile(HttpServletRequest request){
		if(session.getAttribute("user")==null){
			return "home";
		}
		String sessionTime = (String) session.getAttribute("deleteFileTime");
		String requestTime = request.getParameter("time");
		if(sessionTime!=null){
			if(sessionTime.equals(requestTime)){
				session.setAttribute("message", "");
				return "user/staff/recent-upload-pdf";
			}
		}
		session.setAttribute("deleteFileTime",requestTime);
		String id = request.getParameter("id");
		uploadedFile = uploadedfiledao.get(id);
		File file = new File(session.getServletContext().getRealPath("/files")+File.separator+uploadedFile.getFilename());
		file.delete();
		uploadedfiledao.remove(uploadedFile);
		staff = (Staff) session.getAttribute("user");
		List<UploadedFile> uploadedFiles = uploadedfiledao.getall(staff.getId());
		session.setAttribute("files", uploadedFiles);
		return "user/staff/recent-upload-pdf";
	}
	@RequestMapping(value="delete-video.do")
	public String deleteVideo(HttpServletRequest request){
		if(session.getAttribute("user")==null){
			return "home";
		}
		String sessionTime = (String) session.getAttribute("deleteVideoTime");
		String requestTime = request.getParameter("time");
		if(sessionTime!=null){
			if(sessionTime.equals(requestTime)){
				session.setAttribute("message", "");
				return "user/staff/recent-upload-video";
			}
		}
		session.setAttribute("deleteVideoTime",requestTime);
		String id = request.getParameter("id");
		uploadedVideo = uploadedvideodao.get(id);
		File file = new File(session.getServletContext().getRealPath("/files")+File.separator+uploadedVideo.getFilename());
		file.delete();
		uploadedvideodao.remove(uploadedVideo);
		staff = (Staff) session.getAttribute("user");
		List<UploadedVideo> uploadedVideos = uploadedvideodao.getall(staff.getId());
		session.setAttribute("videos", uploadedVideos);
		return "user/staff/recent-upload-video";
	}
	
	
}
