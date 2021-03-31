Web services implemented alone with spring boots and AWS <br>
[스프링 부트와 AWS로 혼자 구현하는 웹 서비스] - 지승구 연습용 Repository<br>
http://m.yes24.com/Goods/Detail/83849117


***
<h3>[Mac os 단축키]</h4> <p>
패키지 가져오기(import) : [Option + Enter]<br>
깃 커밋 : [Command + K]<br>

****
<h3>[Spring Boot Annotation]</h4></p>

**@SpringBootApplication<br>**

- 스프링 부트의 자동 설정, 스프링Bean읽기와 생성을 모두 자동으로 설정<br>

**@RestController**<br>
-  컨트롤러를 JSON을 반환하는 컨트롤러로 만들어준다

**@RunWith(SpringRunner.class)**<br>
-   테스트를 진행할 때 JUnit에 내자된 실행자 외에 다른 실행자를 실행.
-   SpringRunner라는 스프링 실행자를 사용
-   즉,스프링 부트 테스트와 JUnit 사이에 연결자 역할을 한다

**@WebMvcTest** 
- 여러 스프링 테스트 어노테이션 중, Web(Spring MVC)에 집중할 수 있는 어노테이션
- 선언할 경우 @Controller,@ControllerAdivce 등은 사용할 수 있음
- 단, @Service, @Component, @Repository 등은 사용할 수 없음

**@Getter [lombok]**
- 선언된 모든 필드의 get 메소드 생성

**@RequiredArgsConstructor [lombok]**
- 선언된 모든 final 필드가 포함된 생성자를 생성해 준다.
- final이 없는 필드는 생성자에 포함되지 않는다. 

**@Entity [JPA]**
- 테이블과 링크될 클래스임을 나타내는 어노테이션 
- 기본값으로 클래스의 카멜게이스 이름을 언더스코어 네이밍(_)으로 테이블 이름 매핑<br>
-- Ex) SalesManager.java -> sales_manager table

**@Id [JPA]**
 - 해당 테이블의 PK 필드 
***
<h3> [Dependencies] </h3> 
 
 - compile('org.springframework.boot:spring-boot-starter-data-jpa') <br>
    > 스프링 부트용 Spring Data Jpa 추상화 라이브러리
 - compile('com.h2database:h2')<br>
   > 1.인메모리 관계형 데이터베이스 <br>
   >  2.별도의 설치가 필요없이 프로젝트 의존성만으로 관리가능 <br>
   > 3.메모리에서 실행되기 때문에 애플리케이션을 재시작할 때마다 초기화된다는 점을 이용하여 테스트 용도로 많이 사용 <br>
  
***
<h4>참고 사항<br>
- 그래들 버젼 다운그레이드 : 예시) ./gradlew wrapper --gradle-version 4.10.2<br>
- lombok 사용시 <span style="color:red">Gradle 버전이 5 이상</span>인 경우 dependencies{} 위치에 <br>
  > annotationProcessor("org.projectlombok:lombok") <br>
  > compileOnly("org.projectlombok:lombok") <br>
  추가 필요

***
