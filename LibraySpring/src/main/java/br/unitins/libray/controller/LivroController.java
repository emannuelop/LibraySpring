package br.unitins.libray.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.unitins.libray.dto.LivroDTO;
import br.unitins.libray.model.Livro;
import br.unitins.libray.service.LivroService;

import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @PostMapping
    Livro criarLivro(@RequestBody LivroDTO livro) {
        return livroService.salvarLivro(livro);
    }

    @GetMapping
    public List<Livro> listarLivros() {
        return livroService.BuscarTodosLivros(); 
    }

    @GetMapping("/{id}")
    public Livro buscarLivro(@PathVariable Long id) {
        return livroService.buscarLivro(id); 
    }

    @PutMapping("/{id}")
    public Livro atualizarLivro(@PathVariable Long id, @RequestBody LivroDTO livroAtualizado) {
        return livroService.atualizarLivro(id, livroAtualizado);
    }

    @DeleteMapping("/{id}")
    public void deletarLivro(@PathVariable Long id) {
        livroService.deletarLivro(id);
    }
    
}
