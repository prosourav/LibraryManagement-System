package libraryManageMent;
import java.sql.*;
public class Conn {
	Statement s;
	Connection c;
 Conn(){
	  try{  
          Class.forName("com.mysql.cj.jdbc.Driver");  
          c =DriverManager.getConnection("jdbc:mysql://localhost:3306/library?serverTimezone=UTC","root","");   
          s =c.createStatement(); 
          
          }catch(Exception e){ 
          System.out.println(e);
      } 
 }
}
