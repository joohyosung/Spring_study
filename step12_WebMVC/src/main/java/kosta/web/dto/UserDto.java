package kosta.web.dto;

import lombok.Getter;
import lombok.Setter;
import org.aspectj.lang.annotation.After;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Getter
@Setter
public class UserDto {

    String id;
    String name;
    int age;
    String addr;



}
