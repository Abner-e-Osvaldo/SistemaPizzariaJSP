
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

    private Usuario user;
    private UsuarioDAO daoUser;
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String nome = request.getParameter("nome").toString().trim();
        String sobrenome = request.getParameter("sobrenome").toString().trim();
        String senha = request.getParameter("senha").toString().trim();
        String senhaConfirm = request.getParameter("senhaConfirm").toString().trim();
        String email = request.getParameter("email").toString().trim();
        if(senha.equals(senhaConfirm)){
            user = new Usuario(nome,sobrenome,senha,email);
            daoUser = new UsuarioDAO();
            daoUser.inserirUsuario(user);
             request.getRequestDispatcher("index.html").forward(request, response);
        }else{
            request.getRequestDispatcher("register.html").forward(request, response);
        }
       
       
        
    }

}
