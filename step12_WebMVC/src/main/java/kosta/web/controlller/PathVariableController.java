package kosta.web.controlller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
public class PathVariableController {
    @RequestMapping("/{type}/{id}.do")
    public void aa(@PathVariable String type, @PathVariable String id){
        log.info("aa 여기 오니??");
        log.info("type={}, id={}", type, id);
    }

    @GetMapping("/{id}") //
    public String bb(@PathVariable String id){
        log.info("id={}", id);

        return "result";
    }

    @GetMapping("/borad/{type}/{id}")
    public String cc(@PathVariable String type, @PathVariable String id){
        log.info("type={}, id={}", type, id);

        return "result";
    }
}
