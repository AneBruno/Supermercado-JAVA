<%@page import="entidades.*" %>
<%@page import="logic.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>

 <!-- Bootstrap core CSS -->
  <link href="style/mainpage/bootstrap.min.css" rel="stylesheet">

  <!-- Custom styles for this template -->
  <link href="style/mainpage/modern-business.css" rel="stylesheet">
  
  
  <%Persona per = (Persona)session.getAttribute("usuario");%>
</head>
<body>
	 <!-- Navigation -->
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
      <a class="navbar-brand" href="mainpage-admin.jsp">Supermercado</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto">
          <li class="nav-item active">
            <a class="nav-link" href="mainpage-admin.jsp">Home
              <span class="sr-only">(current)</span>
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="ListCategorias">Categor�as</a>
          </li>
			      <li class="nav-item">
            <a class="nav-link" href="ListDescuentos">Descuentos</a>
          </li>
          <li class="nav-item">
	            <a  href="ListClientes" class="nav-link">Clientes</a>
          </li>
              <li class="nav-item">
	            <a  href="ListEmpleados" class="nav-link">Empleados</a>
         
          </li> 
          <li class="nav-item">
              <a class="nav-link" href="ListProductos">Productos</a>
          </li>
          <li class="nav-item">
              <a class="nav-link" href="ListPedidos">Pedidos</a>
          </li>
           <li class="nav-item ">
            <a class="nav-link" href="ListProveedores">Proveedores</a>
          </li>
          <li class="nav-item">
             
              	<a class="nav-link" href="">Cerrar Sesi�n</a>
          	 
          	 
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
        <h1 class="font-weight-light"><b>Hola de nuevo, <%=per.getNombre() %>!</b> </h1>
        <p>Ahora pod�s ver las �ltimas novedades del negocio en un mismo lugar. </p>
       <!--  <a class="btn btn-primary" href="#">Call to Action!</a>  -->
      </div>
      <!-- /.col-md-4 -->
    </div>
    <!-- /.row -->

   

    <!-- Content Row -->
    <div class="row">
      <div class="col-md-4 mb-5">
        <div class="card h-100">
          <div class="card-body">
            <h2 class="card-title">Gesti�n de Descuentos</h2>
            <%DescuentoController ctrl = new DescuentoController();
            int cant=ctrl.contarDctos();%>
            <p class="card-text">Descuentos activos actualmente: <b><%=cant %></b></p>
          </div>
          <div class="card-footer">
            <a href="ListDescuentos" class="btn btn-primary btn-sm">Ver m�s</a>
          </div>
        </div>
      </div>
      <!-- /.col-md-4 -->
      <div class="col-md-4 mb-5">
        <div class="card h-100">
          <div class="card-body">
            <h2 class="card-title">Gesti�n de <br>
            Stock</h2>
            <p class="card-text">Productos que alcanzaron stock m�nimo: <b>0</b></p>
  
          </div>
          <div class="card-footer">
            <a href="#" class="btn btn-primary btn-sm">Ver m�s</a>
          </div>
        </div>
      </div>
      <!-- /.col-md-4 -->
      <div class="col-md-4 mb-5">
        <div class="card h-100">
          <div class="card-body">
            <h2 class="card-title">Gesti�n de Pedidos</h2>
            <p class="card-text">Pedidos pendientes de envio: <b>0</b></p>
            <p></p>
          </div>
          <div class="card-footer">
            <a href="#" class="btn btn-primary btn-sm">Ver m�s</a>
          </div>
        </div>
      </div>
      <!-- /.col-md-4 -->

    </div>
    <!-- /.row -->

  </div>
  

  
</body>
</html>