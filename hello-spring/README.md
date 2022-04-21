# 스프링 입문 - 코드로 배우는 스프링 부트, 웹 MVC, DB 접근 기술

`강의 내용 정리`

## 목차
1. [프로젝트 생성](#1-프로젝트-생성)  
2. [라이브러리 설정](#2-라이브러리-설정)  
3. [View Page 설정](#3-view-page-설정)  
4. [빌드 및 실행](#4-빌드-및-실행)  

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