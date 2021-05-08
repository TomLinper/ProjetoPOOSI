package com.company;

import java.util.ArrayList;

/**
 * Classe que representa uma unidade curricular.
 *
 * @author Carlos Mendes nº42762 / Ivo Gomes nº43573 / Tomas Pereira nº43133
 * @version 08/05/2021
 */
public class UC
{
	// Variaveis de instancia.
    private String nomeUC;
    private ArrayList<Tema> temas;

    /**
     * Construtor da classe UC.
     * @param nomeUC Nome da unidade curricular que estamos a criar.
     */
    public UC(String nomeUC)
    {
        this.nomeUC = nomeUC;
        this.temas = new ArrayList<>();
    }

    public String getNomeUC()
    {
        return nomeUC;
    }

    /**
     * Metodo utilizado para criar temas.
     * @param nomeUC Nome da uc em que queremos criar temas.
     */
    public void criarTema(String nomeUC)
    {
        temas.add(new Tema(nomeUC));
    }
    /**
     * Metodo utilizado para imprimir conteudo que esta no tema.
     */
    public void printTema()
    {
        System.out.println("-------" + this.nomeUC + "-------");
        for (int i = 0; i < temas.size(); i++) {
            System.out.println((i+1) + ". " + temas.get(i).getNome());
        }
    }

    /**
     * Adiciona um objeto da classe Publicacao ao ArrayList publicacoes presente na classe Tema.
     * @param tema Instancia da classe Tema onde estão localizadas as publicacoes.
     * @param nPub Instancia da classe Publicacao a adicionar ao ArrayList.
     */
    public void criarPub(Tema tema, Publicacao nPub)
    {
        tema.criarPub(nPub);
    }

    /**
     * Retorna a instancia da classe Tema associada ao index na classe UC.
     * @param index Indice do tema no ArrayList temas na classe UC.
     * @return A instancia da classe Tema associada ao indice.
     */
    public Tema getTemaFromIndex(int index)
    {
        return temas.get(index-1);
    }

    /**
     * Imprime apenas as publicacoes marcadas como visiveis, num dado objeto da classe Tema.
     * @param tema Tema de onde serao impressas as publicacoes.
     */
    public void printPubsVisiveis(Tema tema)
    {
        System.out.println("-------" + this.nomeUC + "-------");
        System.out.println("---" + tema.getNome() + "---");
        tema.printPubsVisiveis();
    }

    /**
     * Imprime todas as publicacoes num dado objeto da classe Tema.
     * @param tema Tema de onde serao impressas as publicacoes.
     */
    public void printPubs(Tema tema)
    {
        System.out.println("-------" + this.nomeUC + "-------");
        System.out.println("---" + tema.getNome() + "---");
        tema.printPubs();
    }

    /**
     * Retorna a instancia da classe Publicacao associada ao index na classe Tema.
     * @param tema Instancia da classe Tema onde estao localizadas as publicacoes.
     * @param index Indice da publicacao no ArrayList publicacoes na classe Temas.
     * @return A instância da classe Publicacao associada ao indice.
     */
    public Publicacao getPubFromIndex(Tema tema, int index)
    {
        return tema.getPubFromIndex(index);
    }
}
