package cl.thinkcloud.boxplanner.crud.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.thinkcloud.boxplanner.crud.dto.EstSubmodeloDTO;
import cl.thinkcloud.boxplanner.crud.entity.EstSub_modeloEntity;
import cl.thinkcloud.boxplanner.crud.repository.EstSubmodeloRepository;

@Service
public class CrudServiceEstSubmodeloImpl implements Iest_submodeloService {

    private final Logger logger = LoggerFactory.getLogger(CrudServiceEstSubmodeloImpl.class);

    @Autowired
    private EstSubmodeloRepository estSubmodeloRepository;

    private EstSub_modeloEntity convertDtoToEntity(EstSubmodeloDTO dto) {
        logger.info("Service - convertDtoToEntity");
        EstSub_modeloEntity entity = new EstSub_modeloEntity();
        entity.setId(dto.getId());
        entity.setNombre(dto.getNombre());
        entity.setAlias(dto.getAlias());
        entity.setDescripcion(dto.getDescripcion());
        entity.setFechaRegistro(dto.getFechaRegistro());
        return entity;
    }

    private EstSubmodeloDTO convertEntityToDto(EstSub_modeloEntity entity) {
        logger.info("Service - convertEntityToDto");
        EstSubmodeloDTO dto = new EstSubmodeloDTO();
        dto.setId(entity.getId());
        dto.setNombre(entity.getNombre());
        dto.setAlias(entity.getAlias());
        dto.setDescripcion(entity.getDescripcion());
        dto.setFechaRegistro(entity.getFechaRegistro());
        return dto;
    }

    @Override
    public List<EstSubmodeloDTO> findAll() {
        Iterable<EstSub_modeloEntity> entities = estSubmodeloRepository.findAll();
        List<EstSubmodeloDTO> dtos = StreamSupport.stream(entities.spliterator(), false)
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
        return dtos;
    }

    @Override
    public Optional<EstSubmodeloDTO> findById(int id) {
        Optional<EstSub_modeloEntity> optionalEntity = estSubmodeloRepository.findById(id);
        return optionalEntity.map(this::convertEntityToDto);
    }

    @Override
    public EstSubmodeloDTO save(EstSubmodeloDTO dto) {
        EstSub_modeloEntity entity = convertDtoToEntity(dto);
        entity = estSubmodeloRepository.save(entity);
        return convertEntityToDto(entity);
    }

    @Override
    public void delete(int id) {
        estSubmodeloRepository.deleteById(id);
    }
}
