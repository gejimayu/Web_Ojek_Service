<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="register.css">
<title>Register</title>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script>
	function submitForm() {
		var driverstatus;
		if( $("#driverstatus").is(':checked')){
            driverstatus = "true";
        }else{
            driverstatus = "false";
        }
		event.preventDefault();
		var fullname = $('#fullname').val();
		var username = $('#username').val();
		var email = $('#email').val();
		var password = $('#password').val();
		var confirmpassword = $('#confirmpassword').val();
		var phonenumber = $('#phonenumber').val();
		//var driverstatus = $('#driverstatus').val();
		console.log(fullname, username, email, password, confirmpassword, phonenumber, driverstatus);
		var myData = {
			"ojekaccount": {
		    "fullname": fullname,
		    "username": username,
		    "email": email,
		    "password": password,
		    "confirmpassword": confirmpassword,
		    "phonenumber": phonenumber,
		    "driverstatus": driverstatus,
		}
		};
		
		var jsonDataObject = new Object();
		jsonDataObject.fullname = fullname;
		jsonDataObject.username = username;
		jsonDataObject.email= email;
		jsonDataObject.password = password;
		jsonDataObject.confirmpassword= confirmpassword;
		jsonDataObject.phonenumber= phonenumber;
		jsonDataObject.driverstatus= driverstatus;
	
		dataSend = JSON.stringify(jsonDataObject);
		console.log(dataSend);
		$.ajax({
			type: "POST",
			url: "http://localhost:8081/IdentityService/register",
		    data: dataSend,
		    //dataType: "json",
		    contentType: 'application/json',
		    success: function(data, status, xhr){
		    	console.log('register success');
		    	window.location.href = "http://localhost:8080/Client/selectdestination.jsp";
	        },
			error: function(data, status, xhr){
		    	console.log('username or email has already been taken');
		    	alert("username or email has already been taken");
			}
		  });
		console.log(JSON.stringify(myData));
		return false;
	}

	function checkForm() {
		// Fetching values from all input fields and storing them in variables.
		var username = document.forms["myForm"]["username"].value;
	    var email = document.forms["myForm"]["email"].value;
	    var fullname = document.forms["myForm"]["fullname"].value;
	    var password = document.forms["myForm"]["password"].value;
	    var confirmpassword = document.forms["myForm"]["confirmpassword"].value;
	    var phonenumber = document.forms["myForm"]["phonenumber"].value;
	
		//Check All Values/Informations Filled by User are Valid Or Not.If All Fields Are invalid Then Generate alert.
		if ((password == '') || (fullname == '') || (username == '') || (email == '')){
			alert("Fill All Fields");
			return false;
		}
		else if (password != confirmpassword){
			alert("Password Doesn't Match");
			return false;
		}
		else if (!(/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(email))){
			alert("Email Is Not Valid");
			return false;
		}
		else if (!(/^[0-9]{9,}$/.test(phonenumber))){
			alert("Phone Number Is Not Valid");
			return false;
		}
		else{
			submitForm();
			return true;
		}
	}
	
</script>

</head>
<body>
	<center>
		<form enctype='application/json' id="myForm" onsubmit="return checkForm()">
			<center style="font-size: 30px"><b>SIGNUP</b></center><br>
			<table>
				<tr><td>Your Name</td><td colspan="2"><input id="fullname" name="fullname" type="text" maxlength="20"/></td></tr>
				<tr><td>Username</td><td><input id="username" name="username" type="text" type="text" maxlength="20" /></td></tr>
				<tr><td>Email</td><td><input id="email" name="email" type="text" maxlength="20" /></td></tr>
				<tr><td>Password</td><td colspan="2"><input id="password" name="password" type="password" maxlength="20"/></td></tr>
				<tr><td>Confirm Password</td><td colspan="2"><input id="confirmpassword" name="confirmpassword" type="password" maxlength="20"/></td></tr>
				<tr><td>Phone Number</td><td colspan="2"><input id="phonenumber" name="phonenumber" type="text" maxlength="12"/></td></tr>
				<tr><td colspan="3"><input id="driverstatus" type="checkbox" name="driverstatus" />Also sign me up as a driver!</td></tr>
				<tr><td colspan="3" height="10"></td></tr>			
				<tr><td><a href=login.php>Already have an account?</a></td>
				<td align="right" colspan="2"><input type='submit' value="REGISTER"></td></tr>
			</table>
		</form>
	</center>
</body>
</html>