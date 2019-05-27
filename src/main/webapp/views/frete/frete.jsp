<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="wjaa" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<header>
    <wjaa:header title="Calcular Frete"/>
</header>
<body>
<wjaa:menu/>
<div class="content">

        <h4 class="text-center"> Calcular Frete </h4>
        <hr/>
        <wjaa:feedback/>
        <div class="row">
            <div class="col-md-8">
                <div class="col-md-12">
                    <div class="form-row">
                        <div class="form-group col-md-12">
                            <label for="idProduto">PRODUTO</label>
                            <select id="idProduto" name="idProduto" class="form-control" required>
                                <option value="">--Selecione--</option>
                                <c:forEach var="p" items="${produtos}">
                                    <option value="${p.id}">${p.descricao}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group col-md-6">
                            <label for="cep">Calcular frete</label>
                            <input type="text" class="form-control" id="cep" name="cep"  maxlength="8">
                        </div>
                        <div class="form-group col-md-6">
                            <label class="col-md-12" for="btnCalculoFrete">&nbsp;</label>
                            <button id="btnCalculoFrete" type="button" class="btn btn-success" >Calcular Frete</button>
                        </div>
                        <div class="form-group col-md-12">
                            <table class="table table-bordered">
                              <thead>
                                <tr>
                                  <th scope="col">Tipo Frete</th>
                                  <th scope="col">Data entrega</th>
                                  <th scope="col">Dias entrega</th>
                                  <th scope="col">Valor</th>
                                  <th scope="col" class="text-center">Obs</th>
                                  <th scope="col" class="text-center">Erro</th>
                                </tr>
                              </thead>
                              <tbody id="resultFrete">

                              </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
</div>


<wjaa:footer/>
<script src="/static/js/frete/frete.js?v=4"></script>
</body>

</html>