package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.dto.est_impactoDTO;





public interface ServiceBff1 {

    public List<est_impactoDTO> est_impactoFindAll();
    public Optional<est_impactoDTO> est_impactoFindById(int id);
    public void est_impactodelete(int id);
    public est_impactoDTO est_impactosave (est_impactoDTO estImpacto);
    public est_impactoDTO est_impactoupdate(int id, est_impactoDTO estImpacto);
}