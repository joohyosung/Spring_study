package sample01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        // 1. 기존방식
        /*
        MessageBean bean = new MessageBeanEnImpl();
        bean.sayHello("hyosung");
        System.out.println("-----------");

        bean = new MessageBeanKoImpl();
        bean.sayHello("hyosung");
        */

        // 2. Spring IoC 즉 Spring Container로 bean 관리
        /*
        * ApplicationContext는 BeanFactory(객체의 생성, 소멸에 관한 라이프사이클)를 상속받은
        * interface로 BeanFactory 기능 + 다국어 지원, 메시지 처리, 부가적인 기능 수행
        *
        * ApplicationContext Spring Container는 bean들을 singleton으로 관리
        * : 사전 초기화(미리 객체를 생성해서 메모리 위에 올린다.)
        * : 동일한 ID를 여러번 getBean을 해도 항상 동일한 객체 (공유)
        *
        * bean 생성 시 scope="prototye" 옵션을 설정하면 지연초기화로 필요할 때마다 새로운 객체를 생성
        * */
        ApplicationContext application = new ClassPathXmlApplicationContext("applicationContext.xml");

        System.out.println("--bean 객체 안에 있는 메소드 호출--");
        MessageBean bean = application.getBean("en", MessageBean.class);
        bean.sayHello("hyosung");

        bean = application.getBean("ko", MessageBean.class);
        bean.sayHello("hyosung");

        System.out.println("-------------");
        MessageBean bean2 = application.getBean("ko", MessageBean.class);

        System.out.println("bean = " + bean);
        System.out.println("bean2 = " + bean2);
    }
}
