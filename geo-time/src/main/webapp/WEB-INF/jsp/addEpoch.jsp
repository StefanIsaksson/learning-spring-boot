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
		<div class="add-epoch">
			<h2>Add new Epoch</h2>
			<form:form modelAttribute="epoch">
                <div class="form-group">
                    <label for="name">Name:</label>
                    <form:input type="text" path="name" class="form-control" id="name" />
                </div>
                <div class="form-group">
                    <label for="description">Description:</label>
                    <form:input type="text" path="description" class="form-control" id="description" />
                </div>
                <div class="form-group">
                    <label for="period">Period:</label>
                    <form:select path="period" items="${availablePeriods}" class="form-control" id="period" />
                </div>
                <div class="form-group">
                    <label for="start">Begun (m.h.a):</label>
                    <form:input type="number" step="0.001" path="start" class="form-control" id="start" />
                </div>
                 <div class="form-group">
                     <label for="end">Ended (m.h.a):</label>
                     <form:input type="number" step="0.001" path="end" class="form-control" id="end" />
                 </div>
                <button type="submit" class="btn btn-primary">Submit</button>
                <a href="/" class="btn btn-warning" role="button" aria-pressed="true">Cancel</a>
			</form:form>
		</div>
	</div>

	<script type="text/javascript" src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>

</html>