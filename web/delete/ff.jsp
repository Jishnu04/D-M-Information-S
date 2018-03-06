<%@page import="Table.fireforce"%>
<%@page import="java.sql.*"%>

<% Class.forName("com.mysql.jdbc.Driver"); %>
<% ResultSet rs1=null;
    fireforce ff = new fireforce ();
    String user = new String ();
     try
    {
    rs1=ff.returnlog();   
    rs1.next(); 
    user =rs1.getString("user_name");
    ff.deletefireforce1(user);
    response.sendRedirect("http://localhost:8080/GIL/index.jsp");
    }
    catch (SQLException e)
    {
       
    }
     
%>