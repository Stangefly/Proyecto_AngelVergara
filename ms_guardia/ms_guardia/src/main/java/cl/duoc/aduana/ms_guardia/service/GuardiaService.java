package cl.duoc.aduana.ms_guardia.service;
import cl.duoc.aduana.ms_guardia.dto.GuardiaRequestDTO;
import cl.duoc.aduana.ms_guardia.dto.GuardiaResponseDTO;
import cl.duoc.aduana.ms_guardia.model.mapper.GuardiaMapper;
import cl.duoc.aduana.ms_guardia.repository.GuardiaRepository;
import cl.duoc.aduana.ms_guardia.model.Guardia;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GuardiaService {

    private final GuardiaRepository repository;
    private final GuardiaMapper mapper;

    public GuardiaResponseDTO getById(Long id) {
        return mapper.toDto(repository.findById(id).orElse(null));
    }

    public List<GuardiaResponseDTO> getAll() {
        return mapper.toDtoList(repository.findAll());
    }

    public GuardiaResponseDTO create(GuardiaRequestDTO dto) {
        Guardia guardado = repository.save(mapper.toEntity(dto));
        return mapper.toDto(guardado);
    }
}