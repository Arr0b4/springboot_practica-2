package models;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "ciudad")
    private String ciudad;
    public Usuario() {
    }
    public Usuario(String nombre, String apellido, String ciudad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.ciudad = ciudad;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getCiudad() {
        return ciudad;
    }
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
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

    @Override
    public String toString() {
        return "Usuario [id=" + id
                + ", nombre=" + nombre
                + ", apellido=" + apellido
                + ", ciudad=" + ciudad + "]";
    }

}
