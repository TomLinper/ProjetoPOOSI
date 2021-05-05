package com.company;

public class Aluno extends Pessoa{
    // Variáveis de instância
    private int numAluno;

    public Aluno(String nome, String mail, int contacto, String pass, int numAluno) {
        super(nome, mail, contacto, pass);
        this.numAluno = numAluno;
    }

    public int getNumAluno() {
        return numAluno;
    }

    @Override
    public void printUC() { }

    @Override
    public UC getUCFromIndex(int index) {
        return null;
    }

    @Override
    public void addUC(UC uC) { }
}
