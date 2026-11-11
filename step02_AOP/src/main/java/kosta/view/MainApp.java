package kosta.view;

import kosta.service.GoodsService;
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

        System.out.println("--GoodsService call...");
        // interface가 없기 때문에 AOP proxy 객체가 CGLIB방식으로 생성된다.s
        GoodsService goodsService = context.getBean("target2", GoodsService.class);
        goodsService.insert();
        System.out.println("==================");
        goodsService.goodsSelect(100);
    }
}
