package com.company;

import java.util.ArrayList;

public class Professor extends Pessoa{
    private ArrayList<UC> uCurriculares;

    public Professor(String nome, String mail, int contacto, String pass) {
        super(nome, mail, contacto, pass);
        this.uCurriculares = new ArrayList<>();
    }

    public void addUC(UC uC) {
        uCurriculares.add(uC);
    }

    @Override
    public int getNumAluno() {
        return 0;
    }

    /**
     * Imprime todas UCs no ArrayList uCurriculares.
     */
    public void printUC() {
    	for (int i = 0; i < uCurriculares.size(); i++) {
    		System.out.println((i+1) + ". " + uCurriculares.get(i).getNomeUC());
    	}
    }

    /**
     * Retorna a instância da classe UC associada ao index.
     * @param index Índice da unidade curricular no ArrayList uCurriculares na classe Professor.
     * @return A instância da classe UC associada ao index.
     */
    public UC getUCFromIndex(int index) {
        return uCurriculares.get(index-1);
    }
}
