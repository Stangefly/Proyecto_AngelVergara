package cl.duoc.aduana.ms_auto.controller;

import cl.duoc.aduana.ms_auto.dto.AutoRequestDTO;
import cl.duoc.aduana.ms_auto.dto.AutoResponseDTO;
import cl.duoc.aduana.ms_auto.service.AutoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/autos")
@RequiredArgsConstructor
@Tag(name = "Gestión de Autos", description = "Endpoints para la administración del cruce fronterizo de vehículos (CRUD)")
public class AutoController {

    private final AutoService service;

    @Operation(summary = "Listar todos los autos", description = "Obtiene una lista completa de todos los vehículos registrados en la base de datos de la aduana.")
    @ApiResponse(responseCode = "200", description = "Lista de autos obtenida con éxito")
    @GetMapping
    public ResponseEntity<List<AutoResponseDTO>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }


    @Operation(summary = "Buscar un auto por ID", description = "Busca un vehículo específico utilizando su identificador único del sistema.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Auto encontrado exitosamente",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = AutoResponseDTO.class))),
            @ApiResponse(responseCode = "404", description = "El auto no existe en los registros", content = @Content)
    })
    @GetMapping("/{id}")
    public ResponseEntity<AutoResponseDTO> getById(
            @Parameter(description = "ID único del auto a buscar", example = "1")
            @PathVariable Long id) {

        AutoResponseDTO response = service.getById(id);
        if (response == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(response);
    }


    @Operation(summary = "Registrar un nuevo auto", description = "Ingresa un nuevo vehículo al sistema aduanero. Valida que los datos obligatorios estén presentes.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Auto registrado exitosamente en la frontera"),
            @ApiResponse(responseCode = "400", description = "Datos inválidos en el formulario (ej: patente faltante)", content = @Content)
    })
    @PostMapping
    public ResponseEntity<AutoResponseDTO> create(
            @Parameter(description = "Caja de datos (JSON) con la información del auto nuevo")
            @Valid @RequestBody AutoRequestDTO requestDTO) {

        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(requestDTO));
    }

    @Operation(summary = "Actualizar datos de un auto", description = "Modifica la información de un vehículo ya existente mediante su ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Datos del auto actualizados con éxito"),
            @ApiResponse(responseCode = "404", description = "El auto que intenta actualizar no existe", content = @Content),
            @ApiResponse(responseCode = "400", description = "Los nuevos datos enviados son inválidos", content = @Content)
    })
    @PutMapping("/{id}")
    public ResponseEntity<AutoResponseDTO> update(
            @Parameter(description = "ID único del auto a modificar", example = "2") @PathVariable Long id,
            @Valid @RequestBody AutoRequestDTO requestDTO) {

        AutoResponseDTO response = service.update(id, requestDTO);
        if (response == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(response);
    }


    @Operation(summary = "Eliminar un auto", description = "Borra permanentemente un vehículo de los registros de la aduana utilizando su ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Auto eliminado exitosamente (Sin contenido de retorno)"),
            @ApiResponse(responseCode = "404", description = "El auto que intenta borrar no existe", content = @Content)
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @Parameter(description = "ID del auto que será destruido", example = "3")
            @PathVariable Long id) {

        boolean borrado = service.delete(id);
        if (!borrado) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
}