<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.io.*,java.util.*,java.sql.*"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<%@ page import="org.java.ojekonline.webservice.OjekData" %>
<%@ page import="org.java.ojekonline.webservice.OjekDataImplService" %>
<%@ page import="org.java.ojekonline.webservice.Babi" %>
<%@ page import="org.java.ojekonline.webservice.MapElementsArray" %>
<%@ page import="org.java.ojekonline.webservice.MapElements" %>
<%@ page import = "java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="Ngo-Jek - Ojek Online Clone Website">
    <meta name="author" content="Taufan Mahaputra, Erfandi Suryo Putro, Gianfranco F.H">

    <!-- Properties Title -->
    <link rel="shortcut icon" href="" />
    <title>Ngo-Jek</title>

   
    <!-- Custom CSS -->
    <link href="history.css" rel="stylesheet" type='text/css'/>
    <link href="driverHistory.css" rel="stylesheet" type='text/css'/>
    <!-- Custom Fonts -->
    <link href="https://fonts.googleapis.com/css?family=Patua+One" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Oswald:400,500,600" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Roboto:400,500" rel="stylesheet">
    <!-- Script -->
    <script src=""></script>
</head>
<body>
	<%
		OjekDataImplService service = new OjekDataImplService();
		OjekData ps = service.getOjekDataImplPort();
		
		Babi res = new Babi();
		res = ps.getDriverHistory(10);
		%>
		<div>
		<p id="hi_username">Hi, <b> USERNAME</b> !</p>
		<h1 id="logo">
			<span id="labelgreen">PR</span>-<span id="labelred">OJEK</span>
		</h1>
		<a id="logout" href="logout.jsp">Logout</a>
		<p id="extralogo">wush... wush... ngeeeeenggg...</p>
		</div>
		
		<table id="tableactivity">
		<tr>
			<td class="rest_activity"><a href="pickdestination.jsp">ORDER</a></td>
			<td id="current_activity"><a href="#">HISTORY</a></td>
			<td class="rest_activity"><a href="profile.jsp">MY PROFILE</a></td>
		</tr>
		</table>
		<p id="transactionHistory" >TRANSACTION HISTORY</p>
		<table id="tableactivity">
		<tr>
			<td class="rest_activity"><a href="history-penumpang.jsp">PREVIOUS ORDER</a></td>
			<td id="current_activity"><a href="#">DRIVER HISTORY</a></td>
		</tr>
		</table>
		<br>
		<%
		if (res.getResults().size() != 0){
			Map<String, String> hasil = new HashMap<String, String>();
			ArrayList<MapElements> temp = new ArrayList<MapElements>();
			for (MapElementsArray isi : res.getResults()) {
				temp = (ArrayList<MapElements>) isi.getItem();
				for (MapElements konten : temp) { 
					hasil.put(konten.getKey(), konten.getValue());
				} %>
				<form method="post" action="history-driver-hide.jsp">
						<div class="divTabelProfile" >
							<table class="tabelProfile">
								<tr>
									<td class="profilePict" >
										<div class="containerPict">
											<img class="pictProfile" src="<%= ps.getPicture(Integer.parseInt(hasil.get("id_user")))%>">
										</div>
									</td>
									<td class="profileDll">
										<div class="currentDate">
											<%= hasil.get("date_order") %>
										</div>
										<div class="customerName">
											<%= hasil.get("customer_name") %>
										</div>
										<div class="tujuan">
											<%= hasil.get("origin") %> -> <%= hasil.get("destination") %>
										</div>
										<div class="rating">
											gave <span class="colorRating"><%= hasil.get("rating") %></span> stars for this order
										</div>
										<div class="comment">
											and left comment: <br>
											   <span class="userComment"><%= hasil.get("comment") %>'</span>
										</div>
									</td>
									<td class="profileButton">
										<input type="hidden" name="id_history" value="<%= hasil.get("id_history") %>">
										<button class="hideButton" type="submit" name="hide">HIDE</button>
									</td>
								</tr>
							</table>
						</div>
					</form>
			<%
			}
		}
		else {
			%>
			<center>Nothing to display</center><%
		}	
	%>
</body>
</html>