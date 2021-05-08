package com.company;

/**
 * Classe que representa um aluno.
 *
 * @author Carlos Mendes nº42762 / Ivo Gomes nº43573 / Tomas Pereira nº43133
 * @version 08/05/2021
 */
public class Aluno extends Pessoa
{
    // Variaveis de instancia.
    private int numAluno;

    /**
     * Construtor da classe Aluno.
     * @param nome Nome do aluno.
     * @param mail Mail do aluno.
     * @param contacto Contacto telefonico do aluno.
     * @param pass Password do aluno usada para efectuar login.
     * @param numAluno Numero do aluno.
     */
    public Aluno(String nome, String mail, int contacto, String pass, int numAluno)
    {
        super(nome, mail, contacto, pass);
        this.numAluno = numAluno;
    }

    public int getNumAluno()
    {
        return numAluno;
    }

    @Override
    public void printUC() { }

    @Override
    public UC getUCFromIndex(int index)
    {
        return null;
    }

    @Override
    public void addUC(UC uC) { }
}
