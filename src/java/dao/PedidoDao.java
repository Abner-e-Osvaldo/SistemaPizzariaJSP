
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Pedido;

public class PedidoDao {
    
    private Conexao conexao =  new Conexao();
    private String query;
    private PreparedStatement statement;
    private ResultSet resultSet;
    
    public PedidoDao() {
        conexao = new Conexao();
    }
    
    public void inserir(Pedido pedido){
        try {
            query = "INSERT INTO public.pedido(id_cliente, pizza, tamanho, observacao, total, status) VALUES (?, ?, ?, ?, ?, ?);";
            statement = conexao.getConnection().prepareStatement(query);
            statement.setInt(1, pedido.getIdCliente());
            statement.setInt(2, pedido.getPizza());
            statement.setInt(3, pedido.getTamanho());
            statement.setString(4, pedido.getObservacao());
            statement.setDouble(5, pedido.getTotal());
            statement.setInt(6, pedido.getStatus());
            
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void alterar(int idPedido, Pedido pedido){
        try {
            query = "UPDATE public.pedido SET id_cliente=?, pizza=?, tamanho=?, observacao=?, total=?, status=? WHERE id_pedido=" + idPedido;
            statement = conexao.getConnection().prepareStatement(query);
            statement.setInt(1, pedido.getIdCliente());
            statement.setInt(2, pedido.getPizza());
            statement.setInt(3, pedido.getTamanho());
            statement.setString(4, pedido.getObservacao());
            statement.setDouble(5, pedido.getTotal());
            statement.setInt(6, pedido.getStatus());
            
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Pedido> listar(){
        
        ArrayList<Pedido> listaPedido = new ArrayList<>();
        
        try {
            query = "SELECT * FROM pedido";
            statement = conexao.getConnection().prepareStatement(query);
            statement.executeQuery();
            resultSet = statement.executeQuery();
            
            while(resultSet.next()) {
                Pedido pedido = new Pedido();               
                
                if(resultSet.getString("id_pedido") != null)
                    pedido.setIdPedido(Integer.parseInt(resultSet.getString("id_pedido")));
                
                if(resultSet.getString("id_cliente") != null)
                    pedido.setIdCliente(Integer.parseInt(resultSet.getString("id_cliente")));
                
                if(resultSet.getString("status") != null)
                    pedido.setStatus(Integer.parseInt(resultSet.getString("status")));
                
                if(resultSet.getString("pizza") != null)
                    pedido.setPizza(Integer.parseInt(resultSet.getString("pizza")));
                
                if(resultSet.getString("tamanho") != null)
                    pedido.setTamanho(Integer.parseInt(resultSet.getString("tamanho")));
                
                if(resultSet.getString("observacao") != null)
                    pedido.setObservacao(resultSet.getString("observacao"));
                
                if(resultSet.getString("total") != null)
                    pedido.setTotal(Double.parseDouble(resultSet.getString("total")));
                
                listaPedido.add(pedido);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaPedido;
    }
    
    public void encerrar(int id){
        try{
            query = "DELETE FROM pedido WHERE id = " + id;
        
            statement = conexao.getConnection().prepareStatement(query);
            statement.executeUpdate();
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
    }
    
}
