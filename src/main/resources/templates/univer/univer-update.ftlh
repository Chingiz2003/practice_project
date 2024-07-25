<!DOCTYPE html>
<html>
<head>
    <title>StuReg - Обновить студента</title>
</head>
<body>
<h2>Обновить данные студента</h2>
<form action="/univerDto/univerDto/update/${univerDto.id}" method="post">
    <div>
        Имя:
        <input type="text" name="name" value="${univerDto.name}">
    </div>
    <div>
        Фамилия:
        <input type="text" name="country" value="${univerDto.country}">
    </div>
    <div>
        ИИН:
        <input type="text" name="city" value="${univerDto.city}">
    </div>
    <div>
        Дата рождения:
        <input type="text" name="address" value="${univerDto.address}">
    </div>
    <br>
    <button type="submit">Обновить ВУЗ</button>
</form>
</body>
</html>
