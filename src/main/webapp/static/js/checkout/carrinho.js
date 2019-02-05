$(document).ready(function(){
    //Utils.showAlert("Teste Errrooo...");
    $(".btn-remover").click(function(){
       Utils.waiting("Aguarde removendo produto...");
       var idItem = $(this).attr("id-item");
       var idCliente = $(this).attr("id-cliente");
       window.location.href = "/admin/checkout/removeProduto/" + idItem + "/" + idCliente;
    });

    $("#formAddCarrinho").submit(function(){
        Utils.waiting("Aguarde adicionando produto...");

        return true;
    });

});