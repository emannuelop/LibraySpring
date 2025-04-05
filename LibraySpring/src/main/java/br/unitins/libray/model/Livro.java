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

    @ManyToOne
    Autor autor;

    @NotBlank(message = "O Isbn é obrigatório.")
    String isbn;

    Boolean disponivel;

    public Long getIdLivro() {
        return idLivro;
    }

    public Autor getAutor() {
        return autor;
    }

    public Boolean getDisponivel() {
        return disponivel;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public void setDisponivel(Boolean disponivel) {
        this.disponivel = disponivel;
    }

    public void setIdLivro(Long idLivro) {
        this.idLivro = idLivro;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
