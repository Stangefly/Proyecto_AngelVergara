package cl.duoc.aduana.ms_auto.model.mapper;
import cl.duoc.aduana.ms_auto.dto.AutoRequestDTO;
import cl.duoc.aduana.ms_auto.dto.AutoResponseDTO;
import cl.duoc.aduana.ms_auto.model.Auto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AutoMapper {
    public AutoResponseDTO toDto(Auto entity) {
        if (entity == null) return null;
        return new AutoResponseDTO(entity.getId(), entity.getPatente(), entity.getMarca(), entity.getTipo());
    }

    public Auto toEntity(AutoRequestDTO dto) {
        if (dto == null) return null;
        Auto entity = new Auto();
        entity.setPatente(dto.getPatente());
        entity.setMarca(dto.getMarca());
        entity.setTipo(dto.getTipo());
        return entity;
    }

    public List<AutoResponseDTO> toDtoList(List<Auto> entities) {
        return entities.stream().map(this::toDto).collect(Collectors.toList());
    }
}