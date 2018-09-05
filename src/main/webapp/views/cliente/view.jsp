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
            <div class="form-group col-md-4">
              <label for="cpf">CPF</label>
              <input type="text" class="form-control" name="cpf" id="cpf" placeholder="000.000.000-00" value="${vo.cpf}">
            </div>
            <div class="form-group col-md-4">
              <label for="celular">CELULAR</label>
              <input type="text" class="form-control" name="celular" id="celular" placeholder="11999999999" value="${vo.celular}">
            </div>
            <div class="form-group col-md-4">
               <label for="aniversario">ANIVERSÁRIO</label>
               <input type="text" class="form-control" name="aniversario" id="aniversario" placeholder="01/01/2000" value="${vo.aniversario}">
            </div>
          </div>

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