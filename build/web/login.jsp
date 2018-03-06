<%-- 
    Document   : login
    Created on : Mar 19, 2016, 7:24:02 PM
    Author     : JISHNU T U
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file ="index.jsp"%>
<%@page import ="java.sql.*" %>
<% Class.forName("com.mysql.jdbc.Driver"); %>
<%@page import ="Table.*" %>
<%
    int lf=1;
    String user = new String();
   if(request.getParameter("s2")!=null)
   {
   String site = new String("http://localhost:8080/GIL/Fireforce.jsp");
   String op = new String(request.getParameter("D2"));
   user =request.getParameter("N2");
   String pw1 = new String (request.getParameter("N3"));
   String pw2 = new String ();
   ResultSet rs =null;  

try
{
   if(op.equals("fireforce"))
   {
      fireforce ff = new fireforce();
       rs=ff.getfireforce(user);
       if(!rs.next())
           lf=0;
       pw2=rs.getString("passwrd");
       if(pw1.equals(pw2))
       {
       ff.login(user);
       response.sendRedirect("http://localhost:8080/GIL/lfireforce.jsp");
       }
       else
           lf=0; 
   }
   
   else if(op.equals("volagency"))
      {
      volunteer v = new volunteer();
       rs=v.getvoluteer(user);  
       if(!rs.next())
           lf=0;
       pw2=rs.getString("passwrd");
       if(pw1.equals(pw2))
       {
       v.login(user);
       response.sendRedirect("http://localhost:8080/GIL/lvolunteer.jsp");
       }
       else
           lf=0; 
   }
   else if(op.equals("hospital"))
        {
      hospital h = new hospital();
       rs=h.gethospital1(user);  
       if(!rs.next())
           lf=0;
       pw2=rs.getString("passwrd");
       if(pw1.equals(pw2))
       {
       h.login(user);
       response.sendRedirect("http://localhost:8080/GIL/lhospital.jsp");
       }
       else
           lf=0; 
   }
   else if(op.equals("pronearea"))
  {
      pronearea p = new pronearea();
       rs=p.getpronearea1(user);
       if(!rs.next())
           lf=0;
       pw2=rs.getString("passwrd");
       if(pw1.equals(pw2))
       {
       p.login(user);
       response.sendRedirect("http://localhost:8080/GIL/lpronearea.jsp");
       }
       else
           lf=0; 
   }
   else if(op.equals("accplace"))
   {
      accommodation a = new accommodation();
       rs=a.getaccommodation1(user);
       if(!rs.next())
           lf=0;
       pw2=rs.getString("passwrd");
       if(pw1.equals(pw2))
       {
       a.login(user);
       response.sendRedirect("http://localhost:8080/GIL/laccomodation.jsp");
       }
       else
           lf=0; 
   }
   else if(op.equals("geologist"))
    {
      geologist g = new geologist();
       rs=g.getgeologist1(user);  
       if(!rs.next())
           lf=0;
       pw2=rs.getString("passwrd");
       if(pw1.equals(pw2))
       {
       g.login(user);
       response.sendRedirect("http://localhost:8080/GIL/lgeologist.jsp");
       }
       else
           lf=0; 
   }
   else if(op.equals("socialmedia"))
  {
      socialmedia g = new socialmedia();
       rs=g.getsocialmedia1(user);  
       if(!rs.next())
           lf=0;
       pw2=rs.getString("passwrd");
       if(pw1.equals(pw2))
       {
       g.login(user);
       response.sendRedirect("http://localhost:8080/GIL/lsocialmedia.jsp");
       }
       else
           lf=0; 
   }
   else if(op.equals("admin"))
    {
       if(user.equals("hq")&&pw1.equals("hq"))
        response.sendRedirect("http://localhost:8080/GIL/headqua.jsp");
       else
           lf=0;
   }
   else
   response.sendRedirect("http://localhost:8080/GIL/index.jsp");
}
catch (SQLException e)
{
    
}
  }

%>

    <script type="text/javascript" >
    function displays()
    {
        var c=<%=lf%>
        if(c==0)
            alert("    Login Faied \n(Invalid password or username) ");
        else if(c==2)
            alert("You must Login first");
        
    }
    </script>
    



    
