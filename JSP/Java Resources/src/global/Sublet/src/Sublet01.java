package global.Sublet.src;
import java.io.websublet;
import java.io.IOException;
import java.io.PrintWriter;

@websublet(/member)

public class Sublet01 extends websublet {
    public MemberServlet() {
        super();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("id");
        String password = request.getParameter("pw");
        String phone=request.getParameter("phone");
        String adress=request.getParameter("addr");

        //return to response obj, with encoding
        response.setContentType("text/html;charset=UTF-8");
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