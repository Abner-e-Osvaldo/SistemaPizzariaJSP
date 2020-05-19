
package controller;

import dao.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Usuario;


public class CadastrarUsuarioController extends HttpServlet {

    private Usuario u;
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String nome = request.getParameter("tNome").toString().trim();
        String senha = request.getParameter("tSenha").toString().trim();
        int idade = Integer.parseInt(request.getParameter("tIdade").toString().trim());
        String email = request.getParameter("tEmail").toString().trim();
        
        u = new Usuario(nome, senha, idade, email); 
       
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        usuarioDAO.inserirUsuario(u);
        
        request.getRequestDispatcher("index.html").forward(request, response);
        
        
    }

}
