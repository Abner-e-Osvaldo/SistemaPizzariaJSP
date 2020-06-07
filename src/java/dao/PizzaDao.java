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
       query ="INSERT INTO pizza (id_tamanho, nome, descricao, valor, acrescimo_tamanho) VALUES"
            + "("+pizza.getIdTamanho()+",'"+pizza.getNome()+"','"+pizza.getDescricao()+"',"+pizza.getValorBase()+","+pizza.getAcrescimoTamanho()+");";
       
       

    
       statement = conexao.getConnection().prepareStatement(query);
       statement.executeUpdate();
       }catch(SQLException e){
           e.printStackTrace();
       }
   }
   
   public ResultSet ListarPizza(){
       query = "SELECT	id_pizza"
                   + ",nome"
                   +" , tamanho"
                   +", descricao"
                   +", valor"
                   +", acrescimo_tamanho "
               +"FROM pizza"
                  +", tamanho "
               +"where tamanho.id_tamanho = pizza.id_tamanho"
               + " ORDER BY"
               + " nome ASC;";
       try{
           statement = conexao.getConnection().prepareStatement(query);
           resultSet = statement.executeQuery();
           
       }catch(SQLException e){
           e.printStackTrace();
       }
       return resultSet;
   }
   
   public void AtualizarPizza (Pizza pizza){
        query ="UPDATE pizza SET id_tamanho = "+pizza.getIdTamanho()+", nome = '"+pizza.getNome()+"', descricao =  '"+pizza.getDescricao()+"', valor = "+pizza.getValorBase()+", acrescimo_tamanho = "+pizza.getAcrescimoTamanho()+" WHERE id_pizza ="+pizza.getIdPizza() +";";
        try{
        statement = conexao.getConnection().prepareStatement(query);
        statement.executeUpdate();
        
        }catch(SQLException e){
            e.printStackTrace();
        }
   }
   
    
}
