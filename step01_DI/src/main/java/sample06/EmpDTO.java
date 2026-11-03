package sample06;

import org.springframework.beans.factory.annotation.Value;

public class EmpDTO {
    @Value("100")
    private int empno;

    @Value("hyosung")
    private String ename;

    @Value("${name}")
    private String job;

    public EmpDTO() {
        System.out.println("EmpDTO 기본생성자 호출");
    }

    public void setEmpno(int empno) {
        this.empno = empno;
    }

    public int getEmpno() {
        return empno;
    }

    @Override
    public String toString() {
        return "EmpDTO [empno=" + empno + ", ename=" + ename + ", job=" + job + "]";
    }
}
