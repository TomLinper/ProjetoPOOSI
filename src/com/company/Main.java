package com.company;

import java.util.Scanner;
import java.time.LocalDate;

//TODO VerificaÃ§Ãµes e exceptions
//TODO Tabs nas classes

public class Main {
    private static Scanner in = new Scanner(System.in);
    private static Curso engInf = new Curso("Engenharia Informatica", 100);
    private static Pessoa userAtual = null;

    public static void main(String[] args) {
        loginPage();
    }

    private static void loginPage() {
        System.out.println("1. Fazer login como aluno\n2. Fazer login como professor\n3. Registar utilizador\n4. Registar nova UC\n5. Terminar");
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
    private static void registar() {
        int eI = 0;

        System.out.println("Escolha a opÃ§Ã£o com que se identifica:\n1. Aluno\n2. Professor\n3. Voltar");
        int opcao = in.nextInt();
        in.nextLine();

        if (opcao == 1 || opcao == 2) {
            System.out.println("Qual o seu nome?");
            String nome = in.nextLine();

            System.out.println("Qual a sua palavra-passe?");
            String pass = in.nextLine();

            System.out.println("Qual o seu contacto telefonico?");
            int contacto = in.nextInt();
            in.nextLine();

            System.out.println("Qual o seu email?");
            String mail = in.nextLine();

            if (opcao == 1) {
                //Criar e verificar número de aluno.
                int numAluno = (int) (Math.random() * 100000);
                while (!engInf.checkNum(numAluno)) {
                        numAluno = (int) (Math.random() * 100000);
                }

                System.out.println("O seu numero de aluno e " + numAluno + ".");

                //Adicionar professor ao ArrayList pessoas.
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
    }

    /**
     * Pagina do login.
     * @param tipo Tipo de pessoa. Aluno = 1 / Professor = 2
     */
    private static void login(String tipo) {
        System.out.println("Insira o seu nome...");
        String nome = in.nextLine();

        System.out.println("Insira a sua password...");
        String pass = in.nextLine();

        if (engInf.checkLogin(nome, pass, tipo)) {
            System.out.println("Bem-vindo " + nome);
            userAtual = engInf.getUserAtual(nome, pass);

            if (tipo.equals("com.company.Aluno")) {
                menuAluno();
            } else {
                menuProf();
            }

        } else {
            System.out.println("Credenciais incorretas. Por favor tente novamente.");
            loginPage();
        }
    }// fim login


    public static void registarUC() {
        System.out.println("Qual o nome da unidade curricular a criar?");
        String nomeUC = in.nextLine();

        engInf.addUC(nomeUC);
    }// fim registarUC

    /**
     * Menu por onde o aluno tem acesso à plataforma.
     */
    public static void menuAluno() {
        System.out.println("1. Ver uma publicacao \n2. Mandar mensagem a um Professor");
        int opcao = in.nextInt();

        while (opcao != -1) {
            switch (opcao) {
                case 1:
                    //Escolha da publicacao
                    UC uc = escolhaUC();
                    Tema tema = escolhaTema(uc);
                    Publicacao pub = escolhaPubVisiveis(uc, tema);

                    //Visualização do ficheiro.
                    //TODO Perguntar sobre isto na classe Curso.
                    //TODO Adicionar Material.
                    if (pub.getClass().getName().equals("com.company.Anuncio")) {
                        System.out.println("-------" + pub.getTitulo() + "-------");
                        System.out.println(pub.getCorpo());
                    }

                    opcao = 0;
                    break;
                case 2:

            }
        }
    }

    /**
     * Menu por onde o professor tem acesso à plataforma.
     */
    public static void menuProf() {

        System.out.println("1. Criar nova publicacao\n2. Criar novo tema\n3. Alterar visibilidade das publicacoes\n4. Ver uma publicacao\n5. Enviar mensagem\n6. Voltar");
        int opcao = in.nextInt();
        in.nextLine();

        while (opcao != -1) {
            switch (opcao) {
                case 1:
                    Publicacao nPub = null;
                    boolean visibilidade;

                    //Escolha do tipo de publicacao.
                    System.out.println("1. Material\n2. Anuncio");
                    int aux = in.nextInt();
                    in.nextLine();

                    LocalDate today = LocalDate.now();

                    //Definir visibilidade da publicacao.
                    System.out.println("Deseja que o ficheiro fique visível logo após publicação?\n1. Sim\n2. Não");
                    int aux1 = in.nextInt();
                    in.nextLine();

                    if (aux1 == 1) {
                        visibilidade = true;
                    } else {
                        visibilidade = false;
                    }

                    //Escolha da unidade curricular.
                    UC uc = escolhaUC();

                    //Escolha do tema.
                    Tema tema = escolhaTema(uc);

                    //Criação da publicacao.
                    if (aux == 1) {
                        System.out.println("Qual o nome do ficheiro?");
                        String nome = in.nextLine();

                        System.out.println("Qual a extensao do ficheiro?");
                        String ext = in.nextLine();

                        nPub = new Material(userAtual.getNome(), today, ext, nome, visibilidade);
                    } else {
                        System.out.println("Qual o título do anuncio?");
                        String titulo = in.nextLine();

                        System.out.println("Qual o corpo do anuncio?");
                        String corpo = in.nextLine();

                        nPub = new Anuncio(userAtual.getNome(), today, visibilidade, titulo, corpo);
                    }

                    engInf.criarPub(uc, tema, nPub);

                    opcao = 0;
                    break;
                case 2:
                    //Escolha da unidade curricular.
                    System.out.println("A que disciplina quer adicionar o tema?");
                    engInf.printUCProf(userAtual);
                    aux = in.nextInt();
                    in.nextLine();

                    //Escolha do tema.
                    System.out.println("Qual o nome do tema?");
                    String nomeTema = in.nextLine();

                    //Criacao do tema.
                    engInf.criarTema(engInf.getUCProfFromIndex(userAtual, aux), nomeTema);

                    opcao = 0;
                    break;
                case 3:
                    //Escolha da publicacao.
                    uc = escolhaUC();
                    tema = escolhaTema(uc);
                    Publicacao pub = escolhaPub(uc, tema);

                    //Alteração da visibilidade do ficheiro.
                    if (pub.isVisibilidade()) {
                        System.out.println("Este ficheiro encontra-se visível. Deseja alterar a sua visibilidade?\n1. Sim\n2. Não");
                    } else {
                        System.out.println("Este ficheiro encontra-se invisível. Deseja alterar a sua visibilidade?\n1. Sim\n2. Não");
                    }
                    aux = in.nextInt();
                    in.nextLine();

                    //TODO Perguntar sobre isto na classe Curso.
                    if (aux == 1) {
                        pub.setVisibilidade(!pub.isVisibilidade());
                    } else {
                        menuProf();
                    }

                    opcao = 0;
                    break;
                case 4:
                    //Escolha da publicacao.
                    uc = escolhaUC();
                    tema = escolhaTema(uc);
                    pub = escolhaPubVisiveis(uc, tema);

                    //Visualização do ficheiro.
                    //TODO Perguntar sobre isto na classe Curso.
                    //TODO Adicionar Material.
                    if (pub.getClass().getName().equals("com.company.Anuncio")) {
                        System.out.println("-------" + pub.getTitulo() + "-------");
                        System.out.println(pub.getCorpo());
                    }

                    opcao = 0;
                    break;
                case 5:
                	System.out.println("Qual o nome da pessoa a enviar a mensagem?");
                	String dest = in.nextLine();

                    System.out.println("Qual o assunto da mensagem?");
                	String assunto = in.nextLine();

                	System.out.println("Qual a mensagem?");
                	String corpo = in.nextLine();
                	
                	today = LocalDate.now();
                	
                	engInf.sendMsg(new Mensagem(userAtual.getNome(), assunto, corpo, today), dest);

                	opcao = 0;
                	break;
                case 6:
                    opcao = -1;
                    break;
                default:
                    System.out.println("1. Criar nova publicacao\n2. Criar novo tema\n3. Alterar visibilidade das publicacoes\n4. Ver uma publicacao\n5. Enviar mensagem\n6. Voltar");
                    opcao = in.nextInt();
                    in.nextLine();
            }// fim switch
        }// fim while

    } //fim menuProf

    public static UC escolhaUC() {
        System.out.println("Escolha a localização do ficheiro:");
        engInf.printUCProf(userAtual);
        System.out.println("0. Voltar ao menu anterior");
        int indexUC = in.nextInt();
        in.nextLine();

        if (indexUC == 0) {
            menuProf();
        }

        return engInf.getUCProfFromIndex(userAtual, indexUC);
    }

    public static Tema escolhaTema(UC uc) {
        engInf.printTema(uc);
        System.out.println("0. Voltar ao menu anterior");
        int indexTema = in.nextInt();
        in.nextLine();

        if (indexTema == 0) {
            escolhaUC();
            escolhaTema(uc);
        }

        return engInf.getTemaFromIndex(uc, indexTema);
    }

    public static Publicacao escolhaPubVisiveis(UC uc, Tema tema) {
        engInf.printPubsVisiveis(uc, tema);
        System.out.println("0. Voltar ao menu anterior");
        int indexPub = in.nextInt();
        in.nextLine();

        if (indexPub == 0) {
            escolhaTema(uc);
            escolhaPubVisiveis(uc, tema);
        }

        return engInf.getPubFromIndex(uc, tema, indexPub);
    }

    public static Publicacao escolhaPub(UC uc, Tema tema) {
        engInf.printPubs(uc, tema);
        System.out.println("0. Voltar ao menu anterior");
        int indexPub = in.nextInt();
        in.nextLine();

        if (indexPub == 0) {
            escolhaTema(uc);
            escolhaPub(uc, tema);
        }

        return engInf.getPubFromIndex(uc, tema, indexPub);
    }

}//fim Main