package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Table.hospital;
import java.sql.*;
import java.util.Date;

public final class hospital_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("  \n");
      out.write("\n");
      out.write("\n");
 Class.forName("com.mysql.jdbc.Driver"); 
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");

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
    Date date = new Date() ;
    Timestamp timestamp = new Timestamp(date.getTime()); 
    hospital h =new hospital(); 
   r=h.Sethospital(un,pw1,mid,cno,f1,f2,cat,h_name,addr,staff,ambu,capa,timestamp);  
    }
    }
   
      out.write("\n");
      out.write("\n");
      out.write("   \n");
      out.write("<!DOCTYPE html> \n");
      out.write("\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"newcss.css\">\n");
      out.write("        <title>Hospital</title>\n");
      out.write("    </head>\n");
      out.write("    \n");
      out.write("<body onload=\"display()\">\n");
      out.write("    <h1>Fill the Form to Register : </h1>\n");
      out.write("        <form name=\"myform\" action=\"hospital.jsp\" method=\"POST\">\n");
      out.write("            <table border=\"1\">\n");
      out.write("                <tbody>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>User name : </td>\n");
      out.write("                        <td><input type=\"text\" name=\"username\" value=\"\" size=\"50\" /></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Password  :</td>\n");
      out.write("                        <td><input type=\"password\" name=\"pw1\" value=\"\" size=\"50\" /></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Re-type Password :</td>\n");
      out.write("                        <td><input type=\"password\" name=\"pw2\" value=\"\" size=\"50\" /></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Mail_id :</td>\n");
      out.write("                        <td><input type=\"text\" name=\"mid\" value=\"\" size=\"50\" /></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Contact no :</td>\n");
      out.write("                        <td><input type=\"text\" name=\"cno\" value=\"\" size=\"50\" /></td>\n");
      out.write("                    </tr>\n");
      out.write("                     <tr>\n");
      out.write("                        <td>GPS Coordinates :</td>\n");
      out.write("                        <td><input type=\"text\" name=\"lat\" value=\"\" size=\"24\" /> <input type=\"text\" name=\"long\" value=\"\" size=\"24\" /></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Category :</td>\n");
      out.write("                        <td><select name=\"cat\">\n");
      out.write("                                <option value =\"private\">PRIVATE</option>\n");
      out.write("                                <option value =\"govt\">GOVT</option>\n");
      out.write("                                <option value =\"co-op\">COOPERATIVE</option>\n");
      out.write("                            </select></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Name :</td>\n");
      out.write("                        <td><input type=\"text\" name=\"h_name\" value=\"\" size=\"50\" /></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Address:</td>\n");
      out.write("                        <td><input type=\"text\" name=\"addr\" value=\"\" size=\"50\" /></td>\n");
      out.write("                    </tr>\n");
      out.write("                   \n");
      out.write("                      <tr>\n");
      out.write("                        <td>Numbers of Staff</td>\n");
      out.write("                        <td><input type=\"text\" name=\"staff\" value=\"\" size=\"50\" /></td>\n");
      out.write("                    </tr>\n");
      out.write("                      <tr>\n");
      out.write("                        <td>Number of Ambulances :</td>\n");
      out.write("                        <td><input type=\"text\" name=\"ambu\" value=\"\" size=\"50\" /></td>\n");
      out.write("                    </tr>\n");
      out.write("                     <tr>\n");
      out.write("                        <td>Capacity :</td>\n");
      out.write("                        <td><input type=\"text\" name=\"capa\" value=\"\" size=\"50\" /></td>\n");
      out.write("                    </tr>\n");
      out.write("                </tbody>\n");
      out.write("            </table>\n");
      out.write("            <input type=\"reset\" value=\"Clear\" name=\"clear\" />\n");
      out.write("            <input type=\"submit\" value=\"Submit\" name=\"submit\" />\n");
      out.write("        </form>\n");
      out.write("    <a href=\"index.jsp\">BACK</a>\n");
      out.write("  <script type=\"text/javascript\" >\n");
      out.write("    function display()\n");
      out.write("    {\n");
      out.write("        var s =");
      out.print(r );
      out.write(";\n");
      out.write("        if(s==1)\n");
      out.write("        alert(\"Registered successfully\");\n");
      out.write("        else if(s==2)\n");
      out.write("            alert(\"Username Field is empty\");\n");
      out.write("         else if(s==3)\n");
      out.write("            alert(\"Password Mismatch\"); \n");
      out.write("        else if(s==4)\n");
      out.write("            alert(\"Password field cannot be empty\");\n");
      out.write("         else if(s==5)\n");
      out.write("            alert(\"Mail id cannot be empty\");\n");
      out.write("         else if(s==6)\n");
      out.write("            alert(\"Contact no is be empty\");\n");
      out.write("         else if(s==7)\n");
      out.write("            alert(\"Coordinates cannot be empty\");\n");
      out.write("         else if(s==9)\n");
      out.write("            alert(\"hospital name is  empty\");\n");
      out.write("         else if(s==10)\n");
      out.write("            alert(\"address is empty\");\n");
      out.write("    }\n");
      out.write("</script>\n");
      out.write("</body>\n");
      out.write("    \n");
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
