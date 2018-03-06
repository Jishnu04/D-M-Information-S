<%-- 
    Document   : newjsp
    Created on : Mar 19, 2016, 11:17:56 AM
    Author     : JISHNU T U
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>DMIS</title>
        <link rel="stylesheet" type="text/css" href="apply.css">
    </head>
    <body onload="displays()">
        <h1 align="center">DISASTER MANAGEMENT AND INFORMATION SYSTEM</h1>
    <center><img src="pic/logo.png" align ="middle" width="169" height="147" alt="logo"/>    
        <form name="myform2" action="login.jsp" method="POST">
            <p>&nbsp</p>
             <p>&nbsp</p>
      <div style="background-color:lightblue;color:darkblue;width: 350px">
        <table border="0">
      <thead>
        <tr>
             <th>login</th>
            <th>  </th> 
        </tr>
    </thead>
            <tbody>
                <tr>
                    <td>Username : </td>
                    <td><input type="text" name="N2" value="" /></td>
                </tr>
                 <tr>
                    <td>Password : </td>
                    <td><input type="password" name="N3" value="" /></td>
                </tr>
                <tr>
                    <td>Select category :</td>
                    <td><select name="D2">
                            <option value =fireforce>Fire Force</option>
                            <option value =volagency>Volunteer Agency</option>
                            <option value =hospital>Hospital</option>
                            <option value =pronearea>Prone Areas</option>
                            <option value =accplace>Accommodation Places</option>
                            <option value =geologist>Geologist</option>
                            <option value =socialmedia>Social Media</option>
                            <option value =admin>Head quarters </option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Login" name="s2" /></td>
                </tr>
            </tbody>
        </table>
      </div>

   </form>
         <form name="myform1" action="register.jsp" method="POST">
 <div style="background-color:lightblue;color:darkblue;width: 350px">
        <table border="0">
            <thead>
        <tr>
            <th>New User</th>
            <th></th>
        </tr>
    </thead>
            <tbody >
                <tr>
                    <td>Select category :</td>
                    <td><select name="D1">
                            <option value =fireforce>Fire Force</option>
                            <option value =volagency>Volunteer Agency</option>
                            <option value =hospital>Hospital</option>
                            <option value =pronearea>Prone Areas</option>
                            <option value =accplace>Accommodation Places</option>
                            <option value =geologist>Geologist</option>
                            <option value =socialmedia>Social Media</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td> </td>
                    <td><input type="submit" value="Sign Up" name="s1" /></td>
                </tr>
            </tbody>
        </table>
 </div>
   </form>
        </center>  
    </body>
    
</html>
