package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class headqua_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

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
      response.setContentType("text/html;charset=UTF-8");
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
  PreparedStatement t6=connection.prepareStatement("SELECT a.user_name,mail_id,latitude,longitude,address,staff,engine,capacity,statu,last_update from geologist a,facilities f where f.category='G' AND a.user_name=f.user_name;");
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
      out.write("         <a href=\"h2.jsp\" style=\"color: #98FB98\" > NEAREST SERVICE FINDER(link) </a>\n");
      out.write("         \n");
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
      out.write("        <a href=\"index.jsp\" style=\"color: #98FB98\" > BACK </a>\n");
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
