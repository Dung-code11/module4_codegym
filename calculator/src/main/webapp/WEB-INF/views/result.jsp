<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Kết quả</title>
</head>
<body>
<h2>Kết quả tính toán</h2>

<c:if test="${error != null}">
    <p style="color:red">${error}</p>
</c:if>

<c:if test="${error == null}">
    <p>${num1} ${operator} ${num2} = <b>${result}</b></p>
</c:if>

<a href="/">Quay lại</a>
</body>
</html>
