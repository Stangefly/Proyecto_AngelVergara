package cl.duoc.aduana.ms_insp.model.mapper;
import cl.duoc.aduana.ms_insp.dto.InspeccionRequestDTO;
import cl.duoc.aduana.ms_insp.dto.InspeccionResponseDTO;
import cl.duoc.aduana.ms_insp.model.Inspeccion;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class InspeccionMapper {
    public InspeccionResponseDTO toDto(Inspeccion entity) {
        if (entity == null) return null;
        return new InspeccionResponseDTO(entity.getId(), entity.getRut(), entity.getNombre(), entity.getRango());
    }

    public Inspeccion toEntity(InspeccionRequestDTO dto) {
        if (dto == null) return null;
        Inspeccion entity = new Inspeccion();
        entity.setRut(dto.getRut());
        entity.setNombre(dto.getNombre());
        entity.setRango(dto.getRango());
        return entity;
    }

    public List<InspeccionResponseDTO> toDtoList(List<Inspeccion> entities) {
        return entities.stream().map(this::toDto).collect(Collectors.toList());
    }
}