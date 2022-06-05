<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
	<title>NEW USER</title>
</head>

<body>
<p> </p>
<br>
<h2>ADD NEW USER</h2>

<spring:url value="/" var="contextPath" htmlEscape="true" />
<form:form method="POST" action="${contextPath}/addUser">
   <table>
		<tr>
         <td><form:label path="userName">UserName:</form:label></td>
        <td><form:input path="userName" /></td>
   		</tr>
   		<tr>
         <td><form:label path="password">Password:</form:label></td>
        <td><form:input path="password" /></td>
   		</tr>
		<tr>
        <td colspan="2">
            <input type="submit" value="SaveUser"/>
        </td>
    	</tr>
	</table>
</form:form>
</body>
</html>