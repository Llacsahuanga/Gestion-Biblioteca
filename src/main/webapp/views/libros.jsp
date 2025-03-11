<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="models.Libro" %>
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
			<a href="/Gestion-Biblioteca/categorias" class="h-auto text-white hover:bg-green-700 p-2 rounded-md cursor-pointer">Categorías</a>
			<a href="/Gestion-Biblioteca/libros" class="h-auto text-white hover:bg-green-700 p-2 rounded-md cursor-pointer border border-white border-solid">Libros</a>
			<a class="h-auto text-white hover:bg-green-700 p-2 rounded-md cursor-pointer">Reservas</a>
			<a class="h-auto text-white hover:bg-green-700 p-2 rounded-md cursor-pointer">Prestamo</a>
		</div>
	</header>
	
	<main class="p-4">
		<h2 class="text-xl font-bold text-blak-700 text-center mb-4">Lista de Libros</h2>

		<!-- Mensaje de error si existe -->
		<% String error = (String) request.getAttribute("error"); 
		   if (error != null) { %>
			<p class="text-red-500 text-center"><%= error %></p>
		<% } %>

		<!-- Obtener la lista de libros -->
		<%
			List<Libro> libros = (List<Libro>) request.getAttribute("libros");
			if (libros != null && !libros.isEmpty()) {
		%>
			<div class="overflow-x-auto">
				<table class="w-full border-collapse border border-gray-300">
					<thead class="bg-green-600 text-white">
						<tr>
							<th class="border border-gray-300 p-2">ID</th>
							<th class="border border-gray-300 p-2">Título</th>
							<th class="border border-gray-300 p-2">Autor</th>
							<th class="border border-gray-300 p-2">Año</th>
							<th class="border border-gray-300 p-2">Código</th>
							<th class="border border-gray-300 p-2">Descripción</th>
							<th class="border border-gray-300 p-2">Estado</th>
							<th class="border border-gray-300 p-2">Fecha Creación</th>
						</tr>
					</thead>
					<tbody>
						<% for (Libro libro : libros) { %>
							<tr class="bg-gray-200 hover:bg-gray-300">
								<td class="border border-gray-300 p-2 text-center"><%= libro.getIdLibro() %></td>
								<td class="border border-gray-300 p-2"><%= libro.getTitulo() %></td>
								<td class="border border-gray-300 p-2"><%= libro.getAutor() %></td>
								<td class="border border-gray-300 p-2 text-center"><%= libro.getAnioPublicacion() %></td>
								<td class="border border-gray-300 p-2"><%= libro.getCodigo() %></td>
								<td class="border border-gray-300 p-2"><%= libro.getDescripcion() %></td>
								<td class="border border-gray-300 p-2 text-center"><%= libro.getEstado() %></td>
								<td class="border border-gray-300 p-2 text-center"><%= libro.getFechaCreacion() %></td>
							</tr>
						<% } %>
					</tbody>
				</table>
			</div>
		<% } else { %>
			<p class="text-center text-gray-600">No hay libros disponibles.</p>
		<% } %>

		<h2 class="text-xl font-bold text-blak-700 text-center mt-6">Agregar Nuevo Libro</h2>

		<form action="libros" method="post" class="max-w-lg mx-auto bg-white p-4 rounded-md shadow-md">
			<div class="mb-2">
				<label for="idEditorial" class="block text-gray-600">ID Editorial:</label>
				<input type="number" name="idEditorial" required class="w-full p-2 border border-gray-300 rounded-md">
			</div>

			<div class="mb-2">
				<label for="idCategoria" class="block text-gray-600">ID Categoría:</label>
				<input type="number" name="idCategoria" required class="w-full p-2 border border-gray-300 rounded-md">
			</div>

			<div class="mb-2">
				<label for="titulo" class="block text-gray-600">Título:</label>
				<input type="text" name="titulo" required class="w-full p-2 border border-gray-300 rounded-md">
			</div>

			<div class="mb-2">
				<label for="autor" class="block text-gray-600">Autor:</label>
				<input type="text" name="autor" required class="w-full p-2 border border-gray-300 rounded-md">
			</div>

			<div class="mb-2">
				<label for="anioPublicacion" class="block text-gray-600">Año de Publicación:</label>
				<input type="number" name="anioPublicacion" required class="w-full p-2 border border-gray-300 rounded-md">
			</div>

			<div class="mb-2">
				<label for="codigo" class="block text-gray-600">Código:</label>
				<input type="text" name="codigo" required class="w-full p-2 border border-gray-300 rounded-md">
			</div>

			<div class="mb-2">
				<label for="descripcion" class="block text-gray-600">Descripción:</label>
				<input type="text" name="descripcion" required class="w-full p-2 border border-gray-300 rounded-md">
			</div>

			<div class="mb-2">
				<label for="estado" class="block text-gray-600">Estado:</label>
				<select name="estado" class="w-full p-2 border border-gray-300 rounded-md">
					<option value="Disponible">Disponible</option>
					<option value="No disponible">No disponible</option>
				</select>
			</div>

			<div class="mb-4">
				<label for="estadoAuditoria" class="block text-gray-600">Estado Auditoría:</label>
				<input type="text" name="estadoAuditoria" required class="w-full p-2 border border-gray-300 rounded-md">
			</div>

			<button type="submit" class="w-full bg-green-600 text-white p-2 rounded-md hover:bg-green-700">
				Agregar Libro
			</button>
		</form>

	</main>
	
</body>
</html>