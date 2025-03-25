package br.unitins.libray.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

public class Administrador {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long idAdmin;

    @NotBlank(message = "O cargo é obrigatório.")
    String cargo;
}
