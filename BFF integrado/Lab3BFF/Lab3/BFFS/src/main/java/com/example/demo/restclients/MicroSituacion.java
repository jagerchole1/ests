package com.example.demo.restclients;

import java.util.List;
import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.dto.Est_SituacionDTO;

@FeignClient(name = "estsituacion", url = "${rest.endpoints.demoweb.url.est_situacion}")
public interface MicroSituacion {

    @GetMapping(value = "v1/org/est-situacion/REST", produces = "application/json")
    public List<Est_SituacionDTO> findAll();

    @GetMapping(value = "v1/org/est-situacion/REST/{id}", produces = "application/json")
    public Optional<Est_SituacionDTO> findById(@PathVariable("id") int id);

    @DeleteMapping(value = "v1/org/est-situacion/REST/{id}")
    public void deleteById(@PathVariable("id") int id);

    @PostMapping(value = "v1/org/est-situacion/REST", consumes = "application/json", produces = "application/json")
    public Est_SituacionDTO Est_SituacionSave(@RequestBody Est_SituacionDTO est_situacion);
}
