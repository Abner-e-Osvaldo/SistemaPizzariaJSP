/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Pizza;

/**
 *
 * @author abner
 */
public class PizzaDao {
    
   Conexao conexao = new Conexao();
   private PreparedStatement statement;
   private ResultSet resultSet;
   private String query;
   
   public PizzaDao(){
       
    }  
   
   
   public void InsertPizza(Pizza pizza){
       
       try{
       query = "INSERT INTO pizza( id_tamanho,nome,descricao,tamanho,valor,acrescimo_tamanho)VALUE("+pizza.getIdTamanho()+",'"+pizza.getNome()+"' , "+" '"+pizza.getDescricao()+"',"+pizza.getValorBase()+","+pizza.getAcrescimoTamanho()+")";
       
       statement = conexao.getConnection().prepareStatement(query);
       statement.executeUpdate();
       }catch(SQLException e){
           e.printStackTrace();
       }
   }
   
    
}
