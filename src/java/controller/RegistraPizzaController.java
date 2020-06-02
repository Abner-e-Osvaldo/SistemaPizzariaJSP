/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author abner
 */
public class RegistraPizzaController extends HttpServlet {

    

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String  nomePizza = request.getParameter("nomePizza").toString().trim();
        String  descricaoPizza = request.getParameter("descricaoPizza").toString().trim();
        String  tamanhoPizza = request.getParameter("tamanhoPizza").toString().trim();
        double  valorPizza = Integer.parseInt(request.getParameter("valorPizza").toString().trim()); 
        double  acrescimoPizza = Integer.parseInt(request.getParameter("acrescimoPizza").toString().trim());
        
           request.getRequestDispatcher("pages/table.html").forward(request, response);
        
    }


}
