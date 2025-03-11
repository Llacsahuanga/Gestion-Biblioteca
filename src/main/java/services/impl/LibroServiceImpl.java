package services.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import config.MyBatisUtil;
import dao.CategoriaMapper;
import dao.LibroMapper;
import models.Categoria;
import models.Libro;
import services.LibroService;


public class LibroServiceImpl implements LibroService {

	@Override
	public List<Libro> listarLibros() {
        try (SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession()) {
            LibroMapper mapper = session.getMapper(LibroMapper.class);
            return mapper.listarLibros(); // ✅ Llamar correctamente el método
        } catch (Exception e) {
            System.out.println("Error al listar libros: " + e.getMessage());
            return null;
        }
    }

    @Override
    public void insertarLibro(Libro libro) { // ✅ Método para insertar un libro
        try (SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession()) {
            LibroMapper mapper = session.getMapper(LibroMapper.class);
            mapper.insertarLibro(libro); // ✅ Llamar el método de inserción
            session.commit(); // ✅ Confirmar la transacción
        } catch (Exception e) {
            System.out.println("Error al insertar el libro: " + e.getMessage());
        }
    }

	

}
