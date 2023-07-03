package cl.thinkcloud.boxplanner.crud.service;

import java.util.List;
import java.util.Optional;

import cl.thinkcloud.boxplanner.crud.dto.est_impactoDTO;

public interface Iest_impactoService {
    public List<est_impactoDTO> findAll();
    public Optional<est_impactoDTO> findById(int id);
    public est_impactoDTO save(est_impactoDTO estImpacto);
    public void delete(int id);
}
