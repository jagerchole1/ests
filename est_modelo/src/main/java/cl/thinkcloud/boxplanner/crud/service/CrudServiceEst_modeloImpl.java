package cl.thinkcloud.boxplanner.crud.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.thinkcloud.boxplanner.crud.dto.Est_modeloDTO;
import cl.thinkcloud.boxplanner.crud.entity.Est_modeloEntity;
import cl.thinkcloud.boxplanner.crud.repository.EstmodeloRepository;

@Service
public class CrudServiceEst_modeloImpl implements Iest_modeloService {

    private final Logger logger = LoggerFactory.getLogger(CrudServiceEst_modeloImpl.class);

    @Autowired
    private EstmodeloRepository estmodeloRepository;

    public Est_modeloEntity est_modeloDTO2Entity(Est_modeloDTO mDTO)
    {
    	logger.info("Servicer-est_modeloDTO2Entity");
        Est_modeloEntity mEntity = new Est_modeloEntity();
    	mEntity.setId(mDTO.getId());
    	mEntity.setNombre(mDTO.getNombre());
    	mEntity.setAlias(mDTO.getAlias());
    	mEntity.setDescripcion(mDTO.getDescripcion());
    	mEntity.setOrden(mDTO.getOrden());
    	mEntity.setAplica_solo_a_departamentos(mDTO.getAplica_solo_a_departamentos());
    	mEntity.setFecha_registro(mDTO.getFecha_registro());
    	return mEntity;
    }
    
    public Est_modeloDTO est_modeloEntity2DTO(Est_modeloEntity mE)
    {
    	logger.info("Servicer-personaEntity2DTO");
    	Est_modeloDTO mDTO = new Est_modeloDTO();
    	mDTO.setId(mE.getId());
    	mDTO.setNombre(mE.getNombre());
    	mDTO.setAlias(mE.getAlias());
    	mDTO.setDescripcion(mE.getDescripcion());
    	mDTO.setOrden(mE.getOrden());
    	mDTO.setAplica_solo_a_departamentos(mE.getAplica_solo_a_departamentos());
    	mDTO.setFecha_registro(mE.getFecha_registro());
    	return mDTO;
    }
    
    
    @Override
    public List<Est_modeloDTO> findAll() {
    	List<Est_modeloDTO> lmDTO = new ArrayList<Est_modeloDTO>();
    	
    	Iterable<Est_modeloEntity> itME = estmodeloRepository.findAll();
    	
    	Iterator<Est_modeloEntity> it = itME.iterator();
    	
    	while (it.hasNext())
    	{
    		Est_modeloEntity mE = it.next();
    		Est_modeloDTO mDTO = est_modeloEntity2DTO(mE);
    		lmDTO.add(mDTO);
    	}
    	
        return lmDTO;
    }

    @Override
    public Optional<Est_modeloDTO> findById(int id) {
    	Optional<Est_modeloEntity> omE = estmodeloRepository.findById(id);
    	
    	Est_modeloEntity mE = omE.get();
    	
    	Est_modeloDTO mDTO = est_modeloEntity2DTO(mE);
    	
    	Optional<Est_modeloDTO> omDTO = Optional.ofNullable(mDTO);
    	
        return omDTO;
    }

    @Override
    public Est_modeloDTO save(Est_modeloDTO m) {
    	Est_modeloEntity mE = est_modeloDTO2Entity(m);
    	estmodeloRepository.save(mE);
        return m;
    }

    @Override
    public void delete(int id){
    	estmodeloRepository.deleteById(id);
    }
    

}
