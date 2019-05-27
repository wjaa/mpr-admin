$(document).ready(function(){
    $("#btnCalculoFrete").click(function(){
       Utils.waiting("Aguarde calculando frente...");
       var cep = $("#cep").val();
       var idProduto = $("#idProduto").val();

       $.ajax({url: "/admin/checkout/frete/calcular/" + idProduto + "/" + cep,
               success: function(freteResult){
                  $("#resultFrete").html("");
                  console.log(freteResult);

                  freteResult.forEach(function(result){
                    var tr = "<tr>" +
                              "<td>" + result.freteType + "</td>" +
                              "<td>" + result.previsaoEntrega + "</td>" +
                              "<td>" + result.diasUteis + "</td>" +
                              "<td>" + result.valor + "</td>" +
                              "<td>" + result.obs + "</td>" +
                              "<td>" + result.messageError + "</td>" +
                              "</tr>"
                              $("#resultFrete").append(tr);
                  });

               },
               error: function(result){
                 Utils.waitingClose();
                 $("#resultFrete").html(result);
               },
               complete: function(e){
                  Utils.waitingClose();
               }
           });

    });

});
