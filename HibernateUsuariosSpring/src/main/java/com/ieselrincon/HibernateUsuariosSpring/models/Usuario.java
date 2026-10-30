package com.ieselrincon.HibernateUsuariosSpring.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "nombre", length = 50, nullable = false)
    private String nombre;
    @Column(name = "apellido", length = 80, nullable = false)
    private String apellido;
    @Column(name = "ciudad", length = 80)
    private String ciudad;
    public Usuario() { }
    public Usuario(String nombre, String apellido, String ciudad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.ciudad = ciudad;
    }
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }
    public String getCiudad() { return ciudad; }
    public void setCiudad(String ciudad) { this.ciudad = ciudad; }
    @Override
    public String toString() {
        return "Usuario{id=" + id + ", nombre='" + nombre
                + "', apellido='" + apellido + "', ciudad='" + ciudad + "'}";

    }}