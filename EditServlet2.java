

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EditServlet2
 */
@WebServlet("/EditServlet2")
public class EditServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 protected void doPost(HttpServletRequest request, HttpServletResponse response)     
	          throws ServletException, IOException {    
	        response.setContentType("text/html");   
	        PrintWriter out=response.getWriter();   
	            
	        String sid=request.getParameter("id");      
	       int id=Integer.parseInt(sid);      
	        String name=request.getParameter("name");      
	        String age=request.getParameter("age");    
	        String course=request.getParameter("course");      
	        String city=request.getParameter("city");      
	            
	        Students e1=new Students();   
	        e1.setId(sid);     
	        e1.setName(name);     
	        e1.setAge(age);   
	        e1.setCourse(course);     
	        e1.setCity(city);     
	            
	        int status=StudentsDao.update1(e1);   
	        if(status>0){   
	            response.sendRedirect("ViewServlet");   
	        }else{      
	            out.println("Sorry! unable to update record");      
	        }   
	            
	        out.close();    
	    } 
	

}
