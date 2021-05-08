package com.company;

import java.time.LocalDate;

public class Mensagem {
	private String autor;
	private String assunto;
	private String corpo;
	private LocalDate data;
	private boolean lida;

	/**
	 * @param autor
	 * @param assunto
	 * @param corpo
	 * @param data
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

	@Override
	public String toString() {
		return "Autor: " + autor + "\nData: " + data + "\nAssunto: " + assunto + "\nCorpo: " + corpo;
	}
	
}
