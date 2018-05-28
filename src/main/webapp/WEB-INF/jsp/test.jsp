<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2017/11/21
  Time: 21:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/Formatter" method="get">
    <table>
        <%--<tr>--%>
            <%--<td>日期类型</td>--%>
            <%--<td><input type="text" name="startTime" id="date"></td>--%>
        <%--</tr>--%>
        <tr>
            <td>日期</td>
            <td><input type="text" name="startTime"></td>
        </tr>
        <tr>
            <td>百分数：</td>
            <td><input type="text" name="number"></td>


    </table>
    <input type="submit" value="提交">
</form>
</body>
</html>
