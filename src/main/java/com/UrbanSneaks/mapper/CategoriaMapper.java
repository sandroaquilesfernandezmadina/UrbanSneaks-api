package com.UrbanSneaks.mapper;

import com.UrbanSneaks.dtos.categoria.CategoriaEntradaDTO;
import com.UrbanSneaks.dtos.categoria.CategoriaSalidaDTO;
import com.UrbanSneaks.model.Categoria;
import org.springframework.stereotype.Component;

@Component
public class CategoriaMapper {


    public  Categoria toEntity(CategoriaEntradaDTO categoriaDto){
    Categoria categoria = new Categoria();
    categoria.setNomCategoria(categoriaDto.nombre());
    categoria.setEstadoCategiria(true);
    return categoria;
    }

    public  CategoriaSalidaDTO toSalidaDto(Categoria categoria){
        return new CategoriaSalidaDTO(
                categoria.getIdCatategoria(),
                categoria.getNomCategoria()
        );
    }
}


