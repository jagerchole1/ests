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

import cl.thinkcloud.boxplanner.crud.dto.Est_ImportanciaDTO;
import cl.thinkcloud.boxplanner.crud.service.IEst_ImportanciaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@Controller
@RequestMapping("/v1/org/est_importancia")
public class ControladorEst_importancia {

    public final Logger logger = LoggerFactory.getLogger(ControladorEst_importancia.class);

    @Autowired
    private IEst_ImportanciaService servicio;

    @Operation(summary = "agregarEst_importancia")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Respuesta OK", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "404", description = "No encontrado", content = @Content(mediaType = "application/json"))})
    @ResponseBody
    @PostMapping("REST")
    public Est_ImportanciaDTO agregarEst_importancia(@Valid @NonNull @RequestBody Est_ImportanciaDTO est_importancia) {
        logger.info("Controlador-agregarEst_ImportanciaDTO");
        return servicio.save(est_importancia);
    }

    @Operation(summary = "getAllEst_importancia")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Respuesta OK", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "404", description = "No encontrado", content = @Content(mediaType = "application/json"))})
    @ResponseBody
    @GetMapping("REST")
    public List<Est_ImportanciaDTO> getAllEst_importancia() {
        logger.info("Controlador-getAllEst_importancia");
        return servicio.findAll();
    }

    @Operation(summary = "getEst_importancia by Id PathVariable")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Respuesta OK", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "404", description = "No encontrado", content = @Content(mediaType = "application/json"))})
    @ResponseBody
    @GetMapping("REST/{id}")
    public Est_ImportanciaDTO getEst_importancia(@PathVariable("id") int id) {
        return servicio.findById(id).orElse(null);
    }

    @Operation(summary = "updateEst_importanciaById")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Respuesta OK", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "404", description = "No encontrado", content = @Content(mediaType = "application/json"))})
    @ResponseBody
    @PutMapping(("REST"))
    public Est_ImportanciaDTO updateEst_importanciaById(@Valid @NonNull @RequestBody Est_ImportanciaDTO est_importancia) {
        Optional<Est_ImportanciaDTO> p = servicio.findById(est_importancia.getId());
        if (p.isPresent()) {
            return servicio.save(est_importancia);
        } else return null;
    }

    @Operation(summary = "updateEst_importanciaBy Id PathVariable")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Respuesta OK", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "404", description = "No encontrado", content = @Content(mediaType = "application/json"))})
    @ResponseBody
    @PutMapping(("REST/{id}"))
    public Est_ImportanciaDTO updateEst_importanciaById(@Valid @NonNull @RequestBody Est_ImportanciaDTO est_importancia, @PathVariable("id") int id) {
        Optional<Est_ImportanciaDTO> p = servicio.findById(id);
        if (p.isPresent()) {
            est_importancia.setId(id);
            return servicio.save(est_importancia);
        } else return null;
    }

    @Operation(summary = "deleteEst_importancia")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Respuesta OK", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "404", description = "No encontrado", content = @Content(mediaType = "application/json"))})
    @ResponseBody
    @DeleteMapping("REST")
    public Est_ImportanciaDTO deleteEst_importanciaById(@Valid @NonNull @RequestBody Est_ImportanciaDTO est_importancia) {
        Optional<Est_ImportanciaDTO> p = servicio.findById(est_importancia.getId());
        if (p.isPresent()) {
            servicio.delete(est_importancia.getId());
            return est_importancia;
        } else return null;
    }

    @Operation(summary = "deleteEst_importanciaBy Id PathVariable")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Respuesta OK", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "404", description = "No encontrado", content = @Content(mediaType = "application/json"))})
    @ResponseBody
    @DeleteMapping("REST/{id}")
    public int deleteEst_importanciaById(@PathVariable("id") int id) {
        Optional<Est_ImportanciaDTO> p = servicio.findById(id);
        if (p.isPresent()) {
            servicio.delete(id);
            return 1;
        } else return 0;
    }
}
