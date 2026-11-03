package sample07;

public class User {
        private final String name;
        private final int age;
        private final String job;
        private final String address;
        private final String phone;

        // private 생성자 — Builder 외부에서 직접 생성 불가
        private User(Builder builder) {
            this.name = builder.name;
            this.age = builder.age;
            this.job = builder.job;
            this.address = builder.address;
            this.phone = builder.phone;
        }

        // 정적 내부 클래스 Builder
        public static class Builder {
            private String name;
            private int age;
            private String job;
            private String address;
            private String phone;

            public Builder name(String name) {
                this.name = name;
                return this; // 체이닝
            }

            public Builder age(int age) {
                this.age = age;
                return this;
            }

            public Builder job(String job) {
                this.job = job;
                return this;
            }

            public Builder address(String address) {
                this.address = address;
                return this;
            }

            public Builder phone(String phone) {
                this.phone = phone;
                return this;
            }

            // 최종 객체 생성
            public User build() {
                return new User(this);
            }
        }

        @Override
        public String toString() {
            return String.format("User{name='%s', age=%d, job='%s', address='%s', phone='%s'}",
                    name, age, job, address, phone);
        }
}



