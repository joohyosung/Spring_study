package kosta.web.controlller;

import kosta.web.dto.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/param")
@Slf4j
public class ParameterController {

    @GetMapping("/a.do")
    // public String a(String name, int age) {
    public String a(String name, Integer age) {
        System.out.println("a.do");
        System.out.println("name:" + name);
        System.out.println("age:" + age);

        return "result"; // WEB-INF/views/result.jsp
    }

    @GetMapping("/b.do")
    public void b(@RequestParam(defaultValue = "Guest",
                                value = "userId") String id,
                  @RequestParam(defaultValue = "0") int age) { // WEB-INF/views/b.jsp
        System.out.println("b.do");
        System.out.println("id:" + id);
        System.out.println("age:" + age);
    }

    /**
     * 매개변수로 객체(Dto or v)를 받으면
     * 매개변수 앞에 @ModelAttribute 선언된다.
     * view에 전달되는 데이터가 바인딩되고
     * 그 바인딩 된 객체를 뷰에서 사용할 수 있다.
     * 사용방법: 클래스 이름의 첫글자만 소문자 -> UserDTO : ${userDTO.속성}
     */
    @PostMapping("/user.do")
    public String user(@ModelAttribute("dto") UserDto userDto) {

        log.info("user:" + userDto.toString());
//      System.out.println("아이디: " + userDto.getId());
//      System.out.println("이름: " + userDto.getName());
//      System.out.println("나이: " + userDto.getAge());
//      System.out.println("주소: " + userDto.getAddr());

        return "param/user";
    }

    @ModelAttribute("menu")
    public List<String> info() {
        return Arrays.asList("짜장", "짬뽕", "만두");
    }

    @ModelAttribute("mes")
    public String mes(){
        return "졸립다.";
    }

}
