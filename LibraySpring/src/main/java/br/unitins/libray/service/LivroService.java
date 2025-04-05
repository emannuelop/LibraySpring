package br.unitins.libray.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unitins.libray.repository.AutorRepository;
import br.unitins.libray.repository.LivroRepository;
import br.unitins.libray.dto.LivroDTO;
import br.unitins.libray.model.Autor;
import br.unitins.libray.model.Livro;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    @Autowired
    LivroRepository livroRepository;

    @Autowired
    AutorRepository autorRepository;

    //Criar novo livro
    public Livro salvarLivro (LivroDTO livro) {
        Livro livroNovo = new Livro();

        Autor autor = autorRepository.findById(livro.idAutor())
                .orElseThrow(() -> new RuntimeException("Autor não encontrado com ID: " + livro.idAutor()));

        livroNovo.setAutor(autor);
        livroNovo.setDisponivel(true);
        livroNovo.setIsbn(livro.isbn());
        livroNovo.setTitulo(livro.titulo());

        return livroRepository.save(livroNovo);
    }

    //Buscar todos os livros
    public List<Livro> BuscarTodosLivros() {
        return livroRepository.findAll();
    }

    public Livro buscarLivro(Long id) {
        Optional<Livro> livroExistente = livroRepository.findById(id);
        if (livroExistente.isPresent()) {
            Livro livro = livroExistente.get();
            return livro;
        }
        throw new RuntimeException("Livro não encontrado com ID: " + id);
    }

    public Livro atualizarLivro(Long id, LivroDTO livroAtualizado) {
        Optional<Livro> livroExistente = livroRepository.findById(id);

        Autor autor = autorRepository.findById(livroAtualizado.idAutor())
                .orElseThrow(() -> new RuntimeException("Autor não encontrado com ID: " + livroAtualizado.idAutor()));

        if (livroExistente.isPresent()) {
            Livro livro = livroExistente.get();
            livro.setAutor(autor);
            livro.setIsbn(livroAtualizado.isbn());
            livro.setTitulo(livroAtualizado.titulo());
            return livroRepository.save(livro);
        }
        throw new RuntimeException("Livro não encontrado com ID: " + id);
    }

    public void deletarLivro(Long id) {
        livroRepository.deleteById(id);
    }
    
}
