<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		
		<h2> welcome user : ${sessionScope.xyz.userid}</h2>
		
		<h2> Book you tried to add into cart is already there in the cart.Go and check in the cart</h2>
		
		<a href="userincart.jsp">Go to cart</a>
		<a href="lo.jsp"> To search another book</a>
		
</body>
</html>