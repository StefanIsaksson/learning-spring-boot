<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html lang="en">
<head>

	<!-- Access the bootstrap Css like this,
		Spring boot will handle the resource mapping automcatically -->
	<link rel="stylesheet" type="text/css" href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />

	<!--
	<spring:url value="/css/main.css" var="springCss" />
	<link href="${springCss}" rel="stylesheet" />
	 -->
	<c:url value="/css/main.css" var="jstlCss" />
	<link href="${jstlCss}" rel="stylesheet" />

</head>
<body>

	<div class="container">
    <h2>Epochs</h2>
	<table class="table">
      <thead>
        <tr>
          <th scope="col">Name</th>
          <th scope="col">Start (m.y.a)</th>
          <th scope="col">End (m.y.a)</th>
          <th scope="col">Description</th>
          <th scope="col">Period</th>
        </tr>
      </thead>
      <tbody>
      <c:forEach var="epoch" items="${epochs}">
        <tr>
          <th scope="row"><c:out value="${epoch.name}"/></th>
          <td><c:out value="${epoch.start}"/></td>
          <td><c:out value="${epoch.end}"/></td>
          <td><c:out value="${epoch.description}"/></td>
          <td><c:out value="${epoch.period}"/></td>
        </tr>
        </c:forEach>
      </tbody>
    </table>
    <a href="/addEpoch" class="btn btn-primary" role="button" aria-pressed="true">Add new Epoch</a>
	</div>

	<script type="text/javascript" src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>

</html>