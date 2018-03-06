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
public class fireforce 
{
    String URL ="jdbc:mysql://localhost:3306/dmis";
    String USERNAME="root";
    String PASSWORD="123456789";
    Connection connection =null;
    PreparedStatement insertfireforce1=null;
    PreparedStatement insertfireforce2=null;
    PreparedStatement insertfireforce3=null;
    PreparedStatement selectfireforce1=null;
    PreparedStatement selectfireforce2=null;
    PreparedStatement updatefireforce5=null;
    PreparedStatement updatefireforce4=null;
    PreparedStatement selectfireforce5=null;
    PreparedStatement selectfireforce6=null;
    PreparedStatement updatefireforce1=null;
    PreparedStatement updatefireforce2=null;
    PreparedStatement deletefireforce1=null;
    PreparedStatement deletefireforce2=null;
    ResultSet resultset  =null;
     public fireforce()
     {
         try
         {
            connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            insertfireforce1=connection.prepareStatement("INSERT INTO fire_force (user_name,passwrd,station,code,mail_id,contact_no,chief,latitude,longitude) "+" VALUES(?,?,?,?,?,?,?,?,?)");
            insertfireforce2=connection.prepareStatement("INSERT INTO facilities(category,user_name,staff,engine,last_update)"+"VALUES('F',?,?,?,?)");
            insertfireforce3=connection.prepareStatement("UPDATE dmis.fire_force SET log=? WHERE user_name=?");
            updatefireforce4=connection.prepareStatement("update facilities set staff=? , engine=? , capacity=?,last_update=? where user_name=? and category='F'");
            selectfireforce1=connection.prepareStatement("SELECT user_name,passwrd FROM fire_force WHERE user_name=?");
            selectfireforce2=connection.prepareStatement("SELECT statu ,message from facilities where user_name=? and category='F'");
            updatefireforce5=connection.prepareStatement("update facilities set statu=? where user_name=? and category='F'");
            selectfireforce5=connection.prepareStatement("SELECT station,chief,staff,engine,statu from fire_force ff,facilities f"+"where f.category='F' AND ff.user_name=f.user_name");
            selectfireforce6=connection.prepareStatement("SELECT * from fire_force where log=1");
            deletefireforce1=connection.prepareStatement("DELETE fire_force, facilities FROM fire_force INNER JOIN facilities ON fire_force.user_name = facilities.user_name WHERE fire_force.user_name=? and facilities.category='F'");
            deletefireforce2=connection.prepareStatement("DELETE from facilities where category='F' and user_name=?");
         }
         catch(SQLException e)
         {
       
         }
     }
    public int Setfireforce (String user_name,String password,String station,String code,String mail_id,String cno ,String chief,float lattitude,float longitude,Timestamp last,String staff,String engine) 
    {
    int result=0;
    try
    {   
    insertfireforce1.setString(1,user_name);
    insertfireforce1.setString(2,password);
    insertfireforce1.setString(3,station);
    insertfireforce1.setString(4, code);
    insertfireforce1.setString(5,mail_id);
    insertfireforce1.setString(6,cno);
    insertfireforce1.setString(7,chief);
    insertfireforce1.setFloat(8,lattitude);
    insertfireforce1.setFloat(9,longitude);
    insertfireforce2.setTimestamp(4,last);
    insertfireforce2.setString(1,user_name);
    insertfireforce2.setString(2,staff);
    insertfireforce2.setString(3,engine);
   
    result=insertfireforce1.executeUpdate();
    insertfireforce2.executeUpdate();
    }
    catch(SQLException e)
    {
        
    }
  return result;
    }
    
    public ResultSet getfireforce(String un)
    {
        try
        {
            
            selectfireforce1.setString(1,un);
            resultset=selectfireforce1.executeQuery();
            
        }
    catch(SQLException e)
    {
        resultset=null;
    }
        return resultset;
    }
    
    public void login(String x)
    {
        try
        {
         insertfireforce3.setInt(1,1);
         insertfireforce3.setString(2,x);
         insertfireforce3.executeUpdate(); 
        }
        catch(SQLException e)
        {
            
        }
        
    }
    public void logout(String x)
    {
        try
        {
         insertfireforce3.setInt(1,0);
         insertfireforce3.setString(2,x);
         insertfireforce3.executeUpdate();
        }
        catch(SQLException e)
        {
            
        }
        
    }
    public ResultSet returnlog()
    {
        try
        {
         resultset=selectfireforce6.executeQuery();
        }
        catch(SQLException e)
        {

        }
        return resultset;
    }
    
    public int deletefireforce1(String x)
    {
        int result=0;
        try
        {
         deletefireforce1.setString(1, x);
         deletefireforce1.executeUpdate();
        }
        catch(SQLException e)
        {
            
        }
         return result;
    }
        
    public int updatefact(String s,String m,String c,Timestamp t,String u )
    {
        int result=0;
        try
        {
         updatefireforce4.setString(1,s);
         updatefireforce4.setString(2,m);
         updatefireforce4.setString(3,c);
         updatefireforce4.setTimestamp(4, t);
         updatefireforce4.setString(5,u);
         result=updatefireforce4.executeUpdate();
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
         updatefireforce5.setString(1,s);
         updatefireforce5.setString(2,u);
         result=updatefireforce5.executeUpdate();
        }
        catch(SQLException e)
        {
            
        }
        return result;
    }
    public ResultSet returnstm(String u)
    {
        try
        {
         selectfireforce2.setString(1,u);
         resultset=selectfireforce2.executeQuery();
        }
        catch(SQLException e)
        {
            
        }
        return resultset;
    }
} 