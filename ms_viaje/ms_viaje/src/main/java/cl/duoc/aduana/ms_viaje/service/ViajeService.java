package cl.duoc.aduana.ms_viaje.service;

import cl.duoc.aduana.ms_viaje.dto.ViajeRequestDTO;
import cl.duoc.aduana.ms_viaje.dto.ViajeResponseDTO;
import cl.duoc.aduana.ms_viaje.model.Viaje;
import cl.duoc.aduana.ms_viaje.model.mapper.ViajeMapper;
import cl.duoc.aduana.ms_viaje.repository.ViajeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ViajeService {

    private final ViajeRepository repository;
    private final ViajeMapper mapper;

    public ViajeResponseDTO getById(Long id) {
        // Estilo exacto del profesor: orElse(null)
        return mapper.toDto(
                repository.findById(id).orElse(null)
        );
    }

    public List<ViajeResponseDTO> getAll() {
        return mapper.toDtoList(repository.findAll());
    }

    public ViajeResponseDTO create(ViajeRequestDTO dto) {
        Viaje guardado = repository.save(mapper.toEntity(dto));
        return mapper.toDto(guardado);
    }
}