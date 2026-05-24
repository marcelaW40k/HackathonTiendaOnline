package com.cohorte11.aerolineaapi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

@Entity
public class Vuelo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El origen no puede estar vacío")
    private String origen;

    @NotBlank(message = "El destino no puede estar vacío")
    private String destino;

    @NotNull(message = "La fecha y hora del vuelo son obligatorias")
    private LocalDateTime fechaHora;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "El estado del vuelo es obligatorio")
    private EstadoVuelo estado;

    public Vuelo() {
    }

    public Vuelo(Long id, String origen, String destino, LocalDateTime fechaHora, EstadoVuelo estado) {
        this.id = id;
        this.origen = origen;
        this.destino = destino;
        this.fechaHora = fechaHora;
        this.estado = estado;
    }

    // GET ID
    public Long getId() {
        return id;
    }

    // SET ID
    public void setId(Long id) {
        this.id = id;
    }

    // GET ORIGEN
    public String getOrigen() {
        return origen;
    }

    // SET ORIGEN
    public void setOrigen(String origen) {
        this.origen = origen;
    }

    // GET DESTINO
    public String getDestino() {
        return destino;
    }

    // SET DESTINO
    public void setDestino(String destino) {
        this.destino = destino;
    }

    // GET FECHA HORA
    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    // SET FECHA HORA
    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    // GET ESTADO
    public EstadoVuelo getEstado() {
        return estado;
    }

    // SET ESTADO
    public void setEstado(EstadoVuelo estado) {
        this.estado = estado;
    }
}
