<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="wjaa" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <wjaa:header title="Fornecedor"/>
  <link href="https://cdnjs.cloudflare.com/ajax/libs/gijgo/1.9.10/combined/css/gijgo.min.css" rel="stylesheet" type="text/css" />
</head>
<body>
<wjaa:menu/>
<c:set var="destiny" value="CupomEntity"/>
<div class="content">
    <h4 class="text-center">CADASTRO DE CUPOM </h4>
    <hr/>
    <wjaa:feedback/>
    <form action="/admin/${destiny}/save" method="POST">
        <div class="form-row">
            <div class="form-group col-md-2">
                <label for="id" class="label-primary">#ID</label>
                <input type="number" class="form-control" name="id" id="id" readonly="readonly" value="${vo.id}">
            </div>
            <div class="form-group col-md-7">
                <label for="descricao" class="label-primary">DESCRIÇÃO</label>
                <input type="text" class="form-control" name="descricao" id="descricao" value="${vo.descricao}" maxlength="50">
            </div>
            <div class="form-group col-md-3">
                <label >&nbsp;</label>
                <div class="custom-control custom-checkbox">
                    <input type="checkbox" class="custom-control-input" id="promocao" name="promocao" <c:if test="${vo.promocao}">checked</c:if>>
                    <label class="custom-control-label" for="promocao">Cupom de promoção</label>
                </div>
            </div>
        </div>

        <div class="form-row">
            <div class="form-group col-md-4">
                <label for="hash" class="label-primary">CÓDIGO</label>
                <input type="text" class="form-control" name="hash" id="hash" value="${vo.hash}" maxlength="8">
            </div>
            <div class="form-group col-md-4">
                <label for="dataInicio" class="label-primary">DATA DE INICIO</label>
                <div class='input-group' id='pickerDataInicio'>
                    <input type="text" class="form-control date" name="dataInicio" id="dataInicio"
                           placeholder="DD/MM/YYYY" value="<fmt:formatDate value="${vo.dataInicio}" pattern="dd/MM/yyyy"/> ">
                    <span class="input-group-addon">
                        <span class="glyphicon glyphicon-calendar"></span>
                    </span>
                </div>
            </div>
            <div class="form-group col-md-4">
                <label for="dataFim" class="label-primary">DATA DE FIM</label>
                <div class='input-group' id='pickerDataFim'>
                    <input type="text" class="form-control date" name="dataFim" id="dataFim"
                           placeholder="DD/MM/YYYY" value="<fmt:formatDate value="${vo.dataFim}" pattern="dd/MM/yyyy"/> ">
                    <span class="input-group-addon">
                        <span class="glyphicon glyphicon-calendar"></span>
                    </span>
                </div>
            </div>

        </div>
        <div class="form-row">
            <div class="input-group col-md-3">
                <label for="id" class="label-primary">PORCENTAGEM</label>
                <div class="input-group mb-3">
                    <input type="text" class="form-control money" name="porcentagem" id="porcentagem"
                    placeholder="0,00" value="<fmt:formatNumber value="${vo.porcentagem}" pattern="#,##0.00"/>" maxlength="8"/>
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="basic-addon1">%</span>
                    </div>
                </div>
            </div>
            <div class="input-group col-md-3">
                <label for="id" class="label-primary">QUANTIDADE</label>
                <div class="input-group mb-3">
                    <input type="text" class="form-control" name="quantidade" id="quantidade"
                    placeholder="99999" value="${vo.quantidade}" maxlength="5"/>
                </div>
            </div>
        </div>


        <div class="col-xs-12">
            <a href="/admin/${destiny}" class="btn btn-success" >Voltar</a>
            <button type="submit" class="btn btn-primary btn-right">Gravar</button>
        </div>
    </form>
</div>
<wjaa:footer readOnly="${readOnly}"/>
<script src="https://cdnjs.cloudflare.com/ajax/libs/gijgo/1.9.10/combined/js/gijgo.min.js" type="text/javascript"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/gijgo/1.9.10/combined/js/messages/messages.pt-br.min.js" type="text/javascript"></script>
<script>
    $('#dataFim').datepicker({
        uiLibrary: 'bootstrap4',
        locale: "pt-br",
        format: 'dd/mm/yyyy'
    });
    $('#dataInicio').datepicker({
        uiLibrary: 'bootstrap4',
        locale: "pt-br",
        format: 'dd/mm/yyyy'
    });

    $("#hash").attr("readonly",!$("#promocao").is(':checked'));

    $("#promocao").change(function(){
        $("#hash").attr("readonly",!$(this).is(':checked'));
    });

</script>
</body>

</html>