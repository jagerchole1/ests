package cl.thinkcloud.boxplanner.crud.service;

import java.util.List;
import java.util.Optional;

import cl.thinkcloud.boxplanner.crud.dto.EstSubmodeloDTO;

public interface Iest_submodeloService {
    List<EstSubmodeloDTO> findAll();
    Optional<EstSubmodeloDTO> findById(int id);
    EstSubmodeloDTO save(EstSubmodeloDTO dto);
    void delete(int id);
}
