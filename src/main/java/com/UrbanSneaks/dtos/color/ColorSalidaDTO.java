package com.UrbanSneaks.dtos.color;

import jakarta.validation.constraints.NotBlank;

public record ColorSalidaDTO (
      Integer IdColor,
      @NotBlank(message = "El nombre es obligatorio" )
      String nomColor
)
{
}
