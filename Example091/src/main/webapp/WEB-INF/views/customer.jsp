<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<html>
<head>
<title>Customer Page</title>
<style type="text/css">
.tg {
	border-collapse: collapse;
	border-spacing: 0;
	border-color: #ccc;
	cellpadding: 10;
	cellspacing: 10;
}

.tg td {
	font-family: Arial, sans-serif;
	font-size: 14px;
	padding: 10px 5px;
	border-style: solid;
	border-width: 1px;
	overflow: hidden;
	word-break: normal;
	border-color: #ccc;
	color: #333;
	cellpadding: 10;
	cellspacing: 10;
}

.tg th {
	font-family: Arial, sans-serif;
	font-size: 14px;
	font-weight: normal;
	padding: 10px 5px;
	border-style: solid;
	border-width: 1px;
	overflow: hidden;
	word-break: normal;
	border-color: #ccc;
	color: #3 33;
	background-color: #f0f0f0;
	cellpadding: 10;
	cellspacing: 10;
}

.tg .tg-4eph {
	background-color: #f9f9f9
}

a.button {
	background-color: #4CAF50; /* Green */
	border: none;
	color: white;
	padding: 10px 15px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 15px;
	margin: 10px 15px 10px 8px;
}

a.btn {
	background-color: #f44336;
	border: none;
	color: white;
	padding: 10px 15px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 15px;
	margin: 10px 15px 10px 8px;
}

.table {
	border: 1px;
}

.th {
	width: 10%;
}

.value {
	margin: 10px 15px 10px 8px;
}
</style>
</head>
<body>
	<h1>Add a Customer</h1>
	<c:url var="addAction" value="/customer/add"></c:url>
	<form:form action="${addAction}" commandName="customer">
		<table>
			<c:if test="${!empty customer.name}">
				<tr>
					<td><form:label path="id">
							<spring:message text="ID" />
						</form:label></td>
					<td><form:input path="id" readonly="true" size="8" disabled="true" /> <form:hidden path="id" /></td>
				</tr>
			</c:if>
			<tr>
				<td><form:label path="name">
						<spring:message text="Name" />
					</form:label></td>
				<td><form:input path="name" /></td>
			</tr>
			<tr>
				<td><form:label path="address">
						<spring:message text="address" />
					</form:label></td>
				<td><form:input path="address" /></td>
			</tr>
			<tr>
				<td colspan="2"><c:if test="${!empty customer.name}">
						<input type="submit" value="<spring:message text="Edit Customer"/>" />
					</c:if> <c:if test="${empty customer.name}">
						<input type="submit" value="<spring:message text="Add Customer"/>" />
					</c:if></td>
			</tr>
		</table>
	</form:form>
	<br>
	<h3>Customers List</h3>
	<c:if test="${!empty listCustomers}">
		<table class="tg">
			<tr>
				<th width="80">ID</th>
				<th width="120">Customer Name</th>
				<th width="120">Address</th>
				<th width="60">Action</th>
			</tr>
			<c:forEach items="${listCustomers}" var="customer">
				<tr>
					<td>${customer.id}</td>
					<td>${customer.name}</td>
					<td>${customer.address}</td>
					<td><a href="<c:url value='/edit/${customer.id}' />"
						class="button">Edit</a> <a
						href="<c:url value='/remove/${customer.id}' />" class="btn">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>