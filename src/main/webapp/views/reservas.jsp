<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List" %>
<%@page import="models.Reserva" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <title>Lista de Reservas</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gray-100 text-gray-900">

<!-- Barra de navegación -->
<header>
    <div class="flex gap-4 bg-green-600 justify-center h-[50px] items-center">
        <a href="/Gestion-Biblioteca" class="text-white hover:bg-green-700 p-2 rounded-md">Inicio</a>
        <a href="/Gestion-Biblioteca/categorias" class="text-white hover:bg-green-700 p-2 rounded-md">Categorías</a>
       <a href="/Gestion-Biblioteca/libros" class="h-auto text-white hover:bg-green-700 p-2 rounded-md cursor-pointer">Libros</a>
        <a href="/Gestion-Biblioteca/Prestamo" class="text-white hover:bg-green-700 p-2 rounded-md">Préstamo</a>
        <a href="/Gestion-Biblioteca/reserva" class="text-white bg-green-700 p-2 rounded-md border border-white">Reservas</a>
    </div>
</header>

<!-- Contenido -->
<div class="container mx-auto px-4 py-6">
    <h2 class="text-2xl font-bold mb-4 text-center">Lista de Reservas</h2>

    <%
        List<Reserva> reservas = (List<Reserva>) request.getAttribute("reservas");
        if (reservas == null || reservas.isEmpty()) {
    %>
        <p class="text-center text-gray-600">No hay reservas disponibles.</p>
    <%
        } else {
    %>
    <div class="overflow-x-auto">
        <table class="min-w-full bg-white border border-gray-200 shadow-md rounded-lg">
            <thead>
                <tr class="bg-green-600 text-white">
                    <th class="py-2 px-4 text-left">ID Reserva</th>
                    <!--   <th class="py-2 px-4 text-left">ID Usuario</th>-->
                    <th class="py-2 px-4 text-left">ID Ejemplar</th>
                    <th class="py-2 px-4 text-left">Fecha Reserva</th>
                    <th class="py-2 px-4 text-left">Estado</th>
                    <!--  <th class="py-2 px-4 text-left">Fecha Creación</th>-->
                    <th class="py-2 px-4 text-left">Imagen</th>
                </tr>
            </thead>
            <tbody class="divide-y divide-gray-200">
                <% for (Reserva reserva : reservas) { %>
                <tr class="hover:bg-gray-100">
                    <td class="py-2 px-4"><%= reserva.getIdReserva() %></td>
                    
                    <td class="py-2 px-4"><%= reserva.getIdEjemplar() %></td>
                    <td class="py-2 px-4"><%= reserva.getFechaReserva() %></td>
                    <td class="py-2 px-4"><%= reserva.getEstado() %></td>
                    
                    <td class="py-2 px-4">
                        <% if (reserva.getImagenUrl() != null && !reserva.getImagenUrl().isEmpty()) { %>
                            <img src="<%= reserva.getImagenUrl() %>" class="w-20 h-20 object-cover rounded-md border border-gray-300" alt="Imagen Reserva"/>
                        <% } else { %>
                            <span class="text-gray-500">No disponible</span>
                        <% } %>
                    </td>
                </tr>
                <% } %>
            </tbody>
        </table>
    </div>
    <% } %>
</div>

</body>
</html>
