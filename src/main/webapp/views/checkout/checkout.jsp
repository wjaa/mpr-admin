<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="wjaa" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <header>
        <wjaa:header title="Checkout Test"/>
        <link href="https://cdnjs.cloudflare.com/ajax/libs/gijgo/1.9.10/combined/css/gijgo.min.css" rel="stylesheet" type="text/css" />
    </header>
<body>
<wjaa:menu/>
    <div class="content">
        <h4 class="text-center"> CHECKOUT TEST </h4>
        <hr/>
        <wjaa:feedback/>
        <form id="formCheckout" action="/admin/checkout/pagamento" method="POST">
        <div class="row">
            <input type="hidden" id="token" value="${token}">
            <input type="hidden" id="idCheckout" name="idCheckout" value="${checkout.id}">
            <input type="hidden" id="idCarrinho" name="idCarrinho" value="${checkout.carrinho.idCarrinho}">
            <input type="hidden" id="cardToken" name="formaPagamento.cartaoCredito.token">
            <input type="hidden" id="senderHash" name="senderHash">


            <div class="col-md-6">
                <div class="row">
                  <div class="col-md-12 mb-3 alert alert-info">
                        <div class="custom-control custom-radio">
                            <input id="endereco${checkout.endereco.id}" name="endereco" type="radio" class="custom-control-input" value="${checkout.endereco.id}" checked="">
                            <label class="custom-control-label" for="endereco${checkout.endereco.id}">Endereço de Entrega - ${checkout.endereco.descricao}</label>
                         </div>
                      <p><small class="text-muted">${checkout.endereco.endereco}</small></p>
                  </div>
                  <c:forEach var="e" items="${checkout.cliente.enderecos}">
                    <c:if test="${e.id != checkout.endereco.id}" >
                        <div class="col-md-12 mb-3">
                            <div class="custom-control custom-radio">
                                <input id="endereco${e.id}" name="endereco" type="radio" class="custom-control-input" value="${e.id}">
                                <label class="custom-control-label" for="endereco${e.id}">Endereço - ${e.descricao}</label>
                             </div>
                            <p><small class="text-muted">${e.endereco}</small></p>
                        </div>
                    </c:if>
                  </c:forEach>
                  <div class="col-md-12 mb-3">
                    <button id="btnChangeEnd" endereco-atual="${checkout.endereco.id}" class="btn btn-primary" type="button" style="float:right">Alterar Endereco</button>
                  </div>
                </div>
                <div class="row">
                   <div class="col-md-12 mb-3">
                       <table class="table">
                         <thead>
                           <tr>
                             <th scope="col">Tipo Frete</th>
                             <th scope="col">Data</th>
                             <th scope="col">Valor</th>
                           </tr>
                         </thead>
                         <tbody>
                           <c:forEach var="f" items="${checkout.listResultFrete}">
                               <tr>
                                 <th scope="row">
                                    <div class="custom-control custom-radio">
                                      <input id="tipoFrete${f.freteType}" name="tipoFrete" type="radio" class="custom-control-input" value="${f.freteType}" <c:if test="${f.freteType == checkout.freteSelecionado.freteType}">checked="" </c:if>>
                                      <label class="custom-control-label" for="tipoFrete${f.freteType}">${f.freteType.descricao}</label>
                                    </div>
                                 </th>
                                 <td><fmt:formatDate value="${f.previsaoEntrega}" pattern="dd/MM/yyyy"></fmt:formatDate></td>
                                 <td>R$ <fmt:formatNumber value="${f.valor}" pattern="#,##0.00" /></td>
                               </tr>
                           </c:forEach>
                         </tbody>
                       </table>
                       <div class="col-md-12 mb-3">
                            <button id="btnChangeFrete" frete-atual="${checkout.freteSelecionado.freteType}" class="btn btn-primary" type="button" style="float:right">Alterar Frete</button>
                       </div>
                   </div>
                </div>
                <hr/>


                  <div class="d-block my-3">
                      <div class="custom-control custom-radio">
                          <input id="credit" name="formaPagamento.tipoPagamento" type="radio" class="custom-control-input" value="CARTAO_CREDITO" checked="" required="">
                          <label class="custom-control-label" for="credit">Cartão de crédito</label>
                      </div>
                      <div class="custom-control custom-radio">
                          <input id="boleto" name="formaPagamento.tipoPagamento" type="radio" class="custom-control-input" value="BOLETO" required="">
                          <label class="custom-control-label" for="boleto">Boleto</label>
                      </div>
                  </div>
                  <div class="row">
                      <div class="col-md-6 mb-3">
                          <label for="cc-name">Nome no cartão</label>
                          <input type="text" class="form-control" id="cc-name" placeholder="" required="" maxlength="30" value="comprador teste">
                          <small class="text-muted">Nome completo como mostrado no cartão</small>
                          <div class="invalid-feedback">
                              Nome no cartão é obrigatório.
                          </div>
                      </div>
                      <div class="col-md-6 mb-3">
                          <label for="cc-number">Número do cartão de crédito</label>
                          <input type="text" class="form-control" id="cc-number" placeholder="" required="" maxlength="16" value="4111111111111111">
                          <small id="bandeira" class="text-muted" style="display:none">Bandeira <img src="" /></small>
                          <div class="invalid-feedback">
                              Número do cartão é obrigatório
                          </div>
                      </div>
                  </div>
                  <div class="row">
                      <div class="col-md-3 mb-3">
                          <label for="cc-expiration">MM</label>
                          <input type="text" class="form-control" id="cc-expiration-month" placeholder="" required="" maxlength="2" value="12">
                          <div class="invalid-feedback">
                              Data de expiração é obrigatório
                          </div>
                      </div>
                      <div class="col-md-3 mb-3">
                            <label for="cc-expiration">YYYY</label>
                            <input type="text" class="form-control" id="cc-expiration-year" placeholder="" required="" maxlength="4" value="2030">
                            <div class="invalid-feedback">
                                Data de expiração é obrigatório
                            </div>
                      </div>
                      <div class="col-md-6 mb-3">
                          <label for="cc-expiration">CVV</label>
                          <input type="text" class="form-control" id="cc-cvv" placeholder="" required="" maxlength="3" value="123">
                          <div class="invalid-feedback">
                              Security code é obrigatório
                          </div>
                      </div>
                  </div>
            </div>


            <div class="col-md-6">
                <h4 class="d-flex justify-content-between align-items-center mb-3">
                  <span class="text-muted">Seu carrinho</span>
                  <span class="badge badge-secondary badge-pill">${checkout.produtos.size()}</span>
                </h4>
                <ul class="list-group mb-3">

                        <c:forEach var="i" items="${checkout.carrinho.items}">
                            <li class="list-group-item d-flex justify-content-between lh-condensed">
                                <div>
                                    <img src="${i.produto.imgDestaque}" height="80px">
                                </div>
                                <div class="col-md-8 md-4">
                                 <h6 class="my-0">${p.descricao}</h6>
                                 <small class="text-muted">${p.descricaoDetalhada}</small>
                                </div>
                                <div>
                                    <span class="text-muted">R$ <fmt:formatNumber value="${i.produto.preco}" pattern="#,##0.00" /></span>
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
                        <li class="list-group-item d-flex justify-content-between lh-condensed">
                            <div class="col-md-8 md-4">
                               <h6 class="my-0">Total de produtos</h6>
                            </div>
                            <div>
                                <span class="text-muted">R$ <fmt:formatNumber value="${checkout.valorProdutos}" pattern="#,##0.00" /></span>
                            </div>
                        </li>
                        <li class="list-group-item d-flex justify-content-between lh-condensed">
                            <div class="col-md-8 md-4">
                               <h6 class="my-0">Valor do frete</h6>
                            </div>
                            <div>
                                <span class="text-muted">R$ <fmt:formatNumber value="${checkout.valorFrete}" pattern="#,##0.00" /></span>
                            </div>
                        </li>
                        <c:if test="${checkout.cupom != null}">
                            <li class="list-group-item d-flex justify-content-between bg-light">
                              <div class="text-success">
                                <h6 class="my-0">Código de promoção</h6>
                                <small>${checkout.cupom.hash}</small>
                              </div>
                              <span class="text-success">-R$ ${checkout.valorDesconto}</span>
                            </li>
                        </c:if>
                        <li class="list-group-item d-flex justify-content-between bg-light">
                          <div class="text-primary">
                            <h6 class="my-0">Total</h6>
                          </div>
                          <span class="text-primary">R$ <fmt:formatNumber value="${checkout.valorTotal}" pattern="#,##0.00" /></span>
                        </li>

                  </ul>
                  <c:if test="${checkout.cupom == null}">
                    <div class="input-group">
                      <form id="formCupom" method="POST" action="/admin/checkout/addCupom">
                          <input type="text" id="cupom" class="form-control" placeholder="Código promocional">
                          <div class="input-group-append">
                            <button id="btnCupom" id-checkout="${checkout.id}" id-carrinho="${checkout.carrinho.idCarrinho}" type="button" class="btn btn-secondary">Resgatar</button>
                          </div>
                      </form>
                    </div>
                  </c:if>
            </div>

            <hr class="col-md-12">
            <div class="col-md-12">
                <button class="btn btn-danger" type="button" onclick="window.location.href='/admin/checkout/carrinho/' + ${checkout.carrinho.idCarrinho}">Voltar</button>
                <button id="btnCheckout" class="btn btn-primary" type="button" style="float:right">Pagar</button>
            </div>
        </div>
        </form>
    </div>
    <wjaa:footer readOnly="${readOnly}"/>
    <script type="text/javascript" src=
    "https://stc.sandbox.pagseguro.uol.com.br/pagseguro/api/v2/checkout/pagseguro.directpayment.js"></script>
    <script src="/static/js/checkout/checkout.js?v=1.7"></script>
</body>

</html>