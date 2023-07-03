package cl.thinkcloud.boxplanner.crud.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.thinkcloud.boxplanner.crud.dto.est_impactoDTO;
import cl.thinkcloud.boxplanner.crud.entity.est_impactoEntity;
import cl.thinkcloud.boxplanner.crud.repository.est_impactoRepository;

@Service
public class CrudServiceEstImpactoImpl implements Iest_impactoService {

    public final Logger logger = LoggerFactory.getLogger(CrudServiceEstImpactoImpl.class);

    @Autowired
    private est_impactoRepository data;

    public est_impactoEntity estImpactoDTO2Entity(est_impactoDTO dto) {
        logger.info("Service-estImpactoDTO2Entity");
        est_impactoEntity entity = new est_impactoEntity();
        entity.setId(dto.getId());
        entity.setNombre(dto.getNombre());
        entity.setAlias(dto.getAlias());
        entity.setFechaRegistro(dto.getFechaRegistro());
        return entity;
    }

    public est_impactoDTO estImpactoEntity2DTO(est_impactoEntity entity) {
        logger.info("Service-estImpactoEntity2DTO");
        est_impactoDTO dto = new est_impactoDTO();
        dto.setId(entity.getId());
        dto.setNombre(entity.getNombre());
        dto.setAlias(entity.getAlias());
        dto.setFechaRegistro(entity.getFechaRegistro());
        return dto;
    }

    @Override
    public List<est_impactoDTO> findAll() {
        List<est_impactoDTO> listDTO = new ArrayList<>();
        Iterable<est_impactoEntity> itEntity = data.findAll();
        Iterator<est_impactoEntity> iterator = itEntity.iterator();

        while (iterator.hasNext()) {
            est_impactoEntity entity = iterator.next();
            est_impactoDTO dto = estImpactoEntity2DTO(entity);
            listDTO.add(dto);
        }

        return listDTO;
    }

    @Override
    public Optional<est_impactoDTO> findById(int id) {
        Optional<est_impactoEntity> optionalEntity = data.findById(id);

        if (optionalEntity.isPresent()) {
            est_impactoEntity entity = optionalEntity.get();
            est_impactoDTO dto = estImpactoEntity2DTO(entity);
            return Optional.ofNullable(dto);
        } else {
            return Optional.empty();
        }
    }

    @Override
    public est_impactoDTO save(est_impactoDTO dto) {
        est_impactoEntity entity = estImpactoDTO2Entity(dto);
        entity = data.save(entity);
        return estImpactoEntity2DTO(entity);
    }

    @Override
    public void delete(int id) {
        data.deleteById(id);
    }
}
