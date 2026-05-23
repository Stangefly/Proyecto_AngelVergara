package cl.duoc.aduana.ms_viaje.repository;

import cl.duoc.aduana.ms_viaje.model.HistorialViaje;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistorialViajeRepository extends JpaRepository<HistorialViaje, Long> {
}