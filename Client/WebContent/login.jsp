<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="Ngo-Jek - Ojek Online Clone Website">
    <meta name="author" content="Taufan Mahaputra, Erfandi Suryo Putra, Gianfranco F.H">
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	
	 <!-- Properties Title -->
    <link rel="shortcut icon" href="" />
    <title>Ngo-Jek</title>
    
    <!-- Custom CSS -->
    <link href="assets/stylesheets/main.css" rel="stylesheet" type='text/css'/>
    <!-- Custom Fonts -->
    <link href="assets/fonts/font-awesome.min.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Oswald:400,500,600" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Roboto:400,500" rel="stylesheet">
    <!-- Script -->
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
    <script src="assets/javascript/login.js"></script>
    <script>
function submitForm(thisObj, thisEvent) {
	  var name = $('#username-field').val();
	  var password = $('#password-field').val();
		console.log(name, password);
	  var myData = {
	    "account": {
	      "username": name,
	      "password": password
	    }
	  };
	  var jsonDataObject = new Object();
	  jsonDataObject.username = name;
	  jsonDataObject.password = password;
	  
	  dataSend = JSON.stringify(jsonDataObject);
	  $.ajax({
	    type: "POST",
	    url: "http://localhost:8081/IdentityService/login",
	    data: dataSend,
	    contentType: 'application/json',
	    success: function(data, status, xhr){
	    	console.log('successful logged in');
	    	window.location.href = "http://localhost:8080/Client/selectdestination.jsp";
        }
	  });
	  console.log(JSON.stringify(myData));
	  return false;
}
</script>
</head>
<body>
 	<div class="login" id="form-login">
 		<h2 class="title">---LOGIN---</h2>
    <form name="form-login" enctype='application/json'>
   		<div class="input-form">
   			<div class="label">
   				<p style="width: 120px;">Username</p>
  	 			<input id="username-field" type="text" name="username" placeholder="   your username">
  	 		</div>
  	 		<div class="label">
  	 			<p style="width: 120px;">Password</p>
  	 			<input id="password-field" type="password" name="password" placeholder="   password">
  	 		</div>
  	 	</div>
   		<div class="submit-form"> 
   			<p class="no-acc"><a href="register.php"> Don't have an account?</a></p>
   			<input type="submit" value="GO!" onclick=" return submitForm(this,event)">
   		</div>
    </form>
 	</div>
</body>
</html>