package cl.duoc.aduana.ms_viaje.repository;

import cl.duoc.aduana.ms_viaje .model.Viaje;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ViajeRepository extends JpaRepository<Viaje, Long> {
}
