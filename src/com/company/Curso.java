package com.company;

import java.util.ArrayList;

/**
 * Classe usada para gerir o curso e para estabelecer ligacao entre a classe Main e as restantes classes.
 *
 * @author Carlos Mendes nº42762 / Ivo Gomes nº43573 / Tomas Pereira nº43133
 * @version 08/05/2021
 */
public class Curso {
    //Variaveis de instancia.
    private ArrayList<Pessoa> pessoas;
    private ArrayList<UC> uCurriculares;
    private int numMaxParticipantes;
    private int nPartAtual;

    //Variaveis de classe
    private static String nomeCurso = "Engenharia Informatica";

    /**
     * Construtor da classe Curso.
     * @param numMaxParticipantes Numero de participantes do curso.
     */
    public Curso(int numMaxParticipantes) {
        this.numMaxParticipantes = numMaxParticipantes;
        this.uCurriculares = new ArrayList<>();
        this.pessoas = new ArrayList<>(numMaxParticipantes);
        this.nPartAtual = 0;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public int getNumParticipantes() {
        return numMaxParticipantes;
    }

    /**
     * Metodo usado para adicionar um novo objeto da classe Aluno ao array alunos.
     * @param nPessoa Objeto da classe pessoa a adicionar ao ArrayList pessoas.
     */
    public void addPessoa(Pessoa nPessoa) {
        if (nPartAtual < 100) {
            pessoas.add(nPessoa);
            nPartAtual++;
        } else {
            System.out.println("Numero maximo de participantes no curso foi atingido.");
        }
    }

    /**
     * Verifica se o numero de aluno ja existe.
     * @param numAluno Numero de aluno.
     */
    public boolean checkNum(int numAluno) {
        for (Pessoa p : pessoas) {
            if (p.getClass().getName().equals("com.company.Aluno") && p.getNumAluno() == numAluno) {
                return false;
            }
        }
        return true;
    }

    /**
     * Verifica se as credenciais de login estao corretas.
     * @param nome Nome a confirmar.
     * @param pass Password a confirmar.
     * @param tipo Tipo de Pessoa.
     * @return true se as credenciais forem confirmadas e false se nao forem.
     */
    public boolean checkLogin(String nome, String pass, String tipo) {
        for (Pessoa i : pessoas) {
            if (i.getNome().equals(nome) && i.getPass().equals(pass) && i.getClass().getName().equals(tipo)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Procura o nome e a password no ArrayList pessoas e retorna o objeto o, caso encontre.
     * @param nome Nome de utilizador.
     * @param pass Password do utilizador.
     * @return O objeto da classe Pessoa associados aos dados, caso encontre correspondencia. Caso nao encontre, retorna null.
     */
    public Pessoa getUserAtual(String nome, String pass) {
        for (Pessoa i : pessoas) {
            if (i.getNome().equals(nome) && i.getPass().equals(pass)) {
                return i;
            }
        }
		return null;
    }
    
    /**
     * Adiciona um objeto da classe UC ao array uCurriculares.
     * @param nomeUC Nome da unidade curricular.
     */
    public void addUC(String nomeUC) {
        uCurriculares.add(new UC(nomeUC));
    }

    /**
     * Adiciona uma unidade curricular ao ArrayList uCurriculares presente numa dada instancia da classe Pessoa.
     * @param prof Objeto da classe pessoa.
     * @param index Indice da unidade curricular no ArrayList uCurriculares.
     */
    public void addUCProf(Pessoa prof, int index) {
        prof.addUC(uCurriculares.get(index-1));
    }

    /**
     * Imprime o nome de todas as unidades curriculares.
     */
    public void printUCs() {
        for (int i = 0; i < uCurriculares.size(); i++) {
            System.out.println((i+1) + ". " + uCurriculares.get(i).getNomeUC());
        }
    }

    /**
     * Imprime o nome de todas as unidades curriculares associadas a uma dada instância da classe Pessoa.
     * @param userAtual Instância da classe Pessoa.
     */
    public void printUCProf(Pessoa userAtual) {
        userAtual.printUC();
    }

    /**
     * Retorna o objeto da classe UC associada ao index.
     * @param index Indice da unidade curricular no ArrayList uCurriculares.
     * @return O objeto da classe UC associada ao indice.
     */
    public UC getUCFromIndex(int index) {
        return uCurriculares.get(index-1);
    }

    /**
     * Retorna o objeto da classe UC associada ao index na classe Professor.
     * @param userAtual Instancia da classe Pessoa a adicionar ao ArrayList.
     * @param index Indice da unidade curricular no ArrayList uCurriculares na classe Professor.
     * @return O objeto da classe UC associada ao indice.
     */
    public UC getUCProfFromIndex(Pessoa userAtual, int index) {
        return userAtual.getUCFromIndex(index);
    }

    /**
     * Adiciona um objeto da classe Tema ao ArrayList temas presente na classe UC.
     * @param uc Instancia da unidade curricular a adicionar ao ArrayList.
     * @param nomeTema Nome do tema a criar.
     */
    public void criarTema(UC uc, String nomeTema) {
        uc.criarTema(nomeTema);
    }

    /**
     * Imprime os temas associados com uma dada instancia da classe UC.
     */
    public void printTema(UC uc) {
        uc.printTema();
    }

    /**
     * Adiciona um objeto da classe Publicacao ao ArrayList publicacoes presente na classe Tema.
     * @param uc Instancia da classe UC onde estão localizados os temas e publicacoes.
     * @param tema Instancia da classe Tema onde estão localizadas as publicacoes.
     * @param nPub Instancia da classe Publicacao a adicionar ao ArrayList.
     */
    public void criarPub(UC uc, Tema tema, Publicacao nPub) {
        uc.criarPub(tema, nPub);
    }

    /**
     * Retorna a instancia da classe Tema associada ao index na classe UC.
     * @param uc Instancia da classe UC.
     * @param index Indice do tema no ArrayList temas na classe UC.
     * @return A instancia da classe Tema associada ao indice.
     */
    public Tema getTemaFromIndex(UC uc, int index) {
        return uc.getTemaFromIndex(index);
    }

    /**
     * Imprime as publicaaoes marcadas como visiveis no ArrayList publicacoes presente na instância da classe Tema associada a UC.
     * @param uc Instancia da classe UC onde estão localizados os temas e publicacoes.
     * @param tema Instancia da classe Tema onde estão localizadas as publicacoes.
     */
    public void printPubsVisiveis(UC uc, Tema tema) {
        uc.printPubsVisiveis(tema);
    }

    /**
     * Imprime todas as publicaaoes no ArrayList publicacoes presente na instancia da classe Tema associada a UC.
     * @param uc Instancia da classe UC onde estão localizados os temas e publicacoes.
     * @param tema Instancia da classe Tema onde estão localizadas as publicacoes.
     */
    public void printPubs(UC uc, Tema tema) {
        uc.printPubs(tema);
    }

    /**
     * Retorna a instancia da classe Publicacao associada ao index na classe Tema.
     * @param uc Instancia da classe UC onde estão localizados os temas e publicacoes.
     * @param tema Instancia da classe Tema onde estao localizadas as publicacoes.
     * @param index Indice da publicacao no ArrayList publicacoes na classe Temas.
     * @return A instância da classe Publicacao associada ao indice.
     */
    public Publicacao getPubFromIndex(UC uc, Tema tema, int index) {
        return uc.getPubFromIndex(tema, index);
    }

    /**
     * Procura no ArrayList pessoas um objeto com nome igual ao introduzido.
     * @param nome Nome a procurar.
     * @return Retorna o objeto caso coincida com o nome, ou null caso nao encontre um objeto com o mesmo nome.
     */
    public Pessoa searchPessoa(String nome) {
        for (Pessoa p : pessoas) {
            if (p.getNome().equals(nome)) {
                return p;
            }
        }
        return null;
    }

    /**
     * Adiciona um objeto do tipo Mensagem ao ArrayList mensagens presente numa dada instancia da classe Pessoa.
     * @param msg Objeto do tipo Mensagem.
     * @param dest Nome do destinatario (Nome a procurar no ArrayList pessoas).
     */
    public void sendMsg(Mensagem msg, String dest) {
        Pessoa destP = searchPessoa(dest);
        if (destP == null) {
            System.out.println("A pessoa a quem quer enviar mensagem nao foi encontrada.");
        } else {
            destP.sendMsg(msg);
            System.out.println("Mensagem enviada para " + dest + ".");
        }
    }

    /**
     * Imprime todas as mensagens nao lidas presentes no ArrayList mensagens.
     * @param userAtual Instancia da classe Pessoa onde procurar as mensagens.
     * @param index Indice da mensagem a ler.
     * @return O objeto do tipo Mensagem escolhido.
     */
    public Mensagem getMsgFromIndex(Pessoa userAtual, int index) {
       return userAtual.getMsgFromIndex(index);
    }

    /**
     * Muda a visibilidade de uma publicacao
     * @param pub Objeto Publicacao.
     */
    public void mudarVisibilidade(Publicacao pub) {
        pub.setVisivel(!pub.isVisivel());
    }
}
