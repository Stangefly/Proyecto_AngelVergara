package cl.duoc.aduana.ms_auto.service;
import cl.duoc.aduana.ms_auto.dto.AutoRequestDTO;
import cl.duoc.aduana.ms_auto.dto.AutoResponseDTO;
import cl.duoc.aduana.ms_auto.model.mapper.AutoMapper;
import cl.duoc.aduana.ms_auto.repository.AutoRepository;
import cl.duoc.aduana.ms_auto.model.Auto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class AutoService {

    private final AutoRepository repository;
    private final AutoMapper mapper;

    public AutoResponseDTO getById(Long id) {
        return mapper.toDto(repository.findById(id).orElse(null)
        );
    }

    public List<AutoResponseDTO> getAll() {
        return mapper.toDtoList(repository.findAll());
    }

    public AutoResponseDTO create(AutoRequestDTO dto) {
        Auto guardado = repository.save(mapper.toEntity(dto));
        return mapper.toDto(guardado);
    }
}