package br.com.alura.forumhub.repository;

import br.com.alura.forumhub.model.Curso;
import org.springframework.data.repository.CrudRepository;

public interface CursoRepository extends CrudRepository<Curso, Long> {
}
