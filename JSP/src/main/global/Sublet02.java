package src.main.global;
import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.Key;
import java.util.List;
import java.util.Map;
public class Sublet02 extends HttpServlet {

    private boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    public Sublet02() {
        super();
    }
            
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        Map<String, String[]> student = request.getParameterMap();
        PrintWriter out = response.getWriter();
        for (Map.Entry<String, String[]> entry : student.entrySet()) {
            String key = entry.getKey();
            String[] value = entry.getValue();
            boolean allNumeric = true;
            for (int i = 1; i < value.length; i++) {
                if (!isNumeric(value[i])) {
                    allNumeric = false;
                    break;
                }
            }
            if(key.equals("sname") && !isNumeric(value[0]) && allNumeric) {
                student.put(key, value);
            } else {
                out.println("<html><body>");
                out.println("<h1>Fail</h1>");
                out.println("<input type='button' value='back' onclick='history.back()'>");
                out.println("</body></html>");
                out.close();
                return;
            }
        }
        out.println("<html><body>");
        out.println("<h1>Success</h1>");
        out.println("print student info");
        out.println("<table border='1'>");
        out.println("<tr><td>name</td><td>student.name</td></tr>");
        for (Map.Entry<String, String[]> entry : student.entrySet()) {
            String key = entry.getKey();
            String[] value = entry.getValue();
            out.println("<tr><td>" + key + "</td><td>" + value + "</td></tr>");
        }
        out.println("</table>");
        out.println("</body></html>");
        out.close();
    }
}
