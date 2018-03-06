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
public class accommodation {
     String URL ="jdbc:mysql://localhost:3306/dmis";
    String USERNAME="root";
    String PASSWORD="123456789";
    Connection connection =null;
    PreparedStatement insertaccommodation1=null;
    PreparedStatement insertaccommodation2=null;
    PreparedStatement insertaccommodation3=null;
    PreparedStatement selectaccommodation1=null;
    PreparedStatement selectaccommodation2=null;
    PreparedStatement selectaccommodation3=null;
    PreparedStatement selectaccommodation4=null;
    PreparedStatement selectaccommodation5=null;
    PreparedStatement updateaccommodation1=null;
    PreparedStatement updateaccommodation2=null;
    PreparedStatement updateaccommodation3=null;
    PreparedStatement deleteaccommodation=null;
  
    
    
    ResultSet resultset  =null;
     
    
    public accommodation ()
     {
         try
         {
     
             connection=DriverManager.getConnection(URL,USERNAME,PASSWORD);
             insertaccommodation1=connection.prepareStatement("INSERT INTO accommodation (user_name,passwrd,building,location,lattitude,longitude,i_name,contact_no,mail_id) values(?,?,?,?,?,?,?,?,?)");
             insertaccommodation2=connection.prepareStatement("INSERT INTO facilities(category,user_name,staff,engine,capacity,last_update) VALUES('A',?,?,?,?,?)");
             insertaccommodation3=connection.prepareStatement("UPDATE accommodation set log=? where user_name=?");
             selectaccommodation1=connection.prepareStatement("SELECT user_name,passwrd from accommodation "
                                                         +"where user_name=?");
             selectaccommodation2=connection.prepareStatement("SELECT * from accommodation  where log=1");
             selectaccommodation3=connection.prepareStatement("SELECT * from accommodation h, facilities f "
                                                          +"where f.category='A' AND f.user_name=?");
             selectaccommodation4=connection.prepareStatement("SELECT * from facilities where category='A' AND user_name=?");
             selectaccommodation5=connection.prepareStatement("SELECT statu,message from facilities where user_name=?");
             
             deleteaccommodation=connection.prepareStatement("DELETE accommodation,facilities from accommodation inner join facilities on accommodation.user_name=facilities.user_name where accommodation.user_name=? AND facilities.category='A'");      
             updateaccommodation1=connection.prepareStatement("UPDATE facilities set statu=? where category='A' AND user_name=?");
             updateaccommodation2=connection.prepareStatement("UPDATE facilities set staff=?,engine=?,capacity=?,last_update=? "
                                                      +"where category='A' AND user_name=?");
             updateaccommodation3=connection.prepareStatement("UPDATE facilities set message=? "
                                                       +" where category='A' AND user_name=?");
         }
         catch(SQLException e)
         {
       
         }
     }
    public int Setaccommodation(String un,String pw1,String bui,String loc,double f1,double f2,String nm,String cno,String mid,String staff,String eng,String capa,Timestamp last)
    {    int result=0;
try
{
    insertaccommodation1.setString(1,un);
    insertaccommodation1.setString(2,pw1);
    insertaccommodation1.setString(3,bui);
    insertaccommodation1.setString(4,loc);
    insertaccommodation1.setDouble(5,f1);
    insertaccommodation1.setDouble(6,f2);
    insertaccommodation1.setString(7,nm);
    insertaccommodation1.setString(8,cno);
    insertaccommodation1.setString(9,mid);
    
    insertaccommodation2.setString(1,un);
    insertaccommodation2.setString(2,staff);
    insertaccommodation2.setString(3,eng);
    insertaccommodation2.setString(4,capa);
    insertaccommodation2.setTimestamp(5,last);
    
    insertaccommodation2.executeUpdate();
    
    result=insertaccommodation1.executeUpdate();
}
    catch(SQLException e)
    {
        
    }
  return result;
    }
    
   
    
    
    public ResultSet getaccommodation1(String user)
    {
       try
        {
            selectaccommodation1.setString(1,user);
            resultset=selectaccommodation1.executeQuery();
            
        }
     catch(SQLException e)
        {
        
        }
            return resultset;
    }
    
    
    
    public ResultSet getaccommodation2()
    {
      try
       {
           resultset=selectaccommodation2.executeQuery();
          
       }
      catch(SQLException e)
       {
        
       }
        return resultset;
    }
    
    
    
    public ResultSet getaccommodation3(String user)
    {
       try
        {
           selectaccommodation3.setString(1,user);
           resultset=selectaccommodation3.executeQuery();
         
        }
       catch(SQLException e)
        {
        
        }
        return resultset;
    }
    
  public ResultSet getaccommodation4(String user)
    {
       try
        {
            selectaccommodation4.setString(1,user);
            resultset=selectaccommodation4.executeQuery();
            
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
          selectaccommodation5.setString(1,user); 
          resultset=selectaccommodation5.executeQuery();
      }
  catch(SQLException e)
  {
      
  }
      return resultset;
  }
    
    
   public int deleteaccommodation(String user)
     {
         int result=0;
      try
         {
           deleteaccommodation.setString(1,user);
           result=deleteaccommodation.executeUpdate();
       
         
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
           insertaccommodation3.setInt(1,1);
           insertaccommodation3.setString(2,user);
           result=insertaccommodation3.executeUpdate();
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
           insertaccommodation3.setInt(1,0);
           insertaccommodation3.setString(2,user);
           result=insertaccommodation3.executeUpdate();
          }
      catch(SQLException e)
          {
             
          }
 
      return result;  
          }
     
     public int updateaccommodationstatus(String statu,String user)
      {
          int result=0;
       try
           {
             updateaccommodation1.setString(1,statu);
             updateaccommodation1.setString(2,user);
             result=updateaccommodation1.executeUpdate();
           }
               
       catch(SQLException e)
           {
             
           }
 
       return result;  
     }
     
     
     public int updateaccommodationfact(String staff,String engine,String capacity,Timestamp last,String user)
      {
             int result=0;
         try
            {
              updateaccommodation2.setString(1,staff);
              updateaccommodation2.setString(2,engine);
              updateaccommodation2.setString(3,capacity);
              updateaccommodation2.setTimestamp(4,last);
              updateaccommodation2.setString(5,user);
              result=updateaccommodation2.executeUpdate();
            }
               
         catch(SQLException e)
            {
             
            }
 
          return result;  
      }
     
     
     public int updateaccommodationmess(String message,String user)
      {
             int result=0;
       try
           {
             updateaccommodation1.setString(1,message);
             updateaccommodation1.setString(2,user);
             result=updateaccommodation1.executeUpdate();
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
         resultset=selectaccommodation2.executeQuery();
        }
        catch(SQLException e)
        {
            
        }
        return resultset;
    }
     
}
    



