package com.ieselrincon.HibernateUsuariosSpring.controllers;

import com.ieselrincon.HibernateUsuariosSpring.models.Departamento;
import com.ieselrincon.HibernateUsuariosSpring.models.Empleado;
import com.ieselrincon.HibernateUsuariosSpring.repositories.DepartamentoRepository;
import com.ieselrincon.HibernateUsuariosSpring.repositories.EmpleadoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
public class RelacionesController {
    private final DepartamentoRepository departamentos;
    private final EmpleadoRepository empleados;
    public RelacionesController(DepartamentoRepository departamentos,
                                EmpleadoRepository empleados) {
        this.departamentos = departamentos;
        this.empleados = empleados;
    }
    // Una transacción guarda el departamento y sus dos empleados.
    @Transactional
    public Integer guardarDepartamentoConEmpleados() {
        Departamento departamento = departamentos.save(new Departamento("Informática"));
        empleados.save(new Empleado("Ana", departamento));
        empleados.save(new Empleado("Luis", departamento));
        return departamento.getId();
    }
    // Una transacción nueva permite cargar la colección de empleados.
    @Transactional(readOnly = true)
    public void mostrarEmpleados(Integer idDepartamento) {
        Departamento departamento = departamentos.findById(idDepartamento)
                .orElseThrow(() -> new IllegalArgumentException("Departamento inexistente"));
        System.out.println("Departamento: " + departamento.getNombre());
        for (Empleado empleado : departamento.getEmpleados()) {
            System.out.println("Empleado: " + empleado.getNombre());
        }
    }
}