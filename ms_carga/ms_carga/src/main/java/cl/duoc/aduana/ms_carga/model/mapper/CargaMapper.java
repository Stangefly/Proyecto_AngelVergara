package cl.duoc.aduana.ms_carga.model.mapper;
import cl.duoc.aduana.ms_carga.dto.CargaRequestDTO;
import cl.duoc.aduana.ms_carga.dto.CargaResponseDTO;
import cl.duoc.aduana.ms_carga.model.Carga;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CargaMapper {
    public CargaResponseDTO toDto(Carga entity) {
        if (entity == null) return null;
        return new CargaResponseDTO(entity.getId(), entity.getRut(), entity.getNombre(), entity.getRango());
    }

    public Carga toEntity(CargaRequestDTO dto) {
        if (dto == null) return null;
        Carga entity = new Carga();
        entity.setRut(dto.getRut());
        entity.setNombre(dto.getNombre());
        entity.setRango(dto.getRango());
        return entity;
    }

    public List<CargaResponseDTO> toDtoList(List<Carga> entities) {
        return entities.stream().map(this::toDto).collect(Collectors.toList());
    }
}