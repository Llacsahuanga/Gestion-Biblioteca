<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="models.Categoria" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>GESTION BIBLIOTECA</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<script src="https://unpkg.com/@tailwindcss/browser@4"></script>
</head>
<body class="bg-gray-400">

	<header>
		<div class="flex gap-4 bg-green-600 justify-center h-[50px] items-center">
			<a href="/Gestion-Biblioteca" class="h-auto text-white hover:bg-green-700 p-2 rounded-md cursor-pointer">Inicio</a>
			<a href="/Gestion-Biblioteca/categorias" class="h-auto text-white hover:bg-green-700 p-2 rounded-md cursor-pointer border border-white border-solid">Categorías</a>
			<a href="/Gestion-Biblioteca/libros" class="h-auto text-white hover:bg-green-700 p-2 rounded-md cursor-pointer">Libros</a>
			<a href="/Gestion-Biblioteca/Prestamo" class="h-auto text-white hover:bg-green-700 p-2 rounded-md cursor-pointer">Prestamo</a>
			<a class="h-auto text-white hover:bg-green-700 p-2 rounded-md cursor-pointer">Reservas</a>
		</div>
	</header>
	
	<main class="p-4">
		<div class="flex w-full justify-center p-4 gap-4 flex-wrap">
			<%
				List<Categoria> categorias = (List<Categoria>) request.getAttribute("categorias");
				if (categorias != null && !categorias.isEmpty()) {
					for(Categoria categoria: categorias) {
			%>
				<div class="flex bg-gray-200 w-[200px] justify-center flex-col p-4 gap-2 items-center rounded-md border border-gray-300 border-solid hover:border-green-600 cursor-pointer">
					<img class="rounded-sm" src="<%= categoria.getImagenUrl() %>" width="150px">
					<p class="text-center font-bold text-gray-600"><%= categoria.getNombre() %></p>
					
					<!-- Botón "Ver Libros" (sin funcionalidad) -->
					<button class="bg-blue-500 text-white px-4 py-2 rounded hover:bg-blue-700 w-full">Ver Libros</button>

					<!-- Botón "Eliminar" (sin funcionalidad) -->
					<button class="bg-red-500 text-white px-4 py-2 rounded hover:bg-red-700 w-full">Eliminar</button>
				</div>
			<% 	} %>
			<%	} else { %>
				<p>No se encontraron registros</p>
			<% } %>
		</div>
		<div>Total registros: <%= categorias.size() %></div>
		
	</main>
	
</body>
</html>
