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
            <div class="row">
                <div class="col-md-4">
                    <form id="formAddCarrinho" action="/admin/checkout/addProduto" method="POST" enctype="multipart/form-data">
                        <div class="col-md-12">
                            <div class="form-group col-md-12">
                                <label for="idCliente">ID CLIENTE</label>
                                <input type="text" class="form-control" id="idCliente" name="idCliente" required value="${idCliente}">
                            </div>
                            <div class="form-group col-md-12">
                                <label for="idProduto">PRODUTO</label>
                                <select id="idProduto" name="idProduto" class="form-control" required>
                                    <option value="">--Selecione--</option>
                                    <c:forEach var="p" items="${produtos}">
                                        <option value="${p.id}">${p.descricao}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="form-group col-md-12">
                                <label for="idCliente">FOTO</label>
                                <input type="file" class="form-control" id="fotoCliente" name="anexos[0].fotoCliente" required/>
                            </div>

                        </div>
                        <div class="col-md-12" >
                            <button class="btn btn-primary" type="submit" style="float:right">Adicionar Produto </button>
                        </div>
                    </form>
                </div>
                <div class="col-md-8">
                    <form id="formCheckout" action="/admin/checkout/finish" method="POST" enctype="multipart/form-data">
                        <input type="hidden" value="${carrinho.idCarrinho}" name="idCarrinho"/>
                        <div class="col-md-12">
                            <h4 class="d-flex justify-content-between align-items-center mb-3">
                              <span class="text-muted">Seu carrinho</span>
                              <span class="badge badge-secondary badge-pill">${carrinho.items.size()}</span>
                            </h4>
                            <ul class="list-group mb-3">

                                    <c:forEach var="i" items="${carrinho.items}">
                                        <li class="list-group-item d-flex justify-content-between lh-condensed">
                                            <div>
                                                <img src="${i.produto.imgDestaque}" height="80px">
                                            </div>
                                            <div class="col-md-8 md-4">
                                             <h6 class="my-0">${i.produto.descricao}</h6>
                                             <small class="text-muted">${i.produto.descricaoDetalhada}</small>
                                            </div>
                                            <div>
                                                <span class="text-muted">R$ <fmt:formatNumber value="${i.produto.preco}" pattern="#,##0.00" /></span>
                                                <h4><a href="#" id-item="${i.id}" id-cliente="${carrinho.idCliente}" class="btn-remover"><i class="far fa-trash-alt"></i></a></h4>
                                            </div>
                                        </li>
                                        <li class="list-group-item d-flex justify-content-between lh-condensed">
                                            <div>
                                                <img src="${i.anexos[0].urlFoto}" height="80px">
                                            </div>
                                            <div class="col-md-8 md-4">
                                             <h6 class="my-0">Impressão de foto</h6>
                                            </div>
                                            <div>
                                                <span class="text-muted">R$ 0,00</span>
                                            </div>
                                        </li>
                                    </c:forEach>

                              </ul>
                        </div>
                    </form>
                </div>
            </div>

        <hr/>
        <div class="col-md-12">
            <button class="btn btn-danger" type="button" onclick="window.location.href='/admin/checkout/escolhaCliente'">Voltar</button>
            <button class="btn btn-primary" style="float:right" type="button" onclick="Utils.waiting('Aguarde fazendo checkout...');document.forms[1].submit();" >Checkout</button>
        </div>

    </div>
    <wjaa:footer readOnly="${readOnly}"/>
    <script src="/static/js/checkout/carrinho.js?v=2"></script>
</body>

</html>