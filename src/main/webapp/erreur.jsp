<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <!-- Design by foolishdeveloper.com -->
    <title>Centre de Comptage</title>
 
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link rel="stylesheet" href="style.css">
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;500;600&display=swap" rel="stylesheet">
    <!--Stylesheet-->
<style> 
body {
  background-image: url('img.jpg');
  background-repeat: no-repeat;
  background-attachment: fixed;  
  background-size: cover;
}
table, th, td {
  border:1px solid black;
  margin-top: 250px;
 margin-right: 100px
}
a.back{
width: 200px;
  height: 200px;
  position: absolute;
  left: 1350px;
}

  </style>
</head>
<body>
 
   <form class="login" >
   
          <% String msg = (String)session.getAttribute("erreur");
String pageAuth = (String)session.getAttribute("page");
System.out.println(msg);
System.out.println(request.getContextPath());
%>

<br>
   <a class="back" href="<%=request.getContextPath() + pageAuth%>"><h6>Back !</h6></a>

  <table style="width:100%">
  <tr>
    <center><td><center><h1 ><%=msg %></h1><center></td></center>
    
  </tr>
</table>     
    
    </form>
</body>
</html>