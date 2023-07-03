package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.dto.Est_ModeloDTO;





public interface ServiceBff3 {

    public List<Est_ModeloDTO> Est_ModeloFindAll();
    public Optional<Est_ModeloDTO> Est_ModeloFindById(int id);
    public Est_ModeloDTO Est_ModeloSave(Est_ModeloDTO Est_Modelo);
    public void Est_ModeloDelete(int id);
    public Est_ModeloDTO Est_ModeloUpdate(int id, Est_ModeloDTO Est_Modelo);

    
}
