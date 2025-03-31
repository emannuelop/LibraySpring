package br.unitins.libray.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.unitins.libray.repository.LivroRepository;
import br.unitins.libray.model.Livro;
import java.util.List;

@Service
public class LivroService {

    @Autowired
    LivroRepository LivroRepository;

    //Criar novo livro
    public Livro salvarLivro (Livro livro) {
        return LivroRepository.save(livro);
    }

    //Buscar todos os livros
    public List<Livro> BuscarTodosLivros() {
        return LivroRepository.findAll();
    }
    
}
