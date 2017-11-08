<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="Ngo-Jek - Ojek Online Clone Website">
    <meta name="author" content="Taufan Mahaputra, Robby Syaifullah, M Rafli">
    <!-- Properties Title -->
    <link rel="shortcut icon" href="" />
    <title>Ngo-Jek</title>

    <!-- Custom CSS -->
    <link href="style/main.css" rel="stylesheet" type='text/css' />
    <link href="style/editprofile.css" rel="stylesheet" type='text/css' />

    <!-- Custom Fonts -->
    <link href="style/font-awesome.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Patua+One" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Oswald:400,500,600" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Roboto:400,500" rel="stylesheet">
    <!-- Script -->
    <script src="javascript/edit-profile.js"></script>
</head>
<body>
    <div class="container">
        <!-- Header Section -->
        <div class="profile-header">
            <h2 class="profile-title">EDIT PROFILE INFORMATION</h2>
        </div>
            
        <!-- Content Field-->
        <div class="content">
            <form name="form-edit-profile" action="../src/edit-profile.php" method="POST" enctype="multipart/form-data" onsubmit="return validateForm()">
            <input type="hidden" name="username" value="<?php echo $username ?>">
            <table>
                <tr>
                    <td>
                        <div class="img-profile">
                            <img src="<?php echo getImageProfile($con, $username); ?>" alt="User Picture" width="200" height="200">
                        </div>
                    </td>
                    <td>
                        <div class="right-side">
                            <h5> Update profile picture </h5>    
                            <input type="file" name="fileToUpload" id="fileToUpload" hidden></input>
							<input type="text" name="browse-field" onclick= "fileToUpload.click()"></input>
							<input type="button" id="clickme" value="Browse.." onclick="fileToUpload.click()" />
                      </div>
                    </td>
                </tr>
                <tr>
                    <td>Your Name</td>
                    <td><input id="name" type="text" class="right-side-box" name="name" value="<?php echo getNameUser($con, $username); ?>"></td>
                </tr>
                
                <tr>
                    <td>Phone</td>
                    <td>
                        <input id="phone" type="text" class="right-side-box" name="phone" value="<?php echo getPhoneUser($con, $username); ?>" onkeypress='return onlyNumber(event)'>
                    </td>
                </tr>
                
                <tr>
                    <td>Status Driver</td>
                    <td>
                        <label class="switch">
                            <input id="isDriver" type="checkbox" name="driver" value="YES">
                            <span class="slider round"></span>
                        </label>
                    </td>
                </tr>

                </table>
        </div>
        <br><br>
        <button class="btn-back"><a href="profile.php?user=<?php echo $username ?>"> BACK </a></button>
        <button class="btn-save" type="submit" name="submit">SAVE</button>
        </form>
        
    </div>
    <?php   echo isDriver($con, $username); 
            mysqli_close($con);
    ?>
</body>
</html>