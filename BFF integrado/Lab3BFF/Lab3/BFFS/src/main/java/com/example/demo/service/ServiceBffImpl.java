package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.Est_SituacionDTO;
import com.example.demo.dto.EstSubmodeloDTO;
import com.example.demo.dto.Est_ImportanciaDTO;
import com.example.demo.dto.est_impactoDTO;
import com.example.demo.dto.Est_ModeloDTO;
import com.example.demo.restclients.MicroSituacion;
import com.example.demo.restclients.estImpacto;
import com.example.demo.restclients.MicroSubmodelo;
import com.example.demo.restclients.MicroModelo;
import com.example.demo.restclients.MicroImportancia;

@Service
public class ServiceBffImpl implements ServiceBff, ServiceBff1, ServiceBff2, ServiceBff3, ServiceBff4 {

    @Autowired
    private MicroSituacion microSituacion;

    @Autowired
    private estImpacto microEstImpacto;

    @Autowired
    private MicroSubmodelo microSubmodelo;

    @Autowired
    private MicroModelo microModelo;
    
    @Autowired
    private MicroImportancia microImportancia;

    // Implementación de métodos de ServiceBff

    @Override
    public List<Est_SituacionDTO> Est_SituacionFindAll() {
        return microSituacion.findAll();
    }

    @Override
    public Optional<Est_SituacionDTO> Est_SituacionFindById(int id) {
        return microSituacion.findById(id);
    }

    @Override
    public Est_SituacionDTO Est_SituacionSave(Est_SituacionDTO est_situacion) {
        return microSituacion.Est_SituacionSave(est_situacion);
    }

    @Override
    public void Est_SituacionDelete(int id) {
        microSituacion.deleteById(id);
    }

    // Implementación de métodos de ServiceBff1

    @Override
    public List<est_impactoDTO> est_impactoFindAll() {
        return microEstImpacto.findAll();
    }

    @Override
    public Optional<est_impactoDTO> est_impactoFindById(int id) {
        return microEstImpacto.findById(id);
    }

    @Override
    public void est_impactodelete(int id) {
        microEstImpacto.est_impactodelete(id);
    }

    @Override
    public est_impactoDTO est_impactosave(est_impactoDTO estImpacto) {
        return microEstImpacto.est_impactosave(estImpacto);
    }

    @Override
    public est_impactoDTO est_impactoupdate(int id, est_impactoDTO estImpacto) {
        return microEstImpacto.est_impactoupdate(id, estImpacto);
    }

    // Implementación de métodos de ServiceBff2

    @Override
    public List<EstSubmodeloDTO> Est_SubmodeloFindAll() {
        return microSubmodelo.findAll();
    }

    @Override
    public Optional<EstSubmodeloDTO> Est_SubmodeloFindById(int id) {
        return microSubmodelo.findById(id);
    }

    @Override
    public EstSubmodeloDTO Est_SubmodeloSave(EstSubmodeloDTO est_Submodelo) {
        return microSubmodelo.Est_SubmodeloSave(est_Submodelo);
    }

    @Override
    public void Est_SubmodeloDelete(int id) {
        microSubmodelo.Est_SubmodeloDelete(id);
    }

    @Override
    public EstSubmodeloDTO Est_SubmodeloUpdate(int id, EstSubmodeloDTO est_Submodelo) {
        // Implementa la lógica para actualizar un EstSubmodeloDTO por su id
        return null;
    }

    // Implementación de métodos de ServiceBff3

    @Override
    public List<Est_ModeloDTO> Est_ModeloFindAll() {
        return microModelo.findAll();
    }

    @Override
    public Optional<Est_ModeloDTO> Est_ModeloFindById(int id) {
        return microModelo.findById(id);
    }

    @Override
    public void Est_ModeloDelete(int id) {
        microModelo.Est_ModeloDelete(id);
    }

    @Override
    public Est_ModeloDTO Est_ModeloSave(Est_ModeloDTO Est_Modelo) {
        return microModelo.Est_ModeloSave(Est_Modelo);
    }

    @Override
    public Est_ModeloDTO Est_ModeloUpdate(int id, Est_ModeloDTO Est_Modelo) {
        return microModelo.Est_ModeloUpdate(id, Est_Modelo);
    }


    // Implementación de métodos de ServiceBff4

    @Override
    public List<Est_ImportanciaDTO> Est_ImportanciaFindAll() {
        return microImportancia.findAll();
    }

    @Override
    public Optional<Est_ImportanciaDTO> Est_ImportanciaFindById(int id) {
        return microImportancia.findById(id);
    }

    @Override
    public void Est_ImportanciaDelete(int id) {
        microImportancia.Est_ImportanciaDelete(id);
    }

    @Override
    public Est_ImportanciaDTO Est_ImportanciaSave(Est_ImportanciaDTO Est_Importancia) {
        return microImportancia.Est_ImportanciaSave(Est_Importancia);
    }

    @Override
    public Est_ImportanciaDTO Est_ImportanciaUpdate(int id, Est_ImportanciaDTO Est_Importancia) {
        return microImportancia.Est_ImportanciaUpdate(id, Est_Importancia);
    }

}







