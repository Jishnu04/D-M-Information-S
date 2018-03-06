package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Table.fireforce;
import java.sql.*;
import java.util.Date;

public final class lfireforce_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
 Class.forName("com.mysql.jdbc.Driver"); 
      out.write('\n');
      out.write('\n');
  
    ResultSet rs1=null;
    int f=0;
    fireforce ff = new fireforce ();
    String user = new String ();
     try
    {
    rs1=ff.returnlog();   
   
    rs1.next(); 
    user =rs1.getString("user_name");

    }
    catch (SQLException e)
    {
       
    }
    
   if(request.getParameter("DA")!=null)
    {
        response.sendRedirect("http://localhost:8080/GIL/delete/ff.jsp");
        
    }
   if(request.getParameter("lt")!=null)
    {
       
        response.sendRedirect("http://localhost:8080/GIL/index.jsp");
         ff.logout(user);
    }
   if(request.getParameter("UF")!=null)
    {
     ff.updatefact(request.getParameter("n1"),request.getParameter("n2"),request.getParameter("n2"),user);
     f=1;
    }
   if(request.getParameter("us")!=null)
    {
     ff.updatestat(request.getParameter("n3"),user);
     f=2;
    }
   if(request.getParameter("rf")!=null)
        {
                rs1=ff.returnstm(user);
                     rs1.next();
       } 
    
      out.write("\n");
      out.write("    \n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"newcss.css\">\n");
      out.write("        <title>Fire Force Session</title>\n");
      out.write("    </head>\n");
      out.write("    <body onload=\"display1()\">\n");
      out.write("        <h1>status</h1>\n");
      out.write("        <form name=\"updateform1\" action=\"lfireforce.jsp\">\n");
      out.write("            <table border=\"1\">\n");
      out.write("\n");
      out.write("                <tbody>\n");
      out.write("                    <tr>\n");
      out.write("                        \n");
      out.write("                     ");
 
                           rs1=ff.returnstm(user);
                             rs1.next(); 
                        
      out.write("\n");
      out.write("                        <td>Your Current Status  :</td>\n");
      out.write("                        <td>");
      out.print(rs1.getString("statu"));
      out.write("</td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("     \n");
      out.write("                        <td>Message From Head Quarters : </td>\n");
      out.write("                        <td>");
      out.print(rs1.getString("message"));
      out.write("</td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Refresh to get Latest Messages</td>\n");
      out.write("                        <td><input type=\"submit\" value=\"Refresh\" name=\"rf\" /></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td></td>\n");
      out.write("                        <td>Update your Avaiability and Status</td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Staff Available   :</td>\n");
      out.write("                        <td><input type=\"text\" name=\"n1\" value=\"\" size=\"50\" /></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Engines Available   :</td>\n");
      out.write("                        <td><input type=\"text\" name=\"n2\" value=\"\" size=\"50\" /></td>\n");
      out.write("                    </tr>\n");
      out.write("                     <tr>\n");
      out.write("                        <td>Services Provide   :</td>\n");
      out.write("                        <td><input type=\"text\" name=\"n7\" value=\"\" size=\"50\" /></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td></td>\n");
      out.write("                        <td><input type=\"submit\" value=\"Update Availablity\" name=\"UF\" /></td>\n");
      out.write("                    </tr>\n");
      out.write("                     <tr>\n");
      out.write("                        <td>Update your status here   :</td>\n");
      out.write("                        <td><input type=\"text\" name=\"n3\" value=\"\" size=\"120\" /></td>\n");
      out.write("                    </tr>\n");
      out.write("                     <tr>\n");
      out.write("                        <td> <input type=\"reset\" value=\"Clear\" name=\"clear\" /></td>\n");
      out.write("                        <td><input type=\"submit\" value=\"Update Status\" name=\"us\" /></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td><input type=\"submit\" value=\"Deactivate the account\" name=\"DA\" /></td>\n");
      out.write("                        <td> <input type=\"submit\" value=\"Logout\" name=\"lt\" /></td>\n");
      out.write("                    </tr>\n");
      out.write("                \n");
      out.write("                </tbody>\n");
      out.write("            </table>\n");
      out.write("\n");
      out.write(" \n");
      out.write("            \n");
      out.write("           \n");
      out.write("           \n");
      out.write("            \n");
      out.write("            \n");
      out.write("        </form> \n");
      out.write("      <script type=\"text/javascript\" >\n");
      out.write("    function display1()\n");
      out.write("    {\n");
      out.write("        var s=");
      out.print(f);
      out.write("\n");
      out.write("        if(s==1)\n");
      out.write("            alert(\"Updated successfully\");\n");
      out.write("        if(s==2)\n");
      out.write("            alert(\"Status Changed\")\n");
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
