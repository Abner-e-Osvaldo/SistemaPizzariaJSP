/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Usuario;

/**
 *
 * @author abner
 */
public class LoginController extends HttpServlet {
    Usuario user ;
    UsuarioDAO daoUser;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
      String opcao = request.getParameter("opcao");
       switch (opcao.trim()){
           case "login":
                String login = request.getParameter("email");
                String senha = request.getParameter("password");
                HttpSession session = request.getSession();
                user = new Usuario();
                user.setEmail(login);
                user.setSenha(senha);
                daoUser= new UsuarioDAO();
                ResultSet rs = daoUser.listarUsuario(user);
                try{
                    
                if(rs.next()){
                    if(rs.getString("email").equals(login) && rs.getString("senha").equals(senha)){
                        session.setAttribute("user",rs.getString("nome"));
                        request.getRequestDispatcher("pages/dashboard.jsp").forward(request, response);                         
                    }
                }else{
                     session.invalidate();  
                    request.getRequestDispatcher("index.html").forward(request, response);
                }
                
                }catch(SQLException e){
                    e.printStackTrace();
                }
                   
                break;
                
           case "cadastro":
                request.getRequestDispatcher("pages/register.html").forward(request, response);
                break;
       } 
        
     
      
         
      
    }

   
}
