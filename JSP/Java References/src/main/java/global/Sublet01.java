package Java References.src.main.java.global;
import java.io.websublet;
import java.io.IOException;
import java.io.PrintWriter;

@websublet(/member)

public class Sublet01 extends websublet {
    public MemberServlet() {
        super();
    }
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /* 서블릿에서 클라이언트의 요청을 얻는 방법
 * - HttpServletRequest 클래스에서 <form> 태그로 전송된 
 *   데이터를 받아오는데 사용하는 메서드.
 *   * getParameter(String name) 
 *     => <form> 태그의 name 속성에 들어간 변수명을
 *        받아서 사용을 함. 반환형은 String 타입임.
 *   * getParameterValues(String name) 
 *     => 같은 name에 대하여 여러 개의 값을
 *        얻을 때 사용함. 반환형은 String[] 타입임.
 *                                   
 * 서블릿에서 요청 받은 내용을 처리하여 클라이언트에 보내는 방법
 * 1. HttpServletResponse 클래스를 이용하여 응답을 함.
 * 2. doGet()이나 doPost() 메서드 안에서 처리함.
 * 3. javax.servlet.http.HttpServletResponse 객체를 
 *    이용함.
 * 4. setContentType() 메서드를 이용하여 클라이언트에게 전송할 
 *    데이터의 종류(MIME-TYPE)를 지정함.
 * 5. 클라이언트(웹 브라우저)와 서블릿의 틍신은 자바 I/O의 스트림을 
 *    이용함.
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
 * - 데이터 종류(MIME-TYPE) : 톰캣 컨테이너에서 미리 제공하는 
 *                         여러 가지 전송 데이터 종류를 
 *                         하나 지정하여 웹 브라우저로 
 *                         전송.
 *                         이처럼 톰캣 컨테이네에서 미리 
 *                         설정해 놓은 데이터의 종류들을 
 *                         말함. 웹 브라우저는 기본적으로 
 *                         HTML만 인식하므로 서블릿에서 
 *                         전송하는 대부분의 데이터는
 *                         MIME-TYPE을 "text/html"
 *                         로 설정을 함.
 * - 서블릿이 클라이언트(웹 브라우저)에 응답하는 과정.
 *   * setContentType()을 이용해서 MIME-TYPE을 지정함.
 *   * 데이터를 출력할 PrintWriter 객체를 생성함.
 *   * 출력 데이터를 HTML 형식으로 만듬.
 *   * PrintWriter 객체의 print()나 println() 메서드를 
 *     이용해 데이터를 출력함.
 * 
 * 
 * 웹 브라우저에서 서블릿으로 데이터를 전송하는 전송 방식(2가지)
 * 1. get 방식
 *    - 서블릿에 데이터를 전송할 때는 데이터가 url 뒤에 
 *      name=value 형태로 전송이 됨.
 *    - 여러 개의 데이터를 전송할 때는 '&'로 구분하여 전송이 됨.
 *    - 보안이 취약함.
 *    - 전송할 수 있는 데이터는 최대 255자.
 *    - 기본 전송 방식이고 사용이 쉬움.
 *    - 웹 브라우저에 직접 입력해서 전송할 수도 있음.
 *    - 서블릿에서는 doGet() 메서드에서 전송된 데이터를 처리함.
 *    - get 방식의 요청은 자료를 검색한다거나, 게시글의 상세정보를
 *      본다거나, 특정 상품의 정보를 조회하는 것과 같이 데이터를
 *      조회하는 경우에 적합함.
 *     
 * 2. post 방식
 *    - 서블릿에 데이터를 전송할 때는 TCP/IP 프로토콜 데이터의 
 *      head 영역에 숨겨진 채 전송이 됨.
 *    - 보안, 전송 데이터의 용량이 무제한이나  속도가 get 방식보다 느림.
 *    - 서블릿에서는 doPost() 메서드에서 전송된 데이터를 처리함.
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
        out.println("</table>");
        out.println("</div>");
        out.println("<head></head>");
        out.println("<body></body>");
        out.println("</html>");
    }
}