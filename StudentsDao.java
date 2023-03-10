import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.lang.NullPointerException;

public class StudentsDao {
		public static Connection getconnection() {
		Connection con1=null;
	
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/students","root","root");
		}
		catch(Exception e1) {
			System.out.println(e1);
		}
		return con1;
		
	
}
	public static int save1(Students e1) {
		int status=0;
		try {
			Connection con1=StudentsDao.getconnection();
			PreparedStatement ps1=con1.prepareStatement("insert into stu(id,name,age,course,city) values (?,?,?,?,?)");
		
			ps1.setString(1,e1.getName());
			ps1.setString(2,e1.getAge());
			ps1.setString(3,e1.getCourse());
			ps1.setString(4,e1.getCity());
			status=ps1.executeUpdate();
			con1.close();
		}
		catch(Exception e11) {
			e11.printStackTrace();}
			return status;
		}
		public static int update1(Students e1){      
	        int status=0;   
	        try{    
	            Connection con1=StudentsDao.getconnection();     
	            PreparedStatement ps1=con1.prepareStatement("update stu set id1=?, name1=?,age1=?,course1=?,city1=? where id1=?");      
	            ps1.setString(1,e1.getName());     
	            ps1.setString(2,e1.getAge());      
	            ps1.setString(3,e1.getCourse());   
	            ps1.setString(4,e1.getCity());     
	                
	            status=ps1.executeUpdate();     
	                
	            con1.close();   
	        }   
	        catch(Exception e11)    
	        {   
	            e11.printStackTrace();  
	        }   
	            
	        return status;      
	    }   
      
	  
	    public static int delete1(int id1){     
	        int status=0;   
	        try{    
	            Connection con1=StudentsDao.getconnection();     
	            PreparedStatement ps1=con1.prepareStatement("delete from student where id=?");      
	            ps1.setInt(1,id1);      
	            status=ps1.executeUpdate();     
	                
	            con1.close();   
	        }catch(Exception e1){e1.printStackTrace();}     
	            
	        return status;      
	    }   
	    public static Students getStudentsById(int id1){      
	    	Students e1=new Students();   
	            
	        try{    
	            Connection con1=StudentsDao.getconnection();     
	            PreparedStatement ps1=con1.prepareStatement("select * from stu where id1=?");    
	            ps1.setInt(1,id1);      
	            ResultSet rs1=ps1.executeQuery();   
	            if(rs1.next()){     
	                e1.setId(rs1.getString(1));    
	                e1.setName(rs1.getString(2));      
	                e1.setAge(rs1.getString(3));   
	                e1.setCourse(rs1.getString(4));    
	                e1.setCity(rs1.getString(5));      
	            }   
	            con1.close();   
	        }catch(Exception ex1){ex1.printStackTrace();}   
	            
	        return e1;      
	    }   
	    public static List<Students> getAllStudents(){    
	        List<Students> list=new ArrayList<Students>();    
	            
	        try{    
	            Connection con1=StudentsDao.getconnection();     
	            PreparedStatement ps1=con1.prepareStatement("select * from stu");   
	            ResultSet rs1=ps1.executeQuery();   
	            while(rs1.next()){      
	                Students e1=new Students();   
	                e1.setId(rs1.getString(1));    
	                e1.setName(rs1.getString(2));      
	                e1.setAge(rs1.getString(3));   
	                e1.setCourse(rs1.getString(4));    
	                e1.setCity(rs1.getString(5));      
	                list.add(e1);   
	            }   
	            con1.close();   
	        }catch(Exception e1){e1.printStackTrace();}     
	            
	        return list;    
	    }   
	} 
