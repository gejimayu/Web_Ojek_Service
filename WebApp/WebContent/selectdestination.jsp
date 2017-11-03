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
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1> hello </h1>
	<% 
		//URL wsdlURL = new URL("http://localhost:8082/WS/OjekData?wsdl");
		
		//QName qname = new QName("http://webservice.ojekonline.java.org/", 
				//"OjekDataImplService");
		
		//Service service = Service.create(wsdlURL, qname);  

		//OjekData ps = service.getPort(OjekData.class);
		
		OjekDataImplService tes = new OjekDataImplService();
		OjekData ps = tes.getOjekDataImplPort();
		
		ps.validateToken("aso");
	
	%>
	
</body>
</html>