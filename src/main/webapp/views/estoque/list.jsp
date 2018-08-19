<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="wjaa" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<wjaa:header/>
<body>
<wjaa:menu/>
    <c:set var="destiny" value="EstoqueEntity"/>
    <div class="content">
        <h4 class="text-center"> LISTA DE ESTOQUE </h4>
        <hr/>
        <wjaa:feedback/>
        <div class="text-center btn-novo">
          <a href="/admin/${destiny}/0" class="btn btn-primary" >ADICIONAR ESTOQUE</a>
        </div>
        <table class="table">
          <thead class="thead-dark">
            <tr>
              <th scope="col">ID</th>
              <th scope="col">PRODUTO</th>
              <th scope="col">FORNECEDOR</th>
              <th scope="col">DATA COMPRA</th>
              <th scope="col">DATA ATUALIZAÇÃO</th>
              <th scope="col">PREÇO COMPRA (UN)</th>
              <th scope="col">AÇÃO</th>
            </tr>
          </thead>
          <tbody>
            <c:forEach var="e" items="${list}">
            <tr>
              <td scope="row"><a href="/admin/${destiny}/${e.id}?readOnly=true" >${e.id}</a></td>
              <td><a href="/admin/${destiny}/${e.id}?readOnly=true">${e.produto.descricao}</a></td>
              <td>${e.fornecedor.nome}</td>
              <td><fmt:formatDate value="${e.dataCompra}" pattern="dd/MM/yyyy"></fmt:formatDate></td>
              <td><fmt:formatDate value="${e.dataAtualizacao}" pattern="dd/MM/yyyy"></fmt:formatDate></td>
              <td><fmt:formatNumber value="${e.precoCompra}" pattern="#,##0.00" /></td>
              <td align="center"><a href="/admin/${destiny}/${e.id}" class="btn btn-success"><i class="fas fa-edit"></i></a></td>
            </tr>
            </c:forEach>
          </tbody>
        </table>
    </div>
<wjaa:footer/>
</body>

</html>