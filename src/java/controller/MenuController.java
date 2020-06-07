
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class MenuController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String opcao = request.getParameter("opcao");
        
        switch(opcao.trim()){
            case "pedido":
                request.getRequestDispatcher("pages/pedido.jsp").forward(request, response);
                break;
            
            case "dashboard":
                request.getRequestDispatcher("pages/dashboard.jsp").forward(request, response);
                break;
                
            case "table":
                request.getRequestDispatcher("pages/pizza.jsp").forward(request, response);
                break;
            
        }
    }

}
