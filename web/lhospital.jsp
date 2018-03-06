<%-- 
    Document   : newjsp
    Created on : Mar 20, 2016, 8:21:27 AM
    Author     : JISHNU T U
--%>
<%@page import="Table.hospital"%> 
<%@page import="java.sql.*"%>

<% Class.forName("com.mysql.jdbc.Driver"); %>
<%@page import = "java.util.Date" %>
<%   
    ResultSet rs1=null;
    int f=0;
    hospital h = new hospital ();
    String user = new String ();
    try
    {
    rs1=h.returnlog(); 
    rs1.next();
    user =rs1.getString("user_name");
    }
    catch (SQLException e)
    {
        
    }
   if(request.getParameter("DA")!=null)
   {
        response.sendRedirect("http://localhost:8080/GIL/delete/h.jsp");
    }
   if(request.getParameter("lt")!=null)
    {
       
        response.sendRedirect("http://localhost:8080/GIL/index.jsp");
         h.logout(user);
    }
   if(request.getParameter("UF")!=null)
    {
    Date date = new Date(); 
    Timestamp timestamp = new Timestamp(date.getTime()); 
     h.updatefact(request.getParameter("n1"),request.getParameter("n2"),request.getParameter("n7"),timestamp,user);
     f=1;
    }
   if(request.getParameter("us")!=null)
    {
     h.updatestatus(request.getParameter("n3"),user);
     f=2;
    }
   if(request.getParameter("rf")!=null)
        {
                rs1=h.gethospital4(user);
                     rs1.next();
       }
    %>
    
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="apply.css">
        <title>Hospital Session</title>
    </head>
    <body onload="display1()">
           <h1 align ="center">USER PROFILE</h1>
        <form name="updateform1" action="lhospital.jsp">
            <table border="0">

                <tbody>
                    <tr>
                        
                        <%
                            rs1=h.gethospital4(user);
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
                        <td>Update your Availability and Status</td>
                    </tr>
                    <tr>
                        <td>Staff Available   :</td>
                        <td><input type="text" name="n1" value="" size="50" /></td>
                    </tr>
                    <tr>
                        <td>Ambulances Available   :</td>
                        <td><input type="text" name="n2" value="" size="50" /></td>
                    </tr>
                    <tr>
                        <td>Services Provided   :</td>
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
