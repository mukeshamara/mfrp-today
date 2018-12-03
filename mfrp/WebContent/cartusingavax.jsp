<%@ page language="java" contentType="text/html; charset=ISO-8859-1"

    pageEncoding="ISO-8859-1" import="java.util.*,com.model.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Home Page</title>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

 

    <script>

        $(document).ready(function(){

        $("#fromloc").change(function(){

           

            $.ajax({

                    type: "GET",

                    url: "GetBooks",

                    data: "fromloc="+$("#fromloc").val(),

                    dataType: "text",

                    success: function(result){

                    var jd = $.parseJSON(result);

                        $(jd).each(function (index, data) {

                        var row = "";

                            row += "<tr><td>" + data.bid + "</td>";

                            row += "<td>"+data.bname+"</td>";

                            row += "<td>"+data.price+"</td>";

                            row += "<td id='tot"+index+"' >"+data.tobo+"</td>";

                            row += "<td><input type='text' name='seatcnt' id='seatcnt"+index+"'></td>";

                            row += "<td><input type='button' id='book"+index+"' value='Book' ";

                            row += "onclick='bookfun("+index+","+data.price+","+data.bid+","+data.tots+")' ";

                           row +="/></td></tr>";

                            $("#table1").append(row);

                            

                            $("#fids").append("<option value='"+data.bid+"'>"+data.bid+"</option>");

                           

                        });

                      

                    }

                

                });

        });

       

        

        });

        function bookfun(ind,pr,fno,tots)

    {

           

        var sreq = $("#seatcnt"+ind).val();  //3

        alert("Seat "+sreq+" reserved on "+fno);

       

        $.ajax({

                type: "POST",

                url: "updatedetails",

                data: "fid="+fno+"&cnt="+sreq+"&pri="+pr+"&tobooks="+tots,

                dataType: "text",

                success: function(result){

                alert(result);

                $("#tot"+ind).text(tots-sreq);

                $("#seatcnt"+ind).val("");

                }

            

               });

   

     }

    </script>

</head>

<body>

    <sql:setDataSource driver="com.mysql.jdbc.Driver"

            url="jdbc:mysql://localhost:3306/mfrpproject"

            user="root" password="root"

            var="mysrc"

    />

    <sql:query var="stmt" dataSource="${mysrc}">

        select distinct customer_id from add_to_cart where customer_id='${param.username}';

    </sql:query>

   

        From: <select name="fromloc" id="fromloc">

                <option value="none">Select...</option>

                <c:forEach var="rs" items="${stmt.rows}">

                    <option value="${rs.customer_id}">${rs.customer_id}</option>

                </c:forEach>

            </select>

            <br/>

       

        <table id="table1" border="1">

            <tr>

                <th>Flight Id</th><th>To Location</th>

                <th>Duration</th><th>Seats</th>

                <th>Seats Req</th>

                <th>Action</th>

            </tr>

           

        </table>

       			<a href="order.jsp">Pay Now</a>

           

   

    <%-- <a href="success.jsp?val=128">Click here</a>

 

    <form action="login.do" method="post">

            User name:<br>

            <input type="text" name="userid" pattern="[a-zA-Z][0-9]{5}" title="Invalid user id"> <br/>

            User password:<br/>

            <input type="password" name="psw"> <br/>

            <input type="submit" value="Login Now" /> &nbsp; &nbsp;

            <input type="reset" value="Clear Fields" />

    </form>

    <br/>

    ${errmsg}

--%>

 

 

 

   

</body>

</html>