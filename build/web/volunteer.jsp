<%-- 
    Document   : volunteer
    Created on : Mar 20, 2016, 9:40:12 PM
    Author     : EBIN PAUL
--%>





<%@page import="Table.volunteer"%>  
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
    String mid =new String (request.getParameter("mail_id"));
    String cno =new String (request.getParameter("cno"));
    String la =new String (request.getParameter("lat"));
    String lo =new String (request.getParameter("long"));
    String loc =new String (request.getParameter("location"));
    String agency =new String (request.getParameter("agency"));
    String cat =new String (request.getParameter("cat"));
    String staff=new String (request.getParameter("staff_count"));
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
   
    else if(mid.equals(null)||mid.equals(""))
        r=5;
  
      
    else if(cno.equals(null)||cno.equals(""))
        r=6;
    
    else if(la.equals(null)||la.equals(""))
        r=7;
    
     
    else if(lo.equals(null)||lo.equals(""))
        r=7;
    
    else if(loc.equals(null)||loc.equals(""))
        r=8; 
    
    else if(agency.equals(null)||agency.equals(""))
        r=9;
    
  
      
    if(r==0)
    {
    Date date = new Date();
    Timestamp timestamp = new Timestamp(date.getTime()); 
    volunteer v =new volunteer();
    r=v.Setvolunteer(un,pw1,mid,cno,f1,f2,loc,agency,cat,staff,timestamp);    
    }
    }
    %>

   
<!DOCTYPE html> 

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="apply.css">
        <title>Volunteer</title>
    </head>
    
<body onload="display()">
    <h1 align="center">Volunteer Registration : </h1>
    <h2>Fill the Form to Register : </h2>
        <form name="myform" action="volunteer.jsp" method="POST">
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
                        <td>Mail id :</td>
                        <td><input type="text" name="mail_id" value="" size="50" /></td>
                    </tr>
                    <tr>
                        <td>Contact no :</td>
                        <td><input type="text" name="cno" value="" size="50" /></td>
                    </tr>
                    <tr>
                        <td>Location :</td>
                        <td><input type="text" name="location" value="" size="50" /></td>
                    </tr>
                    <tr>
                        <td>GPS Coordinates :</td>
                        <td><input type="text" name="lat" value="" size="24" /> <input type="text" name="long" value="" size="24" /></td>
                    </tr>
                      <tr>
                        <td>Agency Name :</td>
                        <td><input type="text" name="agency" value="" size="50" /></td>
                    </tr>
                      <tr>
                        <td>Category :</td>
                        <td><select name="cat">
                                <option value ="club">CLUB</option>
                                <option value ="nss">NSS</option>
                                <option value ="red_cross">RED CROSS</option>
                                <option value ="other">OTHER COMMUNITY</option>
                            </select></td>
                    </tr>
                    <tr>
                        <td>Staff Count :</td>
                        <td><input type="text" name="staff_count" value="" size="50" /></td>
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
            alert("Mail id cannot be empty");
         else if(s==6)
            alert("Contact no is be empty");
         else if(s==7)
            alert("Coordinates cannot be empty");
         else if(s==8)
            alert("Location is  empty");
         else if(s==9)
            alert("Agency name is empty");
         
    }
</script>
</body>
    
    