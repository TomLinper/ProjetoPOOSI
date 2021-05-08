package com.company;

import java.time.LocalDate;

public class Anuncio extends Publicacao{
	// Variaveis de instancia
    private String titulo;
    private String corpo;
    
    /**
     * 
     * @param autor: autor do anuncio
     * @param data: Data em que o anuncio foi criado
     * @param visibilidade: variavel que controla se o ficheiro e visivel ou não para os alunos
     * @param titulo: Título do anúncio
     * @param corpo: Corpo do anuncio
     */
    public Anuncio(String autor, LocalDate data, boolean visibilidade, String titulo, String corpo) {
        super(autor, data, visibilidade);
        this.titulo = titulo;
        this.corpo = corpo;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getCorpo() {
        return corpo;
    }

    @Override
    public String getNome() {
        return null;
    }

    @Override
    public String getExtensao() {
        return null;
    }
}
