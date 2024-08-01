package br.com.alura.forumhub.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class TopicoRequest {

    @NotBlank
    private String titulo;

    @NotBlank
    private String mensagem;

    @NotNull
    private Long autorId;

    @NotNull
    private Long cursoId;

    public @NotBlank String getTitulo() {
        return titulo;
    }

    public void setTitulo(@NotBlank String titulo) {
        this.titulo = titulo;
    }

    public @NotBlank String getMensagem() {
        return mensagem;
    }

    public void setMensagem(@NotBlank String mensagem) {
        this.mensagem = mensagem;
    }

    public @NotNull Long getAutorId() {
        return autorId;
    }

    public void setAutorId(@NotNull Long autorId) {
        this.autorId = autorId;
    }

    public @NotNull Long getCursoId() {
        return cursoId;
    }

    public void setCursoId(@NotNull Long cursoId) {
        this.cursoId = cursoId;
    }
}
