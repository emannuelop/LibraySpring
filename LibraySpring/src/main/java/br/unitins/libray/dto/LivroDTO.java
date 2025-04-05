package br.unitins.libray.dto;

import jakarta.validation.constraints.NotBlank;

public record LivroDTO(

    @NotBlank(message = "O titulo é obrigatório.")
    String titulo,

    Long idAutor,

    @NotBlank(message = "O Isbn é obrigatório.")
    String isbn
) {
    
}
