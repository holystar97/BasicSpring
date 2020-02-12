package kr.co.form1.test01;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AjaxTestCont {

  public AjaxTestCont() {
    System.out.println("---AjaxTestCont()객체 생성됨");
  }
  
  @RequestMapping("/member/test.do")
  public void ajaxTest(HttpServletRequest req, HttpServletResponse resp) {
    try {
      resp.setContentType("text/plain; charset=UTF-8");
      PrintWriter out=resp.getWriter();
      out.println("서버에서 응답해준 메세지:");
      out.println("무궁화꽃이 피었습니다");
      out.flush();      
      out.close();
      
    }catch (Exception e) {
      System.out.println("응답실패:"+e);
    }//try end
  }//ajaxTest() end
  
  
  @RequestMapping("/member/idcheck.do")
  public void idCheck(HttpServletRequest req, HttpServletResponse resp) {
    try {
      String uid=req.getParameter("uid").trim();
      String message="";
      if(uid.length()<5 || uid.length()>=11) {
        message="<span style='color:red;font-weight:bold'>아이디는 5~10글자 이내 입력해 주세요!!</span>";  
      }else {
        
      }//if end

      
    }catch (Exception e) {
      System.out.println("응답실패:"+e);
    }
  }//idCheck() end
  
  
  
}//class end





