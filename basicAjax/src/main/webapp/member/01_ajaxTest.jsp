<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>01_ajaxTest.jsp</title>
</head>
<body>
<!--  
  AJAX(Asynchronous JavaScript And XML)
  - 페이지 전체를 reload하지 않고 일부분만 reload할수 있다
  - jQuery 오픈소스중 ajax()함수를 이용한다
  - 응답받아온 메세지를 처리하는 함수를 callback함수라 한다
-->
  <button>* 서버에서 응답받기 *</button>
  <div id="panel"></div>


<script src="../js/jquery.js"></script>
<script >
  $("button").click(function(){
	  //alert();
	  /*1)
	  $.ajax({
		       url     : "test.do",     //요청명령어
		       method  : "get",         //요청방식
		       dataType: "text",        //자료형
		       error   :function(error){//callback함수
		    	 alert("에러:"+error)
		       },
		       success :function(result){//callback함수
		    	 //alert(result);
		       	 //$("#panel").append(result);
		       	 $("#panel").empty();
		       	 $("#panel").text(result);
		       }		  
	  });//ajax() end
	  */
	  
	  //2)callback함수 호출
	  //$.get("요청명령어", callback함수)
	  $.get("test.do", responseProc);//get() end

  });//click end
  
  
  function responseProc(result){
	  $("#panel").append(result);
  }//responseProc() end
  
  
  
</script>







</body>
</html>