<%@page import="Table.volunteer"%>
<%@page import="java.sql.*"%>

<% Class.forName("com.mysql.jdbc.Driver"); %>
<% ResultSet rs1=null;
    volunteer v = new volunteer ();
    String user = new String ();
     try
    {
    rs1=v.returnlog();   
    rs1.next(); 
    user =rs1.getString("user_name");
    v.delvolunteer(user);
    response.sendRedirect("http://localhost:8080/GIL/index.jsp");
    }
    catch (SQLException e)
    {
       
    }
     
%>