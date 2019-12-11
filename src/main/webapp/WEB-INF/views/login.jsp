<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <title>Login</title>
    <link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>"/>
</head>
<body>
<header>
    <jsp:include page="header.jsp"/>

    <nav class="container container--70">
        <ul class="nav--actions">
            <li><a href="#">Zaloguj</a></li>
            <li class="highlighted"><a href="#">Załóż konto</a></li>
        </ul>

    </nav>
</header>

<section class="login-page">
    <h2>Zaloguj się</h2>
    <form:form modelAttribute="user" method="post" action="/login">
        <div class="form-group">
            <form:input title="email" path="email"/>
        </div>
        <div class="form-group">
            <form:password path="password" title="password"/>
            <a href="#" class="btn btn--small btn--without-border reset-password">Przypomnij hasło</a>
        </div>
        <div class="form-group form-group--buttons">
            <a href="/register" class="btn btn--without-border">Załóż konto</a>
            <input class="btn" type="submit" value="Zaloguj się"/>
        </div>
    </form:form>
</section>
<jsp:include page="footer.jsp"/>
</body>
</html>
