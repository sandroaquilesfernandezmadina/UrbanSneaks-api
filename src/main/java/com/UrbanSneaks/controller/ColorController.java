package com.UrbanSneaks.controller;

import com.UrbanSneaks.dtos.categoria.CategoriaSalidaDTO;
import com.UrbanSneaks.dtos.color.ColorEntradaDTO;
import com.UrbanSneaks.dtos.color.ColorSalidaDTO;
import com.UrbanSneaks.service.ColorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/color")
public class ColorController {

    @Autowired
    private ColorService colorService;

    @GetMapping
    public List<ColorSalidaDTO> findAllColor(){
        return colorService.findAll();
    }

    @GetMapping("/{id}")
    public ColorSalidaDTO findAllById(@PathVariable Integer id){
        return colorService.finDAllById(id);
    }

    @PostMapping
    public ColorSalidaDTO saveColor(@RequestBody @Valid ColorEntradaDTO colorDto){
        return colorService.SaveColor(colorDto);
    }

    @PutMapping("/{id}")
    public ColorSalidaDTO UpdateColor(@PathVariable Integer id, @RequestBody ColorEntradaDTO colorDto){
        return colorService.UpdateColor(id, colorDto);
    }

    @DeleteMapping("/{id}")
    public void deleteClor(@PathVariable Integer id){
        colorService.deleteColor(id);
    }
}
