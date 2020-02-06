<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login/loginResult.jsp</title>
</head>
<body>
	<h3>로그인 결과 </h3>
<h1>1) JSP </h1>
	<%=request.getAttribute("msg") %><br>
	아이디(세션): <%=session.getAttribute("s_id") %><br>
	비번(세션): <%=session.getAttribute("s_pw") %><br>
	
	<h1>2) EL </h1>
	${msg}<br>
	아이디 (세션) : ${s_id }<br>
	비번 (세션): ${s_pw }<br>
</body>
</html>