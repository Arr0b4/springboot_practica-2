package controllers;
import models.Usuario;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
public class UsuarioController {
    public int createUsuario(String nombre, String apellido, String ciudad) {

        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Usuario.class)
                .buildSessionFactory();

        Session session = sessionFactory.openSession();

        Usuario usuario = new Usuario(nombre, apellido, ciudad);

        session.beginTransaction();
        session.persist(usuario);
        session.getTransaction().commit();

        int idGenerado = usuario.getId();

        session.close();
        sessionFactory.close();

        return idGenerado;
    }
    public String getUsuario(int id) {

        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Usuario.class)
                .buildSessionFactory();

        Session session = sessionFactory.openSession();

        session.beginTransaction();
        Usuario usuario = session.get(Usuario.class, id);
        session.getTransaction().commit();

        session.close();
        sessionFactory.close();

        if (usuario == null) {
            return "No existe un usuario con id " + id;
        }

        return usuario.toString();
    }
    public String updateUsuario(int id, String nuevoNombre) {

        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Usuario.class)
                .buildSessionFactory();
        Session session = sessionFactory.openSession();

        session.beginTransaction();
        Usuario usuario = session.get(Usuario.class, id);

        if (usuario == null) {
            session.getTransaction().commit();
            session.close();
            sessionFactory.close();
            return "No existe un usuario con id " + id;
        }

        usuario.setNombre(nuevoNombre);
        session.getTransaction().commit();

        session.close();
        sessionFactory.close();

        return "Usuario " + id + " actualizado";
    }
    public String deleteUsuario(int id) {

        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Usuario.class)
                .buildSessionFactory();

        Session session = sessionFactory.openSession();

        session.beginTransaction();
        Usuario usuario = session.get(Usuario.class, id);

        if (usuario == null) {
            session.getTransaction().commit();
            session.close();
            sessionFactory.close();
            return "No existe un usuario con id " + id;
        }

        session.remove(usuario);
        session.getTransaction().commit();

        session.close();
        sessionFactory.close();

        return "Usuario " + id + " eliminado";
    }
}