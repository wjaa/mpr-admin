<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="wjaa" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<wjaa:header title="Fornecedor"/>
<body>
<wjaa:menu/>
<c:set var="destiny" value="CatalogoEntity"/>
<div class="content">
    <h4 class="text-center">Imagens Exclusivas</h4>
    <hr/>
    <wjaa:feedback/>
    <form action="/admin/${destiny}/save" method="POST" enctype="multipart/form-data">
        <div class="form-row">
            <div class="form-group col-md-2">
                <label for="id" class="label-primary">#ID</label>
                <input type="number" class="form-control" name="id" id="id" readonly="readonly" value="${vo.id}">
            </div>
            <div class="form-group col-md-3">
                <label for="descricao">CATALOGO</label>
                <select name="idCatalogoGrupo" class="form-control">
                    <option value="">--Selecione--</option>
                    <c:forEach var="t" items="${vo.listCatalogoGrupo}">
                        <option value="${t.id}" <c:if test="${t.id == vo.idCatalogoGrupo}">selected</c:if> >
                           ${t.nome}
                        </option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group col-md-5">
                <label for="descricao">NOME</label>
                <input type="text" class="form-control" name="descricao" id="descricao"
                       placeholder="Descrição" value="${vo.descricao}" maxlength="80">
            </div>
             <div class="form-group col-md-2">
                <label >&nbsp;</label>
                <div class="custom-control custom-checkbox">
                    <input type="checkbox" class="custom-control-input" id="ativo" name="ativo" <c:if test="${vo.ativo}">checked</c:if>>
                    <label class="custom-control-label" for="ativo">Imagem ativa?</label>
                </div>
            </div>
        </div>
        <div class="form-row">
            <div class="form-group col col-md-6">
                <div class="alert alert-success">
                    <div class="col-xs-12 form-group"  >
                        <label  class="col-lg-12 control-label font12">Imagem exclusiva.</label>
                        <div class="col-xs-12"  >
                            <div  class="img-thumbnail text-center">
                                <input type="hidden" value="${vo.img}" name="img"/>
                                <img src="http://stc.meuportaretrato.com/images/catalogo/${vo.img}" class="img-thumbnail" onerror="this.src='/static/img/notfound.png';" style="height: 200px!important;">
                            </div>
                        </div>
                    </div>

                    <div class="form-group col-md-12">
                        <div id="divBtnImagem" class="col-xs-6 form-group text-center">
                             <label for="destaque" class="col-lg-12 control-label ">Escolha uma imagem<font color="red">*</font> :</label>
                             <div class="col-xs-12">
                                <input id="destaque" class="file-loading " type="file" name="fileImg" accept="image/*"  >
                             </div>
                        </div>
                    </div>

                </div>
            </div>
         </div>
        <div class="col-xs-12">
            <a href="/admin/${destiny}" class="btn btn-success" >Voltar</a>
            <button type="submit" class="btn btn-primary btn-right">Gravar</button>
        </div>
    </form>
</div>
<wjaa:footer readOnly="${readOnly}"/>
</body>

</html>