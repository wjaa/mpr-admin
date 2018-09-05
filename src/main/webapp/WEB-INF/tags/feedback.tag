<%@tag pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${errorMessage != null}">
    <div class="alert alert-danger alert-dismissible fade show" role="alert">
        <h4>${errorMessage.errorDetail}</h4>
        <c:forEach var="e" items="${errorMessage.errorMessage}">
            <p>${e}</p>
        </c:forEach>
        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
            <span aria-hidden="true">&times;</span>
        </button>
    </div>
</c:if>
<c:if test="${successMessage != null}">
    <div class="alert alert-success alert-dismissible fade show" role="alert">
        <h3>${successMessage}</h3>
        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
            <span aria-hidden="true">&times;</span>
        </button>
    </div>
</c:if>
