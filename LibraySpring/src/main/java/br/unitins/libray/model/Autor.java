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
    private Long idAutor;

    @NotBlank(message = "O nome é obrigatório.")
    private String nome;

    @NotBlank(message = "A nacionalidade é obrigatória.")
    private String nacionalidade;

    public Long getIdAutor() {
        return idAutor;
    }

    public String getNome() {
        return nome;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setIdAutor(Long idAutor) {
        this.idAutor = idAutor;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }
}
