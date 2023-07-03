package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.EstSubmodeloDTO;
import com.example.demo.dto.Est_ImportanciaDTO;
import com.example.demo.dto.Est_ModeloDTO;
import com.example.demo.dto.Est_SituacionDTO;
import com.example.demo.dto.est_impactoDTO;
import com.example.demo.service.ServiceBff;
import com.example.demo.service.ServiceBff1;
import com.example.demo.service.ServiceBff2;
import com.example.demo.service.ServiceBff3;
import com.example.demo.service.ServiceBff4;

@RestController
@RequestMapping("/v1/bff")
public class BffController {

    @Autowired
    private ServiceBff serviceBff;

    @Autowired
    private ServiceBff1 serviceBff1;

    @Autowired
    private ServiceBff2 serviceBff2;

    @Autowired
    private ServiceBff3 serviceBff3;

    @Autowired
    private ServiceBff4 serviceBff4;

    // Métodos de ServiceBff
    @GetMapping(value = "/Est_SituacionFindAll")
    public List<Est_SituacionDTO> Est_SituacionFindAll() {
        return serviceBff.Est_SituacionFindAll();
    }

    @GetMapping(value = "/Est_SituacionFindById/{id}")
    public Optional<Est_SituacionDTO> Est_SituacionFindById(@PathVariable("id") int id) {
        return serviceBff.Est_SituacionFindById(id);
    }

    @PostMapping(value = "/Est_SituacionSave", consumes = "application/json", produces = "application/json")
    public Est_SituacionDTO Est_SituacionSave(@RequestBody Est_SituacionDTO est_situacion) {
        return serviceBff.Est_SituacionSave(est_situacion);
    }

    @DeleteMapping(value = "/Est_SituacionDelete/{id}")
    public void Est_SituacionDelete(@PathVariable("id") int id) {
        serviceBff.Est_SituacionDelete(id);
    }

    // Métodos de ServiceBff1
    @GetMapping(value = "/est_impactoFindAll")
    public List<est_impactoDTO> est_impactoFindAll() {
        return serviceBff1.est_impactoFindAll();
    }

    @GetMapping(value = "/est_impactoFindById/{id}")
    public Optional<est_impactoDTO> est_impactoFindById(@PathVariable("id") int id) {
        return serviceBff1.est_impactoFindById(id);
    }

    @DeleteMapping(value = "/est_impactoDelete/{id}")
    public void est_impactoDelete(@PathVariable("id") int id) {
        serviceBff1.est_impactodelete(id);
    }

    @PostMapping(value = "/est_impactoSave", consumes = "application/json", produces = "application/json")
    public est_impactoDTO est_impactoSave(@RequestBody est_impactoDTO est_impacto) {
        return serviceBff1.est_impactosave(est_impacto);
    }

    // Métodos de ServiceBff2
    @GetMapping(value = "/Est_SubmodeloFindAll")
    public List<EstSubmodeloDTO> Est_SubmodeloFindAll() {
        return serviceBff2.Est_SubmodeloFindAll();
    }

    @GetMapping(value = "/Est_SubmodeloFindById/{id}")
    public Optional<EstSubmodeloDTO> Est_SubmodeloFindById(@PathVariable("id") int id) {
        return serviceBff2.Est_SubmodeloFindById(id);
    }

    @PostMapping(value = "/Est_SubmodeloSave", consumes = "application/json", produces = "application/json")
    public EstSubmodeloDTO Est_SubmodeloSave(@RequestBody EstSubmodeloDTO est_submodelo) {
        return serviceBff2.Est_SubmodeloSave(est_submodelo);
    }

    @DeleteMapping(value = "/Est_SubmodeloDelete/{id}")
    public void Est_SubmodeloDelete(@PathVariable("id") int id) {
        serviceBff2.Est_SubmodeloDelete(id);
    }

    // Métodos de ServiceBff3

    @GetMapping(value = "/Est_ModeloFindAll")
    public List<Est_ModeloDTO> Est_ModeloFindAll() {
        return serviceBff3.Est_ModeloFindAll();
    }

    @GetMapping(value = "/Est_ModeloFindById/{id}")
    public Optional<Est_ModeloDTO> Est_ModeloFindById(@PathVariable("id") int id) {
        return serviceBff3.Est_ModeloFindById(id);
    }

    @PostMapping(value = "/Est_ModeloSave", consumes = "application/json", produces = "application/json")
    public Est_ModeloDTO Est_ModeloSave(@RequestBody Est_ModeloDTO Est_Modelo) {
        return serviceBff3.Est_ModeloSave(Est_Modelo);
    }

    @DeleteMapping(value = "/Est_ModeloDelete/{id}")
    public void Est_ModeloDelete(@PathVariable("id") int id) {
        serviceBff3.Est_ModeloDelete(id);
    }


    // Métodos de ServiceBff4

    @GetMapping(value = "/Est_ImportanciaFindAll")
    public List<Est_ImportanciaDTO> Est_ImportanciaFindAll() {
        return serviceBff4.Est_ImportanciaFindAll();
    }

    @GetMapping(value = "/Est_ImportanciaFindById/{id}")
    public Optional<Est_ImportanciaDTO> Est_ImportanciaFindById(@PathVariable("id") int id) {
        return serviceBff4.Est_ImportanciaFindById(id);
    }

    @PostMapping(value = "/Est_ImportanciaSave", consumes = "application/json", produces = "application/json")
    public Est_ImportanciaDTO Est_ImportanciaSave(@RequestBody Est_ImportanciaDTO Est_Importancia) {
        return serviceBff4.Est_ImportanciaSave(Est_Importancia);
    }

    @DeleteMapping(value = "/Est_ImportanciaDelete/{id}")
    public void Est_ImportanciaDelete(@PathVariable("id") int id) {
        serviceBff4.Est_ImportanciaDelete(id);
    }






}


