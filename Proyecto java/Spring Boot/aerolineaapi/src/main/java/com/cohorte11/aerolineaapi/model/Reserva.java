package com.cohorte11.aerolineaapi.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime fechaReserva;

    @Enumerated(EnumType.STRING)
    private ClaseAsiento clase;

    @ManyToOne
    @JoinColumn(name = "pasajero_id", nullable = false)
    private Pasajero pasajero;

    @ManyToOne
    @JoinColumn(name = "vuelo_id", nullable = false)
    private Vuelo vuelo;

    public Reserva() {
    }

    public Reserva(LocalDateTime fechaReserva, ClaseAsiento clase, Pasajero pasajero, Vuelo vuelo) {
        this.fechaReserva = fechaReserva;
        this.clase = clase;
        this.pasajero = pasajero;
        this.vuelo = vuelo;
    }

    // GET ID
    public Long getId() {
        return id;
    }

    // SET ID
    public void setId(Long id) {
        this.id = id;
    }

    // GET FECHA RESERVA
    public LocalDateTime getFechaReserva() {
        return fechaReserva;
    }

    // SET FECHA RESERVA
    public void setFechaReserva(LocalDateTime fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    // GET CLASE
    public ClaseAsiento getClase() {
        return clase;
    }

    // SET CLASE
    public void setClase(ClaseAsiento clase) {
        this.clase = clase;
    }

    // GET PASAJERO
    public Pasajero getPasajero() {
        return pasajero;
    }

    // SET PASAJERO
    public void setPasajero(Pasajero pasajero) {
        this.pasajero = pasajero;
    }

    // GET VUELO
    public Vuelo getVuelo() {
        return vuelo;
    }

    // SET VUELO
    public void setVuelo(Vuelo vuelo) {
        this.vuelo = vuelo;
    }
}
