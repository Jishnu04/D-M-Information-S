package Table;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.*;
/**
 *
 * @author JISHNU T U
 */
public class geologist {
    String URL ="jdbc:mysql://localhost:3306/dmis";
    String USERNAME="root";
    String PASSWORD="123456789";
    Connection connection =null;
    PreparedStatement insertgeologist1=null;
    PreparedStatement insertgeologist2=null;
    PreparedStatement insertgeologist3=null;
    PreparedStatement selectgeologist1=null;
    PreparedStatement selectgeologist2=null;
    PreparedStatement selectgeologist3=null;
    PreparedStatement selectgeologist4=null;
    PreparedStatement selectgeologist5=null; 
    PreparedStatement updategeologist1=null;
    PreparedStatement updategeologist2=null;
    PreparedStatement updategeologist3=null;
    PreparedStatement deletegeologist1=null;
    PreparedStatement deletegeologist2=null;
    ResultSet resultset  =null;
     public geologist()
     {
         try
         {
            connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            insertgeologist1=connection.prepareStatement("INSERT INTO geologist (user_name,passwrd,location,contact_no,mail_id,address,latitude,longitude) "+" VALUES(?,?,?,?,?,?,?,?)");
            insertgeologist2=connection.prepareStatement("INSERT INTO facilities(category,user_name,staff,engine,capacity,last_update)"+"VALUES('G',?,?,?,?,?)");
            insertgeologist3=connection.prepareStatement("UPDATE dmis.geologist SET log=? WHERE user_name=?");
            
            selectgeologist1=connection.prepareStatement("SELECT user_name,passwrd FROM geologist WHERE user_name=?");
            selectgeologist2=connection.prepareStatement ("SELECT * from geologist  where log=1");
            selectgeologist3=connection.prepareStatement("SELECT * from geologist h, facilities f "
                                                          +"where f.category='G' AND f.user_name=?");
            selectgeologist4=connection.prepareStatement("SELECT * from facilities where category='G' AND user_name=?");
              selectgeologist5=connection.prepareStatement("SELECT statu ,message from facilities where user_name=? and category='G'");
               updategeologist1=connection.prepareStatement("update facilities set statu=? where user_name=? and category='G'");
            updategeologist2=connection.prepareStatement("update facilities set staff=?,engine=?,capacity=?,last_update=? where user_name=? and category='G'");
            updategeologist3=connection.prepareStatement("UPDATE facilities set statu=? where category='G' AND user_name=?");
           
            deletegeologist1=connection.prepareStatement("DELETE geologist, facilities FROM geologist INNER JOIN facilities ON geologist.user_name = facilities.user_name WHERE geologist.user_name=? AND facilities.category='G'");
               }
         catch(SQLException e)
         {
       
         }
     }
    public int Setgeologist (String user_name,String password,String location,String con,String mail_id,String address ,double lattitude,double longitude,String staff,String engine,String capacity,Timestamp last) 
    {
    int result=0;
    try
    {   
    insertgeologist1.setString(1,user_name);
    insertgeologist1.setString(2,password);
    insertgeologist1.setString(3,location);
    insertgeologist1.setString(4, con);
    insertgeologist1.setString(5,mail_id);
    insertgeologist1.setString(6,address);
    insertgeologist1.setDouble(7,lattitude);
    insertgeologist1.setDouble(8,longitude);
    
    insertgeologist2.setString(1,user_name);
    insertgeologist2.setString(2,staff);
    insertgeologist2.setString(3,engine);
    insertgeologist2.setString(4,capacity);
    insertgeologist2.setTimestamp(5,last);
   
    result=insertgeologist1.executeUpdate();
    insertgeologist2.executeUpdate();
    }
    catch(SQLException e)
    {
        
    }
  return result;
    }
    
    public ResultSet getgeologist1(String user)
    {
       try
        {
            selectgeologist1.setString(1,user);
            resultset=selectgeologist1.executeQuery();
            
        }
     catch(SQLException e)
        {
        
        }
            return resultset;
    }
    
    
    
    public ResultSet getgeologist2()
    {
      try
       {
           resultset=selectgeologist2.executeQuery();
          
       }
      catch(SQLException e)
       {
        
       }
        return resultset;
    }
    
    
    
    public ResultSet getgeologist3(String user)
    {
       try
        {
           selectgeologist3.setString(1,user);
           resultset=selectgeologist3.executeQuery();
         
        }
       catch(SQLException e)
        {
        
        }
        return resultset;
    }
    
  public ResultSet getgeologist4(String user)
    {
       try
        {
            selectgeologist4.setString(1,user);
            resultset=selectgeologist4.executeQuery();
            
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
          selectgeologist5.setString(1,user); 
          resultset=selectgeologist4.executeQuery();
      }
  catch(SQLException e)
  {
      
  }
      return resultset;
  }
    
    
   public int deletegeologist(String user)
     {
         int result=0;
      try
         {
           deletegeologist1.setString(1,user);
           result=deletegeologist1.executeUpdate();
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
           insertgeologist3.setInt(1,1);
           insertgeologist3.setString(2,user);
           result=insertgeologist3.executeUpdate();
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
           insertgeologist3.setInt(1,0);
           insertgeologist3.setString(2,user);
           result=insertgeologist3.executeUpdate();
          }
      catch(SQLException e)
          {
             
          }
 
      return result;  
          }
     
     public int updategeologiststatus(String statu,String user)
      {
          int result=0;
       try
           {
             updategeologist1.setString(1,statu);
             updategeologist1.setString(2,user);
             result=updategeologist1.executeUpdate();
           }
               
       catch(SQLException e)
           {
             
           }
 
       return result;  
     }
     
     
     public int updategeologistfact(String staff,String engine,String capacity,Timestamp last,String user)
      {
             int result=0;
         try
            {
          
              updategeologist2.setString(1,staff);
              updategeologist2.setString(2,engine);
              updategeologist2.setString(3,capacity);
              updategeologist2.setTimestamp(4,last);
             updategeologist2.setString(5,user);
              result=updategeologist2.executeUpdate();
            }
               
         catch(SQLException e)
            {
             
            }
 
          return result;  
      }
     
     
     public int updategeologistmess(String message,String user)
      {
             int result=0;
       try
           {
             updategeologist1.setString(1,message);
             updategeologist1.setString(2,user);
             result=updategeologist1.executeUpdate();
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
         resultset=selectgeologist2.executeQuery();
        }
        catch(SQLException e)
        {
            
        }
        return resultset;
}
}