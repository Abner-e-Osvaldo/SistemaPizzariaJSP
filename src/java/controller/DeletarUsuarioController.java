
package controller;

import dao.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class DeletarUsuarioController extends HttpServlet {

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String funcao = request.getParameter("funcao");
        
        switch(funcao.trim())
        {
            case "opcoes":
                mostrarOpcoes(request, response);
                break;
                
            case "deletar":
                int id = Integer.parseInt(request.getParameter("tId"));
                UsuarioDAO udao = new UsuarioDAO();
                udao.deletarUsuario(id);
                request.getRequestDispatcher("index.html").forward(request, response);
                break;
        }
        
        
    }
    
    public void mostrarOpcoes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        UsuarioDAO udao = new UsuarioDAO();
        ResultSet rs = udao.listarUsuario();
        
        request.setAttribute("resultado", rs);
        
        request.getRequestDispatcher("pages/deletar.jsp").forward(request, response);
    }

    
}
