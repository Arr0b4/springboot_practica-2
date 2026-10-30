package com.ieselrincon.HibernateUsuariosSpring.controllers;

import com.ieselrincon.HibernateUsuariosSpring.models.Categoria;
import com.ieselrincon.HibernateUsuariosSpring.repositories.CategoriaRepository;
import java.util.List;
import org.springframework.stereotype.Service;
@Service
public class CategoriaController {
    private final CategoriaRepository repositorio;
    public CategoriaController(CategoriaRepository repositorio) {
        this.repositorio = repositorio;
    }
    public Categoria crear(String nombre, String descripcion) {
        Categoria categoria = new Categoria(nombre);
        categoria.setDescripcion(descripcion);
        return repositorio.save(categoria);
    }
    public List<Categoria> listar() {
        return repositorio.findAll();
    }
}