package com.cohorte11.aerolineaapi.repository;

import com.cohorte11.aerolineaapi.model.Pasajero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PasajeroRepository extends JpaRepository<Pasajero, Long> {}
