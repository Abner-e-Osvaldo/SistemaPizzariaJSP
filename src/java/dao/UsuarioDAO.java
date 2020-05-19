
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Usuario;

public class UsuarioDAO {

    private Conexao conexao;
    private String query;
    private PreparedStatement statement;
    private ResultSet resultSet;

    public UsuarioDAO() {
        conexao = new Conexao();
    }

    public void inserirUsuario(Usuario usuario){
        try {
            query = "INSERT INTO usuario(nome,email,senha,idade) VALUES (" +"'"+ usuario.getNome() + "'," + "'"+ usuario.getEmail() + "',"
                    + "'"+ usuario.getSenha() + "'," + usuario.getIdade() + ")";

            statement = conexao.getConnection().prepareStatement(query);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet listarUsuario(){
        try {
            query = "SELECT * FROM usuario";
            statement = conexao.getConnection().prepareStatement(query);
            statement.executeQuery();
            resultSet = statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultSet;
    }
    
    public void editarUsuario(int id, Usuario u){
        try{
            query = "UPDATE usuario SET nome='" + u.getNome() + "', email='" + u.getEmail() + "' " +
                        "WHERE id = " + id;
        
            statement = conexao.getConnection().prepareStatement(query);
            statement.executeUpdate();
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    public void deletarUsuario(int id){
        try{
            query = "DELETE FROM usuario WHERE id = " + id;
        
            statement = conexao.getConnection().prepareStatement(query);
            statement.executeUpdate();
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
    }

   
}


