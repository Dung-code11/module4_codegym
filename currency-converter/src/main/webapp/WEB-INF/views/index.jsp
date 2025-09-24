<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head><title>Currency Converter</title></head>
<body>
    <h2>Chuyển đổi USD → VNĐ</h2>
    <form action="convert" method="post">
        Tỉ giá (VNĐ/USD): <input type="text" name="rate"><br><br>
        Số USD: <input type="text" name="usd"><br><br>
        <button type="submit">Chuyển đổi</button>
    </form>
</body>
</html>
