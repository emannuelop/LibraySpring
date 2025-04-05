package br.unitins.libray.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.unitins.libray.dto.AutorDTO;
import br.unitins.libray.model.Autor;
import br.unitins.libray.service.AutorService;

import java.util.List;

@RestController
@RequestMapping("/autores")
public class AutorController {

    @Autowired
    private AutorService autorService;

    @PostMapping
    Autor criarAutor(@RequestBody AutorDTO autor) {
        return autorService.salvarAutor(autor);
    }

    @GetMapping
    public List<Autor> listarAutores() {
        return autorService.BuscarTodosAutores(); 
    }

    @GetMapping("/{id}")
    public Autor buscarAutor(@PathVariable Long id) {
        return autorService.buscarAutor(id); 
    }

    @PutMapping("/{id}")
    public Autor atualizarAutor(@PathVariable Long id, @RequestBody AutorDTO autorAtualizado) {
        return autorService.atualizarAutor(id, autorAtualizado);
    }

    @DeleteMapping("/{id}")
    public void deletarAutor(@PathVariable Long id) {
        autorService.deletarAutor(id);
    }
    
}
