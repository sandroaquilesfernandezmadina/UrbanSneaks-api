package com.UrbanSneaks.repository;

import com.UrbanSneaks.model.Categoria;
import com.UrbanSneaks.model.Color;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ColorRepository extends JpaRepository<Color, Integer> {
 boolean existsByNomColorIgnoreCase(String nomColor);
 boolean existsByNomColorIgnoreCaseAndIdColorNot(String nomColor, Integer idColor);
 List<Color> findByEstadoColorTrue();
}
