<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="javax.xml.namespace.QName" %>
<%@ page import="javax.xml.ws.Service" %>
<%@ page import="java.net.URL" %>
<%@ page import="org.java.ojekonline.webservice.OjekData" %>
<%@ page import="org.java.ojekonline.webservice.OjekDataImplService" %>
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
	%>
	<div>
	<
	</div>
</body>
</html>