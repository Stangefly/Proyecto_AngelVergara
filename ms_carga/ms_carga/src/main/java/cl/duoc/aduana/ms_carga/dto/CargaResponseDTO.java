package cl.duoc.aduana.ms_carga.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CargaResponseDTO {
    private Long id;
    private String rut;
    private String nombre;
    private String rango;
}