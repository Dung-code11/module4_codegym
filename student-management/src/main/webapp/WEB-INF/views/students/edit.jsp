<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head><title>Sửa sinh viên</title>
<meta charset="UTF-8">
</head>
<body>
<h2>Sửa sinh viên</h2>
<a href="${pageContext.request.contextPath}/students">Quay lại danh sách</a>

<form method="post" action="${pageContext.request.contextPath}/students/${studentForm.id}/edit">
    <p>
        <label>Mã số (không đổi):</label><br/>
        <input type="text" name="id" value="${studentForm.id}" readonly/>
        <c:if test="${errors['id'] != null}">
            <span style="color:red">${errors['id']}</span>
        </c:if>
    </p>

    <p>
        <label>Họ tên:</label><br/>
        <input type="text" name="name" value="${studentForm.name}"/>
        <c:if test="${errors['name'] != null}">
            <span style="color:red">${errors['name']}</span>
        </c:if>
    </p>

    <p>
        <label>Điểm tổng kết (GPA):</label><br/>
        <input type="number" step="0.1" name="gpa" value="${studentForm.gpa}"/>
        <c:if test="${errors['gpa'] != null}">
            <span style="color:red">${errors['gpa']}</span>
        </c:if>
    </p>

    <p><button type="submit">Cập nhật</button></p>
</form>
</body>
</html>
