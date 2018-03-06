<%-- 
    Document   : pronearea
    Created on : Mar 21, 2016, 11:16:17 AM
    Author     : EBIN PAUL
--%>


<%@page import="Table.accommodation"%>  
<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% Class.forName("com.mysql.jdbc.Driver"); %>
<%@page import = "java.util.Date" %>


<%
    int r=0; 
    if(request.getParameter("submit")!=null)
    {
    String un =new String(request.getParameter("username"));
    String pw1 =new String (request.getParameter("pw1"));
    String pw2 =new String (request.getParameter("pw2"));
    String bui =new String (request.getParameter("bui"));
    String loc =new String (request.getParameter("loc"));
    String la =new String (request.getParameter("lat"));
    String lo =new String (request.getParameter("long"));
    String nm =new String (request.getParameter("nme"));
    String cno =new String (request.getParameter("cno"));
    String mid =new String (request.getParameter("mid"));
    String staff=new String (request.getParameter("staff"));
    String eng=new String (request.getParameter("eng"));
    String capa=new String (request.getParameter("capa"));
    double f1=Double.parseDouble("0.0");
    double f2=Double.parseDouble("0.0");    
 try
    {
     f1 = Double.parseDouble(la); 
     f2 = Double.parseDouble(lo);  
    }
    catch (NumberFormatException n) 
           {
            r=12;
           }
   
    if(un.equals(null)||un.equals("")) 
        r=2;
    
    else if(pw1.equals(null)||pw1.equals(""))  
        r=4;
   
    else if(!pw1.equals(pw2))
          r=3;        
     
    else if(bui.equals(null)||loc.equals(""))
        r=5;
      
    else if(loc.equals(null)||loc.equals(""))
        r=6;
  
    else if(la.equals(null)||la.equals(""))
        r=6;
    
     
    else if(lo.equals(null)||lo.equals(""))
        r=6;
    
    else if(nm.equals(null)||nm.equals(""))
        r=7; 
       
    else if(cno.equals(null)||cno.equals(""))
        r=8;
    
    else if(mid.equals(null)||mid.equals(""))
        r=9;
      
    if(r==0)
    {
    Date date = new Date();
    Timestamp timestamp = new Timestamp(date.getTime()); 
   accommodation a =new    accommodation();  
    r=a.Setaccommodation(un,pw1,bui,loc,f1,f2,nm,cno,mid,staff,eng,capa,timestamp);  
    
    }
    }
    %>

   
<!DOCTYPE html> 

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="apply.css">
        <title>Accommodation</title>
    </head>
    
<body onload="display()">
    <h1 align="center">Accomodation Registration : </h1>
    <h2>Fill the Form to Register : </h2>
        <form name="myform" action="accomodation.jsp" method="POST">
            <table border="0">
                <tbody>
                    <tr>
                        <td>User name : </td>
                        <td><input type="text" name="username" value="" size="50" /></td>
                    </tr>
                    <tr>
                        <td>Password  :</td>
                        <td><input type="password" name="pw1" value="" size="50" /></td>
                    </tr>
                    <tr>
                        <td>Re-type Password :</td>
                        <td><input type="password" name="pw2" value="" size="50" /></td>
                    </tr>
                    <tr>
                        <td>Building Name :</td>
                        <td><input type="text" name="bui" value="" size="50" /></td>
                    </tr>
                    <tr>
                        <td>Location :</td>
                        <td><input type="text" name="loc" value="" size="50" /></td>
                    </tr>
                    <tr>
                        <td>GPS Coordinates :</td>
                        <td><input type="text" name="lat" value="" size="24" /> <input type="text" name="long" value="" size="24" /></td>
                    </tr>
                    <tr>
                        <td>Owner Name :</td>
                        <td><input type="text" name="nme" value="" size="50" /></td>
                    </tr>
                     <tr>
                        <td>Contact no :</td>
                        <td><input type="text" name="cno" value="" size="50" /></td>
                    </tr>
                     <tr>
                        <td>Mail id :</td>
                        <td><input type="text" name="mid" value="" size="50" /></td>
                    </tr>
                    <tr>
                        <td>Hospitality :</td>
                        <td><input type="text" name="staff" value="" size="50" /></td>
                    </tr>
                      <tr>
                        <td>Services Provided:</td>
                        <td><input type="text" name="eng" value="" size="50" /></td>
                    </tr>
                     <tr>
                        <td>Capacity :</td>
                        <td><input type="text" name="capa" value="" size="50" /></td>
                    </tr>
                </tbody>
            </table>
            <input type="reset" value="Clear" name="clear" />
            <input type="submit" value="Submit" name="submit" />
        </form>
    <a href="index.jsp" style="color: #98FB98">BACK</a>
  <script type="text/javascript" >
    function display()
    {
        var s =<%=r %>;
        if(s==1)
        alert("Registered successfully");
        else if(s==2)
            alert("Username Field is empty");
         else if(s==3)
            alert("Password Mismatch"); 
        else if(s==4)
            alert("Password field cannot be empty");
        else if(s==5)
            alert("Building name cannot be empty");
         else if(s==6)
            alert("Location cannot be empty");
         else if(s==7)
            alert("Coordinates cannot be empty");
         else if(s==8)
            alert("Owner name cannot be empty");
        else if(s==9)
            alert("Contact no cannot be empty");
        else if(s==10)
            alert("Mail id cannot be empty");
    }
</script>
</body>
    

