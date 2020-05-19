<%-- 
    Document   : editar
    Created on : May 18, 2020, 6:30:04 PM
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
                out.print("ID: " + resultSet.getString("id") +  " | Nome: " + resultSet.getString("nome") +  " | Email " + resultSet.getString("email") + "<br>");
            }
            
        %>
        <br><br>
        
        <form method="POST" action="EditarUsuarioController?funcao=editar">
            Digite o ID que deseja editar <input type="text" name="tId" size="3" />  <br>
            
            Nome: <input type="text" name="tNome" size="10" /> <br>
            Email <input type="text" name="tEmail" size="20" /> <br>
            
            <br>
            
            <input type="submit" value="Editar"/>
            
        </form>
    </body>
</html>
