<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <title>Document</title>
    <link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>"/>
</head>
<body>
<jsp:include page="form-header.jsp"/>

<section class="form--steps">
    <div class="form--steps-instructions">
        <div class="form--steps-container">
            <h3>Ważne!</h3>
            <p data-step="3" class="active">
                Wybierz jedną, do
                której trafi Twoja przesyłka.
            </p>
        </div>
    </div>
    <div class="form--steps-container">
        <div class="form--steps-counter">Krok
            <span>
                3
            </span>
            /4
        </div>
            <div data-step="3">
                <h3>Wybierz organizacje, której chcesz pomóc:</h3>
                <div class="form-group form-group--checkbox">
                <form:form method="post" action="/form_step3" modelAttribute="donationThirdStep">
                    <c:forEach items="${institutions}" var="institution">
                        <form:radiobutton path="institution" value="${institution.id}"/>
                        <label>
                            <span class="checkbox radio"></span>
                            <span class="description">
                                <div class="title">${institution.name}</div>
                                <div class="subtitle">Cel i misja: ${institution.description}</div>
                            </span>
                        </label>

                    </c:forEach>
                </div>
                <form:hidden path="categories"/>
                <form:hidden path="quantity"/>
                <div class="form-group form-group--buttons">
                    <button type="button" class="btn prev-step">Wstecz</button>
                    <input type="submit" class="btn next-step" value="Dalej"/>
                </div>

                </form:form>
            </div>
    </div>
</section>
<jsp:include page="footer.jsp"/>
</body>
</html>
