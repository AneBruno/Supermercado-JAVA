<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- Bootstrap core CSS -->
  <link href="style/mainpage/bootstrap.min.css" rel="stylesheet">

  <!-- Custom styles for this template -->
  <link href="style/mainpage/modern-business.css" rel="stylesheet">
  
   <!--  <link href="style/login/login.css" rel="stylesheet"> -->
     
    <link href="style/login/login.css" rel="stylesheet">
   
<title>Alta Proveedores</title>
</head>
<body>
<!-- Page Content -->
  <div class="container">
 <!-- Navigation -->
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
        </ul>
      </div>
    </div>
  </nav>
  </div>
  <form action="AddProveedor" method="post">
  				<div class="form-label-group">
                  <input type="text" name="tel" id="tel" class="form-control" placeholder="Telefono" required >
                  <label for="tel">Telefono</label>
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
                
  <form action="AddProveedor" method="post">
    <button class="btn btn-lg btn-primary btn-block btn-login text-uppercase font-weight-bold mb-2" type="submit" onclick="return confirm('Se agregar� un nuevo proveedor. Desea confirmar?')">Agregar</button>
 </form> 
 
</form>
</body>
</html>