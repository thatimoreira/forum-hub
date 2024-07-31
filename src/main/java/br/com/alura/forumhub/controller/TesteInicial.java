package br.com.alura.forumhub.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TesteInicial {

    @GetMapping("/")
    public String TesteInicial() {
        return "SUCESSO!!!";
    }
}
