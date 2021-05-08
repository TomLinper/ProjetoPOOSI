package com.company;

import java.util.ArrayList;

/**
 * Classe que representa um professor.
 *
 * @author Carlos Mendes nº42762 / Ivo Gomes nº43573 / Tomas Pereira nº43133
 * @version 08/05/2021
 */
public class Professor extends Pessoa
{
	// Variaveis de instancia.
    private ArrayList<UC> uCurriculares;

    /**
     * Construtor da classe Professor.
     * @param nome Nome do Professor.
     * @param mail Email do Professor.
     * @param contacto Contacto do Professor.
     * @param pass Palavra passe do Professor.
     */
    public Professor(String nome, String mail, int contacto, String pass)
    {
        super(nome, mail, contacto, pass);
        this.uCurriculares = new ArrayList<>();
    }

    /**
     * Metodo para adicionar uma UC ao arraylist uCurriculares.
     */
    public void addUC(UC uC)
    {
        uCurriculares.add(uC);
    }

    /**
     * Imprime todas UCs no ArrayList uCurriculares.
     */
    public void printUC()
    {
    	for (int i = 0; i < uCurriculares.size(); i++) {
    		System.out.println((i+1) + ". " + uCurriculares.get(i).getNomeUC());
    	}
    }

    /**
     * Retorna a instancia da classe UC associada ao index.
     * @param index Indice da unidade curricular no ArrayList uCurriculares na classe Professor.
     * @return A instancia da classe UC associada ao index.
     */
    public UC getUCFromIndex(int index)
    {
        return uCurriculares.get(index-1);
    }

    @Override
    public int getNumAluno()
    {
        return 0;
    }
}
