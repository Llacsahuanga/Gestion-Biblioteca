<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="models.Libro" %>
<%@ page import="shared.Constants" %>
 
<%
    Libro libro = (Libro) request.getAttribute("libro");
%>
 
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Detalles del Libro</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gray-100 flex flex-col items-center min-h-screen p-4">
 
    <header class="bg-green-600 w-full p-3 text-white text-center">
        <h1 class="text-lg font-bold">Detalles del Libro</h1>
    </header>
 
    <main class="mt-4 w-full max-w-3xl">
        <% if (libro != null) { %>
            <div class="bg-white p-4 rounded-lg shadow-md flex">
                
                <!-- Imagen del Libro (puedes agregar una imagen si tienes URL en tu modelo, o una imagen por defecto) -->
                <div class="w-1/2 flex justify-center items-center">
                    <img class="rounded-lg shadow-md w-60 h-60 object-cover"
                         src="<%= libro.getImagenUrl() != null ? libro.getImagenUrl() : Constants.IMAGEN_PRODUCTO_DEFAULT %>"
                         alt="Imagen del libro">
                </div>
 
                <!-- Tabla de detalles -->
                <div class="w-1/2 pl-4">
                    <table class="w-full border border-gray-300 rounded-lg overflow-hidden text-sm">
                        <tbody>
                            <tr>
                                <td class="p-1 border-b font-semibold">Título</td>
                                <td class="p-1 border-b text-gray-800"><%= libro.getTitulo() %></td>
                            </tr>
                            <tr class="bg-gray-50">
                                <td class="p-1 border-b font-semibold">Autor</td>
                                <td class="p-1 border-b text-gray-800"><%= libro.getAutor() %></td>
                            </tr>
                            <tr>
                                <td class="p-1 border-b font-semibold">Código</td>
                                <td class="p-1 border-b text-gray-800"><%= libro.getCodigo() %></td>
                            </tr>
                            <tr class="bg-gray-50">
                                <td class="p-1 border-b font-semibold">Año de Publicación</td>
                                <td class="p-1 border-b text-gray-800"><%= libro.getAnioPublicacion() %></td>
                            </tr>
                            <tr>
                                <td class="p-1 border-b font-semibold">Descripción</td>
                                <td class="p-1 border-b text-gray-800"><%= libro.getDescripcion() %></td>
                            </tr>
                            <tr class="bg-gray-50">
                                <td class="p-1 border-b font-semibold">Estado</td>
                                <td class="p-1 border-b text-gray-800"><%= libro.getEstado() %></td>
                            </tr>
                            <tr>
                                <td class="p-1 border-b font-semibold">Estado de Auditoría</td>
                                <td class="p-1 border-b text-gray-800"><%= libro.getEstadoAuditoria() %></td>
                            </tr>
                            <tr class="bg-gray-50">
                                <td class="p-1 border-b font-semibold">Fecha de Creación</td>
                                <td class="p-1 border-b text-gray-800"><%= libro.getFechaCreacion() != null ? libro.getFechaCreacion().toString() : "N/A" %></td>
                            </tr>
                        </tbody>
                    </table>
                </div>
 
            </div>
        <% } else { %>
            <p class="text-red-500 font-bold text-lg text-center">Libro no encontrado.</p>
        <% } %>
    </main>
 
</body>
</html>
