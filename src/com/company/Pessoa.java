package com.company;

import java.util.ArrayList;

public abstract class Pessoa {
    // Variaveis de instancia
    private String nome;
    private String mail;
    private int contacto;
    private String pass;
    private ArrayList<Mensagem> mensagens;

    // Variaveis de classe
    private static String curso = "Engenharia Informatica";
    /**
     * 
     * @param nome: Nome da Pessoa (Aluno ou Professor)
     * @param mail: Email da Pessoa
     * @param contacto: Numero de telemovel da pessoa
     * @param pass: Palavra passe para fazer login
     */
    public Pessoa(String nome, String mail, int contacto, String pass) {
        this.nome = nome;
        this.mail = mail;
        this.contacto = contacto;
        this.pass = pass;
        this.mensagens = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public String getMail() {
        return mail;
    }

    public int getContacto() {
        return contacto;
    }

    public String getPass() {
        return pass;
    }

    public static String getCurso() {
        return curso;
    }

    /**
     * Adiciona um objeto da
     * @param msg
     */
    public void sendMsg(Mensagem msg) {
        mensagens.add(msg);
    }
    /**
     * 
     * @param index: numero da mensagem que a pessoa quer ler
     * @return da mensagem escolhida para ler
     */
    public Mensagem getMsgNLidas(int index) {
        ArrayList<Mensagem> nLidas = new ArrayList<>();
        for (int i = 0; i < mensagens.size(); i++) {
            if (!mensagens.get(i).isLida()) {
                nLidas.add(mensagens.get(i));
            }
        }

        Mensagem msg = nLidas.get(index-1);

        return msg;
    }
    /**
     * metodo utilizado para ver as mensagens que ainda nao foram lidas
     */
    public void printMsg() {
        for (int i = 0; i < mensagens.size(); i++) {
            if (!mensagens.get(i).isLida()) {
                System.out.println((i+1) + ". " + mensagens.get(i).getAssunto() + " - " + mensagens.get(i).getAutor());
            }
        }
    }
    
    public abstract void printUC();

    public abstract UC getUCFromIndex(int index);

    public abstract void addUC(UC uC);

    public abstract int getNumAluno();
}
