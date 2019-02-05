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

var Utils = function() {
  return {
	    validarCPF: function (cpf) {
	    	var numeros, digitos, soma, i, resultado, digitos_iguais;
	        digitos_iguais = 1;
	        if (cpf.length < 11)
	              return false;
	        for (i = 0; i < cpf.length - 1; i++)
	              if (cpf.charAt(i) != cpf.charAt(i + 1))
	                    {
	                    digitos_iguais = 0;
	                    break;
	                    }
	        if (!digitos_iguais)
	              {
	              numeros = cpf.substring(0,9);
	              digitos = cpf.substring(9);
	              soma = 0;
	              for (i = 10; i > 1; i--)
	                    soma += numeros.charAt(10 - i) * i;
	              resultado = soma % 11 < 2 ? 0 : 11 - soma % 11;
	              if (resultado != digitos.charAt(0))
	                    return false;
	              numeros = cpf.substring(0,10);
	              soma = 0;
	              for (i = 11; i > 1; i--)
	                    soma += numeros.charAt(11 - i) * i;
	              resultado = soma % 11 < 2 ? 0 : 11 - soma % 11;
	              if (resultado != digitos.charAt(1))
	                    return false;
	              return true;
	              }
	        else
	            return false;
	   },
	   waitingSearch: function(){
		   waitingDialog.show('Pesquisando aguarde...', {dialogSize: 'sm', progressType: 'warning'});
	   },
	   waiting: function(msg){
		   waitingDialog.show(msg, {dialogSize: 'sm', progressType: 'warning'});
	   },
	   waitingSearch: function(msg){
		   waitingDialog.show(msg, {dialogSize: 'sm', progressType: 'warning'});
	   },
	   waitingClose: function(){
		   waitingDialog.hide();
	   },
	   numberOnly:function(campo){
		   $(campo).val($(campo).val().replace(/[^0-9]/g, ''));
	   },
	   showAlert:function(msg){
		   BootstrapDialog.show({
	            title: 'Alerta!',
	            message: msg,
	            cssClass: 'alert-dialog',
	            buttons: [{
	                label: 'Ok',
	                action: function(dialogItself){
	                    dialogItself.close();
	                }
	            }]
	        });
	   },
	   confirmDlg : function(msg, callback){
		   bootbox.confirm(msg, callback);
	   },
	   isNotEmpty:function(val){
		   return val != null && "" != val.trim();
	   },
	   isEmpty:function(val){
		   return val == null || "" == val;
	   },
	   replaceAll:function(string, token, newtoken) {
			while (string.indexOf(token) != -1) {
		 		string = string.replace(token, newtoken);
			}
			return string;
	   },
	   lpad: function(value, size) {
		   if (value.length >= size) return value;
		   while (value.length < size){
			   value = '0' + value;
		   }
			console.log(value);
		   return value;
	   }
  }

}();


