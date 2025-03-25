package JavaReferences.src.main.java.global.controller.model.src.main;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import JavaReferences.src.main.StudentDAO;

public class InsertServlet extends HttpServlet {
    public InsertServlet() {
        super();
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //business logic+encoding
        try {
            request.setCharacterEncoding("UTF-8");
        } catch (Exception e) {
            throw new ServletException("Unsupported encoding", e);
        }
        response.setContentType("text/html; charset=UTF-8");
        //get info from the form
        String name = request.getParameter("name").trim();
        int age = Integer.parseInt(request.getParameter("age"));
        String address = request.getParameter("address").trim();
        String email = request.getParameter("email").trim();
        String phone = request.getParameter("phone").trim();
        //save to db
        StudentDTO dto = new StudentDTO();
        dto.setName(name);
        dto.setAge(age);
        dto.setAddress(address);
        dto.setEmail(email);
        dto.setPhone(phone);
        StudentDAO dao = new StudentDAO();
        int check=dao.insertStudent(dto);
        //set path and forward to student details page
            //RequestDispatcher rd = request.getRequestDispatcher("view/studentDetails.jsp");
            //rd.forward(request, response);
        //direct out without additional jsp
        PrintWriter out = response.getWriter();
        if(check>0) {
            out.println("<script>alert('Success!');</script>");
            out.println("<script>location.href='select';</script>");
        } else {
            out.println("<script>alert('Fail!');</script>");
            out.println("<script>history.back();</script>");
        }
        out.flush();
    }
}
