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
    <c:set var="destiny" value="CupomEntity"/>
    <div class="content">
        <h4 class="text-center"> LISTA DE CUPOM </h4>
        <hr/>
        <wjaa:feedback/>
        <div class="text-center btn-novo">
          <a href="/admin/${destiny}/0" class="btn btn-primary" >NOVO CUPOM</a>
        </div>
        <table class="table">
          <thead class="thead-dark">
            <tr>
              <th scope="col">ID</th>
              <th scope="col">DESCRICAO</th>
              <th scope="col">CÓDIGO</th>
              <th scope="col">DATA INICIO</th>
              <th scope="col">DATA FIM</th>
              <th scope="col">PROMOÇÃO</th>
              <th scope="col">PORCENTAGEM</th>
              <th scope="col">AÇÃO</th>
            </tr>
          </thead>
          <tbody>
            <c:forEach var="c" items="${list}">
            <tr>
              <td scope="row"><a href="/admin/${destiny}/${c.id}?readOnly=true" >${c.id}</a></td>
              <td><a href="/admin/${destiny}/${c.id}?readOnly=true">${c.descricao}</a></td>
              <td>${c.hash}</td>
              <td><fmt:formatDate value="${c.dataInicio}" pattern="dd/MM/yyyy"></fmt:formatDate></td>
              <td><fmt:formatDate value="${c.dataFim}" pattern="dd/MM/yyyy"></fmt:formatDate></td>
              <td><c:if test="${c.promocao}">SIM</c:if><c:if test="${!c.promocao}">NÃO</c:if> </td>
              <td><fmt:formatNumber value="${c.porcentagem}" pattern="#,##0.00" />%</td>
              <td align="center"><a href="/admin/${destiny}/${c.id}" class="btn btn-success"><i class="fas fa-edit"></i></a></td>
            </tr>
            </c:forEach>
          </tbody>
        </table>
    </div>
<wjaa:footer/>
</body>

</html>