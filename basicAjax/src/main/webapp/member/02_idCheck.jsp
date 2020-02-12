<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>02_idCheck.jsp</title>
</head>
<body>
  <h3>[회원가입]</h3>
  <form name="memfrm" id="memfrm">
  <table>
  <tr>
    <th>아이디</th>
    <td><input type="text" name="uid" id="uid"></td>
    <td><div id="demo" style="display:none"></div></td>
  </tr>  
  </table>    
  </form>
  
<script src="../js/jquery.js"></script>
<script>
  $("#uid").keyup(function(){
	  
	  $.post("idcheck.do",          //요청명령어
			 "uid="+$("#uid").val(),//전달값
			 responseProc           //콜백함수
	  );//post() end
	  
  });//keyup() end
  
  function responseProc(result){
	$("#demo").empty();
	$("#demo").html(result);
	$("#demo").show();
  }//responseProc() end
  
</script>    
</body>
</html>




