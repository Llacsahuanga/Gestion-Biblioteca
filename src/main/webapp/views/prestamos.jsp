<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="models.Libro" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Préstamos</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <script src="https://unpkg.com/@tailwindcss/browser@4"></script>
    <script>
        function filtrarLibros(estado) {
            window.location.href = 'Prestamo?estado=' + estado;
        }
    </script>
</head>
<body class="bg-gray-400 p-6">

    <header>
		<div class="flex gap-4 bg-green-600 h-[50px] items-center justify-between">
		<div class="flex gap-4 justify-center w-full">
			<a href="/Gestion-Biblioteca" class="h-auto text-white hover:bg-green-700 p-2 rounded-md cursor-pointer">Inicio</a>
			<a href="/Gestion-Biblioteca/categorias" class="h-auto text-white hover:bg-green-700 p-2 rounded-md cursor-pointer">Categorías</a>
			<a href="/Gestion-Biblioteca/Prestamo" class="h-auto text-white hover:bg-green-700 p-2 rounded-md cursor-pointer border border-white border-solid">Prestamo</a>
			<a href="/Gestion-Biblioteca/reserva" class="h-auto text-white hover:bg-green-700 p-2 rounded-md cursor-pointer">Reservas</a>
		</div>
			<a class="mr-2 bg-white p-1 rounded text-green-700 font-medium hover:bg-green-700 hover:text-white hover:border hover:border-white" href="/Gestion-Biblioteca/prestar">Prestar Libro</a>
		</div>
	</header>

    <main class="p-4">
        <h2 class="text-xl font-bold text-black text-center mb-4">Lista de Libros para Préstamo</h2>

        <div class="flex justify-center gap-4 mb-4">
            <button onclick="filtrarLibros('DISPONIBLE')" class="bg-green-600 text-white p-2 rounded-md hover:bg-green-700">Ver Disponibles</button>
            <button onclick="filtrarLibros('NO DISPONIBLE')" class="bg-red-600 text-white p-2 rounded-md hover:bg-red-700">Ver No Disponibles</button>
            <button onclick="window.location.href='Prestamo'" class="bg-blue-600 text-white p-2 rounded-md hover:bg-blue-700">Mostrar Todos</button>
        </div>
        
        <% String error = (String) request.getAttribute("error"); %>
        <% if (error != null) { %>
            <p class="text-red-500 text-center"><%= error %></p>
        <% } %>

        <div class="overflow-x-auto">
            <table class="w-full border-collapse border border-gray-300">
                <thead class="bg-green-600 text-white">
                    <tr>
                        
                        <th class="border border-gray-300 p-2">Título</th>
                        <th class="border border-gray-300 p-2">Autor</th>
                        <th class="border border-gray-300 p-2">Código</th>
                        <th class="border border-gray-300 p-2">Estado</th>
                    </tr>
                </thead>
                <tbody>
                    <% List<Libro> libros = (List<Libro>) request.getAttribute("libros"); %>
                    <% if (libros != null && !libros.isEmpty()) { %>
                        <% for (Libro libro : libros) { %>
                            <tr class="bg-gray-200 hover:bg-gray-300">
                                <td class="border border-gray-300 p-2"><%= libro.getTitulo() %></td>
                                <td class="border border-gray-300 p-2"><%= libro.getAutor() %></td>
                                <td class="border border-gray-300 p-2"><%= libro.getCodigo() %></td>
                                <td class="border border-gray-300 p-2 text-center"><%= libro.getEstado() %></td>
                            </tr>
                        <% } %>
                    <% } else { %>
                        <tr>
                            <td colspan="6" class="text-center text-gray-600 p-4">No hay libros disponibles.</td>
                        </tr>
                    <% } %>
                </tbody>
            </table>
        </div>
    </main>

</body>
</html>
