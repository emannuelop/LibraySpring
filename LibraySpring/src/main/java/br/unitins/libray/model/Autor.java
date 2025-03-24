package br.unitins.libray.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long idAutor;

    @NotBlank(message = "O nome é obrigatório.")
    String nome;

    @NotBlank(message = "A nacionalidade é obrigatória.")
    String nacionalidade;
}
