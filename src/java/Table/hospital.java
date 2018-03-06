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
public class hospital {
    String URL ="jdbc:mysql://localhost:3306/dmis";
    String USERNAME="root";
    String PASSWORD="123456789";
    Connection connection =null;
    PreparedStatement inserthospital1=null;
    PreparedStatement inserthospital2=null;
    PreparedStatement inserthospital3=null;
    PreparedStatement selecthospital1=null;
    PreparedStatement selecthospital2=null;
    PreparedStatement selecthospital3=null;
    PreparedStatement selecthospital4=null;
    PreparedStatement selecthospital5=null;
    PreparedStatement updatehospital1=null;
    PreparedStatement updatehospital2=null;
    PreparedStatement updatehospital3=null;
    PreparedStatement deletehospital1=null;
    PreparedStatement deletehospital2=null;
    
    
    ResultSet resultset  =null;
     
    
    public hospital()
     {
         try
         {
     
             connection=DriverManager.getConnection(URL,USERNAME,PASSWORD);
             inserthospital1=connection.prepareStatement("INSERT INTO hospital(user_name,passwrd,mail_id,contact_no,lattitude,longitude,category,name,address) values(?,?,?,?,?,?,?,?,?)");
             inserthospital2=connection.prepareStatement("INSERT INTO facilities(category,user_name,staff,engine,capacity,last_update)VALUES('H',?,?,?,?,?)");
             inserthospital3=connection.prepareStatement("UPDATE hospital set log=? where user_name =?");
             selecthospital1=connection.prepareStatement("SELECT user_name,passwrd from hospital "
                                                         +"where user_name=?");
             selecthospital2=connection.prepareStatement("SELECT * from hospital  where log=1");
             selecthospital3=connection.prepareStatement("SELECT * from hospital h, facilities f "
                                                          +"where f.category='H' AND f.user_name=?");
             selecthospital4=connection.prepareStatement("SELECT * from facilities where category='H' AND user_name=?");
             selecthospital5=connection.prepareStatement("SELECT * from hospital where log=1");
             deletehospital1=connection.prepareStatement("DELETE hospital, facilities FROM hospital INNER JOIN facilities ON hospital.user_name = facilities.user_name WHERE hospital.user_name=? and facilities.category='H'");
             deletehospital2=connection.prepareStatement("DELETE from hospital h,facilities f "
                                                      +" where f.category='H' AND f.user_name=?");
             updatehospital1=connection.prepareStatement("UPDATE facilities set statu=? where category='H' AND user_name=?");
             updatehospital2=connection.prepareStatement("update facilities set staff=? , engine=? , capacity=?,last_update=? where user_name=? and category='H'");
        
         }
         catch(SQLException e)
         {
       
         }
     }
    public int Sethospital(String user,String passwrd,String mail_id,String cno,double lattitude,double longitude,String category,String h_name,String address,String staff_count,String ambulances,String capacity,Timestamp last)
    {
    int result=0;
try
{
    inserthospital1.setString(1,user);
    inserthospital1.setString(2,passwrd);
    inserthospital1.setString(3,mail_id);
    inserthospital1.setString(4, cno);
    inserthospital1.setDouble(5,lattitude);
    inserthospital1.setDouble(6,longitude);
    inserthospital1.setString(7,category);
    inserthospital1.setString(8,h_name);
    inserthospital1.setString(9,address);
    inserthospital2.setString(1,user);
    inserthospital2.setString(2,staff_count);
    inserthospital2.setString(3,ambulances);
    inserthospital2.setString(4,capacity);
    inserthospital2.setTimestamp(5,last);
    
    inserthospital2.executeUpdate();
    result=inserthospital1.executeUpdate();
}
    catch(SQLException e)
    {
        
    }
  return result;
    }
    
   
    
    
    public ResultSet gethospital1(String user)
    {
       try
        {
            selecthospital1.setString(1,user);
            resultset=selecthospital1.executeQuery();
            
        }
     catch(SQLException e)
        {
        
        }
            return resultset;
    }
    
    
    
    public ResultSet gethospital2()
    {
      try
       {
           resultset=selecthospital2.executeQuery();
          
       }
      catch(SQLException e)
       {
        
       }
        return resultset;
    }
    
    
    
    public ResultSet gethospital3(String user)
    {
       try
        {
           selecthospital3.setString(1,user);
           resultset=selecthospital3.executeQuery();
         
        }
       catch(SQLException e)
        {
        
        }
        return resultset;
    }
    
  public ResultSet gethospital4(String user)
    {
       try
        {
            selecthospital4.setString(1,user);
            resultset=selecthospital4.executeQuery();
            
        }
     catch(SQLException e)
        {
        
        }
            return resultset;
    }
    
    
    public int deletehospital(String user)
     {
         int result=0;
      try
         {
           deletehospital1.setString(1,user);
           result=deletehospital1.executeUpdate();
   
         }
      catch(SQLException e)
         {
             
         }
     return result;
     }
 
 
     public int login(String user)
      {
           int result=0;
       try
          {
           inserthospital3.setInt(1,1);
           inserthospital3.setString(2,user);
           result=inserthospital3.executeUpdate();
          }
      catch(SQLException e)
          {
             
          }
 
      return result;  
          }
     
     public int logout(String user)
      {
           int result=0;
       try
          {
           inserthospital3.setInt(1,0);
           inserthospital3.setString(2,user);
           result=inserthospital3.executeUpdate();
          }
      catch(SQLException e)
          {
             
          }
 
      return result;  
          }
     
     public int updatestatus(String statu,String user)
      {
          int result=0;
       try
           {
             updatehospital1.setString(1,statu);
             updatehospital1.setString(2,user);
             result=updatehospital1.executeUpdate();
           }
               
       catch(SQLException e)
           {
             
           }
 
       return result;  
     }
     
     
     public int updatefact(String staff_count,String ambulances,String capacity,Timestamp last,String user)
      {
             int result=0;
         try
            {
              updatehospital2.setString(1,staff_count);
              updatehospital2.setString(2,ambulances);
              updatehospital2.setString(3,capacity);
              updatehospital2.setTimestamp(4,last);
              updatehospital2.setString(5,user);
              result=updatehospital2.executeUpdate();
            }
               
         catch(SQLException e)
            {
             
            }
 
          return result;  
      }
     
     
     public int updatehospitalmess(String message,String user)
      {
             int result=0;
       try
           {
             updatehospital1.setString(1,message);
             updatehospital1.setString(2,user);
             result=updatehospital1.executeUpdate();
           }
               
        catch(SQLException e)
           {
             
           }
 
          return result;  
      }
     
     public ResultSet returnlog()
    {
        try
        {
         resultset=selecthospital5.executeQuery();
        }
        catch(SQLException e)
        {
            
        }
        return resultset;
    }
}
