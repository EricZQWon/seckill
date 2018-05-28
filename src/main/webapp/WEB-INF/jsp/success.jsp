<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2017/11/21
  Time: 21:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form  modelAttribute="formatter">
    <table>
        <tr>
            <form:input path="startTime"/>
        </tr>
        <tr>
            <form:input path="number"/>
        </tr>
        <%--<tr>--%>
            <%--<form:input path="percent"/>--%>
        <%--</tr>--%>
        <%--<tr>--%>
            <%--<form:input path="zheng"/>--%>
        <%--</tr>--%>
    </table>
</form:form>
</body>
</html>
