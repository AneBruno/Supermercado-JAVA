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
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Productos</title>

  
  <link href="style/mainpage/modern-business.css" rel="stylesheet">
  <!-- Bootstrap core CSS -->
  <link href="style/mainpage/bootstrap.min.css" rel="stylesheet">

  <!-- Custom styles for this template -->
  <link href="style/cliente/productos.css" rel="stylesheet">
  
  <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
  
  
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  
  <!-- Boton para aumentar o decrementar la cantidad de productos seleccionados -->
    
  	
  <%Persona per = (Persona)session.getAttribute("usuario");%>
  <% LinkedList<Producto> lprod = (LinkedList<Producto>)request.getAttribute("productos");
   	 LinkedList<Categoria> lc= (LinkedList<Categoria>)request.getAttribute("categorias");%>

<script>
function w3_open() {
  document.getElementById("mySidebar").style.display = "block";
  document.getElementById("myOverlay").style.display = "block";
}

function w3_close() {
  document.getElementById("mySidebar").style.display = "none";
  document.getElementById("myOverlay").style.display = "none";
}
</script>

</head>

<body>
 <!-- Navigation -->
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
   <button class="w3-button w3-dark-gray w3-large" onclick="w3_open()">&#9776;</button>
    <div class="container">
      <a class="navbar-brand" href="mainpage.jsp">Supermercado</a>

      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto">
  
          <li class="nav-item">
            <a class="nav-link" href="mis-pedidos.jsp">Mis pedidos</a> <!--  poner en un boton -->
          </li>
          <li class="nav-item">
            <a class="nav-link" href="ListDescuentos">Descuentos</a> <!--  poner en un boton -->
          </li>
          <li class="nav-item active">
            <a class="nav-link" href="ListProductos">Productos</a>
             <span class="sr-only">(current)</span>
          </li>          
          <li class="nav-item">
            <a class="nav-link" href="nosotros.jsp">Nosotros</a>
          </li>
          <li class="nav-item">
              <form action="Inicio" method="get">
              	<a class="nav-link" href="">Cerrar Sesi�n</a>
          	  </form>
          </li>
       
        </ul>
      </div>
    </div>
  </nav>
  
  <!-- Sidebar -->
	<div class="w3-sidebar w3-bar-block" style="display:none;z-index:5" id="mySidebar">
	  <button class="w3-bar-item w3-button w3-large" onclick="w3_close()">Cerrar &times;</button>
	  	 
	  	<div class="w3-dropdown-hover">
	  	  <button class="w3-button w3-gray">Precio</button>
		    <div class="w3-dropdown-content w3-bar-block w3-border">
		     <a class="w3-bar-item w3-button" href="ListProductosMenosMas">De menor a mayor precio</a>
			 <a class="w3-bar-item w3-button" href="ListProductosMasMenos">De mayor a menor precio</a>
	    	</div>
	    </div>
	  	<div class="w3-dropdown-hover">
	    	<button class="w3-button w3-gray">Categoria</button>
		    <div class="w3-dropdown-content w3-bar-block w3-border">
		     <a class="w3-bar-item w3-button" href="ListProductos">Todos</a>
			    <% for (Categoria c: lc) { %>
			      <a class="w3-bar-item w3-button" href="BuscarCat?id=<%=c.getIdCategoria()%>"><%=c.getDescCategoria()%></a>
			  	 <%} %>
    		</div>
  		</div>
	  <!-- <a href="#" class="w3-bar-item w3-button">Link 3</a>-->
	  <div class="w3-dropdown-hover">
		     <a class="w3-button w3-gray" href="ListBajoStock">Stock Bajo</a>
	    </div>
	</div>
  
  <!-- Contenido de la p�gina -->
  
<div class="container">

    <div class="row">
    
    <div class="col-lg-3">

        <br>
        <div class="list-group">
        	<%for(Categoria c:lc){ %>
        		<a href="BuscarCatAct?id=<%=c.getIdCategoria()%>"class="list-group-item"><%=c.getDescCategoria()%></a>
			<%}%>

        </div>

      </div>
      <!-- /.col-lg-3 -->


      <div class="col-lg-9">
		  <br>
        
        <div class="row">
		
		<%if(lprod.size() == 0){ %>   
		<br> 
		<br>
		<br>                   
		<div class="alert alert-warning" > �Lo sentimos! No hay productos con esta categor�a  </div>                               	
		<%} %>
		
		<%for (Producto p: lprod){ %>
          <div class="col-lg-4 col-md-6 mb-4">
            <div class="card h-100">
              <a href="#"><img class="card-img-top" src="http://placehold.it/700x400" alt=""></a>
              <div class="card-body">
                <h4 class="card-title">
                  <a><%=p.getDescProducto()%></a>
                </h4>
                <p class="card-text"><%=p.getMarca() %></p>
                <h5><%="$" + p.getPrecio() %></h5>
              </div>
              <div class="card-footer">
                <!-- ESPACIO PARA SELECCIONAR CANTIDAD DEL PRODUCTO -->
				  <input type="number" id="points" name="points" value="0" step="1" min="0" max="99">
				  <small class="btn btn-primary btn-sm" style="margin-left: 75px;">A�adir</small>
				</div>
				
				<!-- BOTON PAR AGREGAR AL CARRITO ESA CANTIDAD -->
        
              
            </div>
          </div>

        <%} %>

        </div>
        <!-- /.row -->

      </div>
      <!-- /.col-lg-9 -->

    </div>
    <!-- /.row -->

  </div>
  <!-- /.container -->

  <br>

  
  
</body>

</html>