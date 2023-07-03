package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.dto.EstSubmodeloDTO;





public interface ServiceBff2 {

    public List<EstSubmodeloDTO> Est_SubmodeloFindAll();
    public Optional<EstSubmodeloDTO> Est_SubmodeloFindById(int id);
    public EstSubmodeloDTO Est_SubmodeloSave(EstSubmodeloDTO Est_Submodelo);
    public void Est_SubmodeloDelete(int id);
    public EstSubmodeloDTO Est_SubmodeloUpdate(int id, EstSubmodeloDTO Est_Submodelo);

    
}