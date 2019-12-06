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
            <p data-step="4">Podaj adres oraz termin odbioru rzeczy.</p>
        </div>
    </div>

    <div class="form--steps-container">
        <div class="form--steps-counter">Krok <span>4</span>/4
        </div>
            <div data-step="4">
                <h3>Podaj adres oraz termin odbioru rzecz przez kuriera:</h3>
                <form:form modelAttribute="donationFourthStep" method="post" action="/form_step4">

                <div class="form-section form-section--columns">
                    <div class="form-section--column">
                        <h4>Adres odbioru</h4>
                        <div class="form-group form-group--inline">
                            <label> Ulica </label>
                            <form:input path="street"/>
                        </div>
                        <div class="form-group form-group--inline">
                            <label> Miasto </label>
                            <form:input path="city"/>
                        </div>
                        <div class="form-group form-group--inline">
                            <label> Kod pocztowy </label>
                            <form:input path="zipCode"/>
                        </div>
                        <%--<div class="form-group form-group--inline">
                            <label>
                                Numer telefonu <input type="phone" name="phone" />
                            </label>
                        </div>--%>
                    </div>
                    <div class="form-section--column">
                        <h4>Termin odbioru</h4>
                        <div class="form-group form-group--inline">
                            <label> Data </label>
                            <form:input type="date" path="pickUpDate"/>
                        </div>
                        <div class="form-group form-group--inline">
                            <label> Godzina </label>
                            <form:input type="time" path="pickUpTime" />
                        </div>
                        <div class="form-group form-group--inline">
                            <label>
                                Uwagi dla kuriera
                            </label>
                            <form:textarea path="pickUpComment"/>
                        </div>
                    </div>
                </div>
                <div class="form-group form-group--buttons">
                    <button type="button" class="btn prev-step">Wstecz</button>
                    <button type="button" class="btn next-step">Dalej</button>
                </div>
            </div>
        </form:form>
    </div>
</section>
<jsp:include page="footer.jsp"/>
</body>
</html>
