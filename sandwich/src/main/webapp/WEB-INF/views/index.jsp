<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Sandwich Condiments</title>
</head>
<body>
<h2>Chọn gia vị cho Sandwich</h2>
<form action="save" method="post">
    <input type="checkbox" name="condiment" value="Lettuce"> Lettuce <br>
    <input type="checkbox" name="condiment" value="Tomato"> Tomato <br>
    <input type="checkbox" name="condiment" value="Mustard"> Mustard <br>
    <input type="checkbox" name="condiment" value="Sprouts"> Sprouts <br>
    <button type="submit">Submit</button>
</form>
</body>
</html>
