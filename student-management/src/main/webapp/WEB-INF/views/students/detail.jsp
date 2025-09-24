<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head><title>Chi tiết sinh viên</title>
<meta charset="UTF-8">
</head>
<body>
<h2>Chi tiết sinh viên</h2>
<p><b>Mã số:</b> ${student.id}</p>
<p><b>Họ tên:</b> ${student.name}</p>
<p><b>Điểm:</b> ${student.gpa}</p>
<p><b>Xếp loại:</b> ${student.rank}</p>

<a href="${pageContext.request.contextPath}/students">Quay lại</a> |
<a href="${pageContext.request.contextPath}/students/${student.id}/edit">Sửa</a> |
<form method="post" action="${pageContext.request.contextPath}/students/${student.id}/delete" style="display:inline">
    <button type="submit">Xóa</button>
</form>
</body>
</html>
