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
  

 - 참고   
   Gradle?  
   Ant, Maven 빌드도구의 단점을 보완하고, 장점을 취합하여 만든 오픈소스 빌드도구  
   
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