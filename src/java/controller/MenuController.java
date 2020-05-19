
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
            case "cadastrar":
                request.getRequestDispatcher("pages/cadastrar.html").forward(request, response);
                break;
            
            case "listar":
                request.getServletContext().getRequestDispatcher("/ListarUsuarioController").forward(request, response);
                break;
                
            case "editar":
                request.getServletContext().getRequestDispatcher("/EditarUsuarioController?funcao=opcoes").forward(request, response);
                break;
                
            case "deletar":
                request.getServletContext().getRequestDispatcher("/DeletarUsuarioController?funcao=opcoes").forward(request, response);
                break;
        }
    }

}
