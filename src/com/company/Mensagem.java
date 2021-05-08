package com.company;

import java.time.LocalDate;

/**
 * Classe que representa uma mensagem.
 *
 * @author Carlos Mendes nº42762 / Ivo Gomes nº43573 / Tomas Pereira nº43133
 * @version 08/05/2021
 */
public class Mensagem {
	// Variaveis de instancia.
	private String autor;
	private String assunto;
	private String corpo;
	private LocalDate data;
	private boolean lida;

	/**
	 * Construtor da classe Mensagem.
	 * @param autor Autor da mensagem.
	 * @param assunto Assunto da mensagem.
	 * @param corpo Texto contido na mensagem.
	 * @param data Data em que a mensagem foi criada.
	 */
	public Mensagem(String autor, String assunto, String corpo, LocalDate data) {
		this.autor = autor;
		this.assunto = assunto;
		this.corpo = corpo;
		this.data = data;
		this.lida = false;
	}

	public String getAutor() {
		return autor;
	}

	public String getAssunto() {
		return assunto;
	}

	public String getCorpo() {
		return corpo;
	}

	public LocalDate getData() {
		return data;
	}

	public boolean isLida() {
		return lida;
	}

	public void setLida(boolean lida) {
		this.lida = lida;
	}

	@Override
	public String toString() {
		return "Autor: " + autor + "\nData: " + data + "\nAssunto: " + assunto + "\nCorpo: " + corpo;
	}
	
}
