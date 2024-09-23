<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: swift
  Date: 2024-09-23
  Time: 오후 12:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
    <h3> <%=request.getParameter("name")%>님 로그인 성공</h3>
    <fieldset>
        <legend>선택한 취미</legend>
        <%
            //취미
            String[] hobbies = request.getParameterValues("hobby");
            for (String h : hobbies)
            {
                //브라우저 출력
                System.out.println(h);// 콘솔에 출력
                out.println(h+",");// 브라우저에 출력-> 빨간 줄 뜨지만 기능은 구현됨
                //out.println("<input> type='checkbox' value='"+h+"'>"+h);
        %>

        <input type="checkbox" value="<%=h%>"><%=h%>

        <%
            }
        %>

    </fieldset>

</body>
</html>
