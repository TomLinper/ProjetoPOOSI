package com.company;

import java.time.LocalDate;

public class Anuncio extends Publicacao{
    private String titulo;
    private String corpo;

    public Anuncio(String autor, LocalDate data, boolean visibilidade, String titulo, String corpo) {
        super(autor, data, visibilidade);
        this.titulo = titulo;
        this.corpo = corpo;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getCorpo() {
        return corpo;
    }

    @Override
    public String getNome() {
        return null;
    }

    @Override
    public String getExtensao() {
        return null;
    }
}
