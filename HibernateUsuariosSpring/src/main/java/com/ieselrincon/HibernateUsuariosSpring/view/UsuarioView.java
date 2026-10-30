package com.ieselrincon.HibernateUsuariosSpring.view;

import com.ieselrincon.HibernateUsuariosSpring.controllers.UsuarioController;
import com.ieselrincon.HibernateUsuariosSpring.models.Usuario;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
@Component
@Profile("usuarios")
public class UsuarioView implements CommandLineRunner {
    private final UsuarioController controlador;
    public UsuarioView(UsuarioController controlador) {
        this.controlador = controlador;
    }
    @Override
    public void run(String... args) {
        Usuario creado = controlador.createUsuario("Ana", "Pérez", "Las Palmas");
        Integer id = creado.getId(); // Id generado por MariaDB.
        System.out.println("CREAR: " + creado);
        System.out.println("CONSULTAR: " + controlador.getUsuario(id));
        Usuario actualizado = controlador.updateUsuario(id, "Laura");
        System.out.println("ACTUALIZAR: " + actualizado);
        System.out.println("VOLVER A CONSULTAR: " + controlador.getUsuario(id));
        System.out.println("ELIMINAR: " + controlador.deleteUsuario(id));
        System.out.println("DESPUÉS DE ELIMINAR: " + controlador.getUsuario(id));
    }}
