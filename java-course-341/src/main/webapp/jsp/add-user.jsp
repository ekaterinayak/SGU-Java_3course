<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Add new bank user</title>
    <link href = "../css/style.css" rel = "stylesheet">
</head>
<body>
    <h1 align="center">Добавление нового пользователя</h1>

    <form class="add-user-form" id="form" method="POST">

        <div class="field">
            <label>Имя: </label>
            <input type="text" name="name">
        </div>

        <div class="field">
            <label>Пароль: </label>
            <input type="password" name="password">
        </div>

        <div class="field">
            <label>Номер банковского счета: </label>
            <input type="text" name="accountNumber">
        </div>

        <div class="field">
            <label>Сумма денег на счету: </label>
            <input type="text" name="amount">
        </div>
        <br>

        <div align="center">
            <button>Добавить пользователя</button>
        </div>
    </form>
</body>
</html>
