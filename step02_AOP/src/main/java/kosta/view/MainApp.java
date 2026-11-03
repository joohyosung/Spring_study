package kosta.view;

import kosta.service.MemberService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        System.out.println("-----------------------------");
        MemberService service =
                context.getBean("target", MemberService.class);

        service.memberInsert("안녕");

        System.out.println("====================");
        int re = service.memberDelete(10);
        System.out.println("re = " + re);

        System.out.println("====================");
        service.memberUpdate();

        System.out.println("==================");
        String result = service.select("name", "희정");
        System.out.println("result = " + result);

    }
}
