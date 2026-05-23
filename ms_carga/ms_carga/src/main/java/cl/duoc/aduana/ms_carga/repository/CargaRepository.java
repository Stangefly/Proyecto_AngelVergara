package cl.duoc.aduana.ms_carga.repository;
import cl.duoc.aduana.ms_carga.model.Carga;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CargaRepository extends JpaRepository<Carga, Long> {
}