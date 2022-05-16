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
			<form:form action="/edit/freeActivity/${freeActivity.id }"
				modelAttribute="freeActivity">
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
				<p>
					<form:label path="date">
						<strong>Date: </strong>
					</form:label>
					<br>
				</p>
				<form:errors path="date" class="form-control-lg" />
				<form:input path="date" class="form-control-lg" />
				<br>

				<p>
					<form:label path="state">
						<strong>State: </strong>
					</form:label>
					<br>
				</p>
				<form:errors path="state" class="form-control-lg" />
				<form:select path="state">
					<form:option value="AL">ALABAMA</form:option>
					<form:option value="AK">ALASKA</form:option>
					<form:option value="AR">ARKANSAS</form:option>
					<form:option value="AZ">ARIZONA</form:option>
					<form:option value="CA">CALIFORNIA</form:option>
					<form:option value="CO">COLORADO</form:option>
					<form:option value="CT">CONNECTICUT</form:option>
					<form:option value="DE">DELAWARE</form:option>
					<form:option value="FL">FLORIDA</form:option>
					<form:option value="GA">GEORGIA</form:option>
					<form:option value="HI">HAWAII</form:option>
					<form:option value="ID">IDAHO</form:option>
					<form:option value="IL">ILLINOIS</form:option>
					<form:option value="IN">INDIANA</form:option>
					<form:option value="IA">IOWA</form:option>
					<form:option value="KS">KANSAS</form:option>
					<form:option value="KY">KENTUCKY</form:option>
					<form:option value="LA">LOUISIANA</form:option>
					<form:option value="ME">MAINE</form:option>
					<form:option value="MD">MARYLAND</form:option>
					<form:option value="MA">MASSACHUSETTS</form:option>
					<form:option value="MI">MICHIGAN</form:option>
					<form:option value="MN">MINNESOTA</form:option>
					<form:option value="MS">MISSISSIPPI</form:option>
					<form:option value="MO">MISSOURI</form:option>
					<form:option value="MT">MONTANA</form:option>
					<form:option value="NE">NEBRASKA</form:option>
					<form:option value="NV">NEVADA</form:option>
					<form:option value="NH">NEW HAMPSHIRE</form:option>
					<form:option value="NJ">NEW JERSEY</form:option>
					<form:option value="NM">NEW MEXICO</form:option>
					<form:option value="NY">NEW YORK</form:option>
					<form:option value="NC">NORTH CAROLINA</form:option>
					<form:option value="ND">NORTH DAKOTA</form:option>
					<form:option value="OH">OHIO</form:option>
					<form:option value="OK">OKLAHOMA</form:option>
					<form:option value="OR">OREGON</form:option>
					<form:option value="PA">PENNSYLVANIA</form:option>
					<form:option value="RI">RHODE ISLAND</form:option>
					<form:option value="SC">SOUTH CAROLINA</form:option>
					<form:option value="SD">SOUTH DAKOTA</form:option>
					<form:option value="TN">TENNESSEE</form:option>
					<form:option value="TX">TEXAS</form:option>
					<form:option value="UT">UTAH</form:option>
					<form:option value="VT">VERMONT</form:option>
					<form:option value="VA">VIRGINIA</form:option>
					<form:option value="WA">WASHINGTON</form:option>
					<form:option value="WV">WEST VIRGINIA</form:option>
					<form:option value="WI">WISONSIN</form:option>
					<form:option value="WY">WYOMING</form:option>
				</form:select>

				<p>
					<form:label path="place">
						<strong>Location: </strong>
					</form:label>
					<br>
				</p>
				<form:errors path="place" class="form-control-lg" />
				<form:input path="place" class="form-control-lg" />

				<input class="button" type="submit" value="submit" />
				<a href="/home">Cancel</a>
			</form:form>
		</div>
		<div class="flex-one">
			<img src="${freeActivity.link }" />
		</div>
	</div>
</body>
</html>