<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script> -->
<!--  <script src="upload.js"></script> -->
</head>
<style>
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
.cancelbtn, .signupbtn {
	width: 100%;
	float: right;
	margin-right: 83px;
}

.upper {
	position: absolute;
	left: 50%;
	top: 10%;
	transform: translate(-50%, 0%);
}

.center {
	position: absolute;
	left: 50%;
	top: 50%;
	transform: translate(-50%, -50%);
}

.middle {
	position: absolute;
	left: 50%;
}
</style>
<body>
	<h1 class="upper">${msg}</h1>
	<button onclick="document.getElementById('id01').style.display='block'"
		class="center" style="width: auto;">Post Message</button>

	<div id="id01" class="modal">
		<span onclick="document.getElementById('id01').style.display='none'"
			class="close" title="Close Modal">&times;</span>
		<form class="modal-content" action="message.html" method="post"
			enctype="multipart/form-data">
			<div class="container">
				<h1 align="center">Post Message</h1>
				<hr>
				<textarea style="width: 90%; min-height: 400px;"
					placeholder="Enter Message" name="message"></textarea>
				<p>
					<label for="image">Choose Image</label>
				</p>
				<p>
					<input name="file" id="fileToUpload" type="file" />
				</p>
				<p>
					<input type="submit" value="Upload">
				</p>
				<div class="clearfix">
					<button type="submit" style="width: auto;" class="signupbtn">Post</button>

				</div>
			</div>
		</form>
		<form method="post" action="savefile.html"
			enctype="multipart/form-data">
			<p>
				<label for="image">Choose Image</label>
			</p>
			<p>
				<input name="file" id="fileToUpload" type="file" />
			</p>
			<p>
				<input type="submit" value="Upload">
			</p>
		</form>
	</div>

</body>
</html>