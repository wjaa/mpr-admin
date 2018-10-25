$(document).ready(function(){
});

function listLote(idProduto,o){

    $.ajax({url: "/admin/EstoqueEntity/byIdProduto/" + idProduto,
        success: function(result){
            $("#card" + idProduto).html(result);
            $(o).hide();
            $("#redunce" + idProduto).show();
            $("#tr" + idProduto).show();
        },
        error: function(result){
            $("#card" + idProduto).html("Erro na busca dos dados.");
        }
    });


}

function hideLote(idProduto, o){
    $(o).hide();
    $("#expand" + idProduto).show();
    $("#tr" + idProduto).hide();
}

