package com.UrbanSneaks.dtos.categoria;

import jakarta.validation.constraints.NotBlank;

public record CategoriaSalidaDTO(
    Integer idCategoria,
    @NotBlank(message = "El nombre es obligatorio")
    String nomCategoria
) {  }
