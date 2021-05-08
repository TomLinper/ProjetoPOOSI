package com.company;

import java.util.ArrayList;

/**
 * Classe abstrata que representa uma Pessoa.
 *
 * @author Carlos Mendes nº42762 / Ivo Gomes nº43573 / Tomas Pereira nº43133
 * @version 08/05/2021
 */
public abstract class Pessoa {
    // Variaveis de instancia.
    private String nome;
    private String mail;
    private int contacto;
    private String pass;
    private ArrayList<Mensagem> mensagens;

    // Variaveis de classe.
    private static String curso = "Engenharia Informatica";

    /**
     * Construtor da classe Pessoa.
     * @param nome Nome da Pessoa (Aluno ou Professor).
     * @param mail Email da Pessoa.
     * @param contacto Numero de telemovel da pessoa.
     * @param pass Palavra passe para fazer login.
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
     * Adiciona um objeto da classe Mensagem ao ArrayList mensagens.
     * @param msg Objeto do tipo Mensagem a adicionar.
     */
    public void sendMsg(Mensagem msg) {
        mensagens.add(msg);
    }

    /**
     * Imprime todas as mensagens nao lidas presentes no ArrayList mensagens.
     * @param index Indice da mensagem a ler.
     * @return o objeto do tipo Mensagem escolhido.
     */
    public Mensagem getMsgFromIndex(int index) {
        ArrayList<Mensagem> nLidas = new ArrayList<>();
        for (int i = 0; i < mensagens.size(); i++) {
            if (!mensagens.get(i).isLida()) {
                nLidas.add(mensagens.get(i));
            }
        }

        return nLidas.get(index-1);
    }

    /**
     * Metodo utilizado para ver as mensagens que ainda nao foram lidas.
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
