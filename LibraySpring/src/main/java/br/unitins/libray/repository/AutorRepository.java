package br.unitins.libray.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.unitins.libray.model.Autor;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long>{

}
