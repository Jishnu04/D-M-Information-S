<%-- 
    Document   : headqua
    Created on : Mar 20, 2016, 9:47:46 PM
    Author     : JISHNU T U
--%>
<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% Class.forName("com.mysql.jdbc.Driver"); %>
<% 
   int e1=2;
  Connection connection = null;
  connection =DriverManager.getConnection("jdbc:mysql://localhost:3306/dmis","root","123456789");
  PreparedStatement sm=connection.prepareStatement("UPDATE facilities SET message =? WHERE category=? AND user_name=?");
  PreparedStatement t1=connection.prepareStatement("SELECT ff.user_name,station,mail_id,chief,latitude,longitude,staff,engine,capacity,statu,last_update from fire_force ff,facilities f where f.category='F' AND ff.user_name=f.user_name");
  PreparedStatement t2=connection.prepareStatement("SELECT p.user_name,mail_id,lattitude,longitude,location,p.category,staff,engine,capacity,statu,last_update from volunteer p,facilities f where f.category='V' AND p.user_name=f.user_name;");
  PreparedStatement t3=connection.prepareStatement("SELECT h.user_name,mail_id,lattitude,longitude,h.category,name,staff,engine,capacity,statu,last_update from hospital h,facilities f where f.category='H' AND h.user_name=f.user_name;");
  PreparedStatement t4=connection.prepareStatement("SELECT p.user_name,location,lattitude,longitude,landform,staff,engine,capacity,statu,last_update from pronearea p,facilities f where f.category='P' AND p.user_name=f.user_name;");
  PreparedStatement t5=connection.prepareStatement("SELECT a.user_name,building,lattitude,longitude,i_name,mail_id,staff,engine,capacity,statu,last_update from accommodation a,facilities f where f.category='A' AND a.user_name=f.user_name;");
  PreparedStatement t6=connection.prepareStatement("SELECT a.user_name,mail_id,latitude,longitude,address,staff,engine,capacity,statu,last_update from geologist a,facilities f where f.category='G' AND a.user_name=f.user_name;");
  PreparedStatement t7=connection.prepareStatement("SELECT a.user_name,c_name,latitude,longitude,mail_id,address,staff,engine,capacity,statu,last_update from `socialmedia` a,facilities f where f.category='S' AND a.user_name=f.user_name;");
   ResultSet rst=null;
  if(request.getParameter("send")!=null)
  {
      sm.setString(1,request.getParameter("m"));
      sm.setString(2,request.getParameter("D"));
      sm.setString(3,request.getParameter("un"));
      e1=sm.executeUpdate();
  }
  %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" type="text/css" href="apply.css">
        <title>HQ </title>
    </head>
    <body onload ="message()">
        <h1 align="center"> HEADQUARTERS  </h1>
       
         <a href="h2.jsp" style="color: #98FB98" > NEAREST SERVICE FINDER(link) </a>
         
        <form name="msg" action="headqua.jsp" method="POST">
            <table border="1">
                <tbody>
                    <tr>
                        <td>Enter Message : </td>
                        <td><textarea name="m" rows="5" cols="50">
                            </textarea></td>
                    </tr>
                    <tr>
                        <td>Select Dept : <select name="D">
                            <option value =F>Fire Force</option>
                            <option value =V>Volunteer Agency</option>
                            <option value =H>Hospital</option>
                            <option value =P>Prone Areas</option>
                            <option value =A>Accommodation Places</option>
                            <option value =S>Social Media</option>
                        </select></td>
                        <td>Username : <input type="text" name="un" value="" /></td>
                    </tr>
                    <tr>
                        <td><input type="reset" value="Clear" name="clear" /></td>
                        <td><input type="submit" value="Send" name="send" /></td>
                    </tr>
                </tbody>
            </table>
        </form>
         <form name="tb" action="h1.jsp">
           <input type="submit" value="Fire Force" name="tab" /> 
            <input type="submit" value="Volunteer" name="tab" />
            <input type="submit" value="Hospital" name="tab" />
            <input type="submit" value="Prone Area" name="tab" />
            <input type="submit" value="Accomadation Places" name="tab" />
            <input type="submit" value="Geologist" name="tab" />
            <input type="submit" value="Social Media" name="tab" />
            
        </form>
        <a href="index.jsp" style="color: #98FB98" > BACK </a>
        <script type="text/javascript" >
    function message()
    {
        var s =<%=e1 %>;
        if(s==1)
        alert("Message Sent successfully");
        else if(s==0)
            alert("Sending Failed");
    }
</script>
    </body>
</html>
