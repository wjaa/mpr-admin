<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="wjaa" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<header>
    <wjaa:header title="Busca de pedido"/>
</header>
<body>
<wjaa:menu/>

       <c:set var="destiny" value="PedidoEntity"/>
       <div class="content">
           <h4 class="text-center"> BUSCA DE PEDIDO </h4>
           <hr/>
           <form action="/admin/PedidoEntity/find" method="POST">
            <div class="form-row">
              <div class="form-group col-md-3">
                <label for="exampleInputEmail1">Status Pedido</label>
                <select class="form-control" name="sysCode">
                    <option value="">-- SELECIONE -- </option>
                    <c:forEach var="s" items="${listSysCode}">
                        <option value="${s.code}">${s.desc}</option>
                    </c:forEach>
                </select>
              </div>
              <div class="form-group col-md-3">
                <label for="codigo">Código Pedido</label>
                <input type="text" class="form-control" id="codigo" name="codigo" placeholder="AABBCCDD">
              </div>
              <div class="form-group col-md-3">
                <label for="idCliente">ID do Cliente</label>
                <input type="text" class="form-control" id="idCliente" name="idCliente" placeholder="ID DO CLIENTE">
              </div>
              <div class="form-group col-md-1">
                <label for="btnBuscar">&nbsp;</label>
                <button id="btnBuscar" type="submit" class="form-control btn btn-primary">Buscar</button>
              </div>
            </div>
           </form>
           <hr/>
           <wjaa:feedback/>
           <table class="table">
             <thead class="thead-dark">
               <tr>
                 <th scope="col">#ID</th>
                 <th scope="col">CODIGO PEDIDO</th>
                 <th scope="col">DATA</th>
                 <th scope="col">STATUS</th>
                 <th scope="col">CLIENTE</th>
                 <th scope="col">VALOR TOTAL</th>
                 <th scope="col">DESCONTO</th>
                 <th scope="col">FRETE</th>
                 <th scope="col">CODIGO DA TRANSAÇÃO</th>
                 <th scope="col">CODIGO RASTREIO</th>
                 <th scope="col">AÇÃO</th>
               </tr>
             </thead>
             <tbody>
               <c:forEach var="p" items="${list}">
               <tr>
                 <td scope="row"><a href="/admin/${destiny}/${p.id}?readOnly=true" >${p.id}</a></td>
                 <td><a href="/admin/${destiny}/${p.id}?readOnly=true">${p.codigoPedido}</a></td>
                 <td><fmt:formatDate value="${p.data}" pattern="dd/MM/yyyy"></fmt:formatDate></td>
                 <td>${p.statusAtual.nome}</td>
                 <td>${p.cliente.nome}</td>
                 <td><fmt:formatNumber value="${p.valorTotal}" pattern="#,##0.00" /></td>
                 <td><fmt:formatNumber value="${p.valorDesconto}" pattern="#,##0.00" /></td>
                 <td><fmt:formatNumber value="${p.valorFrete}" pattern="#,##0.00" /></td>
                 <td>${p.codigoTransacao}</td>
                 <td>${p.codigoRastreio}</td>
                 <td align="center"><a href="/admin/${destiny}/${p.id}" class="btn btn-success"><i class="fas fa-edit"></i></a></td>
               </tr>
               </c:forEach>
             </tbody>
           </table>
       </div>

<wjaa:footer/>
</body>

</html>