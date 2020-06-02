
package model;

public class Pedido {
    
    String codCliente;
    String tamanho;
    int qtdeSabores;
    String sabores;

    public String getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(String codCliente) {
        this.codCliente = codCliente;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public int getQtdeSabores() {
        return qtdeSabores;
    }

    public void setQtdeSabores(int qtdeSabores) {
        this.qtdeSabores = qtdeSabores;
    }

    public String getSabores() {
        return sabores;
    }

    public void setSabores(String sabores) {
        this.sabores = sabores;
    }
    
    
    
}
