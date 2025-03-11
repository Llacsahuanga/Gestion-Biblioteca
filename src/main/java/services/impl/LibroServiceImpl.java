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
            return mapper.listarLibros(); 
        } catch (Exception e) {
            System.out.println("Error al listar libros: " + e.getMessage());
            return null;
        }
    }

    @Override
    public void insertarLibro(Libro libro) {
        try (SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession()) {
            LibroMapper mapper = session.getMapper(LibroMapper.class);
            mapper.insertarLibro(libro);
            session.commit(); 
        } catch (Exception e) {
            System.out.println("Error al insertar el libro: " + e.getMessage());
        }
    }
	

}
