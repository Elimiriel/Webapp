package JavaReferences.src.main.java.global.controller.model.src.main;

// Description: SelectServlet.java is a servlet that connects to the database and retrieves student details. It then sets the student details to the request object and forwards the request to the student details page.
//

import java.io.IOException;
import java.util.List;
import JavaReferences.src.main.StudentDAO;
import JavaReferences.src.main.java.global.controller.model.src.main.StudentDTO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet
public class SelectServlet extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //business logic
        //get student details: connect to database
        StudentDAO dao = new StudentDAO();
        StudentDTO dto = (StudentDTO) dao.selectStudentList();
        
        // search from db: from dao to dto list
        List<StudentDTO> list = dao.selectStudentList();
        
        //set student details to request object
        request.setAttribute("List", list);
        
        //set path and forward to student details page
        RequestDispatcher rd = request.getRequestDispatcher("view/studentDetails.jsp");
        rd.forward(request, response);
    }

}
