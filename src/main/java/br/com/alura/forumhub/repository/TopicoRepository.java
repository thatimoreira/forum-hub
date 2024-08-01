package br.com.alura.forumhub.repository;

import br.com.alura.forumhub.model.Topico;
import br.com.alura.forumhub.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TopicoRepository extends JpaRepository<Topico, Long> {
    Optional<Topico> findByTituloAndMensagem(String titulo, String mensagem);

    Optional<Topico> findByTituloAndAutor(String titulo, Usuario autor);
}
