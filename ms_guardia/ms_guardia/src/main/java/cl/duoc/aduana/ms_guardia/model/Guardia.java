package cl.duoc.aduana.ms_guardia.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "guardia")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Guardia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String rut;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String rango;
}