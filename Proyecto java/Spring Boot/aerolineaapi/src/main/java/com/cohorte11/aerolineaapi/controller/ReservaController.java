package com.cohorte11.aerolineaapi.controller;

import com.cohorte11.aerolineaapi.dto.ReservaRequestDTO;
import com.cohorte11.aerolineaapi.dto.ReservaResponseDTO;
import com.cohorte11.aerolineaapi.model.Reserva;
import com.cohorte11.aerolineaapi.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/reservas")
public class ReservaController {

    private final ReservaService reservaService;

    @Autowired
    public ReservaController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }

    // 🔹 Crear una reserva
    @PostMapping
    public ResponseEntity<ReservaResponseDTO> crearReserva(@RequestBody ReservaRequestDTO dto) {
        Reserva nueva = reservaService.save(dto);
        return ResponseEntity.ok(ReservaResponseDTO.desde(nueva));
    }


    // 🔹 Listar todas las reservas
    @GetMapping
    public ResponseEntity<List<ReservaResponseDTO>> listarReservas() {
        List<ReservaResponseDTO> reservas = reservaService.findAll()
                .stream()
                .map(ReservaResponseDTO::desde)
                .collect(Collectors.toList());
        return ResponseEntity.ok(reservas);
    }

    // 🔹 Obtener una reserva por ID
    @GetMapping("/{id}")
    public ResponseEntity<ReservaResponseDTO> obtenerPorId(@PathVariable Long id) {
        Reserva reserva = reservaService.findById(id);
        return ResponseEntity.ok(ReservaResponseDTO.desde(reserva));
    }

    // 🔹 Actualizar una reserva
    @PutMapping("/{id}")
    public ResponseEntity<ReservaResponseDTO> actualizarReserva(@PathVariable Long id,
                                                                @RequestBody ReservaRequestDTO dto) {
        Reserva actualizada = reservaService.update(id, dto);
        return ResponseEntity.ok(ReservaResponseDTO.desde(actualizada));
    }


    // 🔹 Eliminar una reserva
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarReserva(@PathVariable Long id) {
        reservaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
