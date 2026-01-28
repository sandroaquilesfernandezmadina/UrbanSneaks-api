package com.UrbanSneaks.repository;

import com.UrbanSneaks.dtos.categoria.CategoriaSalidaDTO;
import com.UrbanSneaks.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoriaRepository extends JpaRepository <Categoria, Integer>{
    boolean  existsByNomCategoriaIgnoreCase(String nomCategoria);
    List<Categoria> findByEstadoCategiriaTrue();
}
