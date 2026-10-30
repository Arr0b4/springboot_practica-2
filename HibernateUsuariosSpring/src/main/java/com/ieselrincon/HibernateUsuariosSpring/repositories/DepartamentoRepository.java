package com.ieselrincon.HibernateUsuariosSpring.repositories;

import com.ieselrincon.HibernateUsuariosSpring.models.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;
public interface DepartamentoRepository extends JpaRepository<Departamento, Integer> { }