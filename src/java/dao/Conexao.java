
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private Connection conn;
    private String banco = "jdbc:mysql://127.0.0.1:8889/bancobsi?useSSL=false";

    public Conexao(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(banco, "root", "root");
        }
        catch(ClassNotFoundException ex){
             ex.printStackTrace();
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }

    public Connection getConnection(){
        return conn;
    }
}