<%-- 
    Document   : listar.jsp
    Created on : May 17, 2020, 4:05:35 PM
    Author     : z004324c
--%>

<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <%
            ResultSet resultSet = (ResultSet) request.getAttribute("resultado");
                
            while(resultSet.next())
            {
                out.print("Nome: " + resultSet.getString("nome") + "<br>");
            }
            
        %>
        <br><br>
        <a href="Dashboard.html"> <button> Voltar </button> </a>
        
        
    </body>
</html>
