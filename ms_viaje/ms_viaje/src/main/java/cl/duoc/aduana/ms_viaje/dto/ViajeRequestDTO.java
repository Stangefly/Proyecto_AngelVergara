package cl.duoc.aduana.ms_viaje.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ViajeRequestDTO {
    @NotBlank(message = "La patente no puede estar vacía")
    private String patente;

    @NotBlank(message = "La marca no puede estar vacía")
    private String marca;

    @NotBlank(message = "El tipo no puede estar vacío")
    private String tipo;
}