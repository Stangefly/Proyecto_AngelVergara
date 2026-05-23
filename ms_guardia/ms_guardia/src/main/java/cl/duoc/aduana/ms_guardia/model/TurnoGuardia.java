package cl.duoc.aduana.ms_guardia.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Entity
@Table(name = "turno_guardia")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TurnoGuardia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_turno")
    private Long idTurno;

    @Column(name = "id_guardia", nullable = false)
    private Long idGuardia;

    @Column(name = "fecha_turno", nullable = false)
    private LocalDate fechaTurno;

    @Column(name = "sector_aduana", nullable = false)
    private String sectorAduana;
}