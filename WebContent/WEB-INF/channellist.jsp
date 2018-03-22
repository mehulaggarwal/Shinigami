<%@page import="java.util.List"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://fonts.googleapis.com/css?family=Lato"
	rel="stylesheet">
</head>
<style>
*{
 font-family: 'Lato', sans-serif;
}

.middle {
	position: absolute;
	left: 50%;
	top: 15%;
	transform: translate(-50%, -15%);
}

.middle1 {
	position: absolute;
	left: 50%;
	transform: translate(-50%, 0%);
}
ul.a{
list-style-type: none;
}
.dlink{
text-decoration: none;
}
.fontsize{
font-size: 40px;
}
.font1{
 font-size: 100px;
}
</style>
<body>
	<h1 class="middle1" class="font1">Click on the channel to subscribe</h1>
	<div class="middle">
		<h2>Channel List:</h2>
		<c:if test="${not empty lists}">

			<ul class="a">
				<c:forEach var="listValue" items="${lists}">
					<li><a
						href="/SubscriberModel/subscribeChannel/${listValue.channel_name}/${listValue.channel_id}.html" class="dlink" class="fontsize">${listValue.channel_name}</a></li>
						<br>
				</c:forEach>
			</ul>

		</c:if>
	</div>
</body>
</html>