<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="wjaa" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<header>
    <wjaa:header title="Fornecedor"/>
</header>
<body>
<wjaa:menu/>
<c:set var="destiny" value="ProdutoEntity"/>
<div class="content">
    <h4 class="text-center">CADASTRO DE PRODUTO </h4>
    <hr/>
    <wjaa:feedback/>
    <form action="/admin/${destiny}/save" method="POST" enctype="multipart/form-data">
        <div class="form-row">
            <div class="form-group col-md-3">
                <label for="id" class="label-primary">#ID</label>
                <input type="number" class="form-control" name="id" id="id" readonly="readonly" value="${vo.id}" >
            </div>
            <div class="form-group col-md-4">
                <label for="descricao">TIPO DE PRODUTO</label>
                <select name="idTipoProduto" class="form-control">
                    <option value="">--Selecione--</option>
                    <c:forEach var="t" items="${vo.listTipoProdutos}">
                        <option value="${t.id}" <c:if test="${t.id == vo.idTipoProduto}">selected</c:if> >
                           ${t.descricao}
                        </option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group col-md-3">
                <label for="referencia" class="label-primary">Referência</label>
                <input type="text" class="form-control" name="referencia" id="referencia" value="${vo.referencia}" maxlength="50" >
            </div>
            <div class="form-group col-md-2">
                <label >&nbsp;</label>
                <div class="custom-control custom-checkbox">
                    <input type="checkbox" class="custom-control-input" id="ativo" name="ativo" <c:if test="${vo.ativo}">checked</c:if>>
                    <label class="custom-control-label" for="ativo">Produto ativo?</label>
                </div>
            </div>
        </div>

        <div class="form-row">
            <div class="form-group col-md-5">
                <label for="id" class="label-primary">DESCRIÇÃO</label>
                <input type="text" class="form-control" name="descricao" id="descricao"
                       placeholder="DESCRIÇÃO DO PRODUTO" value="${vo.descricao}" maxlength="80">
            </div>
            <div class="form-group col-md-3">
                <label for="peso">QTDE DE FOTOS</label>
                <input type="text" class="form-control" name="qtdeFotos" id="qtdeFotos"
                        value="${vo.qtdeFotos}" maxlength="10"/>
            </div>
            <div class="form-group col-md-2">
                <label for="peso">ESTOQUE MÍNIMO</label>
                <input type="text" class="form-control" name="estoqueMinimo" id="estoqueMinimo"
                        value="${vo.estoqueMinimo}" maxlength="10"/>
            </div>
            <div class="form-group col-md-2">
                <label for="peso">PREÇO</label>
                <input type="text" class="form-control money" name="preco" id="preco"
                        <c:if test="${vo.id > 0}"> readOnly="readOnly" </c:if>
                       placeholder="0,00" value="<fmt:formatNumber value="${vo.preco}" pattern="#,##0.00" />" maxlength="9"/>
            </div>
        </div>

        <div class="form-row">
            <div class="form-group col-md-12">
                <label for="id" class="label-primary">DESCRIÇÃO DETALHADA</label>
                <textarea class="form-control" id="descricaoDetalhada" name="descricaoDetalhada" rows="5" maxlength="1000">${vo.descricaoDetalhada}</textarea>
            </div>
        </div>

        <div class="form-row">
            <div class="form-group col-md-2">
                <label for="peso">PESO C/ CAIXA</label>
                <input type="text" class="form-control money" name="peso" id="peso"
                       placeholder="0,00" value="<fmt:formatNumber value="${vo.peso}" pattern="#,##0.00" />" maxlength="9"/>
            </div>
            <div class="form-group col-md-2">
                <label for="comp">COMPRIMENTO</label>
                <input type="text" class="form-control money" name="comp" id="comp"
                       placeholder="0,00" value="<fmt:formatNumber value="${vo.comp}" pattern="#,##0.00" />" maxlength="9"/>
            </div>
            <div class="form-group col-md-2">
                <label for="larg">LARGURA</label>
                <input type="text" class="form-control money" name="larg" id="larg"
                       placeholder="0,00" value="<fmt:formatNumber value="${vo.larg}" pattern="#,##0.00" />" maxlength="9"/>
            </div>
            <div class="form-group col-md-2">
                <label for="alt">ALTURA</label>
                <input type="text" class="form-control money" name="alt" id="alt"
                       placeholder="0,00" value="<fmt:formatNumber value="${vo.alt}" pattern="#,##0.00" />" maxlength="9"/>
            </div>
            <div class="form-group col-md-2">
                <label >&nbsp;</label>
                <div class="custom-control custom-checkbox">
                    <input type="checkbox" class="custom-control-input" id="lancamento" name="lancamento" <c:if test="${vo.lancamento}">checked</c:if>>
                    <label class="custom-control-label" for="lancamento">Lançamento</label>
                </div>
            </div>
            <div class="form-group col-md-2">
                <label >&nbsp;</label>
                <div class="custom-control custom-checkbox">
                    <input type="checkbox" class="custom-control-input" id="popular" name="popular" <c:if test="${vo.popular}">checked</c:if>>
                    <label class="custom-control-label" for="popular">Popular</label>
                </div>
            </div>
        </div>

        <div class="form-row">

            <div class="form-group col-md-3">
                <label for="id" class="label-primary">Nome da cor</label>
                <input type="text" class="form-control" name="nomeCor" id="nomeCor"
                       placeholder="COR DO PRODUTO" value="${vo.nomeCor}" maxlength="50">
            </div>
            <div class="form-group col-md-3">
                <label for="peso">Hexa da cor</label>
                <input type="text" class="form-control" name="hexaCor" id="hexaCor"
                       placeholder="#FFFFFF" value="${vo.hexaCor}" maxlength="7"/>
            </div>
            <div id="colorSquare" class="form-group col-md-6" style="font-size:60px; color:${vo.hexaCor};">
                <label>&nbsp;</label>
                <i class="fas fa-square"></i>
                <i class="far fa-square"></i>
                <i class="fas fa-circle"></i>
                <i class="far fa-circle"></i>
            </div>
        </div>

        <div class="form-row">
            <div class="form-group col col-md-4">
                <div class="alert alert-success">
                    <div class="col-xs-12 form-group"  >
                        <label  class="col-lg-12 control-label font12">FOTO DESTAQUE PRODUTO (Usado no módulo de operações)</label>
                        <div class="col-xs-12"  >
                            <div  class="img-thumbnail text-center">
                                <img src="http://stc.meuportaretrato.com/images/d/${vo.imgDestaque}" class="img-thumbnail" onerror="this.src='/static/img/notfound.png';" style="height: 200px!important;">
                            </div>
                        </div>
                    </div>

                    <div class="form-group col-md-12">
                        <div id="divBtnImagem" class="col-xs-6 form-group text-center">
                             <label for="destaque" class="col-lg-12 control-label ">Escolha uma imagem<font color="red">*</font> :</label>
                             <div class="col-xs-12">
                                <input id="destaque" class="file-loading " type="file" name="destaque" accept="image/*"  >
                             </div>
                        </div>
                    </div>

                </div>
            </div>
            <div class="form-group col col-md-4">
                <div class="alert alert-secondary">
                    <div class="col-xs-12 form-group "  >
                        <label  class="col-lg-12 control-label font12">IMAGEM PREVIEW RETRATO (Usada para gerar preview do cliente)</label>
                        <div class="col-xs-12"  >
                            <div  class="img-thumbnail text-center">
                                <img src="http://stc.meuportaretrato.com/images/p/${vo.imgPreview}" onerror="this.src='/static/img/notfound.png';" class="img-thumbnail" style="height: 200px!important;">
                            </div>
                        </div>
                    </div>
                    <div class="form-group col-md-12">
                        <div id="divBtnImagem" class="col-xs-6 form-group text-center">
                             <label for="preview" class="col-lg-12 control-label">Escolha uma imagem:<font color="red">*</font> :</label>
                             <div class="col-xs-12">
                                <input id="preview" class="file-loading " type="file" name="preview" accept="image/*"  >
                             </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-group col col-md-4">
                <div class="alert alert-secondary">
                    <div class="col-xs-12 form-group "  >
                        <label  class="col-lg-12 control-label font12">IMAGEM PREVIEW PAISAGEM (Usada para gerar preview do cliente)</label>
                        <div class="col-xs-12"  >
                            <div  class="img-thumbnail text-center">
                                <img src="http://stc.meuportaretrato.com/images/p/${vo.imgPreviewPaisagem}" onerror="this.src='/static/img/notfound.png';" class="img-thumbnail" style="height: 200px!important;">
                            </div>
                        </div>
                    </div>
                    <div class="form-group col-md-12">
                        <div id="divBtnImagem" class="col-xs-6 form-group text-center">
                             <label for="preview" class="col-lg-12 control-label">Escolha uma imagem:<font color="red">*</font> :</label>
                             <div class="col-xs-12">
                                <input id="preview" class="file-loading " type="file" name="previewPaisagem" accept="image/*"  >
                             </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="form-row">
            <div class="form-group col col-md-6">
                <div class="alert alert-primary font12" role="alert">
                  Imagem de destaque secundária será apresentada quando o cliente abrir o detalhamento de um produto.
                </div>
                <table class="table table-bordered">
                    <thead class="thead-dark ">
                        <tr>
                            <th>Ação</th>
                            <th>Imagem destaque segundaria</th>
                        </tr>
                    </thred>
                    <tbody>
                        <c:forEach var="i" items="${vo.listImgDestaque}" varStatus="status" >
                        <tr id="tr${i.id}">
                            <input type="hidden" name="listImgDestaque[${status.index}].id" value="${i.id}"/>
                            <input type="hidden" name="listImgDestaque[${status.index}].img" value="${i.img}" />
                            <td><button class="btn btn-danger" onclick="$('#tr${i.id}').remove();"><i class="fas fa-trash-alt"></i> </button></td>
                            <td><img src="http://stc.meuportaretrato.com/images/d/${i.img}" onerror="this.src='/static/img/notfound.png';" class="img-thumbnail" style="height: 70px!important;"></td>
                        </tr>
                        </c:forEach>
                    </tbody>
                </table>

            </div>

            <div class="col-md-6">
                  <input type="file" class="form-control" id="listDestaque" name="listDestaque"  multiple/>
            </div>


        </div>


        <div class="col-xs-12">
            <a href="/admin/${destiny}" class="btn btn-success" >Voltar</a>
            <button type="submit" class="btn btn-primary btn-right">Gravar</button>
        </div>
    </form>
</div>
<wjaa:footer readOnly="${readOnly}"/>
<script src="/static/js/produto/view.js?v=1"></script>
</body>

</html>