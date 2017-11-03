<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="style/kepala.css">
<link rel="stylesheet" type="text/css" href="style/selectdriver.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Select Driver</title>
</head>
<body>
	<div>
		<p id="hi_username">Hi, <b>man</b> !</p>
		<h1 id="logo">
			<span id="labelgreen">PR</span>-<span id="labelred">OJEK</span>
		</h1>
		<a id="logout" href="../login.php">Logout</a>
		<p id="extralogo">wush... wush... ngeeeeenggg...</p>
	</div>

	<table id="tableactivity">
		<tr>
			<td id="current_activity"><a href="pickdestination.jsp">ORDER</a></td>
			<td class="rest_activity"><a href="userHistory.jsp">HISTORY</a></td>
			<td class="rest_activity"><a href="showprofile.jsp">MY PROFILE</a></td>
		</tr>
	</table>

	<p id="makeanorder">MAKE AN ORDER</p>
		
	<table class="tableorder">
		<tr>
			<td><div class="circle">1</div></td>
			<td class="titleorder">Select<br>Destination</td>
		</tr>
	</table>

	<table class="tableorder">
		<tr id="current_order">
			<td><div class="circle">2</div></td>
			<td class="titleorder">Select a<br>Driver</td>
		</tr>
	</table>

	<table class="tableorder">
		<tr>
			<td><div class="circle">3</div></td>
			<td class="titleorder">Complete<br>your Order</td>
		</tr>
	</table>

	<div class="driverblock">
		<h2 class="title_driver">PREFERRED DRIVERS:</h2>
		<div class="chosen_driver">
			if (request.getParameter("picking_point")) {
				session.setAttribute("pick", "request.getParameter("picking_point")");
			}
			if (request.getParameter("destination")) {
				session.setAttribute("dest", "request.getParameter("destination")");
			} 
			if (request.getParameter("preferred_driver")) {
				session.setAttribute("prefdriver", "request.getParameter("preferred_driver")");
			}
			  
		</div>
	</div>
	
	<div class="driverblock">
		<h2 class="title_driver">OTHER DRIVERS:</h2>
		<div class="chosen_driver">
		</div>
	</div>	
</body>
</html>