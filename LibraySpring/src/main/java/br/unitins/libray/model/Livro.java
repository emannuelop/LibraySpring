package br.unitins.libray.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long idLivro;

    @NotBlank(message = "O titulo é obrigatório.")
    String titulo;

    @NotBlank(message = "O autor do livro é obrigatório.")
    @ManyToOne
    Autor autor;

    @NotBlank(message = "O Isbn é obrigatório.")
    String isbn;

    Boolean disponivel;

}
