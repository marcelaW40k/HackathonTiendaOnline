package com.cohorte11.aerolineaapi.controller;

import com.cohorte11.aerolineaapi.model.Vuelo;
import com.cohorte11.aerolineaapi.service.VueloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/vuelos")
public class VueloController {
    private final VueloService vueloService;

    @Autowired
    public VueloController(VueloService vueloService) {
        this.vueloService = vueloService;
    }

    @GetMapping
    public ResponseEntity<List<Vuelo>> obtenerTodos() {
        return ResponseEntity.ok(vueloService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vuelo> obtenerPorId(@PathVariable Long id) {
        Vuelo vuelo = vueloService.findById(id);
        return (vuelo == null) ? ResponseEntity.notFound().build() : ResponseEntity.ok(vuelo);
    }

    @PostMapping
    public ResponseEntity<Vuelo> crear(@Valid @RequestBody Vuelo vuelo) {
        Vuelo creado = vueloService.save(vuelo);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vuelo> actualizar(@PathVariable Long id, @Valid @RequestBody Vuelo datos) {
        Vuelo actualizado = vueloService.update(id, datos);
        return (actualizado == null) ? ResponseEntity.notFound().build() : ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        vueloService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
