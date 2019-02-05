<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="wjaa" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <header>
        <wjaa:header title="Pedido criado com sucesso."/>
    </header>
<body>
<wjaa:menu/>
    <div class="content">
        <h4 class="text-center"> PEDIDO CRIADO COM SUCESSO</h4>
        <hr/>
        <wjaa:feedback/>

    </div>
    <wjaa:footer readOnly="${readOnly}"/>
</body>

</html>