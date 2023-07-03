package com.example.demo.restclients;

import java.util.List;
import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.dto.Est_ModeloDTO;


@FeignClient(name = "estmodelo", url = "${rest.endpoints.demoweb.url.estmodelo}")
public interface MicroModelo {
    ///v1/bff1/micro1


    @GetMapping(value = "v1/org/est_modelo/REST", produces = "application/json")
    public List<Est_ModeloDTO> findAll();

    @GetMapping(value = "v1/org/est_modelo/REST/{id}", produces = "application/json")
    public Optional<Est_ModeloDTO> findById(@PathVariable("id") int id);
    //public PersonaDTO save(PersonaDTO persona);

    //public void delete(int id);

    @PostMapping(value = "v1/org/est_modelo/REST", consumes = "application/json", produces = "application/json")
    public Est_ModeloDTO Est_ModeloSave(@RequestBody Est_ModeloDTO Est_Modelo);

    @DeleteMapping(value = "v1/org/est_modelo/REST/{id}", produces = "application/json")
    public void Est_ModeloDelete(@PathVariable("id") int id);

    @PutMapping(value = "v1/org/est_modelo/REST/{id}", consumes = "application/json", produces = "application/json")
    public Est_ModeloDTO Est_ModeloUpdate(@PathVariable("id") int id, @RequestBody Est_ModeloDTO Est_Modelo);

}