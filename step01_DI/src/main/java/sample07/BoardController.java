package sample07;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;

@Controller("controller")
@RequiredArgsConstructor // final 필드 또는 @Nonill이 선언된 필드를 기준
public class BoardController {
//  @Autowired
    private final BoardService boardService;

    @Autowired
    private BoardDTO boardDTO;

    @Autowired
    private BoardDTO boardDTO2;

    public void test(){
        System.out.println("BoardController test call");
        boardService.select();
    }

    @PostConstruct
    public void init(){
        System.out.println("-------------------");
        System.out.println("boardDTO = "+boardDTO);
        System.out.println("boardDTO2 = "+boardDTO2);
    }
}
