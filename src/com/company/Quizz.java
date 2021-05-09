package com.company;

import org.w3c.dom.ls.LSOutput;

import java.time.LocalDate;
import java.util.ArrayList;

public class Quizz extends Publicacao {
    //Variaveis de instancia.
    private String titulo;
    private int nPerguntas;
    private ArrayList<Pergunta> perguntas;

    /**
     * Construtor da classe Quizz.
     * @param autor Autor da publicacao.
     * @param data Data de criacao da publicacao.
     * @param visibilidade Visibilidade da publicacao.
     * @param titulo Titulo do Quizz.
     * @param nPerguntas Numero de perguntas do quizz.
     */
    public Quizz(String autor, LocalDate data, boolean visibilidade, String titulo, int nPerguntas) {
        super(autor, data, visibilidade);
        this.titulo = titulo;
        this.nPerguntas = nPerguntas;
        this.perguntas = new ArrayList<>(nPerguntas);
    }

    public String getTitulo() {
        return titulo;
    }

    public int getnPerguntas() {
        return nPerguntas;
    }

    public int getRespCorreta(int index) {
        return perguntas.get(index).getRespCorreta();
    }

    public void addPergunta(Pergunta pergunta) {
        perguntas.add(pergunta);
    }

    public void printPergunta(int index) {
        System.out.println(perguntas.get(index).getPergunta());
    }

    public void printOpcoes(int index) {
        perguntas.get(index).printOpcoes();
    }

    @Override
    public String getNome() {
        return null;
    }

    @Override
    public String getExtensao() {
        return null;
    }

    @Override
    public String getCorpo() {
        return null;
    }
}
