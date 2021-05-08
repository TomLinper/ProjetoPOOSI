package com.company;

import java.util.ArrayList;

public class UC {
	//variaveis de instancia
    private String nomeUC;
    private ArrayList<Tema> temas;
    /**
     * @param nomeUC: Nome da unidade curricular que estamos a criar
     */
    public UC(String nomeUC) {
        this.nomeUC = nomeUC;
        this.temas = new ArrayList<>();
    }

    public String getNomeUC() {
        return nomeUC;
    }
    /**
     * 
     * @param nomeUC:Nome da uc em que queremos criar temas
     * metodo utilizado para criar temas
     */
    public void criarTema(String nomeUC) {
        temas.add(new Tema(nomeUC));
    }
    /**
     * metodo utilizado para imprimir conteudo que esta no tema
     */
    public void printTema() {
        System.out.println("-------" + this.nomeUC + "-------");
        for (int i = 0; i < temas.size(); i++) {
            System.out.println((i+1) + ". " + temas.get(i).getNome());
        }
    }

    public void criarPub(Tema tema, Publicacao nPub) {
        tema.criarPub(nPub);
    }

    public Tema getTemaFromIndex(int index) {
        return temas.get(index-1);
    }

    public void printUC() {
        System.out.println("---------" + this.nomeUC + "---------");
        for (Tema t: temas) {
            System.out.println("---" + t.getNome() + "---");
            t.printPubsVisiveis();
        }
    }

    public void printPubsVisiveis(Tema tema) {
        System.out.println("-------" + this.nomeUC + "-------");
        System.out.println("---" + tema.getNome() + "---");
        tema.printPubsVisiveis();
    }

    public void printPubs(Tema tema) {
        System.out.println("-------" + this.nomeUC + "-------");
        System.out.println("---" + tema.getNome() + "---");
        tema.printPubs();
    }

    public Publicacao getPubFromIndex(Tema tema, int index) {
        return tema.getPubFromIndex(index);
    }
}
