package kosta.web.controlller;

import kosta.web.dto.UserDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

@Controller // 생성 id="requestMappingController
@RequestMapping("/rem")
public class RequestMappingController {

    @RequestMapping("/a.do")
    public ModelAndView a() {
        System.out.println("a.do");
        // WEB-INF/views/result.jsp 이동하고 그쪽의 message 전달
        return new ModelAndView("result", "message", "SpringWebMVC 시작~~");
    }

    /**
     * return : void인 경우는 요청된 주소가 뷰이름이 된다.
     * ex) rem/b.do 요청이 되면 뷰이름은 rem/b가 된다.
     */
    @RequestMapping({"/b.do", "/c.do"})
    public void test(Model model) {
        System.out.println("b.do");
        // 모델에 저장을 하면 requestScope에 저장된다. -> 이동방식: forward
        model.addAttribute("message", "재미있다.");
        model.addAttribute("list", Arrays.asList("A","B","C"));
    }

    /**
     * @return: String인 경우는 리턴값이 뷰이름이 된다.
     * @RequestMapping: 요청방식 구분없이 처리
     * 만약 요청 방식(http method = get, post, delete, patch, put)
     * 구분하고 싶다면?
     * @GetMapping
     * @PostMapping
     *
     * RestAPI 요청 방식
     * @PutMapping
     * @PatchMapping
     * @DeleteMapping
     */
//    @RequestMapping("/test.do")
    @GetMapping("/test.do")
    public String test(HttpServletRequest request) {
        String name = request.getParameter("name");
        System.out.println("name:" + name);
        return "result"; // WEB-INF/views/result.jsp로 이동
    }

    @PostMapping("/test.do")
    public String test2(HttpServletRequest request) {
        String name = request.getParameter("name");
        System.out.println("name:" + name);
        return "home"; // WEB-INF/views/home.jsp로 이동
    }

    @RequestMapping(value="/a.do", params = {"id"})
    public String test3(HttpServletRequest request) {
        String id = request.getParameter("id");
        System.out.println("id:" + id);

        System.out.println("param설정입니다.");
        return "result";
    }


}
