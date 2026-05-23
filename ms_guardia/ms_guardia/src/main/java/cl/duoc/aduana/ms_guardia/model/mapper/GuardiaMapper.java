package cl.duoc.aduana.ms_guardia.model.mapper;
import cl.duoc.aduana.ms_guardia.dto.GuardiaRequestDTO;
import cl.duoc.aduana.ms_guardia.dto.GuardiaResponseDTO;
import cl.duoc.aduana.ms_guardia.model.Guardia;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GuardiaMapper {
    public GuardiaResponseDTO toDto(Guardia entity) {
        if (entity == null) return null;
        return new GuardiaResponseDTO(entity.getId(), entity.getRut(), entity.getNombre(), entity.getRango());
    }

    public Guardia toEntity(GuardiaRequestDTO dto) {
        if (dto == null) return null;
        Guardia entity = new Guardia();
        entity.setRut(dto.getRut());
        entity.setNombre(dto.getNombre());
        entity.setRango(dto.getRango());
        return entity;
    }

    public List<GuardiaResponseDTO> toDtoList(List<Guardia> entities) {
        return entities.stream().map(this::toDto).collect(Collectors.toList());
    }
}