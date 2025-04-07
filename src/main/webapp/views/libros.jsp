<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="models.Libro" %>
<%@ page import="shared.Constants" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>GESTION BIBLIOTECA</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gray-400">

    <% List<Libro> libros = (List<Libro>) request.getAttribute("libros"); %>

    <header>
		<div class="flex gap-4 bg-green-600 h-[50px] items-center justify-between">
		<div class="flex gap-4 justify-center w-full">
			<a href="/Gestion-Biblioteca" class="h-auto text-white hover:bg-green-700 p-2 rounded-md cursor-pointer">Inicio</a>
			<a href="/Gestion-Biblioteca/categorias" class="h-auto text-white hover:bg-green-700 p-2 rounded-md cursor-pointer border border-white border-solid">Categorías</a>
			<a href="/Gestion-Biblioteca/Prestamo" class="h-auto text-white hover:bg-green-700 p-2 rounded-md cursor-pointer">Prestamo</a>
			<a href="/Gestion-Biblioteca/reserva" class="h-auto text-white hover:bg-green-700 p-2 rounded-md cursor-pointer">Reservas</a>
		</div>
			<a class="mr-2 bg-white p-1 rounded text-green-700 font-medium hover:bg-green-700 hover:text-white hover:border hover:border-white" href="/Gestion-Biblioteca/prestar"></a>
		</div>
	</header>
    
    <main class="p-4">
    <div class="flex w-full justify-center p-4 gap-4 flex-wrap">
        <% if (libros != null && !libros.isEmpty()) { %>
            <% for (Libro libro : libros) { %>
                <div class="flex bg-gray-200 w-[200px] justify-center flex-col p-4 gap-1 items-center rounded-md border border-gray-300 hover:border-green-600 cursor-pointer">
                    <a href="libros?id=<%= libro.getIdLibro() %>">
                        <img class="rounded-sm" 
                             src="<%= (libro.getImagenUrl() != null && !libro.getImagenUrl().isEmpty()) ? libro.getImagenUrl() :  Constants.IMAGEN_PRODUCTO_DEFAULT %>" 
                             width="150px">
                        <span class="text-xs text-left text-green-600 font-medium"><%= libro.getIdLibro() %></span>
                        <span class="text-center font-bold text-blue-600 text-xl"><%= libro.getTitulo() %></span>
                        <span class="text-center font-bold text-gray-600 text-xs"><%= libro.getAutor() %></span>
                        <span class="w-full text-red-500 text-left text-xs"><%= libro.getDescripcion() %></span>
                    </a>
                    <button class="bg-orange-600 w-full text-white font-medium hover:bg-orange-700 p-1rounded cursor-pointer"onclick="prestarLibro(<%= libro.getIdLibro() %>)">+ Prestar Libro</button>
                </div>
            <% } %>
        <% } else { %>
            <p class="text-center text-gray-600">No hay libros disponibles.</p>
            <% } %>
        </div>

    </main>
</body>
<script>
	
	async function prestarLibro(idLibro){
		console.log('agregarCarrito', idLibro);
	
		fetch('/Gestion-Biblioteca/prestar?idLibro='+idLibro, {
			method: 'POST'
		});
	}

</script>
</html>