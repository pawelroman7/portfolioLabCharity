<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <title>Register</title>
    <link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>"/>
</head>
<body>
<header>
    <jsp:include page="header.jsp"/>
</header>

<section class="login-page">
    <h2>Załóż konto</h2>
    <form:form action="/register" method="post" modelAttribute="newUser">
    <form>
        <div class="form-group">
            <form:input path="email" title="email"/>
        </div>
        <div class="form-group">
            <form:password path="password" title="password"/>
        </div>
        <div class="form-group">

        </div>

        <div class="form-group form-group--buttons">
            <a href="login.html" class="btn btn--without-border">Zaloguj się</a>
            <input class="btn" type="submit" value="Załóż konto"/>
        </div>
    </form>
    </form:form>
</section>
<jsp:include page="footer.jsp"/>
</body>
</html>
