package cl.duoc.aduana.ms_insp.service;

import cl.duoc.aduana.ms_insp.dto.InspeccionRequestDTO;
import cl.duoc.aduana.ms_insp.dto.InspeccionResponseDTO;
import cl.duoc.aduana.ms_insp.model.Inspeccion;
import cl.duoc.aduana.ms_insp.model.mapper.InspeccionMapper;
import cl.duoc.aduana.ms_insp.repository.InspeccionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InspeccionService {

    private final InspeccionRepository repository;
    private final InspeccionMapper mapper;

    public InspeccionResponseDTO getById(Long id) {
        return mapper.toDto(repository.findById(id).orElse(null));
    }

    public List<InspeccionResponseDTO> getAll() {
        return mapper.toDtoList(repository.findAll());
    }

    public InspeccionResponseDTO create(InspeccionRequestDTO dto) {
        Inspeccion guardado = repository.save(mapper.toEntity(dto));
        return mapper.toDto(guardado);
    }
}