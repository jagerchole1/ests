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

import cl.thinkcloud.boxplanner.crud.dto.EstSubmodeloDTO;
import cl.thinkcloud.boxplanner.crud.service.Iest_submodeloService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@Controller
@RequestMapping("/v1/org/est_submodelo")
public class ControladorEstsubmodelo {

    public final Logger logger = LoggerFactory.getLogger(ControladorEstsubmodelo.class);

    @Autowired
    private Iest_submodeloService servicio;

    @Operation(summary = "agregarEstSubmodelo")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Respuesta OK", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "404", description = "No encontrado", content = @Content(mediaType = "application/json"))})
    @ResponseBody
    @PostMapping("REST")
    public EstSubmodeloDTO agregarEstSubmodelo(@Valid @NonNull @RequestBody EstSubmodeloDTO submodelo) {
        logger.info("Controlador-agregarEstSubmodelo");
        return servicio.save(submodelo);
    }

    @Operation(summary = "getAllEstSubmodelos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Respuesta OK", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "404", description = "No encontrado", content = @Content(mediaType = "application/json"))})
    @ResponseBody
    @GetMapping("REST")
    public List<EstSubmodeloDTO> getAllEstSubmodelos() {
        logger.info("Controlador-getAllEstSubmodelos");
        return servicio.findAll();
    }

    @Operation(summary = "getEstSubmodelo by Id PathVariable")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Respuesta OK", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "404", description = "No encontrado", content = @Content(mediaType = "application/json"))})
    @ResponseBody
    @GetMapping("REST/{id}")
    public EstSubmodeloDTO getEstSubmodelo(@PathVariable("id") int id) {
        return servicio.findById(id).orElse(null);
    }

    @Operation(summary = "updateEstSubmodeloById")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Respuesta OK", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "404", description = "No encontrado", content = @Content(mediaType = "application/json"))})
    @ResponseBody
    @PutMapping(("REST"))
    public EstSubmodeloDTO updateEstSubmodeloById(@Valid @NonNull @RequestBody EstSubmodeloDTO submodelo) {
        Optional<EstSubmodeloDTO> p = servicio.findById(submodelo.getId());
        if (p.isPresent()) {
            return servicio.save(submodelo);
        } else return null;
    }

    @Operation(summary = "updateEstSubmodeloBy Id PathVariable")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Respuesta OK", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "404", description = "No encontrado", content = @Content(mediaType = "application/json"))})
    @ResponseBody
    @PutMapping(("REST/{id}"))
    public EstSubmodeloDTO updateEstSubmodeloById(@Valid @NonNull @RequestBody EstSubmodeloDTO submodelo, @PathVariable("id") int id) {
        Optional<EstSubmodeloDTO> p = servicio.findById(id);
        if (p.isPresent()) {
            submodelo.setId(id);
            return servicio.save(submodelo);
        } else return null;
    }

    @Operation(summary = "deleteEstSubmodelo")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Respuesta OK", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "404", description = "No encontrado", content = @Content(mediaType = "application/json"))})
    @ResponseBody
    @DeleteMapping("REST")
    public EstSubmodeloDTO deleteEstSubmodeloById(@Valid @NonNull @RequestBody EstSubmodeloDTO submodelo) {
        Optional<EstSubmodeloDTO> p = servicio.findById(submodelo.getId());
        if (p.isPresent()) {
            servicio.delete(submodelo.getId());
            return submodelo;
        } else return null;
    }

    @Operation(summary = "deleteEstSubmodeloBy Id PathVariable")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Respuesta OK", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "404", description = "No encontrado", content = @Content(mediaType = "application/json"))})
    @ResponseBody
    @DeleteMapping("REST/{id}")
    public int deleteEstSubmodeloById(@PathVariable("id") int id) {
        Optional<EstSubmodeloDTO> p = servicio.findById(id);
        if (p.isPresent()) {
            servicio.delete(id);
            return 1;
        } else return 0;
    }
}
