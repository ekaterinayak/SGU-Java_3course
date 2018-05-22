<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>Simple JSP</title>
</head>
<body>
    <h2>Number: ${number}</h2>
    <h2>Message: ${message}</h2>

    <form action="${pageContext.request.contextPath}/simple-jsp" method="post">
        <button type="submit" name="button" value="button">Новая попытка</button>
    </form>
</body>
</html>
