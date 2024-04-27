package com.controller;

import java.io.File;

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
public class AvatarsController {
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
	

	@RequestMapping(value="avatar1.do")
	public String avatar1(){
		if(session.getAttribute("user")==null){
			return "home";
		}
		String result = "";
		deletePrevious();
		if(session.getAttribute("type").equals("student")){
			Student student = (Student) session.getAttribute("user");
			student.setProfile("01.jpg");
			studentdao.update(student);
			result="user/student/profile";
		}
		else{
			Staff staff = (Staff) session.getAttribute("user");
			staff.setProfile("01.jpg");
			staffdao.update(staff);
			result="user/staff/profile";
		}
		return result;
	}
	@RequestMapping(value="avatar2.do")
	public String avatar2(){
		if(session.getAttribute("user")==null){
			return "home";
		}
		String result = "";
		deletePrevious();
		if(session.getAttribute("type").equals("student")){
			Student student = (Student) session.getAttribute("user");
			student.setProfile("02.jpg");
			studentdao.update(student);
			result="user/student/profile";
		}
		else{
			Staff staff = (Staff) session.getAttribute("user");
			staff.setProfile("02.jpg");
			staffdao.update(staff);
			result="user/staff/profile";
		}
		return result;
	}
	@RequestMapping(value="avatar3.do")
	public String avatar3(){
		if(session.getAttribute("user")==null){
			return "home";
		}
		String result = "";
		deletePrevious();
		if(session.getAttribute("type").equals("student")){
			Student student = (Student) session.getAttribute("user");
			student.setProfile("03.jpg");
			studentdao.update(student);
			result="user/student/profile";
		}
		else{
			Staff staff = (Staff) session.getAttribute("user");
			staff.setProfile("03.jpg");
			staffdao.update(staff);
			result="user/staff/profile";
		}
		return result;
	}
	@RequestMapping(value="avatar4.do")
	public String avatar4(){
		if(session.getAttribute("user")==null){
			return "home";
		}
		String result = "";
		deletePrevious();
		if(session.getAttribute("type").equals("student")){
			Student student = (Student) session.getAttribute("user");
			student.setProfile("04.jpg");
			studentdao.update(student);
			result="user/student/profile";
		}
		else{
			Staff staff = (Staff) session.getAttribute("user");
			staff.setProfile("04.jpg");
			staffdao.update(staff);
			result="user/staff/profile";
		}
		return result;
	}
	@RequestMapping(value="avatar5.do")
	public String avatar5(){
		if(session.getAttribute("user")==null){
			return "home";
		}
		String result = "";
		deletePrevious();
		if(session.getAttribute("type").equals("student")){
			Student student = (Student) session.getAttribute("user");
			student.setProfile("05.jpg");
			studentdao.update(student);
			result="user/student/profile";
		}
		else{
			Staff staff = (Staff) session.getAttribute("user");
			staff.setProfile("05.jpg");
			staffdao.update(staff);
			result="user/staff/profile";
		}
		return result;
	}
	@RequestMapping(value="avatar6.do")
	public String avatar6(){
		if(session.getAttribute("user")==null){
			return "home";
		}
		String result = "";
		deletePrevious();
		if(session.getAttribute("type").equals("student")){
			Student student = (Student) session.getAttribute("user");
			student.setProfile("06.jpg");
			studentdao.update(student);
			result="user/student/profile";
		}
		else{
			Staff staff = (Staff) session.getAttribute("user");
			staff.setProfile("06.jpg");
			staffdao.update(staff);
			result="user/staff/profile";
		}
		return result;
	}
	@RequestMapping(value="avatar7.do")
	public String avatar7(){
		if(session.getAttribute("user")==null){
			return "home";
		}
		String result = "";
		deletePrevious();
		if(session.getAttribute("type").equals("student")){
			Student student = (Student) session.getAttribute("user");
			student.setProfile("07.jpg");
			studentdao.update(student);
			result="user/student/profile";
		}
		else{
			Staff staff = (Staff) session.getAttribute("user");
			staff.setProfile("07.jpg");
			staffdao.update(staff);
			result="user/staff/profile";
		}
		return result;
	}
	@RequestMapping(value="avatar8.do")
	public String avatar8(){
		if(session.getAttribute("user")==null){
			return "home";
		}
		String result = "";
		deletePrevious();
		if(session.getAttribute("type").equals("student")){
			Student student = (Student) session.getAttribute("user");
			student.setProfile("08.jpg");
			studentdao.update(student);
			result="user/student/profile";
		}
		else{
			Staff staff = (Staff) session.getAttribute("user");
			staff.setProfile("08.jpg");
			staffdao.update(staff);
			result="user/staff/profile";
		}
		return result;
	}
	@RequestMapping(value="avatar9.do")
	public String avatar9(){
		if(session.getAttribute("user")==null){
			return "home";
		}
		String result = "";
		deletePrevious();
		if(session.getAttribute("type").equals("student")){
			Student student = (Student) session.getAttribute("user");
			student.setProfile("09.jpg");
			studentdao.update(student);
			result="user/student/profile";
		}
		else{
			Staff staff = (Staff) session.getAttribute("user");
			staff.setProfile("09.jpg");
			staffdao.update(staff);
			result="user/staff/profile";
		}
		return result;
	}
	@RequestMapping(value="avatar10.do")
	public String avatar10(){
		if(session.getAttribute("user")==null){
			return "home";
		}
		String result = "";
		deletePrevious();
		if(session.getAttribute("type").equals("student")){
			Student student = (Student) session.getAttribute("user");
			student.setProfile("10.jpg");
			studentdao.update(student);
			result="user/student/profile";
		}
		else{
			Staff staff = (Staff) session.getAttribute("user");
			staff.setProfile("10.jpg");
			staffdao.update(staff);
			result="user/staff/profile";
		}
		return result;
	}
	@RequestMapping(value="avatar11.do")
	public String avatar11(){
		if(session.getAttribute("user")==null){
			return "home";
		}
		String result = "";
		deletePrevious();
		if(session.getAttribute("type").equals("student")){
			Student student = (Student) session.getAttribute("user");
			student.setProfile("11.jpg");
			studentdao.update(student);
			result="user/student/profile";
		}
		else{
			Staff staff = (Staff) session.getAttribute("user");
			staff.setProfile("11.jpg");
			staffdao.update(staff);
			result="user/staff/profile";
		}
		return result;
	}
	@RequestMapping(value="avatar12.do")
	public String avatar12(){
		if(session.getAttribute("user")==null){
			return "home";
		}
		String result = "";
		deletePrevious();
		if(session.getAttribute("type").equals("student")){
			Student student = (Student) session.getAttribute("user");
			student.setProfile("12.jpg");
			studentdao.update(student);
			result="user/student/profile";
		}
		else{
			Staff staff = (Staff) session.getAttribute("user");
			staff.setProfile("12.jpg");
			staffdao.update(staff);
			result="user/staff/profile";
		}
		return result;
	}
	@RequestMapping(value="avatar13.do")
	public String avatar13(){
		if(session.getAttribute("user")==null){
			return "home";
		}
		String result = "";
		deletePrevious();
		if(session.getAttribute("type").equals("student")){
			Student student = (Student) session.getAttribute("user");
			student.setProfile("13.jpg");
			studentdao.update(student);
			result="user/student/profile";
		}
		else{
			Staff staff = (Staff) session.getAttribute("user");
			staff.setProfile("13.jpg");
			staffdao.update(staff);
			result="user/staff/profile";
		}
		return result;
	}
	@RequestMapping(value="avatar14.do")
	public String avatar14(){
		if(session.getAttribute("user")==null){
			return "home";
		}
		String result = "";
		deletePrevious();
		if(session.getAttribute("type").equals("student")){
			Student student = (Student) session.getAttribute("user");
			student.setProfile("14.jpg");
			studentdao.update(student);
			result="user/student/profile";
		}
		else{
			Staff staff = (Staff) session.getAttribute("user");
			staff.setProfile("14.jpg");
			staffdao.update(staff);
			result="user/staff/profile";
		}
		return result;
	}
	@RequestMapping(value="avatar15.do")
	public String avatar15(){
		if(session.getAttribute("user")==null){
			return "home";
		}
		String result = "";
		deletePrevious();
		if(session.getAttribute("type").equals("student")){
			Student student = (Student) session.getAttribute("user");
			student.setProfile("15.jpg");
			studentdao.update(student);
			result="user/student/profile";
		}
		else{
			Staff staff = (Staff) session.getAttribute("user");
			staff.setProfile("15.jpg");
			staffdao.update(staff);
			result="user/staff/profile";
		}
		return result;
	}
	@RequestMapping(value="avatar16.do")
	public String avatar16(){
		if(session.getAttribute("user")==null){
			return "home";
		}
		String result = "";
		deletePrevious();
		if(session.getAttribute("type").equals("student")){
			Student student = (Student) session.getAttribute("user");
			student.setProfile("16.jpg");
			studentdao.update(student);
			result="user/student/profile";
		}
		else{
			Staff staff = (Staff) session.getAttribute("user");
			staff.setProfile("16.jpg");
			staffdao.update(staff);
			result="user/staff/profile";
		}
		return result;
	}
	@RequestMapping(value="avatar17.do")
	public String avatar17(){
		if(session.getAttribute("user")==null){
			return "home";
		}
		String result = "";
		deletePrevious();
		if(session.getAttribute("type").equals("student")){
			Student student = (Student) session.getAttribute("user");
			student.setProfile("17.jpg");
			studentdao.update(student);
			result="user/student/profile";
		}
		else{
			Staff staff = (Staff) session.getAttribute("user");
			staff.setProfile("17.jpg");
			staffdao.update(staff);
			result="user/staff/profile";
		}
		return result;
	}
	@RequestMapping(value="avatar18.do")
	public String avatar18(){
		if(session.getAttribute("user")==null){
			return "home";
		}
		String result = "";
		deletePrevious();
		if(session.getAttribute("type").equals("student")){
			Student student = (Student) session.getAttribute("user");
			student.setProfile("18.jpg");
			studentdao.update(student);
			result="user/student/profile";
		}
		else{
			Staff staff = (Staff) session.getAttribute("user");
			staff.setProfile("18.jpg");
			staffdao.update(staff);
			result="user/staff/profile";
		}
		return result;
	}
	@RequestMapping(value="avatar19.do")
	public String avatar19(){
		if(session.getAttribute("user")==null){
			return "home";
		}
		String result = "";
		deletePrevious();
		if(session.getAttribute("type").equals("student")){
			Student student = (Student) session.getAttribute("user");
			student.setProfile("19.jpg");
			studentdao.update(student);
			result="user/student/profile";
		}
		else{
			Staff staff = (Staff) session.getAttribute("user");
			staff.setProfile("19.jpg");
			staffdao.update(staff);
			result="user/staff/profile";
		}
		return result;
	}
	@RequestMapping(value="avatar20.do")
	public String avatar20(){
		if(session.getAttribute("user")==null){
			return "home";
		}
		String result = "";
		deletePrevious();
		if(session.getAttribute("type").equals("student")){
			Student student = (Student) session.getAttribute("user");
			student.setProfile("20.jpg");
			studentdao.update(student);
			result="user/student/profile";
		}
		else{
			Staff staff = (Staff) session.getAttribute("user");
			staff.setProfile("20.jpg");
			staffdao.update(staff);
			result="user/staff/profile";
		}
		return result;
	}
	@RequestMapping(value="avatar21.do")
	public String avatar21(){
		if(session.getAttribute("user")==null){
			return "home";
		}
		String result = "";
		deletePrevious();
		if(session.getAttribute("type").equals("student")){
			Student student = (Student) session.getAttribute("user");
			student.setProfile("21.jpg");
			studentdao.update(student);
			result="user/student/profile";
		}
		else{
			Staff staff = (Staff) session.getAttribute("user");
			staff.setProfile("21.jpg");
			staffdao.update(staff);
			result="user/staff/profile";
		}
		return result;
	}
	@RequestMapping(value="avatar22.do")
	public String avatar22(){
		if(session.getAttribute("user")==null){
			return "home";
		}
		String result = "";
		deletePrevious();
		if(session.getAttribute("type").equals("student")){
			Student student = (Student) session.getAttribute("user");
			student.setProfile("22.jpg");
			studentdao.update(student);
			result="user/student/profile";
		}
		else{
			Staff staff = (Staff) session.getAttribute("user");
			staff.setProfile("22.jpg");
			staffdao.update(staff);
			result="user/staff/profile";
		}
		return result;
	}
	@RequestMapping(value="avatar23.do")
	public String avatar23(){
		if(session.getAttribute("user")==null){
			return "home";
		}
		String result = "";
		deletePrevious();
		if(session.getAttribute("type").equals("student")){
			Student student = (Student) session.getAttribute("user");
			student.setProfile("23.jpg");
			studentdao.update(student);
			result="user/student/profile";
		}
		else{
			Staff staff = (Staff) session.getAttribute("user");
			staff.setProfile("23.jpg");
			staffdao.update(staff);
			result="user/staff/profile";
		}
		return result;
	}
	@RequestMapping(value="avatar24.do")
	public String avatar24(){
		if(session.getAttribute("user")==null){
			return "home";
		}
		String result = "";
		deletePrevious();
		if(session.getAttribute("type").equals("student")){
			Student student = (Student) session.getAttribute("user");
			student.setProfile("24.jpg");
			studentdao.update(student);
			result="user/student/profile";
		}
		else{
			Staff staff = (Staff) session.getAttribute("user");
			staff.setProfile("24.jpg");
			staffdao.update(staff);
			result="user/staff/profile";
		}
		return result;
	}
	@RequestMapping(value="avatar25.do")
	public String avatar25(){
		if(session.getAttribute("user")==null){
			return "home";
		}
		String result = "";
		deletePrevious();
		if(session.getAttribute("type").equals("student")){
			Student student = (Student) session.getAttribute("user");
			student.setProfile("25.jpg");
			studentdao.update(student);
			result="user/student/profile";
		}
		else{
			Staff staff = (Staff) session.getAttribute("user");
			staff.setProfile("25.jpg");
			staffdao.update(staff);
			result="user/staff/profile";
		}
		return result;
	}
	@RequestMapping(value="avatar26.do")
	public String avatar26(){
		if(session.getAttribute("user")==null){
			return "home";
		}
		String result = "";
		deletePrevious();
		if(session.getAttribute("type").equals("student")){
			Student student = (Student) session.getAttribute("user");
			student.setProfile("26.jpg");
			studentdao.update(student);
			result="user/student/profile";
		}
		else{
			Staff staff = (Staff) session.getAttribute("user");
			staff.setProfile("26.jpg");
			staffdao.update(staff);
			result="user/staff/profile";
		}
		return result;
	}
	@RequestMapping(value="avatar27.do")
	public String avatar27(){
		if(session.getAttribute("user")==null){
			return "home";
		}
		String result = "";
		deletePrevious();
		if(session.getAttribute("type").equals("student")){
			Student student = (Student) session.getAttribute("user");
			student.setProfile("27.jpg");
			studentdao.update(student);
			result="user/student/profile";
		}
		else{
			Staff staff = (Staff) session.getAttribute("user");
			staff.setProfile("27.jpg");
			staffdao.update(staff);
			result="user/staff/profile";
		}
		return result;
	}
	@RequestMapping(value="avatar28.do")
	public String avatar28(){
		if(session.getAttribute("user")==null){
			return "home";
		}
		String result = "";
		deletePrevious();
		if(session.getAttribute("type").equals("student")){
			Student student = (Student) session.getAttribute("user");
			student.setProfile("28.jpg");
			studentdao.update(student);
			result="user/student/profile";
		}
		else{
			Staff staff = (Staff) session.getAttribute("user");
			staff.setProfile("28.jpg");
			staffdao.update(staff);
			result="user/staff/profile";
		}
		return result;
	}
	@RequestMapping(value="avatar29.do")
	public String avatar29(){
		if(session.getAttribute("user")==null){
			return "home";
		}
		String result = "";
		deletePrevious();
		if(session.getAttribute("type").equals("student")){
			Student student = (Student) session.getAttribute("user");
			student.setProfile("29.jpg");
			studentdao.update(student);
			result="user/student/profile";
		}
		else{
			Staff staff = (Staff) session.getAttribute("user");
			staff.setProfile("29.jpg");
			staffdao.update(staff);
			result="user/staff/profile";
		}
		return result;
	}
	@RequestMapping(value="avatar30.do")
	public String avatar30(){
		if(session.getAttribute("user")==null){
			return "home";
		}
		String result = "";
		deletePrevious();
		if(session.getAttribute("type").equals("student")){
			Student student = (Student) session.getAttribute("user");
			student.setProfile("30.jpg");
			studentdao.update(student);
			result="user/student/profile";
		}
		else{
			Staff staff = (Staff) session.getAttribute("user");
			staff.setProfile("30.jpg");
			staffdao.update(staff);
			result="user/staff/profile";
		}
		return result;
	}
	@RequestMapping(value="avatar31.do")
	public String avatar31(){
		if(session.getAttribute("user")==null){
			return "home";
		}
		String result = "";
		deletePrevious();
		if(session.getAttribute("type").equals("student")){
			Student student = (Student) session.getAttribute("user");
			student.setProfile("31.jpg");
			studentdao.update(student);
			result="user/student/profile";
		}
		else{
			Staff staff = (Staff) session.getAttribute("user");
			staff.setProfile("31.jpg");
			staffdao.update(staff);
			result="user/staff/profile";
		}
		return result;
	}
	@RequestMapping(value="avatar32.do")
	public String avatar32(){
		if(session.getAttribute("user")==null){
			return "home";
		}
		String result = "";
		deletePrevious();
		if(session.getAttribute("type").equals("student")){
			Student student = (Student) session.getAttribute("user");
			student.setProfile("32.jpg");
			studentdao.update(student);
			result="user/student/profile";
		}
		else{
			Staff staff = (Staff) session.getAttribute("user");
			staff.setProfile("32.jpg");
			staffdao.update(staff);
			result="user/staff/profile";
		}
		return result;
	}
	@RequestMapping(value="avatar33.do")
	public String avatar33(){
		if(session.getAttribute("user")==null){
			return "home";
		}
		String result = "";
		deletePrevious();
		if(session.getAttribute("type").equals("student")){
			Student student = (Student) session.getAttribute("user");
			student.setProfile("33.jpg");
			studentdao.update(student);
			result="user/student/profile";
		}
		else{
			Staff staff = (Staff) session.getAttribute("user");
			staff.setProfile("33.jpg");
			staffdao.update(staff);
			result="user/staff/profile";
		}
		return result;
	}
	
	public void deletePrevious(){

		if(session.getAttribute("type").equals("student")){
			Student student = (Student) session.getAttribute("user");
			if(student.getProfile().charAt(0)=='p'){
				File file2 = new File(session.getServletContext().getRealPath("/images")+File.separator+student.getProfile());
				file2.delete();
			}
		}
		else{
			Staff staff = (Staff) session.getAttribute("user");
			if(staff.getProfile().charAt(0)=='p'){
				File file2 = new File(session.getServletContext().getRealPath("/images")+File.separator+staff.getProfile());
				file2.delete();
			}
		}
	}
}
