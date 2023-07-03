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

import cl.thinkcloud.boxplanner.crud.dto.Est_modeloDTO;
import cl.thinkcloud.boxplanner.crud.service.Iest_modeloService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@Controller
@RequestMapping("/v1/org/est_modelo")
public class ControladorEst_modelo {

    public final Logger logger = LoggerFactory.getLogger(ControladorEst_modelo.class);

    @Autowired
    private Iest_modeloService servicio;

    @Operation(summary = "agregarEstmodelo")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Respuesta OK", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "404", description = "No encontrado", content = @Content(mediaType = "application/json"))})
    @ResponseBody
    @PostMapping("REST")
    public Est_modeloDTO agregarEstmodelo(@Valid @NonNull @RequestBody Est_modeloDTO submodelo) {
        logger.info("Controlador-agregarEstSubmodelo");
        return servicio.save(submodelo);
    }

    @Operation(summary = "getAllEstmodelo")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Respuesta OK", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "404", description = "No encontrado", content = @Content(mediaType = "application/json"))})
    @ResponseBody
    @GetMapping("REST")
    public List<Est_modeloDTO> getAllEstSubmodelos() {
        logger.info("Controlador-getAllEstmodelo");
        return servicio.findAll();
    }

    @Operation(summary = "getEstmodelo by Id PathVariable")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Respuesta OK", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "404", description = "No encontrado", content = @Content(mediaType = "application/json"))})
    @ResponseBody
    @GetMapping("REST/{id}")
    public Est_modeloDTO getEstmodelo(@PathVariable("id") int id) {
        return servicio.findById(id).orElse(null);
    }

    @Operation(summary = "updateEstmodeloById")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Respuesta OK", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "404", description = "No encontrado", content = @Content(mediaType = "application/json"))})
    @ResponseBody
    @PutMapping(("REST"))
    public Est_modeloDTO updateEstSubmodeloById(@Valid @NonNull @RequestBody Est_modeloDTO modelo) {
        Optional<Est_modeloDTO> p = servicio.findById(modelo.getId());
        if (p.isPresent()) {
            return servicio.save(modelo);
        } else return null;
    }

    @Operation(summary = "updateEstmodeloBy Id PathVariable")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Respuesta OK", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "404", description = "No encontrado", content = @Content(mediaType = "application/json"))})
    @ResponseBody
    @PutMapping(("REST/{id}"))
    public Est_modeloDTO updateEstSubmodeloById(@Valid @NonNull @RequestBody Est_modeloDTO modelo, @PathVariable("id") int id) {
        Optional<Est_modeloDTO> p = servicio.findById(id);
        if (p.isPresent()) {
            modelo.setId(id);
            return servicio.save(modelo);
        } else return null;
    }

    @Operation(summary = "deleteEstmodelo")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Respuesta OK", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "404", description = "No encontrado", content = @Content(mediaType = "application/json"))})
    @ResponseBody
    @DeleteMapping("REST")
    public Est_modeloDTO deleteEstSubmodeloById(@Valid @NonNull @RequestBody Est_modeloDTO modelo) {
        Optional<Est_modeloDTO> p = servicio.findById(modelo.getId());
        if (p.isPresent()) {
            servicio.delete(modelo.getId());
            return modelo;
        } else return null;
    }

    @Operation(summary = "deleteEstmodeloBy Id PathVariable")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Respuesta OK", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "404", description = "No encontrado", content = @Content(mediaType = "application/json"))})
    @ResponseBody
    @DeleteMapping("REST/{id}")
    public int deleteEstmodeloById(@PathVariable("id") int id) {
        Optional<Est_modeloDTO> p = servicio.findById(id);
        if (p.isPresent()) {
            servicio.delete(id);
            return 1;
        } else return 0;
    }
}
