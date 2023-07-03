package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import com.example.demo.dto.Est_SituacionDTO;

public interface ServiceBff {
    public List<Est_SituacionDTO> Est_SituacionFindAll();
    public Optional<Est_SituacionDTO> Est_SituacionFindById(int id);
    public Est_SituacionDTO Est_SituacionSave(Est_SituacionDTO Est_Situacion);
    public void Est_SituacionDelete(int id);
}
