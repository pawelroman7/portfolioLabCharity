<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Donation confirmed</title>
</head>
<body>
<jsp:include page="form-header.jsp"/>
<section class="form--steps">
    <div class="form--steps-instructions">
        <div class="form--steps-container">
            <!-- STEP 6 -->
            <div data-step="5">
                <h3>Podsumowanie Twojej darowizny</h3>
                <form:form modelAttribute="donationFinal" method="post" action="/saveDonation">
                <div class="summary">
                    <div class="form-section">
                        <h4>Oddajesz:</h4>
                        <ul>

                                <li>
                                    <span class="icon icon-bag"></span>
                                    <span class="summary--text">
                                            ${donationFinal.quantity}
                                                <c:forEach items="${donationFinal.categories}" var="category">
                                                    ${category.name}
                                    </span>
                                </li>
                            </c:forEach>
                            <li>
                                <span class="icon icon-hand"></span>
                                <span class="summary--text"
                                >Dla fundacji: ${donationFinal.institution.name}</span
                                >
                            </li>
                        </ul>
                    </div>

                    <div class="form-section form-section--columns">
                        <div class="form-section--column">
                            <h4>Adres odbioru:</h4>
                            <ul>
                                <li>${donationFinal.street}</li>
                                <li>${donationFinal.city}</li>
                                <li>${donationFinal.zipCode}</li>
                                <li>123 456 789</li>
                            </ul>
                        </div>

                        <div class="form-section--column">
                            <h4>Termin odbioru:</h4>
                            <ul>
                                <li>${donationFinal.pickUpDate}</li>
                                <li>${donationFinal.pickUpTime}</li>
                                <li>${donationFinal.pickUpComment}</li>
                            </ul>
                        </div>
                    </div>
                </div>

                <div class="form-group form-group--buttons">
                    <button type="button" class="btn prev-step">Wstecz</button>
                    <input type="submit" class="btn" value="Potwierdzam"/>
                </div>
            </div>
            </form:form>
        </div>
    </div>
</section>
<jsp:include page="footer.jsp"/>
</body>
</html>
