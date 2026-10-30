package com.ieselrincon.HibernateUsuariosSpring.models;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "departamentos")
public class Departamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "nombre", length = 80, nullable = false)
    private String nombre;
    // "departamento" es el atributo de Empleado que controla la relación.
    @OneToMany(mappedBy = "departamento")
    private List<Empleado> empleados = new ArrayList<>();
    public Departamento() { }
    public Departamento(String nombre) { this.nombre = nombre; }
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public List<Empleado> getEmpleados() { return empleados; }
    public void setEmpleados(List<Empleado> empleados) { this.empleados = empleados; }
}