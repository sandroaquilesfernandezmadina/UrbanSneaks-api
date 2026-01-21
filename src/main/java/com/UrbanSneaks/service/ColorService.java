package com.UrbanSneaks.service;

import com.UrbanSneaks.model.Color;

import java.util.List;
import java.util.Optional;

public interface ColorService {
    List<Color> findAll();
    Optional<Color> finDAllById(Integer id);
    Color saveColor(Color color);
    Color UpdateColor (Integer id , Color color);
    void deleteColor(Integer id);
}
