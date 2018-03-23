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
<style>
.dropbtn {
	background-color: #4CAF50;
	color: white;
	padding: 16px;
	font-size: 16px;
	border: none;
	cursor: pointer;
}

.dropdown {
	position: absolute;
	display: block;
	left: 50%;
	top: 20%;
	transform: translate(-50%, -20%);
}
.dropdown1 {
	position: absolute;
	display: block;
	left: 50%;
	top: 40%;
	transform: translate(-50%, -40%);
	z-index: -1;
}
.dropdown-content {
	display: none;
	position: absolute;
	background-color: #f9f9f9;
	min-width: 160px;
	box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
	z-index: 1;
}

.dropdown-content a {
	color: black;
	padding: 12px 16px;
	text-decoration: none;
	display: block;
}

.dropdown-content a:hover {
	background-color: #f1f1f1
}

.dropdown:hover .dropdown-content {
	display: block;
}
.dropdown1:hover .dropdown-content {
	display: block;
}

.dropdown:hover .dropbtn {
	background-color: #3e8e41;
}
.dropdown1:hover .dropbtn {
	background-color: #3e8e41;
}

body {
	font-family: Arial, Helvetica, sans-serif;
}

* {
	box-sizing: border-box
}
/* Full-width input fields */
input[type=text], input[type=password] {
	width: 100%;
	padding: 15px;
	margin: 5px 0 22px 0;
	display: inline-block;
	border: none;
	background: #f1f1f1;
}

/* Add a background color when the inputs get focus */
input[type=text]:focus, input[type=password]:focus {
	background-color: #ddd;
	outline: none;
}

/* Set a style for all buttons */
button {
	background-color: #4CAF50;
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	cursor: pointer;
	width: 100%;
	opacity: 0.9;
}

button:hover {
	opacity: 1;
}

/* Extra styles for the cancel button */
.cancelbtn {
	padding: 14px 20px;
	background-color: #f44336;
}

/* Remove the highlight */
.dlink {
	text-decoration: none;
}

/* Float cancel and signup buttons and add an equal width */
.cancelbtn, .signupbtn {
	float: left;
	width: 50%;
}

/* Add padding to container elements */
.container {
	padding: 16px;
}

/* The Modal (background) */
.modal {
	display: none; /* Hidden by default */
	position: fixed; /* Stay in place */
	z-index: 1; /* Sit on top */
	left: 0;
	top: 0;
	width: 100%; /* Full width */
	height: 100%; /* Full height */
	overflow: auto; /* Enable scroll if needed */
	background-color: #474e5d;
	padding-top: 50px;
}

/* Modal Content/Box */
.modal-content {
	background-color: #fefefe;
	margin: 5% auto 15% auto;
	/* 5% from the top, 15% from the bottom and centered */
	border: 1px solid #888;
	width: 80%; /* Could be more or less, depending on screen size */
}

/* Style the horizontal ruler */
hr {
	border: 1px solid #f1f1f1;
	margin-bottom: 25px;
}

.pos {
	position: absolute;
	left: 80%;
}

.cenup {
	position: absolute;
	left: 50%;
	top: 30%;
	width: auto;
	font-size: 18px;
	transform: translate(-50%, -30%);
}

.pos2 {
	position: absolute;
	left: 65%;
}
/* The Close Button (x) */
.close {
	position: absolute;
	right: 35px;
	top: 15px;
	font-size: 40px;
	font-weight: bold;
	color: #f1f1f1;
}

.close:hover, .close:focus {
	color: #f44336;
	cursor: pointer;
}

/* Clear floats */
.clearfix::after {
	content: "";
	clear: both;
	display: table;
}

/* Change styles for cancel button and signup button on extra small screens */
@media screen and (max-width: 300px) {
	.cancelbtn, .signupbtn {
		width: 100%;
	}
}

.down {
	position: absolute;
	top: 15%;
}
.logout{
 position: absolute;
 top:90%;
 left:90%;
}
</style>
<body>

	<form action="showlist.html" method="post">
		<button style="width: auto;" type="submit" class="pos2">Subscribe
			a Channel</button>
	</form>
	<button onclick="document.getElementById('id01').style.display='block'"
		class="pos" style="width: auto;">Create Channel</button>

	<div id="id01" class="modal">
		<span onclick="document.getElementById('id01').style.display='none'"
			class="close" title="Close Modal">&times;</span>
		<form class="modal-content" action="createchannel.html" method="post">
			<div class="container">
				<h1>Create Channel</h1>
				<hr>
				<label><b>Channel name</b></label> <input type="text"
					placeholder="Enter Channel Name" name="channel_name" required>

				<div class="clearfix">
					<button type="button"
						onclick="document.getElementById('id01').style.display='none'"
						class="cancelbtn">Cancel</button>
					<button type="submit" class="signupbtn">Create</button>
				</div>
			</div>
		</form>
	</div>
	<%-- <div class="down">
		<h3>Channels created by you:</h3>
		<c:if test="${not empty lists}">

			<ul>
				<c:forEach var="listValue" items="${lists}">
					<li><a
						href="/SubscriberModel/PostMessage/${listValue.channel_name}/${listValue.channel_id}.html">${listValue.channel_name}</a></li>
				</c:forEach>
			</ul>

		</c:if>
	</div> --%>
	<div class="dropdown">
		<button class="dropbtn" class="cenup">Channel Created by you</button>
		<div class="dropdown-content">
			<c:if test="${not empty lists}">

				<c:forEach var="listValue" items="${lists}">
					<a
						href="/SubscriberModel/PostMessage/${listValue.channel_name}/${listValue.channel_id}.html"
						class='dlink'>${listValue.channel_name}</a>

				</c:forEach>

			</c:if>

		</div>

	</div>
	<div class="dropdown1">
		<button class="dropbtn" class="cenup">Channel Subscribed by you</button>
		<div class="dropdown-content">
			<c:if test="${not empty lists1}">

				<c:forEach var="listValue" items="${lists1}">
					<a
						href="/SubscriberModel/showMessages/${listValue.channel_name}/${listValue.channel_id}.html"
						class='dlink'>${listValue.channel_name}</a>

				</c:forEach>

			</c:if>

		</div>

	</div>
	
	<a class="logout" href="/SubscriberModel/logout.html">Log out</a>
	
	<script>
		// Get the modal
		var modal = document.getElementById('id01');

		// When the user clicks anywhere outside of the modal, close it
		window.onclick = function(event) {
			if (event.target == modal) {
				modal.style.display = "none";
			}
		}
	</script>

</body>
</html>
