<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="wjaa" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<header>
    <wjaa:header title="Fornecedor"/>
</header>
<body>
<wjaa:menu/>

    <div class="content">
        <h4 class="text-center"> CADASTRO DE FORNECEDOR </h4>
        <hr/>
        <wjaa:feedback/>
        <form action="/admin/FornecedorEntity/save" method="POST">
          <div class="form-row">
             <div class="form-group col-md-3">
               <label for="id" class="label-primary">#ID</label>
               <input type="number" class="form-control" name="id" id="id" readonly="readonly" value="${vo.id}">
             </div>
             <div class="form-group col-md-6">
               <label for="cnpj">CNPJ</label>
               <input type="text" class="form-control cnpj" name="cnpj" id="cnpj"
                      placeholder="00.000.000/0000-00" value="${vo.cnpj}" maxlength="18">
             </div>
              <div class="form-group offset-md-1 col-md-2">
                  <label >&nbsp;</label>
                  <div class="custom-control custom-checkbox">
                      <input type="checkbox" class="custom-control-input" id="ativo" name="ativo" <c:if test="${vo.ativo}">checked</c:if>>
                      <label class="custom-control-label" for="ativo">Ativo</label>
                  </div>
              </div>
          </div>
          <div class="form-row">
            <div class="form-group col-md-6">
              <label for="nome">Nome</label>
              <input type="text" class="form-control" name="nome" id="nome" placeholder="Nome" value="${vo.nome}" maxlength="60">
            </div>
            <div class="form-group col-md-6">
              <label for="email">Email</label>
              <input type="email" class="form-control" name="email" id="email" placeholder="Email" value="${vo.email}" maxlength="100">
            </div>
          </div>
          <div class="form-group">
            <label for="endereco">Endereço</label>
            <input type="text" class="form-control" name="endereco" id="endereco" placeholder="Endereço" value="${vo.endereco}" maxlength="200">
          </div>
          <div class="form-row">
              <div class="form-group col-md-6">
                <label for="telefonePrincipal">Telefone Comercial</label>
                <input type="phone" class="form-control" name="telefonePrincipal" id="telefonePrincipal"
                     placeholder="11 99999999" value="${vo.telefonePrincipal}" maxlength="13">
              </div>
              <div class="form-group col-md-6">
                <label for="telefoneSecundario">Celular</label>
                <input type="phone" class="form-control" name="telefoneSecundario" id="telefoneSecundario"
                       placeholder="11 99999999" value="${vo.telefoneSecundario}" maxlength="13">
              </div>
          </div>
           <div class="form-row">
               <div class="form-group col-md-12">
                 <label for="observacao" class="label-primary">OBSERVAÇÃO</label>
                 <input type="text" class="form-control" name="observacao" id="observacao" value="${vo.observacao}" maxlength="255">
               </div>
          </div>
          <div class="col-xs-12">
              <a href="/admin/FornecedorEntity" class="btn btn-success" >Voltar</a>
              <button type="submit" class="btn btn-primary btn-right">Gravar</button>
          </div>
        </form>
    </div>
<wjaa:footer readOnly="${readOnly}"/>
</body>

</html>