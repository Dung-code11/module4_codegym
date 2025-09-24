<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head><title>Danh sách sinh viên</title>
<meta charset="UTF-8">
</head>
<body>
<h2>Danh sách sinh viên</h2>
<a href="${pageContext.request.contextPath}/students/add">Thêm sinh viên</a>
<c:if test="${not empty message}">
    <p style="color: green">${message}</p>
</c:if>

<form method="get">
    <input type="text" name="q" value="${q}" placeholder="Tìm kiếm..."/>
    <button type="submit">Search</button>
</form>

<table border="1">
<tr>
    <th>Mã số</th><th>Họ tên</th><th>Điểm</th><th>Hạng</th><th>Action</th>
</tr>
<c:forEach var="s" items="${students}">
    <tr>
        <td><c:out value="${s.id}"/></td>
        <td><c:out value="${s.name}"/></td>
        <td><c:out value="${s.gpa}"/></td>
        <td><c:out value="${s.rank}"/></td>
        <td>
            <a href="${pageContext.request.contextPath}/students/${s.id}">Chi tiết</a> |
            <a href="${pageContext.request.contextPath}/students/${s.id}/edit">Sửa</a> |
            <form method="post" action="${pageContext.request.contextPath}/students/${s.id}/delete" style="display:inline">
                <button type="submit">Xóa</button>
            </form>
        </td>
    </tr>
</c:forEach>
</table>
</body>
</html>
