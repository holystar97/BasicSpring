<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>03_idCheck_cookie.jsp</title>
</head>
<body>
  <h3>[회원가입]</h3>
  <form name="memfrm" id="memfrm" onsubmit="return send()">
  <table>
  <tr>
    <th>아이디</th>
    <td>
      <input type="text" name="uid" id="uid">
      <button type="button" id="checkId">중복확인</button>
    </td>
    <td>
      <span id="panel_id"></span> <!-- ID 중복 관련 메세지 -->
    </td>
  </tr>  
  <tr>
    <th>비밀번호</th>
    <td><input type="password" name="upw" id="upw"></td>
    <td>&nbsp;</td>
  </tr>  
  <tr>
    <td colspan="3"><input type="submit" value="가입"></td>
  </tr>  
  </table>    
  </form>
    
<script src="../js/jquery.js"></script>
<script src="../js/jquery.cookie.js"></script>
<script>
//해당페이지가 로딩되었을때 쿠키변수 삭제
$(function(){
	$.removeCookie("checkID");
});


$("#checkId").click(function(){
  //$.post("요청명령어", 전달값, 콜백함수, 응답받는형식)
  var params="uid=" + $("#uid").val();
  //$.post("idcheck2.do", params, checkID, "text");
  $.post("idcheck2.do", params, checkID, "json");
});//click() end

function checkID(result){
  //1)text응답
  //alert(result);

  //2)json응답
  //alert(result);//[object Object]
  //alert(result.count);  
  var count=eval(result.count);//형변환
  if(count==0){
    $("#panel_id").css("color", "blue");
	$("#panel_id").text("사용 가능한 아이디 입니다");
	//$.cookie("쿠키변수명", 값)
	$.cookie("checkID", "PASS"); //쿠키변수 생성	
  }else{
	$("#panel_id").css("color", "red");
	$("#panel_id").text("중복된 아이디 입니다");
	$("#uid").focus(); //커서생성	
  }//if end  
  
}//checkID() end


function send(){
  //아이디 중복확인을 해야만 회원가입폼이 서버로 전송
  //쿠키변수값 가져오기
  var checkID=$.cookie("checkID");
  if(checkID=="PASS"){
	return true;
  }else{
	$("#panel_id").css("color", "green");
	$("#panel_id").text("아이디 중복확인 해주세요");
	$("#uid").focus(); //커서생성
	return false;  
  }//if end
  
}//send() end



</script>    
</body>
</html>




