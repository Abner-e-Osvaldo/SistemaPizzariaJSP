/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.PizzaDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Pizza;

/**
 *
 * @author abner
 */
public class RegistraPizzaController extends HttpServlet {
    PizzaDao pizzadao;
    ResultSet rs;
    String  nomePizza;
    String  descricaoPizza;
    int  tamanhoPizza;
    double  valorPizza;
    double  acrescimoPizza;
    int idPizza;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
    } 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
         String opcao = request.getParameter("opcao");
         switch(opcao.trim()){
             case "create":
                 nomePizza = request.getParameter("nomePizza").toString().trim();
                 descricaoPizza = request.getParameter("descricaoPizza").toString().trim();
                 tamanhoPizza = Integer.parseInt(request.getParameter("tamanhoPizza").toString().trim());
                 valorPizza = Double.parseDouble(request.getParameter("valorPizza").toString().trim()); 
                 acrescimoPizza = Double.parseDouble(request.getParameter("acrescimoPizza").toString().trim());
                 Pizza pizzaCreate = new Pizza(nomePizza,descricaoPizza,valorPizza,acrescimoPizza,tamanhoPizza);
                 pizzadao = new PizzaDao();
                 pizzadao.InsertPizza(pizzaCreate);
                 request.getRequestDispatcher("pages/pizza.jsp").forward(request, response);
                 break;
             case "update":
                  nomePizza      = request.getParameter("nomePizzaEdit").toString().trim();
                  descricaoPizza = request.getParameter("descricaoPizzaEdit").toString().trim();
                  tamanhoPizza   = Integer.parseInt(request.getParameter("tamanhoPizzaEdit").toString().trim());
                  valorPizza     = Double.parseDouble(request.getParameter("valorPizzaEdit").toString().trim()); 
                  acrescimoPizza = Double.parseDouble(request.getParameter("acrescimoPizzaEdit").toString().trim());
                  idPizza   = Integer.parseInt(request.getParameter("idPizza").toString().trim());
                  Pizza pizzaUpdate = new Pizza(nomePizza,descricaoPizza,valorPizza,acrescimoPizza,tamanhoPizza);
                  pizzaUpdate.setIdPizza(idPizza);
                  pizzadao = new PizzaDao();
                  pizzadao.AtualizarPizza(pizzaUpdate);
                 request.getRequestDispatcher("pages/pizza.jsp").forward(request, response);
                 break;
             case "delete":
                 idPizza = Integer.parseInt(request.getParameter("idPizzaDelete").toString().trim());
                 pizzadao = new PizzaDao();
                 pizzadao.DeletarPizza(idPizza);
                 request.getRequestDispatcher("pages/pizza.jsp").forward(request, response);
                break;
         }  
        
    }
    
    
    public ResultSet ListarPizza(){
        PizzaDao pizzadao = new PizzaDao();
        rs = pizzadao.ListarPizza();
        return rs;
    }


}
