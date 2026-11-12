package kosta.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 이 클래스가 웹브라우져에서 동작(실행) 할수 있게 하고 싶다.!
 *   => 자바중심의 코드에서 마크업을 섞어서 사용할수있다.
 * 
 * 조건 : 
 *    1) 반드시 public 클래스로 선언
 *    2) HttpServlet 상속받는다.
 *    3) 필요한 메소드(servlet의 lifecycle에 관련된 메소드 )를 
 *        재정의해서 기능을 작성한다.
 *        
 *    4) 브라우져에서 어떻게 요청하면 현재 서블릿이 실행될지에해당하는 
 *      설정( web.xml or @annotation )이 필요하다!!
 * */
public class TestServlet extends HttpServlet {
	
	public TestServlet() {
		System.out.println("TestServlet 생성됨...");
	}
	
	/**
	 * 사용자 요청이 들어올때마다 호출된다.
	 * */
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("되니?");
		
		//전송된 id 받기
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		//받은 아이디를 가지고 서비스 호출하고 결과받는다.
		
		if("jang".equals(id) && "1234".equals(pwd)) {//비번이 1234인지도 체크한다.
			//성공했을때 뷰쪽을 전달할 데이터 scope에 저장
			request.setAttribute("list", Arrays.asList("짬뽕","짜장","탕수육")); //뷰에서 ${list}
			
			//이동하기 
			request.getRequestDispatcher("ok.jsp").forward(request, response);
			
		}else {
			//실패 - 이동할때 오류메지를 전달하고 싶다!
			//오류메시지를 request scope에 저장해보자
			request.setAttribute("errMessage","정보를 다시 확인해주세요  servlet."); //뷰에서 ${errMessage}
			request.getRequestDispatcher("fail.jsp").forward(request, response);
			
			//response.sendRedirect("fail.jsp");//새로운 request,response를 생성해서이동한다.
		}
		
		
		//브라우져에 출력
		/*PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<head><title>서블릿실습</title></head>");
		
		out.print("<body>");
		
		out.print("<h1>Servlet Success </h1>" + id);
		
		out.print("</body>");
		out.print("</html>");*/
	}

}







