package cl.duoc.aduana.ms_insp.controller;

import cl.duoc.aduana.ms_insp.dto.InspeccionRequestDTO;
import cl.duoc.aduana.ms_insp.dto.InspeccionResponseDTO;
import cl.duoc.aduana.ms_insp.service.InspeccionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/inspeccions")
@RequiredArgsConstructor
public class InspeccionController {

    private final InspeccionService service;

    @GetMapping
    public ResponseEntity<List<InspeccionResponseDTO>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<InspeccionResponseDTO> getById(@PathVariable Long id) {
        InspeccionResponseDTO response = service.getById(id);
        if (response == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<InspeccionResponseDTO> create(@Valid @RequestBody InspeccionRequestDTO requestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(requestDTO));
    }
}