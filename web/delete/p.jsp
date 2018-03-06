<%@page import="Table.pronearea"%> 
<%@page import="java.sql.*"%>

<% Class.forName("com.mysql.jdbc.Driver"); %>
<%@page import = "java.util.Date" %>
<%   
    ResultSet rs1=null;
    pronearea p = new pronearea ();
    String user = new String ();
    try 
    {
    rs1=p.returnlog(); 
    rs1.next();
    user =rs1.getString("user_name");
    p.deletepronearea(user); 
    response.sendRedirect("http://localhost:8080/GIL/index.jsp");
    }
    catch (SQLException e)
    {
        
    }
    %>