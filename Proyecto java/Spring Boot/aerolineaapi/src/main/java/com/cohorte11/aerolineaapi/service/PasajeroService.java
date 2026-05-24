package com.cohorte11.aerolineaapi.service;


import com.cohorte11.aerolineaapi.model.Pasajero;
import com.cohorte11.aerolineaapi.repository.PasajeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PasajeroService {

    private final PasajeroRepository pasajeroRepository;

    @Autowired
    public PasajeroService(PasajeroRepository pasajeroRepository) {
        this.pasajeroRepository = pasajeroRepository;
    }

    public List<Pasajero> findAll() {
        return pasajeroRepository.findAll();
    }

    public Pasajero findById(Long id) {
        return pasajeroRepository.findById(id).orElse(null);
    }

    public Pasajero save(Pasajero pasajero) {
        return pasajeroRepository.save(pasajero);
    }

    public Pasajero update(Long id, Pasajero datos) {
        Pasajero existente = findById(id);
        if (existente == null) return null;

        existente.setNombre(datos.getNombre());
        existente.setApellido(datos.getApellido());
        existente.setDocumento(datos.getDocumento());
        existente.setEmail(datos.getEmail());

        return pasajeroRepository.save(existente);
    }

    public void delete(Long id) {
        pasajeroRepository.deleteById(id);
    }
}

