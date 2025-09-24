<html>
<head>
    <title>Calculator</title>
</head>
<body>
<h2>Ứng dụng Máy tính đơn giản</h2>
<form action="calculate" method="post">
    <input type="number" name="num1" step="any" required>
    <select name="operator">
        <option value="+">Cộng (+)</option>
        <option value="-">Trừ (-)</option>
        <option value="*">Nhân (×)</option>
        <option value="/">Chia (÷)</option>
    </select>
    <input type="number" name="num2" step="any" required>
    <button type="submit">Tính</button>
</form>
</body>
</html>
