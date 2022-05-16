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
<title>Home Page</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/home.css">
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
	<div>
		<h3>
			Welcome,
			<c:out value="${thisUser.userName }" />
		</h3>
		<a href="/logout">logout</a>
	</div>
	<div class="description">
		<h4>Help a Veteran by Donating and voting on an event below or
			recommending an event also.</h4>
		<h2>EVENT DATE (10-08-22)</h2>
		<h5>
			<a href="/home">DONATE HERE</a>
		</h5>
	</div>
	<div class="donatedEventsTable">
		<h1>Donated Activities</h1>
		<p><i>These are the events that users and veterans can vote on. The activity with the highest votes will be the activity in which the donation money will go to. Donated Activity will happen on the date stated above.</i></p>
		<p style="color: red;">Total Amount Donated: $2300</p>
		<table class="table table-hover">
			<thead>
				<tr>
					<th scope="col">ACTIVITY</th>
					<th scope="col">DESCRIPTION</th>
					<th scope="col">BRIEF IMAGE</th>
					<th scope="col">VOTES</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${donatedActivities }" var="donatedActivity">
					<tr>
						<th scope="row"><a href="/activities/${donatedActivity.id }"><c:out
									value="${donatedActivity.name }" /></a></th>
						<td><c:out value="${donatedActivity.description }" /></td>
						<td><img src="${donatedActivity.link }" alt="activity-image" /></td>
						<td><div class="upvoteSection">
								<a href="#"><img class="upvoteIcon"
									src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS83fDUPoWN1IWw8u_mUvN3CHCn95a2gbOmgA&usqp=CAU"
									alt="upvote icon" /></a>
								<p>7</p>
							</div></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<a class="recommendActivityLink" href="/new/donatedactivity">Recommend
			an new activity!</a>
	</div>

	<div class="donatedEventsTable">
		<h1>Free Events veterans Can Attend</h1>
		<table class="table table-hover">
			<thead>
				<tr>
					<th scope="col">ACTIVITY</th>
					<th scope="col">DESCRIPTION</th>
					<th scope="col">BRIEF IMAGE</th>
					<th scope="col">DATE</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${freeActivities }" var="freeActivity">
					<tr>
						<th scope="row"><a href="/free/activities/${freeActivity.id }"><c:out
									value="${freeActivity.name }" /></a></th>
						<td><c:out value="${freeActivity.description }" /></td>
						<td><img src="${freeActivity.link }" alt="activity-image" /></td>
						<td><c:out value="${freeActivity.date }"/></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<a class="recommendActivityLink" href="new/FreeActivity">Post Your
			Event</a>
	</div>
</body>
</html>