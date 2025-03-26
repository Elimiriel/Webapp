package JavaReferences.src.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import JavaReferences.src.main.StudentDAO;
import JavaReferences.src.main.java.global.controller.model.src.main.StudentDTO;

public class StudentDAO {
    //methods to save, update, delete, and retrieve student details
    Connection con = null;//DB connection
    PreparedStatement ps = null;//SQL statement
    ResultSet rs = null;//SQL result set
    String sql = null;//SQL query command saved as string

    public void saveStudent() {
        //init generator
        String driver="oracle.jdbc.driver.OracleDriver";
        String url="jdbc:oracle:thin:@localhost:1521:xe";
        String user="web";
        String password="1234";
        
        try {
            Class.forName(driver);//load the driver to ram
            con = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public List<StudentDTO> selectStudentList() {
        List<StudentDTO> list = new ArrayList<StudentDTO>();
        //command
        sql = "select * from student order by name desc";
        try {
            ps = con.prepareStatement(sql);//transfer object
            ps.executeQuery();//execute the query
            rs = ps.executeQuery();//result set: whole table including labels
            //loop through the result set
            while (rs.next()/* move to the next row to pass the 1st row, label */) {
                StudentDTO dto = new StudentDTO();
                dto.setName(rs.getString("name"));
                dto.setAge(rs.getInt("age"));
                dto.setAddress(rs.getString("address"));
                dto.setEmail(rs.getString("email"));
                dto.setPhone(rs.getString("phone"));
                //add to the list
                list.add(dto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            rs.close();
            ps.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    public int insertStudent(StudentDTO dto) {
        int result = 0;//positive: success, negative: fail
        //command
        sql = "insert into student values(?, ?, ?, ?, ?)";
        try {
            ps = con.prepareStatement(sql);//sql command transfer object
            ps.setString(1, dto.getName());
            ps.setInt(2, dto.getAge());
            ps.setString(3, dto.getAddress());
            ps.setString(4, dto.getEmail());
            ps.setString(5, dto.getPhone());
            //ps.setDate(6, dto.getRegdate());
            result = ps.executeUpdate();//execute the query| executeUpdate: insert, update, delete | return int
                                        //executeQuery: select | return ResultSet
        } catch (Exception e) {
            e.printStackTrace();
        }
        //disconnect
        try {
            ps.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    public StudentDTO findstudent(String info) {
        StudentDTO dto = null;
        //command
        sql = "select * from student where ? like ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, "*");
            ps.setString(2, "%"+info+"%");
            rs = ps.executeQuery();
            if (rs.next()) {
                dto = new StudentDTO();
                dto.setName(rs.getString("name"));
                dto.setAge(rs.getInt("age"));
                dto.setAddress(rs.getString("address"));
                dto.setEmail(rs.getString("email"));
                dto.setPhone(rs.getString("phone"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //disconnect
        try {
            ps.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dto;
    }
    public StudentDTO delStudent(StudentDTO dto, String info) {
        //command
        sql = "delete from student where ? like ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, "dto.rowid");
            ps.setString(2, "%"+info+"%");
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //disconnect
        try {
            ps.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dto;
    }
}
