<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="wjaa" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <header>
        <wjaa:header title="Pedido criado com sucesso."/>
    </header>
<body>
<wjaa:menu/>
    <div class="content">
        <h4 class="text-center"> PEDIDO CRIADO COM SUCESSO</h4>
        <hr/>
        <wjaa:feedback/>
        <div class="row">
           <div class="col-md-12">
                <table class="table">
                 <thead>
                   <tr>
                     <th scope="col">#</th>
                     <th scope="col">Código do pedido</th>
                     <th scope="col">Data</th>
                     <th scope="col">Tipo Pagamento</th>
                     <th scope="col">Status pedido</th>
                     <th scope="col">E-mail cliente</th>
                     <th scope="col">Link do boleto</th>
                   </tr>
                 </thead>
                 <tbody>
                      <tr>
                         <td scope="row">
                            ${resultadoPagamento.idPedido}
                         </td>
                         <td>${resultadoPagamento.codigoPedido}</td>
                         <td><fmt:formatDate value="${resultadoPagamento.dataPedido}" pattern="dd/MM/yyyy"></fmt:formatDate></td>
                         <td>${resultadoPagamento.pagamentoType}</td>
                         <td>${resultadoPagamento.statusPedido}</td>
                         <td>${resultadoPagamento.email}</td>
                         <td>${resultadoPagamento.paymentLink}</td>
                      </tr>
                 </tbody>
               </table>
           </div>
        </div>

    </div>
    <wjaa:footer readOnly="${readOnly}"/>
</body>

</html>