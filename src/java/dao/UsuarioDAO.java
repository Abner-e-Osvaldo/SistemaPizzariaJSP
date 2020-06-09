
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
        conexao = Conexao.getInstance();
    }

    public void inserirUsuario(Usuario usuario){
        try {
            query = "INSERT INTO usuario(nome,sobrenome,email,senha) VALUES (" +"'"+ usuario.getName() + "'," + "'"+ usuario.getLastname() + "',"
                    + "'"+ usuario.getEmail() + "'," + usuario.getSenha()+ ")";

            statement = conexao.getConnection().prepareStatement(query);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet listarUsuario(Usuario user ){
        try {
            query = "SELECT * FROM usuario WHERE email= '"+user.getEmail()+"' AND senha='"+user.getSenha()+"';";
            statement = conexao.getConnection().prepareStatement(query);
            statement.executeQuery();
            resultSet = statement.executeQuery();
            
            
        } catch (SQLException e) {
            e.printStackTrace();
            
        }

        return resultSet;
    }
    

   
}


