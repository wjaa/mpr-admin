<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="wjaa" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<header>
    <wjaa:header/>
</header>
<body>
<wjaa:menu/>
    <c:set var="destiny" value="TabelaPrecoEntity"/>
    <div class="content">
        <h4 class="text-center"> TABELAS DE PREÇOS </h4>
        <hr/>
        <wjaa:feedback/>
        <div class="text-center btn-novo">
          <a href="/admin/${destiny}/0" class="btn btn-primary" >NOVA TABELA DE PREÇO</a>
        </div>
        <table class="table">
          <thead class="thead-dark">
            <tr>
              <th scope="col">#ID</th>
              <th scope="col">PRODUTO</th>
              <th scope="col">DATA VIGENCIA</th>
              <th scope="col">PREÇO</th>
              <th scope="col">DESCRIÇAO</th>
              <th scope="col">AÇÃO</th>
            </tr>
          </thead>
          <tbody>
            <c:forEach var="t" items="${list}">
            <tr>
              <td scope="row"><a href="/admin/${destiny}/${t.id}?readOnly=true" >${t.id}</a></td>
              <td><a href="/admin/${destiny}/${t.id}?readOnly=true">${t.produto.descricao}</a></td>
              <td><fmt:formatDate value="${t.dataVigencia}" pattern="dd/MM/yyyy"></fmt:formatDate></td>
              <td><fmt:formatNumber value="${t.preco}" pattern="#,##0.00" /></td>
              <td>${t.descricao}</td>
              <td align="center"><a href="/admin/${destiny}/${t.id}" class="btn btn-success"><i class="fas fa-edit"></i></a></td>
            </tr>
            </c:forEach>
          </tbody>
        </table>
    </div>
<wjaa:footer/>
</body>

</html>