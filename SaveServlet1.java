

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SaveServlet
 */
@WebServlet("/SaveServlet1")
public class SaveServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response)     
	         throws ServletException, IOException {     
	        response.setContentType("text/html");   
	        PrintWriter out=response.getWriter();   
	        String id=request.getParameter("id");      
	        String name=request.getParameter("name");      
	        String age=request.getParameter("age");    
	        String course=request.getParameter("course");      
	        String city=request.getParameter("city");
	        
	        Students e1=new Students();   
	        e1.setId(id); 
	        e1.setName(name);     
	        e1.setAge(age);   
	        e1.setCourse(course);     
	        e1.setCity(city);
	        int status=StudentsDao.save1(e1);     
	        if(status>0){   
	            out.print("<p>Record saved successfully!</p>");     
	            request.getRequestDispatcher("index.html").include(request, response);
	        }
	        else {
	        	out.println("Sorry! unable to save record");    
	        }   
	            
	        out.close();    
	    }   
	}

