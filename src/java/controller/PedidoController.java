
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Pedido;
import dao.PedidoDao;

public class PedidoController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String opcao = request.getParameter("opcao");
        
        Pedido pedido = new Pedido();
        String cliente = request.getParameter("codCliente");
        String tamanho = request.getParameter("tamanho");
        String sabores = request.getParameter("sabores");
        int qtdeSabores = Integer.parseInt(request.getParameter("qtdeSabores"));
        
        pedido.setTamanho(tamanho);
        pedido.setSabores(sabores);
        pedido.setCodCliente(cliente);
        pedido.setQtdeSabores(qtdeSabores);
        
        switch(opcao.trim()){
            case "inserir":                
                inserir(pedido);
                request.getRequestDispatcher("pages/pedido.jsp").forward(request, response);
                break;
                
            case "listar":
                listar();
                request.getRequestDispatcher("pages/pedido.jsp").forward(request, response);
                break;
        }
        
    }
    
    public void inserir(Pedido pedido) {
        PedidoDao pedidoDao = new PedidoDao();
        pedidoDao.inserir(pedido);
    }
    
    public void encerrar(int id) {
        PedidoDao pedidoDao = new PedidoDao();
        pedidoDao.encerrar(id);
    }
    
    public void listar() {
        PedidoDao pedidoDao = new PedidoDao();
        pedidoDao.listar();
    }
    
}
