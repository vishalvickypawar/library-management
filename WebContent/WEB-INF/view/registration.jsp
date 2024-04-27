<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Registration</title>
<spring:url value="/resources/css/w3.css" var="w3css"/>
<spring:url value="/resources/images/eLearningLogoTag-sm.png" var="logo"/>
<spring:url value="/resources/icons/font-awesome_4-6-3_user-plus_256_0_000000_none.png" var="icon"/>
<spring:url value="/resources/icons/font-awesome_4-6-3_user_256_50_000000_none.png" var="img1"/>
<spring:url value="/resources/icons/font-awesome_4-6-3_arrow-circle-left_256_0_ffffff_none.png" var="back"/>
<spring:url value="/resources/images/black.jpg" var="black"/>
<spring:url value="/resources/icons/font-awesome-4.6.3/css/font-awesome.min.css" var="facss"/>
<spring:url value="/resources/script/jquery-3.0.0.js" var="jquery"/>
<spring:url value="/resources/script/myscript.js" var="myscript"/>
<link href="${w3css }" rel="stylesheet" type="text/css">
<link href="${facss }" rel="stylesheet" type="text/css">
<link rel="icon" href="${icon }">
<script src="${jquery}"></script>
<script src="${myscript}"></script>
</head>
<%
response.setHeader("Pragma", "no-cache");
response.setHeader("Cache-Control", "no-store");
response.setHeader("Expires", "0");
response.setDateHeader("Expires", -1);
%>


<body class="w3-light-grey">
    <div class="w3-content w3-white w3-card-4" style="min-height:1000px">
        <div id="heading" class="w3-container w3-margin-bottom w3-padding-top">
            <img src="${logo }" width="273px" class="w3-left">
            <div class="w3-container w3-right w3-hide-small">
                <a class="w3-btn w3-light-grey w3-hover-teal w3-margin-top w3-card-2" href="login.do"><i class="fa fa-user"></i> Login</a>
                <a class="w3-btn w3-teal w3-margin-top w3-card-2" href="registration.do"><i class="fa fa-user-plus"></i> Sign Up</a>
            </div>
        </div>
        <div id="menu" style="max-width:inherit">
            <ul id="top" class="w3-navbar w3-light-grey w3-card-2">
                
                <li class="w3-hide-medium w3-hide-large w3-opennav w3-light-grey w3-left">
                    <a title="Menu" id="menu-icon" class="w3-hover-teal" style="height:38px"><i class="fa fa-bars" style="margin-top:5px"></i></a>
                </li>
                <li class="w3-hide-medium w3-hide-large w3-opennav w3-light-grey w3-right">
                    <a title="Sign Up" class="w3-teal" style="height:38px" href="registration.do"><i class="fa fa-user-plus" style="margin-top:5px"></i></a>
                </li>
                <li class="w3-hide-medium w3-hide-large w3-opennav w3-light-grey w3-right">
                    <a title="Login" class="w3-hover-teal" style="height:38px" href="login.do"><i class="fa fa-user" style="margin-top:5px"></i></a>
                </li>
                <li class="w3-hide-medium"><a class="w3-hover-teal" href="home.do"><i class="fa fa-home"></i> Home</a></li>
                <li class="w3-hide-small w3-hide-large"><a class="w3-hover-teal" href="home.do" title="Home" style="height:38px"><i class="fa fa-home" style="margin-top:5px"></i></a></li>
                <li class="w3-hide-small w3-hide-medium"><a class="w3-hover-teal" href="about.do"><i class="fa fa-sticky-note"></i> About Us</a></li>
                <li class="w3-hide-small w3-hide-large"><a class="w3-hover-teal" href="about.do"><i class="fa fa-sticky-note"></i> About</a></li>
                <li class="w3-hide-small"><a class="w3-hover-teal" href="warning-login.do"><i class="fa fa-book"></i> Subjects</a></li>
                <li id="drop-head-1" class="w3-hide-small w3-dropdown-click w3-hover-teal">
                	<a class="w3-hover-teal w3-padding-top w3-padding-bottom w3-padding-tiny" style="height:38px">
                    	<i class="fa fa-angle-double-down" style="margin-top:5px"></i>
                    </a>
                	<div id="drop-content-1" class="w3-dropdown-content w3-light-grey w3-card-2">
      					<a class="w3-hover-teal" href="warning-login.do">Physics</a>
      					<a class="w3-hover-teal" href="warning-login.do">Java</a>
      					<a class="w3-hover-teal" href="warning-login.do">Digital Electronics</a>
                        <a class="w3-hover-teal" href="warning-login.do">Chemistry</a>
                        <a class="w3-hover-teal" href="warning-login.do">Web Designing</a>
                        <a class="w3-hover-teal" href="warning-login.do">Microprocessors</a>
                        <a class="w3-hover-teal" href="warning-login.do">Other</a>
    				</div>
                </li>
                <li class="w3-hide-small"><a class="w3-hover-teal" href="warning-login.do"><i class="fa fa-question-circle"></i> Queries</a></li>
                <li class="w3-hide-small"><a class="w3-hover-teal" href="contact.do"><i class="fa fa-envelope"></i> Contact</a></li>
                <li class="small-buttons w3-hide-small w3-right" style="display:none" title="Sign Up">
                	<a class="w3-teal" href="registration.do" style="height:39px"><i class="fa fa-user-plus" style="margin-top:5px"></i></a>
                </li>
                <li class="small-buttons w3-hide-small w3-right" style="display:none" title="Login">
                	<a class="w3-hover-teal" href="login.do" style="height:39px"><i class="fa fa-user" style="margin-top:5px"></i></a>
                </li>
            </ul>
            <ul id="down-menu" class="w3-navbar w3-light-grey w3-hide-medium w3-hide-large w3-card-2" style="display:none">
                <li><a class="w3-hover-teal" href="about.do"><i class="fa fa-sticky-note"></i> About Us</a></li>
                <li><a class="w3-hover-teal" href="warning-login.do"><i class="fa fa-book"></i> Subjects</a> </li>
                <li><a class="w3-hover-teal" href="warning-login.do"><i class="fa fa-question-circle"></i> Queries</a></li>
                <li><a class="w3-hover-teal" href="contact.do"><i class="fa fa-envelope"></i> Contact</a></li>
            </ul>
        </div>
        
        <div id="extra-bar" style="max-width:inherit; display:none;">
            <ul class="w3-navbar w3-light-grey w3-card-2">
            	<li><a>home</a></li>
            </ul>
        </div>
        
        <div class="w3-row w3-content w3-padding w3-margin-top" style="max-width:700px">
          <div class="w3-container w3-teal w3-center">
          <a href="registration.do" class="w3-left w3-padding-top"><img src="${back }" width="40px"></a>
          <h3>Registration</h3>
        </div>
        </div>
        
        <div class="topic w3-content w3-padding-bottom" style="max-width:700px">
        	<div class="w3-card-4 w3-margin w3-padding-bottom">
            	<div class="w3-container w3-teal"><h2>Registration</h2></div>
        		<div class="w3-row w3-margin-top w3-padding-top">
        			<div class="w3-container w3-center w3-third">
        				<img src="${img1 }" class="w3-circle w3-border" 
                        	style="width:100%; max-width:200px">
        			</div>
        			<form class="w3-twothird" action="registration-student-action.do" method="post" onsubmit="initial();">
                            <p class="w3-text-red w3-center">${message }
                            </p>
				        	<p>
				            <input id="t" class="w3-input w3-border w3-light-grey w3-hover-white" type="hidden" name="time">
				            </p>
                        <div class="w3-container"><label class="w3-label"><b>Name</b></label></div>
                        <div class="w3-row-padding">
                            <div class="w3-half">
                            	<input class="w3-input w3-border w3-light-grey w3-hover-white" type="text" placeholder="Firstname" name="firstname" required autofocus pattern="^[a-zA-Z ]+$" title="Only letters">
                            </div>
                            <div class="w3-half">
                            	<input class="w3-input w3-border w3-light-grey w3-hover-white" type="text" placeholder="Lastname" name="lastname" required pattern="^[a-zA-Z ]+$" title="Only letters">
                            </div>
                        </div>
                        <div class="w3-container">
                            <p>
                                <label class="w3-label"><b>Course</b></label>
                                <select class="w3-select w3-border w3-light-grey w3-hover-white" name="course" required>
                                    <option value="none" selected disabled>Choose your option...</option>
                                    <option value="10+2">10+2</option>
                                    <option value="btechcs">B.Tech(Computer Science)</option>
                                    <option value="btechee">B.Tech(Electrical Engineering)</option>
                                    <option value="btechec">B.Tech(Electronics & Communication)</option>
                                    <option value="btechme">B.Tech(Mechanical)</option>
                                    <option value="btechce">B.Tech(Civil)</option>
                                    <option value="bsc">B.Sc</option>
                                    <option value="bca">BCA</option>
                                </select>
                            </p>
                            <p>
                                <label class="w3-label"><b>Email</b></label>
                                <input class="w3-input w3-border w3-light-grey w3-hover-white" type="email" name="email" required>
                            </p>
                            <p>
                            <p>
                                <label class="w3-label"><b>Contact No.</b></label>
                                <input class="w3-input w3-border w3-light-grey w3-hover-white" type="text" name="contact" required pattern="[0-9]{10}" title="10 digit phone number">
                            </p>
                            <p>
                                <label class="w3-label"><b>Username</b></label>
                                <input class="w3-input w3-border w3-light-grey w3-hover-white" type="text" name="user" required pattern="^[a-zA-Z0-9._]+$" title="Letters digits . and _ ">
                            </p>
                            <p>
                                <label class="w3-label"><b>Password</b></label>
                                <input class="w3-input w3-border w3-light-grey w3-hover-white" type="password" name="pass" required pattern=".{8,}" title="Minimum 8 characters">
                            </p>
                            <p>
                                <label class="w3-label"><b>Confirm Password</b></label>
                                <input class="w3-input w3-border w3-light-grey w3-hover-white" type="password" name="confirmpass" required pattern=".{8,}" title="Minimum 8 characters">
                            </p>
                            <p>
                            	<input type="submit" class="w3-btn w3-teal" value="Submit">
                            </p>
                        </div>
        			</form>
        		</div>
        	</div>
        </div>
          
    
    </div>

</body>

</html>
