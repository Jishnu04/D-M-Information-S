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
public class socialmedia {
    String URL ="jdbc:mysql://localhost:3306/dmis";
    String USERNAME="root";
    String PASSWORD="123456789";
    Connection connection =null;
    PreparedStatement insertsocialmedia1=null;
    PreparedStatement insertsocialmedia2=null;
    PreparedStatement insertsocialmedia3=null;
    PreparedStatement selectsocialmedia1=null;
    PreparedStatement selectsocialmedia2=null;
    PreparedStatement selectsocialmedia3=null;
    PreparedStatement selectsocialmedia4=null;
    PreparedStatement selectsocialmedia5=null;
    PreparedStatement updatesocialmedia1=null;
    PreparedStatement updatesocialmedia2=null;
    PreparedStatement updatesocialmedia3=null;
    PreparedStatement deletesocialmedia1=null;
    PreparedStatement deletesocialmedia2=null;
    
    
    ResultSet resultset  =null;
     
    
    public socialmedia()
     {
         try
         {
     
             connection=DriverManager.getConnection(URL,USERNAME,PASSWORD);
             insertsocialmedia1=connection.prepareStatement("INSERT INTO socialmedia(user_name,passwrd,c_name,contact_no,mail_id,address,latitude,longitude) values(?,?,?,?,?,?,?,?)");
             insertsocialmedia2=connection.prepareStatement("INSERT INTO facilities(category,user_name,staff,engine,capacity,last_update) VALUES('S',?,?,?,?,?)");
             insertsocialmedia3=connection.prepareStatement("UPDATE dmis.socialmedia SET log=? WHERE user_name=?");
             selectsocialmedia1=connection.prepareStatement("SELECT user_name,passwrd from socialmedia "
                                                         +"where user_name=?");
             selectsocialmedia2=connection.prepareStatement("SELECT * from socialmedia  where log=1");
             selectsocialmedia3=connection.prepareStatement("SELECT * from socialmedia h, facilities f "
                                                          +"where f.category='S' AND f.user_name=?");
             selectsocialmedia4=connection.prepareStatement("SELECT * from facilities where category='S' AND user_name=?");
             selectsocialmedia5=connection.prepareStatement("SELECT statu,message from facilities where user_name=?");
             
             deletesocialmedia1=connection.prepareStatement("DELETE socialmedia , facilities FROM socialmedia INNER JOIN facilities ON socialmedia.user_name = facilities.user_name WHERE socialmedia.user_name=? and facilities.category='S'");
       
             updatesocialmedia1=connection.prepareStatement("UPDATE facilities set statu=? where category='S' AND user_name=?");
             updatesocialmedia2=connection.prepareStatement("UPDATE facilities set staff=?,engine=?,capacity=?,last_update=? "
                                                      +"where category='S' AND user_name=?");
             updatesocialmedia3=connection.prepareStatement("UPDATE facilities set message=? "
                                                       +" where category='S' AND user_name=?");
         }
         catch(SQLException e)
         {
       
         }
     }
    public int Setsocialmedia(String un,String pw1,String nm,String cno,String mid,String add,double f1,double f2,String staff,String eng,String capa,Timestamp last)
    {    int result=0;
try
{
    insertsocialmedia1.setString(1,un);
    insertsocialmedia1.setString(2,pw1);
    insertsocialmedia1.setString(3,nm);
    insertsocialmedia1.setString(4,cno);
    insertsocialmedia1.setString(5,mid);
    insertsocialmedia1.setString(6,add);
    insertsocialmedia1.setDouble(7,f1);
    insertsocialmedia1.setDouble(8,f2);
    
    
    insertsocialmedia2.setString(1,un);
    insertsocialmedia2.setString(2,staff);
    insertsocialmedia2.setString(3,eng);
    insertsocialmedia2.setString(4,capa);
    insertsocialmedia2.setTimestamp(5,last);
    
    result=insertsocialmedia2.executeUpdate();
    insertsocialmedia1.executeUpdate();
}
    catch(SQLException e)
    {
        
    }
  return result;
    }
    
     public ResultSet getsocialmedia1(String user)
    {
       try
        {
            selectsocialmedia1.setString(1,user);
            resultset=selectsocialmedia1.executeQuery();
            
        }
     catch(SQLException e)
        {
        
        }
            return resultset;
    }
    
    
    
    public ResultSet getsocialmedia2()
    {
      try
       {
           resultset=selectsocialmedia2.executeQuery();
          
       }
      catch(SQLException e)
       {
        
       }
        return resultset;
    }
    
    
    
    public ResultSet getsocialmedia3(String user)
    {
       try
        {
           selectsocialmedia3.setString(1,user);
           resultset=selectsocialmedia3.executeQuery();
         
        }
       catch(SQLException e)
        {
        
        }
        return resultset;
    }
    
  public ResultSet getsocialmedia4(String user)
    {
       try
        {
            selectsocialmedia4.setString(1,user);
            resultset=selectsocialmedia4.executeQuery();
            
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
          selectsocialmedia5.setString(1,user); 
          resultset=selectsocialmedia4.executeQuery();
      }
  catch(SQLException e)
  {
      
  }
      return resultset;
  }
    
    
   public int deletesocialmedia(String user)
     {
         int result=0;
      try
         {
           deletesocialmedia1.setString(1,user);
           result=deletesocialmedia1.executeUpdate();
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
           insertsocialmedia3.setInt(1,1);
           insertsocialmedia3.setString(2,user);
           result=insertsocialmedia3.executeUpdate();
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
           insertsocialmedia3.setInt(1,0);
           insertsocialmedia3.setString(2,user);
           result=insertsocialmedia3.executeUpdate();
          }
      catch(SQLException e)
          {
             
          }
 
      return result;  
          }
     
     public int updatesocialmediastatus(String statu,String user)
      {
          int result=0;
       try
           {
             updatesocialmedia1.setString(1,statu);
             updatesocialmedia1.setString(2,user);
             result=updatesocialmedia1.executeUpdate();
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
              updatesocialmedia2.setString(1,staff);
              updatesocialmedia2.setString(2,engine);
              updatesocialmedia2.setString(3,capacity);
              updatesocialmedia2.setTimestamp(4,last);
              updatesocialmedia2.setString(5,user);
              result=updatesocialmedia2.executeUpdate();
            }
               
         catch(SQLException e)
            {
             
            }
 
          return result;  
      }
     
     
     public int updatesocialmediamess(String message,String user)
      {
             int result=0;
       try
           {
             updatesocialmedia1.setString(1,message);
             updatesocialmedia1.setString(2,user);
             result=updatesocialmedia1.executeUpdate();
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
         resultset=selectsocialmedia2.executeQuery();
        }
        catch(SQLException e)
        {
            
        }
        return resultset;
    }
     
    
}
