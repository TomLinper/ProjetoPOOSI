package com.company;

public abstract class Pessoa {
    // Variáveis de instância
    private String nome;
    private String mail;
    private int contacto;
    private String pass;

    // Variáveis de classe
    private static String curso = "Engenharia Informática";

    public Pessoa(String nome, String mail, int contacto, String pass) {
        this.nome = nome;
        this.mail = mail;
        this.contacto = contacto;
        this.pass = pass;
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
    
    public abstract void printUC();

    public abstract UC getUCFromIndex(int index);

    public abstract void addUC(UC uC);

    public abstract int getNumAluno();
}
