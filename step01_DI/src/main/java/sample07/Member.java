package sample07;

import lombok.Builder;

@Builder
public class Member {
    private String id;
    private String password;
    private int age;
    private String phone;
}
