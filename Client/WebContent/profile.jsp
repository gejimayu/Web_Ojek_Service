<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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

 	<div class="container">
    <!-- navbar -->
    <div class="navbar">
      <img src="assets/image/yesbos.png" class="logo">
      <div class="logout">
        <p style="margin-bottom: 2px;">Hi, <strong>username</strong> !</p>
        <a href="index.php">Logout</a>
      </div>
    </div>

    <!-- navigation -->
    <div class="header" id="header">
          <nav>
            <ul>
              <li><a href="sel-destination.jsp">ORDER</a></li>
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
          <h3 style="margin-bottom: 5px;">@username></h3>
          nama user<br>
          status driver
          <br>
          <i class="fa fa-envelope-o" aria-hidden="true">&nbsp; username</i><br>
          <i class="fa fa-phone" aria-hidden="true">&nbsp; phone number</i>
        </div>
    </div>

    <!-- preferred-location -->
    <?php echo ListPreferredLocation($con, $username) ?>

  </div>




</body>
</html>