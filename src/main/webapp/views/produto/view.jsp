<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="wjaa" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<wjaa:header title="Fornecedor"/>
<body>
<wjaa:menu/>
<c:set var="destiny" value="ProdutoEntity"/>
<div class="content">
    <h4 class="text-center">CADASTRO DE PRODUTO </h4>
    <hr/>
    <wjaa:feedback/>
    <form action="/admin/${destiny}/save" method="POST">
        <div class="form-row">
            <div class="form-group col-md-3">
                <label for="id" class="label-primary">#ID</label>
                <input type="number" class="form-control" name="id" id="id" readonly="readonly" value="${vo.id}">
            </div>
            <div class="form-group col-md-6">
                <label for="descricao">TIPO DE PRODUTO</label>
                <select name="idTipoProduto" class="form-control">
                    <option value="">--Selecione--</option>
                    <c:forEach var="t" items="${vo.listTipoProdutos}">
                        <option value="${t.id}" <c:if test="${t.id == vo.idTipoProduto}">selected</c:if> >
                           ${t.descricao}
                        </option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="form-row">
            <div class="form-group col-md-7">
                <label for="id" class="label-primary">DESCRIÇÃO</label>
                <input type="text" class="form-control" name="descricao" id="descricao"
                       placeholder="DESCRIÇÃO DO PRODUTO" value="${vo.descricao}">
            </div>
            <div class="form-group col-md-3">
                <label for="peso">PESO</label>
                <input type="text" class="form-control" name="peso" id="peso"
                       placeholder="0,00" value="<fmt:formatNumber value="${vo.peso}" pattern="#,##0.00" />" />
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