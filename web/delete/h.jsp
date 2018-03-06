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
         h.deletehospital(user); 
           response.sendRedirect("http://localhost:8080/GIL/index.jsp");
    }
    catch (SQLException e)
    {
        
    }
    
%>