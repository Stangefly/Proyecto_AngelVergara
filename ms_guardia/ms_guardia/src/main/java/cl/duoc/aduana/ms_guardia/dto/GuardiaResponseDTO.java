package cl.duoc.aduana.ms_guardia.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GuardiaResponseDTO {
    private Long id;
    private String rut;
    private String nombre;
    private String rango;
}