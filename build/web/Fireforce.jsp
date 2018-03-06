
<%-- 
    Document   : index
    Created on : Mar 17, 2016, 6:06:27 PM
    Author     : JISHNU T U
--%>

<%@page import="Table.fireforce"%>
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
    String st =new String (request.getParameter("station"));
    String stc =new String (request.getParameter("scode"));
    String mid =new String (request.getParameter("mailid"));
    String cno =new String (request.getParameter("cno"));
    String cheif =new String (request.getParameter("cheif"));
    String la =new String (request.getParameter("lat"));
    String lo =new String (request.getParameter("long"));
    String staff =new String (request.getParameter("staff"));
    String mac =new String (request.getParameter("mac"));
    float f1=Float.parseFloat("0.0");
    float f2=Float.parseFloat("0.0");
    int a=Integer.parseInt("0");
  try
  {
      a=Integer.parseInt(staff);
  }
  catch (NumberFormatException n)
  {
      r=12;
  }
    try
    {
     f1 = Float.parseFloat(la); 
     f2 = Float.parseFloat(lo);  
    }
    catch (NumberFormatException n) 
           {
            r=11;
           }
   
    if(un.equals(null)||un.equals("")) 
        r=2;
    
    else if(pw1.equals(null)||pw1.equals(""))  
        r=4;
   
    else if(!pw1.equals(pw2))
          r=3;        
   
    else if(st.equals(null)||st.equals("")) 
        r=5;
  
     
    else if(stc.equals(null)||stc.equals("")) 
        r=6;

    else if(mid.equals(null)||mid.equals(""))
        r=7;
  
      
    else if(cno.equals(null)||cno.equals(""))
        r=8;
    
   
    else if(cheif.equals(null)||cheif.equals(""))
        r=9;
  
     
    else if(la.equals(null)||la.equals(""))
        r=10;
    
     
    else if(lo.equals(null)||lo.equals(""))
        r=10;
   
      
    if(r==0)
    {
    Date date = new Date();
    Timestamp timestamp = new Timestamp(date.getTime()); 
    fireforce ff =new fireforce();
    r=ff.Setfireforce(un,pw1,st,stc,mid,cno,cheif,f1,f2,timestamp,staff,mac);  
    }
    }
    %>

   
<!DOCTYPE html> 

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="apply.css">
        <title>Fire FORCE</title>
    </head>
    
<body onload="display()">
    <h1 align="center">Fire force Registration : </h1>
    <h2>Fill the Form to Register : </h2>
        <form name="myform" action="Fireforce.jsp" method="POST">
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
                        <td>Station :</td>
                        <td><input type="text" name="station" value="" size="50" /></td>
                    </tr>
                    <tr>
                        <td>Station code :</td>
                        <td><input type="text" name="scode" value="" size="50" /></td>
                    </tr>
                    <tr>
                        <td>Mail id :</td>
                        <td><input type="text" name="mailid" value="" size="50" /></td>
                    </tr>
                    <tr>
                        <td>Contact No :</td>
                        <td><input type="text" name="cno" value="" size="50" /></td>
                    </tr>
                    <tr>
                        <td>Cheif Officer(in charge) :</td>
                        <td><input type="text" name="cheif" value="" size="50" /></td>
                    </tr>
                    <tr>
                        <td>GPS Cordinates :</td>
                        <td><input type="text" name="lat" value="" size="24" /> <input type="text" name="long" value="" size="24" /></td>
                    </tr>
                      <tr>
                        <td>Numbers of Staff</td>
                        <td><input type="text" name="staff" value="" size="50" /></td>
                    </tr>
                      <tr>
                        <td>Number of machinery :</td>
                        <td><input type="text" name="mac" value="" size="50" /></td>
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
            alert("Station name cannot be empty");
         else if(s==6)
            alert("Station code field cannot be empty");
         else if(s==7)
            alert("Mail id cannot be empty");
         else if(s==8)
            alert("Contact no is  empty");
         else if(s==9)
            alert("Cheif officer field is empty");
         else if(s==10 || s==11)
            alert("Invalid Cordinates");
         else if(s==12)
            alert("Invalid Staff number");
    }
</script>
</body>
    
    