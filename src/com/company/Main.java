package com.company;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.time.LocalDate;

//TODO Ver detalhes da pessoa
//TODO Tabs nas classes

/**
 * Classe onde ocorre a interacao entre o utilizador e o sistema.
 *
 * @author Carlos Mendes nº42762 / Ivo Gomes nº43573 / Tomas Pereira nº43133
 * @version 08/05/2021
 */
public class Main
{
    //Variaveis de classe.
    private static Scanner in = new Scanner(System.in);
    private static Curso engInf = new Curso(100);
    private static Pessoa userAtual = null;
    private static UC uc = null;
    private static Tema tema = null;
    private static Publicacao pub = null;

    public static void main(String[] args)
    {
        loginPage();
    }

    /**
     * Pagina inicial onde e possivel registar e fazer login.
     */
    private static void loginPage()
    {
        System.out.println("-----Login-----\n1. Fazer login como aluno\n2. Fazer login como professor\n3. Registar utilizador\n4. Registar nova UC\n5. Terminar");
        int opcao = in.nextInt();
        in.nextLine();

        while (opcao != -1) {
            switch (opcao) {
                case 1:
                    login("com.company.Aluno");
                    opcao = 0;
                    break;
                case 2:
                    login("com.company.Professor");
                    opcao = 0;
                    break;
                case 3:
                    registar();
                    opcao = 0;
                    break;
                case 4:
                    registarUC();
                    opcao = 0;
                    break;
                case 5:
                    opcao = -1;
                    break;
                default:
                    System.out.println("1. Fazer login como professor\n2. Fazer login como aluno\n3. Registar utlizador\n4. Registar nova UC\n5. Terminar");
                    opcao = in.nextInt();
                    in.nextLine();
            }
        }
    }

    /**
     * Menu onde irá ocorrer o registo dos utilizadores.
     */
    private static void registar()
    {
        System.out.println("Escolha a opcao com que se identifica:\n1. Aluno\n2. Professor\n3. Voltar");
        int opcao = in.nextInt();
        in.nextLine();

        if (opcao == 1 || opcao == 2) {
            //Variaveis para a super-classe.
            System.out.println("Qual o seu nome?");
            String nome = in.nextLine();

            System.out.println("Qual a sua palavra-passe?");
            String pass = in.nextLine();

            System.out.println("Qual o seu contacto telefonico?");
            int contacto = in.nextInt();
            in.nextLine();

            System.out.println("Qual o seu email?");
            String mail = in.nextLine();


            //Variaveis para as sub-classes (1. Aluno / 2. Professor).
            if (opcao == 1) {
                //Criar e verificar número de aluno.
                int numAluno = (int) (Math.random() * 100000);
                while (!engInf.checkNum(numAluno)) {
                    numAluno = (int) (Math.random() * 100000);
                }

                System.out.println("O seu numero de aluno e " + numAluno + ".");

                //Adicionar aluno ao ArrayList pessoas.
                engInf.addPessoa(new Aluno(nome, mail, contacto, pass, numAluno));
                System.out.println("Aluno registado com sucesso!");


            } else {
                //Adicionar professor ao ArrayList pessoas.
                Pessoa novaP = new Professor(nome, mail, contacto, pass);
                engInf.addPessoa(novaP);

                //Associar unidades curriculares ao professor.
                System.out.println("Quais as suas unidades curriculares?");
                engInf.printUCs();
                System.out.println("0. Terminar");
                int uc = in.nextInt();
                in.nextLine();

                while (uc != 0) {
                    engInf.addUCProf(novaP, uc);

                    System.out.println("Quais as suas unidades curriculares?");
                    engInf.printUCs();
                    System.out.println("0. Terminar");
                    uc = in.nextInt();
                    in.nextLine();
                }

                System.out.println("Professor registado com sucesso!");

            }
            loginPage();
        } else if (opcao == 3) {
            loginPage();
        } else {
            System.out.println("Opcao inexistente. Por favor escolha uma das opcoes abaixo.");
            registar();
        }
    } //fim registar

    /**
     * Pagina do login.
     * @param tipo Tipo de pessoa.
     */
    private static void login(String tipo)
    {
        //Obtencao dos dados de login.
        System.out.println("Insira o seu nome...");
        String nome = in.nextLine();

        System.out.println("Insira a sua password...");
        String pass = in.nextLine();

        //Confirmacao dos dados e redirecionamento para o menu correspondente ao tipo de pessoa.
        if (engInf.checkLogin(nome, pass, tipo)) {
            System.out.println("Bem-vindo " + nome);
            userAtual = engInf.getUserAtual(nome, pass); //Obtencao do user atual.

            if (tipo.equals("com.company.Aluno")) {
                menuAluno();
            } else {
                menuProf();
            }

        } else {
            System.out.println("Credenciais incorretas. Por favor tente novamente.");
            loginPage();
        }
    }//fim login

    /**
     * Pagina de registo de unidades curriculares.
     */
    public static void registarUC()
    {
        System.out.println("Qual o nome da unidade curricular a criar?");
        String nomeUC = in.nextLine();

        engInf.addUC(nomeUC);
    }//fim registarUC

    /**
     * Menu por onde o aluno tem acesso à plataforma.
     */
    public static void menuAluno()
    {
        System.out.println("1. Ver uma publicacao \n2. Mandar mensagem a um Professor\n3. Ver mensagens\n4. Voltar");
        int opcao = in.nextInt();
        in.nextLine();

        while (opcao != -1) {
            switch (opcao) {
                case 1:
                    //Escolha da publicacao.
                    uc = escolhaUC();
                    tema = escolhaTema(uc);
                    pub = escolhaPub(uc, tema);

                    //Visualização do ficheiro.
                    if (pub.getClass().getName().equals("com.company.Anuncio")) {
                        System.out.println("-------" + pub.getTitulo() + "-------");
                        System.out.println(pub.getCorpo());
                        System.out.println("Data: " + pub.getData() + "\nAutor: " + pub.getAutor());
                    } else if (pub.getClass().getName().equals("com.company.Material")){
                        System.out.println("-------" + pub.getNome() + "-------");
                        System.out.println("\nTipo: " + pub.getExtensao() + "\nData: " + pub.getData() + "\nAutor: " + pub.getAutor());
                    } else {
                        int corretas = 0;
                        System.out.println("-------" + pub.getTitulo() + "-------");

                        //Loop para processar perguntas.
                        for (int i = 0; i < pub.getnPerguntas(); i++) {
                            //Print da pergunta e escolha da resposta.
                            System.out.println("Pergunta nº " + (i+1) + "/" + pub.getnPerguntas());
                            pub.printPergunta(i);
                            pub.printOpcoes(i);
                            System.out.println("Escolha o número da opcao correta...");

                            int escolha = in.nextInt();
                            in.nextLine();

                            //Verificacao da resposta.
                            if (escolha == pub.getRespCorreta(i)) {
                                corretas++;
                                System.out.println("A sua resposta esta correta!");
                            } else {
                                System.out.println("A sua resposta esta incorreta.");
                            }
                        }
                        //Resultado final.
                        System.out.println("Acertou " + corretas + "/" + pub.getnPerguntas() + " perguntas. Nota: " + (20*corretas)/ pub.getnPerguntas() + "/20.");
                    }

                    menuAluno();

                    opcao = 0;
                    break;
                case 2:
                    //Obtencao de dados.
                    System.out.println("Qual o nome da pessoa a enviar a mensagem?");
                    String dest = in.nextLine();

                    System.out.println("Qual o assunto da mensagem?");
                    String assunto = in.nextLine();

                    System.out.println("Qual a mensagem?");
                    String corpo = in.nextLine();

                    LocalDate today = LocalDate.now();

                    //Criacao de um objeto do tipo Mensagem e sua adicao ao ArrayList mensagens.
                    engInf.sendMsg(new Mensagem(userAtual.getNome(), assunto, corpo, today), dest);
                    System.out.println("Mensagem enviada para " + dest + ".");

                    menuAluno();

                    opcao = 0;
                    break;
                case 3:
                    sendMsg();

                    menuAluno();

                    opcao = 0;
                    break;
                case 4:
                    opcao = -1;
                    loginPage();
                    break;
            }//fim switch.
        }//fim while.

    }//fim menuAluno.

    /**
     * Menu por onde o professor tem acesso à plataforma.
     */
    public static void menuProf()
    {

        System.out.println("1. Criar nova publicacao\n2. Criar novo tema\n3. Alterar visibilidade das publicacoes\n4. Ver uma publicacao\n5. Enviar mensagens\n6. Ver mensagens\n7. Voltar");
        int opcao = in.nextInt();
        in.nextLine();

        while (opcao != -1) {
            switch (opcao) {
                case 1:
                    Publicacao nPub = null;
                    boolean visibilidade;

                    //Escolha do tipo de publicacao.
                    System.out.println("Qual o tipo da publicacao?\n1. Material\n2. Anuncio\n3. Quizz");
                    int aux = in.nextInt();
                    in.nextLine();

                    LocalDate today = LocalDate.now();

                    //Definir visibilidade da publicacao.
                    System.out.println("Deseja que o ficheiro fique visível logo após publicação?\n1. Sim\n2. Não");
                    int aux1 = 0;
                    try {
                        aux1 = in.nextInt();
                        in.nextLine();
                    }
                    catch(InputMismatchException inputMismatchException){
                        System.out.println("Escolha uma opcao valida");
                        menuProf();
                    }
                    if (aux1 == 1) {
                        visibilidade = true;
                    } else {
                        visibilidade = false;
                    }

                    //Escolha do tema.
                    uc = escolhaUC();
                    tema = escolhaTema(uc);

                    //Criação da publicacao.
                    if (aux == 1) {
                        System.out.println("Qual o nome do ficheiro?");
                        String nome = in.nextLine();

                        System.out.println("Qual a extensao do ficheiro?");
                        String ext = in.nextLine();

                        nPub = new Material(userAtual.getNome(), today, ext, nome, visibilidade);
                    } else if (aux == 2) {
                        System.out.println("Qual o titulo do anuncio?");
                        String titulo = in.nextLine();

                        System.out.println("Qual o corpo do anuncio?");
                        String corpo = in.nextLine();

                        nPub = new Anuncio(userAtual.getNome(), today, visibilidade, titulo, corpo);
                    } else if (aux == 3) {
                        System.out.println("Qual o titulo do quizz?");
                        String titulo = in.nextLine();

                        System.out.println("Quantas perguntas irá ter o quizz?");
                        int nPerguntas = in.nextInt();
                        in.nextLine();

                        nPub = new Quizz(userAtual.getNome(), today, visibilidade, titulo, nPerguntas);
                    } else {
                        System.out.println("Por favor insira o valor correspondente ao ficheiro que quer criar.");
                        menuProf();
                    }

                    engInf.criarPub(uc, tema, nPub);

                    //Criacao do quizz.
                    if (aux == 3) {
                        //Loop para processar perguntas.
                        for (int i = 0; i < nPub.getnPerguntas(); i++) {
                            System.out.println("Qual a " + (i+1) + "º pergunta?");
                            String pergunta = in.nextLine();

                            System.out.println("Quantas opcoes de resposta tem a " + (i+1) + "º pergunta?");
                            int nOpcoes = in.nextInt();
                            in.nextLine();

                            ArrayList<String> opcoes = new ArrayList<>(nOpcoes);

                            //Loop para processar opcoes.
                            for (int k = 0; k < nOpcoes; k++) {
                                System.out.println("Qual a " + (k+1) + " opcao de resposta?");
                                opcoes.add(in.nextLine());
                            }

                            System.out.println("Qual o indice da opcao correta?");
                            int respCorreta = in.nextInt();
                            in.nextLine();

                            nPub.addPergunta(new Pergunta(pergunta, respCorreta, opcoes));
                        }
                    }

                    menuProf();

                    opcao = 0;
                    break;
                case 2:

                    //Obtencao de dados.
                    System.out.println("A que disciplina quer adicionar o tema?");
                    engInf.printUCProf(userAtual);
                    System.out.println("0. Voltar");
                    aux = in.nextInt();
                    in.nextLine();

                    if (aux == 0) {
                        menuProf();
                    }

                    System.out.println("Qual o nome do tema?");
                    String nomeTema = in.nextLine();

                    try {
                        //Criacao do tema.
                        engInf.criarTema(engInf.getUCProfFromIndex(userAtual, aux), nomeTema);
                    } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                        System.out.println("Input error. Por favor insira uma das opcoes acima.");
                        menuProf();
                    }

                    opcao = 0;
                    break;
                case 3:
                    //Escolha da publicacao.
                    uc = escolhaUC();
                    tema = escolhaTema(uc);
                    pub = escolhaPub(uc, tema);

                    //Alteração da visibilidade do ficheiro.
                    if (pub.isVisivel()) {
                        System.out.println("Este ficheiro encontra-se visivel. Deseja alterar a sua visibilidade?\n1. Sim\n2. Não");
                    } else {
                        System.out.println("Este ficheiro encontra-se invisivel. Deseja alterar a sua visibilidade?\n1. Sim\n2. Não");
                    }
                    aux = 0;
                    try {
                    		aux = in.nextInt();
                    		in.nextLine();
                    }
                    	catch(InputMismatchException inputmissmatchexception) {
                    		System.out.println("Escolha inválida...");
                    		menuProf();
                    	}

                    if (aux == 1) {
                        engInf.mudarVisibilidade(pub);
                    } else if (aux > 2){
                        System.out.println("Input error. Por favor insira uma das opcoes acima.");
                        menuProf();
                    }

                    opcao = 0;
                    break;
                case 4:
                    //Escolha da publicacao.
                    uc = escolhaUC();
                    tema = escolhaTema(uc);
                    pub = escolhaPub(uc, tema);

                    //Visualização do ficheiro.
                    if (pub.getClass().getName().equals("com.company.Anuncio")) {
                        System.out.println("-------" + pub.getTitulo() + "-------");
                        System.out.println(pub.getCorpo());
                        System.out.println("Data: " + pub.getData() + "\nAutor: " + pub.getAutor());
                    } else if (pub.getClass().getName().equals("com.company.Material")){
                        System.out.println("-------" + pub.getNome() + "-------");
                        System.out.println("\nTipo: " + pub.getExtensao() + "\nData: " + pub.getData() + "\nAutor: " + pub.getAutor());
                    } else {
                        int corretas = 0;
                        System.out.println("-------" + pub.getTitulo() + "-------");
                        //Loop para processar perguntas.
                        for (int i = 0; i < pub.getnPerguntas(); i++) {
                            //Print da pergunta e escolha da resposta.
                            System.out.println("Pergunta nº " + (i+1) + "/" + pub.getnPerguntas());
                            pub.printPergunta(i);
                            pub.printOpcoes(i);
                            System.out.println("Escolha o indice da opcao correta...");
                            
                            int escolha = 0;
                            
                            try{
                            	escolha = in.nextInt();
                            	in.nextLine();
                            }
                            catch(InputMismatchException inputmissmatchexception) {
                            	System.out.println("Escolha inválida...");
                            	menuProf();
                            }
                            //Verificacao da resposta.
                            if (escolha == pub.getRespCorreta(i)) {
                                corretas++;
                                System.out.println("A sua resposta esta correta!");
                            } else {
                                System.out.println("A sua resposta esta incorreta.");
                            }
                        }
                        //Resultado final.
                        System.out.println("Acertou " + corretas + "/" + pub.getnPerguntas() + " perguntas. Nota: " + (20*corretas)/ pub.getnPerguntas() + "/20.");
                    }

                    opcao = 0;
                    break;
                case 5:
                    //Obtencao de dados.
                	System.out.println("Qual o nome da pessoa a enviar a mensagem?");
                	String dest = in.nextLine();

                    System.out.println("Qual o assunto da mensagem?");
                	String assunto = in.nextLine();

                	System.out.println("Qual a mensagem?");
                	String corpo = in.nextLine();
                	
                	today = LocalDate.now();

                    //Criacao de um objeto do tipo Mensagem e sua adicao ao ArrayList mensagens.
                	engInf.sendMsg(new Mensagem(userAtual.getNome(), assunto, corpo, today), dest);

                    menuProf();

                	opcao = 0;
                	break;
                case 6:
                    sendMsg();
                    menuProf();

                    opcao = 0;
                    break;
                case 7:
                    opcao = -1;
                    loginPage();
                    break;
                default:
                    System.out.println("1. Criar nova publicacao\n2. Criar novo tema\n3. Alterar visibilidade das publicacoes\n4. Ver uma publicacao\n5. Enviar mensagens\n6. Ver mensagens\n7. Voltar");
                    opcao = in.nextInt();
                    in.nextLine();
            }// fim switch
        }// fim while

    } //fim menuProf

    /**
     * Imprime uma lista de UCs e permite selecionar uma.
     * @return A instancia da classe UC escolhida.
     */
    public static UC escolhaUC()
    {
        int indexUC = 0;
        UC UC = null;

        if (userAtual.getClass().getName().equals("com.company.Professor")) {

            System.out.println("Escolha a localizacao do ficheiro:");
            engInf.printUCProf(userAtual);

            indexUC= 0;
            try{
            	System.out.println("0. Voltar ao menu anterior");
            	indexUC = in.nextInt();
                in.nextLine();
            }
           catch(InputMismatchException inputmissmatchexception) {
        	   System.out.println("Não foi possível concretizar esta ação.");
           }

            if (indexUC == 0) {
                menuProf();
            }

            try {
                UC = engInf.getUCProfFromIndex(userAtual, indexUC);
            } catch (IndexOutOfBoundsException indexOutOfBoundsException){
                System.out.println("Input error. Por favor insira uma das opcoes acima.");
                menuProf();
            }

        } else {

            System.out.println("Escolha a localizacao do ficheiro:");
            engInf.printUCs();

            System.out.println("0. Voltar ao menu anterior");
            indexUC = in.nextInt();
            in.nextLine();

            if (indexUC == 0) {
                menuProf();
            }

            try {
                UC = engInf.getUCFromIndex(indexUC);
            } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                System.out.println("Input error. Por favor insira uma das opcoes acima.");
                menuProf();
            }

        }

        return UC;


    }//fim escolhaUC

    /**
     * Imprime uma lista de Temas e permite selecionar um.
     * @param uc Objeto da classe UC onde estara o Tema.
     * @return A instancia da classe Tema escolhida.
     */
    public static Tema escolhaTema(UC uc)
    {
        engInf.printTema(uc);
        System.out.println("0. Voltar ao menu anterior");
        int indexTema = in.nextInt();
        in.nextLine();

        if (indexTema == 0) {
            escolhaUC();
            escolhaTema(uc);
        }

        return engInf.getTemaFromIndex(uc, indexTema);
    }//fim escolhaTema

    /**
     * Imprime uma lista de publicacaoes visiveis e permite selecionar uma.
     * @param uc Objeto da classe UC onde estara o Tema.
     * @param tema Objeto da classe Tema onde estara a Publicacao.
     * @return A instancia da classe Tema escolhida.
     */
    public static Publicacao escolhaPubVisiveis(UC uc, Tema tema)
    {
        engInf.printPubsVisiveis(uc, tema);
        System.out.println("0. Voltar ao menu anterior");
        int indexPub = in.nextInt();
        in.nextLine();

        if (indexPub == 0) {
            escolhaTema(uc);
            escolhaPubVisiveis(uc, tema);
        }

        return engInf.getPubFromIndex(uc, tema, indexPub);
    }//fim escolhaPubVisiveis

    /**
     * Imprime uma lista de todas as publicacaoes e permite selecionar uma.
     * @param uc Objeto da classe UC onde estara o Tema.
     * @param tema Objeto da classe Tema onde estara a Publicacao.
     * @return A instancia da classe Tema escolhida.
     */
    public static Publicacao escolhaPub(UC uc, Tema tema)
    {
        engInf.printPubs(uc, tema);
        System.out.println("0. Voltar ao menu anterior");
        int indexPub = in.nextInt();
        in.nextLine();

        if (indexPub == 0) {
            escolhaTema(uc);
            escolhaPub(uc, tema);
        }

        return engInf.getPubFromIndex(uc, tema, indexPub);
    }//fim escolhaPub

    public static void sendMsg() {
        //Impressao do assunto e autor das mensagens nao visualizadas no ArrayList mensagens.
        System.out.println("----CAIXA DE ENTRADA----");
        System.out.println("Escolha a mensagem:");
        userAtual.printMsg();
        System.out.println("0. Voltar");

        //Escolha da mensagem a visualizar.
        int index = in.nextInt();
        in.nextLine();

        if (index != 0){
            try {
                //Obtencao e impressao da mensagem.
                Mensagem msg = engInf.getMsgFromIndex(userAtual, index);
                msg.setLida(true);
                System.out.println(msg.toString());
            } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                System.out.println("Input error. Por favor insira uma das opcoes acima.");
            }
        }
    }
}//fim Main