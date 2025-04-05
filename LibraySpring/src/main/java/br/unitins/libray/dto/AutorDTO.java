package br.unitins.libray.dto;

import jakarta.validation.constraints.NotBlank;

public record AutorDTO(

    @NotBlank(message = "O nome é obrigatório.")
    String nome,

    @NotBlank(message = "A nacionalidade é obrigatória.")
    String nacionalidade

) {
    
}
