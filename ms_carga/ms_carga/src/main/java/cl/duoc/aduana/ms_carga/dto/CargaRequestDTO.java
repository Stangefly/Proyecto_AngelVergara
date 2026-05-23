package cl.duoc.aduana.ms_carga.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CargaRequestDTO {
    @NotBlank(message = "El RUT no puede estar vacío")
    private String rut;

    @NotBlank(message = "El nombre no puede estar vacío")
    private String nombre;

    @NotBlank(message = "El rango no puede estar vacío")
    private String rango;
}