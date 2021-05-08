package com.company;

import java.time.LocalDate;

/**
 * Classe que representa um anuncio.
 *
 * @author Carlos Mendes nº42762 / Ivo Gomes nº43573 / Tomas Pereira nº43133
 * @version 08/05/2021
 */
public class Anuncio extends Publicacao{
	// Variaveis de instancia.
    private String titulo;
    private String corpo;
    
    /**
     * Construtor da classe Anuncio.
     * @param autor Autor do anuncio.
     * @param data Data em que o anuncio foi criado.
     * @param visibilidade Variavel que controla se o ficheiro e visivel ou nao para os alunos.
     * @param titulo Titulo do anuncio.
     * @param corpo Corpo do anuncio.
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
