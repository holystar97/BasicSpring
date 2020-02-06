package kr.co.basicspring.test01;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
/*
 * 스프링 프레임 워크의 특징 
 * -기본 3단 패키지로 구성된다
 * -request.getContextPath() -> basicSpring
 * - 환경설정이 복잡하다
 * - 어노테이션 방식으로 구성할 수 있다 
*/
import org.springframework.web.servlet.ModelAndView;

@Controller //해당 클래스는 컨트롤러 기능이다 
			//URL에서 요청된 명령어를 읽어서 실행 해주는 클래스를 지정
			//스프링 컨테이너( 서버) 에서 자동으로 객체 생성이 된다.
public class CalcController {
			public CalcController() {
				System.out.println("---------CalcController()객체 생성됨");
			}
			
			//요청 명령어 등록 후 실행의 주체는 메소드(함수)
			//요청 명령어 @RequestMapping(value="요청 명령어 ", method =GET|POST)
			
			//결과 확인
			//http://localhost:8090/basicspring/add.do?no1=3&no2=5
			@RequestMapping(value= "/add.do", method=RequestMethod.GET)
			public ModelAndView add(HttpServletRequest req) {
				
				int no1=Integer.parseInt(req.getParameter("no1"));
				int no2=Integer.parseInt(req.getParameter("no2"));
				
				//System.out.println("no1: "+ no1);
				//System.out.println("no2: " +no2);
				int result=no1+no2;
				
				//View페이지로 이동하기 위한 클래스 
				//->Model
				//->ModelAndView
				
				ModelAndView mav=new ModelAndView();
				//view 페이지 구성
				//servlet-context.xml -> prefix : web/ins/d[ra
				 //                   ->suffix: .jsp
				// WEB-INF/views/caclResult.jsp
				
				mav.setViewName("calcResult");
				
				//공유 장소 request영역에 값 올리기 
				req.setAttribute("msg", "<h1>두 수의 합 </h1>");
				req.setAttribute("img", "<img src='resources/images/add.png'>");
				req.setAttribute("no1", no1);
				req.setAttribute("no2", no2);
				req.setAttribute("result", result);
			
				return mav;
			}
			
			@RequestMapping(value= "/sub.do", method=RequestMethod.GET)
			public ModelAndView minus(HttpServletRequest req) {
				
				int no1=Integer.parseInt(req.getParameter("no1"));
				int no2=Integer.parseInt(req.getParameter("no2"));
				
				//System.out.println("no1: "+ no1);
				//System.out.println("no2: " +no2);
				int result=no1-no2;
				
				//View페이지로 이동하기 위한 클래스 
				//->Model
				//->ModelAndView
				
				ModelAndView mav=new ModelAndView();
				//view 페이지 구성
				//servlet-context.xml -> prefix : web/ins/d[ra
				 //                   ->suffix: .jsp
				// WEB-INF/views/caclResult.jsp
				
				mav.setViewName("calcResult");
				
				//공유 장소 request영역에 값 올리기 
				req.setAttribute("msg", "<h1>두 수의 차 </h1>");
				req.setAttribute("img", "<img src='resources/images/sub.png'>");
				req.setAttribute("no1", no1);
				req.setAttribute("no2", no2);
				req.setAttribute("result", result);
			
				return mav;
			}
			
			@RequestMapping(value= "/mul.do", method=RequestMethod.GET)
			public ModelAndView mul(HttpServletRequest req) {
				
				int no1=Integer.parseInt(req.getParameter("no1"));
				int no2=Integer.parseInt(req.getParameter("no2"));
				
				//System.out.println("no1: "+ no1);
				//System.out.println("no2: " +no2);
				int result=no1*no2;
				
				//View페이지로 이동하기 위한 클래스 
				//->Model
				//->ModelAndView
				
				ModelAndView mav=new ModelAndView();
				//view 페이지 구성
				//servlet-context.xml -> prefix : web/ins/d[ra
				 //                   ->suffix: .jsp
				// WEB-INF/views/caclResult.jsp
				
				mav.setViewName("calcResult");
				
				//공유 장소 request영역에 값 올리기 
				req.setAttribute("msg", "<h1>두 수의 곱 </h1>");
				req.setAttribute("img", "<img src='resources/images/mul.png'>");
				req.setAttribute("no1", no1);
				req.setAttribute("no2", no2);
				req.setAttribute("result", result);
			
				return mav;
			}
			@RequestMapping(value= "/div.do", method=RequestMethod.GET)
			public ModelAndView div(HttpServletRequest req) {
				
				int no1=Integer.parseInt(req.getParameter("no1"));
				int no2=Integer.parseInt(req.getParameter("no2"));
				
				//System.out.println("no1: "+ no1);
				//System.out.println("no2: " +no2);
				int result=no1/no2;
				
				//View페이지로 이동하기 위한 클래스 
				//->Model
				//->ModelAndView
				
				ModelAndView mav=new ModelAndView();
				//view 페이지 구성
				//servlet-context.xml -> prefix : web/ins/d[ra
				 //                   ->suffix: .jsp
				// WEB-INF/views/caclResult.jsp
				
				mav.setViewName("calcResult");
				
				//공유 장소 request영역에 값 올리기 
				req.setAttribute("msg", "<h1>두 수의 나누기  </h1>");
				req.setAttribute("img", "<img src='resources/images/div.png'>");
				req.setAttribute("no1", no1);
				req.setAttribute("no2", no2);
				req.setAttribute("result", result);
			
				return mav;
			}
			
			//2) 요청 명령어를 처리하는 메소드 매개변수의 유연성
			// @RequestParam("요청변수명") 자료형 변수명
			//-> 사용자가 요청한 값을 직접 변수에 저장가능하다 
			//결과 확인 
			//http://localhost:8090/basicspring/diff.do?no1=3&no2=5
			
			@RequestMapping("diff.do")
			public ModelAndView diff(@RequestParam("no1") int a, @RequestParam("no2") int b ) {
				
				int result=Math.abs(a-b);
				ModelAndView mav=new ModelAndView();
				mav.setViewName("calcResult");
				
				//request에 값 올리기 
				mav.addObject("msg","<h1>두수 사이의 차이 </h1>");
				mav.addObject("no1",a);
				mav.addObject("no2",b);
				mav.addObject("result",result);
				
				return mav;
				
			}
			
			
			
			//3) 사용자가 요청한 값을 매개변수로 직접 지정가능하다 
			// -> 요청 변수명가 매개변수명이 동일해야한다 
			
			//결과 확인 
			//http://localhost:8090/basicspring/max.do?no1=3&no2=5
			
			@RequestMapping("max.do")
			public ModelAndView max(int no1, int no2) {
				
				int result=Math.max(no1,no2);
				ModelAndView mav=new ModelAndView();
				mav.setViewName("calcResult");
				
				//request에 값 올리기 
				mav.addObject("msg","<h1>두수 중 큰수  </h1>");
				mav.addObject("no1",no1);
				mav.addObject("no2",no2);
				mav.addObject("result",result);
				
				return mav;
			}

			
			
			
			
			
			
			
			
}
