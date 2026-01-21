package com.UrbanSneaks.serviceImpl;

import com.UrbanSneaks.model.Color;
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

    @Override
    public List<Color> findAll() {
        return colorRepository.findAll();
    }

    @Override
    public Optional<Color> finDAllById(Integer id) {
        return colorRepository.findById(id);
    }

    @Override
    public Color saveColor(Color color) {
        return colorRepository.save(color);
    }

    @Override
    public Color UpdateColor(Integer id, Color color) {
        Color col = colorRepository.findById(id)
           .orElseThrow(()-> new RuntimeException("categoria no encontrada con el: " + id));

        col.setNomColor(color.getNomColor());
        col.setEstadoColor(color.getEstadoColor());
        return colorRepository.save(col);
    }

    @Override
    public void deleteColor(Integer id) {
    colorRepository.deleteById(id);
    }
}
