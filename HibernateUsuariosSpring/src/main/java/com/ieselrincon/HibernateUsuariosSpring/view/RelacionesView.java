package com.ieselrincon.HibernateUsuariosSpring.view;

import com.ieselrincon.HibernateUsuariosSpring.controllers.RelacionesController;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
@Component
@Profile("relaciones")
public class RelacionesView implements CommandLineRunner {
    private final RelacionesController controlador;
    public RelacionesView(RelacionesController controlador) {
        this.controlador = controlador;
    }
    @Override
    public void run(String... args) {
        Integer id = controlador.guardarDepartamentoConEmpleados();
        controlador.mostrarEmpleados(id);
    }
}

