
package model;

public class Pedido {
    
    int idPedido;
    int idCliente;
    int pizza;
    int tamanho;
    String observacao;
    double total;
    int status;
    
    String pizzaTexto;
    String tamanhoTexto;
    String statusTexto;
    
    double totalValue;
    int totalCount;

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getPizza() {
        return pizza;
    }

    public void setPizza(int pizza) {
        this.pizza = pizza;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
        
        if(tamanho == 1) 
            setTamanhoTexto("BROTO");
        
        if(tamanho == 2) 
            setTamanhoTexto("PEQUENA");
        
        if(tamanho == 3) 
            setTamanhoTexto("MÉDIA");
        
        if(tamanho == 4) 
            setTamanhoTexto("GRANDE");
        
        if(tamanho == 5) 
            setTamanhoTexto("BIG");
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
        
        if(status == 1) 
            setStatusTexto("EM ATENDIMENTO");
        
        if(status == 2) 
            setStatusTexto("CANCELADO");
        
        if(status == 3) 
            setStatusTexto("COMPLETO");
    }

    public String getPizzaTexto() {
        return pizzaTexto;
    }

    public void setPizzaTexto(String pizzaTexto) {
        this.pizzaTexto = pizzaTexto;
    }

    public String getTamanhoTexto() {
        return tamanhoTexto;
    }

    public void setTamanhoTexto(String tamanhoTexto) {
        this.tamanhoTexto = tamanhoTexto;
    }

    public String getStatusTexto() {
        return statusTexto;
    }

    public void setStatusTexto(String statusTexto) {
        this.statusTexto = statusTexto;
    }

    public double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(double totalValue) {
        this.totalValue = totalValue;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

}
