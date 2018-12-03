<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
			${errmsg1}
		<h2 Customer id: ${sessionScope.xyz.userid}></h2>
		<h2> Total price: <% request.getAttribute("toprice");%></h2>
			
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
  background-image:linear-gradient(rgba(0,0,0,0.1),rgba(0,0,0,0.1)),url(image.jpg);

 

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
Order Payment
</font>
</h1>
</div>
<div class="container">
<form action="payment.do" onsubmit="return validateForm()" method="post">
<div class="form-group row">
    <label for="id"  class="col-sm-2 col-form-label">
    <font color="black">
   
    Customer ID
     </font>
    </label>
    
    <div class="col-sm-6">
      ${sessionScope.xyz.userid}
      
    </div>
</div>
<div class="form-group row">
    <label for="text"  class="col-sm-2 col-form-label">
    <font color="black">
   
    Total Cost
     </font>
    </label>
    
    <div class="col-sm-6">
     

${sessionScope.toprice}

    </div>
</div>
<div class="form-group row">
    <label for="text"  class="col-sm-2 col-form-label">
    <font color="black">
   
    Account Number
     </font>
    </label>
    
    <div class="col-sm-6">
      <input type="text" class="form-control" name="acc_no" id="name" required />
    </div>
</div>
<div class="form-group row">
    <label for="text"  class="col-sm-2 col-form-label">
    <font color="black">
   
    Bank Name
     </font>
    </label>
    
    <div class="col-sm-6">
      <input type="text" class="form-control" name="bank_name" id="name" required />
    </div>
</div>
<div class="form-group row">
    <label for="text"  class="col-sm-2 col-form-label">
    <font color="black">
   
    Bank IFSC Code
     </font>
    </label>
    
    <div class="col-sm-6">
      <input type="text" class="form-control" name="ifsc_code" id="name" required />
    </div>
</div>
<div class="form-group row">
    <label for="text"  class="col-sm-2 col-form-label">
    <font color="black">
   
    Payment Amount
     </font>
    </label>
    
    <div class="col-sm-6">
      <input type="text" class="form-control" name="amount" id="name" required />
    </div>
</div>
<p>
</p>
<div class="form-group container" style="display: inline-block;">
<input class="btn btn-success" type="submit" value="Pay Now" />
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