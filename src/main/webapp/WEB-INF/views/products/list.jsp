<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;
    charset=UTF-8">
    <title>Products List</title>
</head>
<body>

<spring:hasBindErrors name="product">
    <ul>
        <c:forEach var="error" items="${errors.allErrors}">
            <li><spring:message code="${error.code}" text="${error.defaultMessage}"/></li>
        </c:forEach>
    </ul>
</spring:hasBindErrors>

    <table>
        <tr>
            <td>Titulo</td>
            <td>Valores</td>
        </tr>

        <c:forEach items="${products}" var="product">
        			<tr>
        				<td>${product.title}</a></td>

        			</tr>
        		</c:forEach>

</table>
</body>
</html>