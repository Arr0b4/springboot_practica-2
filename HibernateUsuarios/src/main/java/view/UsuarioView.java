package view;
import controllers.UsuarioController;
public class UsuarioView {
    public static void main(String[] args) {
        UsuarioController controlador = new UsuarioController();
        // CREATE: guardamos el id generado por MariaDB
        int id = controlador.createUsuario("Ana", "Pérez", "Las Palmas");
        System.out.println("Usuario creado con id: " + id);
        // READ
        System.out.println("Consulta: " + controlador.getUsuario(id));
        // UPDATE y nueva consulta
        System.out.println(controlador.updateUsuario(id, "Laura"));
        System.out.println("Después de actualizar: " + controlador.getUsuario(id));
        // DELETE y comprobación final
        System.out.println(controlador.deleteUsuario(id));
        System.out.println("Comprobación final: " + controlador.getUsuario(id));
    }
}