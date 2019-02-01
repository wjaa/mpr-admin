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
        <form action="/admin/ClienteEntity/save" method="POST">
            <input type="hidden" class="form-control" id="token" value="${token}">
            <div class="col-md-4 order-md-2 mb-4">
              <h4 class="d-flex justify-content-between align-items-center mb-3">
                <span class="text-muted">Seu carrinho</span>
                <span class="badge badge-secondary badge-pill">3</span>
              </h4>
              <ul class="list-group mb-3">
                <li class="list-group-item d-flex justify-content-between lh-condensed">
                  <div>
                    <h6 class="my-0">Nome do produto</h6>
                    <small class="text-muted">Breve descrição</small>
                  </div>
                  <span class="text-muted">R$12</span>
                </li>
                <li class="list-group-item d-flex justify-content-between lh-condensed">
                  <div>
                    <h6 class="my-0">Segundo produto</h6>
                    <small class="text-muted">Breve descrição</small>
                  </div>
                  <span class="text-muted">R$8</span>
                </li>
                <li class="list-group-item d-flex justify-content-between lh-condensed">
                  <div>
                    <h6 class="my-0">Terceiro item</h6>
                    <small class="text-muted">Breve descrição</small>
                  </div>
                  <span class="text-muted">R$5</span>
                </li>
                <li class="list-group-item d-flex justify-content-between bg-light">
                  <div class="text-success">
                    <h6 class="my-0">Código de promoção</h6>
                    <small>CODIGOEXEMEPLO</small>
                  </div>
                  <span class="text-success">-R$5</span>
                </li>
                <li class="list-group-item d-flex justify-content-between">
                  <span>Total (BRL)</span>
                  <strong>R$20</strong>
                </li>
              </ul>
              <form class="card p-2">
                <div class="input-group">
                  <input type="text" class="form-control" placeholder="Código promocional">
                  <div class="input-group-append">
                    <button type="submit" class="btn btn-secondary">Resgatar</button>
                  </div>
                </div>
              </form>
            </div>

        <div class="row">
          <div class="col-md-6 mb-3">
              <label for="cc-name">Id do cliente</label>
              <input type="text" class="form-control" id="cc-name" placeholder="" required="">
              <small class="text-muted">Nome completo como mostrado no cartão</small>
              <div class="invalid-feedback">
                  Nome no cartão é obrigatório.
              </div>
          </div>
          <div class="col-md-6 mb-3">
              <label for="cc-number">Número do cartão de crédito</label>
              <input type="text" class="form-control" id="cc-number" placeholder="" required="">
              <div class="invalid-feedback">
                  Número do cartão é obrigatório
              </div>
          </div>
        </div>

          <div class="d-block my-3">
              <div class="custom-control custom-radio">
                  <input id="credit" name="paymentMethod" type="radio" class="custom-control-input" checked="" required="">
                  <label class="custom-control-label" for="credit">Cartão de crédito</label>
              </div>
              <div class="custom-control custom-radio">
                  <input id="boleto" name="paymentMethod" type="radio" class="custom-control-input" required="">
                  <label class="custom-control-label" for="boleto">Boleto</label>
              </div>
          </div>
          <div class="row">
              <div class="col-md-6 mb-3">
                  <label for="cc-name">Nome no cartão</label>
                  <input type="text" class="form-control" id="cc-name" placeholder="" required="">
                  <small class="text-muted">Nome completo como mostrado no cartão</small>
                  <div class="invalid-feedback">
                      Nome no cartão é obrigatório.
                  </div>
              </div>
              <div class="col-md-6 mb-3">
                  <label for="cc-number">Número do cartão de crédito</label>
                  <input type="text" class="form-control" id="cc-number" placeholder="" required="">
                  <div class="invalid-feedback">
                      Número do cartão é obrigatório
                  </div>
              </div>
          </div>
          <div class="row">
              <div class="col-md-3 mb-3">
                  <label for="cc-expiration">Data de expiração</label>
                  <input type="text" class="form-control" id="cc-expiration" placeholder="" required="">
                  <div class="invalid-feedback">
                      Data de expiração é obrigatório
                  </div>
              </div>
              <div class="col-md-3 mb-3">
                  <label for="cc-expiration">CVV</label>
                  <input type="text" class="form-control" id="cc-cvv" placeholder="" required="">
                  <div class="invalid-feedback">
                      Security code é obrigatório
                  </div>
              </div>
          </div>
          <hr class="mb-4">
          <button class="btn btn-primary btn-lg btn-block" type="submit">Checkout</button>
        </form>
    </div>
    <wjaa:footer readOnly="${readOnly}"/>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/gijgo/1.9.10/combined/js/gijgo.min.js" type="text/javascript"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/gijgo/1.9.10/combined/js/messages/messages.pt-br.min.js" type="text/javascript"></script>
    <script>
        $('.data').datepicker({
            uiLibrary: 'bootstrap4',
            locale: "pt-br",
            format: 'dd/mm/yyyy'
        });

    </script>
</body>

</html>