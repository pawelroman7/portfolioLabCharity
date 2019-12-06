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
            <p data-step="2">
                Uzupełnij szczegóły dotyczące Twoich rzeczy. Dzięki temu będziemy
                wiedzieć komu najlepiej je przekazać.
            </p>
        </div>
    </div>
    <div class="form--steps-container">
        <div class="form--steps-counter">Krok <span>2</span>/4</div>
        <form:form modelAttribute="donationSecondStep" id="donationFormTwo" method="post" action="/form_step2">
        <div data-step="2" class="active">
            <h3>Podaj liczbę 60l worków, w które spakowałeś/aś rzeczy:</h3>
            <div class="form-group form-group--inline">
                <label>
                    Liczba 60l worków:
                </label>
                    <form:input path="quantity"/>
                <form:hidden path="categories"/>
            </div>
            <div class="form-group form-group--buttons">
                <button type="button" class="btn prev-step">Wstecz</button>
                <input type="submit" value="Dalej" class="btn next-step">
            </div>
        </div>
        </form:form>
    </div>
</section>
<jsp:include page="footer.jsp"/>
</body>
</html>
