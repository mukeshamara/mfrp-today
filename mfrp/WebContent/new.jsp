<%--  <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<h2>New User</h2>
		<form action="newus.do" method="post">
		Name: <input type="text" name="name"/><br/>
		Date-Of-Birth: <input type="date" name="dob"/><br/>
		Password: <input type="text" name="pass" /><br/>
		Contact-Number: <input type="text" name="number" /><br/>
		Email: <input type="text" name="email"/><br/>
		<input type="submit" value="submit"/><br/>
		
</body>
</html>
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="../css/bootstrap.css">
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script type="text/javascript" src="../js/bootstrap.min.js"></script>

<style type="text/css">
body {
  background-image:linear-gradient(rgba(0,0,0,0.1),rgba(0,0,0,0.1)),url("image.jpg");

 

       height:100vh;

 

       background-size:cover;

 

       background-position:center;
}
label {
font-weight: bold;
}
</style>
</head>
<body>
<div class="row">
<div class="container offset-md-6 col-lg-6" style="background-color: rgba(0, 0, 0, 0); color: white;">
<div class="container" style="padding: 30px;">
<h1>
<font color="black">
Registration Page
</font>
</h1>
</div>
<div class="container" style="padding-bottom: 10px;">
<font color="black">
Already have an account?</font> &nbsp;<a href="lo.jsp">Login</a>
</div>
<div class="container">
<form action="newus.do" onsubmit="return validateForm()" method="post">
<div class="form-group row">
    <label for="name"  class="col-sm-2 col-form-label">
    <font color="black">
   
    Name
     </font>
    </label>
    
    <div class="col-sm-6">
      <input type="text" class="form-control" name="name" id="name" placeholder="Enter your name" required />
    </div>
</div>
<div class="form-group row">
<label for="password" class="col-sm-2 col-form-label">
<font color="black">
Password
</font>
</label>
<div class="col-sm-6">
<input type="password" id="password" name="pass" class="form-control" aria-describedby="passwordHelp" required  pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*\W).{6,10}" />
<small id="passwordHelp" class="form-text text-muted">
<span style="color: red;">
Password length must be between 6 and 10 characters. <br/> 
Use at least 1 upper case,1 lower case, 1 digit.
</span>
</small>
</div> 
</div>
<div class="form-group row">
<label for="confirmPassword" class="col-sm-2 col-form-label">
<font color="black">
Confirm Password
</font>
</label>
<div class="col-sm-6">
<input type="password" id="confirmPassword" name="confirmPassword" class="form-control" id="confirmPassword"  aria-describedby="confirmPasswordHelp" required >
<small id="confirmPasswordHelp" class="form-text text-muted">
<span id="errmsg"></span> 
</small>
</div> 
</div>
<div class="form-group row">
<label for="DOB" class="col-sm-2 col-form-label">
<font color="black">
DOB
</font>
</label>
<div class="col-sm-6">
<input id="dob" name="dob" type="date" class="form-control" required />
</div>
</div>
<div class="form-group row">
<label for="Contact Number" class="col-sm-2 col-form-label">
<font color="black">
Contact Number
</font>
</label>
<div class="col-sm-6">
<input type="tel" name="number"  id="number" class="form-control" required />
</div>
</div>
<div class="form-group row">
<label for="email" class="col-sm-2 col-form-label">
<font color="black">
Email
</font>
</label>
<div class="col-sm-6">
<input id=email type="email" name="email" class="form-control" placeholder="Enter your email"  required  pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$"/>
</div>
</div>
<p>
</p>
<div class="form-group container" style="display: inline-block;">
<input class="btn btn-success" type="submit" value="Register" />
<input class="btn btn-light" type="reset" value="Reset" />
</div>
</form>
</div>
</div>
</div>
<script>
function validateForm() {
var psw1 = document.getElementById("password").value;
var psw2 = document.getElementById("confirmPassword").value;
if(psw1 != psw2) { 
document.getElementById("errmsg").innerHTML = "<font color=red>Passwords do not match!</font>";
return false;
}
}
</script>
</body>
</html>