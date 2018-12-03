
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Home Page</title>

</head>
 

<body>
<%--
<% 
User name=(User)session.getAttribute("xyz"); 
		
out.print("Hello User: You have entered the name: "+name);
%>
 --%>
 

    <sql:setDataSource driver="com.mysql.jdbc.Driver"

            url="jdbc:mysql://localhost:3306/mfrpproject"

            user="root" password="root"

            var="mysrc"

    />

   

 

    <sql:query var="stmt" dataSource="${mysrc}">

        select * from customer_registration where category_name='';

    </sql:query>
    <form action="cart.do" method="post">

    <table border='1'>

        <tr>
           <th>click here</th> <th>User Id</th><th>User Name</th><th>Address</th>

        </tr>

        <c:forEach var="rs" items="${stmt.rows}">
	
            <tr>
				<td><input  type="checkbox" name="book_id" value="${rs.book_id}"></td>
                <td>${rs.category_name}</td>

                <td>${rs.book_id}</td>
					
                <td>${rs.book_name}</td>
				<td>
				
		<td/>
            </tr>

        </c:forEach>
        
        	
			<input type="submit" value="Add to Cart"/>
		</form>

    </table>

  </body>

</html>

