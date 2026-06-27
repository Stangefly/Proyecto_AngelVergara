package cl.duoc.aduana.ms_auto.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import io.swagger.v3.oas.annotations.media.Schema;


@Data
@Schema(description = "Objeto de transferencia de datos para registrar un auto")
public class AutoRequestDTO {

    @NotBlank
    @Schema(description = "Patente única del vehículo", example = "AB123CD")
    private String patente;

    @NotBlank
    @Schema(description = "Marca de fabricación del vehículo", example = "Toyota")
    private String marca;

    @NotBlank
    @Schema(description = "Tipo de vehículo o carrocería", example = "SUV")
    private String tipo;
}