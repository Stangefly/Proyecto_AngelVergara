package cl.duoc.aduana.ms_viaje.model.mapper;
import cl.duoc.aduana.ms_viaje.dto.ViajeRequestDTO;
import cl.duoc.aduana.ms_viaje.dto.ViajeResponseDTO;
import cl.duoc.aduana.ms_viaje.model.Viaje;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ViajeMapper {
    public ViajeResponseDTO toDto(Viaje entity) {
        if (entity == null) return null;
        return new ViajeResponseDTO(entity.getId(), entity.getPatente(), entity.getMarca(), entity.getTipo());
    }

    public Viaje toEntity(ViajeRequestDTO dto) {
        if (dto == null) return null;
        Viaje entity = new Viaje();
        entity.setPatente(dto.getPatente());
        entity.setMarca(dto.getMarca());
        entity.setTipo(dto.getTipo());
        return entity;
    }

    public List<ViajeResponseDTO> toDtoList(List<Viaje> entities) {
        return entities.stream().map(this::toDto).collect(Collectors.toList());
    }
}