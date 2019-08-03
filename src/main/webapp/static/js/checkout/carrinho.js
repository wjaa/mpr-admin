$(document).ready(function(){
    $(".btn-remover").click(function(){
       Utils.waiting("Aguarde removendo produto...");
       var idItem = $(this).attr("id-item");
       window.location.href = "/admin/checkout/removeProduto/" + idItem;
    });

    $("#formAddCarrinho").submit(function(){
        Utils.waiting("Aguarde adicionando produto...");

        return true;
    });

});

function selectImg(idCatalogo, imgUrl){
    $('#modalImagensExclusivas').modal('hide');
    $("#imgCatalogo").show();
    $("#imgCatalogo img").attr("src",imgUrl);
    $("#idCatalogo").val(idCatalogo);
}