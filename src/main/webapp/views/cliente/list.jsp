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
    <c:set var="destiny" value="ClienteEntity"/>
    <div class="content">
        <h4 class="text-center"> CLIENTES </h4>
        <hr/>
        <wjaa:feedback/>
        <table class="table">
          <thead class="thead-dark">
            <tr>
              <th scope="col">#ID</th>
              <th scope="col">NOME</th>
              <th scope="col">EMAIL</th>
              <th scope="col">CPF</th>
              <th scope="col">CELULAR</th>
              <th scope="col">ANIVERSARIO</th>
              <th scope="col">ATIVO</th>
              <th scope="col">AÇÃO</th>
            </tr>
          </thead>
          <tbody>
            <c:forEach var="c" items="${list}">
            <tr>
              <td scope="row"><a href="/admin/${destiny}/${c.id}?readOnly=true" >${c.id}</a></td>
              <td><a href="/admin/${destiny}/${c.id}?readOnly=true">${c.nome}</a></td>
              <td>${c.email}</td>
              <td>${c.cpf}</td>
              <td>${c.celular}</td>
              <td><fmt:formatDate value="${c.aniversario}" pattern="dd/MM/yyyy"></fmt:formatDate></td>
              <td><c:if test="${c.ativo}">SIM</c:if><c:if test="${!c.ativo}">NÃO</c:if> ${f.ativo}</td>
              <td align="center"><a href="/admin/${destiny}/${c.id}" class="btn btn-success"><i class="fas fa-edit"></i></a></td>
            </tr>
            </c:forEach>
          </tbody>
        </table>
    </div>
<wjaa:footer/>
</body>

</html>