Web services implemented alone with spring boots and AWS <br>
[스프링 부트와 AWS로 혼자 구현하는 웹 서비스] - 지승구 연습용 Repository<br>
http://m.yes24.com/Goods/Detail/83849117

***
<h3>[내가 이해하는 Class 역할]</h3><br>
**[DTO]**  
- 계층간 데이터 교환을 위한 객체 (VO랑 비슷하지만 다른 개념)
- DB의 데이터를 Service나 Controller 등으로 보낼 떄 사용하는 객체
- 로직을 갖고 있지 않은 순수한 데이터 객체이며, getter/setter 메서드만을 갖는다.

**[Entity]**
- 실제 데이터베이스의 테이블과 1:1로 매핑ㄷ 되는 클래스, DB의 테이블내에 존재하는 컬람만을 속성(필드)으로 가져야한다.
- Entity는 클래스는 상속을 받거나 구현체여서는 안되며, 테이블내에 존재하지 않는 컬럼을 가져서도 안된다.

**[Entity, DTO 분리 이유]**
- DBLayer와 View Layer 사이의 역할을 분리 하기 위해서
- Entity 클래스는 실제 테이블과 매핑되어 변경하게 되면 여러 다른클래스에 영향을 끼치고, DTO클래스는 View와 통신하며 자주 변경되므로 분리 해주어야한다.

**[DTO 와 VO 차이점 ]**
- VO는 DTO와 동일한 개념이지만 read Only 속성을 갖는다, VO는 특정한 비지니스 값을 담는 객체이고, DTO는 Layer간의 통신 용도로 오고가는 객체를 말한다.

**순서흐름**
1. Client 가 Request를 보낸다.
2. Request URL에 알맞은 Controller가 수신한다.
3. Controller는 넘어온 요청을 처리하기 위해 Service를 호출한다.
4. Service는 알맞은 정보를 가공하여 Controller 에게 데이터를 넘긴다.
5. Controller는 Service의 결과물을 Client에게 전달해준다.
***
<h3>[Mac os 단축키]</h3> <p>
패키지 가져오기(import) : [Option + Enter]<br>
깃 커밋 : [Command + K]<br>
검색 : [command + shift + A] <br>
****
<h3>[Spring Boot Annotation]</h4></p>

**@SpringBootApplication<br>**

- 스프링 부트의 자동 설정, 스프링Bean읽기와 생성을 모두 자동으로 설정<br>
- 특히나 @SpringBoot Application이 있는 위치부터 설정을 읽어 가기 때문에 이 어노테이션이 있는 클래스는<br>
    프로젝트 최상단에 위치해 있어야 한다.

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
**HiddenHttpMethodFilter**
- 스프링3.0 부터 지원해주는 Filter
- Put del patch 요청인 경우에 _Method로 그 값을 받아와서 컨트롤러에 매핑해주는 필터

**스프링 부트 MVC 확장**
- @Configuration + WebMvcConfigurer

**스프링 MVC 재정의**
- @Configuration + @EnableWebMvc

**HttpMessageConverters**
HTTP요청 본문을 객첼 변경하거나, 객체를 HTTP 응답 본문으로 변경할 때 사용,

***
<h2>오류,에러,설정정보</h2>

<h3> HttpMediaTypeNotAcceptableException </h3>
 - 의 오류는 미디어타입을 처리할 httpConverter가 없다는 의미  <br>
 - httpConverter는 HttpMessageConvertersAutoConfiguration에 의해서 적용이 된다.<br>
 > Json Type을 Convert해주는 class = appingJackson2HttpMessageConverter<br>
 > XML Type을 Convert해주는 class = MappingJackson2XmlHttpMessageConverterConfiguration<br>

<h3>XML Type Convert 의존성 주입 </h3>
```
         <dependency>          
            <groupId>com.fasterxml.jackson.dataformat</groupId>
            <artifactId>jackson-dataformat-xml</artifactId>
            <version>2.9.6</version>
        </dependency>
```

**Application.properties 에 경로 추가 방법**
- 1)spring.mvc.static-path-pattern=/static/** : MVC상단 경로 고정
- 2)@Configuration 에 코드로 경로 추가 하는 방법
```
  //기존 리소스 핸드러는 유지하면서 원하는 리소스 핸들러만 따로 추가할 수 있음
  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
  registry.addResourceHandler("/m/**")
  .addResourceLocations("classpath:/m/")
  .setCachePeriod(20);
  }
```

**버전생략하고 jar사용하는 방법**
(<scirpt> 소스에 명시 되어있는 버전을 변경하기 위해서 모든 view에 찾아가 일일히 수정 해줄 필요 없이 pom.xml에 정의된 버전으로 따라가도록 하여 모든 버전을 일괄적으로 적용시킬 수 있는 방)

```
<dependency>
    <groupId>org.webjars</groupId>
    <artifactId>webjars-locator</artifactId>
    <version>0.40</version>
</dependency>
```
***

**HiddenHttpMethodFilter**
 - 스프링3.0 부터 지원해주는 Filter
 - Put del patch 요청인 경우에 _Method로 그 값을 받아와서 컨트롤러에 매핑해주는 필터


<h3> [Dependencies] </h3> 
 
 - compile('org.springframework.boot:spring-boot-starter-data-jpa') <br>
    > 스프링 부트용 Spring Data Jpa 추상화 라이브러리
 - compile('com.h2database:h2')<br>
   > 1.인메모리 관계형 데이터베이스 <br>
   >  2.별도의 설치가 필요없이 프로젝트 의존성만으로 관리가능 <br>
   > 3.메모리에서 실행되기 때문에 애플리케이션을 재시작할 때마다 초기화된다는 점을 이용하여 테스트 용도로 많이 사용 <br>
 - compile('org.springframework.boot:spring-boot-starter-mustache')
    > Mustache 의존성 적용 
***
<h4>참고 사항<br>
- 그래들 버젼 다운그레이드 : 예시) ./gradlew wrapper --gradle-version 4.10.2<br>
- lombok 사용시 <span style="color:red">Gradle 버전이 5 이상</span>인 경우 dependencies{} 위치에 <br>
  > annotationProcessor("org.projectlombok:lombok") <br>
  > compileOnly("org.projectlombok:lombok") <br>
  추가 필요

***
