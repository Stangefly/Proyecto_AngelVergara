package cl.duoc.aduana.ms_viaje.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name="historial_viaje")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HistorialViaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_historial")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_viaje")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Viaje viaje;

    @Column(name="fecha_cruce")
    private Date fechaCruce;

    private String estado; 
}