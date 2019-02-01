<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="wjaa" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <header>
        <wjaa:header title="Checkout Test"/>
    </header>
<body>
<wjaa:menu/>
    <div class="content">
        <h4 class="text-center"> CARRINHO TEST </h4>
        <hr/>
        <wjaa:feedback/>
        <form action="/admin/checkout/finish" method="POST" enctype="multipart/form-data">
            <c:if test="${carrinho != null}">
                <div class="row">
                    <div class="col-md-4 order-md-2 mb-4">
                        <h4 class="d-flex justify-content-between align-items-center mb-3">
                          <span class="text-muted">Seu carrinho</span>
                          <span class="badge badge-secondary badge-pill">${carrinho.items.size()}</span>
                        </h4>
                        <ul class="list-group mb-3">

                                <c:forEach var="i" items="${carrinho.items}">
                                    <li class="list-group-item d-flex justify-content-between lh-condensed">
                                        <div>
                                         <h6 class="my-0">${i.produto.descricao}</h6>
                                         <small class="text-muted">${i.produto.descricaoDetalhada}</small>
                                        </div>
                                        <span class="text-muted">R$ ${i.produto.preco}</span>
                                  </li>
                                </c:forEach>

                          </ul>
                    </div>
                </div>
                <div class="row">
                    <button class="btn btn-primary btn-lg btn-block" type="submit">Checkout</button>
                </div>
            </c:if>
        <hr/>
        <form action="/admin/checkout/addProduto" method="POST" enctype="multipart/form-data">
            <div class="row">
                <div class="form-group col-md-2">
                    <label for="idCliente">ID CLIENTE</label>
                    <input type="text" class="form-control" id="idCliente" name="idCliente" required value="${idCliente}">
                </div>
                <div class="form-group col-md-6">
                    <label for="idProduto">PRODUTO</label>
                    <select id="idProduto" name="idProduto" class="form-control" required>
                        <option value="">--Selecione--</option>
                        <c:forEach var="p" items="${produtos}">
                            <option value="${p.id}">${p.descricao}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group col-md-4">
                    <label for="idCliente">FOTO</label>
                    <input type="file" class="form-control" id="fotoCliente" name="fotoCliente" required/>
                </div>

            </div>
            <div class="row">
                <button class="btn btn-primary btn-lg btn-block" type="submit">Adicionar Produto </button>
            </div>
        </form>
    </div>
    <wjaa:footer readOnly="${readOnly}"/>
</body>

</html>