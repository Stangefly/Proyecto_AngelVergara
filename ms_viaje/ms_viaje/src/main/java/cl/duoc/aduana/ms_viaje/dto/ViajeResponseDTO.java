package cl.duoc.aduana.ms_viaje.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ViajeResponseDTO {
    private Long id;
    private String patente;
    private String marca;
    private String tipo;
}