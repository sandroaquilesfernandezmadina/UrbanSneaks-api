package com.UrbanSneaks.repository;

import com.UrbanSneaks.model.Color;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ColorRepository extends JpaRepository<Color, Integer> {
 boolean existsByNomColorIgnoreCase(String nomColor);

}
