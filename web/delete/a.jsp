<%@page import="Table.accommodation"%>  
<%@page import="java.sql.*"%>

<% Class.forName("com.mysql.jdbc.Driver"); %>
<%@page import = "java.util.Date" %>
<%    
    ResultSet rs1=null;
    int f=0;
    accommodation p = new accommodation ();
    String user = new String ();
    try
    {
    rs1=p.returnlog(); 
    rs1.next();
    user =rs1.getString("user_name");
      p.deleteaccommodation(user);
      response.sendRedirect("http://localhost:8080/GIL/index.jsp");
    }
    catch (SQLException e)
    {
        
    }
    %>