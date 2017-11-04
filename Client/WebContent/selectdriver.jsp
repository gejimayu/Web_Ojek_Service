<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.io.*,java.util.*,java.sql.*"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix = "sql"%>
<%@ page import="org.java.ojekonline.webservice.OjekData" %>
<%@ page import="org.java.ojekonline.webservice.OjekDataImplService" %>
<%@ page import="org.java.ojekonline.webservice.Babi" %>
<%@ page import="org.java.ojekonline.webservice.MapElementsArray" %>
<%@ page import="org.java.ojekonline.webservice.MapElements" %>
<%@ page import = "java.util.ArrayList"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="style/kepala.css">
<link rel="stylesheet" type="text/css" href="style/selectdriver.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Select Driver</title>
</head>
<body>
	<%  
		int userid = 1;
		String pick = request.getParameter("picking_point"), 
				dest = request.getParameter("destination"), 
				prefdriver = request.getParameter("preferred_driver");	
		if (pick != null) {
			session.setAttribute("pick", pick);
		}
		if (dest != null) {
			session.setAttribute("dest", dest);
		} 
		if (prefdriver != null) {
			session.setAttribute("prefdriver", prefdriver);
		}
		
		OjekDataImplService service = new OjekDataImplService();
		OjekData ps = service.getOjekDataImplPort();
	%>	  
	<div>
		<p id="hi_username">Hi, <b>Pika1</b> !</p>
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
		
		</div>
	</div>
	
	<div class="driverblock">
		<h2 class="title_driver">OTHER DRIVERS:</h2>
		<div class="chosen_driver">
		
		<%
			Babi res = new Babi();
			res = ps.findDriver(userid, pick, dest);
	
			Map<String, String> hasil = new HashMap<String, String>();
			
			ArrayList<MapElements> temp = new ArrayList<MapElements>();
			for (MapElementsArray isi : res.getResults()) {
				temp = (ArrayList<MapElements>) isi.getItem();
				for (MapElements konten : temp) { 
					hasil.put(konten.getKey(), konten.getValue());
				} %>
			
				<table>
					<tr>
						<td><img src='<%= hasil.get("prof_pic")  %>'></td>
						<td id='driver_identification'>
							<span id='driver_name'><%= hasil.get("name")  %></span><br>
							<span id='driver_rating'>☆ <%= Float.parseFloat(hasil.get("avgrating"))  %></span> 
							(<%= hasil.get("num_votes") %> votes) <br>
							<form action='completeorder.php' method='POST'>
								<button name='driverid' value='<%=hasil.get("id_driver")%>'>I CHOOSE YOU!</button>
							</form>
						</td>
					</tr>
				</table>	
				
		<%	}
		%>
		
		</div>
	</div>	
</body>
</html>