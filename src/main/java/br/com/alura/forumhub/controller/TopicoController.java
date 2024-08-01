package br.com.alura.forumhub.controller;

import br.com.alura.forumhub.dto.TopicoRequest;
import br.com.alura.forumhub.model.Curso;
import br.com.alura.forumhub.model.Topico;
import br.com.alura.forumhub.model.Usuario;
import br.com.alura.forumhub.repository.CursoRepository;
import br.com.alura.forumhub.repository.TopicoRepository;
import br.com.alura.forumhub.repository.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Optional;

@RestController
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @PostMapping("/topicos")
    public ResponseEntity<String> criarTopico(@RequestBody Topico topico, @RequestParam Long autorId, @RequestParam Long cursoId) {
        Usuario autor = usuarioRepository.findById(autorId).orElseThrow(() -> new RuntimeException("Autor não encontrado"));
        Curso curso = cursoRepository.findById(cursoId).orElseThrow(() -> new RuntimeException("Curso não encontrado"));

        Optional<Topico> topicoExistente = topicoRepository.findByTituloAndAutor(topico.getTitulo(), autor);
        if (topicoExistente.isPresent()) {
            throw new RuntimeException("Tópico duplicado");
        }

        topico.setAutor(autor);
        topico.setCurso(curso);

        topicoRepository.save(topico);
        if (topicoExistente.isPresent()) {
            return ResponseEntity.badRequest().body("Tópico duplicado.");
        }

        topicoRepository.save(topico);

        return  ResponseEntity.ok("Tópico criado com sucesso!");
    }
}
