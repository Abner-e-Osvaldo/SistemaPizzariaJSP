
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Pedido;
import dao.PedidoDao;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

public class PedidoController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String idPedido = request.getParameter("idPedido");
        String idCliente = request.getParameter("idCliente");
        String status = request.getParameter("status");
        String pizza = request.getParameter("pizza");
        String tamanho = request.getParameter("tamanho");
        String observacao = request.getParameter("observacao");
        String total = request.getParameter("total");
        
        Pedido pedido = new Pedido();
        if(idPedido != "") {
            pedido.setIdPedido(Integer.parseInt(idPedido));
        }
        pedido.setIdCliente(Integer.parseInt(idCliente));
        pedido.setStatus(Integer.parseInt(status));
        pedido.setPizza(Integer.parseInt(pizza));
        pedido.setTamanho(Integer.parseInt(tamanho));
        pedido.setObservacao(observacao);
        pedido.setTotal(Double.parseDouble(total));
        
        String opcao = request.getParameter("opcao");
        switch(opcao.trim()){
            case "inserir":   

                if(!validarPedido(pedido))
                    return;
                
                inserir(pedido);
                //request.setAttribute("listaPedido", listar());
                request.getRequestDispatcher("pages/pedido.jsp").forward(request, response);
                
                break;
                
            case "alterar":
                alterar(pedido);
                //request.setAttribute("listaPedido", listar());
                request.getRequestDispatcher("pages/pedido.jsp").forward(request, response);
                break;
                
            case "listar":
                request.setAttribute("listaPedido", listar());
                request.getRequestDispatcher("pages/pedido.jsp").forward(request, response);
                break;
        }
        
    }
    
    public void inserir(Pedido pedido) {
        PedidoDao pedidoDao = new PedidoDao();
        pedidoDao.inserir(pedido);
    }
    
    public void alterar(Pedido pedido) {
        PedidoDao pedidoDao = new PedidoDao();
        pedidoDao.alterar(pedido.getIdPedido(), pedido);
    }
    
    public void encerrar(int id) {
        PedidoDao pedidoDao = new PedidoDao();
        pedidoDao.encerrar(id);
    }
    
    public ArrayList<Pedido> listar() {
        PedidoDao pedidoDao = new PedidoDao();
        ArrayList<Pedido> listaPedido = pedidoDao.listar();
        return listaPedido;
    }
    
    public boolean validarPedido(Pedido pedido) {
        
        boolean validaPedido = true;
        
        if(pedido.getIdCliente() == 0) {
            validaPedido = false;
        }
        
        return validaPedido;
    }
    
    
    public Double lucroTotal() {
        Pedido pedido = new Pedido();
        int statusConcluido = 3;
        pedido.setStatus(statusConcluido);
        
        PedidoDao pedidoDao = new PedidoDao();
        ArrayList<Pedido> listaPedido = pedidoDao.listarQuery(pedido);
        
        double lucroTotal = 0;
        for(Pedido ped : listaPedido) {
            lucroTotal += ped.getTotal();
        }
        
        return lucroTotal;
    }
    
    public int realizadosComSucesso() {
        Pedido pedido = new Pedido();
        int statusConcluido = 3;
        pedido.setStatus(statusConcluido);
        
        PedidoDao pedidoDao = new PedidoDao();
        ArrayList<Pedido> listaPedido = pedidoDao.listarQuery(pedido);
        
        return listaPedido.size();
    }
    
    
    public Double lucroEstimado() {
        Pedido pedido = new Pedido();
        int statusEmAndamento = 1;
        pedido.setStatus(statusEmAndamento);
        
        PedidoDao pedidoDao = new PedidoDao();
        ArrayList<Pedido> listaPedido = pedidoDao.listarQuery(pedido);
        
        double lucroEstimado = 0;
        for(Pedido ped : listaPedido) {
            lucroEstimado += ped.getTotal();
        }
        
        return lucroEstimado;
    }
    
    public int emAndamento() {
        Pedido pedido = new Pedido();
        int statusEmAndamento = 1;
        pedido.setStatus(statusEmAndamento);
        
        PedidoDao pedidoDao = new PedidoDao();
        ArrayList<Pedido> listaPedido = pedidoDao.listarQuery(pedido);
        
        return listaPedido.size();
    }
    
    
    public Double prejuizoTotal() {
        Pedido pedido = new Pedido();
        int statusCancelado = 2;
        pedido.setStatus(statusCancelado);
        
        PedidoDao pedidoDao = new PedidoDao();
        ArrayList<Pedido> listaPedido = pedidoDao.listarQuery(pedido);
        
        double prejuizoTotal = 0;
        for(Pedido ped : listaPedido) {
            prejuizoTotal += ped.getTotal();
        }
        
        return prejuizoTotal;
    }
    
     public int cancelados() {
        Pedido pedido = new Pedido();
        int statusCancelado = 2;
        pedido.setStatus(statusCancelado);
        
        PedidoDao pedidoDao = new PedidoDao();
        ArrayList<Pedido> listaPedido = pedidoDao.listarQuery(pedido);
        
        return listaPedido.size();
    }
         
}
