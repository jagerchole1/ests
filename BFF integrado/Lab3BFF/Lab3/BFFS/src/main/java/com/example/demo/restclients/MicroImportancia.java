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

import com.example.demo.dto.Est_ImportanciaDTO;


@FeignClient(name = "estimportancia", url = "${rest.endpoints.demoweb.url.estimportancia}")
public interface MicroImportancia {
    ///v1/bff1/micro1


    @GetMapping(value = "v1/org/est_importancia/REST", produces = "application/json")
    public List<Est_ImportanciaDTO> findAll();

    @GetMapping(value = "v1/org/est_importancia/REST/{id}", produces = "application/json")
    public Optional<Est_ImportanciaDTO> findById(@PathVariable("id") int id);
    //public PersonaDTO save(PersonaDTO persona);

    //public void delete(int id);

    @PostMapping(value = "v1/org/est_importancia/REST", consumes = "application/json", produces = "application/json")
    public Est_ImportanciaDTO Est_ImportanciaSave(@RequestBody Est_ImportanciaDTO Est_Importancia);

    @DeleteMapping(value = "v1/org/est_importancia/REST/{id}", produces = "application/json")
    public void Est_ImportanciaDelete(@PathVariable("id") int id);

    @PutMapping(value = "v1/org/est_importancia/REST/{id}", consumes = "application/json", produces = "application/json")
    public Est_ImportanciaDTO Est_ImportanciaUpdate(@PathVariable("id") int id, @RequestBody Est_ImportanciaDTO Est_Importancia);

}