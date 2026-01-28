package com.UrbanSneaks.serviceImpl;

import com.UrbanSneaks.dtos.color.ColorEntradaDTO;
import com.UrbanSneaks.dtos.color.ColorSalidaDTO;
import com.UrbanSneaks.mapper.CategoriaMapper;
import com.UrbanSneaks.mapper.ColorMapper;
import com.UrbanSneaks.model.Categoria;
import com.UrbanSneaks.model.Color;
import com.UrbanSneaks.repository.CategoriaRepository;
import com.UrbanSneaks.repository.ColorRepository;
import com.UrbanSneaks.service.ColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ColorServiceImpl implements ColorService {

    @Autowired
    private ColorRepository colorRepository;

    @Autowired
    private ColorMapper colorMapper;

    @Override
    public List<ColorSalidaDTO> findAll() {
        return colorRepository.findAll()
                .stream()
                .map(colorMapper::toSalidaDto)
                .toList();
    }

    @Override
    public ColorSalidaDTO finDAllById(Integer id) {
        Color color = colorRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("color no encontrado"));
        return  colorMapper.toSalidaDto(color);
    }

    @Override
    public ColorSalidaDTO SaveColor(ColorEntradaDTO ColorDto) {

        if(colorRepository.existsByNomColorIgnoreCase(ColorDto.nombre())){
            throw new RuntimeException("El color ya existe");
        }


        Color color = colorMapper.toEntity(ColorDto);
        return colorMapper.toSalidaDto(
                colorRepository.save(color)
        );
    }

    @Override
    public ColorSalidaDTO UpdateColor(Integer id, ColorEntradaDTO colorDto) {
        Color color = colorRepository.findById(id)
           .orElseThrow(()-> new RuntimeException("categoria no encontrada con el: " + id));

            color.setNomColor(colorDto.nombre());
        return colorMapper.toSalidaDto(
                colorRepository.save(color)
        );
    }

    @Override
    public void deleteColor(Integer id) {
    colorRepository.deleteById(id);
    }
}
