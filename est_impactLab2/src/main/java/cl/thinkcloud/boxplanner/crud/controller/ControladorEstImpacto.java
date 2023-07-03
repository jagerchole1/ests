package cl.thinkcloud.boxplanner.crud.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cl.thinkcloud.boxplanner.crud.dto.est_impactoDTO;
import cl.thinkcloud.boxplanner.crud.service.Iest_impactoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@Controller
@RequestMapping("/v1/org/est_impacto")
public class ControladorEstImpacto {

    public final Logger logger = LoggerFactory.getLogger(ControladorEstImpacto.class);

    @Autowired
    private Iest_impactoService servicio;

    @Operation(summary = "agregarEstImpacto")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Respuesta OK", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "404", description = "No encontrado", content = @Content(mediaType = "application/json"))})
    @ResponseBody
    @PostMapping("REST")
    public est_impactoDTO agregarEstImpacto(@Valid @NonNull @RequestBody est_impactoDTO estImpacto) {
        logger.info("Controlador-agregarEstImpacto");
        return servicio.save(estImpacto);
    }

    @Operation(summary = "getAllEstImpactos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Respuesta OK", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "404", description = "No encontrado", content = @Content(mediaType = "application/json"))})
    @ResponseBody
    @GetMapping("REST")
    public List<est_impactoDTO> getAllEstImpactos() {
        logger.info("Controlador-getAllEstImpactos");
        return servicio.findAll();
    }

    @Operation(summary = "getEstImpacto by Id PathVariable")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Respuesta OK", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "404", description = "No encontrado", content = @Content(mediaType = "application/json"))})
    @ResponseBody
    @GetMapping("REST/{id}")
    public est_impactoDTO getEstImpacto(@PathVariable("id") int id) {
        return servicio.findById(id).orElse(null);
    }

    @Operation(summary = "updateEstImpactoById")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Respuesta OK", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "404", description = "No encontrado", content = @Content(mediaType = "application/json"))})
    @ResponseBody
    @PutMapping(("REST"))
    public est_impactoDTO updateEstImpactoById(@Valid @NonNull @RequestBody est_impactoDTO estImpacto) {
        Optional<est_impactoDTO> p = servicio.findById(estImpacto.getId());
        if (p.isPresent()) {
            return servicio.save(estImpacto);
        } else return null;
    }

    @Operation(summary = "updateEstImpactoBy Id PathVariable")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Respuesta OK", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "404", description = "No encontrado", content = @Content(mediaType = "application/json"))})
    @ResponseBody
    @PutMapping(("REST/{id}"))
    public est_impactoDTO updateEstImpactoById(@Valid @NonNull @RequestBody est_impactoDTO estImpacto, @PathVariable("id") int id) {
        Optional<est_impactoDTO> p = servicio.findById(id);
        if (p.isPresent()) {
            estImpacto.setId(id);
            return servicio.save(estImpacto);
        } else return null;
    }

    @Operation(summary = "deleteEstImpacto")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Respuesta OK", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "404", description = "No encontrado", content = @Content(mediaType = "application/json"))})
    @ResponseBody
    @DeleteMapping("REST")
    public est_impactoDTO deleteEstImpactoById(@Valid @NonNull @RequestBody est_impactoDTO estImpacto) {
        Optional<est_impactoDTO> p = servicio.findById(estImpacto.getId());
        if (p.isPresent()) {
            servicio.delete(estImpacto.getId());
            return estImpacto;
        } else return null;
    }

    @Operation(summary = "deleteEstImpactoBy Id PathVariable")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Respuesta OK", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "404", description = "No encontrado", content = @Content(mediaType = "application/json"))})
    @ResponseBody
    @DeleteMapping("REST/{id}")
    public int deleteEstImpactoById(@PathVariable("id") int id) {
        Optional<est_impactoDTO> p = servicio.findById(id);
        if (p.isPresent()) {
            servicio.delete(id);
            return 1;
        } else return 0;
    }
}
