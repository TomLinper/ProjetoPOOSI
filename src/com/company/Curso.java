package com.company;

import java.util.ArrayList;

public class Curso {
    private ArrayList<Pessoa> pessoas;
    private ArrayList<UC> uCurriculares;
    private String nomeCurso;
    private int numParticipantes;


    public Curso(String nomeCurso, int numParticipantes) {
        this.nomeCurso = nomeCurso;
        this.numParticipantes = numParticipantes;
        this.uCurriculares = new ArrayList<>(numParticipantes);
        this.pessoas = new ArrayList<>(numParticipantes);
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public int getNumParticipantes() {
        return numParticipantes;
    }

    /**
     * Método usado para criar uma nova instância da classe Aluno e adiciona-la ao array alunos.
     * @param nPessoa Instância da classe pessoa a adicionar ao ArrayList pessoas.
     */
    public void addPessoa(Pessoa nPessoa) {
        pessoas.add(nPessoa);
    }

    /**
     * Verifica se o numero de aluno já existe.
     * @param numAluno Número de aluno.
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
     * Verifica se as credenciais de login estão corretas.
     * @param nome Nome a confirmar.
     * @param pass Password a confirmar.
     * @param tipo Tipo de Pessoa.
     * @return true se as credenciais forem confirmadas e false se não forem.
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
     * Procura o nome e a password no ArrayList pessoas e retorna a instância associada, caso encontre
     * @param nome Nome de utilizador.
     * @param pass Password do utilizador.
     * @return A instância da classe Pessoa associados aos dados, caso encontre correspondência. Caso não encontre, retorna null.
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
     * Adiciona uma instância da classe UC ao array uCurriculares.
     * @param nomeUC Nome da unidade curricular.
     */
    public void addUC(String nomeUC) {
        uCurriculares.add(new UC(nomeUC));
    }

    /**
     * Adiciona uma unidade curricular ao ArrayList uCurriculares presente na instância da classe Pessoa.
     * @param prof Instância da classe pessoa.
     * @param index Índice da unidade curricular no ArrayList uCurriculares.
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
     * Retorna a instância da classe UC associada ao index na classe Professor.
     * @param userAtual Instância da classe Pessoa.
     * @param index Índice da unidade curricular no ArrayList uCurriculares na classe Professor.
     * @return A instância da classe UC associada ao indice.
     */
    public UC getUCProfFromIndex(Pessoa userAtual, int index) {
        return userAtual.getUCFromIndex(index);
    }

    /**
     * Cria e adiciona uma instância da classe Tema ao ArrayList temas presente na classe UC.
     * @param uc Instância da unidade curricular.
     * @param nomeTema Nome do tema a criar.
     */
    public void criarTema(UC uc, String nomeTema) {
        uc.criarTema(nomeTema);
    }

    /**
     * Imprime os temas associados com uma dada instância da classe UC.
     */
    public void printTema(UC uc) {
        uc.printTema();
    }

    /**
     * Adiciona uma instância da classe Publicacao ao ArrayList publicacoes presente na classe Tema.
     * @param uc Instância da classe UC onde estão localizados os temas e publicacoes.
     * @param tema Instância da classe Tema onde estão localizadas as publicacoes.
     * @param nPub Instância da classe Publicacao a adicionar ao ArrayList.
     */
    public void criarPub(UC uc, Tema tema, Publicacao nPub) {
        uc.criarPub(tema, nPub);
    }

    /**
     * Retorna a instância da classe Tema associada ao index na classe UC.
     * @param uc Instância da classe UC.
     * @param index Índice do tema no ArrayList temas na classe UC.
     * @return A instância da classe Tema associada ao indice.
     */
    public Tema getTemaFromIndex(UC uc, int index) {
        return uc.getTemaFromIndex(index);
    }

    /**
     * Imprime as publicaaoes marcadas como visiveis no ArrayList publicacoes presente na instância da classe Tema associada à UC.
     * @param uc Instância da classe UC onde estão localizados os temas e publicacoes.
     * @param tema Instância da classe Tema onde estão localizadas as publicacoes.
     */
    public void printPubsVisiveis(UC uc, Tema tema) {
        uc.printPubsVisiveis(tema);
    }

    /**
     * Imprime todas as publicaaoes no ArrayList publicacoes presente na instância da classe Tema associada à UC.
     * @param uc Instância da classe UC onde estão localizados os temas e publicacoes.
     * @param tema Instância da classe Tema onde estão localizadas as publicacoes.
     */
    public void printPubs(UC uc, Tema tema) {
        uc.printPubs(tema);
    }

    /**
     *
     * @param uc Instância da classe UC onde estão localizados os temas e publicacoes.
     * @param tema Instância da classe Tema onde estão localizadas as publicacoes.
     * @param index Índice da publicacao no ArrayList publicacoes na classe Temas.
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
     *
     * @param msg
     * @param dest
     */
    public void sendMsg(Mensagem msg, String dest) {
        Pessoa destP = searchPessoa(dest);
        if (destP == null) {
            System.out.println("A pessoa a quem quer enviar mensagem não foi encontrada.");
        } else {
            destP.sendMsg(msg);
        }
    }

    public Mensagem getMsgNLidas(Pessoa userAtual, int index) {
       return userAtual.getMsgNLidas(index);
    }
}
