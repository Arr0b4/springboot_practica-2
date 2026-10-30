package com.ieselrincon.HibernateUsuariosSpring.view;


import com.ieselrincon.HibernateUsuariosSpring.controllers.CategoriaController;
import com.ieselrincon.HibernateUsuariosSpring.models.Categoria;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
@Component
@Profile("categorias")
public class CategoriaView implements CommandLineRunner {
    private final CategoriaController controlador;
    public CategoriaView(CategoriaController controlador) {
        this.controlador = controlador;
    }
    @Override
    public void run(String... args) {
        Categoria creada = controlador.crear("Software", "Aplicaciones informáticas");
        System.out.println("CATEGORÍA CREADA, ID: " + creada.getId());
        for (Categoria categoria : controlador.listar()) {
            System.out.println("CATEGORÍA: " + categoria.getId() + " - "
                    + categoria.getNombre() + " - " + categoria.getDescripcion());
        }
    }
}

