$(document).ready(function(){
    setTimeout(function(){
            $(".alert").alert('close')
        },10000
    );


    if (readOnly){
        $("input, select, button, textarea").attr("disabled",true);
    }

});

