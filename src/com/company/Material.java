package com.company;

import java.time.LocalDate;

/**
 * Classe que representa um material.
 *
 * @author Carlos Mendes nº42762 / Ivo Gomes nº43573 / Tomas Pereira nº43133
 * @version 08/05/2021
 */
public class Material extends Publicacao{
	// Variaveis de instancia
    private String extensao;
    private String nome;
    
    /**
     * Construtor da classe Material.
     * @param autor Pessoa que criou o ficheiro.
     * @param data Data em que o ficheiro foi criado.
     * @param extensao Tipo de ficheiro.
     * @param nome O nome do ficheiro.
     * @param visibilidade Variavel que controla se o ficheiro e visivel ou nao para os alunos.
     */
    public Material(String autor, LocalDate data, String extensao, String nome, boolean visibilidade) {
        super(autor, data, visibilidade);
        this.extensao = extensao;
        this.nome = nome;
    }

    public String getExtensao() {
        return extensao;
    }

    @Override
    public String getTitulo() {
        return null;
    }

    @Override
    public String getCorpo() {
        return null;
    }

    public String getNome() {
        return nome;
    }
}
