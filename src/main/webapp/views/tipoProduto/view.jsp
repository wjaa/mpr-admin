<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="wjaa" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<wjaa:header title="Fornecedor"/>
<body>
<wjaa:menu/>
<c:set var="destiny" value="TipoProdutoEntity"/>
<div class="content">
    <h4 class="text-center">CADASTRO DE TIPO DE PRODUTO </h4>
    <hr/>
    <wjaa:feedback/>
    <form action="/admin/${destiny}/save" method="POST">
        <div class="form-row">
            <div class="form-group col-md-3">
                <label for="id" class="label-primary">#ID</label>
                <input type="number" class="form-control" name="id" id="id" readonly="readonly" value="${vo.id}">
            </div>
            <div class="form-group col-md-6">
                <label for="descricao">DESCRIÇÃO</label>
                <input type="text" class="form-control" name="descricao" id="descricao"
                       placeholder="Descrição" value="${vo.descricao}" maxlength="80">
            </div>
            <div class="form-group col-md-3">
                <label >&nbsp;</label>
                <div class="custom-control custom-checkbox">
                    <input type="checkbox" class="custom-control-input" id="acessorio" name="acessorio" <c:if test="${vo.acessorio}">checked</c:if>>
                    <label class="custom-control-label" for="acessorio">Acessório?</label>
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
</body>

</html>