<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>${message}</h1>
	<h1>로그인 아이디 : ${id }</h1>
	<h1>로그인 패스워드 : ${password }</h1>
	
	<%
		String id = request.getParameter(id);
		String password = request.getParameter("password");
	%>

	<%= request.getAttribute("id") %> : <%= request.getAttribute("password") %>
</body>
</html>