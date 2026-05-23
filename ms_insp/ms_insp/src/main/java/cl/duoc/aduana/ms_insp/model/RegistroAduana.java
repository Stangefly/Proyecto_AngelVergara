package cl.duoc.aduana.ms_insp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name = "registro_aduana")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegistroAduana {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_registro")
    private Long idRegistro;

    @Column(name = "id_inspeccion", nullable = false)
    private Long idInspeccion;

    @Column(name = "fecha_registro", nullable = false)
    private LocalDateTime fechaRegistro;

    @Column(name = "monto_impuesto")
    private Double montoImpuesto;
}