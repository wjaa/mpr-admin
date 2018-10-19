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
    <c:set var="destiny" value="ProdutoEntity"/>
    <div class="content">
        <h4 class="text-center"> LISTA DE PRODUTOS </h4>
        <hr/>
        <wjaa:feedback/>
        <div class="text-center btn-novo">
          <a href="/admin/${destiny}/0" class="btn btn-primary" >NOVO PRODUTO</a>
        </div>
        <table class="table">
          <thead class="thead-dark">
            <tr>
              <th scope="col">#ID</th>
              <th scope="col">IMG DESTAQUE</th>
              <th scope="col">DESCRIÇÃO</th>
              <th scope="col">TIPO DE PRODUTO</th>
              <th scope="col">NOME COR</th>
              <th scope="col">COR</th>
              <th scope="col">PESO</th>
              <th scope="col">PREÇO</th>
              <th scope="col">AÇÃO</th>
            </tr>
          </thead>
          <tbody>
            <c:forEach var="p" items="${list}">
            <tr>
              <td scope="row"><a href="/admin/${destiny}/${p.id}?readOnly=true" >${p.id}</a></td>
              <td><img src="http://stc.meuportaretrato.com/images/d/${p.imgDestaque}" class="img-thumbnail" style="height: 50px!important;"></td>
              <td><a href="/admin/${destiny}/${p.id}?readOnly=true">${p.descricao}</a></td>
              <td>${p.nomeTipoProduto}</td>
              <td>${p.nomeCor}</td>
              <td style="font-size: 30px; color:${p.hexaCor}"><i class="fas fa-circle"></i></td>
              <td><fmt:formatNumber value="${p.peso}" pattern="#,##0.00" /></td>
              <td><fmt:formatNumber value="${p.preco}" pattern="#,##0.00" /></td>
              <td align="center"><a href="/admin/${destiny}/${p.id}" class="btn btn-success"><i class="fas fa-edit"></i></a></td>
            </tr>
            </c:forEach>
          </tbody>
        </table>
    </div>
<wjaa:footer/>
</body>

</html>