package com.company;

import java.util.ArrayList;

public abstract class Pessoa {
    // Variáveis de instância
    private String nome;
    private String mail;
    private int contacto;
    private String pass;
    private ArrayList<Mensagem> mensagens;

    // Variáveis de classe
    private static String curso = "Engenharia Informática";

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
