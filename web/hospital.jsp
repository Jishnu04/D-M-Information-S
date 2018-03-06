<%--  
    Document   : hospital
    Created on : Mar 20, 2016, 11:30:46 PM
    Author     : EBIN PAUL
--%>

<%@page import="Table.hospital"%> 
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
    String mid =new String (request.getParameter("mid"));
    String cno =new String (request.getParameter("cno"));
    String la =new String (request.getParameter("lat"));
    String lo =new String (request.getParameter("long"));
    String cat =new String (request.getParameter("cat"));
    String h_name =new String (request.getParameter("h_name"));
    String addr =new String (request.getParameter("addr"));
    String staff=new String (request.getParameter("staff"));
    String ambu=new String (request.getParameter("ambu"));
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
   
    else if(mid.equals(null)||mid.equals(""))
        r=5;
  
      
    else if(cno.equals(null)||cno.equals(""))
        r=6;
    
    else if(la.equals(null)||la.equals(""))
        r=7;
    
     
    else if(lo.equals(null)||lo.equals(""))
        r=7;
    
    else if(cat.equals(null)||cat.equals(""))
        r=8; 
    
    else if(h_name.equals(null)||h_name.equals(""))
        r=9;
   
    else if(addr.equals(null)||addr.equals(""))
        r=10;
      
    if(r==0)
    {
    Date date = new Date();
    Timestamp timestamp = new Timestamp(date.getTime()); 
    hospital h =new hospital(); 
    r=h.Sethospital(un,pw1,mid,cno,f1,f2,cat,h_name,addr,staff,ambu,capa,timestamp);  
    }
    }
    %>

   
<!DOCTYPE html> 

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="apply.css">
        <title>Hospital</title>
    </head>
    
<body onload="display()">
    <h1>Fill the Form to Register : </h1>
        <form name="myform" action="hospital.jsp" method="POST">
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
                        <td>Mail_id :</td>
                        <td><input type="text" name="mid" value="" size="50" /></td>
                    </tr>
                    <tr>
                        <td>Contact no :</td>
                        <td><input type="text" name="cno" value="" size="50" /></td>
                    </tr>
                     <tr>
                        <td>GPS Coordinates :</td>
                        <td><input type="text" name="lat" value="" size="24" /> <input type="text" name="long" value="" size="24" /></td>
                    </tr>
                    <tr>
                        <td>Category :</td>
                        <td><select name="cat">
                                <option value ="private">PRIVATE</option>
                                <option value ="govt">GOVT</option>
                                <option value ="co-op">COOPERATIVE</option>
                            </select></td>
                    </tr>
                    <tr>
                        <td>Name :</td>
                        <td><input type="text" name="h_name" value="" size="50" /></td>
                    </tr>
                    <tr>
                        <td>Address:</td>
                        <td><input type="text" name="addr" value="" size="50" /></td>
                    </tr>
                   
                      <tr>
                        <td>Numbers of Staff</td>
                        <td><input type="text" name="staff" value="" size="50" /></td>
                    </tr>
                      <tr>
                        <td>Number of Ambulances :</td>
                        <td><input type="text" name="ambu" value="" size="50" /></td>
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
    <a href="index.jsp" style="color: #98FB98" >BACK</a>
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
         else if(s==9)
            alert("hospital name is  empty");
         else if(s==10)
            alert("address is empty");
    }
</script>
</body>
    
