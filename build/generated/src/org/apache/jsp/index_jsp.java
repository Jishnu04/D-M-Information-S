package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>DMIS</title>\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"newcss.css\">\n");
      out.write("    </head>\n");
      out.write("    <body onload=\"displays()\">\n");
      out.write("        <h1 align=\"center\">DISASTER MANAGEMENT AND INFORMATION SYSTEM</h1>\n");
      out.write("        <h2>Register Your Service here</h2>\n");
      out.write("         <form name=\"myform1\" action=\"register.jsp\" method=\"POST\">\n");
      out.write("        <table border=\"0\">\n");
      out.write("            <tbody >\n");
      out.write("                <tr>\n");
      out.write("                    <td>Objective : </td>\n");
      out.write("                    <td><input type=\"text\" name=\"N1\" value=\"\" /></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>Select category :</td>\n");
      out.write("                    <td><select name=\"D1\">\n");
      out.write("                            <option value =fireforce>Fire Force</option>\n");
      out.write("                            <option value =volagency>Volunteer Agency</option>\n");
      out.write("                            <option value =hospital>Hospital</option>\n");
      out.write("                            <option value =pronearea>Prone Areas</option>\n");
      out.write("                            <option value =accplace>Accommodation Places</option>\n");
      out.write("                            <option value =geologist>Geologist</option>\n");
      out.write("                            <option value =socialmedia>Social Media</option>\n");
      out.write("                        </select>\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("            </tbody>\n");
      out.write("        </table>\n");
      out.write("<input type=\"submit\" value=\"Sign Up\" name=\"s1\" />\n");
      out.write("   </form>\n");
      out.write("        <h2>Login here</h2>\n");
      out.write("        <form name=\"myform2\" action=\"login.jsp\" method=\"POST\">\n");
      out.write("        <table border=\"0\">\n");
      out.write("            <tbody>\n");
      out.write("                <tr>\n");
      out.write("                    <td>Username : </td>\n");
      out.write("                    <td><input type=\"text\" name=\"N2\" value=\"\" /></td>\n");
      out.write("                </tr>\n");
      out.write("                 <tr>\n");
      out.write("                    <td>Password : </td>\n");
      out.write("                    <td><input type=\"password\" name=\"N3\" value=\"\" /></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>Select category :</td>\n");
      out.write("                    <td><select name=\"D2\">\n");
      out.write("                            <option value =fireforce>Fire Force</option>\n");
      out.write("                            <option value =volagency>Volunteer Agency</option>\n");
      out.write("                            <option value =hospital>Hospital</option>\n");
      out.write("                            <option value =pronearea>Prone Areas</option>\n");
      out.write("                            <option value =accplace>Accommodation Places</option>\n");
      out.write("                            <option value =geologist>Geologist</option>\n");
      out.write("                            <option value =socialmedia>Social Media</option>\n");
      out.write("                            <option value =admin>Head quarters </option>\n");
      out.write("                        </select>\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("            </tbody>\n");
      out.write("        </table>\n");
      out.write("<input type=\"submit\" value=\"Login\" name=\"s2\" />\n");
      out.write("   </form>\n");
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
