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

/**
 *
 * @author z004324c
 */
public class ListarUsuarioController extends HttpServlet {

 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        UsuarioDAO udao = new UsuarioDAO();
        ResultSet rs = udao.listarUsuario();
        
        request.setAttribute("resultado", rs);
        
        request.getRequestDispatcher("pages/listar.jsp").forward(request, response);
    }

   
}
