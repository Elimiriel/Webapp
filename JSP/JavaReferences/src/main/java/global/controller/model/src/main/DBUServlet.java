package JavaReferences.src.main.java.global.controller.model.src.main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import JavaReferences.src.main.StudentDAO;

public class DBUServlet {
    public DBUServlet() {
        super();
    }
    protected void addservice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.setCharacterEncoding("UTF-8");
    response.setCharacterEncoding("UTF-8");
    response.setContentType("text/html; charset=UTF-8");
    String nsname=request.getParameter("name").trim();
    Integer nsage = Integer.parseInt(request.getParameter("age").trim());
    String nsaddress=request.getParameter("address").trim();
    String nsemail=request.getParameter("email").trim();
    String nsphone=request.getParameter("phone").trim();
    //save to db
    StudentDTO dto = new StudentDTO();
    dto.setName(nsname);
    dto.setAge(nsage);
    dto.setAddress(nsaddress);
    dto.setEmail(nsemail);
    dto.setPhone(nsphone);
    //dto to DB
    StudentDAO dao = new StudentDAO();
    int result=dao.insertStudent(dto);
    PrintWriter out=response.getWriter();
    if(result>0) {
        out.println(nsname+"님의 정보가 성공적으로 저장되었습니다.");
        response.sendRedirect("selectServlet");//servlet maps to view/studentDetails.jsp
    } else {
        out.println(nsname+"님의 정보가 저장되지 않았습니다.");
        response.sendRedirect("history.back()");
    }
    }
    protected void delservice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        //in actual, must confirm pwd: for security. identification sublet is needed.
        String nsname=request.getParameter("name").trim();
        //delete from db
        StudentDTO dto = new StudentDTO();
        dto.setName(nsname);
        //dto to DB
        StudentDAO dao = new StudentDAO();
        int result=dao.delStudent(dto, nsname);
        PrintWriter out=response.getWriter();
        if(result>0) {
            out.println(nsname+"님의 정보가 성공적으로 삭제되었습니다.");
            response.sendRedirect("selectServlet");//servlet maps to view/studentDetails.jsp
        } else {
            out.println(nsname+"님의 정보가 삭제되지 않았습니다.");
            response.sendRedirect("history.back()");
        }
    }

}
