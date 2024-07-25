<!DOCTYPE html>
<html>
<head>
    <title>StuReg</title>
</head>
<body>
<h2>Подробная информация о студенте</h2>
<div>
    <hr>
        <div>${student.firstName}</div>
        <div>${student.lastName}</div>
        <div>${student.iin}</div>
        <div>${student.dateOfBirth}</div>
        <div>${student.email}</div>
    <hr>
</div>
<div>
    <form action="/student/delete/${student.id}" method="post">
        <button type="submit">Удалить студента</button>
    </form>
    <a href="student/update/${student.id}">Обновить данные</a>
</div>
</body>
</html>