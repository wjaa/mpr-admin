<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="wjaa" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<wjaa:header/>
<body>
<wjaa:menu/>
    <c:set var="destiny" value="TipoProdutoEntity"/>
    <div class="content">
        <h4 class="text-center"> LISTA DE TIPO DE PRODUTOS </h4>
        <hr/>
        <wjaa:feedback/>
        <div class="text-center btn-novo">
          <a href="/admin/${destiny}/0" class="btn btn-primary" >NOVO TIPO DE PRODUTO</a>
        </div>
        <table class="table">
          <thead class="thead-dark">
            <tr>
              <th scope="col">#ID</th>
              <th scope="col">DESCRIÇÃO</th>
              <th scope="col">AÇÃO</th>
            </tr>
          </thead>
          <tbody>
            <c:forEach var="t" items="${list}">
            <tr>
              <td scope="row"><a href="/admin/${destiny}/${t.id}?readOnly=true" >${t.id}</a></td>
              <td><a href="/admin/${destiny}/${t.id}?readOnly=true">${t.descricao}</a></td>
              <td align="center"><a href="/admin/${destiny}/${t.id}" class="btn btn-success"><i class="fas fa-edit"></i></a></td>
            </tr>
            </c:forEach>
          </tbody>
        </table>
    </div>
<wjaa:footer/>
</body>

</html>