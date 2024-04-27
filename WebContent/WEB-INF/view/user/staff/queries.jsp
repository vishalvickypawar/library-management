<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Queries</title>
<spring:url value="/resources/css/w3.css" var="w3css"/>
<spring:url value="/resources/images/eLearningLogoTag-sm.png" var="logo"/>
<spring:url value="/resources/icons/font-awesome_4-6-3_question-circle_256_0_000000_none.png" var="icon"/>
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
                <li class="w3-hide-small w3-hide-medium"><a class="w3-hover-teal" href="about-user.do"><i class="fa fa-sticky-note"></i> About Us</a></li>
                <li class="w3-hide-small w3-hide-large"><a class="w3-hover-teal" href="about-user.do"><i class="fa fa-sticky-note"></i> About</a></li>
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
                <li><a class="w3-teal" href="queries.do"><i class="fa fa-question-circle"></i> Queries</a></li>
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
                <li><a class="w3-hover-teal" href="about-user.do"><i class="fa fa-sticky-note"></i> About Us</a></li>
                <li><a class="w3-hover-teal" href="subjects.do"><i class="fa fa-book"></i> Subjects</a></li>
                <li><a class="w3-hover-teal" href="contact.do"><i class="fa fa-envelope"></i> Contact</a></li>
            </ul>
        </div>
        
        <div id="extra-bar" style="max-width:inherit; display:none;">
            <ul class="w3-navbar w3-light-grey w3-card-2">
            	<li><a>home</a></li>
            </ul>
        </div>
        
        <div class="w3-row w3-content w3-padding w3-margin-top">
          <div class="w3-container w3-teal w3-center"><h3>Queries</h3></div>
          <a href="queries.do">
            <div class="w3-half tablink w3-bottombar w3-hover-light-grey w3-padding w3-border-teal">All Questions and Answers</div>
          </a>
          <a href="queries-my.do">
            <div class="w3-half tablink w3-bottombar w3-hover-light-grey w3-padding">My Answers</div>
          </a>
        </div>
        
        <div class="topic w3-content w3-padding-bottom">
        	<div class="w3-card-4 w3-margin">
            	<div class="w3-container w3-teal"><h2>All Questions and Answers</h2></div>
        		<ul class="w3-ul">
                <c:forEach items="${sessionScope.questions }" var="questions" varStatus="loop">
                  <li class="w3-row w3-hover-light-grey" onclick="showAns('a${loop.index}')" title="Click to show answers">
                    <div class="w3-quarter" style="min-width:200px;">
                        <c:choose>
	                    <c:when test="${questions.student.profile == 'nopic'}">
	                        <img src="${img4 }" class="w3-left w3-circle w3-margin" style="width:60px">
	                    </c:when>
	                    <c:otherwise>
	                    	<img src="${pageContext.request.contextPath }/images/${questions.student.profile}" class="w3-left w3-circle w3-margin" style="width:60px">
	                    </c:otherwise>
	                    </c:choose>
                        <br><span class="w3-large">${questions.student.firstname}</span><br>
                        <span>${questions.formattedDate }</span>
                    </div>
                    <div class="w3-half w3-padding">
                        <span>${questions.question}</span>
                    </div>
                  	<div class="w3-quarter w3-right w3-margin-top">
                        <p class="w3-right w3-margin-right"><span class="w3-badge w3-red w3-padding">${questions.replies }</span></p>
                    </div>
                  </li>
                  
                  <ul id="a${loop.index }" class="w3-ul w3-light-grey" style="display:none">
                  	  <li class="w3-light-grey">
	                    <form class="w3-form w3-margin-left w3-margin-right" action="answer.do" onsubmit="initial();">
	                    	<input type="hidden" name="question-id" value="${questions.id }">
	                    	<p>
	                    	<input id="t" class="w3-input w3-border w3-light-grey w3-hover-white" type="hidden" name="time">
	                    	</p>
	                        <label class="w3-label"><b>Answer</b></label>
	                        <textarea class="w3-input w3-border w3-white" name="answer" required></textarea>
	                        </p>
	                        <p>
	                        <input type="submit" class="w3-btn w3-teal" value="Submit">
	                        </p>
	                    </form>
	                  </li>
                	<c:forEach items="${sessionScope.answers }"  var="answers">
                	<c:if test="${answers.question.id == questions.id}">
                      <li class="w3-row w3-margin-left">
                        <div class="w3-quarter w3-margin-left" style="min-width:200px;">
                        <c:choose>
	                    <c:when test="${answers.staff.profile == 'nopic'}">
                            <img src="${img4 }" class="w3-left w3-circle w3-margin" 
                            	style="width:60px">
                        </c:when>
                        <c:otherwise>
                        	<img src="${pageContext.request.contextPath }/images/${answers.staff.profile}" class="w3-left w3-circle w3-margin" 
                            	style="width:60px">
                        </c:otherwise>
                        </c:choose>
                            <br><span class="w3-large">${answers.staff.firstname }</span><br>
                            <span>${answers.formattedDate }</span>
                        </div>
                        <div class="w3-rest w3-padding w3-margin-left">
                            <span>${answers.answer }</span>
                        </div>
                      </li>
                      </c:if>
                    </c:forEach>
                  </ul>
                  </c:forEach>
                </ul>
            </div>
        </div>
        
        
    </div>

</body>

</html>
