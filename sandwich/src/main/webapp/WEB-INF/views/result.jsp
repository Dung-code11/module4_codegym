<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Kết quả</title>
</head>
<body>
<h2>Các gia vị bạn chọn:</h2>
<c:if test="${condiments != null}">
    <ul>
        <c:forEach var="c" items="${condiments}">
            <li>${c}</li>
        </c:forEach>
    </ul>
</c:if>
<c:if test="${condiments == null}">
    <p>Bạn chưa chọn gia vị nào!</p>
</c:if>
<a href="/">Quay lại</a>
</body>
</html>
