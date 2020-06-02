/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author abner
 */
public class Pizza {
    
    private String nome;
    private String descricao;
    private double valorBase;
    private double acrescimoTamanho;
    private int idTamanho;

    
    public Pizza() {
    }

    public Pizza(String nome, String descricao, double valorBase, double acrescimoTamanho, int idTamanho) {
        this.nome = nome;
        this.descricao = descricao;
        this.valorBase = valorBase;
        this.acrescimoTamanho = acrescimoTamanho;
        this.idTamanho = idTamanho;
    }
    
    

    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


    public double getValorBase() {
        return valorBase;
    }

    public void setValorBase(double valorBase) {
        this.valorBase = valorBase;
    }

    public double getAcrescimoTamanho() {
        return acrescimoTamanho;
    }

    public void setAcrescimoTamanho(double acrescimoTamanho) {
        this.acrescimoTamanho = acrescimoTamanho;
    }

    public int getIdTamanho() {
        return idTamanho;
    }

    public void setIdTamanho(int idTamanho) {
        this.idTamanho = idTamanho;
    }
    
    
    
    
    
    
    
    

    
}
