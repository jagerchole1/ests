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

import com.example.demo.dto.EstSubmodeloDTO;


@FeignClient(name = "estsubmodelo", url = "${rest.endpoints.demoweb.url.estsubmodelo}")
public interface MicroSubmodelo {
    ///v1/bff1/micro1


    @GetMapping(value = "v1/org/est_submodelo/REST", produces = "application/json")
    public List<EstSubmodeloDTO> findAll();

    @GetMapping(value = "v1/org/est_submodelo/REST/{id}", produces = "application/json")
    public Optional<EstSubmodeloDTO> findById(@PathVariable("id") int id);
    //public PersonaDTO save(PersonaDTO persona);

    //public void delete(int id);

    @PostMapping(value = "v1/org/est_submodelo/REST", consumes = "application/json", produces = "application/json")
    public EstSubmodeloDTO Est_SubmodeloSave(@RequestBody EstSubmodeloDTO Est_Submodelo);

    @DeleteMapping(value = "v1/org/est_submodelo/REST/{id}", produces = "application/json")
    public void Est_SubmodeloDelete(@PathVariable("id") int id);

    @PutMapping(value = "v1/org/est_submodelo/REST/{id}", consumes = "application/json", produces = "application/json")
    public EstSubmodeloDTO Est_SubmodeloUpdate(@PathVariable("id") int id, @RequestBody EstSubmodeloDTO Est_Submodelo);

}
