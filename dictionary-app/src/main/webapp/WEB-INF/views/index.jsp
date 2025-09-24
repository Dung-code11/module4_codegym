<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Dictionary App</title>
</head>
<body>
<h2>Từ điển Anh - Việt</h2>
<form action="translate" method="post">
    <input type="text" name="word" placeholder="Nhập từ tiếng Anh"/>
    <button type="submit">Dịch</button>
</form>

<c:if test="${not empty result}">
    <p>Kết quả: ${result}</p>
</c:if>
</body>
</html>
