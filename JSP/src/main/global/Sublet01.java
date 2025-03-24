package src.main.global;
/*
 * OpenJDK에는 기본적으로 `javax.servlet` 패키지가 포함되어 있지 않습니다. 이를 해결하려면 서블릿 API 라이브러리를 프로젝트에 추가해야 합니다. Maven을 사용하여 프로젝트를 관리하고 있다면, `pom.xml` 파일에 다음과 같이 서블릿 API 의존성을 추가할 수 있습니다.

```xml
<dependencies>
    <!-- ...existing dependencies... -->
    <dependency>
        <groupId>javax.servlet</groupId>
        <artifactId>javax.servlet-api</artifactId>
        <version>4.0.1</version>
        <scope>provided</scope>
    </dependency>
</dependencies>
```

Maven을 사용하지 않는 경우, 직접 서블릿 API JAR 파일을 다운로드하여 프로젝트의 클래스패스에 추가할 수 있습니다. 다음은 서블릿 API JAR 파일을 다운로드하고 클래스패스에 추가하는 방법입니다.

1. [Maven Central Repository](https://mvnrepository.com/artifact/javax.servlet/javax.servlet-api/4.0.1)에서 `javax.servlet-api-4.0.1.jar` 파일을 다운로드합니다.
2. 다운로드한 JAR 파일을 프로젝트의 `lib` 디렉토리에 복사합니다.
3. IDE에서 프로젝트의 클래스패스에 JAR 파일을 추가합니다.

Visual Studio Code에서 클래스패스에 JAR 파일을 추가하는 방법은 다음과 같습니다.

1. 프로젝트의 루트 디렉토리에 `lib` 디렉토리를 생성하고, 다운로드한 JAR 파일을 이 디렉토리에 복사합니다.
2. `.classpath` 파일을 열고 다음과 같이 JAR 파일을 클래스패스에 추가합니다.

```xml
<classpath>
    <!-- ...existing classpath entries... -->
    <classpathentry kind="lib" path="lib/javax.servlet-api-4.0.1.jar"/>
</classpath>
```

이제 `javax.servlet` 패키지를 사용할 수 있습니다. Sublet01.java 파일의 패키지 선언을 수정하고, 잘못된 import를 제거한 후 코드를 다시 확인해 보겠습니다.
 * 
 */

import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/250324/sublet01")//URL mapping annotation
//web.xml: <servlet><servlet-name>sublet01</servlet-name><servlet-class>global.Sublet01</servlet-class></servlet>
//<servlet-mapping><servlet-name>sublet01</servlet-name><url-pattern>/250324/sublet01</url-pattern></servlet-mapping>
public class Sublet01 extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public Sublet01() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Hello, World!</h1>");
        out.println("</body></html>");
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /* 서블릿에서 클라이언트의 요청을 얻는 방법
        * - HttpServletRequest 클래스에서 <form> 태그로 전송된 데이터를 받아오는데 사용하는 메서드.
        *   * getParameter(String name) 
        *     => <form> 태그의 name 속성에 들어간 변수명을 받아 사용. 반환형은 String 타입임.
        *   * getParameterValues(String name) 
        *     => 같은 name에 대하여 여러 개의 값을 얻을 때 사용함. 반환형은 String[] 타입임.
        *                                   
        * 서블릿에서 요청 받은 내용을 처리하여 클라이언트에 보내는 방법
        * 1. HttpServletResponse 클래스를 이용하여 응답을 함.
        * 2. doGet()이나 doPost() 메서드 안에서 처리함.
        * 3. javax.servlet.http.HttpServletResponse 객체
        * 4. setContentType() 메서드를 이용하여 클라이언트에게 전송할  데이터의 종류(MIME-TYPE)를 지정함.
        * 5. 클라이언트(웹 브라우저)와 서블릿의 틍신은 자바 I/O의 스트림을 이용함.
        * 
        * 
        * 서블릿 생명 주기(Life Cycle)
        * Servlet 객체 생성 → init() 메서드 호출 → service(), doGet(), doPost() 메서드 호출 → destroy() 메서드 호출
        *   (최초 한 번)        (최초 한 번)                   (요청 시 매번)                    (마지막 한 번)
        * 
        * - init() : 서블릿 요청 시 맨 처음 한 번만 호출됨.
        *            서블릿 생성 시 초기화 작업을 주로 진행을 함.
        * - doGet() / doPost() : 서블릿 요청 시 매번 호출됨. 실제로 클라이언트가 요청하는 작업을 수행함.
        * - destory() : 서블릿이 기능을 수행하고 메모리에서 소멸될 
        *               때 호출이 됨. 서블릿의 마무리 작업을 주로 
        *               수행을 함.
        * - 서버(서블릿)에서 웹 브라우저로 데이터를 전송할 때에는 어떤 
        *   종류의 데이터를 전송하는지 웹 브라우저에게 알려 주어야 함.
        *   => 이유 : 웹 브라우저가 전송 받을 데이터의 종류를 미리 알고
        *            있으면 더 빠르게 처리할 수 있기 때문임.
        * - 데이터 종류(MIME-TYPE) : 톰캣 컨테이네에서 미리 설정해 놓은 데이터의 종류들. 브라우저는 기본적으로 HTML만 인식->서블릿에서 전송하는 대부분의 데이터 MIME-TYPE: "text/html"
        * - 서블릿이 클라이언트(웹 브라우저)에 응답하는 과정.
        *   * setContentType()을 이용해서 MIME-TYPE을 지정함.
        *   * 데이터를 출력할 PrintWriter 객체를 생성함.
        *   * 출력 데이터를 HTML 형식으로 만듬.
        *   * PrintWriter 객체의 print()나 println() 메서드를 이용해 데이터를 출력함.
        * 
        * 
        * 웹 브라우저에서 서블릿으로 데이터를 전송하는 전송 방식(2가지)
        * 1. get 방식
        *    - 서블릿에 데이터를 전송할 때는 데이터가 url 뒤에 name=value 형태로 전송이 됨.
        *    - 여러 개의 데이터를 전송할 때는 '&'로 구분하여 전송이 됨.
        *    - 보안이 취약, 최대 255자.
        *    - 기본 전송 방식이고 사용이 쉬움.
        *    - 웹 브라우저에 직접 입력해서 전송할 수도 있음.
        *    - 서블릿에서는 doGet() 메서드에서 전송된 데이터를 처리함.
        *    - get 방식의 요청은 단순 데이터 조회하는 경우에 적합함.
        *     
        * 2. post 방식
        *    - TCP/IP 프로토콜 데이터의 head 영역에 숨겨진 채 전송이 됨.
        *    - 보안, 전송 데이터의 용량이 무제한이나  속도가 get 방식보다 느림.
        *    - 서블릿에서는 doPost() 메서드에서 전송된 데이터를 처리함.\
        * Mapping
        * 1. url mapping
        * 2. web.xml mapping
        */
        //no tofu at inputs and outputs
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().append("Served at: ").append(request.getContextPath());
        
        String name = request.getParameter("id");
        String password = request.getParameter("pw");
        String phone=request.getParameter("phone");
        String adress=request.getParameter("addr");
        String[] hobby=request.getParameterValues("hobby");
        

        //output object
        PrintWriter out = response.getWriter();//force insert HTML tag
        //passing jsp, direct out from sublet
        out.println("<!DOCTYPE html>");
        out.println("<div align=\"center\">");
        out.println("<h2>info</h2>");
        out.println("<table border=\"1\">");
        out.println("<tr><td>id</td><td>"+name+"</td></tr>");
        out.println("<tr><td>pw</td><td>"+password+"</td></tr>");
        out.println("<tr><td>phone</td><td>"+phone+"</td></tr>");
        out.println("<tr><td>addr</td><td>"+adress+"</td></tr>");
        for (String h : hobby) {
            //only checked hobby
            out.println("<tr><td>hobby</td><td>"+h+"</td></tr>");
        }
        out.println("</table>");
        out.println("</div>");
        out.println("<head></head>");
        out.println("<body></body>");
        out.println("</html>");
    }
}