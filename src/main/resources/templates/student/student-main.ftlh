<!DOCTYPE html>
<html>
<head>
    <title>StuReg</title>
</head>
<body>
<h1>Welocme to StuReg!</h1>
<h2>LIST OF STUDENTS</h2>
<div>
    <hr>
    <#list students as student>
        <div>${student.firstName}</div>
        <div>${student.lastName}</div>
        <a href="/student/${student.id}">Подробнее...</a>
        <hr>
    </#list>
</div>
<h2>Добавить студента</h2>
<form action="/student/create" method="post">
    <div>Введите ваши данные</div>
    <div>
        Имя
        <input type="text" name="firstName">
    </div>
    <div>
        Фамилия
        <input type="text" name="lastName">
    </div>
    <div>
        ИИН
        <input type="text" name="iin">
    </div>
    <div>
        Дата рождения
        <input type="date" name="dateOfBirth">
    </div>
    <div>
        Почта
        <input type="email" name="email">
    </div>
    <br>
    <button type="submit">Добавитьстудента</button>
</form>
</body>
</html>