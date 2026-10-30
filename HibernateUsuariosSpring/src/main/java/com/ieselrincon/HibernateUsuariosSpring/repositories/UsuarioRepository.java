package com.ieselrincon.HibernateUsuariosSpring.repositories;

import com.ieselrincon.HibernateUsuariosSpring.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

// Spring Data JPA aporta save, findById, existsById y deleteById.
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> { }