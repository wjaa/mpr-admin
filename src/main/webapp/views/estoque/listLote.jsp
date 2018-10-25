<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="wjaa" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="destiny" value="EstoqueEntity"/>
<table class="table table-bordered">
    <thead class="thead-light">
        <tr>
            <th scope="col">#ID DO LOTE</th>
            <th scope="col">FORNECEDOR</th>
            <th scope="col">DATA COMPRA</th>
            <th scope="col">DATA ATUALIZAÇÃO</th>
            <th scope="col">PREÇO COMPRA (UN)</th>
            <th scope="col">QUANTIDADE</th>
            <th scope="col">AÇÃO</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="e" items="${list}">
        <tr>
            <td><a href="/admin/${destiny}/${e.id}?readOnly=true" >#${e.id}</a></td>
            <td>${e.nomeFornecedor}</td>
            <td><fmt:formatDate value="${e.dataCompra}" pattern="dd/MM/yyyy"></fmt:formatDate></td>
            <td><fmt:formatDate value="${e.dataAtualizacao}" pattern="dd/MM/yyyy"></fmt:formatDate></td>
            <td><fmt:formatNumber value="${e.precoCompra}" pattern="#,##0.00" /></td>
            <td>${e.quantidade}/${e.quantidadeAtual} </td>
            <td align="center"><a href="/admin/${destiny}/${e.id}" class="btn btn-success"><i class="fas fa-edit"></i></a></td>
        </tr>
        </c:forEach>
    </tbody>
</table>