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

import cl.thinkcloud.boxplanner.crud.dto.Est_SituacionDTO;
import cl.thinkcloud.boxplanner.crud.service.ICrudService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;


@Controller
@RequestMapping("/v1/org/est-situacion")
public class ControladorEst_Situacion {

    public final Logger logger = LoggerFactory.getLogger(ControladorEst_Situacion.class);

    @Autowired
    private ICrudService servicio;

    // CREATE-READ-UPDATE-DELETE

    @Operation(summary = "agregarest_Situacion")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Respuesta OK", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "404", description = "No encontrado", content = @Content(mediaType = "application/json")) })
    @ResponseBody
    @PostMapping("REST") // CREATE-POST
    public Est_SituacionDTO agregarest_Situacion(@Valid @NonNull @RequestBody Est_SituacionDTO est_Situacion) {
        logger.info("Controlador-agregarest_Situacion");
        return servicio.save(est_Situacion);
    }

    @Operation(summary = "getAllest_Situaciones")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Respuesta OK", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "404", description = "No encontrado", content = @Content(mediaType = "application/json")) })
    @ResponseBody
    @GetMapping("REST") // READ-GET
    public List<Est_SituacionDTO> getAllest_Situaciones() {
        logger.info("Controlador-getAllest_Situaciones");
        return servicio.findAll();
    }

    @Operation(summary = "getest_SituacionByIdPathVariable")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Respuesta OK", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "404", description = "No encontrado", content = @Content(mediaType = "application/json")) })
    @ResponseBody
    @GetMapping("REST/{id}") // READ-GET/id
    public Est_SituacionDTO getest_SituacionById(@PathVariable("id") int id) {
        Optional<Est_SituacionDTO> e = servicio.findById(id);
        return e.orElse(null);
    }

    @Operation(summary = "updateest_SituacionById")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Respuesta OK", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "404", description = "No encontrado", content = @Content(mediaType = "application/json")) })
    @ResponseBody
    @PutMapping("REST") // UPDATE-PUT
    public Est_SituacionDTO updateest_SituacionById(@Valid @NonNull @RequestBody Est_SituacionDTO est_Situacion) {
        Optional<Est_SituacionDTO> existingest_Situacion = servicio.findById(est_Situacion.getId());
        return existingest_Situacion.map(e -> servicio.save(est_Situacion)).orElse(null);
    }

    @Operation(summary = "updateest_SituacionByIdPathVariable")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Respuesta OK", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "404", description = "No encontrado", content = @Content(mediaType = "application/json")) })
    @ResponseBody
    @PutMapping("REST/{id}") // UPDATE-PUT
    public Est_SituacionDTO updateest_SituacionById(@Valid @NonNull @RequestBody Est_SituacionDTO est_Situacion,
            @PathVariable("id") int id) {
        Optional<Est_SituacionDTO> existingest_Situacion = servicio.findById(id);
        return existingest_Situacion.map(e -> {
            est_Situacion.setId(id);
            return servicio.save(est_Situacion);
        }).orElse(null);
    }

    @Operation(summary = "deleteest_Situacion")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Respuesta OK", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "404", description = "No encontrado", content = @Content(mediaType = "application/json")) })
    @ResponseBody
    @DeleteMapping("REST") // DELETE-DELETE
    public Est_SituacionDTO deleteest_SituacionById(@Valid @NonNull @RequestBody Est_SituacionDTO est_Situacion) {
        Optional<Est_SituacionDTO> existingest_Situacion = servicio.findById(est_Situacion.getId());
        if (existingest_Situacion.isPresent()) {
            servicio.delete(est_Situacion.getId());
            return est_Situacion;
        } else {
            return null;
        }
    }

    @Operation(summary = "deleteest_SituacionByIdPathVariable")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Respuesta OK", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "404", description = "No encontrado", content = @Content(mediaType = "application/json")) })
    @ResponseBody
    @DeleteMapping("REST/{id}") // DELETE-DELETE
    public int deleteest_SituacionById(@PathVariable("id") int id) {
        Optional<Est_SituacionDTO> existingest_Situacion = servicio.findById(id);
        if (existingest_Situacion.isPresent()) {
            servicio.delete(id);
            return 1;
        } else {
            return 0;
        }
    }
}

