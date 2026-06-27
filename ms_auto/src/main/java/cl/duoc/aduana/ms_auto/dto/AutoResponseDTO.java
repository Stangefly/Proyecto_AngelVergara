package cl.duoc.aduana.ms_auto.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AutoResponseDTO {
    private Long id;
    private String patente;
    private String marca;
    private String tipo;
}