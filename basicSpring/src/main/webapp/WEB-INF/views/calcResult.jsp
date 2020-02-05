<%@page import="org.springframework.web.context.request.RequestScope"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>1) JSP </h1>
	<%=request.getAttribute("msg") %>
	숫자 1: <%=request.getAttribute("no1") %>
	숫자 2: <%=request.getAttribute("no2") %>
	결과 : <%=request.getAttribute("result") %>
	<%=request.getAttribute("img") %>
	
	<h1>2) EL </h1>
	${requestScope.msg}
	숫자 1: ${requestScope.no1}
	숫자 2: ${requestScope.no2}
	결과 : ${requestScope.result}
	${requestScope.img}
	
	<h1>3) EL </h1>
	${msg}
	숫자 1: ${no1}
	숫자 2: ${no2}
	결과 : ${result}
	${ img==null ? "" : img}
	
	
	
	
</body>
</html>