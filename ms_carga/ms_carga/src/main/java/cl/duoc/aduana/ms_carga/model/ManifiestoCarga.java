package cl.duoc.aduana.ms_carga.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "manifiesto_carga")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ManifiestoCarga {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_manifiesto")
    private Long idManifiesto;

    @Column(name = "id_carga", nullable = false)
    private Long idCarga;

    @Column(name = "origen", nullable = false)
    private String origen;

    @Column(name = "destino", nullable = false)
    private String destino;
}