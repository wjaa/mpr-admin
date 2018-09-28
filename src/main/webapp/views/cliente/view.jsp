<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="wjaa" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <header>
        <wjaa:header title="Clientes"/>
        <link href="https://cdnjs.cloudflare.com/ajax/libs/gijgo/1.9.10/combined/css/gijgo.min.css" rel="stylesheet" type="text/css" />
    </header>
<body>
<wjaa:menu/>

    <div class="content">
        <h4 class="text-center"> CLIENTE </h4>
        <hr/>
        <wjaa:feedback/>
        <form action="/admin/ClienteEntity/save" method="POST">
          <div class="form-row">
             <div class="form-group col-md-2">
               <label for="id" class="label-primary">#ID</label>
               <input type="number" class="form-control" name="id" id="id" readonly="readonly" value="${vo.id}">
             </div>
             <div class="form-group col-md-5">
                 <label for="nome">NOME</label>
                 <input type="text" class="form-control" name="nome" id="nome" placeholder="NOME DO CLIENTE" value="${vo.nome}">
             </div>
              <div class="form-group col-md-5">
                  <label for="email">NOME</label>
                  <input type="text" class="form-control" name="email" id="email" placeholder="exemplo@cliente.com" value="${vo.email}">
              </div>
          </div>
          <div class="form-row">
            <div class="form-group col-md-3">
              <label for="cpf">CPF</label>
              <input type="text" class="form-control" name="cpf" id="cpf" placeholder="000.000.000-00" value="${vo.cpf}">
            </div>
            <div class="form-group col-md-3">
              <label for="celular">CELULAR</label>
              <input type="text" class="form-control" name="celular" id="celular" placeholder="11999999999" value="${vo.celular}">
            </div>
            <div class="form-group col-md-3">
               <label for="aniversario">ANIVERSÁRIO</label>
               <input type="text" class="form-control" name="aniversario" id="aniversario" placeholder="01/01/2000" value="<fmt:formatDate value="${vo.aniversario}" pattern="dd/MM/yyyy"></fmt:formatDate>">
            </div>
            <div class="form-group col-md-3">
               <label >&nbsp;</label>
                 <div class="custom-control custom-checkbox">
                     <input type="checkbox" class="custom-control-input" id="ativo" name="ativo" <c:if test="${vo.ativo}">checked</c:if>>
                     <label class="custom-control-label" for="ativo">Ativo</label>
                 </div>
            </div>
          </div>
          <c:forEach var="e" items="${vo.enderecos}" varStatus="status">
                <input type="hidden" name="enderecos[${status.index}].principal" value="${e.principal}"/>
                <input type="hidden" name="enderecos[${status.index}].descricao" value="${e.descricao}"/>
                <div class="card">
                  <div class="card-body">

                    <h5 class="card-title">${e.descricao}<c:if test="${e.principal}"> - <span class="badge badge-secondary">Principal</span></c:if></h5>
                    <hr/>
                        <div class="form-group col-md-12">
                             <div class="custom-control custom-checkbox">
                                 <input type="checkbox" class="custom-control-input" id="enderecos.ativo" name="enderecos[${status.index}].ativo" <c:if test="${e.ativo}">checked</c:if>>
                                 <label class="custom-control-label" for="ativo">Ativo</label>
                             </div>
                        </div>
                        <div class="form-row">
                             <input type="hidden" name="enderecos[${status.index}].id" id="enderecos.id" value="${e.id}">
                             <input type="hidden" name="enderecos[${status.index}].idCliente" id="enderecos.idCliente" value="${e.idCliente}">
                             <div class="form-group col-md-2">
                               <label for="id" class="label-primary">CEP</label>
                               <input type="text" class="form-control" name="enderecos[${status.index}].cep" id="enderecos.cep" value="${e.cep}">
                             </div>
                             <div class="form-group col-md-8">
                                 <label for="nome">LOGRADOURO</label>
                                 <input type="text" class="form-control" name="enderecos[${status.index}].logradouro" id="enderecos.logradouro" placeholder="LOGRADOURO" value="${e.logradouro}">
                             </div>
                              <div class="form-group col-md-2">
                                  <label for="email">NUMERO</label>
                                  <input type="text" class="form-control" name="enderecos[${status.index}].numero" id="enderecos.numero" placeholder="Número" value="${e.numero}">
                              </div>
                        </div>
                        <div class="form-row">
                             <div class="form-group col-md-5">
                               <label for="id" class="label-primary">COMPLEMENTO</label>
                               <input type="text" class="form-control" name="enderecos[${status.index}].complemento" id="enderecos.complemento" value="${e.complemento}">
                             </div>
                             <div class="form-group col-md-3">
                                 <label for="nome">BAIRRO</label>
                                 <input type="text" class="form-control" name="enderecos[${status.index}].bairro" id="enderecos.bairro" placeholder="BAIRRO" value="${e.bairro}">
                             </div>
                              <div class="form-group col-md-3">
                                  <label for="email">CIDADE</label>
                                  <input type="text" class="form-control" name="enderecos[${status.index}].cidade" id="enderecos.cidade" placeholder="Cidade" value="${e.cidade}">
                              </div>
                              <div class="form-group col-md-1">
                                    <label for="email">UF</label>
                                    <input type="text" class="form-control" name="enderecos[${status.index}].uf" id="enderecos.uf" placeholder="UF" value="${e.uf}">
                              </div>
                        </div>
                        <div class="form-row">
                             <div class="form-group col-md-12">
                               <label for="observacao" class="label-primary">OBSERVAÇÃO</label>
                               <input type="text" class="form-control" name="enderecos[${status.index}].observacao" id="enderecos.observacao" value="${e.observacao}">
                             </div>
                        </div>
                  </div>
                </div>


          </c:forEach>

          <div class="col-xs-12">
              <a href="/admin/ClienteEntity" class="btn btn-success" >Voltar</a>
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