<%@page import="java.util.LinkedList"%>
<%@page import="entidades.*"%>
<%@page import="logic.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

  <link href="style/mainpage/bootstrap.min.css" rel="stylesheet">
  <link href="style/mainpage/modern-business.css" rel="stylesheet">
  
  <!-- Estilo para el listado de clientes -->
  <link href="style/clientes-admin/listado-clientes.css" rel="stylesheet">  
  <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">
  <link href="style/clientes-admin/confirmacion.css" rel="stylesheet"> 
  <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">  
  <link rel="stylesheet" href="style/filtros.css">  
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  
<title>Productos</title>

<% LinkedList<Producto> lprod = (LinkedList<Producto>)request.getAttribute("productos");
LinkedList<Categoria> lc= (LinkedList<Categoria>)request.getAttribute("categorias");%>

</head>
<body>

  <div class="container">
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
      <a class="navbar-brand" href="mainpage-admin.jsp">Supermercado</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto">
          <li class="nav-item">
            <a class="nav-link" href="ListCategorias">Categor�as</a>
          </li>
          <li class="nav-item ">
            <a class="nav-link" href="ListDescuentos">Descuentos</a>
           
          </li>
          <li class="nav-item ">
	            <a class="nav-link" href="ListClientes">Clientes</a>
	             
          </li>
          <li class="nav-item">
             <a class="nav-link" href="ListEmpleados">Empleados</a>
          </li>
          <li class="nav-item active">
              <a class="nav-link" href="ListProductos">Productos</a>
                <span class="sr-only">(current)</span>
          </li>
          <li class="nav-item ">
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
  </div>
  
 <hr> 

    <div class="container bootstrap snippets bootdey"> 
	
	<!--  DROPLISTS -->
	<!-- CATEGORIAS -->
	<div class="w3-container">
  	<div class="w3-dropdown-hover">
    	<button class="w3-button w3-black">Categoria</button>
	    <div class="w3-dropdown-content w3-bar-block w3-border">
	     <a class="w3-bar-item w3-button" href="ListProductos">Todos</a>
		    <% for (Categoria c: lc) { %>
		      <a class="w3-bar-item w3-button" href="BuscarCat?id=<%=c.getIdCategoria()%>"><%=c.getDescCategoria()%></a>
		  	 <%} %>
    	</div>
  	</div>
  	<!-- PRECIO -->
  	<div class="w3-dropdown-hover">
  	<button class="w3-button w3-black">Precio</button>
	    <div class="w3-dropdown-content w3-bar-block w3-border">
	     <a class="w3-bar-item w3-button" href="ListProductosMenosMas">De menor a mayor precio</a>
		 <a class="w3-bar-item w3-button" href="ListProductosMasMenos">De mayor a menor precio</a>
    	</div>
	</div>
	<!-- SEARCH -->
	<!-- DESCRIPCION -->
	<form action="ListProductosDesc">
	   <div class="search-container" style="margin:auto;max-width:300px">
	      <input type="text" placeholder="Descripcion..." name="desc">
	      <button type="submit"><i class="fa fa-search"></i></button>
	   </div>
	</form>

</div>
	

	
	<br>
	
	<!--  TABLA -->	
    <div class="row">
        <div class="col-lg-12">
            <div class="main-box no-header clearfix">
                <div class="main-box-body clearfix">
                    <div class="table-responsive">
                        <table class="table user-list">
                            <thead>
                                <tr>
                                <th align="center"><span>ID</span></th>
                                <th align="center"><span>Descripci�n</span></th>
                                <th align="center"><span>Stock</span></th>
                                <th align="center"><span>Stock M�nimo</span></th>
                                <th align="center"><span>Marca</span></th>
                                <th align="center"><span>ID Categor�a</span></th>
                                <th align="center"><span>Precio</span></th>
        
                                <th>&nbsp;</th>
                                </tr>
                            </thead>
                            <tbody>
	                           <% for (Producto p: lprod) { %>
	                    			<tr>
	                    			<td><%=p.getIdProducto()%></td>
	                    			<td><%=p.getDescProducto()%></td>
	                    			<td><%=p.getStock()%></td>
                                    <td><%=p.getStockMinimo()%></td>
                                    <td><%=p.getMarca()%></td>
   									<td><%=p.getId_categoria()%></td>
                                    <td><%=p.getPrecio()%> </td>
       
                                     <td style="width: 10%;">
                                        
                                         <a  href="BuscarProducto?id=<%=p.getIdProducto()%>"  class="table-link text-info">
                                            <span class="fa-stack">
                                                <i class="fa fa-square fa-stack-2x"></i>
                                                <i class="fa fa-pencil fa-stack-1x fa-inverse"></i>
                                            </span>
                                        </a>
                                        <a  href="DeleteProducto?id=<%=p.getIdProducto()%>" class="table-link danger" onclick="return confirm('Desea eliminar este producto?');" >
                                            <span class="fa-stack">
                                                <i class="fa fa-square fa-stack-2x"></i>
                                                <i class="fa fa-trash-o fa-stack-1x fa-inverse"></i>
                                            </span>
                                            
                                        </a>
                                    
                                    </td>
                                   
    
	                    		</tr>
	                    		   
	                    		
	                    		<% } %>
	                    		
                    		</tbody>	
                        </table>
                    </div>
                </div>
            </div>
            <span style="text-align: right; vertical-align: bottom;">
            	
			<div class="w3-container">	 
			<form action="crearProducto.jsp" method="post">
				<button class="w3-button w3-xlarge w3-circle w3-teal" type="submit" >+</button>
				<a href="crearProducto.jsp"> Agregar producto</a>
			</form>
			</div>
			
			</span>            
            
          
        </div>
    </div>
</div>

</body>
</html>
