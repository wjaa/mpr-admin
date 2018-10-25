<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="wjaa" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <wjaa:header title="Lote Estoque"/>
  <link href="https://cdnjs.cloudflare.com/ajax/libs/gijgo/1.9.10/combined/css/gijgo.min.css" rel="stylesheet" type="text/css" />
</head>
<body>
<wjaa:menu/>
<c:set var="destiny" value="EstoqueEntity"/>
<div class="content">
    <h4 class="text-center">CADASTRO DE LOTE DO ESTOQUE </h4>
    <hr/>
    <wjaa:feedback/>
    <form action="/admin/${destiny}/save" method="POST">
        <div class="form-row">
            <div class="form-group col-md-2">
                <label for="id" class="label-primary">#ID</label>
                <input type="number" class="form-control" name="id" id="id" readonly="readonly" value="${vo.id}">
            </div>
            <div class="form-group col-md-5">
                <label for="dataAtualizacao" class="label-primary">DATA DE ATUALIZAÇÃO</label>
                <input type="text" class="form-control" name="dataAtualizacao" id="dataAtualizacao"
                       placeholder="DD/MM/YYYY" readonly="readonly" value="<fmt:formatDate value="${vo.dataAtualizacao}" pattern="dd/MM/yyyy"/> ">
            </div>
            <div class="form-group col-md-5">
                <label for="dataCompra" class="label-primary">DATA DA COMPRA</label>
                <input type="text" class="form-control" name="dataCompra" id="dataCompra"
                       placeholder="DD/MM/YYYY" value="<fmt:formatDate value="${vo.dataCompra}" pattern="dd/MM/yyyy"/> ">
            </div>

        </div>
        <div class="form-row">

            <div class="form-group col-md-2">
                <label for="quantidade" class="label-primary">QUANTIDADE</label>
                <input type="text" class="form-control" name="quantidade" id="quantidade" value="${vo.quantidade}">
            </div>

            <div class="form-group col-md-2">
                <label for="" class="label-primary">QUANTIDADE ATUAL</label>
                <input type="text" class="form-control" readOnly="readOnly" value="${vo.quantidadeAtual}">
            </div>

            <div class="form-group col-md-4">
                <label for="idProduto">PRODUTO</label>
                <select id="idProduto" name="idProduto" class="form-control">
                    <option value="">--Selecione--</option>
                    <c:forEach var="p" items="${vo.produtos}">
                        <option value="${p.id}" <c:if test="${p.id == vo.idProduto}">selected</c:if> >
                                ${p.descricao}
                        </option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group col-md-4">
                <label for="idFornecedor">FORNECEDOR</label>
                <select id="idFornecedor" name="idFornecedor" class="form-control">
                    <option value="">--Selecione--</option>
                    <c:forEach var="f" items="${vo.fornecedores}">
                        <option value="${f.id}" <c:if test="${f.id == vo.idFornecedor}">selected</c:if> >
                                ${f.nome}
                        </option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="form-row">
            <div class="form-group col-md-7">
                <label for="id" class="label-primary">VALOR (UN) COMPRA</label>
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="basic-addon1">R$</span>
                    </div>
                    <input type="text" class="form-control money" name="precoCompra" id="precoCompra"
                           placeholder="0,00" value="<fmt:formatNumber value="${vo.precoCompra}" pattern="#,##0.00"/>" maxlength="9"/>
                </div>

            </div>
        </div>
        <div class="form-row">
            <div class="form-group col-md-12">
                <label for="id" class="label-primary">OBSERVAÇÃO</label>
                <textarea class="form-control" id="observacao" name="observacao" rows="5" maxlength="1000">${vo.observacao}</textarea>
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
    $('#dataCompra').datepicker({
        uiLibrary: 'bootstrap4',
        locale: "pt-br",
        format: 'dd/mm/yyyy'
    });

</script>
</body>

</html>