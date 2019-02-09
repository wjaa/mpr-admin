$(document).ready(function(){

    console.log("init");

    //utilizado para validar o CVV, data de validacao do cartao de credito.
    var brand = {};
    PagSeguroDirectPayment.setSessionId($("#token").val());


    //submit do form
    $("#btnCheckout").click(function(){

        Utils.waiting("Aguarde, enviado dados de pagamento...");
        var param = {
                cardNumber: $("input#cc-number").val(),
                cvv: $("input#cc-cvv").val(),
                expirationMonth: $("input#cc-expiration-month").val(),
                expirationYear: $("input#cc-expiration-year").val(),
                brand: brand.name,
                success: function(response) {
                    $("#cardToken").val(response.card.token);
                    if ( response.card.token != null ){
                        $("#formCheckout").submit();
                    }else{
                        Utils.waitingClose();
                        Utils.showAlert("Token do pagseguro está vazio, tente novamente.");
                    }

                },
                error: function(response) {
                    Utils.waitingClose();
                    Utils.showAlert("Erro ao tentar resgatar o token: " + response);
                },
                complete: function(response) {
                }
        }
        console.log("iniciando checkout");
        var senderHash = PagSeguroDirectPayment.getSenderHash();
        console.log(senderHash);
        $("#senderHash").val(senderHash);
        PagSeguroDirectPayment.createCardToken(param);

    });

    //pega a bandeira do cartao
    $("#cc-number").blur(function(){
        PagSeguroDirectPayment.getBrand({
         cardBin: $("input#cc-number").val(),
         success: function(response) {
                brand = response.brand;
                $("#bandeira img").attr("src","https://stc.pagseguro.uol.com.br/public/img/payment-methods-flags/42x20/" + brand.name +".png")
                $("#bandeira").show();
                //
         },
         error: function(response) {
            //TODO TRATAR O ERRO COM ALERT.
            console.log("ERROR");
            console.log(response);
         },
         complete: function(response) {
         }
        });
    });


    $("#btnCupom").click(function(){
       Utils.waiting("Aguarde adicionando cupom...");
       var idCheckout = $(this).attr("id-checkout");
       var idCarrinho = $(this).attr("id-carrinho");
       var cupom = $("#cupom").val();
       window.location.href = "/admin/checkout/addCupom/" + idCarrinho + "/" + idCheckout + "/" + cupom;

    });

    $("#btnChangeEnd").click(function(){
         var idCarrinho = $("#idCarrinho").val();
         var idCheckout = $("#idCheckout").val();
         var idEndAtual = $(this).attr("endereco-atual");
         var idEndereco = $("input[name='endereco']:checked"). val();
         if (idEndAtual == idEndereco ){
            Utils.showAlert("Você já está utilizando esse endereço.");
            return;
         }

        Utils.waiting("Aguarde alterando endereço...");
        window.location.href = "/admin/checkout/alterarEndereco/" +idCarrinho + "/" + idCheckout + "/" + idEndereco;

    });

    $("#btnChangeFrete").click(function(){
         var idCarrinho = $("#idCarrinho").val();
         var idCheckout = $("#idCheckout").val();
         var tipoFreteAtual = $(this).attr("frete-atual");
         var tipoFrete = $("input[name='tipoFrete']:checked"). val();
         if (tipoFreteAtual == tipoFrete ){
            Utils.showAlert("Você já está utilizando esse frete.");
            return;
         }

        Utils.waiting("Aguarde alterando frete...");
        window.location.href = "/admin/checkout/alterarFrete/" +idCarrinho + "/" + idCheckout + "/" + tipoFrete;

    });

});

