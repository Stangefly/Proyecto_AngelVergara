package cl.duoc.aduana.ms_auto.service;
import cl.duoc.aduana.ms_auto.dto.AutoRequestDTO;
import cl.duoc.aduana.ms_auto.dto.AutoResponseDTO;
import cl.duoc.aduana.ms_auto.model.mapper.AutoMapper;
import cl.duoc.aduana.ms_auto.repository.AutoRepository;
import cl.duoc.aduana.ms_auto.model.Auto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AutoService {

    private final AutoRepository repository;
    private final AutoMapper mapper;

    public List<AutoResponseDTO> getAll() {
        return mapper.toDtoList(repository.findAll());
    }

    public AutoResponseDTO getById(Long id) {
        return mapper.toDto(repository.findById(id).orElse(null));
    }

    public AutoResponseDTO create(AutoRequestDTO dto) {
        Auto guardado = repository.save(mapper.toEntity(dto));
        return mapper.toDto(guardado);
    }

    public AutoResponseDTO update(Long id, AutoRequestDTO dto) {
        Optional<Auto> autoExistente = repository.findById(id);
        if (autoExistente.isEmpty()) {
            return null;
        }
        Auto auto = autoExistente.get();
        auto.setPatente(dto.getPatente());
        auto.setMarca(dto.getMarca());
        auto.setTipo(dto.getTipo());

        return mapper.toDto(repository.save(auto));
    }

    public boolean delete(Long id) {
        if (!repository.existsById(id)) {
            return false;
        }
        repository.deleteById(id);
        return true;
    }
}