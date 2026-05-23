package cl.duoc.aduana.ms_guardia.repository;
import cl.duoc.aduana.ms_guardia.model.Guardia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuardiaRepository extends JpaRepository<Guardia, Long> {
}