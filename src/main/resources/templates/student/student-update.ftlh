<!DOCTYPE html>
<html>
<head>
    <title>StuReg - Обновить студента</title>
</head>
<body>
<h2>Обновить данные студента</h2>
<form action="/student/student/update/${student.id}" method="post">
    <div>
        Имя:
        <input type="text" name="firstName" value="${student.firstName}">
    </div>
    <div>
        Фамилия:
        <input type="text" name="lastName" value="${student.lastName}">
    </div>
    <div>
        ИИН:
        <input type="text" name="iin" value="${student.iin}">
    </div>
    <div>
        Дата рождения:
        <input type="text" name="dateOfBirth" value="${student.dateOfBirth}">
    </div>
    <div>
        Почта:
        <input type="text" name="email" value="${student.email}">
    </div>
    <br>
    <button type="submit">Обновить студента</button>
</form>
</body>
</html>
