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

import com.example.demo.dto.est_impactoDTO;


@FeignClient(name = "estImpacto", url = "${rest.endpoints.demoweb.url.impacto}")
public interface estImpacto {
    ///v1/bff1/micro1


    @GetMapping(value = "/v1/org/est_impacto/REST", produces = "application/json")
    public List<est_impactoDTO> findAll();

    @GetMapping(value = "/v1/org/est_impacto/REST/{id}", produces = "application/json")
    public Optional<est_impactoDTO> findById(@PathVariable("id") int id);

    @DeleteMapping(value = "v1/org/est_impacto/REST/{id}", produces = "application/json")
    public void est_impactodelete(@PathVariable("id") int id);

    @PostMapping(value = "/v1/org/est_impacto/REST", consumes = "application/json", produces = "application/json")
    public est_impactoDTO est_impactosave(@RequestBody est_impactoDTO estImpacto);

    @PutMapping(value = "v1/org/est_impacto/REST/{id}", consumes = "application/json", produces = "application/json")
    public est_impactoDTO est_impactoupdate(@PathVariable("id") int id, @RequestBody est_impactoDTO estImpacto);
}
