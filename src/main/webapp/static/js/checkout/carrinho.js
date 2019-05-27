$(document).ready(function(){
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

    $("#btnCalculoFrete").click(function(){
       Utils.waiting("Aguarde calculando frente...");
       var cep = $(this).attr("id-item");
       var idCliente = $(this).attr("id-cliente");
       window.location.href = "/admin/checkout/removeProduto/" + idItem + "/" + idCliente;
    });

});

function selectImg(idCatalogo, imgUrl){
    $('#modalImagensExclusivas').modal('hide');
    $("#imgCatalogo").show();
    $("#imgCatalogo img").attr("src",imgUrl);
    $("#idCatalogo").val(idCatalogo);
}