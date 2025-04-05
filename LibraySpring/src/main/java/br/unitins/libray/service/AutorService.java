package br.unitins.libray.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.unitins.libray.repository.AutorRepository;
import br.unitins.libray.dto.AutorDTO;
import br.unitins.libray.model.Autor;

import java.util.List;
import java.util.Optional;

@Service
public class AutorService {

    @Autowired
    AutorRepository autorRepository;

    //Criar novo autor
    public Autor salvarAutor (AutorDTO autor) {
        Autor autorNovo = new Autor();

        autorNovo.setNacionalidade(autor.nacionalidade());
        autorNovo.setNome(autor.nome());
        return autorRepository.save(autorNovo);
    }

    //Buscar todos os autors
    public List<Autor> BuscarTodosAutores() {
        return autorRepository.findAll();
    }

    public Autor buscarAutor(Long id) {
        Optional<Autor> autorExistente = autorRepository.findById(id);
        if (autorExistente.isPresent()) {
            Autor autor = autorExistente.get();
            return autor;
        }
        throw new RuntimeException("Autor não encontrado com ID: " + id);
    }

    public Autor atualizarAutor(Long id, AutorDTO autorAtualizado) {
        Optional<Autor> autorExistente = autorRepository.findById(id);

        if (autorExistente.isPresent()) {
            Autor autor = autorExistente.get();
            autor.setNome(autorAtualizado.nome());
            autor.setNacionalidade(autorAtualizado.nacionalidade());
            return autorRepository.save(autor);
        }
        throw new RuntimeException("Autor não encontrado com ID: " + id);
    }

    public void deletarAutor(Long id) {
        autorRepository.deleteById(id);
    }
    
}
