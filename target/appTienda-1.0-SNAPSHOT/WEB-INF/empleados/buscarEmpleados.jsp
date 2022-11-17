<%@page import="tienda.modelo.dao.EmpleadoDAO"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="tienda.conexion.Conexion"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <title>Buscar empleados</title>
        <!<!-- Navbar Template · Bootstrap v5.2 -->
        <link rel="canonical" href="https://getbootstrap.com/docs/5.2/examples/navbars-offcanvas/">
        <link href="../../assets/dist/css/bootstrap.min.css" rel="stylesheet">
        <!-- Custom styles for this template -->
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
                    <h1 class="display-5 fw-normal">Tabla de datos de los empleados</h1>
                    <p class="fs-5">
                        <%
                            Connection cn = Conexion.abrir();
                            PreparedStatement ps;
                            ResultSet rs;
                            ps = cn.prepareStatement("SELECT * FROM EMPLEADO");
                            rs = ps.executeQuery();
                        %>
                    <form action="#" method="post">
                        <table class="table table-borderless">
                            <tr>
                                <td>
                                    <input 
                                        class="form-control" 
                                        id="searchbar"
                                        onkeyup="searchEmpleado()"
                                        type="search" 
                                        name="search" 
                                        placeholder="Buscador de empleados...">
                                </td>
                            </tr>

                        </table>
                        <table id="datosTabla" class="table table-borderless">
                            <thead>
                                <tr>
                                    <th scope="col">IdEmpleado</th>
                                    <th scope="col">Nombre</th>
                                    <th scope="col">Apellidos</th>
                                    <th scope="col">Cargo</th>
                                </tr>
                            </thead>
                            <tbody>
                                <%while (rs.next())
                                    {%>
                                <tr>
                                    <th class="idempleadoE" scope = "row"><%=rs.getInt("idempleado")%></th>
                                    <td class="empleados"><%=rs.getString("nombre")%></td>
                                    <td class="apellidosE"><%=rs.getString("apaterno")%> <%=rs.getString("amaterno")%></td>
                                    <td class="cargoE"><%=rs.getString("cargo")%></td>
                                </tr>
                                <%}%>
                            </tbody>
                        </table>
                    </form>
                    </p>
                </div>
            </div>
        </div>




        <script src="../../assets/dist/js/bootstrap.bundle.min.js"></script>
        <script>

            // para el buscador
            function searchEmpleado() {
                let input = document.getElementById("searchbar").value;
                input = input.toLowerCase();
                
                let a = document.getElementsByClassName("idempleadoE");
                let x = document.getElementsByClassName("empleados");
                let b = document.getElementsByClassName("apellidosE");
                let c = document.getElementsByClassName("cargoE");
        
                for (i = 0; i < x.length; i++) {
                    if (!x[i].innerHTML.toLowerCase().includes(input)) {
                        a[i].style.display = "none";
                        x[i].style.display = "none";
                        b[i].style.display = "none";
                        c[i].style.display = "none";
                    } else {
                        a[i].style.display = "";
                        x[i].style.display = "";
                        b[i].style.display = "";
                        c[i].style.display = "";
                    }
                }
            }
            //para obtener datos de la tabla en formato Json
            function tablaAJson(table) {
                var data = [];
                var headers = [];
                for (var i = 0; i < table.rows[0].cells.length; i++) {
                    headers[i] = table.rows[0].cells[i].innerHTML.toLowerCase().replace(/ /gi, '');
                }
                for (var i = 1; i < table.rows.length; i++) {
                    var tableRow = table.rows[i];
                    var rowData = {};
                    for (var j = 0; j < tableRow.cells.length; j++) {
                        rowData[ headers[j] ] = tableRow.cells[j].innerHTML;
                    }
                    data.push(rowData);
                }
                return data;
            }
            var myJson = JSON.stringify(tablaAJson(document.getElementById("datosTabla")));
            console.log(myJson);
        </script>
    </body>
</html>
