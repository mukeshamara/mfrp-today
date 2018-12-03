<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*,com.model.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2> welcome user : ${sessionScope.xyz.userid}</h2>

		<h1> Added sucessfully</h1>
		<sql:setDataSource driver="com.mysql.jdbc.Driver"

            url="jdbc:mysql://localhost:3306/mfrpproject"

            user="root" password="root"

            var="mysrc"

    />
   <%--  <% User usid=(User)session.getAttribute("xyz"); %>--%>
 
    <sql:query var="stmt" dataSource="${mysrc}">

        select * from add_to_cart;

    </sql:query>
    

    <table border='1'>

        <tr>

           <th>Book_id</th><th>Customer_id</th><th>Quantity</th>

        </tr>

        <c:forEach var="rs" items="${stmt.rows}">
	
            <tr>
				
                <td>${rs.book_id}</td>

                <td>${rs.customer_id}</td>
					
                <td><input type="text" name="quantity" value="0"/></td>
                <%-- <% String x=(String)request.getParameter("quantity"); 
				<td><input  type="checkbox" name="book_id" value="x"></td>
            </tr> --%>

        </c:forEach>
        <form action="print.do" method="post">
			<input type="submit" value="Add to Cart"/>
		</form>
		  </table>
		<%-- <a href="lo.jsp">To add more books</a> --%>
</body>
</html>