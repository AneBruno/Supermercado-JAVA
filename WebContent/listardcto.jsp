<%@page import="java.util.LinkedList"%>
<%@page import="java.sql.Date" %>
<%@page import="entidades.*"%>
<%@ page import="java.util.Calendar"%>
<%@page import="logic.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Descuentos</title>

  <!-- Bootstrap core CSS -->
  <link href="style/mainpage/bootstrap.min.css" rel="stylesheet">
  <!-- Custom styles for this template -->
  <link href="style/mainpage/modern-business.css" rel="stylesheet">


<% LinkedList<Descuento> ld = (LinkedList<Descuento>)request.getAttribute("descuentos");
java.sql.Date timeNow = new Date(Calendar.getInstance().getTimeInMillis());
Persona per = (Persona)session.getAttribute("usuario");%>

</head>
<body>
 <!-- Navigation -->
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
      <a class="navbar-brand" href="mainpage.jsp">Supermercado</a>

      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto">
  
  
          <li class="nav-item">
            <a class="nav-link" href="ListPedidos">Mis pedidos</a> <!--  poner en un boton -->
          </li>
          <li class="nav-item">
            <a class="nav-link" href="ListDescuentos">Descuentos</a> <!--  poner en un boton -->
          </li>
          <li class="nav-item">
            <a class="nav-link" href="ListProductos">Productos</a>
          </li>          
          <li class="nav-item">
            <a class="nav-link" href="nosotros.jsp">Nosotros</a>
          </li>
          <li class="nav-item">
              	<a class="nav-link" href="CerrarSesion">Cerrar Sesi�n</a>
          </li>
        </ul>
      </div>
    </div>
  </nav>

  <!-- Page Content -->
  <div class="container">

    <!-- Heading Row -->
    <div class="row align-items-center my-5">
      <div class="col-lg-7">
        <img class="img-fluid rounded mb-4 mb-lg-0" src="style/mainpage/6.jpg" alt="">
      </div>
      <!-- /.col-lg-8 -->
      <div class="col-lg-5 text-center" >
        <h1 class="font-weight-light"><b>Ahora tambi�n disfrutar de nuestros descuentos.</b> </h1>
       <!--  <a class="btn btn-primary" href="#">Call to Action!</a>  -->
      </div>
      <!-- /.col-md-4 -->
    </div>
    <!-- /.row -->


<div class="row">
<% if(ld.size()!=0){ 
	for(Descuento dcto: ld){%>

		 <!-- /.col-md-4 -->
		
	      <div class="col-md-4 mb-5">
	        <div class="card h-100">
	          <div class="card-body">
	            <h2 class="card-title"> <%=dcto.getPorcDcto() %> %</h2>
	            <p class="card-text">Aprovecha tu descuento! Disfrute de los beneficios al m�ximo desde
	            el <b><%=dcto.getFechaDctoInicio()%></b> hasta el <b><%=dcto.getFechaDctoFin()%></b></p>
	            <p></p>
	          </div>
	          <div class="card-footer">
	            
	          </div>
	        </div>
	      </div>
		
	    <!-- /.col-md-4 -->

<% } %>
	<% } %>

 </div>
</div>

 
</body>
</html>