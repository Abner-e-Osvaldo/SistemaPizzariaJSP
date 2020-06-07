$(document).ready(function(){
   
    $('#exampleModal').on('show.bs.modal', function (event) {
  var button = $(event.relatedTarget) // Button that triggered the modal
  var recipient = button.data('whatever') // Extract info from data-* attributes
  // If necessary, you could initiate an AJAX request here (and then do the updating in a callback).
  // Update the modal's content. We'll use jQuery here, but you could use a data binding library or other methods instead.
  var modal = $(this)
  
  modal.find('.modal-body input').val(recipient)
})


  $('#exampleModal2').on('show.bs.modal', function (event) {
      
      
  var button = $(event.relatedTarget);
  
  const idPizza = button[0].parentElement.parentElement.getAttribute('value');
  const nome = button[0].parentElement.parentElement.querySelectorAll('td')[0].innerText;
  const descricao = button[0].parentElement.parentElement.querySelectorAll('td')[1].innerText; 
  const tamanho = button[0].parentElement.parentElement.querySelectorAll('td')[2].getAttribute('value');
  const valorBase = button[0].parentElement.parentElement.querySelectorAll('td')[3].innerText;
  const acrescimoTamanho = button[0].parentElement.parentElement.querySelectorAll('td')[4].innerText;
  
   var recipient = button.data('whatever') // Extract info from data-* attributes
  // If necessary, you could initiate an AJAX request here (and then do the updating in a callback).
  // Update the modal's content. We'll use jQuery here, but you could use a data binding library or other methods instead.
  var modal = $(this)
  
  modal.find('.modal-body input').val(recipient);
  
  $("[name=nomePizzaEdit]").val(nome);
  $("[name=descricaoPizzaEdit]").val(descricao);
  $("[name=valorPizzaEdit]").val(valorBase);
  $("[name=acrescimoPizzaEdit]").val(acrescimoTamanho);
  $("[name=tamanhoPizzaEdit]").val(tamanho);
  $("[name=idPizza]").val(idPizza);

  
 
 /* document.getElementsByName('descricaoPizzaEdit')[0].value=descricao;
  document.getElementsByName('valorPizzaEdit')[0].value=valorBase;
  document.getElementsByName('acrescimoPizzaEdit')[0].value=acrescimoTamanho;
  */
  
  
  
  // Button that triggered the modal
 
})

    
    
    
});