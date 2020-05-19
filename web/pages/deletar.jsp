<%-- 
    Document   : editar.jsp
    Created on : May 18, 2020, 6:13:14 PM
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
                out.print("ID: " + resultSet.getString("id") +  " | Nome: " + resultSet.getString("nome") + "<br>");
            }
            
        %>
        <br><br>
        
        <form method="POST" action="DeletarUsuarioController?funcao=deletar">
            Digite o ID que deseja deletar: <input type="text" name="tId" size="3" /> 
            <input type="submit" value="Deletar"/>
        </form>
        
    </body>
</html>
