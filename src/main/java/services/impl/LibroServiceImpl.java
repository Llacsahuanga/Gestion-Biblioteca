package services.impl;

import java.util.Collections;

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
    @Override
    public List<Libro> filtrarPorEstado(String estado) {
        try (SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession()) {
            LibroMapper mapper = session.getMapper(LibroMapper.class);
            return mapper.filtrarPorEstado(estado);
        } catch (Exception e) {
            System.out.println("Error al filtrar libros por estado: " + e.getMessage());
            return Collections.emptyList();
        }
    }

	@Override
	public List<Libro> listarLibrosPorIdSubcategoria(Integer idSubcategoria) {
		try (SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession()) {
	        LibroMapper libroMapper = session.getMapper(LibroMapper.class);
	        return libroMapper.listarLibrosPorIdSubcategoria(idSubcategoria);
	    } catch (Exception e) {
	        System.out.println("Error al listar libros por subcategoría: " + e.getMessage());
	        return null;
	    }
	}

	@Override
	public Libro obtenerLibroPorId(int id) {
		try (SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession()) {
            LibroMapper productoMapper = session.getMapper(LibroMapper.class);
            return productoMapper.buscarPorId(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
}
    
	
}
