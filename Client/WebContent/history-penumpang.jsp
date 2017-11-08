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
    <link href="style/main.css" rel="stylesheet" type='text/css'/>
    <link href="style/profile.css" rel="stylesheet" type='text/css'/>
    <link href="style/history.css" rel="stylesheet" type='text/css'/>
    <link href="style/driverHistory.css" rel="stylesheet" type='text/css'/>
    <!-- Custom Fonts -->
    <link href="assets/stylesheets/font-awesome.css" rel="stylesheet">
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
		res = ps.getUserHistory(10);
		if (res != null){
			Map<String, String> hasil = new HashMap<String, String>();
			ArrayList<MapElements> temp = new ArrayList<MapElements>();
			for (MapElementsArray isi : res.getResults()) {
				temp = (ArrayList<MapElements>) isi.getItem();
				for (MapElements konten : temp) { 
					hasil.put(konten.getKey(), konten.getValue());
				} %>
				<form method="post" action="history-penumpang-hide.jsp">
						<div class="divTabelProfile" >
							<table class="tabelProfile">
								<tr>
									<td class="profilePict" >
										<div class="containerPict">
											<img class="pictProfile" src="<%= ps.getPicture(Integer.parseInt(hasil.get("id_driver")))%>">
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
			<center>No History</center><%
		}	
	%>
</body>
</html>