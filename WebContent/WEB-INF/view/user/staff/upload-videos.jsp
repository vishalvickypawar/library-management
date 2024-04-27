<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Upload</title>
<spring:url value="/resources/css/w3.css" var="w3css"/>
<spring:url value="/resources/images/eLearningLogoTag-sm.png" var="logo"/>
<spring:url value="/resources/icons/font-awesome_4-6-3_book_256_0_000000_none.png" var="icon"/>
<spring:url value="/resources/icons/font-awesome_4-6-3_user_256_50_000000_none.png" var="img4"/>
<spring:url value="/resources/icons/font-awesome_4-6-3_user_256_50_ffffff_none.png" var="img5"/>
<spring:url value="/resources/icons/font-awesome_4-6-3_arrow-circle-left_256_0_ffffff_none.png" var="back"/>
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
                <a href="">
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
                <li class="w3-hide-small w3-hide-medium"><a class="w3-hover-teal" href="about-user.do"><i class="fa fa-sticky-note"></i> About Us</a></li>
                <li class="w3-hide-small w3-hide-large"><a class="w3-hover-teal" href="about-user.do"><i class="fa fa-sticky-note"></i> About</a></li>
                <li><a class="w3-teal" href="subjects.do"><i class="fa fa-book"></i> Subjects</a></li>
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
                <a href="" class="small-buttons w3-hide-small w3-right" style="display:none">
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
                <li><a class="w3-hover-teal" href="about-user.do"><i class="fa fa-sticky-note"></i> About Us</a></li>
                <li><a class="w3-hover-teal" href="queries.do"><i class="fa fa-question-circle"></i> Queries</a></li>
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
          <a href="upload.do" class="w3-left w3-padding-top"><img src="${back }" width="40px"></a>
          <h3>Upload</h3>
        </div>
        
        
        <div class="topic w3-content w3-padding-bottom" style="max-width:700px">
        	<div class="w3-card-4 w3-margin-top w3-padding-bottom">
            	<div class="w3-container w3-teal">
            	<h2><i class="fa fa-play-circle"></i> &nbsp;Video Upload</h2></div>
        		<form:form class="w3-form w3-margin-left w3-margin-right" action="upload-video-action.do" enctype="multipart/form-data" method="post" onsubmit="initial();">
        			<p>
        			<input id="t" class="w3-input w3-border w3-light-grey w3-hover-white" type="hidden" name="time">
        			</p>
                    <p class="w3-text-red w3-center">${message}
            		</p>
                    <p>
                    <label class="w3-label"><b>Title</b></label>
                    <input class="w3-input w3-border w3-light-grey w3-hover-white" type="text" name="title" required>
                    </p>
                    <p>
                    <label class="w3-label"><b>Description</b></label>
                    <textarea class="w3-input w3-border w3-light-grey w3-hover-white" name="description" required></textarea>
                    </p>
		            <p>
		            <label class="w3-label"><b>Subject</b></label>
		            <select class="w3-select w3-border w3-light-grey w3-hover-white" name="subject" required>
		            	<option value="none" selected disabled>Choose your option...</option>
		            	<option value="physics">Physics</option>
		                <option value="java">Java</option>
		            	<option value="digital-electronics">Digital Electronics</option>
		                <option value="chemistry">Chemistry</option>
		            	<option value="web-designing">Web Designing</option>
		                <option value="microprocessor">Microprocessor</option>
		                <option value="other">Other</option>
		            </select>
		            </p>
                    <p>
                    <label class="w3-label"><b>Select Video File</b></label>
                    <input class="w3-input w3-border w3-light-grey w3-hover-white" type="file" name="file" required>
                    </p>
                    <p>
                    <input type="submit" class="w3-btn w3-teal" value="Submit">
                    </p>
                </form:form>
        	</div>
        </div>
    
    
    </div>

</body>

</html>
