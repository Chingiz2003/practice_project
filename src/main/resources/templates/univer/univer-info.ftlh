<!DOCTYPE html>
<html>
<head>
    <title>StuReg</title>
</head>
<body>
<h1>Welocme to StuReg!</h1>
<h2>LIST OF UNIVERS</h2>
<div>
    <hr>
        <div>${univerDto.name}</div>
        <div>${univerDto.country}</div>
        <div>${univerDto.city}</div>
        <div>${univerDto.address}</div>
    <hr>
</div>
<div>
    <form action="/univerDto/delete/${univerDto.id}" method="post">
        <button type="submit">
            Удалить ВУЗ
        </button>
    </form>
    <a href="univerDto/update/${univerDto.id}">Обновить данные</a>
</div>
</body>
</html>