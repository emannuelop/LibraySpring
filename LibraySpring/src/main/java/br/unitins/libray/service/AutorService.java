package br.unitins.libray.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.unitins.libray.repository.AutorRepository;
import br.unitins.libray.model.Autor;
import java.util.List;
import java.util.Optional;

@Service
public class AutorService {

    @Autowired
    AutorRepository autorRepository;

    //Criar novo autor
    public Autor salvarAutor (Autor autor) {
        return autorRepository.save(autor);
    }

    //Buscar todos os autors
    public List<Autor> BuscarTodosAutores() {
        return autorRepository.findAll();
    }

    public Autor atualizarAutor(Long id, Autor autorAtualizado) {
        Optional<Autor> autorExistente = autorRepository.findById(id);

        if (autorExistente.isPresent()) {
            Autor autor = autorExistente.get();
            autor.setNome(autorAtualizado.getNome());
            autor.setNacionalidade(autorAtualizado.getNacionalidade());
            return autorRepository.save(autor);
        }
        throw new RuntimeException("Autor não encontrado com ID: " + id);
    }

    public void deletarAutor(Long id) {
        autorRepository.deleteById(id);
    }
    
}
