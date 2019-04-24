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
                <div class="col-md-5">
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

                            <div class="form-group col-md-12 text-center">
                                 <label class="text-center" for="idProduto">FOTO</label>
                            </div>

                            <div id="imgCatalogo" class="form-row text-center" style="display:none">
                                <div class="form-group col-md-12 text-center">
                                    <input type="hidden" id="idCatalogo" name="anexos[0].idCatalogo" value="" />
                                    <img src="" width="80px" class="rounded float-left text-center ">
                                </div>
                            </div>

                            <div class="form-row">
                                <div class="form-group col-md-6">
                                    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#modalImagensExclusivas">Imagens exclusivas</button>
                                </div>
                                <div class="form-group col-md-6">
                                    <input type="file" class="form-control" id="fotoCliente" name="anexos[0].fotoCliente"/>
                                </div>
                            </div>

                        </div>
                        <div class="col-md-12 text-center" >
                            <button class="btn btn-primary text-center" type="submit" style="float:right">Adicionar Produto </button>
                        </div>
                    </form>
                </div>
                <div class="col-md-7">
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




        <div id="modalImagensExclusivas" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
          <div class="modal-dialog modal-lg">

            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Escolha sua imagem exclusiva</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                      <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <div class="form-group col-md-12">
                        <label for="idCatalogoGrupo">CATALOGO</label>
                        <select id="idCatalogoGrupo" name="idCatalogoGrupo" class="form-control" required>
                            <c:forEach var="c" items="${listCatalogo}">
                                <option value="${c.id}">${c.nome}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-row">
                        <c:forEach var="i" items="${imagensExclusivas}">
                            <div class="col-sm-3">
                                <img src="http://stc.meuportaretrato.com/images/catalogo/${i.urlImg}" width="200px" alt="${i.descricao}"
                                class="rounded float-left img-thumbnail" style="cursor:pointer" onclick="selectImg(${i.idCatalogo}, 'http://stc.meuportaretrato.com/images/catalogo/${i.urlImg}');">
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </div>
          </div>
        </div>

    </div>
    <wjaa:footer readOnly="${readOnly}"/>
    <script src="/static/js/checkout/carrinho.js?v=4"></script>
</body>

</html>