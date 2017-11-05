<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<%@ page import="javax.xml.namespace.QName" %>
<%@ page import="javax.xml.ws.Service" %>
<%@ page import="java.net.URL" %>
<%@ page import="org.java.ojekonline.webservice.OjekData" %>
<%@ page import="org.java.ojekonline.webservice.OjekDataImplService" %>
<%@ page import="org.java.ojekonline.webservice.Profile" %>
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
		int id_user = 1;
	
		OjekDataImplService service = new OjekDataImplService();
		OjekData ps = service.getOjekDataImplPort();
		Profile profile = new Profile();
		profile = ps.getProfileInfo(id_user);
	%>


 	<div class="container">
    <!-- navbar -->
    <div class="navbar">
      <img src="assets/image/yesbos.png" class="logo">
      <div class="logout">
        <p style="margin-bottom: 2px;">Hi, <strong><%= profile.getUsername() %></strong> !</p>
        <a href="index.php">Logout</a>
      </div>
    </div>

    <!-- navigation -->
    <div class="header" id="header">
          <nav>
            <ul>
              <li><a href="seldestination.jsp">ORDER</a></li>
              <li><a href="history-penumpang.jsp">HISTORY</a></li>
              <li><a href="profile.jsp" class="option-active" >MY PROFILE</a></li>
            </ul>
          </nav>
    </div>

    <!-- profile -->
    <div class="profile">
        <div class="profile-header">
          <h2 class="profile-title">MY PROFILE</h2>
            <a href="edit-profile.jsp"  class="fa fa-pencil fa-2x edit-profile-icon tooltip"><span class="tooltiptext">Edit Profile</span></a>
        </div>
        <div class="img-profile">
          <img src="#imageprofile">
          <h3 style="margin-bottom: 5px;"> @<%= profile.getUsername() %> </h3>
          <%= profile.getFullName() %><br>
          <%= profile.getDriver() %>
          <br>
          <i class="fa fa-envelope-o" aria-hidden="true">&nbsp; <%= profile.getUsername() %></i><br>
          <i class="fa fa-phone" aria-hidden="true">&nbsp; <%= profile.getPhoneNumber() %></i>
        </div>
    </div>

    <!-- preferred-location -->
    <%
			ArrayList<String> locations = new ArrayList<String>();
    		locations = ps.listLocation(id_user);
    		if(locations.size() == 0) {
    %>			
    <%= locations.size() %>
    			 <div class="preferred-location">
    			 	<div class="location-header">
				          <h4 class="profile-title">PREFERRED LOCATIONS:</h4>
				          <a href="edit-location.jsp" class="fa fa-pencil fa-2x edit-location-icon tooltip"><span class="tooltiptext">Edit Location</span></a>
				    </div>
				    <div class="list-location">
				       <ul> No location was inserted </ul>
				    </div>
				 </div>
				  
    <% 	
    		}
    		else { 
    			for (String location : locations) {
	%>
			
				<div class="preferred-location">
    			 	<div class="location-header">
				          <h4 class="profile-title">PREFERRED LOCATIONS:</h4>
				          <a href="edit-location.jsp" class="fa fa-pencil fa-2x edit-location-icon tooltip"><span class="tooltiptext">Edit Location</span></a>
				    </div>
				    <div class="list-location">
				        <ul>
				        	<li>
				       			 <i class="fa fa-angle-right" aria-hidden="true"><span>&nbsp;<%= location %>  </span></i></li>
				        	</li>
				        </ul>
				    </div>
				 </div>ss
				
		<%		}
    		}
		%>

  </div>

	


</body>
</html>