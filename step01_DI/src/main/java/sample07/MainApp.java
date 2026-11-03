package sample07;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("sample07/springDI.xml");

        System.out.println("-------------------");

        BoardController con = context.getBean("controller", BoardController.class);

        con.test();

        System.out.println("-------------------");

        BoardDTO dto = new BoardDTO(0);

        System.out.println("---------Builder 패턴 사용하기----------");

        User user = new User.Builder()
                .name("주효성")
                .age(32)
                .job("개발자")
                .address("성남시")
                .build(); // phone은 생략 가능

        System.out.println(user);

        System.out.println("-------------------");
        user = new User.Builder().name("주하린").age(1).job("효녀").address("성남시").build();
        System.out.println(user);

        System.out.println("---------Member----------");
        Member member = new Member.MemberBuilder().age(20).id("joo").build();
        System.out.println(member);
    }
}
