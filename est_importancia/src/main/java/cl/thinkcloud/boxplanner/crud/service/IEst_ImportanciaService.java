package cl.thinkcloud.boxplanner.crud.service;

import java.util.List;
import java.util.Optional;

import cl.thinkcloud.boxplanner.crud.dto.Est_ImportanciaDTO;

public interface IEst_ImportanciaService {
    List<Est_ImportanciaDTO> findAll();
    Optional<Est_ImportanciaDTO> findById(int id);
    Est_ImportanciaDTO save(Est_ImportanciaDTO dto);
    void delete(int id);
}
