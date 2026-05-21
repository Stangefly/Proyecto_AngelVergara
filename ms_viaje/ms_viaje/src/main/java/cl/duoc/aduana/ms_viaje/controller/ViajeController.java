package cl.duoc.aduana.ms_viaje.controller;

import cl.duoc.aduana.ms_viaje.dto.ViajeRequestDTO;
import cl.duoc.aduana.ms_viaje.dto.ViajeResponseDTO;
import cl.duoc.aduana.ms_viaje.service.ViajeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/Viajes")
@RequiredArgsConstructor
public class ViajeController {

    private final ViajeService service;

    @GetMapping
    public ResponseEntity<List<ViajeResponseDTO>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ViajeResponseDTO> getById(@PathVariable Long id) {
        ViajeResponseDTO response = service.getById(id);
        if (response == null) {
            return ResponseEntity.notFound().build(); // Devuelve 404 nativo si es null
        }
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<ViajeResponseDTO> create(@Valid @RequestBody ViajeRequestDTO requestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(requestDTO));
    }
}