<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Library Management System</title>
<spring:url value="/resources/css/w3.css" var="w3css"/>
<spring:url value="/resources/images/eLearningLogoTag-sm.png" var="logo"/>
<spring:url value="/resources/icons/font-awesome_4-6-3_home_256_0_000000_none.png" var="icon"/>
<spring:url value="/resources/icons/font-awesome_4-6-3_book_256_0_000000_none.png" var="icon1"/>
<spring:url value="/resources/icons/font-awesome_4-6-3_play-circle_256_0_44af8f_none.png" var="icon2"/>
<spring:url value="/resources/icons/font-awesome_4-6-3_question-circle_256_0_000000_none.png" var="icon3"/>
<spring:url value="/resources/images/Boy with laptop computer.jpg" var="img1"/>
<spring:url value="/resources/images/books-and-laptops.jpg" var="img2"/>
<spring:url value="/resources/images/A_woman_hand_mouse.jpg" var="img3"/>
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
    <div class="w3-content w3-white w3-card-4" style="position:relative; z-index:3">
        <div id="heading" class="w3-container w3-margin-bottom w3-padding-top">
            	<img src="${logo }" width="273px" class="w3-left">
                <div class="w3-container w3-right w3-hide-small">
                    <a class="w3-btn w3-light-grey w3-hover-teal w3-margin-top w3-card-2" href="login.do"><i class="fa fa-user"></i> Login</a>
                    <a class="w3-btn w3-light-grey w3-hover-teal w3-margin-top w3-card-2" href="registration.do"><i class="fa fa-user-plus"></i> Sign Up</a>
                </div>
        </div>
        <div id="menu" style="max-width:inherit">
            <ul id="top" class="w3-navbar w3-light-grey w3-card-2">
                
                <li class="w3-hide-medium w3-hide-large w3-opennav w3-light-grey w3-left">
                    <a title="Menu" id="menu-icon" class="w3-hover-teal" style="height:38px"><i class="fa fa-bars" style="margin-top:5px"></i></a>
                </li>
                <li class="w3-hide-medium w3-hide-large w3-opennav w3-light-grey w3-right">
                    <a title="Sign Up" class="w3-hover-teal" style="height:38px" href="registration.do"><i class="fa fa-user-plus" style="margin-top:5px"></i></a>
                </li>
                <li class="w3-hide-medium w3-hide-large w3-opennav w3-light-grey w3-right">
                    <a title="Login" class="w3-hover-teal" style="height:38px" href="login.do"><i class="fa fa-user" style="margin-top:5px"></i></a>
                </li>
                <li class="w3-hide-medium"><a class="w3-teal" href="home.do"><i class="fa fa-home"></i> Home</a></li>
                <li class="w3-hide-small w3-hide-large"><a class="w3-teal" href="home.do" title="Home" style="height:38px"><i class="fa fa-home" style="margin-top:5px"></i></a></li>
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
                	<a class="w3-hover-teal" href="registration.do" style="height:39px"><i class="fa fa-user-plus" style="margin-top:5px"></i></a>
                </li>
                <li class="small-buttons w3-hide-small w3-right" style="display:none" title="Login">
                	<a class="w3-hover-teal" href="login.do" style="height:39px"><i class="fa fa-user" style="margin-top:5px"></i></a>
                </li>
            </ul>
            <ul id="down-menu" class="w3-navbar w3-light-grey w3-hide-medium w3-hide-large w3-card-2" style="display:none">
                <li><a class="w3-hover-teal" href="about.do"><i class="fa fa-sticky-note"></i> About Us</a></li>
                <li><a class="w3-hover-teal" href="warning-login.do"><i class="fa fa-book"></i> Subjects</a></li>
                <li><a class="w3-hover-teal" href="warning-login.do"><i class="fa fa-question-circle"></i> Queries</a></li>
                <li><a class="w3-hover-teal" href="contact.do"><i class="fa fa-envelope"></i> Contact</a></li>
            </ul>
        </div>
        
        <div id="extra-bar" style="max-width:inherit; display:none;">
            <ul class="w3-navbar w3-light-grey w3-card-2">
            	<li><a>home</a></li>
            </ul>
        </div>
            <div class="w3-content w3-card-2" id="slides1" style="z-index:-3; position:absolute; width:100%">
                <img class="mySlides1" src="${img1 }" width="100%">
                <img class="mySlides1" src="${img2 }" width="100%" style="display:none">
                <img class="mySlides1" src="${img3 }" width="100%" style="display:none">
            </div>
            <div class="w3-content w3-card-2" id="slides2" style="z-index:-2; position:absolute; width:100%">
                <img class="mySlides2" src="${img1 }" width="100%">
                <img class="mySlides2" src="${img2 }" width="100%" style="display:none">
                <img class="mySlides2" src="${img3 }" width="100%" style="display:none">
            </div>
            <div class="w3-content w3-card-2" style="z-index:-1; position:absolute; width:100%">
            
            	<div class="w3-display-container w3-text-white">
                  <img src="${black }" style="width:100%; opacity:0.3;">
                  <div class="w3-display-bottommiddle w3-container">
                  <p>
                  	<span class="w3-badge indicator w3-tiny w3-white" style="width:3px">&nbsp;</span>
                    <span class="w3-badge indicator w3-tiny" style="width:3px">&nbsp;</span>
                    <span class="w3-badge indicator w3-tiny" style="width:3px">&nbsp;</span>
				  </p></div>
                  <div class="w3-display-middle middle-text w3-large w3-center w3-padding" style="width:100%">Welcome to E-Learning</div>
                  <div class="w3-display-middle middle-text w3-large w3-center w3-padding" style="width:100%; display:none">View and download free PDFs and Videos from different subjects</div>
                  <div class="w3-display-middle middle-text w3-large w3-center w3-padding" style="width:100%; display:none">Ask Questions from any subjects and get answers from the staff</div>
                </div>
            
                <div class="w3-white w3-card-4 w3-row-padding w3-content w3-center w3-padding-top w3-padding-bottom" style="width:100%;">
            	<a href="about.do">
                <div class="w3-third w3-hover-shadow w3-padding w3-hover-light-grey"><br><br>
                    <img src="${icon1 }" width="50%"><br>
                    <h5>E-Books</h5>
                    <p>View and download free E-Books and notes in PDF format from different subjects.</p><br>
                </div>
                </a>
                <a href="about.do">
            	<div class="w3-third w3-hover-shadow w3-padding w3-hover-light-grey"><br><br>
                    <img src="${icon2 }" width="50%"><br>
                    <h5>Videos</h5>
                    <p>View and download free lecture videos and other videos in PDF format from different subjects.</p><br>
                </div>
                </a>
                <a href="about.do">
            	<div class="w3-third w3-hover-shadow w3-padding w3-hover-light-grey"><br><br>
                    <img src="${icon3 }" width="50%"><br>
                    <h5>Queries</h5>
                    <p>Ask questions from any subject and get answers from staff members.</p><br><br>
                </div>
                </a>
            </div>
            </div>
          
    </div>
</body>

</html>
