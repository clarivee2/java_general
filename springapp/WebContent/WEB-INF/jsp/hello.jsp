<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/jsp/include.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Example - Spring Application</title>
</head>
<body>
  <h1>Example - Spring Application</h1>
  <p>this is my test thru the hello controller.</p>
  <p>Greetings, it is now <c:out value="${now}"/></p>
  <h2>Other Parts</h2>
  <a href="<c:url value="inventory.htm"/>">Inventory Management</a>

</body>
</html>