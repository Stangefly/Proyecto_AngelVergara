package cl.duoc.aduana.ms_guardia.controller;

import cl.duoc.aduana.ms_guardia.dto.GuardiaRequestDTO;
import cl.duoc.aduana.ms_guardia.dto.GuardiaResponseDTO;
import cl.duoc.aduana.ms_guardia.service.GuardiaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/guardias")
@RequiredArgsConstructor
public class GuardiaController {

    private final GuardiaService service;

    @GetMapping
    public ResponseEntity<List<GuardiaResponseDTO>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GuardiaResponseDTO> getById(@PathVariable Long id) {
        GuardiaResponseDTO response = service.getById(id);
        if (response == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<GuardiaResponseDTO> create(@Valid @RequestBody GuardiaRequestDTO requestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(requestDTO));
    }
}