package view;
import models.Usuario;
import models.Departamento;
import models.Empleado;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
public class RelacionesView {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Usuario.class)
                .addAnnotatedClass(Departamento.class)
                .addAnnotatedClass(Empleado.class)
                .buildSessionFactory();
        try {
            int idDepartamento;
            // Guardar un departamento y dos empleados.
            try (Session session = factory.openSession()) {
                Transaction tx = session.beginTransaction();
                try {
                    Departamento d = new Departamento("Informática");
                    session.persist(d);
                    session.persist(new Empleado("Ana", d));
                    session.persist(new Empleado("Luis", d));
                    tx.commit();
                    idDepartamento = d.getId();
                } catch (RuntimeException e) {
                    if (tx.isActive()) tx.rollback();
                    throw e;
                }
            }
            // Comprobar la relación recuperando los datos.
            try (Session session = factory.openSession()) {
                session.beginTransaction();
                Departamento d = session.get(Departamento.class, idDepartamento);
                System.out.println("Departamento: " + d.getNombre());
                for (Empleado e : d.getEmpleados()) {
                    System.out.println("Empleado: " + e.getNombre());
                }
                session.getTransaction().commit();
            }
        } finally {
            factory.close();
        }
    }
}
