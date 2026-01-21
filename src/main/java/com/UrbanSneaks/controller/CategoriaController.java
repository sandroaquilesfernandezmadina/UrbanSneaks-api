package com.UrbanSneaks.controller;

import com.UrbanSneaks.dtos.categoria.CategoriaEntradaDTO;
import com.UrbanSneaks.dtos.categoria.CategoriaSalidaDTO;
import com.UrbanSneaks.model.Categoria;
import com.UrbanSneaks.service.CategoriaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public List<CategoriaSalidaDTO> FindAllCategoria() {
        return categoriaService.FindAllCategoria();
    }

    @GetMapping("/{id}")
    public CategoriaSalidaDTO FindAllById(@PathVariable Integer id) {
        return categoriaService.FindAllById(id);
    }

    @PostMapping
    public CategoriaSalidaDTO saveCategoria(@RequestBody @Valid CategoriaEntradaDTO categoriaDto) {
        return categoriaService.SaveCategoria(categoriaDto);
    }

    @PutMapping("/{id}")
    public CategoriaSalidaDTO updateCategoria(@PathVariable Integer id, @RequestBody @Valid CategoriaEntradaDTO categoriaDto) {
        return categoriaService.UpdateCategoria(id, categoriaDto);
    }

    @DeleteMapping("/{id}")
    public void deleteCategoria(@PathVariable Integer id) {
    categoriaService.deleteCategoria(id);
    }
}
