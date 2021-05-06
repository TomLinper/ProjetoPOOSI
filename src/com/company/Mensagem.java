package com.company;

import java.time.LocalDate;

public class Mensagem {
	private String autor;
	private String assunto;
	private String corpo;
	private LocalDate data;
	/**
	 * @param autor
	 * @param assunto
	 * @param corpo
	 * @param data
	 */
	public Mensagem(String autor, String assunto, String corpo, LocalDate data) {
		super();
		this.autor = autor;
		this.assunto = assunto;
		this.corpo = corpo;
		this.data = data;
	}
	@Override
	public String toString() {
		return "Mensagem autor=" + autor + ", assunto=" + assunto + ", corpo=" + corpo + ", data=" + data;
	}
	
}
