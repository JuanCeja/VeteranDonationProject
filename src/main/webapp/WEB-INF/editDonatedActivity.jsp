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
<title>Edit Your Activity</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/editDonatedActivity.css">
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

	<h3>Edit Your Activity</h3>
	<div class="form-container">
		<div class="flex-one">
			<form:form action="/edit/donatedActivity/${donatedActivity.id }"
				modelAttribute="donatedActivity">
				<input type="hidden" name="_method" value="put">
				<p>
					<form:label path="name">
						<strong>Activity Name: </strong>
					</form:label>
					<br>
				</p>
				<form:errors path="name" class="form-control-lg" />
				<form:input path="name" class="form-control-lg" />

				<p>
					<form:label path="description">
						<strong>Activity Description:</strong>
					</form:label>
					<br>
				</p>
				<form:errors path="description" class="form-control-lg" />
				<form:textarea path="description" class="form-control-lg" />
				<p>
					<form:label path="link">
						<strong>Activity Image Link: </strong>
					</form:label>
					<br>
				</p>
				<form:errors path="link" class="form-control-lg" />
				<form:input path="link" class="form-control-lg" />
				<br>
				<input class="button" type="submit" value="submit" />
				<a href="/home">Cancel</a>
			</form:form>
		</div>
		<div class="flex-one">
			<img src="${donatedActivity.link }" />
		</div>
	</div>
</body>
</html>