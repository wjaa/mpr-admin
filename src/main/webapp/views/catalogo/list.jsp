<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="wjaa" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<wjaa:header/>
<body>
<wjaa:menu/>
    <c:set var="destiny" value="CatalogoEntity"/>
    <div class="content">
        <h4 class="text-center"> LISTA DE IMAGENS EXCLUSIVAS </h4>
        <hr/>
        <wjaa:feedback/>
        <div class="text-center btn-novo">
          <a href="/admin/${destiny}/0" class="btn btn-primary" >ADICIONAR NOVA IMAGEM EXCLUSIVA</a>
        </div>
        <table class="table">
          <thead class="thead-dark">
            <tr>
              <th scope="col">#ID</th>
              <th scope="col">IMAGEM</th>
              <th scope="col">DESCRICAO</th>
              <th scope="col">CATALOGO</th>
              <th scope="col">ATIVO</th>
              <th scope="col">AÇÃO</th>
            </tr>
          </thead>
          <tbody>
            <c:forEach var="t" items="${list}">
            <tr>
              <td scope="row"><a href="/admin/${destiny}/${t.id}?readOnly=true" >${t.id}</a></td>
              <td><img src="http://stc.meuportaretrato.com/images/catalogo/${p.img}" class="img-thumbnail" style="height: 50px!important;"></td>
              <td><a href="/admin/${destiny}/${t.id}?readOnly=true">${t.descricao}</a></td>
              <td><a href="/admin/${destiny}/${t.id}?readOnly=true">${t.catalogoGrupo.nome}</a></td>
              <td><c:if test="${t.ativo}">SIM</c:if><c:if test="${!t.ativo}">NÃO</c:if> </td>
              <td align="center">
                <a href="/admin/${destiny}/${t.id}" class="btn btn-success"><i class="fas fa-edit"></i></a>
                <a href="#" onclick="remover(${t.id}, '${t.descricao}')" class="btn btn-danger"><i class="fas fa-trash"></i></i></a>
               </td>
            </tr>
            </c:forEach>
          </tbody>
        </table>
    </div>
<wjaa:footer/>
</body>
<script>
    function remover(id, nome){
        Utils.confirmDlg("Tem certeza que deseja remover a imagem [ <b>'" + nome + "'</b> ]?", function(result){
            if (result){
                $.ajax({
                  method: "DELETE",
                  url: "/admin/${destiny}/" + id,
                  success: function(){
                    window.location.href = '/admin/CatalogoEntity';
                  },
                  error: function(response){
                    console.log(response);
                    Utils.showAlert(response.responseText);
                  },
                })

            }

        });
    }

</script>
</html>