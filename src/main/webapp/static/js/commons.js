$(document).ready(function(){
    setTimeout(function(){
            $(".mpr-alert").alert('close')
        },10000
    );


    if (readOnly){
        $("input, select, button, textarea").attr("disabled",true);
        $("button.navbar-toggler").attr("disabled",false);
    }


    $('.money').mask("#.##0,00", {reverse: true});
    $('.cpf').mask('000.000.000-00', {reverse: true});
    $('.cnpj').mask('00.000.000/0000-00', {reverse: true});
    $('.date').mask('00/00/0000',{placeholder:"__/__/_____"});


});

