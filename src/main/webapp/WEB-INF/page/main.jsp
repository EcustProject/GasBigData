<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: huchao
  Date: 2017/4/12
  Time: 18:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>首页</title>
</head>
<body>
    <table border="1">
        <tr>
            <th>封面</th><th>书名</th><th>作者</th><th>价格</th>
        </tr>
        <c:forEach items="${requestScope.book_list}" var="book">
            <tr>
                <td><img src="/resources/images/${book.image}" height="60"></td>
                <td>${book.name}</td>
                <td>${book.author}</td>
                <td>${book.price}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
