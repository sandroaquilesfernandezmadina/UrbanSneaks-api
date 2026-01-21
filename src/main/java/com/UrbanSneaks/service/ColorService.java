package com.UrbanSneaks.service;

import com.UrbanSneaks.dtos.categoria.CategoriaSalidaDTO;
import com.UrbanSneaks.dtos.color.ColorEntradaDTO;
import com.UrbanSneaks.dtos.color.ColorSalidaDTO;
import com.UrbanSneaks.model.Color;

import java.util.List;
import java.util.Optional;

public interface ColorService {
    List<ColorSalidaDTO> findAll();
    ColorSalidaDTO finDAllById(Integer id);
    ColorSalidaDTO SaveColor (ColorEntradaDTO colorDto);
    ColorSalidaDTO UpdateColor (Integer id , ColorEntradaDTO colorDto);
    void deleteColor(Integer id);
}

