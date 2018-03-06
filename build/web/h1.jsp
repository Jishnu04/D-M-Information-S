<%@include file="headqua.jsp" %> 
<%
    String s=request.getParameter("tab");
  if(s.equals("Fire Force")) 
  {  
        rst=t1.executeQuery() ;
        %>
        <h2> FIRE FORCE </h2>
        <table border="1">
            <thead>
                <tr>
                    <th>USER NAME</th>
                    <th>STATION</th>
                    <th>MAIL ID</th>
                    <th>CHEIF OFFICER</th>
                    <th>LATTITUDE</th>
                    <th>LONGITUDE</th>
                    <th>NO. OF STAFF</th>
                    <th>ENGINES COUNT</th>
                    <th>SERVICES PROVIDE</th>
                    <th>STATUS</th>
                    <th>LAST UPDATE</th>
                </tr>
            </thead>
            <tbody>
            <%while(rst.next()) { %>    
                <tr>
                    <td> <%=rst.getString("user_name") %></td>
                    <td><%=rst.getString("station") %></td>
                    <td><%=rst.getString("mail_id") %></td>
                    <td><%=rst.getString("chief") %></td>
                    <td><%=rst.getString("latitude") %></td>
                    <td><%=rst.getString("longitude") %></td>
                    <td><%=rst.getString("staff") %></td>
                    <td><%=rst.getString("engine") %></td>
                    <td><%=rst.getString("capacity") %></td>
                    <td><%=rst.getString("statu") %></td>
                    <td><%=rst.getString("last_update") %></td>
                </tr>
                   <%}%>
            </tbody>
        </table>
            <%
     }

     if(s.equals("Volunteer")) 
     {
         
        rst=t2.executeQuery();
        %>
        <h2> VOLUNTEER AGENCY </h2>
        <table border="1">
            <thead>
                <tr>
                    <th>USER NAME</th>
                     <th>MAIL ID</th>
                    <th>LATTITUDE</th>
                    <th>LONGITUDE</th>
                    <th>CATEGORY</th>
                    <th>NO. OF VOLUNTEER</th>
                    <th>TRANSPORTATION FACILITIES</th>
                    <th>SERVICES PROVIDE</th>
                    <th>STATUS</th>
                    <th>LAST UPDATE</th>
                </tr>
            </thead>
            <tbody>
            <%while(rst.next()) { %>    
                <tr>
                    <td> <%=rst.getString("user_name") %></td>
                    <td><%=rst.getString("mail_id") %></td>
                    <td><%=rst.getString("lattitude") %></td>
                    <td><%=rst.getString("longitude") %></td>
                    <td><%=rst.getString("category") %></td>
                    <td><%=rst.getString("staff") %></td>
                    <td><%=rst.getString("engine") %></td>
                    <td><%=rst.getString("capacity") %></td>
                    <td><%=rst.getString("statu") %></td>
                    <td><%=rst.getString("last_update") %></td>
                </tr>
                     <%}%>
            </tbody>
        </table>
<%

     } 
if(s.equals("Hospital")) 
     {
         
        rst=t3.executeQuery();
        %>
        <h2> HOSPITAL </h2>
        <table border="1">
            <thead>
                <tr>
                    <th>USER NAME</th>
                     <th>MAIL ID</th>
                    <th>LATTITUDE</th>
                    <th>LONGITUDE</th>
                    <th>CATEGORY</th>
                    <th>NO. OF VOLUNTEER</th>
                    <th>TRANSPORTATION FACILITIES</th>
                    <th>SERVICES PROVIDE</th>
                    <th>STATUS</th>
                    <th>LAST UPDATE</th>
                </tr>
            </thead>
            <tbody>
            <%while(rst.next()) { %>    
                <tr>
                    <td> <%=rst.getString("user_name") %></td>
                    <td><%=rst.getString("mail_id") %></td>
                    <td><%=rst.getString("lattitude") %></td>
                    <td><%=rst.getString("longitude") %></td>
                    <td><%=rst.getString("category") %></td>
                    <td><%=rst.getString("staff") %></td>
                    <td><%=rst.getString("engine") %></td>
                    <td><%=rst.getString("capacity") %></td>
                    <td><%=rst.getString("statu") %></td>
                    <td><%=rst.getString("last_update") %></td>
                </tr>
                     <%}%>
            </tbody>
        </table>
<%

     } 
if(s.equals("Prone Area")) 
     {
         
        rst=t4.executeQuery(); 
        %>
        <h2> PRONE AREAS </h2>
        <table border="1">
            <thead>
                <tr>
                  
                    <th>USER NAME</th>
                     <th>LOCATION</th>
                    <th>LATTITUDE</th>
                    <th>LONGITUDE</th>
                    <th>lANDFORM</th>
                    <th>BODY MEMBER</th>
                    <th>MIGRATION FACILITIES</th>
                    <th>DENSITY</th>
                    <th>STATUS</th>
                    <th>LAST UPDATE</th>
                </tr>
            </thead>
            <tbody>
            <%while(rst.next()) { %>    
                <tr>
                    <td> <%=rst.getString("user_name") %></td>
                    <td><%=rst.getString("location") %></td>
                    <td><%=rst.getString("lattitude") %></td>
                    <td><%=rst.getString("longitude") %></td>
                    <td><%=rst.getString("landform") %></td>
                    <td><%=rst.getString("staff") %></td>
                    <td><%=rst.getString("engine") %></td>
                    <td><%=rst.getString("capacity") %></td>
                    <td><%=rst.getString("statu") %></td>
                    <td><%=rst.getString("last_update") %></td>
                </tr>
                     <%}%>
            </tbody>
        </table>
<%

     } 
if(s.equals("Accomadation Places")) 
     {
        
        rst=t5.executeQuery(); 
        %>
        <h2> ACCOMADATION PLACES </h2>
        <table border="1">
            <thead>
                <tr>
                  
                    <th>USER NAME</th>
                     <th>BUILDING</th>
                    <th>LATTITUDE</th>
                    <th>LONGITUDE</th>
                    <th>INCHARGE MEMBER</th>
                    <th>MAIL ID</th>
                    <th>SERVICE MEMBER</th>
                     <th>TRANSPORTATION FACILITES</th>
                    <th>CAPACITY</th>
                    <th>STATUS</th>
                    <th>LAST UPDATE</th>
                </tr>
            </thead>
            <tbody>
            <%while(rst.next()) { %>    
                <tr>
                    <td> <%=rst.getString("user_name") %></td>
                    <td><%=rst.getString("building") %></td>
                    <td><%=rst.getString("lattitude") %></td>
                    <td><%=rst.getString("longitude") %></td>
                    <td><%=rst.getString("i_name") %></td>
                    <td><%=rst.getString("mail_id") %></td>
                    <td><%=rst.getString("staff") %></td>
                    <td><%=rst.getString("engine") %></td>
                    <td><%=rst.getString("capacity") %></td>
                    <td><%=rst.getString("statu") %></td>
                    <td><%=rst.getString("last_update") %></td>
                </tr>
                     <%}%>
            </tbody>
        </table>
<%
 
     } 
if(s.equals("Geologist")) 
     {
        
        rst=t6.executeQuery(); 
        %>
        <h2> GEOLOGIST </h2>
        <table border="1">
            <thead>
                <tr>
                  
                  
                    <th>USER NAME</th>
                     <th>MAIL ID</th>
                    <th>LATTITUDE</th>
                    <th>LONGITUDE</th>
          
                    <th>ADDRESS</th>
                    <th>STAFF</th>
                     <th>EQUIPMENT FACILITES</th>
                    <th>AREA COVERED</th>
                    <th>STATUS</th>
                    <th>LAST UPDATE</th>
                </tr>
            </thead>
            <tbody>
            <%while(rst.next()) { %>    
                <tr> 
                    <td> <%=rst.getString("user_name") %></td>
                    <td><%=rst.getString("mail_id") %></td>
                    <td><%=rst.getString("latitude") %></td>
                    <td><%=rst.getString("longitude") %></td>
 
                    <td><%=rst.getString("address") %></td>
                    <td><%=rst.getString("staff") %></td>
                    <td><%=rst.getString("engine") %></td>
                    <td><%=rst.getString("capacity") %></td>
                    <td><%=rst.getString("statu") %></td>
                    <td><%=rst.getString("last_update") %></td>
                </tr>
                     <%}%>
            </tbody>
        </table>
<%
 
     } 
if(s.equals("Social Media")) 
     {
        
        rst=t7.executeQuery(); 
        %>
        <h2> SOCIAL MEDIA </h2>
        <table border="1">
            <thead>
                <tr>
                          
                    <th>USER NAME</th>
                     <th>MAIL ID</th>
                    <th>LATTITUDE</th>
                    <th>LONGITUDE</th>
                    <th>ADDRESS</th>
                    <th>STAFF</th>
              
                    <th>SATELLITES OWNED</th>
                    <th>AREA COVERED</th>
                    <th>STATUS</th>
                    <th>LAST UPDATE</th>
                </tr>
            </thead>
            <tbody>
            <%while(rst.next()) { %>    
                <tr> 
                    <td> <%=rst.getString("user_name") %></td>
                    <td><%=rst.getString("mail_id") %></td>
                    <td><%=rst.getString("latitude") %></td>
                    <td><%=rst.getString("longitude") %></td>
                    <td><%=rst.getString("address") %></td>
                    <td><%=rst.getString("staff") %></td>
                    <td><%=rst.getString("engine") %></td>
                    <td><%=rst.getString("capacity") %></td>
                    <td><%=rst.getString("statu") %></td>
                    <td><%=rst.getString("last_update") %></td>
                </tr>
                     <%}%>
            </tbody>
        </table>
<%
 
     } 

     %>
  
