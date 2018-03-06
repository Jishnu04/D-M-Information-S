/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Table;
import java.sql.*;
/**
 *
 * @author JISHNU T U
 */
public class volunteer {
    String URL ="jdbc:mysql://localhost:3306/dmis";
    String USERNAME="root";
    String PASSWORD="123456789";
    Connection connection =null;
    PreparedStatement insertvolunteer1=null;
    PreparedStatement insertvolunteer2=null;
    PreparedStatement selectvolunteer1=null;
    PreparedStatement selectvolunteer2=null;
    PreparedStatement updatevolunteer3=null;
    PreparedStatement insertvolunteer4=null;
    PreparedStatement selectvolunteer5=null;
    PreparedStatement updatevolunteer1=null;
    PreparedStatement updatevolunteer2=null;
    PreparedStatement updatevolunteer4=null;   
    PreparedStatement deletevolunteer1=null;
    PreparedStatement deletevolunteer2=null;
    
    
    ResultSet resultset  =null;
     
    
    public volunteer()
     {
         try
         {
     
             connection=DriverManager.getConnection(URL,USERNAME,PASSWORD);
             insertvolunteer1=connection.prepareStatement("INSERT INTO dmis.volunteer (user_name,passwrd,mail_id,contact_no,lattitude,longitude,location,agency,category) VALUES(?,?,?,?,?,?,?,?,?)");
             insertvolunteer2=connection.prepareStatement("INSERT INTO facilities(category,user_name,staff,last_update)"+"VALUES('V',?,?,?)");
             selectvolunteer1=connection.prepareStatement("SELECT user_name,passwrd from volunteer where user_name=?");
             selectvolunteer2=connection.prepareStatement("SELECT * from facilities where category='V' and user_name=?");
            updatevolunteer3=connection.prepareStatement("update facilities set staff=?,engine=?,capacity=?,last_update=? where category='V' and user_name=?");
            insertvolunteer4=connection.prepareStatement("update volunteer set log=? where user_name =?");
            selectvolunteer5=connection.prepareStatement("SELECT user_name from volunteer where log =1" );
            deletevolunteer1=connection.prepareStatement("DELETE volunteer, facilities FROM volunteer INNER JOIN facilities ON volunteer.user_name = facilities.user_name WHERE volunteer.user_name=? and facilities.category='V'");
            updatevolunteer4=connection.prepareStatement("update facilities set statu =? where category='V' and user_name=?");
            deletevolunteer2=connection.prepareStatement("DELETE from facilities where category='V' and user_name=?");
         }
         catch(SQLException e)
         {
       
         }
     }
    public int Setvolunteer(String user_name,String passwrd,String mail_id,String cno,double lattitude,double longitude,String location,String agency,String category,String staff,Timestamp last)
    {
    int result=0;
try
{
    insertvolunteer1.setString(1,user_name);
    insertvolunteer1.setString(2,passwrd);
    insertvolunteer1.setString(3,mail_id);
    insertvolunteer1.setString(4, cno);
    insertvolunteer1.setDouble(5,lattitude);
    insertvolunteer1.setDouble(6,longitude);
    insertvolunteer1.setString(7,location);
    insertvolunteer1.setString(8,agency);
    insertvolunteer1.setString(9,category);
    insertvolunteer2.setString(1,user_name);
    insertvolunteer2.setString(2,staff);
    insertvolunteer2.setTimestamp(3,last);
    insertvolunteer2.executeUpdate();
    result=insertvolunteer1.executeUpdate();
}
    catch(SQLException e)
    {
        
    }
  return result;
    }
    
    public ResultSet getvoluteer(String user)
    {
        try
        {
            selectvolunteer1.setString(1,user);
            resultset=selectvolunteer1.executeQuery();
            
            
        }
    catch(SQLException e)
    {
        
    }
        return resultset;
    }
    public ResultSet returnsm(String user)
    {
        try
        {
            
           selectvolunteer2.setString(1,user);
           resultset=selectvolunteer2.executeQuery();
          
            
        }
    catch(SQLException e)
    {
        
    }
        return resultset;
    }
    public ResultSet returnlog()
    {
        try
        {
            resultset=selectvolunteer5.executeQuery();     
        }
    catch(SQLException e)
    {
        
    }
        return resultset;
    }
 
 public int delvolunteer(String user)
 {
     int result=0;
    try
    {
        deletevolunteer1.setString(1,user);
        result=deletevolunteer1.executeUpdate();
    }
 catch(SQLException e)
         {
             
         }
    return result;
 }
  public void login(String x)
    {
        try
        {
         insertvolunteer4.setInt(1,1);
         insertvolunteer4.setString(2,x); 
         insertvolunteer4.executeUpdate(); 
        }
        catch(SQLException e)
        {
            
        }
        
    }
   public void logout(String x)
    {
        try
        {
         insertvolunteer4.setInt(1,0);
         insertvolunteer4.setString(2,x);
         insertvolunteer4.executeUpdate();
        }
        catch(SQLException e)
        {
            
        }
        
    }
   public int updatefact(String s,String m,String c,Timestamp t,String u )
    {
        int result=0;
        try
        {
         updatevolunteer3.setString(1,s);
         updatevolunteer3.setString(2,m);
         updatevolunteer3.setString(3,c);
         updatevolunteer3.setTimestamp(4, t);
         updatevolunteer3.setString(5,u);
         result=updatevolunteer3.executeUpdate();
        }
        catch(SQLException e)
        {
            
        }
        return result;
    }
    public int updatestat(String s,String u ) 
    {
        int result=0;
        try
        {
         updatevolunteer4.setString(1,s);
         updatevolunteer4.setString(2,u);
         result=updatevolunteer4.executeUpdate();
        }
        catch(SQLException e)
        {
            
        }
        return result;
    }
 
}
