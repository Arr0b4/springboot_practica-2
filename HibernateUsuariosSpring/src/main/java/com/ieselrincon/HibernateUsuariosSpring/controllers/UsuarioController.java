package com.ieselrincon.HibernateUsuariosSpring.controllers;

import com.ieselrincon.HibernateUsuariosSpring.models.Usuario;
import com.ieselrincon.HibernateUsuariosSpring.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;
@Service
public class UsuarioController {
    private final UsuarioRepository repositorio;
    public UsuarioController(UsuarioRepository repositorio) {
        this.repositorio = repositorio;
    }
    public Usuario createUsuario(String nombre, String apellido, String ciudad) {
        return repositorio.save(new Usuario(nombre, apellido, ciudad));
    }
    public Usuario getUsuario(Integer id) {
        return repositorio.findById(id).orElse(null);
    }
    public Usuario updateUsuario(Integer id, String nuevoNombre) {
        Usuario usuario = getUsuario(id);
        if (usuario == null) {
            return null;
        }
        usuario.setNombre(nuevoNombre);
        return repositorio.save(usuario);
    }
    public boolean deleteUsuario(Integer id) {
        if (!repositorio.existsById(id)) {
            return false;
        }
        repositorio.deleteById(id);
        return true;
    }
}