package com.company;

import java.time.LocalDate;

public abstract class Publicacao {
	//variaveis de instancia
    private String autor;
    private LocalDate data;
    private boolean visibilidade;
    /**
     * 
     * @param autor: Autor da publicacao
     * @param data: Data em que a publicacao foi criada
     * @param visibilidade : variavel que controla se a publicacao e visivel ou nao para os alunos
     */
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
