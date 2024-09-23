<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%=request.getParameter("name")%>님의 혈액형은 <%=request.getParameter("blood")%>입니다
<br>
<%
    String bloodType = request.getParameter("blood"); // form 에서 name="blood" value="A" or "B" ...
    if (bloodType.equals("A")) out.println("당신의 성격은 A 입니다");
    else if (bloodType.equals("B")) out.println("당신의 성격은 B 입니다");
    else if (bloodType.equals("AB")) out.println("당신의 성격은 AB 입니다");
    else if (bloodType.equals("O")) out.println("당신의 성격은 O 입니다");
%>
</body>
</html>
