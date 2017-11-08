<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<%@ page import="javax.xml.namespace.QName" %>
<%@ page import="javax.xml.ws.Service" %>
<%@ page import="java.net.URL" %>
<%@ page import = "java.io.*,java.util.*,java.sql.*"%>
<%@ page import="org.java.ojekonline.webservice.OjekData" %>
<%@ page import="org.java.ojekonline.webservice.OjekDataImplService" %>
<%@ page import="org.java.ojekonline.webservice.Profile" %>
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
    <meta name="author" content="Taufan Mahaputra, Robby Syaifullah, M Rafli">
    <!-- Properties Title -->
    <link rel="shortcut icon" href="editlocation.css" />
    <title>Ngo-Jek</title>

    <!-- Custom CSS -->
    <link href="style/main.css" rel="stylesheet" type='text/css' />
    <link href="style/editlocation.css" rel="stylesheet" type='text/css' />
    <!-- Custom Fonts -->
    <link href="style/font-awesome.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Patua+One" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Oswald:400,500,600" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Roboto:400,500" rel="stylesheet">
    <link href="style/editlocation.css" rel="stylesheet">
    <!-- Script -->
    <script src="javascript/edit-location.js"></script>
</head>
<%
	OjekDataImplService service = new OjekDataImplService();
	OjekData ps = service.getOjekDataImplPort();
	String user = request.getParameter("id_user");
	int id_user = Integer.parseInt(user);
	String full_name = request.getParameter("name");
	String phone_number = request.getParameter("phone");
	String driver = request.getParameter("driver");
	if (driver != null) {
		driver = "true";
	}
	else {
		driver = "false";
	}
	
	ps.saveProfile(id_user, full_name, phone_number, driver);
%>
<body>
<script>
alert('Successfully updated profile!');
window.location.href = "http://localhost:8080/Client/edit-profile.jsp"
</script>
</body>
</html>