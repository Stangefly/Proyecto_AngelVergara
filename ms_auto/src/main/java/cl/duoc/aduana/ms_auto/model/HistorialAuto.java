package cl.duoc.aduana.ms_auto.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.util.Date;

@Entity
@Table(name="historial_auto")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HistorialAuto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_historial")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_auto")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Auto auto;

    @Column(name="fecha_cruce")
    private Date fechaCruce;

    private String estado; 
}