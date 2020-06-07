
var pedido = {
  
  init: function() {
      
      $("#formpedido").attr('action', ''); 
      
      $("#btn-inserir").on('click', function() {
          $("#formpedido").attr('action', 'PedidoController?opcao=inserir');
          $("#formpedido").submit();
      });
      
      $("#btn-atualizar").on('click', function() {
         $("#formpedido").attr('action', 'PedidoController?opcao=alterar'); 
         $("#formpedido").submit();
      });
      
      $("#pizza").on('change', function() {
        pedido.calculaTotal();
      });
      
      $("#tamanho").on('change', function() {
        pedido.calculaTotal();
      });
      
  },
  
  editar: function(btnDOM) {
      
      let linha = $(btnDOM).parent().parent();
      let idPedido = linha[0].querySelectorAll('[name=idPedido-list]')[0].getAttribute('value');
      let idCliente = linha[0].querySelectorAll('[name=idCliente-list]')[0].getAttribute('value');
      let status = linha[0].querySelectorAll('[name=status-list]')[0].getAttribute('value');
      let pizza = linha[0].querySelectorAll('[name=pizza-list]')[0].getAttribute('value');
      let tamanho = linha[0].querySelectorAll('[name=tamanho-list]')[0].getAttribute('value');
      let observacao = linha[0].querySelectorAll('[name=observacao-list]')[0].getAttribute('value');
      let total = linha[0].querySelectorAll('[name=total-list]')[0].getAttribute('value');
      
      $("#idPedido").val(idPedido);
      $("#idCliente").val(idCliente);
      $("#status").val(status);
      $("#pizza").val(pizza);
      $("#tamanho").val(tamanho);
      $("#observacao").val(observacao);
      $("#total").val(total);
      
  },
  
  calculaTotal: function() {
      let pizza = parseInt($("#pizza").val());
      let tamanho = parseInt($("#tamanho").val());
      let taxa = 13.72;
      let total = pizza + tamanho + taxa;
      $("#total").val(total);
  }
    
};

$(function() {
    pedido.init();
});