<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) -->
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/showFreeActivity.css">
<!-- change to match your file/naming structure -->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="topHeader">
		<img
			src="https://www.philosophytalk.org/sites/default/files/styles/large_blog__900x400_/public/our-military-blog-pics-1.png"
			alt="USA flag with military branches" />
	</div>
	<div class="activity-info">
		<h1>
			<c:out value="${freeActivity.name }" />
		</h1>

			<p><i>Created By:</i></p>
			<h3>
				<c:out value="${freeActivity.user.userName }" />
			</h3>

			<p><i>Contact Information:</i></p>
			<h3>
				<c:out value="${freeActivity.user.email }" />
			</h3>

			<p><i>Location:</i></p>
			<h3>
				<c:out value="${freeActivity.place }"/>, <c:out value="${freeActivity.state }" /> 
			</h3>



		<img src="${freeActivity.link }" alt="activity-image" />
	</div>

	<div class="activity-description">
		<h4>Description:</h4>
		<p>
			<c:out value="${freeActivity.description }"></c:out>
		</p>
		<c:if test="${freeActivity.user.id == user_id }">
			<a class="button" href="/free/activities/${freeActivity.id}/edit">Edit
				Activity</a>
			<a class="delete-button" href="/free/delete/${freeActivity.id }">Delete
				Activity</a>
		</c:if>
		<a href="/home"><h5>Home</h5></a>
	</div>

</body>
</html>