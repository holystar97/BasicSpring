package kr.co.basicspring.test03;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
//http://localhost:8090/basicspring/login.do
@Controller
public class LoginCont {
	
	public LoginCont() {
		System.out.println("---LoginCnt() 객체가 생성");
	}
	
	@RequestMapping(value="login.do",method=RequestMethod.GET)
	public String loginForm() {
	
		return "login/loginForm";
	}
	
	@RequestMapping(value="login.do",method=RequestMethod.POST)
	public ModelAndView loginProc(LoginVO vo, HttpServletRequest req, HttpSession session) {
		String id=vo.getId();
		String pw=vo.getPw();
		ModelAndView mav=  new ModelAndView();
		if(id.equals("okdolsk")&& pw.equals("1234")) {
			mav.setViewName("login/loginResult");
			session.setAttribute("s_id", id);
			session.setAttribute("s_pw", pw);
			req.setAttribute("msg", "로그인 성공~~ ");
			//로그인 성공
		}else {
			//로그인 실패
			mav.setViewName("login/msgView");
			mav.addObject("msg","<p>아이디와 비번이 일치하지 않습니다.</p>");
			mav.addObject("link","<a href='javascript:hisotry.back()'>[다시 시도]</a>");
			
		}
		return mav;
	}
	
	
}
