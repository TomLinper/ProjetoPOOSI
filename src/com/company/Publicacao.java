package com.company;

import java.time.LocalDate;

public abstract class Publicacao {
    private String autor;
    private LocalDate data;
    private boolean visibilidade;

    public Publicacao(String autor, LocalDate data, boolean visibilidade) {
        this.autor = autor;
        this.data = data;
        this.visibilidade = visibilidade;
    }

    public String getAutor() {
        return autor;
    }

    public LocalDate getData() {
        return data;
    }

    public boolean isVisibilidade() {
        return visibilidade;
    }

    public void setVisibilidade(boolean visibilidade) {
        this.visibilidade = visibilidade;
    }

    public abstract String getNome();

    public abstract String getExtensao();

    public abstract String getTitulo();

    public abstract String getCorpo();
}
