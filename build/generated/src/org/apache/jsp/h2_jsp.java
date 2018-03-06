package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import Table.*;

public final class h2_jsp extends org.apache.jasper.runtime.HttpJspBase
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

 double lat1 =Double.parseDouble("0.0");
 double lon1 =Double.parseDouble("0.0"); 
 double d =Double.parseDouble("0.0");
 DistanceCalculator D =new DistanceCalculator();
if(request.getParameter("s")!=null)
 {
  String s1=new String (request.getParameter("la"));
  String s2=new String (request.getParameter("lo"));
  String s3=new String (request.getParameter("d"));
  
 
 try
 {
 lat1 =Double.parseDouble(s1);
 lon1 =Double.parseDouble(s2); 
 d =Double.parseDouble(s3);
 }
 catch(NumberFormatException n)
 {
    lat1 =Double.parseDouble("0.0");
    lon1 =Double.parseDouble("0.0"); 
    d =Double.parseDouble("0.0");
 }
 }
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
   
    
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"apply.css\">\n");
      out.write("        <script src=\"http://maps.google.com/maps/api/js?sensor=false\" \n");
      out.write("      type=\"text/javascript\"></script>\n");
      out.write("        <title>LOCATER</title>\n");
      out.write("    </head>\n");
      out.write("    <body >\n");
      out.write("        <h1> NEAREST SERVICE  FINDER </h1>\n");
      out.write("        <a href=\"headqua.jsp\"> HQ </a>\n");
      out.write("        <form name=\"myform\" action=\"h2.jsp\" method=\"POST\">\n");
      out.write("           Latitude  :   <input type=\"text\" name=\"la\" value=\"\" />\n");
      out.write("           Longitude :   <input type=\"text\" name=\"lo\" value=\"\" />\n");
      out.write("           \n");
      out.write("           Maxicum Distance :<input type=\"text\" name=\"d\" value=\"\" />\n");
      out.write("           <input type=\"submit\" value=\"Submit\" name=\"s\" />\n");
      out.write("        </form>\n");
      out.write("        \n");
      out.write("        <h1> FIRE FORCE LOCATION</h1>\n");
      out.write("    <div id=\"map1\" style=\"width: 500px; height: 500px;\"></div>\n");
      out.write("    \n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("var map = new google.maps.Map(document.getElementById('map1'), {\n");
      out.write("    zoom: 10,\n");
      out.write("    center: new google.maps.LatLng(");
      out.print(lat1);
      out.write(',');
      out.print(lon1);
      out.write("),\n");
      out.write("    mapTypeId: google.maps.MapTypeId.ROADMAP\n");
      out.write("});\n");
      out.write("var infowindow = new google.maps.InfoWindow();\n");
      out.write("var marker, i;\n");

    rst=t1.executeQuery(); 
      while(rst.next())
      {
          double lat2 =rst.getDouble("latitude");
          double lon2=rst.getDouble("longitude");
          if(D.distance(lat1, lon1, lat2, lon2)<d)
          {
    
      out.write("\n");
      out.write("    marker = new google.maps.Marker({\n");
      out.write("        position: new google.maps.LatLng(");
      out.print(lat2);
      out.write(',');
      out.write(' ');
      out.print(lon2);
      out.write("),\n");
      out.write("        map: map\n");
      out.write("    });\n");
      out.write("    google.maps.event.addListener(marker, 'click', (function (marker, i) {\n");
      out.write("        return function () {\n");
      out.write("            infowindow.setContent(\"F\");\n");
      out.write("            infowindow.open(map, marker);\n");
      out.write("        };\n");
      out.write("    })(marker, i)); ");

}
}
      out.write("\n");
      out.write("</script>\n");
      out.write("\n");
      out.write("<h2> VOLUNTEER LOCATION</h2>\n");
      out.write("<div id=\"map2\" style=\"width: 500px; height: 500px;\"></div>\n");
      out.write("  <script type=\"text/javascript\">\n");
      out.write("var map = new google.maps.Map(document.getElementById('map2'), {\n");
      out.write("    zoom: 10,\n");
      out.write("    center: new google.maps.LatLng(");
      out.print(lat1);
      out.write(',');
      out.print(lon1);
      out.write("),\n");
      out.write("    mapTypeId: google.maps.MapTypeId.ROADMAP\n");
      out.write("});\n");
      out.write("var infowindow = new google.maps.InfoWindow();\n");
      out.write("var marker, i;\n");

    rst=t2.executeQuery(); 
      while(rst.next())
      {
          double lat2 =rst.getDouble("lattitude");
          double lon2=rst.getDouble("longitude");
          if(D.distance(lat1, lon1, lat2, lon2)<d)
          {
    
      out.write("\n");
      out.write("    marker = new google.maps.Marker({\n");
      out.write("        position: new google.maps.LatLng(");
      out.print(lat2);
      out.write(',');
      out.write(' ');
      out.print(lon2);
      out.write("),\n");
      out.write("        map: map\n");
      out.write("    });\n");
      out.write("    google.maps.event.addListener(marker, 'click', (function (marker, i) {\n");
      out.write("        return function () {\n");
      out.write("            infowindow.setContent(\"F\");\n");
      out.write("            infowindow.open(map, marker);\n");
      out.write("        };\n");
      out.write("    })(marker, i)); ");

}
}
      out.write("\n");
      out.write("</script>\n");
      out.write("\n");
      out.write("<h2>HOSPITAL</h2>\n");
      out.write("<div id=\"map3\" style=\"width: 500px; height: 500px;\"></div>\n");
      out.write("  <script type=\"text/javascript\">\n");
      out.write("var map = new google.maps.Map(document.getElementById('map3'), {\n");
      out.write("    zoom: 10,\n");
      out.write("    center: new google.maps.LatLng(");
      out.print(lat1);
      out.write(',');
      out.print(lon1);
      out.write("),\n");
      out.write("    mapTypeId: google.maps.MapTypeId.ROADMAP\n");
      out.write("});\n");
      out.write("var infowindow = new google.maps.InfoWindow();\n");
      out.write("var marker, i;\n");

    rst=t3.executeQuery(); 
      while(rst.next())
      {
          double lat2 =rst.getDouble("lattitude");
          double lon2=rst.getDouble("longitude");
          if(D.distance(lat1, lon1, lat2, lon2)<d)
          {
    
      out.write("\n");
      out.write("    marker = new google.maps.Marker({\n");
      out.write("        position: new google.maps.LatLng(");
      out.print(lat2);
      out.write(',');
      out.write(' ');
      out.print(lon2);
      out.write("),\n");
      out.write("        map: map\n");
      out.write("    });\n");
      out.write("    google.maps.event.addListener(marker, 'click', (function (marker, i) {\n");
      out.write("        return function () {\n");
      out.write("            infowindow.setContent(\"F\");\n");
      out.write("            infowindow.open(map, marker);\n");
      out.write("        };\n");
      out.write("    })(marker, i)); ");

}
}
      out.write("\n");
      out.write("</script>\n");
      out.write("<h2> PRONE AREAS</h2>\n");
      out.write("<div id=\"map4\" style=\"width: 500px; height: 500px;\"></div>\n");
      out.write("  <script type=\"text/javascript\">\n");
      out.write("var map = new google.maps.Map(document.getElementById('map4'), {\n");
      out.write("    zoom: 10,\n");
      out.write("    center: new google.maps.LatLng(");
      out.print(lat1);
      out.write(',');
      out.print(lon1);
      out.write("),\n");
      out.write("    mapTypeId: google.maps.MapTypeId.ROADMAP\n");
      out.write("});\n");
      out.write("var infowindow = new google.maps.InfoWindow();\n");
      out.write("var marker, i;\n");

    rst=t4.executeQuery(); 
      while(rst.next())
      {
          double lat2 =rst.getDouble("lattitude");
          double lon2=rst.getDouble("longitude");
          if(D.distance(lat1, lon1, lat2, lon2)<d)
          {
    
      out.write("\n");
      out.write("    marker = new google.maps.Marker({\n");
      out.write("        position: new google.maps.LatLng(");
      out.print(lat2);
      out.write(',');
      out.write(' ');
      out.print(lon2);
      out.write("),\n");
      out.write("        map: map\n");
      out.write("    });\n");
      out.write("    google.maps.event.addListener(marker, 'click', (function (marker, i) {\n");
      out.write("        return function () {\n");
      out.write("            infowindow.setContent(\"F\");\n");
      out.write("            infowindow.open(map, marker);\n");
      out.write("        };\n");
      out.write("    })(marker, i)); ");

}
}
      out.write("\n");
      out.write("</script>\n");
      out.write("<h2> ACCOMMODATION</h2>\n");
      out.write("<div id=\"map5\" style=\"width: 500px; height: 500px;\"></div>\n");
      out.write("  <script type=\"text/javascript\">\n");
      out.write("var map = new google.maps.Map(document.getElementById('map5'), {\n");
      out.write("    zoom: 10,\n");
      out.write("    center: new google.maps.LatLng(");
      out.print(lat1);
      out.write(',');
      out.print(lon1);
      out.write("),\n");
      out.write("    mapTypeId: google.maps.MapTypeId.ROADMAP\n");
      out.write("});\n");
      out.write("var infowindow = new google.maps.InfoWindow();\n");
      out.write("var marker, i;\n");

    rst=t5.executeQuery(); 
      while(rst.next())
      {
          double lat2 =rst.getDouble("lattitude");
          double lon2=rst.getDouble("longitude");
          if(D.distance(lat1, lon1, lat2, lon2)<d)
          {
    
      out.write("\n");
      out.write("    marker = new google.maps.Marker({\n");
      out.write("        position: new google.maps.LatLng(");
      out.print(lat2);
      out.write(',');
      out.write(' ');
      out.print(lon2);
      out.write("),\n");
      out.write("        map: map\n");
      out.write("    });\n");
      out.write("    google.maps.event.addListener(marker, 'click', (function (marker, i) {\n");
      out.write("        return function () {\n");
      out.write("            infowindow.setContent(\"F\");\n");
      out.write("            infowindow.open(map, marker);\n");
      out.write("        };\n");
      out.write("    })(marker, i)); ");

}
}
      out.write("\n");
      out.write("</script>\n");
      out.write("<h2> GEOLOGIST</h2>\n");
      out.write("<div id=\"map6\" style=\"width: 500px; height: 500px;\"></div>\n");
      out.write("  <script type=\"text/javascript\">\n");
      out.write("var map = new google.maps.Map(document.getElementById('map6'), {\n");
      out.write("    zoom: 10,\n");
      out.write("    center: new google.maps.LatLng(");
      out.print(lat1);
      out.write(',');
      out.print(lon1);
      out.write("),\n");
      out.write("    mapTypeId: google.maps.MapTypeId.ROADMAP\n");
      out.write("});\n");
      out.write("var infowindow = new google.maps.InfoWindow();\n");
      out.write("var marker, i;\n");

    rst=t6.executeQuery(); 
      while(rst.next())
      {
          double lat2 =rst.getDouble("latitude");
          double lon2=rst.getDouble("longitude");
          if(D.distance(lat1, lon1, lat2, lon2)<d)
          {
    
      out.write("\n");
      out.write("    marker = new google.maps.Marker({\n");
      out.write("        position: new google.maps.LatLng(");
      out.print(lat2);
      out.write(',');
      out.write(' ');
      out.print(lon2);
      out.write("),\n");
      out.write("        map: map\n");
      out.write("    });\n");
      out.write("    google.maps.event.addListener(marker, 'click', (function (marker, i) {\n");
      out.write("        return function () {\n");
      out.write("            infowindow.setContent(\"F\");\n");
      out.write("            infowindow.open(map, marker);\n");
      out.write("        };\n");
      out.write("    })(marker, i)); ");

}
}
      out.write("\n");
      out.write("</script>\n");
      out.write("<h2> SOCIAL MEDIA</h2>\n");
      out.write("<div id=\"map7\" style=\"width: 500px; height: 500px;\"></div>\n");
      out.write("  <script type=\"text/javascript\">\n");
      out.write("var map = new google.maps.Map(document.getElementById('map7'), {\n");
      out.write("    zoom: 10,\n");
      out.write("    center: new google.maps.LatLng(");
      out.print(lat1);
      out.write(',');
      out.print(lon1);
      out.write("),\n");
      out.write("    mapTypeId: google.maps.MapTypeId.ROADMAP\n");
      out.write("});\n");
      out.write("var infowindow = new google.maps.InfoWindow();\n");
      out.write("var marker, i;\n");

    rst=t7.executeQuery(); 
      while(rst.next())
      {
          double lat2 =rst.getDouble("latitude");
          double lon2=rst.getDouble("longitude");
          if(D.distance(lat1, lon1, lat2, lon2)<d)
          {
    
      out.write("\n");
      out.write("    marker = new google.maps.Marker({\n");
      out.write("        position: new google.maps.LatLng(");
      out.print(lat2);
      out.write(',');
      out.write(' ');
      out.print(lon2);
      out.write("),\n");
      out.write("        map: map\n");
      out.write("    });\n");
      out.write("    google.maps.event.addListener(marker, 'click', (function (marker, i) {\n");
      out.write("        return function () {\n");
      out.write("            infowindow.setContent(\"F\");\n");
      out.write("            infowindow.open(map, marker);\n");
      out.write("        };\n");
      out.write("    })(marker, i)); ");

}
}
      out.write("\n");
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
