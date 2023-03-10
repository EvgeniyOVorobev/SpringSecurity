<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Z
  Date: 10.03.2023
  Time: 17:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<body>
<h3>
  Information for all employees
</h3>
<br><br>
<security:authorize access="hasRole('HR')">
<input type="button" value="Salary"
onclick="window.location.href='hr_info'">
only for hr staff
</security:authorize>
<br><br>
<security:authorize access="hasRole('Manager')">
<input type="button" value="Performance"
       onclick="window.location.href='manager_info'">
only for manager staff
</security:authorize>
</body>
</html>
