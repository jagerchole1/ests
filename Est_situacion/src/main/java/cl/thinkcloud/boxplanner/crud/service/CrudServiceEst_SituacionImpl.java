package cl.thinkcloud.boxplanner.crud.service;

import cl.thinkcloud.boxplanner.crud.dto.Est_SituacionDTO;
import cl.thinkcloud.boxplanner.crud.entity.Est_SituacionEntity;
import cl.thinkcloud.boxplanner.crud.repository.IEst_SituacionRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Component
@Service
public class CrudServiceEst_SituacionImpl implements ICrudService {

    public final Logger logger = LoggerFactory.getLogger(CrudServiceEst_SituacionImpl.class);

    @Autowired
    private IEst_SituacionRepository data;

    public Est_SituacionEntity estSituacionDTO2Entity(Est_SituacionDTO eDTO) {
        logger.info("Servicer-estSituacionDTO2Entity");
        Est_SituacionEntity eEntity = new Est_SituacionEntity();
        eEntity.setId(eDTO.getId());
        eEntity.setEstSubmodeloId(eDTO.getEstSubmodeloId());
        eEntity.setBscObjetivoId(eDTO.getBscObjetivoId());
        eEntity.setEstImpactoId(eDTO.getEstImpactoId());
        eEntity.setEstImportanciaId(eDTO.getEstImportanciaId());
        eEntity.setNombre(eDTO.getNombre());
        eEntity.setAlias(eDTO.getAlias());
        eEntity.setDescripcion(eDTO.getDescripcion());
        eEntity.setOrden(eDTO.getOrden());
        eEntity.setIncluir(eDTO.isIncluir());
        eEntity.setFechaRegistro(eDTO.getFechaRegistro());
        return eEntity;
    }

    public Est_SituacionDTO estSituacionEntity2DTO(Est_SituacionEntity eEntity) {
        logger.info("Servicer-estSituacionEntity2DTO");
        Est_SituacionDTO eDTO = new Est_SituacionDTO();
        eDTO.setId(eEntity.getId());
        eDTO.setEstSubmodeloId(eEntity.getEstSubmodeloId());
        eDTO.setBscObjetivoId(eEntity.getBscObjetivoId());
        eDTO.setEstImpactoId(eEntity.getEstImpactoId());
        eDTO.setEstImportanciaId(eEntity.getEstImportanciaId());
        eDTO.setNombre(eEntity.getNombre());
        eDTO.setAlias(eEntity.getAlias());
        eDTO.setDescripcion(eEntity.getDescripcion());
        eDTO.setOrden(eEntity.getOrden());
        eDTO.setIncluir(eEntity.isIncluir());
        eDTO.setFechaRegistro(eEntity.getFechaRegistro());
        return eDTO;
    }

    @Override
    public List<Est_SituacionDTO> findAll() {
        List<Est_SituacionDTO> leDTO = new ArrayList<>();

        Iterable<Est_SituacionEntity> itEE = data.findAll();

        Iterator<Est_SituacionEntity> it = itEE.iterator();

        while (it.hasNext()) {
            Est_SituacionEntity eEntity = it.next();
            Est_SituacionDTO eDTO = estSituacionEntity2DTO(eEntity);
            leDTO.add(eDTO);
        }

        return leDTO;
    }

    @Override
    public Optional<Est_SituacionDTO> findById(int id) {
        Optional<Est_SituacionEntity> oEE = data.findById(id);

        if (oEE.isPresent()) {
            Est_SituacionEntity eEntity = oEE.get();
            Est_SituacionDTO eDTO = estSituacionEntity2DTO(eEntity);
            Optional<Est_SituacionDTO> oeDTO = Optional.ofNullable(eDTO);
            return oeDTO;
        } else {
            return Optional.empty();
        }
    }

    @Override
    public Est_SituacionDTO save(Est_SituacionDTO eDTO) {
        Est_SituacionEntity eEntity = estSituacionDTO2Entity(eDTO);
        eEntity = data.save(eEntity);
        Est_SituacionDTO savedDTO = estSituacionEntity2DTO(eEntity);
        return savedDTO;
    }

    @Override
    public void delete(int id) {
        data.deleteById(id);
    }
}
