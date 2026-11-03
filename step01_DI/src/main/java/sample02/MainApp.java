package sample02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        /*
        System.out.println("1. 기존방식");


        Member member = new Member("joo", "1234", 32, "sungnam");

        MemberDAO dao = new MemberDAO();

        MemberService service = new MemberService(dao, member);
        service.selectInsert();
        */

        System.out.println("2. Spring IoC Container 사용하기");
        ApplicationContext context = new ClassPathXmlApplicationContext("SpringDI_Constructor.xml");
        System.out.println("------------------------");

        MemberService service =  context.getBean("service", MemberService.class);
        service.selectInsert();
    }
}
