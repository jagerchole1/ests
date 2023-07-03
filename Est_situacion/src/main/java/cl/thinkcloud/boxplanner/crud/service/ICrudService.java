package cl.thinkcloud.boxplanner.crud.service;

import java.util.List;
import java.util.Optional;

import cl.thinkcloud.boxplanner.crud.dto.Est_SituacionDTO;


public interface ICrudService {
    public List<Est_SituacionDTO> findAll();
    public Optional<Est_SituacionDTO> findById(int id);
    public Est_SituacionDTO save(Est_SituacionDTO est_Situacion);
    public void delete(int id);
}
