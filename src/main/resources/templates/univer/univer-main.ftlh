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
    <#list univers as univerDto>
        <div>${univerDto.name}</div>
        <div>${univerDto.country}</div>
        <a href="/univerDto/${univerDto.id}">Подробнее...</a>
        <hr>
    </#list>
</div>
<h2>Добавить ВУЗ</h2>
<form action="/univerDto/create" method="post">
    <div>Введите данные ВУЗа</div>
    <div>
        Наименование
        <input type="text" name="name">
    </div>
    <div>
        Страна
        <input type="text" name="country">
    </div>
    <div>
        Город
        <input type="text" name="city">
    </div>
    <div>
        Адрес
        <input type="text" name="address">
    </div>
    <br>
    <button type="submit">Добавить ВУЗ</button>
</form>
</body>
</html>