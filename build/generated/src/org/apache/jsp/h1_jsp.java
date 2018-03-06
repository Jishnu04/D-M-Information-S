package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class h1_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/headqua.jsp");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
 Class.forName("com.mysql.jdbc.Driver"); 
      out.write('\n');
 
   int e1=2;
  Connection connection = null;
  connection =DriverManager.getConnection("jdbc:mysql://localhost:3306/dmis","root","123456789");
  PreparedStatement sm=connection.prepareStatement("UPDATE facilities SET message =? WHERE category=? AND user_name=?");
  PreparedStatement t1=connection.prepareStatement("SELECT ff.user_name,station,mail_id,chief,latitude,longitude,staff,engine,capacity,statu,last_update from fire_force ff,facilities f where f.category='F' AND ff.user_name=f.user_name");
  PreparedStatement t2=connection.prepareStatement("SELECT p.user_name,mail_id,lattitude,longitude,location,p.category,staff,engine,capacity,statu,last_update from volunteer p,facilities f where f.category='V' AND p.user_name=f.user_name;");
  PreparedStatement t3=connection.prepareStatement("SELECT h.user_name,mail_id,lattitude,longitude,h.category,name,staff,engine,capacity,statu,last_update from hospital h,facilities f where f.category='H' AND h.user_name=f.user_name;");
  PreparedStatement t4=connection.prepareStatement("SELECT p.user_name,location,lattitude,longitude,landform,staff,engine,capacity,statu,last_update from pronearea p,facilities f where f.category='P' AND p.user_name=f.user_name;");
  PreparedStatement t5=connection.prepareStatement("SELECT a.user_name,building,lattitude,longitude,i_name,mail_id,staff,engine,capacity,statu,last_update from accommodation a,facilities f where f.category='A' AND a.user_name=f.user_name;");
  PreparedStatement t6=connection.prepareStatement("SELECT a.user_name,mail_id,latitude,longitude,address,engine,capacity,statu,last_update from geologist a,facilities f where f.category='G' AND a.user_name=f.user_name;");
  PreparedStatement t7=connection.prepareStatement("SELECT a.user_name,c_name,latitude,longitude,mail_id,address,staff,engine,capacity,statu,last_update from `socialmedia` a,facilities f where f.category='S' AND a.user_name=f.user_name;");
   ResultSet rst=null;
  if(request.getParameter("send")!=null)
  {
      sm.setString(1,request.getParameter("m"));
      sm.setString(2,request.getParameter("D"));
      sm.setString(3,request.getParameter("un"));
      e1=sm.executeUpdate();
  }
  
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("         <link rel=\"stylesheet\" type=\"text/css\" href=\"apply.css\">\n");
      out.write("        <title>HQ </title>\n");
      out.write("    </head>\n");
      out.write("    <body onload =\"message()\">\n");
      out.write("        <h1 align=\"center\"> HEADQUARTERS  </h1>\n");
      out.write("       \n");
      out.write("         <a href=\"h2.jsp\" style=\"color: #98FB98\" > NEAREST SERVICE FINDER </a>\n");
      out.write("        <form name=\"msg\" action=\"headqua.jsp\" method=\"POST\">\n");
      out.write("            <table border=\"1\">\n");
      out.write("                <tbody>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Enter Message : </td>\n");
      out.write("                        <td><textarea name=\"m\" rows=\"5\" cols=\"50\">\n");
      out.write("                            </textarea></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Select Dept : <select name=\"D\">\n");
      out.write("                            <option value =F>Fire Force</option>\n");
      out.write("                            <option value =V>Volunteer Agency</option>\n");
      out.write("                            <option value =H>Hospital</option>\n");
      out.write("                            <option value =P>Prone Areas</option>\n");
      out.write("                            <option value =A>Accommodation Places</option>\n");
      out.write("                            <option value =S>Social Media</option>\n");
      out.write("                        </select></td>\n");
      out.write("                        <td>Username : <input type=\"text\" name=\"un\" value=\"\" /></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td><input type=\"reset\" value=\"Clear\" name=\"clear\" /></td>\n");
      out.write("                        <td><input type=\"submit\" value=\"Send\" name=\"send\" /></td>\n");
      out.write("                    </tr>\n");
      out.write("                </tbody>\n");
      out.write("            </table>\n");
      out.write("        </form>\n");
      out.write("         <form name=\"tb\" action=\"h1.jsp\">\n");
      out.write("           <input type=\"submit\" value=\"Fire Force\" name=\"tab\" /> \n");
      out.write("            <input type=\"submit\" value=\"Volunteer\" name=\"tab\" />\n");
      out.write("            <input type=\"submit\" value=\"Hospital\" name=\"tab\" />\n");
      out.write("            <input type=\"submit\" value=\"Prone Area\" name=\"tab\" />\n");
      out.write("            <input type=\"submit\" value=\"Accomadation Places\" name=\"tab\" />\n");
      out.write("            <input type=\"submit\" value=\"Geologist\" name=\"tab\" />\n");
      out.write("            <input type=\"submit\" value=\"Social Media\" name=\"tab\" />\n");
      out.write("            \n");
      out.write("        </form>\n");
      out.write("        \n");
      out.write("        <script type=\"text/javascript\" >\n");
      out.write("    function message()\n");
      out.write("    {\n");
      out.write("        var s =");
      out.print(e1 );
      out.write(";\n");
      out.write("        if(s==1)\n");
      out.write("        alert(\"Message Sent successfully\");\n");
      out.write("        else if(s==0)\n");
      out.write("            alert(\"Sending Failed\");\n");
      out.write("    }\n");
      out.write("</script>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write(' ');
      out.write('\n');

    String s=request.getParameter("tab");
  if(s.equals("Fire Force")) 
  {  
        rst=t1.executeQuery() ;
        
      out.write("\n");
      out.write("        <h2> FIRE FORCE </h2>\n");
      out.write("        <table border=\"1\">\n");
      out.write("            <thead>\n");
      out.write("                <tr>\n");
      out.write("                    <th>USER NAME</th>\n");
      out.write("                    <th>STATION</th>\n");
      out.write("                    <th>MAIL ID</th>\n");
      out.write("                    <th>CHEIF OFFICER</th>\n");
      out.write("                    <th>LATTITUDE</th>\n");
      out.write("                    <th>LONGITUDE</th>\n");
      out.write("                    <th>NO. OF STAFF</th>\n");
      out.write("                    <th>ENGINES COUNT</th>\n");
      out.write("                    <th>SERVICES PROVIDE</th>\n");
      out.write("                    <th>STATUS</th>\n");
      out.write("                    <th>LAST UPDATE</th>\n");
      out.write("                </tr>\n");
      out.write("            </thead>\n");
      out.write("            <tbody>\n");
      out.write("            ");
while(rst.next()) { 
      out.write("    \n");
      out.write("                <tr>\n");
      out.write("                    <td> ");
      out.print(rst.getString("user_name") );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print(rst.getString("station") );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print(rst.getString("mail_id") );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print(rst.getString("chief") );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print(rst.getString("latitude") );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print(rst.getString("longitude") );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print(rst.getString("staff") );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print(rst.getString("engine") );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print(rst.getString("capacity") );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print(rst.getString("statu") );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print(rst.getString("last_update") );
      out.write("</td>\n");
      out.write("                </tr>\n");
      out.write("                   ");
}
      out.write("\n");
      out.write("            </tbody>\n");
      out.write("        </table>\n");
      out.write("            ");

     }

     if(s.equals("Volunteer")) 
     {
         
        rst=t2.executeQuery();
        
      out.write("\n");
      out.write("        <h2> VOLUNTEER AGENCY </h2>\n");
      out.write("        <table border=\"1\">\n");
      out.write("            <thead>\n");
      out.write("                <tr>\n");
      out.write("                    <th>USER NAME</th>\n");
      out.write("                     <th>MAIL ID</th>\n");
      out.write("                    <th>LATTITUDE</th>\n");
      out.write("                    <th>LONGITUDE</th>\n");
      out.write("                    <th>CATEGORY</th>\n");
      out.write("                    <th>NO. OF VOLUNTEER</th>\n");
      out.write("                    <th>TRANSPORTATION FACILITIES</th>\n");
      out.write("                    <th>SERVICES PROVIDE</th>\n");
      out.write("                    <th>STATUS</th>\n");
      out.write("                    <th>LAST UPDATE</th>\n");
      out.write("                </tr>\n");
      out.write("            </thead>\n");
      out.write("            <tbody>\n");
      out.write("            ");
while(rst.next()) { 
      out.write("    \n");
      out.write("                <tr>\n");
      out.write("                    <td> ");
      out.print(rst.getString("user_name") );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print(rst.getString("mail_id") );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print(rst.getString("lattitude") );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print(rst.getString("longitude") );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print(rst.getString("category") );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print(rst.getString("staff") );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print(rst.getString("engine") );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print(rst.getString("capacity") );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print(rst.getString("statu") );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print(rst.getString("last_update") );
      out.write("</td>\n");
      out.write("                </tr>\n");
      out.write("                     ");
}
      out.write("\n");
      out.write("            </tbody>\n");
      out.write("        </table>\n");


     } 
if(s.equals("Hospital")) 
     {
         
        rst=t3.executeQuery();
        
      out.write("\n");
      out.write("        <h2> HOSPITAL </h2>\n");
      out.write("        <table border=\"1\">\n");
      out.write("            <thead>\n");
      out.write("                <tr>\n");
      out.write("                    <th>USER NAME</th>\n");
      out.write("                     <th>MAIL ID</th>\n");
      out.write("                    <th>LATTITUDE</th>\n");
      out.write("                    <th>LONGITUDE</th>\n");
      out.write("                    <th>CATEGORY</th>\n");
      out.write("                    <th>NO. OF VOLUNTEER</th>\n");
      out.write("                    <th>TRANSPORTATION FACILITIES</th>\n");
      out.write("                    <th>SERVICES PROVIDE</th>\n");
      out.write("                    <th>STATUS</th>\n");
      out.write("                    <th>LAST UPDATE</th>\n");
      out.write("                </tr>\n");
      out.write("            </thead>\n");
      out.write("            <tbody>\n");
      out.write("            ");
while(rst.next()) { 
      out.write("    \n");
      out.write("                <tr>\n");
      out.write("                    <td> ");
      out.print(rst.getString("user_name") );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print(rst.getString("mail_id") );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print(rst.getString("lattitude") );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print(rst.getString("longitude") );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print(rst.getString("category") );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print(rst.getString("staff") );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print(rst.getString("engine") );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print(rst.getString("capacity") );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print(rst.getString("statu") );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print(rst.getString("last_update") );
      out.write("</td>\n");
      out.write("                </tr>\n");
      out.write("                     ");
}
      out.write("\n");
      out.write("            </tbody>\n");
      out.write("        </table>\n");


     } 
if(s.equals("Prone Area")) 
     {
         
        rst=t4.executeQuery(); 
        
      out.write("\n");
      out.write("        <h2> PRONE AREAS </h2>\n");
      out.write("        <table border=\"1\">\n");
      out.write("            <thead>\n");
      out.write("                <tr>\n");
      out.write("                  \n");
      out.write("                    <th>USER NAME</th>\n");
      out.write("                     <th>LOCATION</th>\n");
      out.write("                    <th>LATTITUDE</th>\n");
      out.write("                    <th>LONGITUDE</th>\n");
      out.write("                    <th>lANDFORM</th>\n");
      out.write("                    <th>BODY MEMBER</th>\n");
      out.write("                    <th>MIGRATION FACILITIES</th>\n");
      out.write("                    <th>DENSITY</th>\n");
      out.write("                    <th>STATUS</th>\n");
      out.write("                    <th>LAST UPDATE</th>\n");
      out.write("                </tr>\n");
      out.write("            </thead>\n");
      out.write("            <tbody>\n");
      out.write("            ");
while(rst.next()) { 
      out.write("    \n");
      out.write("                <tr>\n");
      out.write("                    <td> ");
      out.print(rst.getString("user_name") );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print(rst.getString("location") );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print(rst.getString("lattitude") );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print(rst.getString("longitude") );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print(rst.getString("landform") );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print(rst.getString("staff") );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print(rst.getString("engine") );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print(rst.getString("capacity") );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print(rst.getString("statu") );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print(rst.getString("last_update") );
      out.write("</td>\n");
      out.write("                </tr>\n");
      out.write("                     ");
}
      out.write("\n");
      out.write("            </tbody>\n");
      out.write("        </table>\n");


     } 
if(s.equals("Accomadation Places")) 
     {
        
        rst=t5.executeQuery(); 
        
      out.write("\n");
      out.write("        <h2> ACCOMADATION PLACES </h2>\n");
      out.write("        <table border=\"1\">\n");
      out.write("            <thead>\n");
      out.write("                <tr>\n");
      out.write("                  \n");
      out.write("                    <th>USER NAME</th>\n");
      out.write("                     <th>BUILDING</th>\n");
      out.write("                    <th>LATTITUDE</th>\n");
      out.write("                    <th>LONGITUDE</th>\n");
      out.write("                    <th>INCHARGE MEMBER</th>\n");
      out.write("                    <th>MAIL ID</th>\n");
      out.write("                    <th>SERVICE MEMBER</th>\n");
      out.write("                     <th>TRANSPORTATION FACILITES</th>\n");
      out.write("                    <th>CAPACITY</th>\n");
      out.write("                    <th>STATUS</th>\n");
      out.write("                    <th>LAST UPDATE</th>\n");
      out.write("                </tr>\n");
      out.write("            </thead>\n");
      out.write("            <tbody>\n");
      out.write("            ");
while(rst.next()) { 
      out.write("    \n");
      out.write("                <tr>\n");
      out.write("                    <td> ");
      out.print(rst.getString("user_name") );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print(rst.getString("building") );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print(rst.getString("lattitude") );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print(rst.getString("longitude") );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print(rst.getString("i_name") );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print(rst.getString("mail_id") );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print(rst.getString("staff") );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print(rst.getString("engine") );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print(rst.getString("capacity") );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print(rst.getString("statu") );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print(rst.getString("last_update") );
      out.write("</td>\n");
      out.write("                </tr>\n");
      out.write("                     ");
}
      out.write("\n");
      out.write("            </tbody>\n");
      out.write("        </table>\n");

 
     } 
if(s.equals("Geologist")) 
     {
        
        rst=t6.executeQuery(); 
        
      out.write("\n");
      out.write("        <h2> GEOLOGIST </h2>\n");
      out.write("        <table border=\"1\">\n");
      out.write("            <thead>\n");
      out.write("                <tr>\n");
      out.write("                  \n");
      out.write("                  \n");
      out.write("                    <th>USER NAME</th>\n");
      out.write("                     <th>MAIL ID</th>\n");
      out.write("                    <th>LATTITUDE</th>\n");
      out.write("                    <th>LONGITUDE</th>\n");
      out.write("                    <th>INCHARGE MEMBER</th>\n");
      out.write("                    <th>ADDRESS</th>\n");
      out.write("                    <th>STAFF</th>\n");
      out.write("                     <th>EQUIPMENT FACILITES</th>\n");
      out.write("                    <th>AREA COVERED</th>\n");
      out.write("                    <th>STATUS</th>\n");
      out.write("                    <th>LAST UPDATE</th>\n");
      out.write("                </tr>\n");
      out.write("            </thead>\n");
      out.write("            <tbody>\n");
      out.write("            ");
while(rst.next()) { 
      out.write("    \n");
      out.write("                <tr> \n");
      out.write("                    <td> ");
      out.print(rst.getString("user_name") );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print(rst.getString("mail_id") );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print(rst.getString("latitude") );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print(rst.getString("longitude") );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print(rst.getString("address") );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print(rst.getString("engine") );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print(rst.getString("capacity") );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print(rst.getString("statu") );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print(rst.getString("last_update") );
      out.write("</td>\n");
      out.write("                </tr>\n");
      out.write("                     ");
}
      out.write("\n");
      out.write("            </tbody>\n");
      out.write("        </table>\n");

 
     } 
if(s.equals("Social Media")) 
     {
        
        rst=t7.executeQuery(); 
        
      out.write("\n");
      out.write("        <h2> SOCIAL MEDIA </h2>\n");
      out.write("        <table border=\"1\">\n");
      out.write("            <thead>\n");
      out.write("                <tr>\n");
      out.write("                          \n");
      out.write("                    <th>USER NAME</th>\n");
      out.write("                     <th>MAIL ID</th>\n");
      out.write("                    <th>LATTITUDE</th>\n");
      out.write("                    <th>LONGITUDE</th>\n");
      out.write("                    <th>ADDRESS</th>\n");
      out.write("                    <th>STAFF</th>\n");
      out.write("              \n");
      out.write("                    <th>SATELLITES OWNED</th>\n");
      out.write("                    <th>AREA COVERED</th>\n");
      out.write("                    <th>STATUS</th>\n");
      out.write("                    <th>LAST UPDATE</th>\n");
      out.write("                </tr>\n");
      out.write("            </thead>\n");
      out.write("            <tbody>\n");
      out.write("            ");
while(rst.next()) { 
      out.write("    \n");
      out.write("                <tr> \n");
      out.write("                    <td> ");
      out.print(rst.getString("user_name") );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print(rst.getString("mail_id") );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print(rst.getString("latitude") );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print(rst.getString("longitude") );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print(rst.getString("address") );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print(rst.getString("staff") );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print(rst.getString("engine") );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print(rst.getString("capacity") );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print(rst.getString("statu") );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print(rst.getString("last_update") );
      out.write("</td>\n");
      out.write("                </tr>\n");
      out.write("                     ");
}
      out.write("\n");
      out.write("            </tbody>\n");
      out.write("        </table>\n");

 
     } 

     
      out.write("\n");
      out.write("  \n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
