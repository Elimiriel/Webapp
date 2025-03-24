## Getting Started

Welcome to the VS Code Java world. Here is a guideline to help you get started to write Java code in Visual Studio Code.

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

## Dependency Management

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).

## JSP

HTML main+Java: after process; wrapping into HTTP

## Servlet

Java main(controller), inserted HTML+CSS+JS as output(view): actual process->TOO LONG COMPLEX CODE // .jsp: HTML wrapped Java+intersublet

- 정적인 웹 페이지의 문제점을 보완하여 나온 것이 동적인 웹 페이지를 구현하는 JSP임. 하지만 사실 동적인 웹 페이지를 처음으로 구현한 것은 JSP가 아님. 초기에 동적인 웹 페이지를 구현한 것은 서블릿(Servlet) 이었음.
- 서버 쪽에서 실행되면서 **클라이언트의 요청에 따라 동적으로 서비스를 제공하는 자바 클래스**임.
- 서블릿은 자바로 작성되어 있으므로 자바의 일반적인 특징을 모두 가지고 있음.
- 서블릿은 서버에서 실행되다가 웹 브라우저에서 요청을 하면 해당 기능을 수행한 후 웹 브라우저에게 결과를 전송함.
- 서버에서 실행되기 때문에 보안과 관련된 기능도 훨씬 안전하게 수행이 가능함.

  ※ 서블릿의 특징.

  1. 서버쪽에서 실행되면서 기능을 수행함.
  2. 기존의 정적인 웹 프로그램의 문제점을 보완하여 동적인 여러 가지 기능을 제공함.
  3. 스레드 방식으로 실행이 됨.
  4. 자바로 만들어져서 자바의 특징(객체 지향)을 가짐.
  5. 서블릿 컨테이너에서 실행됨.
  6. 컨테이너 종류에 상관없이 실행됨(플랫폼 독립적).
  7. 보안 기능을 적용하기 쉬움.
  8. 웹 브라우저에서 요청시 기능을 수행함.
- 서버에서 만들어진 서블릿이 스스로 작동하는 것이 아니라, 서블릿을 관리해 주는 것이 필요한데, 이러한 역할을 하는 것이 바로 서블릿 컨테이너임. 즉, 서블릿을 '요구사항 명세서' 라고 표현한다면, 서블릿 컨테이너는 그 명세서를 보고 개발하는 '개발자' 임. 서블릿 컨테이너는 Client의 request(요청)를 받아주고, response(응답)할 수 있게, 웹 서버와 소켓을 만들어 통신을 함. 대표적으로는 무료 서비스인 톰캣(Tomcat)이 있음. 톰캣은 웹 서버와 소켓을 만들어 통신하며 JSP(Jaca Srver Page)와 Servlet이 작동할 수 있는 환경을 만들어 줌.

  ### Document base format of .jsp
- Already HTML wrapped form
- ```jsp
  <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
  ```

  이 줄은 JSP 페이지 지시자입니다. 이 지시자는 페이지의 속성을 설정합니다.

  - `language="java"`: 이 JSP 페이지에서 사용할 언어를 지정합니다. 기본적으로 Java입니다.
  - `contentType="text/html; charset=UTF-8"`: 생성된 페이지의 MIME 타입과 문자 인코딩을 지정합니다. 여기서는 HTML 문서이고 UTF-8 인코딩을 사용합니다.
  - `pageEncoding="UTF-8"`: JSP 페이지 자체의 문자 인코딩을 지정합니다.

  ```jsp
  <!DOCTYPE html>
  <html>
  ```

  이 줄은 HTML5 문서 타입을 선언하고 HTML 문서의 시작을 알립니다.

  ```jsp
  <head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Insert title here</title>
  </head>
  ```

  - `<head>`: HTML 문서의 머리 부분을 정의합니다. 여기에는 메타데이터, 제목, 스타일시트 링크 등이 포함됩니다.
  - `<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">`: 문서의 문자 인코딩을 UTF-8로 설정합니다.
  - `<title>Insert title here</title>`: 브라우저 탭에 표시될 문서의 제목을 설정합니다.

  ```jsp
  <body>
  <!--HTML COMMENT, ctrl+shft+/ in eclipse -->
  <%-- JSP Comment --%>
  <h2>Init!</h2>
  </body>
  </html>
  ```

  - `<body>`: HTML 문서의 본문을 정의합니다. 여기에는 실제로 화면에 표시될 콘텐츠가 포함됩니다.
  - `<!--HTML COMMENT, ctrl+shft+/ in eclipse -->`: HTML 주석입니다. 브라우저에 표시되지 않습니다.
  - `<%-- JSP Comment --%>`: JSP 주석입니다. JSP 파일을 처리할 때 무시되며, HTML 주석과 달리 클라이언트에게 전송되지 않습니다.
  - `<h2>Init!</h2>`: "Init!"라는 텍스트를 포함하는 HTML 헤딩 요소입니다.
  - `</body>`: HTML 문서의 본문 끝을 알립니다.
  - `</html>`: HTML 문서의 끝을 알립니다.

  이 코드는 기본적인 HTML 구조를 포함한 JSP 페이지로, UTF-8 인코딩을 사용하여 HTML 콘텐츠를 생성합니다.

## Next: Spring(boot)
