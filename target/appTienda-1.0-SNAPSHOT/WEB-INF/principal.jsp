<%@page import="tienda.modelo.bean.Empleado"%>
<%@page import="tienda.modelo.bean.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <title>Principal</title>
        <!<!-- Navbar Template · Bootstrap v5.2 -->
        <link rel="canonical" href="https://getbootstrap.com/docs/5.2/examples/navbars-offcanvas/">
        <link href="assets/dist/css/bootstrap.min.css" rel="stylesheet">
        <!-- Custom styles for this template -->
        <link href="estilos.css" rel="stylesheet">
    </head>
    <body>
        <nav class="navbar navbar-dark bg-dark" aria-label="Dark offcanvas navbar">
            <div class="container-fluid">
                <a class="navbar-brand" href="index.html">Lenguaje de Programación II - Semestre 2022-II - Mendoza Torres Jairo Daniel - 20B3010069
                </a>
                <button class="navbar-toggler" type="button" data-bs-toggle="offcanvas"
                        data-bs-target="#offcanvasNavbarDark" aria-controls="offcanvasNavbarDark">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="offcanvas offcanvas-end text-bg-dark" tabindex="-1" id="offcanvasNavbarDark"
                     aria-labelledby="offcanvasNavbarDarkLabel">
                    <div class="offcanvas-header">
                        <h5 class="offcanvas-title" id="offcanvasNavbarDarkLabel">Indice de tareas</h5>
                        <button type="button" class="btn-close btn-close-white" data-bs-dismiss="offcanvas"
                                aria-label="Close"></button>
                    </div>
                    <div class="offcanvas-body">
                        <ul class="navbar-nav justify-content-end flex-grow-1 pe-3">
                            <li class="nav-item">
                                <a class="nav-link active" aria-current="page" href="index.html">Principal</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </nav>
        <div class="container my-5">
            <div class="bg-light p-5 rounded">
                <div class="col-sm-8 py-5 mx-auto">
                    <h1 class="display-5 fw-normal"><b>Datos del empleado</b></h1>
                    <p class="fs-5">
                        <%
                            Usuario user = (Usuario) request.getSession().getAttribute("usuario");
                            Empleado emp = (Empleado) request.getAttribute("empleado");
                        %>
                    <h3 id="us">Usuario:<%=user.getUsuario()%> </h3>
                    <h1>Empleado</h1>
                    <h5>Id:<%=emp.getIdempleado()%></h5>
                    <h5>Nombre: <%=emp.getNombre()%></h5>
                    <h5>Apellidos: <%=emp.getApaterno()%>  <%=emp.getAmaterno()%></h5>
                    <h5>Cargo: <%=emp.getCargo()%></h5>

                    <br><br>
                    <ul>
                        <li><a href="#">Empleados </a></li>
                        <li><a href="buscarEmpleado">Buscar Empleado</a></li>

                    </ul>

                    <br><br>
                    <p>
                        <a class="btn btn-primary" href="cerrarSesion" role="button">Cerrar sesion</a>
                    </p>
                    </p>
                </div>
            </div>
        </div>

        <script src="assets/dist/js/bootstrap.bundle.min.js"></script>

    </body>
</html>
