package sample06;

public class EmpService {
    public EmpService(){
        System.out.println("EmpService 기본생성자 호출");
    }

    public void test(EmpDTO dto){
        System.out.println("EmpService의 test call");
        System.out.println("empDTO = " + dto);
    }
}
