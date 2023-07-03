package cl.thinkcloud.boxplanner.crud.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.thinkcloud.boxplanner.crud.dto.Est_ImportanciaDTO;
import cl.thinkcloud.boxplanner.crud.entity.Est_ImportanciaEntity;
import cl.thinkcloud.boxplanner.crud.repository.Est_ImportanciaRepository;

@Service
public class CrudServiceEst_ImportanciaImpl implements IEst_ImportanciaService {

    private final Logger logger = LoggerFactory.getLogger(CrudServiceEst_ImportanciaImpl.class);

    @Autowired
    private Est_ImportanciaRepository data;

    public Est_ImportanciaEntity est_importanciaDTO2Entity(Est_ImportanciaDTO eDTO) {
        logger.info("Servicer-est_importanciaDTO2Entity");
        Est_ImportanciaEntity eEntity = new Est_ImportanciaEntity();
        eEntity.setId(eDTO.getId());
        eEntity.setNombre(eDTO.getNombre());
        eEntity.setAlias(eDTO.getAlias());
        eEntity.setFecha_registro(eDTO.getFecha_registro());
        return eEntity;
    }

    public Est_ImportanciaDTO est_importanciaEntity2DTO(Est_ImportanciaEntity eE) {
        logger.info("Servicer-est_importanciaEntity2DTO");
        Est_ImportanciaDTO eDTO = new Est_ImportanciaDTO();
        eDTO.setId(eE.getId());
        eDTO.setNombre(eE.getNombre());
        eDTO.setAlias(eE.getAlias());
        eDTO.setFecha_registro(eE.getFecha_registro());
        return eDTO;
    }

    @Override
    public List<Est_ImportanciaDTO> findAll() {
        List<Est_ImportanciaDTO> leDTO = new ArrayList<Est_ImportanciaDTO>();
        Iterable<Est_ImportanciaEntity> itEE = data.findAll();
        Iterator<Est_ImportanciaEntity> it = itEE.iterator();

        while (it.hasNext()) {
            Est_ImportanciaEntity eE = it.next();
            Est_ImportanciaDTO eDTO = est_importanciaEntity2DTO(eE);
            leDTO.add(eDTO);
        }
        return leDTO;

    }

    @Override
    public Optional<Est_ImportanciaDTO> findById(int id) {
        Optional<Est_ImportanciaEntity> oEE = data.findById(id);

        Est_ImportanciaEntity eE = oEE.get();

        Est_ImportanciaDTO eDTO = est_importanciaEntity2DTO(eE);

        Optional<Est_ImportanciaDTO> oeDTO = Optional.ofNullable(eDTO);

        return oeDTO;
    }

    @Override
    public Est_ImportanciaDTO save(Est_ImportanciaDTO e) {
        Est_ImportanciaEntity eE = est_importanciaDTO2Entity(e);
        data.save(eE);
        return e;
    }

    @Override
    public void delete(int id) {
        data.deleteById(id);
    }

}