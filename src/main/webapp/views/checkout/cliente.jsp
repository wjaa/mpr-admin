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
        <h4 class="text-center"> CHECKOUT TEST - LOGIN</h4>
        <hr/>
        <wjaa:feedback/>
        <form action="/admin/checkout/login" method="POST" enctype="multipart/form-data">
            <div class="row">
                <div class="form-group col-md-6">
                    <div class="form-group offset-md-2 col-md-6" style="margin-top:50px;">
                        <button class="btn btn-primary btn-block" type="button">Cliente não autenticado</button>
                    </div>
                </div>

                <div class="form-group col-md-6">

                    <c:if test="${auth != null}">
                        <div class="form-group offset-md-2 col-md-6">
                              <label for="id" class="label-primary">Você está logado com <a href="/admin/checkout/carrinho" >${auth.username}</a></label>
                              <button class="btn btn-danger btn-block" type="button" onclick="window.location.href='/admin/checkout/logoff'">Sair</button>
                        </div>

                    </c:if>
                    <c:if test="${auth == null}">
                        <div class="form-group offset-md-2 col-md-6">
                            <label for="id" class="label-primary">Usuário</label>
                            <input type="text" class="form-control" name="username" id="username" required>
                        </div>
                        <div class="form-group offset-md-2 col-md-6">
                            <label for="id" class="label-primary">Senha</label>
                            <input type="text" class="form-control" name="password" id="password" required>
                        </div>
                        <div class="form-group offset-md-2 col-md-6">
                            <button class="btn btn-primary btn-block" type="submit">Entrar</button>
                        </div>
                    </c:if>
                </div>
            </div>
        </form>
    </div>
    <wjaa:footer readOnly="${readOnly}"/>
</body>

</html>