package com.UrbanSneaks.mapper;

import com.UrbanSneaks.dtos.color.ColorEntradaDTO;
import com.UrbanSneaks.dtos.color.ColorSalidaDTO;
import com.UrbanSneaks.model.Categoria;
import com.UrbanSneaks.model.Color;
import com.UrbanSneaks.service.ColorService;
import org.springframework.stereotype.Component;

@Component
public class ColorMapper {

    public Color toEntity(ColorEntradaDTO colorDto){
        Color color = new Color();
        color.setNomColor(colorDto.nombre());
        color.setEstadoColor(true);
        return color;
    }

    public ColorSalidaDTO toSalidaDto(Color color){
        return  new ColorSalidaDTO(
                color.getIdColor(),
                color.getNomColor()
        );
    }
}
