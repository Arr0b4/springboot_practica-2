package com.ieselrincon.HibernateUsuariosSpring.repositories;

import com.ieselrincon.HibernateUsuariosSpring.models.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
public interface EmpleadoRepository extends JpaRepository<Empleado, Integer> { }