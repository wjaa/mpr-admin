<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="wjaa" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<header>
    <wjaa:header/>
    <link rel="stylesheet" href="/static/css/estoque/list.css?v=1.1" />
</header>
<body>
<wjaa:menu/>
    <c:set var="destiny" value="EstoqueEntity"/>
    <div class="content">
        <h4 class="text-center"> PRODUTOS EM ESTOQUE </h4>
        <hr/>
        <wjaa:feedback/>
        <div class="text-center btn-novo">
          <a href="/admin/${destiny}/0" class="btn btn-primary" >CRIAR UM NOVO LOTE</a>
        </div>
        <table class="table">
          <thead class="thead-dark">
            <tr>
              <th scope="col" class="text-center">LOTES</th>
              <th scope="col" class="text-center">NOME PRODUTO</th>
              <th scope="col" class="text-center">TIPO PRODUTO</th>
              <th scope="col" class="text-center">REFERENCIA</th>
              <th scope="col" class="text-center">QUANTIDADE</th>
            </tr>
          </thead>
          <tbody>
            <c:forEach var="e" items="${list}">
            <tr>
              <td scope="row" class="text-center">
                <a id="expand${e.idProduto}" href="#" onclick="listLote(${e.idProduto},this);"><i class="fas fa-plus-circle"></i></a>
                <a id="redunce${e.idProduto}" href="#" onclick="hideLote(${e.idProduto},this);" style="color:red; display:none;"><i class="fas fa-minus-circle"></i></a>
              </td>
              <td scope="row" class="text-center">${e.nomeProduto}</td>
              <td scope="row" class="text-center">${e.tipoProduto}</td>
              <td scope="row" class="text-center">${e.referencia}</td>
              <c:set var="cssStyle" value="quantidadeOk"/>
              <c:if test="${e.quantidade <= e.estoqueMinimo}">
                 <c:set var="cssStyle" value="quantidadeWarning"/>
              </c:if>
              <c:if test="${e.quantidade == 0}">
                 <c:set var="cssStyle" value="quantidadeZero"/>
              </c:if>
              <td scope="row" class="${cssStyle} text-center">${e.quantidade}</td>
            </tr>
            <tr id="tr${e.idProduto}" style="display:none;">
                <td>&nbsp;</td>
                <td colspan="4">
                    <div id="card${e.idProduto}" class="card-body">
                        Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put a bird on it squid single-origin coffee nulla assumenda shoreditch et. Nihil anim keffiyeh helvetica, craft beer labore wes anderson cred nesciunt sapiente ea proident. Ad vegan excepteur butcher vice lomo. Leggings occaecat craft beer farm-to-table, raw denim aesthetic synth nesciunt you probably haven't heard of them accusamus labore sustainable VHS.
                    </div>

                </td>
            </tr>
            </c:forEach>
          </tbody>
        </table>
    </div>
    <wjaa:footer/>
    <script src="/static/js/estoque/list.js?v=1.2"></script>
</body>

</html>