package com.company;

import java.util.ArrayList;

public class Pergunta

{
    //Variaveis de instancia.
    private String pergunta;
    private ArrayList<String> opcoes;
    private int respCorreta;

    /**
     * Construtor da classe Pergunta.
     * @param pergunta Pergunta do quizz.
     * @param respCorreta Indice da resposta correta.
     */
    public Pergunta(String pergunta, int respCorreta, ArrayList<String> opcoes) {
        this.pergunta = pergunta;
        this.respCorreta = respCorreta;
        this.opcoes = opcoes;
    }

    public String getPergunta()
    {
        return pergunta;
    }

    public void printOpcoes()
    {
        for (int i = 0; i < opcoes.size(); i++) {
            System.out.println((i+1) + ". " + opcoes.get(i));
        }
    }

    public int getRespCorreta()
    {
        return respCorreta;
    }
}
