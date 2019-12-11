<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Head</title>
</head>
<body>
<nav class="container container--70">
    <ul class="nav--actions">
        <li><a href="" class="btn btn--small btn--without-border">Zaloguj</a></li>
        <li><a href="/register" class="btn btn--small btn--highlighted">Załóż konto</a></li>
    </ul>

    <ul>
        <li><a href="#" class="btn btn--without-border active">Start</a></li>
        <li><a href="#" class="btn btn--without-border">O co chodzi?</a></li>
        <li><a href="#" class="btn btn--without-border">O nas</a></li>
        <li><a href="#" class="btn btn--without-border">Fundacje i organizacje</a></li>
        <li>
        <form:form action="/form_step1" method="get">
            <input type="submit" class="btn btn--without-border" value="Przekaż dary">
        </form:form>
        <li><a href="#" class="btn btn--without-border">Kontakt</a></li>
    </ul>
</nav>
</body>
</html>
