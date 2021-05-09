package com.company;

import java.time.LocalDate;

/**
 * Classe abstrata que representa uma publicacao.
 *
 * @author Carlos Mendes nº42762 / Ivo Gomes nº43573 / Tomas Pereira nº43133
 * @version 08/05/2021
 */
public abstract class Publicacao
{
	// Variaveis de instancia.
    private String autor;
    private LocalDate data;
    private boolean visivel;

    /**
     * Construtor da classe Publicacao.
     * @param autor Autor da publicacao.
     * @param data Data em que a publicacao foi criada.
     * @param visivel Variavel que controla se a publicacao e visivel ou nao para os alunos.
     */
    public Publicacao(String autor, LocalDate data, boolean visivel)
    {
        this.autor = autor;
        this.data = data;
        this.visivel = visivel;
    }

    public String getAutor()
    {
        return autor;
    }

    public LocalDate getData()
    {
        return data;
    }

    public boolean isVisivel()
    {
        return visivel;
    }

    public void setVisivel(boolean visivel)
    {
        this.visivel = visivel;
    }

    public abstract String getNome();

    public abstract String getExtensao();

    public abstract String getTitulo();

    public abstract String getCorpo();

    public abstract int getnPerguntas();

    public abstract void addPergunta(Pergunta pergunta);

    public abstract void printPergunta(int index);

    public abstract void printOpcoes(int index);

    public abstract int getRespCorreta(int index);
}
