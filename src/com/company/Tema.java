package com.company;

import java.util.ArrayList;

public class Tema {
	private ArrayList<Publicacao> publicacoes;
	private String nome;
	
	public Tema(String nome) {
		this.nome = nome;
		this.publicacoes = new ArrayList<>();
	}

	public String getNome() {
		return nome;
	}

	/**
	 * Adiciona uma instancia da classe Publicacao ao ArrayList publicacoes.
	 * @param nPub Instancia da classe Publicacoes a adicionar.
	 */
	public void criarPub(Publicacao nPub) {
        publicacoes.add(nPub);
    }

	/**
	 * Imprime as publicacaoes visiveis associadas a uma instancia da classe Tema.
	 */
	public void printPubsVisiveis() {
		int k = 0;
		for (Publicacao p : publicacoes) {
			if (p.getClass().getName().equals("com.company.Material") && p.isVisibilidade()) {
				System.out.println((k+1) + ". "+ p.getNome() + "." + p.getExtensao());
			} else if (p.getClass().getName().equals("com.company.Anuncio") && p.isVisibilidade()) {
				System.out.println((k+1) + ". " + p.getTitulo());
			}
			k++;
		}
	}

	/**
	 * Imprime todas as publicacaoes associadas a uma instancia da classe Tema.
	 */
	public void printPubs() {
		int k = 0;
		for (Publicacao p : publicacoes) {
			if (p.getClass().getName().equals("com.company.Material")) {
				System.out.println((k+1) + ". "+ p.getNome() + "." + p.getExtensao());
			} else if (p.getClass().getName().equals("com.company.Anuncio")) {
				System.out.println((k+1) + ". " + p.getTitulo());
			}
			k++;
		}
	}

	public Publicacao getPubFromIndex(int index) {
		return publicacoes.get(index-1);
	}
}
