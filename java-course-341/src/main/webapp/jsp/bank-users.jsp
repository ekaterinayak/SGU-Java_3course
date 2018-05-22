<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Пользователи банка</title>
</head>
<body>
    <table border="1px">
        <thead>
            <th width="50px"><h3>Id</h3></th>
            <th width="300px"><h3>Name</h3></th>
            <th width="300px"><h3>Password</h3></th>
            <th width="200px"><h3>Account number</h3></th>
            <th width="150px"><h3>Amount</h3></th>
        </thead>
        <tbody>
            <c:forEach var="user" items="${users}">
                <tr>
                    <td>${user.getId()}</td>
                    <td>${user.getName()}</td>
                    <td>${user.getPassword()}</td>
                    <td>${user.getAccountNumber()}</td>
                    <td>${user.getAmount()}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
