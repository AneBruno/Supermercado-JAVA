<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

	<meta charset="ISO-8859-1">
  	<link href="style/mainpage/bootstrap.min.css" rel="stylesheet">
  	<link href="style/mainpage/modern-business.css" rel="stylesheet">
  	<link href="style/login/login.css" rel="stylesheet">
   
	<title>Alta Proveedor</title>
	
</head>

<body>

  <div class="container">
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
  	<div class="container">
    	<a class="navbar-brand" href="mainpage-admin.jsp">Supermercado</a>

     <div class="collapse navbar-collapse" id="navbarResponsive">
     
     	<ul class="navbar-nav ml-auto">   
     	     
          <li class="nav-item">
            <a class="nav-link" href="ListCategorias">Categor�as</a>
          </li>
          
          <li class="nav-item">
           <a class="nav-link" href="ListDescuentos">Descuentos</a>
          </li>
          
          <li class="nav-item ">
	            <a class="nav-link" href="ListClientes">Clientes</a>	             
          </li>
          
          <li class="nav-item">
             <a class="nav-link" href="ListEmpleados">Empleados</a>
          </li>
          
          <li class="nav-item">
             <a class="nav-link" href="ListPedidos">Pedidos</a>
          </li>
          
          <li class="nav-item ">
            <a class="nav-link" href="ListProveedores">Proveedores</a>
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
  
  </div>
  
  <div class="container-fluid">
  <div class="row no-gutter">
    <div class="d-none d-md-flex col-md-4 col-lg-6 bg-image"></div>
    <div class="col-md-8 col-lg-6">
      <div class="login d-flex align-items-center py-5">
        <div class="container">
          <div class="row">
            <div class="col-md-9 col-lg-8 mx-auto ">
              <h3 class="login-heading mb-4 text-center">Nuevo Proveedor</h3>
              
              <form action="AddProveedor" method="post">
               
                <div class="form-label-group">
                  <input type="text" name="tel" id="tel" class="form-control" placeholder="Tel�fono" required >
                  <label for="tel">Tel�fono</label>
                </div>
                
                <div class="form-label-group">
                  <input type="text" name="email" id="email" class="form-control" placeholder="Email" required >
                  <label for="email">Email</label>
                </div>
                
                <div class="form-label-group">
                  <input type="text" name="razonS" id="razonS" class="form-control" placeholder="Razon Social" required>
                  <label for="razonS">Raz�n Social</label>
                </div>
                
                <!--  <div class="form-label-group">
                  <input type="text" name="baja" id="baja" class="form-control" placeholder="Fecha de Baja" >
                  <label for="baja">Fecha Baja</label>
                </div>  --> 

                <p>${message_categoria}</p>
 
                <form action="AddCategoria" method="post">
                <button class="btn btn-lg btn-primary btn-block btn-login text-uppercase font-weight-bold mb-2" type="submit" onclick="return confirm('Se agregar� un nuevo proveedor. Desea confirmar?')">Agregar</button>
                </form>
                
      	     </form>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
</body>
</html>