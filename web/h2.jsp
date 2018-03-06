<%-- 
    Document   : h2
    Created on : Mar 23, 2016, 12:08:13 AM
    Author     : JISHNU T U
--%>
<%@page import="java.sql.*"%>
<%@page import ="Table.*" %>
<% Class.forName("com.mysql.jdbc.Driver"); %>
<%
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
   
    %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="apply.css">
        <script src="http://maps.google.com/maps/api/js?sensor=false" 
      type="text/javascript"></script>
        <title>LOCATER</title>
    </head>
    <body >
        <h1> NEAREST SERVICE  FINDER </h1>
        <a href="headqua.jsp" style="color: #98FB98" > HQ (link ) </a>
        <form name="myform" action="h2.jsp" method="POST">
           Latitude  :   <input type="text" name="la" value="" />
           Longitude :   <input type="text" name="lo" value="" />
           
           Maxicum Distance :<input type="text" name="d" value="" />
           <input type="submit" value="Submit" name="s" />
        </form>
        
        <h1> FIRE FORCE LOCATION</h1>
    <div id="map1" style="width: 500px; height: 500px;"></div>
    
<script type="text/javascript">
var map = new google.maps.Map(document.getElementById('map1'), {
    zoom: 10,
    center: new google.maps.LatLng(<%=lat1%>,<%=lon1%>),
    mapTypeId: google.maps.MapTypeId.ROADMAP
});
var infowindow = new google.maps.InfoWindow();
var marker, i;
<%
    rst=t1.executeQuery(); 
      while(rst.next())
      {
          double lat2 =rst.getDouble("latitude");
          double lon2=rst.getDouble("longitude");
          if(D.distance(lat1, lon1, lat2, lon2)<d)
          {
    %>
    marker = new google.maps.Marker({
        position: new google.maps.LatLng(<%=lat2%>, <%=lon2%>),
        map: map
    });
    google.maps.event.addListener(marker, 'click', (function (marker, i) {
        return function () {
            infowindow.setContent("F");
            infowindow.open(map, marker);
        };
    })(marker, i)); <%
}
}%>
</script>

<h2> VOLUNTEER LOCATION</h2>
<div id="map2" style="width: 500px; height: 500px;"></div>
  <script type="text/javascript">
var map = new google.maps.Map(document.getElementById('map2'), {
    zoom: 10,
    center: new google.maps.LatLng(<%=lat1%>,<%=lon1%>),
    mapTypeId: google.maps.MapTypeId.ROADMAP
});
var infowindow = new google.maps.InfoWindow();
var marker, i;
<%
    rst=t2.executeQuery(); 
      while(rst.next())
      {
          double lat2 =rst.getDouble("lattitude");
          double lon2=rst.getDouble("longitude");
          if(D.distance(lat1, lon1, lat2, lon2)<d)
          {
    %>
    marker = new google.maps.Marker({
        position: new google.maps.LatLng(<%=lat2%>, <%=lon2%>),
        map: map
    });
    google.maps.event.addListener(marker, 'click', (function (marker, i) {
        return function () {
            infowindow.setContent("F");
            infowindow.open(map, marker);
        };
    })(marker, i)); <%
}
}%>
</script>

<h2>HOSPITAL</h2>
<div id="map3" style="width: 500px; height: 500px;"></div>
  <script type="text/javascript">
var map = new google.maps.Map(document.getElementById('map3'), {
    zoom: 10,
    center: new google.maps.LatLng(<%=lat1%>,<%=lon1%>),
    mapTypeId: google.maps.MapTypeId.ROADMAP
});
var infowindow = new google.maps.InfoWindow();
var marker, i;
<%
    rst=t3.executeQuery(); 
      while(rst.next())
      {
          double lat2 =rst.getDouble("lattitude");
          double lon2=rst.getDouble("longitude");
          if(D.distance(lat1, lon1, lat2, lon2)<d)
          {
    %>
    marker = new google.maps.Marker({
        position: new google.maps.LatLng(<%=lat2%>, <%=lon2%>),
        map: map
    });
    google.maps.event.addListener(marker, 'click', (function (marker, i) {
        return function () {
            infowindow.setContent("F");
            infowindow.open(map, marker);
        };
    })(marker, i)); <%
}
}%>
</script>
<h2> PRONE AREAS</h2>
<div id="map4" style="width: 500px; height: 500px;"></div>
  <script type="text/javascript">
var map = new google.maps.Map(document.getElementById('map4'), {
    zoom: 10,
    center: new google.maps.LatLng(<%=lat1%>,<%=lon1%>),
    mapTypeId: google.maps.MapTypeId.ROADMAP
});
var infowindow = new google.maps.InfoWindow();
var marker, i;
<%
    rst=t4.executeQuery(); 
      while(rst.next())
      {
          double lat2 =rst.getDouble("lattitude");
          double lon2=rst.getDouble("longitude");
          if(D.distance(lat1, lon1, lat2, lon2)<d)
          {
    %>
    marker = new google.maps.Marker({
        position: new google.maps.LatLng(<%=lat2%>, <%=lon2%>),
        map: map
    });
    google.maps.event.addListener(marker, 'click', (function (marker, i) {
        return function () {
            infowindow.setContent("F");
            infowindow.open(map, marker);
        };
    })(marker, i)); <%
}
}%>
</script>
<h2> ACCOMMODATION</h2>
<div id="map5" style="width: 500px; height: 500px;"></div>
  <script type="text/javascript">
var map = new google.maps.Map(document.getElementById('map5'), {
    zoom: 10,
    center: new google.maps.LatLng(<%=lat1%>,<%=lon1%>),
    mapTypeId: google.maps.MapTypeId.ROADMAP
});
var infowindow = new google.maps.InfoWindow();
var marker, i;
<%
    rst=t5.executeQuery(); 
      while(rst.next())
      {
          double lat2 =rst.getDouble("lattitude");
          double lon2=rst.getDouble("longitude");
          if(D.distance(lat1, lon1, lat2, lon2)<d)
          {
    %>
    marker = new google.maps.Marker({
        position: new google.maps.LatLng(<%=lat2%>, <%=lon2%>),
        map: map
    });
    google.maps.event.addListener(marker, 'click', (function (marker, i) {
        return function () {
            infowindow.setContent("F");
            infowindow.open(map, marker);
        };
    })(marker, i)); <%
}
}%>
</script>
<h2> GEOLOGIST</h2>
<div id="map6" style="width: 500px; height: 500px;"></div>
  <script type="text/javascript">
var map = new google.maps.Map(document.getElementById('map6'), {
    zoom: 10,
    center: new google.maps.LatLng(<%=lat1%>,<%=lon1%>),
    mapTypeId: google.maps.MapTypeId.ROADMAP
});
var infowindow = new google.maps.InfoWindow();
var marker, i;
<%
    rst=t6.executeQuery(); 
      while(rst.next())
      {
          double lat2 =rst.getDouble("latitude");
          double lon2=rst.getDouble("longitude");
          if(D.distance(lat1, lon1, lat2, lon2)<d)
          {
    %>
    marker = new google.maps.Marker({
        position: new google.maps.LatLng(<%=lat2%>, <%=lon2%>),
        map: map
    });
    google.maps.event.addListener(marker, 'click', (function (marker, i) {
        return function () {
            infowindow.setContent("F");
            infowindow.open(map, marker);
        };
    })(marker, i)); <%
}
}%>
</script>
<h2> SOCIAL MEDIA</h2>
<div id="map7" style="width: 500px; height: 500px;"></div>
  <script type="text/javascript">
var map = new google.maps.Map(document.getElementById('map7'), {
    zoom: 10,
    center: new google.maps.LatLng(<%=lat1%>,<%=lon1%>),
    mapTypeId: google.maps.MapTypeId.ROADMAP
});
var infowindow = new google.maps.InfoWindow();
var marker, i;
<%
    rst=t7.executeQuery(); 
      while(rst.next())
      {
          double lat2 =rst.getDouble("latitude");
          double lon2=rst.getDouble("longitude");
          if(D.distance(lat1, lon1, lat2, lon2)<d)
          {
    %>
    marker = new google.maps.Marker({
        position: new google.maps.LatLng(<%=lat2%>, <%=lon2%>),
        map: map
    });
    google.maps.event.addListener(marker, 'click', (function (marker, i) {
        return function () {
            infowindow.setContent("F");
            infowindow.open(map, marker);
        };
    })(marker, i)); <%
}
}%>
</script>
    </body>
</html>
