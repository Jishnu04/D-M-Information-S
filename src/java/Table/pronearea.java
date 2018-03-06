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
public class pronearea {
     String URL ="jdbc:mysql://localhost:3306/dmis";
    String USERNAME="root";
    String PASSWORD="123456789";
    Connection connection =null;
    PreparedStatement insertpronearea1=null;
    PreparedStatement insertpronearea2=null;
    PreparedStatement insertpronearea3=null;
    PreparedStatement selectpronearea1=null;
    PreparedStatement selectpronearea2=null;
    PreparedStatement selectpronearea3=null;
    PreparedStatement selectpronearea4=null;
    PreparedStatement selectpronearea5=null;
    PreparedStatement updatepronearea1=null;
    PreparedStatement updatepronearea2=null;
    PreparedStatement updatepronearea3=null;
    PreparedStatement deletepronearea1=null;
    PreparedStatement deletepronearea2=null;
    
    
    ResultSet resultset  =null;
     
    
    public pronearea()
     {
         try
         {
     
             connection=DriverManager.getConnection(URL,USERNAME,PASSWORD);
             insertpronearea1=connection.prepareStatement("INSERT INTO pronearea(user_name,passwrd,location,lattitude,longitude,landform) values(?,?,?,?,?,?)");
             insertpronearea2=connection.prepareStatement("INSERT INTO facilities(category,user_name,staff,engine,capacity,last_update) VALUES('P',?,?,?,?,?)");
             insertpronearea3=connection.prepareStatement("UPDATE dmis.pronearea SET log=? WHERE user_name=?");
             selectpronearea1=connection.prepareStatement("SELECT user_name,passwrd from pronearea "
                                                         +"where user_name=?");
             selectpronearea2=connection.prepareStatement("SELECT * from pronearea  where log=1");
             selectpronearea3=connection.prepareStatement("SELECT * from pronearea h, facilities f "
                                                          +"where f.category='P' AND f.user_name=?");
             selectpronearea4=connection.prepareStatement("SELECT * from facilities where category='P' AND user_name=?");
             selectpronearea5=connection.prepareStatement("SELECT statu,message from facilities where user_name=?");
             
             deletepronearea1=connection.prepareStatement("DELETE pronearea , facilities FROM pronearea INNER JOIN facilities ON pronearea.user_name = facilities.user_name WHERE pronearea.user_name=? and facilities.category='P'");
       
             updatepronearea1=connection.prepareStatement("UPDATE facilities set statu=? where category='P' AND user_name=?");
             updatepronearea2=connection.prepareStatement("UPDATE facilities set staff=?,engine=?,capacity=?,last_update=? "
                                                      +"where category='P' AND user_name=?");
             updatepronearea3=connection.prepareStatement("UPDATE facilities set message=? "
                                                       +" where category='P' AND user_name=?");
         }
         catch(SQLException e)
         {
       
         }
     }
    public int Setpronearea(String un,String pw1,String loc,double f1,double f2,String lf,String staff,String capa,String m,Timestamp last)
    {    int result=0;
try
{
    insertpronearea1.setString(1,un);
    insertpronearea1.setString(2,pw1);
    insertpronearea1.setString(3,loc);
    insertpronearea1.setDouble(4,f1);
    insertpronearea1.setDouble(5,f2);
    insertpronearea1.setString(6,lf);
    
    insertpronearea2.setString(1,un);
    insertpronearea2.setString(2,staff);
    insertpronearea2.setString(3,m);
    insertpronearea2.setString(4,capa);
    insertpronearea2.setTimestamp(5,last);
    
    result=insertpronearea2.executeUpdate();
    insertpronearea1.executeUpdate();
}
    catch(SQLException e)
    {
        
    }
  return result;
    }
    
   
    
    
    public ResultSet getpronearea1(String user)
    {
       try
        {
            selectpronearea1.setString(1,user);
            resultset=selectpronearea1.executeQuery();
            
        }
     catch(SQLException e)
        {
        
        }
            return resultset;
    }
    
    
    
    public ResultSet getpronearea2()
    {
      try
       {
           resultset=selectpronearea2.executeQuery();
          
       }
      catch(SQLException e)
       {
        
       }
        return resultset;
    }
    
    
    
    public ResultSet getpronearea3(String user)
    {
       try
        {
           selectpronearea3.setString(1,user);
           resultset=selectpronearea3.executeQuery();
         
        }
       catch(SQLException e)
        {
        
        }
        return resultset;
    }
    
  public ResultSet getpronearea4(String user)
    {
       try
        {
            selectpronearea4.setString(1,user);
            resultset=selectpronearea4.executeQuery();
            
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
          selectpronearea5.setString(1,user); 
          resultset=selectpronearea4.executeQuery();
      }
  catch(SQLException e)
  {
      
  }
      return resultset;
  }
    
    
   public int deletepronearea(String user)
     {
         int result=0;
      try
         {
           deletepronearea1.setString(1,user);
           result=deletepronearea1.executeUpdate();
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
           insertpronearea3.setInt(1,1);
           insertpronearea3.setString(2,user);
           result=insertpronearea3.executeUpdate();
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
           insertpronearea3.setInt(1,0);
           insertpronearea3.setString(2,user);
           result=insertpronearea3.executeUpdate();
          }
      catch(SQLException e)
          {
             
          }
 
      return result;  
          }
     
     public int updateproneareastatus(String statu,String user)
      {
          int result=0;
       try
           {
             updatepronearea1.setString(1,statu);
             updatepronearea1.setString(2,user);
             result=updatepronearea1.executeUpdate();
           }
               
       catch(SQLException e)
           {
             
           }
 
       return result;  
     }
     
     
     public int updatefact(String staff,String engine,String capacity,Timestamp last,String user)
      {
             int result=0;
         try
            {
              updatepronearea2.setString(1,staff);
              updatepronearea2.setString(2,engine);
              updatepronearea2.setString(3,capacity);
              updatepronearea2.setTimestamp(4,last);
              updatepronearea2.setString(5,user);
              result=updatepronearea2.executeUpdate();
            }
               
         catch(SQLException e)
            {
             
            }
 
          return result;  
      }
     
     
     public int updateproneareamess(String message,String user)
      {
             int result=0;
       try
           {
             updatepronearea1.setString(1,message);
             updatepronearea1.setString(2,user);
             result=updatepronearea1.executeUpdate();
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
         resultset=selectpronearea2.executeQuery();
        }
        catch(SQLException e)
        {
            
        }
        return resultset;
    }
     
    
}
