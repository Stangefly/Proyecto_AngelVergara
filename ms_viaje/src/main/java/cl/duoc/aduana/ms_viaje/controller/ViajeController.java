package cl.duoc.aduana.ms_viaje.controller;

import cl.duoc.aduana.ms_viaje.dto.ViajeRequestDTO;
import cl.duoc.aduana.ms_viaje.dto.ViajeResponseDTO;
import cl.duoc.aduana.ms_viaje.service.ViajeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/api/v1/viajes")
@RequiredArgsConstructor
public class ViajeController {

    private final ViajeService service;
    private final RestTemplate restTemplate; // <--- LA HERRAMIENTA DE INTEGRACION

    @GetMapping
    public ResponseEntity<List<ViajeResponseDTO>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ViajeResponseDTO> getById(@PathVariable Long id) {
        ViajeResponseDTO response = service.getById(id);
        if (response == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<ViajeResponseDTO> create(@Valid @RequestBody ViajeRequestDTO requestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(requestDTO));
    }

    // --- EL MÉTODO QUE SALVA LA RÚBRICA ---
    @GetMapping("/integracion/verificar-auto/{idAuto}")
    public ResponseEntity<String> verificarAutoEnAduana(@PathVariable Long idAuto) {
        // Llama al microservicio de autos en el puerto 8081
        String urlMsAuto = "http://localhost:8081/api/v1/autos/" + idAuto;
        try {
            String datosAuto = restTemplate.getForObject(urlMsAuto, String.class);
            return ResponseEntity.ok("INTEGRACIÓN EXITOSA CON ADUANA VECINA (ms_auto): " + datosAuto);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error de conexión entre sistemas: " + e.getMessage());
        }
    }
}