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

${errmsg2}
${errmsg3}
<h2> Your order no is: ${sessionScope.or_id}</h2>
<h3> The ordered books are</h3>
<sql:setDataSource driver="com.mysql.jdbc.Driver"

            url="jdbc:mysql://localhost:3306/mfrpproject"

            user="root" password="root"

            var="mysrc"

    />

   



    <sql:query var="stmt" dataSource="${mysrc}">

        select p.book_id,p.book_name,p.Language,p.Delivery_Time,p.Author_Name,p.price,a.quantity_needed from product p join add_to_cart a on(a.book_id=p.book_id) where a.price_per_book>0;

    </sql:query>
    
    <table border='1'>

        <tr>

           <th>Book Id</th><th>Book Name</th><th>Language</th><th>Delivery_Time</th><th>Author Name</th><th>Price of the Book</th><th>Quantity Ordered</th><th>Status</th>

        </tr>

        <c:forEach var="rs" items="${stmt.rows}">
	
            <tr>
				
                

                <td>${rs.book_id}</td>
					
                <td>${rs.book_name}</td>
                
                <td>${rs.Language}</td>
                <td>${rs.Delivery_Time}</td>
                <td>${rs.Author_Name}</td>
                <td>${rs.price}</td>
                <td>${rs.quantity_needed}</td>
               <td> <h3> Ordered </h3></td>
				<td>
				
		<td/>
            </tr>

        </c:forEach>
        
	

    </table>
    <form action="cancel.jsp">
    	<h2> If you want to cancel the ordered books press below icon</h2>
    	<input type="submit" value="Cancel the order"/><br/>
		</form>
  </body>

</html>





</body>
</html>