package br.unitins.libray.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.unitins.libray.model.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long>{

}
