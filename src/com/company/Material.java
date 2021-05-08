package com.company;

import java.time.LocalDate;

public class Material extends Publicacao{
	//variaveis de instancia
    private String extensao;
    private String nome;
    
    /**
     * 
     * @param autor: Pessoa que criou o ficheiro
     * @param data: Data em que o ficheiro foi criado
     * @param extensao: Tipo de ficheiro
     * @param nome: O nome do ficheiro
     * @param visibilidade: variavel que controla se o ficheiro e visivel ou não para os alunos
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
