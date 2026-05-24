package com.cohorte11.aerolineaapi.service;

import com.cohorte11.aerolineaapi.dto.ReservaRequestDTO;
import com.cohorte11.aerolineaapi.model.Pasajero;
import com.cohorte11.aerolineaapi.model.Reserva;
import com.cohorte11.aerolineaapi.model.Vuelo;
import com.cohorte11.aerolineaapi.repository.PasajeroRepository;
import com.cohorte11.aerolineaapi.repository.ReservaRepository;
import com.cohorte11.aerolineaapi.repository.VueloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaService {

    private final ReservaRepository reservaRepository;
    private final PasajeroRepository pasajeroRepository;
    private final VueloRepository vueloRepository;

    @Autowired
    public ReservaService(ReservaRepository reservaRepository,
                          PasajeroRepository pasajeroRepository,
                          VueloRepository vueloRepository) {
        this.reservaRepository = reservaRepository;
        this.pasajeroRepository = pasajeroRepository;
        this.vueloRepository = vueloRepository;
    }

    public List<Reserva> findAll() {
        return reservaRepository.findAll();
    }

    public Reserva findById(Long id) {
        return reservaRepository.findById(id).orElse(null);
    }

    // ✅ Aquí va tu método corregido
    public Reserva save(ReservaRequestDTO dto) {
        Pasajero pasajero = pasajeroRepository.findById(dto.getPasajeroId())
                .orElseThrow(() -> new RuntimeException("Pasajero no encontrado"));
        Vuelo vuelo = vueloRepository.findById(dto.getVueloId())
                .orElseThrow(() -> new RuntimeException("Vuelo no encontrado"));

        Reserva reserva = new Reserva(dto.getFechaReserva(), dto.getClase(), pasajero, vuelo);
        return reservaRepository.save(reserva);
    }

    public Reserva update(Long id, ReservaRequestDTO dto) {
        Reserva existente = findById(id);
        if (existente == null) return null;

        Pasajero pasajero = pasajeroRepository.findById(dto.getPasajeroId())
                .orElseThrow(() -> new RuntimeException("Pasajero no encontrado"));
        Vuelo vuelo = vueloRepository.findById(dto.getVueloId())
                .orElseThrow(() -> new RuntimeException("Vuelo no encontrado"));

        existente.setFechaReserva(dto.getFechaReserva());
        existente.setClase(dto.getClase());
        existente.setPasajero(pasajero);
        existente.setVuelo(vuelo);

        return reservaRepository.save(existente);
    }

    public void delete(Long id) {
        reservaRepository.deleteById(id);
    }
}
