package com.UrbanSneaks.service;

import com.UrbanSneaks.dtos.categoria.CategoriaEntradaDTO;
import com.UrbanSneaks.dtos.categoria.CategoriaSalidaDTO;
import com.UrbanSneaks.model.Categoria;

import java.util.List;
import java.util.Optional;

public interface CategoriaService {
    List<CategoriaSalidaDTO> FindAllCategoria();
    CategoriaSalidaDTO FindAllById(Integer id);
    CategoriaSalidaDTO SaveCategoria(CategoriaEntradaDTO   categoriaDto);
    CategoriaSalidaDTO UpdateCategoria(Integer id, CategoriaEntradaDTO categoriaDto);
    void deleteCategoria(Integer id);
}




