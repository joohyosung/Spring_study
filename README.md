# Spring 실습 프로젝트

13개 프로젝트를 Maven 프로젝트로 정리했습니다. JDK 21로 빌드하며 Java 11 호환 바이트코드를 생성합니다. 모든 소스 파일은 UTF-8입니다.

## IntelliJ에서 열기

1. 전체 프로젝트를 함께 보려면 이 폴더의 `pom.xml`을 열고 Maven 프로젝트로 가져옵니다.
2. 하나만 작업하려면 해당 프로젝트 폴더의 `pom.xml`을 엽니다.
3. Maven 도구 창에서 모든 Maven 프로젝트를 새로고침하고 의존성 다운로드가 끝날 때까지 기다립니다.
4. Lombok 플러그인을 활성화합니다. Maven 컴파일에는 Lombok 어노테이션 처리기가 명시되어 있습니다.

각 프로젝트의 artifactId는 폴더 이름과 같습니다. 중복 모듈 이름 때문에 여러 프로젝트를 함께 열지 못하는 문제를 피하도록 구성했습니다.

## 빌드

저장소 루트에서 `mvn clean package`를 실행하면 모든 프로젝트를 빌드하고 기존 테스트를 실행합니다. 프로젝트 폴더에서 같은 명령을 실행하면 해당 프로젝트만 빌드합니다.

## Tomcat 9

IntelliJ의 실행 → 구성 편집에서 Application server에 로컬 Tomcat 9를 연결합니다. 공유 실행 설정은 서버 이름 `Tomcat 9.0.123`을 참조하므로 같은 이름으로 등록하세요. Tomcat 설치 경로는 Git에 저장하지 않습니다. 각 컴퓨터에서 설치한 Tomcat 9 경로를 선택하세요.

- 개별 프로젝트를 열었다면 `<프로젝트명> - Tomcat 9`를 선택합니다.
- 전체 루트를 열었다면 `<프로젝트명> - Tomcat 9 (all projects)`를 선택합니다.
- 실행 버튼을 누르면 Maven 패키징 후 `<프로젝트명>:war exploded`를 배포합니다.
- 각 서버의 HTTP/JMX 포트를 분리해 동시에 실행할 때 8080/1099 충돌을 피했습니다.
- HTML의 브라우저 미리보기(63342)는 Servlet/Spring 요청을 처리하지 않습니다. 아래 Tomcat URL로 접속하세요.

| 프로젝트 | HTTP | JMX | 시작 URL |
|---|---:|---:|---|
| step06_Servlet | 8080 | 1099 | http://localhost:8080/step06_Servlet/b.jsp |
| step08_Servlet | 8081 | 1100 | http://localhost:8081/step08_Servlet/loginForm.jsp |
| step09_Servlet_Login | 8082 | 1101 | http://localhost:8082/step09_Servlet_Login/loginForm.jsp |
| step10_MyFramework | 8083 | 1102 | http://localhost:8083/step10_MyFramework/index.jsp |
| step11_MyFrameworkLIB | 8084 | 1103 | http://localhost:8084/step11_MyFrameworkLIB/index.jsp |
| step12_WebMVC | 8085 | 1104 | http://localhost:8085/step12_WebMVC/ex01_requestMapping.html |
| step13_MVC_Product | 8086 | 1105 | http://localhost:8086/step13_MVC_Product/ |

Spring 5 / javax.servlet 실습이므로 Tomcat 9를 사용하세요. Tomcat 10 이상으로 바꾸려면 jakarta.servlet 전환이 필요합니다.

## 실습 자료

- DI/AOP 프로젝트는 각 MainApp의 main 메서드 옆 실행 버튼으로 실행합니다.
- 웹 프로젝트의 JSP는 Tomcat에서 실행합니다. WEB-INF 내부 JSP는 Controller를 통해 접근합니다.
- 초기 상품 목록은 XML의 ProductDTO 빈으로 구성되어 있으며 외부 DB가 필요하지 않습니다.
- 자동 생성되는 target/build/out 및 개인 .idea 설정은 Git에서 제외합니다. 공유 실행 설정은 .run 디렉터리에 저장합니다.
- 기존 실습 코드와 파일명(steop04, steop05 포함)은 보존했습니다.

## 검증 결과

JDK 21에서 13개 프로젝트의 Maven package와 기존 테스트가 통과했습니다. Tomcat 9.0.123에서 웹 프로젝트 7개의 JSP 사전 컴파일과 대표 HTTP 요청 18개를 검증했습니다. 상품 등록·삭제 확인은 임시 Tomcat의 메모리 데이터에서만 수행했습니다.
