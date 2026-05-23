package cl.duoc.aduana.ms_carga.service;

import cl.duoc.aduana.ms_carga.dto.CargaRequestDTO;
import cl.duoc.aduana.ms_carga.dto.CargaResponseDTO;
import cl.duoc.aduana.ms_carga.model.Carga;
import cl.duoc.aduana.ms_carga.model.mapper.CargaMapper;
import cl.duoc.aduana.ms_carga.repository.CargaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CargaService {

    private final CargaRepository repository;
    private final CargaMapper mapper;

    public CargaResponseDTO getById(Long id) {
        return mapper.toDto(repository.findById(id).orElse(null));
    }

    public List<CargaResponseDTO> getAll() {
        return mapper.toDtoList(repository.findAll());
    }

    public CargaResponseDTO create(CargaRequestDTO dto) {
        Carga guardado = repository.save(mapper.toEntity(dto));
        return mapper.toDto(guardado);
    }
}