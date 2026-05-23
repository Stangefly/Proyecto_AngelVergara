package cl.duoc.aduana.ms_insp.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InspeccionResponseDTO {
    private Long id;
    private String rut;
    private String nombre;
    private String rango;
}