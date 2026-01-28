package com.UrbanSneaks.serviceImpl;

import com.UrbanSneaks.dtos.categoria.CategoriaEntradaDTO;
import com.UrbanSneaks.dtos.categoria.CategoriaSalidaDTO;
import com.UrbanSneaks.mapper.CategoriaMapper;
import com.UrbanSneaks.model.Categoria;
import com.UrbanSneaks.repository.CategoriaRepository;
import com.UrbanSneaks.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    public CategoriaMapper categoriaMapper;

    @Override
    public List<CategoriaSalidaDTO> FindAllCategoria() {
        return categoriaRepository.findByEstadoCategiriaTrue()
                .stream()
                .map(categoriaMapper::toSalidaDto)
                .toList();
    }

    @Override
    public CategoriaSalidaDTO FindAllById(Integer id) {
       Categoria categoria = categoriaRepository.findById(id)
               .orElseThrow(()-> new RuntimeException("categoria no encontrada")
               );
       return categoriaMapper.toSalidaDto(categoria);
    }

    @Override
    public CategoriaSalidaDTO SaveCategoria(CategoriaEntradaDTO categoriaDto) {

        if(categoriaRepository.existsByNomCategoriaIgnoreCase(categoriaDto.nombre())){
            throw new RuntimeException("La categoria ya existe");
        }

        Categoria categoria = categoriaMapper.toEntity(categoriaDto);
        categoria.setEstadoCategiria(true);
        return categoriaMapper.toSalidaDto(
                categoriaRepository.save(categoria)
        );
    }

    @Override
    public CategoriaSalidaDTO UpdateCategoria(Integer id, CategoriaEntradaDTO categoriaDto) {
           Categoria categoria = categoriaRepository.findById(id)
                   .orElseThrow(()-> new RuntimeException("categoria no encontrada"));
           categoria.setNomCategoria(categoriaDto.nombre());

        return categoriaMapper.toSalidaDto(
                categoriaRepository.save(categoria)
        );
    }

    @Override
    public void deleteCategoria(Integer id) {
        Categoria categoria = categoriaRepository.findById(id)
                        .orElseThrow(() -> new RuntimeException("Categoria no encontrada"));
        categoria.setEstadoCategiria(false);
    categoriaRepository.save(categoria);
    }
}
