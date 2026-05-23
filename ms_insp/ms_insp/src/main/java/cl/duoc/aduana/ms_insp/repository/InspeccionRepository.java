package cl.duoc.aduana.ms_insp.repository;
import cl.duoc.aduana.ms_insp.model.Inspeccion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InspeccionRepository extends JpaRepository<Inspeccion, Long> {
}