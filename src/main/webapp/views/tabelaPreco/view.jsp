<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="wjaa" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <header>
        <wjaa:header title="Tabela de preço"/>
        <link href="https://cdnjs.cloudflare.com/ajax/libs/gijgo/1.9.10/combined/css/gijgo.min.css" rel="stylesheet" type="text/css" />
    </header>
<body>
<wjaa:menu/>

    <div class="content">
        <h4 class="text-center"> TABELA DE PREÇO </h4>
        <hr/>
        <wjaa:feedback/>
        <form action="/admin/TabelaPrecoEntity/save" method="POST">
          <div class="form-row">
             <div class="form-group col-md-3">
               <label for="id" class="label-primary">#ID</label>
               <input type="number" class="form-control" name="id" id="id" readonly="readonly" value="${vo.id}">
             </div>
             <div class="form-group col-md-5">
                 <label for="idProduto">PRODUTO</label>
                 <select id="idProduto" name="idProduto" class="form-control">
                     <option value="">--Selecione--</option>
                     <c:forEach var="p" items="${vo.produtos}">
                         <option value="${p.id}" <c:if test="${p.id == vo.idProduto}">selected</c:if> >
                                 ${p.descricao}
                         </option>
                     </c:forEach>
                 </select>
             </div>
              <div class="form-group col-md-4">
                  <label for="id" class="label-primary">DATA VIGÊNCIA</label>
                  <input type="text" class="form-control data" name="dataVigencia" id="dataVigencia"
                                         placeholder="DD/MM/YYYY" value="<fmt:formatDate value="${vo.dataVigencia}" pattern="dd/MM/yyyy"/> " maxlength="10">
              </div>
          </div>
          <div class="form-row">
            <div class="form-group col-md-6">
              <label for="nome">DESCRIÇÃO</label>
              <input type="text" class="form-control" name="descricao" id="descricao" placeholder="DESCRIÇÃO" value="${vo.descricao}" maxlength="50">
            </div>
            <div class="form-group col-md-6">
              <label for="id" class="label-primary">VALOR (UN) COMPRA</label>
              <div class="input-group mb-3">
                  <div class="input-group-prepend">
                      <span class="input-group-text" id="basic-addon1">R$</span>
                  </div>
                  <input type="text" class="form-control money" name="preco" id="preco"
                         placeholder="0,00" value="<fmt:formatNumber value="${vo.preco}" pattern="#,##0.00"/>" maxlength="9"/>
              </div>
            </div>
          </div>

          <div class="col-xs-12">
              <a href="/admin/TabelaPrecoEntity" class="btn btn-success" >Voltar</a>
              <button type="submit" class="btn btn-primary btn-right">Gravar</button>
          </div>
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