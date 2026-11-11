package kosta.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

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
		System.out.println("TestServlet constructor");
	};

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 전송된 id 받기
		String id = req.getParameter("id");

		// 브라우저에 출력
		PrintWriter out = resp.getWriter();
		out.print("<html>");
		out.print("<head><title>서블릿실습</title></head>");
		out.print("<body>");
		out.print("<h1>Servlet Success </h1>");
		out.print("</body>");
		out.print("</html>");    }

}
