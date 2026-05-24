package com.cohorte11.aerolineaapi.controller;



import com.cohorte11.aerolineaapi.model.Pasajero;
import com.cohorte11.aerolineaapi.service.PasajeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/pasajeros")
public class PasajeroController {

    private final PasajeroService pasajeroService;

    @Autowired
    public PasajeroController(PasajeroService pasajeroService) {
        this.pasajeroService = pasajeroService;
    }

    @GetMapping
    public ResponseEntity<List<Pasajero>> obtenerTodos() {
        return ResponseEntity.ok(pasajeroService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pasajero> obtenerPorId(@PathVariable Long id) {
        Pasajero pasajero = pasajeroService.findById(id);
        return (pasajero == null) ? ResponseEntity.notFound().build() : ResponseEntity.ok(pasajero);
    }

    @PostMapping
    public ResponseEntity<Pasajero> crear(@Valid @RequestBody Pasajero pasajero) {
        Pasajero creado = pasajeroService.save(pasajero);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pasajero> actualizar(@PathVariable Long id, @Valid @RequestBody Pasajero datos) {
        Pasajero actualizado = pasajeroService.update(id, datos);
        return (actualizado == null) ? ResponseEntity.notFound().build() : ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        pasajeroService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

