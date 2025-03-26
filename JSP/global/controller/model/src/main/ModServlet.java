package global.controller.model.src.main;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import JavaReferences.src.main.StudentDAO;
import JavaReferences.src.main.java.global.controller.model.src.main.StudentDTO;

public class ModServlet extends HttpServlet{
    public ModServlet() {
        super();
    }
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name=request.getParameter("name").trim();
        StudentDAO dao=new StudentDAO();
        StudentDTO content=new StudentDTO();
        //save the student details
        request.setAttribute("content", content);
        //forward to the view
        RequestDispatcher rd=request.getRequestDispatcher("view/studentEdit.jsp");
        rd.forward(request, response);
    }
}
