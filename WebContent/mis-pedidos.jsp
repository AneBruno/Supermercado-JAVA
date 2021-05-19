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

<title>Mis pedidos</title>

  <!-- Bootstrap core CSS -->
  <link href="style/mainpage/bootstrap.min.css" rel="stylesheet">
  <!-- Custom styles for this template -->
  <link href="style/mainpage/modern-business.css" rel="stylesheet">
  
  <link href="style/cliente/mis-pedidos.css" rel="stylesheet">
  
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>


  <%Persona per = (Persona)session.getAttribute("usuario");
    String mje= (String)request.getAttribute("mensaje");
	Pedido ped= (Pedido)session.getAttribute("pedido");
	LinkedList<Pedido> lp = (LinkedList<Pedido>)request.getAttribute("pedidos");
	String MES[] = {"Enero", "Feb", "Marzo", "Abril", "Mayo", "Jun", "Jul", "Agosto", "Sept", "Oct", "Nov", "Dic"};
  %>

</head>
<body>
<!-- Navigation -->
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
      <a class="navbar-brand" href="mainpage.jsp">Supermercado</a>

      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto">
  
          <li class="nav-item active">
            <a class="nav-link" href="ListPedidos">Mis pedidos</a> <!--  poner en un boton -->
            <span class="sr-only">(current)</span>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="ListDescuentos">Descuentos</a> 
          </li>
          <li class="nav-item">
            <a class="nav-link" href="ListProductos">Productos</a>
             
          </li>          
          <li class="nav-item ">
            <a class="nav-link" href="nosotros.jsp">Nosotros</a>
            
          </li>
          <li class="nav-item">
              	<a class="nav-link" href="CerrarSesion">Cerrar Sesi�n</a>
          </li>
       
        </ul>
      </div>
    </div>
  </nav>
  
  <div class="container">
    <div class="row">
 
  <!-- Si viene de confirmar un pedido: -->
  <%if(mje!=null){%>
 	<div class="alert alert-success alert-dismissible  center-block">
    	<a  class="close" data-dismiss="alert" aria-label="close">&times;</a>
   	    <strong>Su pedido ha sido registrado con �xito.</strong> En esta secci�n podr� consultar el estado del mismo.
  </div>
  <%}%>
  </div>
  <div class="row">
  <%for (Pedido p: lp){
	Date fec= p.getFechaPedido();
	Calendar cal = Calendar.getInstance();
	cal.setTime(fec);
	int year = cal.get(Calendar.YEAR); 
	String month = MES[cal.get(Calendar.MONTH)];
	int day = cal.get(Calendar.DAY_OF_MONTH);%>
  			<!-- <div class="col-lg-4">-->
  		<div class="col-lg-3 col-md-5 mb-4">
	        <div class="card card-margin">
	            <div class="card-header no-border">
	            </div>
	            <div class="card-body pt-0">
	                <div class="widget-49">
	                    <div class="widget-49-title-wrapper">
	                        <div class="widget-49-date-primary">
	                            <span class="widget-49-date-day"><%=day%></span>
	                            <span class="widget-49-date-month"><%=month%></span>
	                            <span class="widget-49-date-month"><%=year%></span>
	                        </div>
	                        <div class="widget-49-meeting-info">
	                            <span class="widget-49-pro-title"></span>
	                            <span class="widget-49-meeting-time">N�mero de Pedido: #<%=p.getIdPedido()%></span>
	                        </div>
	                    </div>
	                    <ol class="widget-49-meeting-points">
	                        <a>Estado: <%=p.getEstado()%></a>
	                        <br>
	                        <a>Direcci�n: <%=p.getDireccionEnvio()%></a>
	                        <br>
	                        <a>Fecha de Entrega: <%=p.getFechaEntrega() %></a>
	                        <br>
	                        <a>Precio Total: <%=p.getPrecioTotal()%></a>
	                    </ol>
	                    <div class="widget-49-meeting-action">
	                        <a href="#" class="btn btn-sm btn-flash-border-primary">Ver m�s</a>
	                    </div>
	                </div>
	            </div>
	     </div>
	 </div>
	 <%} %>
</div>	
 </div>
</body>
</html>