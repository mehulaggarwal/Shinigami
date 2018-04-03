<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<style>
* {
	font-family: 'Lato', sans-serif;
}

.mid {
	position: absolute;
	left: 50%;
	transform: translate(-50%, 0%);
	width: 100%;
	text-align: center;
}

* {
	box-sizing: border-box;
}

.container {
	border: 2px solid #dedede;
	background-color: #f1f1f1;
	border-radius: 5px;
	padding: 10px;
	margin: 10px 10px;
	width: 70%;
	overflow: auto;
	float: left;
}

.dis {
	margin: 10px 10px;
	padding: 10px;
	float: left;
}
</style>
<head>
<link href="https://fonts.googleapis.com/css?family=Lato"
	rel="stylesheet">
</head>
<body>
	<div class="mid">
		<h1>MESSAGES</h1>
		<hr>
		<br>

		<c:if test="${not empty messages}">

			<c:forEach var="listValue" items="${messages}">
				<p class="container">${listValue.message}</p>
				<a class="dis" href="/SubscriberModel/deleteMessage/${listValue.channel_name}/${listValue.channel_id}/${listValue.notification_id}.html">delete</a>
			</c:forEach>
		</c:if>

	</div>
</body>
</html>