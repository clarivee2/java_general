<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/jsp/include.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Example - Spring Application - Inventory view</title>
</head>
<body>
  <h1>Example - Spring Application - Inventory view</h1>
  <p>this is my test of the inventory controller.</p>
  <p>Greetings, it is now <c:out value="${model.now}"/></p>
  <h3>Products</h3>
    <c:forEach items="${model.products}" var="prod">
      <c:out value="${prod.description}"/> <i>$<c:out value="${prod.price}"/></i><br><br>
    </c:forEach>
    <!--  link to the price increase interface -->
    <br>
    <a href="<c:url value="priceincrease.htm"/>">Increase Prices</a>
    <br>
</body>
</html>