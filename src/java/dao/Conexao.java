
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private static Conexao instance;
    private Connection conn;
    
    private String servidor = "ec2-3-91-139-25.compute-1.amazonaws.com:5432/";
    private String banco = "ddimd85appvo38";
    private String configs = "?useSSL=false";
    private String uri = "jdbc:postgresql://" + servidor + banco + configs;
    
    private String usuario = "kzzgfsfhurfymx";
    private String senha = "75b21f3236210f3a10bc37be9c8cbda72d493fe4d03937415ca85778a0b8206a";

    private Conexao(){
        try{               
            Class.forName("org.postgresql.Driver");
            this.conn = DriverManager.getConnection(uri, usuario, senha);
            System.out.println("Conexão ao banco efetuada com sucesso!");
        }
        catch(ClassNotFoundException ex){
            System.out.println("Erro ao conectar com o banco");
             ex.printStackTrace();
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }

    public Connection getConnection(){
        return conn;
    }
    
    public static Conexao getInstance() {
        try {
            if(instance == null) {
                instance = new Conexao();
            }
            else if (instance.getConnection().isClosed()) {
                instance = new Conexao();
            }
        } catch (Exception e) {
            System.out.println("dao.Conexao.getInstance(): " + e.getMessage());
        }
            
        return instance;
    }
}