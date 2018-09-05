<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="wjaa" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<header>
    <wjaa:header/>
</header>
<body>
<wjaa:menu/>
    <c:set var="destiny" value="FornecedorEntity"/>
    <div class="content">
        <h4 class="text-center"> LISTA DE FORNECEDORES </h4>
        <hr/>
        <wjaa:feedback/>
        <div class="text-center btn-novo">
          <a href="/admin/${destiny}/0" class="btn btn-primary" >NOVO FORNECEDOR</a>
        </div>
        <table class="table">
          <thead class="thead-dark">
            <tr>
              <th scope="col">#ID</th>
              <th scope="col">NOME</th>
              <th scope="col">EMAIL</th>
              <th scope="col">CNPJ</th>
              <th scope="col">ENDERECO</th>
              <th scope="col">TELEFONE 1</th>
              <th scope="col">TELEFONE 2</th>
              <th scope="col">ATIVO</th>
              <th scope="col">AÇÃO</th>
            </tr>
          </thead>
          <tbody>
            <c:forEach var="f" items="${list}">
            <tr>
              <td scope="row"><a href="/admin/${destiny}/${f.id}?readOnly=true" >${f.id}</a></td>
              <td><a href="/admin/${destiny}/${f.id}?readOnly=true">${f.nome}</a></td>
              <td>${f.email}</td>
              <td>${f.cnpj}</td>
              <td>${f.endereco}</td>
              <td>${f.telefonePrincipal}</td>
              <td>${f.telefoneSecundario}</td>
              <td><c:if test="${f.ativo}">SIM</c:if><c:if test="${!f.ativo}">NÃO</c:if> </td>
              <td align="center"><a href="/admin/${destiny}/${f.id}" class="btn btn-success"><i class="fas fa-edit"></i></a></td>
            </tr>
            </c:forEach>
          </tbody>
        </table>
    </div>
<wjaa:footer/>
</body>

</html>