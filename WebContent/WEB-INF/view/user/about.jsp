<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>About Us</title>
<spring:url value="/resources/css/w3.css" var="w3css"/>
<spring:url value="/resources/images/eLearningLogoTag-sm.png" var="logo"/>
<spring:url value="/resources/icons/font-awesome_4-6-3_sticky-note_256_0_000000_none.png" var="icon"/>
<spring:url value="/resources/images/Boy with laptop computer.jpg" var="img1"/>
<spring:url value="/resources/images/books-and-laptops.jpg" var="img2"/>
<spring:url value="/resources/images/A_woman_hand_mouse.jpg" var="img3"/>
<spring:url value="/resources/icons/font-awesome_4-6-3_user_256_50_000000_none.png" var="img4"/>
<spring:url value="/resources/icons/font-awesome_4-6-3_user_256_50_ffffff_none.png" var="img5"/>
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
                <div class="w3-container w3-right w3-hide-small w3-padding-top">
                	<p class="w3-left w3-padding-right">Welcome ${user.firstname }</p>
                    <div class="w3-padding-top w3-right">
                    	<a href="logout-action.do" title="Log Out" class="w3-card-2 w3-btn-floating w3-light-grey w3-hover-red w3-right w3-margin-left"><i class="fa fa-power-off" style="margin-top:8px;"></i></a>
                    </div>
                    <a href="profile.do">
                    <c:choose>
                    <c:when test="${user.profile == 'nopic'}">
                    	<img title="View Profile" src="${img4 }" class="w3-circle w3-right w3-hover-shadow" style="width:50px" alt="User">
                    </c:when>
                    <c:otherwise>
                    	<img title="View Profile" src="${pageContext.request.contextPath }/images/${user.profile}" class="w3-circle w3-right w3-hover-shadow" style="width:50px; height:50px;" alt="User">
                    </c:otherwise>
                    </c:choose>
                    </a> 
                </div>
        </div>
        <div id="menu" style="max-width:inherit">
            <ul id="top" class="w3-navbar w3-light-grey w3-card-2">
                
                <li class="w3-hide-medium w3-hide-large w3-opennav w3-light-grey w3-left">
                    <a title="Menu" id="menu-icon" class="w3-hover-teal" style="height:38px"><i class="fa fa-bars" style="margin-top:5px"></i></a>
                </li>
                <a href="logout-action.do" title="Log Out" class="w3-hide-medium w3-hide-large w3-btn-floating w3-light-grey w3-hover-red w3-right" style="height:38px; width:38px;"><i class="fa fa-power-off" style="margin-top:8px;"></i></a>
                <a href="profile.do">
                	<li class="w3-white w3-hide-medium w3-hide-large">
                	<c:choose>
                    <c:when test="${user.profile == 'nopic'}">
                    	<img title="View Profile" src="${img5 }" class="w3-right w3-circle w3-hover-shadow" style="height:39px" alt="User">
               		</c:when>
                    <c:otherwise>
                    	<img title="View Profile" src="${pageContext.request.contextPath }/images/${user.profile}" class="w3-right w3-circle w3-hover-shadow" style="width:39px; height:39px" alt="User">
                    </c:otherwise>
                    </c:choose>
               		</li>
                </a>
                <li class="w3-hide-small w3-hide-medium"><a class="w3-hover-teal" href="home-user.do"><i class="fa fa-home"></i> Home</a></li>
                <li class="w3-hide-small w3-hide-large"><a class="w3-hover-teal" href="home-user.do" title="Home" style="height:38px"><i class="fa fa-home" style="margin-top:5px"></i></a></li>
                <li class="w3-hide-medium"><a class="w3-teal" href="about-user.do"><i class="fa fa-sticky-note"></i> About Us</a></li>
                <li class="w3-hide-small w3-hide-large"><a class="w3-teal" href="about-user.do"><i class="fa fa-sticky-note"></i> About</a></li>
                <li class="w3-hide-small"><a class="w3-hover-teal" href="subjects.do"><i class="fa fa-book"></i> Subjects</a></li>
                <li id="drop-head-1" class="w3-hide-small w3-dropdown-click w3-hover-teal">
                	<a class="w3-hover-teal w3-padding-top w3-padding-bottom w3-padding-tiny" style="height:38px">
                    	<i class="fa fa-angle-double-down" style="margin-top:5px"></i>
                    </a>
                	<div id="drop-content-1" class="w3-dropdown-content w3-light-grey w3-card-2">
      					<a class="w3-hover-teal" href="subjects-physics.do">Physics</a>
      					<a class="w3-hover-teal" href="subjects-java.do">Java</a>
      					<a class="w3-hover-teal" href="subjects-digital-electronics.do">Digital Electronics</a>
                        <a class="w3-hover-teal" href="subjects-chemistry.do">Chemistry</a>
                        <a class="w3-hover-teal" href="subjects-web-designing.do">Web Designing</a>
                        <a class="w3-hover-teal" href="subjects-microprocessor.do">Microprocessors</a>
                        <a class="w3-hover-teal" href="subjects-other.do">Other</a>
    				</div>
                </li>
                <li class="w3-hide-small"><a class="w3-hover-teal" href="queries.do"><i class="fa fa-question-circle"></i> Queries</a></li>
                <li class="w3-hide-small"><a class="w3-hover-teal" href="contact.do"><i class="fa fa-envelope"></i> Contact</a></li>
                <a href="logout-action.do" title="Log Out" class="w3-btn-floating w3-light-grey w3-hover-red small-buttons w3-hide-small w3-right" 
                	style="height:39px; width:39px;display:none;">
                    	<i class="fa fa-power-off" style="margin-top:8px;"></i>
                </a>
                <a href="profile.do" class="small-buttons w3-hide-small w3-right" style="display:none">
                    <c:choose>
                    <c:when test="${user.profile == 'nopic'}">
                    	<img title="View Profile" src="${img4}" 
                        class="w3-circle w3-hover-shadow" style="height:39px" alt="User">
                    </c:when>
                    <c:otherwise>
                    	<img title="View Profile" src="${pageContext.request.contextPath }/images/${user.profile}" 
                        class="w3-circle w3-hover-shadow" style="width:39px; height:39px" alt="User">
                    </c:otherwise>
                    </c:choose>
                </a>
            </ul>
            <ul id="down-menu" class="w3-navbar w3-light-grey w3-hide-medium w3-hide-large w3-card-2" style="display:none">
                <li><a class="w3-hover-teal" href="home-user.do"><i class="fa fa-home"></i> Home</a></li>
                <li><a class="w3-hover-teal" href="subjects.do"><i class="fa fa-book"></i> Subjects</a></li>
                <li><a class="w3-hover-teal" href="queries.do"><i class="fa fa-question-circle"></i> Queries</a></li>
                <li><a class="w3-hover-teal" href="contact.do"><i class="fa fa-envelope"></i> Contact</a></li>
            </ul>
        </div>
        
        <div id="extra-bar" style="max-width:inherit; display:none;">
            <ul class="w3-navbar w3-light-grey w3-card-2">
            	<li><a>home</a></li>
            </ul>
        </div>
        <ul class="w3-ul">
                  <li class="w3-padding-16 w3-row-padding w3-margin-right">
                  	<div class="w3-container w3-teal w3-center"><h3><i class="fa fa-home"></i> E-Learning</h3></div>
                    <div class="w3-half w3-margin-top">
                        <img class="w3-card-2" src="${img1 }" style="width:100%">
                        </div>
                        <div class="w3-half">
                            <p>E-learning is another form of distance learning where education and training courses are delivered using computer technology. 											Typically, this means that courses are delivered either via the Internet, or on computer networks (linked computers). With the increased availability of PCs and Internet access, e-learning is becoming more and more popular. As computers and the internet become faster and faster, more and more information is transmitted, received, and stored every day. The basic learning essence of the divine nature is updated in the new internet era. Learning is now much easier for a human and understand things much efficient manner through the internet technology.
                    The E-Learning is a breakthrough fuel towards learning.
                    The learner always wants its desired content available in one roof in complete manner.
                    </p>
                        </div>
                  </li>
                  
                  <li class="w3-padding-16 w3-row-padding w3-margin-right">
                  	<div class="w3-container w3-teal w3-center"><h3><i class="fa fa-book"></i> E-Books</h3></div>
                        <div class="w3-half">
                            <p>E-Books are available in Pdf format on this website. There are lots of useful notes and reading materials available on this website in the Pdf format uploaded by different staff members. These Pdfs or e-books are available for different subjects. Apart from the major subjects, e-books from any other subject can be found in the Other section of the subjects. These e-books are provided by the demand of the students who don't get the correct and useful information on their topics of interest anywhere else on the internet easily and for free. The e-books here are completely free after you register yourself to this website. You can view pdf online or download them. More e-books are uploaded almost every week by the staff members of respective subjects.
                             We hope you'll find these free e-books useful.</p>
                        </div>
                    	<div class="w3-half w3-margin-top">
                        <img class="w3-card-2" src="${img2 }" style="width:100%">
                        </div>
                  </li>
                  
                  <li class="w3-padding-16 w3-row-padding w3-margin-right">
                  	<div class="w3-container w3-teal w3-center"><h3><i class="fa fa-play-circle"></i> Videos</h3></div>
                    <div class="w3-half w3-margin-top">
                        <img class="w3-card-2" src="${img3 }" style="width:100%">
                        </div>
                        <div class="w3-half">
                            <p>Videos are available in webm, mp4 and wmv format on this website. There are lots of useful tutorials and lectures available on this website in the these formats uploaded by different staff members. These videos are available for different subjects. Apart from the major subjects, videos from any other subject can be found in the Other section of the subjects. These videos are provided by the demand of the students who don't get the correct and useful information and tutorials on their topics of interest anywhere else on the internet easily and for free. The videos here are completely free after you register yourself to this website. You can view videos online or download them. More videos are uploaded almost every week by the staff members of respective subjects.
                             We hope you'll find these free videos useful.</p>
                        </div>
                  </li>
                  
                  <li class="w3-padding-16 w3-row-padding w3-margin-right">
                  	<div class="w3-container w3-teal w3-center"><h3><i class="fa fa-question-circle"></i> Queries</h3></div>
                        <div class="w3-half">
                            <p>Our staff members welcome your queries about any topic on any subject. They are willing to give you answers to your queries. You can ask questions about any subject (it can be Physics, Maths, Java or even English etc.) and get answers from any staff members. We ensure that only staff members can answer your questions to guarantee that the answers should be correct and complete. Students get their answers within one week. You have option to delete your question if you posted it wrong. This website offers a complete question answer facility to the regestered student and staff members. We are continuously working on improving the quality of answers and the look of the queries page.
                            We ensure you have free interaction with staff members to get help on any problems related to different subjects.</p>
                        </div>
                    	<div class="w3-half w3-margin-top">
                        <img class="w3-card-2" src="${img1 }" style="width:100%">
                        </div>
                  </li>
                  
                </ul>
        
    </div>

</body>

</html>
