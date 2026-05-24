package com.cohorte11.aerolineaapi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "pasajeros")
public class Pasajero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre no puede estar vacío")
    private String nombre;

    @NotBlank(message = "El apellido no puede estar vacío")
    private String apellido;

    @NotBlank(message = "El documento es obligatorio")
    private String documento;

    @NotBlank(message = "El email es obligatorio")
    @Email(message = "El email no tiene un formato válido")
    private String email;

    public Pasajero() {
    }

    public Pasajero(Long id, String nombre, String apellido, String documento, String email) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.documento = documento;
        this.email = email;
    }

    // GET ID
    public Long getId() {
        return id;
    }

    // SET ID
    public void setId(Long id) {
        this.id = id;
    }

    // GET NOMBRE
    public String getNombre() {
        return nombre;
    }

    // SET NOMBRE
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // GET APELLIDO
    public String getApellido() {
        return apellido;
    }

    // SET APELLIDO
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    // GET DOCUMENTO
    public String getDocumento() {
        return documento;
    }

    // SET DOCUMENTO
    public void setDocumento(String documento) {
        this.documento = documento;
    }

    // GET EMAIL
    public String getEmail() {
        return email;
    }

    // SET EMAIL
    public void setEmail(String email) {
        this.email = email;
    }
}