

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ViewServlet
 */
@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 protected void doGet(HttpServletRequest request, HttpServletResponse response)   
             throws ServletException, IOException {  
      response.setContentType("text/html");  
      PrintWriter out=response.getWriter();  
      out.println("<a href='student.html'>Add New Student</a>");  
      out.println("<h1>Student List</h1>");  
        
      List<Students> list=StudentsDao.getAllStudents();  
        
      out.print("<tr><th>Id</th><th>Name</th><th>Age</th><th>Course</th><th>City</th><th>Edit</th><th>Delete</th></tr>");  
       for(Students e1:list){      
       out.print("<tr><td>"+e1.getId()+"</td><td>"+e1.getName()+"</td><td>"+e1.getAge()+"</td><td>"+e1.getCourse()+"</td><td>"+e1.getCity()+"</td><td><a href='EditServlet?id="+e1.getId()+"'>edit</a></td><td><a href='DeleteServlet?id="+e1.getId()+"'>delete</a></td></tr>"); 
      out.print("</table>");  
        
      out.close();  
  }

	 }
}
