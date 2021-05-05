package com.company;

import java.time.LocalDate;

public class Material extends Publicacao{
    private String extensao;
    private String nome;

    public Material(String autor, LocalDate data, String extensao, String nome, boolean visibilidade) {
        super(autor, data, visibilidade);
        this.extensao = extensao;
        this.nome = nome;
    }

    public String getExtensao() {
        return extensao;
    }

    @Override
    public String getTitulo() {
        return null;
    }

    @Override
    public String getCorpo() {
        return null;
    }

    public String getNome() {
        return nome;
    }
}
