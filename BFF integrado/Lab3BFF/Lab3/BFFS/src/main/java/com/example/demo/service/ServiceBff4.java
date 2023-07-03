package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.dto.Est_ImportanciaDTO;




public interface ServiceBff4{

    public List<Est_ImportanciaDTO> Est_ImportanciaFindAll();
    public Optional<Est_ImportanciaDTO> Est_ImportanciaFindById(int id);
    public Est_ImportanciaDTO Est_ImportanciaSave(Est_ImportanciaDTO Est_Importancia);
    public void Est_ImportanciaDelete(int id);
    public Est_ImportanciaDTO Est_ImportanciaUpdate(int id, Est_ImportanciaDTO Est_Importancia);

    
}