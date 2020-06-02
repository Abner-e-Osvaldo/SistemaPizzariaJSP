
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Pedido;

public class PedidoDao {
    
    private Conexao conexao;
    private String query;
    private PreparedStatement statement;
    private ResultSet resultSet;
    
    public PedidoDao() {
        conexao = new Conexao();
    }
    
    public void inserir(Pedido pedido){
        try {
            query = "INSERT INTO pedido(codCliente, tamanho, qtdeSabores, sabores) VALUES (" +"'"+ pedido.getCodCliente() + "'," + "'"+ pedido.getTamanho() + "',"
                    + "'"+ pedido.getQtdeSabores() + "'," + pedido.getSabores() + ")";

            statement = conexao.getConnection().prepareStatement(query);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet listar(){
        try {
            query = "SELECT * FROM pedido";
            statement = conexao.getConnection().prepareStatement(query);
            statement.executeQuery();
            resultSet = statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultSet;
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
