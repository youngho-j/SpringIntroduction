# 스프링 입문 - 코드로 배우는 스프링 부트, 웹 MVC, DB 접근 기술

`강의 내용 정리`

## 목차
1. [프로젝트 생성](#1-프로젝트-생성)  
2. [라이브러리 설정](#2-라이브러리-설정)  
3. [View Page 설정](#3-view-page-설정)  
4. [빌드 및 실행](#4-빌드-및-실행)
5. [스프링 웹 개발 기초](#5-스프링-웹-개발-기초)  
5-1. [정적 컨텐츠](#5-1-정적-컨텐츠static-content)  
5-2. [MVC와 템플릿 엔진](#5-2-mvc와-템플릿-엔진)  
5-3. [API](#5-3-api)  
6. [회원 관리 예제 - 백엔드 개발](#6-회원-관리-예제---백엔드-개발)   
6-1. [비즈니스 요구사항 정리](#6-1.비즈니스-요구사항-정리)  
6-2. [회원 도메인과 리포지토리 만들기](#6-2-회원-도메인과-리포지토리-만들기)  
6-3. [회원 리포지토리 테스트 케이스 작성](#6-3-회원-리포지토리-테스트-케이스-작성)  
6-4. [회원 서비스 개발](#6-4-회원-서비스-개발)  
6-5. [회원 서비스 테스트](#6-5-회원-서비스-테스트)  
7. [스프링 빈과 의존관계](#7-스프링-빈과-의존관계)  
7-1. [컴포넌트 스캔과 자동 의존관계 설정](#7-1-컴포넌트-스캔과-자동-의존관계-설정)  
7-2. [자바 코드로 직접 스프링 빈 등록하기](#7-2-자바-코드로-직접-스프링-빈-등록하기)  

### 1. 프로젝트 생성  
 - [start.spring.io](https://start.spring.io/) 를 통해 Gradle 프로젝트 생성  
   ![image](https://user-images.githubusercontent.com/65080004/164405171-8132c22f-8277-4b21-bc43-fc97b05ef72a.png)  
   - Project : 프로젝트에서 사용할 빌드 관리도구 선택  
   - Language : 프로젝트에서 사용할 언어 선택
   - Spring Boot : 프로젝트 버전
   - Group : 사용할 그룹 입력(일반적으로 도메인을 거꾸로 입력함)  
   - Artifact : 빌드되어 나오는 결과물(일반적으로 프로젝트 명)
   - Name : 프로젝트 이름(Artifact와 같으면 됨)
   - Description : 프로젝트 설명
   - Packageing : 프로젝트 패키징 방법 선택
   - Java : 사용할 언어 버전 선택
   - Dependencies : 사용할 라이브러리 선택하여 추가  
     (의존 관계가 있는 라이브러리까지 자동으로 추가됨)  
       

 - Generate 클릭 시 (Artifact명).zip 으로 된 파일 다운로드
 - 다운로드한 파일을 원하는 폴더 경로에 압축 해제
 - IntelliJ open을 통해 폴더 경로까지 이동 한 후 build.gradle을 open  
  

 - Gradle?  
   `그루비(Grrovy)를 기반`으로 한 `빌드 자동화, 개발 지원에 중점`을 둔 빌드 도구  
   Ant, Maven 빌드도구의 단점을 보완하고, 장점을 취합하여 만든 오픈소스 빌드 도구    
     

 - Reference  
   [오늘도 MadPlay! Gradle이란 무엇일까?](https://madplay.github.io/post/what-is-gradle)  
   
### 2. 라이브러리 설정  
 - Gradle은 의존관계가 있는 라이브러리를 함께 다운로드 함  
     

 - 주요 라이브러리  
   `스프링 부트 라이브러리`  
   - Spring-boot-starter-web  
     * spring-boot-starter-tomcat : 톰캣(웹 서버)
     * spring-webmvc : 스프링 웹 MVC
   - Spring-boot-starter-thymeleaf : 타임리프 템블릿 엔진(view)
   - Spring-boot-starter[공통] : 스프링 부트 + 스프링 코어 + 로깅
      * spring-boot
         * spring-core
      * spring-boot-starter-logging
         * logback, slf4j

   `테스트 라이브러리`  
   - spring-boot-starter-test
      * junit : 테스트 프레임 워크
      * mockito : 목 라이브러리
      * assertj : 테스트 코드를 좀더 편하게 작성할 수 있도록 도와주는 라이브러리
      * spring test : 스프링 통합 테스트 지원  

### 3. View Page 설정  
 - spring-boot WelcomePage 기능  
   * src/main/resources/static/index.html을 넣어두면 WelcomePage 기능 제공  
   * WelcomePage?  
     도메인 경로로 들어왔을때 첫 화면  
   [관련내용 링크]( https://docs.spring.io/spring-boot/docs/2.3.12.RELEASE/reference/html/spring-boot-features.html#boot-features-developing-web-applications)  
     

 - 템플릿 엔진 동작 확인  
   ![템플릿 엔진 동작 확인](https://user-images.githubusercontent.com/65080004/164414368-4d49f803-d8c0-41ca-b2eb-70369f944087.png)  
   [Thymeleaf 관련 참고할만한 내용](http://progtrend.blogspot.com/2019/05/thymeleaf.html)  
   

 - Reference  
   [My Programming Trend Report Thymeleaf 간단 매뉴얼](http://progtrend.blogspot.com/2019/05/thymeleaf.html)  

### 4. 빌드 및 실행
 - 포트가 겹칠 수 있으므로 실행된 서버 종료후 진행  
     

 - 리눅스  
   ```
   1. 콘솔창 띄우기
   
   2. gradlew 파일이 있는 경로로 이동  
      이동 명령어 : cd [디렉토리 경로]  
      폴더 내 파일 보기 명령어 : ll(ls -l 옵션과 기능이 같음)
   
   3. build 폴더 생성  
      빌드 명령어 : ./gradlew build
   
   4. build 폴더 내 jar 파일 경로까지 이동
      이동 명령어 : cd build/libs
   
   5. jar 파일 실행
      실행 명령어 : java -jar [jar명].jar
   
   6. 실행 확인
      브라우저에 localhost:8080 입력 후 페이지 확인
   
   7. 빌드 삭제
      gradlew 파일 경로까지 이동 후 명렁어 실행
      빌드 삭제 명렁어 : ./gradlew clean  
   
   참고, 이전 빌드 기록 삭제 후 다시 빌드하는 법
   명령어 : ./gradlew clean build
   ```
 - 윈도우
    ```
   1. cmd or IntelliJ Terminal
   
   2. gradlew.bat 파일이 있는 경로로 이동  
      이동 명령어 : cd [디렉토리 경로]  
      폴더 내 파일 보기 명령어 : dir /b
   
   3. build 폴더 생성  
      빌드 명령어 : gradlew build
   
   4. build 폴더 내 jar 파일 경로까지 이동
      이동 명령어 : cd build/libs
   
   5. jar 파일 실행
      실행 명령어 : java -jar [jar명].jar
   
   6. 실행 확인
      브라우저에 localhost:8080 입력 후 페이지 확인
   
   7. 빌드 삭제
      gradlew.bat 파일 경로까지 이동 후 명렁어 실행
      빌드 삭제 명렁어 : gradlew clean  
   
   참고, 이전 빌드 기록 삭제 후 다시 빌드하는 법
   명령어 : gradlew clean build
   ```
     

 - Reference  
   [oliviarla 윈도우에서 빌드하고 실행하기](https://velog.io/@oliviarla/spring-boot%EC%9C%88%EB%8F%84%EC%9A%B0%EC%97%90%EC%84%9C-%EB%B9%8C%EB%93%9C%ED%95%98%EA%B3%A0-%EC%8B%A4%ED%96%89%ED%95%98%EA%B8%B0)  

### 5. 스프링 웹 개발 기초
 - 정적 컨텐츠(Static Content)  
   ```
   서버에서 파일 '그대로' 웹 브라우저에 내려주는 것 (가공 X)  
   
   Ex) Spring Boot - WelcomePage
   ```
 - MVC와 템플릿 엔진  
   ```
   템플릿 엔진 - JSP, PHP 등... 
   HTML을 서버에서 '프로그래밍을 통해 동적으로 바꾸어(렌더링하여)' 내려주는 것 
   
   MVC 패턴(Controller, Model, View)을 적용하여 역할을 분리  
   1. 비즈니스 로직 및 서버관련 일을 처리(Controller)  
   2. 담아(Model)서 View에 전달함
   3. View 처리시 템플릿 엔진을 통해 렌더링하여 클라이언트에게 렌더링한 HTML을 전달 
   ```
 - API
   ```
   json 포맷형식으로 클라이언트에게 데이터를 전달하는 방식  
   (과거에는 xml 포맷도 사용했음)
   
   Ex) 최근 vue.js, react 사용시 api 방식으로 데이터를 전달하면
       화면은 클라이언트가 그리는 방식으로 많이 사용
       
       서버끼리 통신시 많이 사용(어떤 데이터가 왔다갔다하는지가 중요하기 때문에)
   ```

### 5-1. 정적 컨텐츠(Static Content)  
 - 스프링 부트 정적 컨텐츠 기능 [Static Content 참고](https://docs.spring.io/spring-boot/docs/2.3.12.RELEASE/reference/html/spring-boot-features.html#boot-features)  
   ![static 폴더 위치](https://velog.velcdn.com/images%2Fsong22861%2Fpost%2F168caf2a-d196-44cf-9281-ceb18d2dbc04%2FScreen%20Shot%202022-03-15%20at%2010.11.00%20PM.png)  
   [이미지 출처](https://velog.io/@song22861/5%ED%8E%B8-JAVA-spring-boot-study-%EC%A0%95%EC%A0%81-%EC%BB%A8%ED%85%90%EC%B8%A0)  
     
   ```
   Spring Boot는 기본적으로 
   classpath 의 /static or /public or /resources or /META-INF/resources 디렉토리
   또는 ServletContext의 root에서 정적 컨텐츠를 제공함
   
   즉, src/main/resources/static 경로의 내부 파일에 대해 정적 컨텐츠 기능을 사용할 수 있음
   
   예를 들어 localhost:8080/hello-static.html을 웹 브라우저에 입력시 hello-static.html 파일을 
   웹브라우저가 그대로 출력하는 것을 볼 수 있음
   ```
 - 정적 컨텐츠 동작 원리
   ![image](https://user-images.githubusercontent.com/65080004/164480918-22b3f515-27c3-4b58-9d9b-00b3c2585814.png)  
   ```
   1. 웹 브라우저에서 localhost:8080/hello-static.html을 요청
   
   2. 내장된 톰캣 서버가 해당 요청을 받음
   
   3. 톰캣 서버는 받은 요청을 스프링 컨테이너에게 넘김
   
   4. 스프링 컨테이너는 @Controller 쪽에서 해당 요청과 관련된 컨트롤러가 있는지 확인  
      (요청과 Mapping 된 것이 있는지 확인  즉, 컨트롤러가 먼저 우선순위를 갖는다!)  
   
   5. 스프링 컨테이너는 해당 요청과 관련된 컨트롤러가 없다고 판단
   
   6. resources/static 접근하여 해당 요청과 관련된 파일이 있는지 확인
   
   7. 해당 요청과 관련된 것이 존재할경우 웹브라우저에 리턴 
   ```  
 
 - [정적 컨텐츠 커스텀](https://atoz-develop.tistory.com/entry/spring-boot-web-mvc-static-resources) 관련 내용 링크  

  
 - Reference  
   [song22861 정적컨텐츠](https://velog.io/@song22861/5%ED%8E%B8-JAVA-spring-boot-study-%EC%A0%95%EC%A0%81-%EC%BB%A8%ED%85%90%EC%B8%A0)  
   [추가정보 Knowledge Repository 정적 컨텐츠 커스텀](https://atoz-develop.tistory.com/entry/spring-boot-web-mvc-static-resources)  
   
### 5-2. MVC와 템플릿 엔진  
 - MVC  
   `Model`, `View`, `Controller`  
   웹에서 화면을 출력하기 위해 내용을 담고, 보여주고, 전달해주는 소프트웨어 구현 방식중 하나
   - Model  
     화면에 필요한 정보를 담는 역할  
       
   - View  
     화면 출력에 중점을 둠
     
   - Controller   
     비즈니스 로직과 서버와 관련된 일
     

   - 정리  
     `Controller, Model`  
     > 내부적인 것 (비즈니스 로직, 서버단 관련 일 등..)을 처리하는데 집중
     
     `View`
     > 화면을 그리는데 집중
 
 - MVC 동작 원리
   ![image](https://user-images.githubusercontent.com/65080004/164721239-ee6788c9-0154-48e2-961a-ca1efdc42ac0.png)  
   ```
   1. 웹 브라우저에서 localhost:8080/hello-mvc을 요청
   
   2. 내장된 톰캣 서버가 해당 요청을 받음
   
   3. 톰캣 서버는 받은 요청을 스프링 컨테이너에게 넘김
   
   4. 스프링 컨테이너는 @Controller 쪽에서 해당 요청과 관련된 컨트롤러가 있는지 확인  
      (요청과 Mapping 된 것이 있는지 확인  즉, 컨트롤러가 먼저 우선순위를 갖는다!)  
   
   5. 스프링 컨테이너는 해당 요청과 맵핑된 컨트롤러가 있으면 해당 메서드 호출
   
   6. 호출한 메서드의 return 값과 model 값을 viewResolver에 전달  
      viewResolver  
      : view를 찾아주고, 템플릿 엔진을 연결시켜주는 역할
   
   7. viewResolver는 return 값과 같은 이름의 templates/hello-template.html 찾아서
      템플릿 엔진에게 넘겨줌
   
   8. 템플릿 엔진이 렌더링을 해 '변환'을 한 HTML을 웹브라우저에 반영한다.
   ```
 
 - 템플릿 엔진  
   템플릿 양식과 특정 데이터 모델에 따른 입력 자료를 합성하여 결과 문서를 출력하는 소프르웨어  
   > 쉽게 말해 html 파일을 브라우저로 그냥 보내주는 것이 아닌,  
     `서버에서 프로그래밍을 통해 동적으로 바꾸어서 보내주는 역할` 이라고 보면 된다.
   
### 5-3. API  
 - API 방식  
   `브라우저에 데이터만 보내주고` 화면을 만드는 건 브라우저가 담당하도록 함  
   
   > 3가지 방법 중 정적 컨텐츠 방식을 제외하면 2가지   
     (`렌더링한 HTML을 내리는 방식` / `API로 데이터를 내리는 방식`)방식만 기억하면 됨  
      
   > `MVC?`  
      뷰를 찾아 템플릿 엔진을 통해 화면을 렌더링해서 HTML을 웹 브라우저에 넘겨줌  
   
   > `API?`  
      데이터를 브라우저에 넘겨주고 브라우저는 데이터를 받아 화면을 구성  
 
 - API 방식 사용시 참고할 내용
   - `@ResponseBody`  
     > HTTP 통신 프로토콜 Response Body에  
       @ResponseBody가 적용된 메서드의 리턴된 값을 직접 넣어준다는 의미  
       리턴된 값(데이터)은 클라이언트에게 그대로 전달됨  
   
   - 객체를 리턴하는 경우?
     ```java
     @GetMapping("hello-api")
     @ResponseBody
     public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        
        return hello;
     }
     ```
     > 위의 예시 처럼 객체를 return 할 경우 객체가 json으로 변환되어 브라우저에 전달됨  
     
     >`json?`  
     {Key : value} 구조로 이루어진 문자열 데이터 포맷  
     Ex) {"name" : "철수"}
 
 - @ResponseBody 사용 원리  
   ![image](https://user-images.githubusercontent.com/65080004/164896026-5817fb2f-c07d-4db7-acc5-dfa4a54f7cd4.png)  
   ```
   1. 웹 브라우저에서 localhost:8080/hello-api?name=spring을 요청
   
   2. 내장된 톰캣 서버가 해당 요청을 받음
   
   3. 톰캣 서버는 받은 요청을 스프링 컨테이너에게 넘김
   
   4. 스프링 컨테이너는 @Controller 쪽에서 해당 요청과 관련된 컨트롤러가 있는지 확인  
      (요청과 Mapping 된 것이 있는지 확인  즉, 컨트롤러가 먼저 우선순위를 갖는다!)  
   
   5. 스프링 컨테이너는 해당 요청과 맵핑된 컨트롤러가 있으면 해당 메서드 호출
   
   6. 호출한 메서드에 @ResponseBody가 적용된 것 확인
      6-1. return 값이 문자열일 경우   
      6-2. return 값이 객체일 경우 
   
   7. 몇가지 조건을 확인하여 HttpMessageConverter가 동작
      7-1. 넘어온 값이 단순 문자열일 경우 StringHttpMessageConverter 동작
      7-2. 넘어온 값이 객체일 경우 MappingJackson2HttpMessageConverter 동작  
           객체를 JSON 포맷으로 변환
   
   8. 웹 브라우저에 데이터 전달
   ```
### 6. 회원관리 예제 - 백엔드 개발
 - 비즈니스 요구사항 정리  
 - 회원 도메인과 리포지토리 만들기
 - 회원 리포지토리 테스트 케이스 작성
 - 회원 서비스 개발
 - 회원 서비스 테스트

### 6-1. 비즈니스 요구사항 정리   
<details>
    <summary>자세히</summary>  
     
 - 비즈니스 요구사항
   - 데이터 : 회원 ID, 이름  
   - 기능 : 회원 등록, 조회  
   - 아직 데이터 저장소 선정되지 않음(가상의 시니리오)  
      
  
 - 일반적인 웹 어플리케이션 계층 구조  
   ![image](https://user-images.githubusercontent.com/65080004/164960226-65eb0eff-a9fd-4776-9e84-b012a6133c10.png)  
     

 - 클래스 의존관계  
   ![image](https://user-images.githubusercontent.com/65080004/164960325-31dabd48-5e63-47d8-9c44-3ccebbfeb56e.png)  
</details>   
     
### 6-2. 회원 도메인과 리포지토리 만들기
<details>
    <summary>자세히</summary>  
 
 - 회원 도메인 생성
   ```java  
   package hello.hellospring.domain;
   
   public class Member {
     
     private Long id;
     private String name;

     public Long getId() {
       return id;
     }
    
     public void setId(Long id) {
       this.id = id;
     }
    
     public String getName() {
       return name;
     }

     public void setName(String name) {
       this.name = name;
     }
   }
   ```
 - 회원 리포지토리 인터페이스 생성  
   ```java
   package hello.hellospring.repository;
   
   public interface MemberRepository {
     Member save(Member member);
     
     Optional<Member> findById(Long id);
     
     Optional<Member> findByName(String name);
     
     List<Member> findAll();
   } 
   ```
   > `Optional?`  
     Optional<T>는 `null이 올 수 있는 값을 감싸는 Wrapper 클래스`  
     NPE가 발생하지 않도록 도움, 각종 메서드 제공
     
 - 회원 리포지토리 인터페이스 구현체 생성
   ```java
   package hello.hellospring.repository;
   
   public class MemoryMemberRepository implements MemberRepository {

     private static Map<Long, Member> store = new HashMap<>();
     private static long sequence = 0L;

     @Override
     public Member save(Member member) {
       member.setId(++sequence);
       store.put(member.getId(), member);
       return member;
     }

     @Override
     public Optional<Member> findById(Long id) {
       return Optional.ofNullable(store.get(id));
     }

     @Override
     public Optional<Member> findByName(String name) {
       return store.values().stream()
               .filter(member -> member.getName().equals(name))
               .findAny();
     }

     @Override
     public List<Member> findAll() {
       return new ArrayList<>(store.values());
     }
   }
   ```
   > Optional.`ofNullable`  
   > public static <T> Optional<T> ofNullable(T value);  
   > 
   > value가 `null인 경우 빈 Optional 반환`
   
   > store.values().stream()   
   > .filter(member -> member.getName().equals(name))  
   > .findAny();  
   > 
   > 1. public abstract java.util.Collection<V> `values()`  
        HashMap에 저장된 value 목록을 Collection 형태로 리턴  
   >
   > 2. public java.util.stream.Stream<E> `stream()`  
        Collection 형태로 리턴된 값을 stream() 메서드를 통해 순차 Stream 리턴  
   > 
   > 3. public abstract Stream<T> `filter(java.util.function.Predicate<? super T> predicate)`  
        주어진 조건에 일치하는 요소로 구성된 Stream 리턴  
   > 
   > 4. public abstract java.util.Optional<T> `findAny()`  
        빈 Stream이 아닐경우 Optional 반환, 비어있을 경우 빈 Optional 반환  
    
</details>  

### 6-3. 회원 리포지토리 테스트 케이스 작성  
<details>
    <summary>자세히</summary>  

 - `Junit`이라는 프레임워크로 테스트를 실행  
   > main 메서드, 컨트롤러 등을 통해 실행하면 `시간이 오래걸리고,  
   반복실행이 어렵고, 여러 테스트를 한번에 실행하기 힘들기 때문에`   
   
 - 테스트 실행시 실행순서가 보장되지 않음.  
   > 즉, `의존 관계없이(순서에 관계없이) 결과가 보장`되어야 한다.  
   
 - 회원 리포지토리 메모리 구현체 테스트  
   ```java
   // 경로 : test.java.hello.hellospring.repository
   package hello.hellospring.repository;
   
   class MemoryMemberRepositoryTest {

     MemoryMemberRepository repository = new MemoryMemberRepository();

     @AfterEach
     public void afterEach() {
       repository.clearStore();
     }

     @Test
     public void save()_메서드_테스트 {
       Member member = new Member();
       member.setName("spring");
       repository.save(member);

       Member result = repository.findById(member.getId()).get();

       assertThat(result).isEqualTo(member);
     }

     @Test
     public void findByName()_메서드_테스트 {
       Member member1 = new Member();
       member1.setName("spring1");
       repository.save(member1);

       Member member2 = new Member();
       member2.setName("spring2");
       repository.save(member2);

       Member result = repository.findByName("spring1").get();

       assertThat(result).isEqualTo(member1);
     }

     @Test
     public void findAll()_메서드_테스트 {
       Member member1 = new Member();
       member1.setName("spring1");
       repository.save(member1);

       Member member2 = new Member();
       member2.setName("spring2");
       repository.save(member2);

       List<Member> result = repository.findAll();

       assertThat(result.size()).isEqualTo(2);
     }
   }
   ```
   > Tip
   > - 테스트 클래스는 public 접근자가 아니어도 됨
   > - 테스트 메서드 명은 한글로도 작성 가능
   > - @AfterEach  
   >   각각의 테스트가 종료될 때마다 실행될 메서드를 정의  
   > 
   > - @Test의 순서는 보장 되지 않음  
   > - org.assertj.core.api.Assertions의 메서드를 사용하면  
       가독성 측면에서 좋음(왼쪽에서 오른쪽으로 자연스럽게 읽으면 됨)  
</details> 

### 6-4. 회원 서비스 개발
<details>
    <summary>자세히</summary>  
 
 - 회원 서비스 개발  
   ```java
    package hello.hellospring.service;
    
    public class MemberService {

      private final MemberRepository memberRepository 
                                     = new MemoryMemberRepository();

      /*
      * 회원가입
      * */
      public Long join(Member member) {
        validateDuplicateMember(member); //중복 회원 검증
        memberRepository.save(member);
        return member.getId();
      }

      private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                        .ifPresent(m -> {
                           throw new IllegalStateException("이미 존재하는 회원입니다.");
                         });
      }

      /*
      * 전체 회원 조회
      * */
      public List<Member> findMembers() {
        return memberRepository.findAll();
      }

      public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
      }
    }
   ```
   > Tip  
   > - 메서드 작성시 길어지는 코드는 따로 메서드로 추출하는 것이  
   >   깔끔한 코드를 유지하는데 도움이 된다.  
   >   > 추출하고자 하는 코드 드래그 후 [단축키 : ctrl + alt + M]  
   > - 리팩토링 관련 단축키  
   >   > 이름 변경 [단축키 : shift + F6]  
         
   >   > 접근제어자, 반환타입, 이름 등 주요 정보 변경 [단축키 : ctrl + F6]  
   > - service에 대한 개발은 많은 사람들의 의사소통이 들어가는 부분이기 때문에  
   >   메서드 명에 비즈니스적인 용어를 작성하는 것이 의사소통시 이해하기 용이함  
   >   그에 반해 repository는 개발적인 부분이므로 조금 더 자유롭게 작성 가능

</details>  

### 6-5. 회원 서비스 테스트
<details>
    <summary>자세히</summary>  
  
 - 테스트 코드 작성
   ```java
   package hello.hellospring.service;
   
   class MemberServiceTest {

     MemberService memberService;
     MemoryMemberRepository memberRepository;
     
     // 테스트시 동일한 MemoryMemberRepository 객체를 사용하기 위해 
     // memberService 생성시 MemoryMemberRepository를 매개변수로 받아 생성
     // 즉, memberService가 MemoryMemberRepository를 직접 생성하지 않고 외부에서 주입받음
     // 이를 '의존성 주입(Dependency Injection)'이라고 함
     // 각 메서드 실행전에 의존성 주입을 진행하여 동일한 MemoryMemberRepository 객체를 공유하도록 함
     @BeforeEach
     public void beforeEach() {
       memberRepository = new MemoryMemberRepository();
       memberService = new MemberService(memberRepository);
     }
     
     // 테스트의 독립성을 보장하기 위해 적용
     @AfterEach
     public void afterEach() {
       memberRepository.clearStore();
     }

    @Test
    void 회원가입_테스트() {

      //given
      Member member = new Member();
      member.setName("hello");

      //when
      Long saveId = memberService.join(member);

      //then
      Member findMember = memberService.findOne(saveId).get();
      assertThat(findMember.getName()).isEqualTo(member.getName());
    }

    @Test
    public void 회원가입_중복_회원_예외_테스트() {
      //given
      Member member1 = new Member();
      member1.setName("spring");

      Member member2 = new Member();
      member2.setName("spring");

      //when
      memberService.join(member1);

      //then
      
      //assertThrows
      // 첫번째 인자 : 코드의 실행 결과로 발생되는 예외
      // 두번째 인자 : 실행할 코드(람다식)
      IllegalStateException e = 
        assertThrows(IllegalStateException.class, () -> memberService.join(member2));
      assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
   }
   ...
   
   // 의존성 주입을 위한 MemberService 코드 수정
   package hello.hellospring.service
   
   public class MemberService {

     private final MemberRepository memberRepository;

     public MemberService(MemberRepository memberRepository) {
       this.memberRepository = memberRepository;
     }
     ...
   } 
   ```
 > Tip
 > - 테스트 클래스(틀) 생성 단축키
 >   > `클래스 명 선택` 또는 `클래스 내부에 커서 둔 채` [단축키 : ctrl + shift + T]  
 > - 테스트 코드 작성시 `given, when, then` 구조로 작성하면 도움됨   
 >   (구조에 맞게 딱 떨어지는 상황이 아닐수도 있으므로 상황에 따라 응용 또는 변형할 수도 있음)  
 >
 >   `given` : `무언가 주어짐(상황, 데이터 등)`  
 >    - 주어진 데이터 기반으로 검증을 진행하는구나를 알 수 있음
 >  
 >   `when` : `테스트 실행시`  
 >    - 이걸 검증하는구나를 알 수 있음  
 > 
 >   `then` : `이러한 결과가 나와야함`  
 >    - 이러한 결과가 나와야하는구나를 알 수 있음  
 >
 > 
 > - 테스트 작성시 정상 flow작성도 중요하지만  
 >   `예외 flow를 테스트 하는 것이 훨씬 더 중요함`
 >   
 >  
 > - 람다함수 : 익명함수(이름이 없는 함수)를 지칭  
 >   > Ex) () -> memberService.join(member2);  
 >   - 매개변수목록(파라미터)과 몸체로 구분됨
 >     > (매개변수목록) -> {몸체} 
 >   - `->` (매개변수 화살표): 매개변수목록과 몸체를 구분
 >   - 실행문 : 변수 선언, 값 저장, 메서드 호출에 해당하는 코드,  
       작성 후 `반드시 세미콜론(;) 붙여야함`  
 > 
 >   - 매개변수의 타입을 추론할 수 있는 경우 타입 생략 가능   
 >   - 몸체가 단일 실행문이면 중괄호`{}` 생략 가능  
 >   
 > 
 > - Extract Variable 리팩토링  
 >   해당 표현식의 결과를 처리하는데 도움(변수로 추출)  
 >   > 추출할 표현식 선택 후 [단축키 : ctrl + alt + V]  
     
 - Reference  
   [히진쓰 람다식의 개념 및 사용법](https://khj93.tistory.com/entry/JAVA-%EB%9E%8C%EB%8B%A4%EC%8B%9DRambda%EB%9E%80-%EB%AC%B4%EC%97%87%EC%9D%B4%EA%B3%A0-%EC%82%AC%EC%9A%A9%EB%B2%95)  
   [밤둘레 람다란?](https://bamdule.tistory.com/75)  
</details> 
 
### 7. 스프링 빈과 의존관계  
<details>
    <summary>자세히</summary>  

 - 스프링 빈(Bean)
   > `스프링 컨테이너가 생성, 관리하는 자바 객체`  
   > 컨테이너의 관리를 통해 객체를 여러번 생성할 필요 X, 공용으로 사용할 수 있음  
   > `POJO(Plain Old Java Object)`로써 Spring 애플리케이션을 구성하는 핵심 객체

 
 - 스프링 빈 등록하는 방법  
   1. 컴포넌트 스캔 원리를 통해 자동 등록  
   2. 자바 코드로 직접 등록 
   

 - 참고
   - 스프링 빈 등록시, 기본적으로 싱글톤으로 등록한다. (싱글톤이 아니게 설정가능)  
     (유일하게 하나를 등록 후 공유 즉, 같은 스프링 빈은 같은 인스턴스)  
   - 스프링을 쓰면, 웬만한건 다 스프링 빈으로 등록해서 써야함(얻는 이점이 많음)  
</details>   

### 7-1. 컴포넌트 스캔과 자동 의존관계 설정  
<details>
    <summary>자세히</summary>  

 - 컴포넌트 스캔(Component Scan)?
   ```
   @Component를 가진 모든 대상을 가져와서 빈에 등록하기 위해 찾는 과정  
   ```
 - 컴포넌트 스캔 원리  
   ```java
   @Controller
   public class MemberController {
     
   }
   ```
   위의 코드처럼 클래스를 작성 후 @Controller 어노테이션을 붙일 경우  
     1. 스프링 실행시 스프링 컨테이너가 생성  
     2. 생성된 `컨테이너에 해당 자바 객체(MemberController)를 생성`
     3. 객체를 `컨테이너에 빈으로 등록하고 관리`  
    순서로 동작이 진행됨  
        

 - 참고  
   - @Controller, @Service, @Repository 는 `@Component의 구체화된 형태`  
     
   - 컴포넌트 스캔 대상  
     > `@Component` - 개발자가 직접 작성한 Class를 Bean으로 등록하기 위해 사용  
       `@Controller` - 스프링 MVC 컨트롤러에서 사용  
       `@Service` - 스프링 비즈니스 로직에서 사용  
       `@Repository` - 스프링 데이터 접근 계층에서 사용  
       `@Configuration` - 스프링 설정 정보에서 사용  
     
   - 컴포넌트 스캔 범위  
     > ../hello/hellospring 하위 패키지 경로가 스캔 범위  
     >  
     > 어떻게 알 수 있나?  
       HelloSpringApplication 클래스의 @SpringBootApplication을 보면  
       scanBasePackages()메서드의 스캔 시작 패키지가 기본 패키지로 설정되어있기 때문에  
       ```java
       package hello.hellospring;

       import org.springframework.boot.SpringApplication;
       import org.springframework.boot.autoconfigure.SpringBootApplication;
        
       @SpringBootApplication
       public class HelloSpringApplication {
        
         public static void main(String[] args) {
           SpringApplication.run(HelloSpringApplication.class, args);
         }
       }
       ```
     
 - 자동 의존관계 설정
   ```
   스프링이 스프링 컨테이너에 등록된 빈(Bean) 중에서  
   @Autowired가 적용된 객체와 같은 빈을 찾아 주입  
   ```
   > `의존성 주입`(Dependency Injection) : 객체간의 `의존성을 외부에서 넣어주는 것` 
   >  - 3가지(`필드 주입`, `setter 주입`, `생성자 주입`) 방법이 존재  
   >    그 중 `생성자 주입을 권장`  
 - 자동 의존관계 설정 원리
   ```java
   @Controller
   public class MemberController {
    
     private final MemberService memberService;
    
     @Autowired
     public MemberController(MemberService memberService) {
       this.memberService = memberService;
     }
   }
   ```
   위의 코드처럼 클래스를 작성 후 생성자에 @Autowired 어노테이션을 붙일 경우
     1. 스프링 실행시 스프링 컨테이너가 생성
     2. 생성된 `컨테이너에 해당 자바 객체(MemberController)를 생성`
     3. 스프링이 @Autowired 어노테이션을 확인 
     4. 스프링 컨테이너에서 연관된 빈(MemberService)을 찾아서 주입함   
        순서로 동작이 진행됨
        

 - 참고  
     1. `@Autowired`  
        자동으로 `연관 관계를 설정`해주는 역할(간단하게, `연결한다`라고 생각하기)  
        (스프링 컨테이너에 존재하는 Bean을 주입)  
     2. Bean 주입 순서는 `Type 확인 -> name 확인` 방식으로 주입이 이루어짐   
     3. @Autowired 적용된 객체가 빈으로 등록되어 있지 않거나 2개 이상 존재시 예외 발생  
     4. 생성자에 @Autowired 적용시 의존관계 주입이 필요한 파라미터가 1개일 경우  
        @Autowired 생략 가능  
     5. @Autowired를 통한 DI는 스프링이 관리하는 객체에서만 동작   
         

 - Reference  
   [yeonnex 스프링빈등록과의존관계설정](https://velog.io/@yeonnex/%EC%8A%A4%ED%94%84%EB%A7%81-%EB%B9%88-%EB%93%B1%EB%A1%9D%EA%B3%BC-%EC%9D%98%EC%A1%B4%EA%B4%80%EA%B3%84-%EC%84%A4%EC%A0%95-%EC%BB%B4%ED%8F%AC%EB%84%8C%ED%8A%B8-%EC%8A%A4%EC%BA%94%EA%B3%BC-%EC%9E%90%EB%8F%99-%EC%9D%98%EC%A1%B4%EA%B4%80%EA%B3%84-%EC%84%A4%EC%A0%95)  
   [dodeon 스프링 빈과 의존관계](https://dodeon.gitbook.io/study/kimyounghan-spring-introduction/04-spring-bean-dependencies)  
   [Jan92 @Component, @Bean, @Autowired 어노테이션 알아보기](https://wildeveloperetrain.tistory.com/26)  

</details>   

### 7-2. 자바 코드로 직접 스프링 빈 등록하기
<details>
    <summary>자세히</summary>  

 - 직접 등록 방법  
   1. 기존 MemberService 코드에서 @Service, @Autowired 제거
   2. 기존 MemoryMemberRepository 코드에서 @Repository 제거
   3. SpringConfig.java 파일 생성 (경로 : hello/hellospring)
      ```java
      package hello.hellospring; 
     
      @Configuration
      public class SpringConfig {
        
        @Bean
        public MemberService memberService() {
          return new MemberService(memberRepository());
        }
        
        @Bean
        public MemberRepository memberRepository() {
          return new MemoryMemberRepository();
        }
      }
      ```
   4. `@Configuration` 을 적용하여 해당 클래스에서 Bean을 등록한다고 명시함  
   5. 해당 클래스에 Bean으로 등록하고자하는 메서드에 @Bean 적용  
      주의! `메서드 이름으로 Bean 이름이 결정`되므로, 중복에 주의할 것!  
   
   - 참고  
     `@Configuration 안에서 @Bean을 사용해야 싱글톤을 보장받을 수 있음`

 
 - 빈 등록 과정   
   1. 스프링 실행시 스프링 컨테이너 생성  
   2. 스프링 컨테이너는 @Configuration이 적용된 클래스를 자동으로 빈으로 등록
   3. 해당 클래스를 파싱하여 @Bean이 적용된 메서드를 Bean으로 등록  
    
 
 - 설정을 통해 수동으로 직접 빈을 등록해야하는 경우  
   > 1. 개발자가 직접 제어가 불가능한 라이브러리를 활용할 때  
   > 2. 애플리케이션에서 전 범위적으로 사용되는 클래스를 등록할 때  
   > 3. 다형성을 활용하여 여러 구현체를 등록해주어야 할 때
 
 
 - 설정을 통해 수동으로 직접 빈을 등록하는 것의 장점  
   - `한 눈에 파악하여 유지보수하기 좋기 떄문에`  
    

 - 참고  
   > 실무에서는 주로  
   > `정형화된 Controller, Service, Repository 같은 코드는 컴포넌트 스캔을 사용`하고,   
   > `정형화 되지 않거나, 상황에 따라 구현 클래스를 변경해야 하는 경우  
   > 설정을 통해 스프링 빈`으로 등록 함  
   
 - Reference  
   [망나니개발자 @Bean, @Configuration, @Component 차이 및 비교](https://mangkyu.tistory.com/75)  
   
</details>
