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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Usuario;

public class EditarUsuarioController extends HttpServlet {
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         
        String funcao = request.getParameter("funcao");
        
        switch(funcao.trim())
        {
            case "opcoes":
                mostrarOpcoes(request, response);
                break;
                
            case "editar":
                int id = Integer.parseInt(request.getParameter("tId"));
                String nome = request.getParameter("tNome");
                String email = request.getParameter("tEmail");
                
                Usuario u = new Usuario(nome, "", 0, email);
                
                UsuarioDAO udao = new UsuarioDAO();
                udao.editarUsuario(id, u);
                
                
                request.getRequestDispatcher("index.html").forward(request, response);
                break;
        }
        
        
    }
    
    public void mostrarOpcoes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        UsuarioDAO udao = new UsuarioDAO();
        ResultSet rs = udao.listarUsuario();
        
        request.setAttribute("resultado", rs);
        
        request.getRequestDispatcher("pages/editar.jsp").forward(request, response);
    }

}
