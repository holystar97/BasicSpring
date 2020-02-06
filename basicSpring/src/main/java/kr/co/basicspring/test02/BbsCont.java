package kr.co.basicspring.test02;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BbsCont {
	public BbsCont() {
		System.out.println("-----BbsCont() 객체 생성됨");
	}
	
	//http://localhost:8090/basicspring/bbs/create.do
	
	/*
	@RequestMapping(value="bbs/create.do", method=RequestMethod.GET)
	public ModelAndView bbsForm() {
		ModelAndView mav =new ModelAndView();
		mav.setViewName("bbs/bbsForm");
		return mav;
	}*/
	
	//http://localhost:8090/basicspring/bbs/create.do
	@RequestMapping(value="bbs/create.do", method=RequestMethod.GET)
	public String bbsForm() {
		return "bbs/bbsForm";
	}
	
	//동일한 요청 명령어를 GET|POST 방식으로 분리해서 호출 가능 
	/* 1)
	@RequestMapping(value="bbs/create.do", method=RequestMethod.POST)
	public ModelAndView bbsIns(HttpServletRequest req) {
		
			String wname=req.getParameter("wname").trim();
			String subject=req.getParameter("subject").trim();
			String content=req.getParameter("content").trim();
			String passwd=req.getParameter("passwd").trim();
			
			
			ModelAndView mav= new ModelAndView();
			mav.setViewName("bbs/bbsResult");
			
			mav.addObject("wname",wname);
			mav.addObject("subject",subject);
			mav.addObject("content",content);
			mav.addObject("passwd",passwd);
	
			return mav;
		
	}*/
	
	//2) 매개 변수 (parameter) 가 dto 객체 인 경우 
	// 해당 클래스에 반드시
	// 폼 컨트롤 요소 이름으로 되어있는 멤버 변수와
	// 각 getter와 setter 함수가 딨어야 한다 
	// <input type=text name= wname>과
	// private String wname의 이름이 동일해야 한다 
	
	 @RequestMapping(value="bbs/create.do", method=RequestMethod.POST)  
	  public ModelAndView bbsIns(BbsDTO dto) {
	    
	    ModelAndView mav=new ModelAndView();
	    mav.setViewName("bbs/bbsResult2");
	    mav.addObject("dto", dto);
	    return mav;
	    
	  }//bbsIns() end
}
