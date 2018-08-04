<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="wjaa" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<wjaa:header/>
<body>
<wjaa:menu/>

    <div class="content">
        <h4 class="text-center"> LISTA DE FORNECEDORES </h4>
        <hr/>
        <div class="text-center btn-novo">
          <a href="/admin/fornecedor/0" class="btn btn-primary" >NOVO FORNECEDOR</a>
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
            </tr>
          </thead>
          <tbody>
            <c:forEach var="f" items="${list}">
            <tr>
              <th scope="row"><a href="/admin/fornecedor/${f.id}" >${f.id}</a></th>
              <td><a href="/admin/fornecedor/${f.id}">${f.nome}</a></td>
              <td>${f.email}</td>
              <td>${f.cnpj}</td>
              <td>${f.endereco}</td>
              <td>${f.telefonePrincipal}</td>
              <td>${f.telefoneSecundario}</td>
              <td>${f.ativo}</td>
            </tr>
            </c:forEach>
          </tbody>
        </table>
    </div>
<wjaa:footer/>
</body>

</html>