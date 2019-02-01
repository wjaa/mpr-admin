<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="wjaa" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <header>
        <wjaa:header title="Escolha um cliente"/>
    </header>
<body>
<wjaa:menu/>
    <div class="content">
        <h4 class="text-center"> CHECKOUT TEST - ESCOLHA UM CLIENTE</h4>
        <hr/>
        <wjaa:feedback/>
        <form action="/admin/checkout/carrinho" method="POST" enctype="multipart/form-data">
            <div class="row">
                <div class="form-group col-md-6">
                    <label for="idCliente">Clientes</label>
                    <select id="idCliente" name="idCliente" class="form-control" required>
                        <option value="">--Selecione--</option>
                        <c:forEach var="c" items="${clientes}">
                            <option value="${c.id}">${c.nome}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group col-md-2">
                    <label for="idCliente">&nbsp;</label>
                    <button class="btn btn-primary btn-block" type="submit">Próximo</button>
                </div>
            </div>
        </form>
    </div>
    <wjaa:footer readOnly="${readOnly}"/>
</body>

</html>