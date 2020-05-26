
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private Connection conn;
    private String banco = "postgres://kzzgfsfhurfymx:75b21f3236210f3a10bc37be9c8cbda72d493fe4d03937415ca85778a0b8206a@ec2-3-91-139-25.compute-1.amazonaws.com:5432/ddimd85appvo38";

    public Conexao(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(banco, "kzzgfsfhurfymx", "75b21f3236210f3a10bc37be9c8cbda72d493fe4d03937415ca85778a0b8206a");
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