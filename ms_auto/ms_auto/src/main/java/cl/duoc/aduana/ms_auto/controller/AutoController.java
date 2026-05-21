package cl.duoc.aduana.ms_auto.controller;

import cl.duoc.aduana.ms_auto.dto.AutoRequestDTO;
import cl.duoc.aduana.ms_auto.dto.AutoResponseDTO;
import cl.duoc.aduana.ms_auto.service.AutoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/autos")
@RequiredArgsConstructor
public class AutoController {

    private final AutoService service;

    @GetMapping
    public ResponseEntity<List<AutoResponseDTO>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AutoResponseDTO> getById(@PathVariable Long id) {
        AutoResponseDTO response = service.getById(id);
        if (response == null) {
            return ResponseEntity.notFound().build(); // Devuelve 404 nativo si es null
        }
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<AutoResponseDTO> create(@Valid @RequestBody AutoRequestDTO requestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(requestDTO));
    }
}