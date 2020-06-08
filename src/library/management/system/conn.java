
package library.management.system;
import java.sql.*;// importing standard JDBC package that allows to select,insert,update and delete data in SQL tables

public class conn 
{
  Connection c;//Connection Interface
  Statement s;//Statement Interface
  public conn()//constructor for conn class
  {
      try
      {
          Class.forName("com.mysql.cj.jdbc.Driver"); //Registering the driver class
          c= DriverManager.getConnection("jdbc:mysql://localhost:3308/project7","root",""); //creating connection
          s=c.createStatement();//Creating statement that allows us to execute queries
       //   c.close();//to close the connection 
      }
      catch(Exception e)
      {
          System.out.println(e);
      }
  }
}
