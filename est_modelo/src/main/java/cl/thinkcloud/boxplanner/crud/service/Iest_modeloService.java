package cl.thinkcloud.boxplanner.crud.service;

import java.util.List;
import java.util.Optional;

import cl.thinkcloud.boxplanner.crud.dto.Est_modeloDTO;

public interface Iest_modeloService {
    List<Est_modeloDTO> findAll();
    Optional<Est_modeloDTO> findById(int id);
    Est_modeloDTO save(Est_modeloDTO dto);
    void delete(int id);
}
