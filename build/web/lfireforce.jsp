<%-- 
    Document   : newjsp
    Created on : Mar 20, 2016, 8:21:27 AM
    Author     : JISHNU T U
--%>
<%@page import="Table.fireforce"%>
<%@page import="java.sql.*"%>

<% Class.forName("com.mysql.jdbc.Driver"); %>
<%@page import = "java.util.Date" %>
<%  
    ResultSet rs1=null;
    int f=0;
    fireforce ff = new fireforce ();
    String user = new String ();
     try
    {
    rs1=ff.returnlog();   
   
    rs1.next(); 
    user =rs1.getString("user_name");

    }
    catch (SQLException e)
    {
       
    }
    
   if(request.getParameter("DA")!=null)
    {
        response.sendRedirect("http://localhost:8080/GIL/delete/ff.jsp");
        
    }
   if(request.getParameter("lt")!=null)
    {
       
        response.sendRedirect("http://localhost:8080/GIL/index.jsp");
         ff.logout(user);
    }
   if(request.getParameter("UF")!=null)
    {
        Date date = new Date();
    Timestamp timestamp = new Timestamp(date.getTime()); 
     ff.updatefact(request.getParameter("n1"),request.getParameter("n2"),request.getParameter("n7"),timestamp,user);
     f=1;
    }
   if(request.getParameter("us")!=null)
    {
     ff.updatestat(request.getParameter("n3"),user);
     f=2;
    }
   if(request.getParameter("rf")!=null)
        {
                rs1=ff.returnstm(user);
                     rs1.next();
       } 
    %>
    
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="apply.css">
        <title>Fire Force Session</title>
    </head>
    <body onload="display1()">
       <h1 align ="center">USER PROFILE</h1>
        <form name="updateform1" action="lfireforce.jsp">
            <table border="0">

                <tbody>
                    <tr>
                        
                     <% 
                           rs1=ff.returnstm(user);
                             rs1.next(); 
                        %>
                        <td>Your Current Status  :</td>
                        <td><%=rs1.getString("statu")%></td>
                    </tr>
                    <tr>
     
                        <td>Message From Head Quarters : </td>
                        <td><%=rs1.getString("message")%></td>
                    </tr>
                    <tr>
                        <td>Refresh to get Latest Messages</td>
                        <td><input type="submit" value="Refresh" name="rf" /></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td>Update your Avaiability and Status</td>
                    </tr>
                    <tr>
                        <td>Staff Available   :</td>
                        <td><input type="text" name="n1" value="" size="50" /></td>
                    </tr>
                    <tr>
                        <td>Engines Available   :</td>
                        <td><input type="text" name="n2" value="" size="50" /></td>
                    </tr>
                     <tr>
                        <td>Services Provide   :</td>
                        <td><input type="text" name="n7" value="" size="50" /></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="submit" value="Update Availablity" name="UF" /></td>
                    </tr>
                     <tr>
                        <td>Update your status here   :</td>
                        <td><input type="text" name="n3" value="" size="120" /></td>
                    </tr>
                     <tr>
                        <td> <input type="reset" value="Clear" name="clear" /></td>
                        <td><input type="submit" value="Update Status" name="us" /></td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="Deactivate the account" name="DA" /></td>
                        <td> <input type="submit" value="Logout" name="lt" /></td>
                    </tr>
                
                </tbody>
            </table>

 
            
           
           
            
            
        </form> 
      <script type="text/javascript" >
    function display1()
    {
        var s=<%=f%>
        if(s==1)
            alert("Updated successfully");
        if(s==2)
            alert("Status Changed")
    }
</script>
    </body>
</html>
