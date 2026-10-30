package com.ieselrincon.HibernateUsuariosSpring.repositories;

import com.ieselrincon.HibernateUsuariosSpring.models.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> { }