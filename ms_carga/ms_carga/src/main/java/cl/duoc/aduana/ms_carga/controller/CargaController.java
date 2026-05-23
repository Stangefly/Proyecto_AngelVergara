package cl.duoc.aduana.ms_carga.controller;

import cl.duoc.aduana.ms_carga.dto.CargaRequestDTO;
import cl.duoc.aduana.ms_carga.dto.CargaResponseDTO;
import cl.duoc.aduana.ms_carga.service.CargaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cargas")
@RequiredArgsConstructor
public class CargaController {

    private final CargaService service;

    @GetMapping
    public ResponseEntity<List<CargaResponseDTO>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CargaResponseDTO> getById(@PathVariable Long id) {
        CargaResponseDTO response = service.getById(id);
        if (response == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<CargaResponseDTO> create(@Valid @RequestBody CargaRequestDTO requestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(requestDTO));
    }
}