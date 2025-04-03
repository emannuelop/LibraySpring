package br.unitins.libray.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.unitins.libray.repository.LivroRepository;
import br.unitins.libray.model.Livro;
import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    @Autowired
    LivroRepository livroRepository;

    //Criar novo livro
    public Livro salvarLivro (Livro livro) {
        return livroRepository.save(livro);
    }

    //Buscar todos os livros
    public List<Livro> BuscarTodosLivros() {
        return livroRepository.findAll();
    }

    public Livro atualizarLivro(Long id, Livro livroAtualizado) {
        Optional<Livro> livroExistente = livroRepository.findById(id);

        if (livroExistente.isPresent()) {
            Livro livro = livroExistente.get();
            livro.setAutor(livroAtualizado.getAutor());
            livro.setDisponivel(livroAtualizado.getDisponivel());
            livro.setIsbn(livroAtualizado.getIsbn());
            livro.setTitulo(livroAtualizado.getTitulo());
            return livroRepository.save(livro);
        }
        throw new RuntimeException("Livro não encontrado com ID: " + id);
    }

    public void deletarLivro(Long id) {
        livroRepository.deleteById(id);
    }
    
}
