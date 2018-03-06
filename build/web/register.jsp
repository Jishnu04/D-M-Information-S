<%-- 
    Document   : register
    Created on : Mar 19, 2016, 2:55:23 PM
    Author     : JISHNU T U
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file ="index.jsp"%>
<%
   if(request.getParameter("s1")!=null)
   {
   String site = new String("http://localhost:8080/GIL/Fireforce.jsp");
   String op = new String(request.getParameter("D1"));
   if(op.equals("fireforce"))
   response.sendRedirect("http://localhost:8080/GIL/Fireforce.jsp");
   else if(op.equals("volagency"))
   response.sendRedirect("http://localhost:8080/GIL/volunteer.jsp");
   else if(op.equals("hospital"))
   response.sendRedirect("http://localhost:8080/GIL/hospital.jsp");
   else if(op.equals("pronearea"))
   response.sendRedirect("http://localhost:8080/GIL/pronearea.jsp");
   else if(op.equals("accplace"))
   response.sendRedirect("http://localhost:8080/GIL/accomodation.jsp"); 
   else if(op.equals("geologist"))
   response.sendRedirect("http://localhost:8080/GIL/geologist.jsp");
   else if(op.equals("socialmedia"))
   response.sendRedirect("http://localhost:8080/GIL/socialmedia.jsp");
   else
   response.sendRedirect("http://localhost:8080/GIL/Fireforce.jsp");
  }

%>