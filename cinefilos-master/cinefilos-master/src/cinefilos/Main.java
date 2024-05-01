package cinefilos;

import cinefilos.bancoDeDados.*;
import java.io.*;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int escolhaClienteLoginOuCadastro;
        int escolhaClienteOpcoes;
        int escolhaGerente;
        int escolhaAtualizarExibicoes;
        int escolhaAtualizarLanchonete;
        int quantidade;

        int escolhaInicial = menuInicial(sc);
        Fachada fachada = new Fachada();
        Programacao programacao = fachada.criarProgramacao();
        Lanchonete lanchonete = fachada.criarLanchonete();
        BancoDeClientes clientes = fachada.criarBancoClientes();
        BancoDeGerentes gerentes = fachada.criarBancoGerente();
        BancoDeFuncionarios funcionarios = fachada.criarBancoFuncionario();
        Cliente cliente;

        try {
            List<String> dadosGerentes = gerentes.recuperaDadosDeGerentes();
            for (String dados : dadosGerentes) {
                System.out.println(dados);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        gerentes.recuperaDadosDeGerentes();
        gerentes.recuperaTextoDeArquivo();







        while (escolhaInicial != 3) {
            switch (escolhaInicial) {

                case 1:
                    // MODO CLIENTE
                    do {
                        escolhaClienteLoginOuCadastro = menuClienteLoginOuCadastro(sc);

                        switch (escolhaClienteLoginOuCadastro) {

                            case 1:
                                System.out.println("Digite seu nome:");
                                sc.nextLine();
                                String nome = sc.nextLine();

                                System.out.println("Digite seu e-mail:");
                                String email = sc.nextLine();

                                System.out.println("Digite sua senha:");
                                String senha = sc.nextLine();

                                cliente = fachada.cadastroCliente(nome, email, senha);
                                clientes.adicionarCliente(cliente);

                                System.out.println(cliente);

                                break;

                            case 2:
                                System.out.println("Digite seu e-mail:");
                                sc.nextLine();
                                String emailLogin = sc.nextLine();

                                System.out.println("Digite sua senha:");
                                String senhaLogin = sc.nextLine();

                                cliente = fachada.loginCliente(clientes, emailLogin, senhaLogin);

                                if (cliente == null) {
                                    System.out.println("Cliente não encontrado.");
                                }

                                System.out.println(cliente);


                                do {
                                    escolhaClienteOpcoes = menuClienteOpcoes(sc);

                                    switch (escolhaClienteOpcoes) {
                                        case 1:
                                            System.out.println(programacao.getProgramacao());
                                            System.out.println("Digite o titulo filme que quer adicionar no carrinho:");
                                            sc.nextLine();
                                            String titulo = sc.nextLine();
                                            System.out.println("Digite o número da sala:");
                                            int numero = sc.nextInt();

                                            System.out.println("Digite a quantidade que você quer comprar:");
                                            quantidade = sc.nextInt();

                                            programacao.buscarExibicao(titulo, numero);

                                            break;

                                        case 2:
                                            System.out.println("Digite o nome do item que quer adicionar no carrinho:");
                                            sc.nextLine();
                                            nome = sc.nextLine();
                                            System.out.println("Digite a quantidade que você quer comprar:");
                                            quantidade = sc.nextInt();

                                            Item item = lanchonete.buscaItemNaLanchonete(nome);
                                            cliente.getCarrinho().add(item);

                                            break;
                                        case 3:
                                            assert cliente != null;
                                            fachada.fecharPedido(cliente);

                                            break;

                                        case 4:
                                            cliente.getCarrinho().clear();
                                            System.out.println("Pedido cancelado com sucesso.");
                                            escolhaClienteOpcoes = 5;
                                            break;

                                    }
                                } while (escolhaClienteOpcoes != 5);
                                break;
                        }
                    } while (escolhaClienteLoginOuCadastro != 3);
                    break;

                case 2:

                    String senhaEsperada;
                    System.out.println("Digite a senha:");
                    sc.nextLine();
                    senhaEsperada = sc.nextLine();
                    gerentes.buscarGerente(senhaEsperada);

                    escolhaGerente = 5;
                    Gerente gerente = fachada.loginGerente(gerentes, senhaEsperada);
                    System.out.println(gerente);


                    do {
                        escolhaGerente = menuGerente(sc);

                        switch (escolhaGerente) {

                            case 1:

                                do {
                                    escolhaAtualizarExibicoes = menuEscolhaAtualizarExibicoes(sc);

                                    switch (escolhaAtualizarExibicoes) {
                                        case 1:
                                            System.out.println(programacao.getProgramacao());
                                            System.out.println("Digite o número correspondente à exibição que quer remover:");
                                            int numero = sc.nextInt();
                                            programacao.removerExibicao(numero);

                                            break;

                                        case 2:

                                            System.out.println("Digite a quantidade de poltronas da sala: ");
                                            int quantidadePoltronas = sc.nextInt();
                                            sc.nextLine();
                                            System.out.println("Digite qual é o tipo da sala: Básica, 3D ou VIP?");
                                            String tipo = sc.nextLine();
                                            System.out.println("Digite o número da sala:");
                                            numero = sc.nextInt();

                                            System.out.println("Digite o título do filme:");
                                            sc.nextLine();
                                            String titulo = sc.nextLine();
                                            System.out.println("Digite o horário de exibição do filme:");
                                            String horario = sc.nextLine();
                                            System.out.println("Adicionar exibição");
                                            Sala sala = new Sala(quantidadePoltronas, tipo, numero);
                                            Filme filme = new Filme(titulo, horario);
                                            Exibicao exibicao = new Exibicao(sala, filme);
                                            programacao.adicionarExibicao(exibicao);
                                            break;
                                    }

                                } while (escolhaAtualizarExibicoes != 3);
                                break;


                            case 2:

                                do {
                                    escolhaAtualizarLanchonete = menuAtualizarLanchonete(sc);
                                    switch (escolhaAtualizarLanchonete) {
                                        case 1:
                                            System.out.println("Digite o nome do item que quer atualizar:");
                                            sc.nextLine();
                                            String nome = sc.nextLine();

                                            System.out.println("Digite o novo preço do item:");
                                            double preco = sc.nextDouble();


                                            Item item = lanchonete.buscaItemNaLanchonete(nome);
                                            item.setPreco(preco);

                                            break;
                                        case 2:
                                            System.out.println(lanchonete.getLanchonete());
                                            System.out.println("Digite o número que corresponde ao item que quer remover:");
                                            int numero = sc.nextInt();
                                            lanchonete.removerItem(numero);

                                            break;
                                        case 3:
                                            System.out.println(lanchonete.getLanchonete());
                                            System.out.println("Digite o nome do item que quer adicionar:");
                                            sc.nextLine();
                                            nome = sc.nextLine();

                                            System.out.println("Digite o preço do item:");
                                            preco = sc.nextDouble();

                                            System.out.println("Digite a quantidade de item que quer adicionar:");
                                            quantidade = sc.nextInt();

                                            item = new Item(nome, preco, quantidade);
                                            item.setPreco(item.getPreco() * quantidade);
                                            lanchonete.adicionaItem(item);


                                            break;
                                    }


                                } while (escolhaAtualizarLanchonete != 4);
                                break;


                            case 3:

                                System.out.println("Digite o nome do cliente que quer buscar:");
                                sc.nextLine();
                                String nome = sc.nextLine();

                                cliente = fachada.buscarClientePeloNome(nome);
                                fachada.gerarRelatorio(cliente);
                                cliente.getCarrinhoDoRelatorio().clear();
                                break;
                        }
                    } while (escolhaGerente != 4);
            }
            escolhaInicial = menuInicial(sc);
        }
        sc.close();
    }

    private static int  menuAtualizarLanchonete(Scanner sc) {
        int escolhaAtualizarLanchonete;
        System.out.println("""
                ____________________
                [1] ATUALIZAR PREÇO
                [2] REMOVER ITEM
                [3] ADICIONAR ITEM
                [4] VOLTAR
                ____________________
                --> Digite sua escolha:
                """);
        if (!sc.hasNextInt()) {
            int tentativas = 0;
            while (!sc.hasNextInt()) {
                System.err.println("A escolha só pode ser um número inteiro! Tente novamente:");
                sc.next();

                if (tentativas > 1) {
                    System.err.println("*LIMITE DE TENTATIVAS ALCANÇADA*.");
                    return 3;
                }
                tentativas++;

            }
        }
        return sc.nextInt();
    }

    private static int menuEscolhaAtualizarExibicoes(Scanner sc) {
        System.out.println("""
                _______________________
                [1] REMOVER EXIBIÇÃO
                [2] ADICIONAR EXIBIÇÃO
                [3] VOLTAR
                _______________________
                --> Digite sua escolha:
                """);
        if (!sc.hasNextInt()) {
            int tentativas = 0;
            while (!sc.hasNextInt()) {
                System.err.println("A escolha só pode ser um número inteiro! Tente novamente:");
                sc.next();

                if (tentativas > 1) {
                    System.err.println("*LIMITE DE TENTATIVAS ALCANÇADA*.");
                    return 3;
                }
                tentativas++;

            }
        }
        return sc.nextInt();
    }

    private static int menuGerente(Scanner sc) {
        System.out.println("""
                ___________________________________
                [1] ATUALIZAR EXIBIÇÕES.
                [2] ATUALIZAR ITENS LANCHONETE
                [3] GERAR RELATÓRIO
                [4] SAIR DO SISTEMA
                ____________________________________
                --> Digite o número de sua escolha:
                """);
        if (!sc.hasNextInt()) {
            int tentativas = 0;
            while (!sc.hasNextInt()) {
                System.err.println("A escolha só pode ser um número inteiro! Tente novamente:");
                sc.next();

                if (tentativas > 1) {
                    System.err.println("*LIMITE DE TENTATIVAS ALCANÇADA*.");
                    return 3;
                }
                tentativas++;

            }
        }
        return sc.nextInt();
    }

    private static int menuClienteOpcoes(Scanner sc) {
        System.out.println("""
                ____________________________________
                [1] EXIBIÇÃO.
                [2] LANCHONETE.
                [3] FECHAR PEDIDO.
                [4] CANCELAR COMPRA
                [5] SAIR DO SISTEMA
                ____________________________________
                --> Digite o número de sua escolha:
                """);
        if (!sc.hasNextInt()) {
            int tentativas = 0;
            while (!sc.hasNextInt()) {
                System.err.println("A escolha só pode ser um número inteiro! Tente novamente:");
                sc.next();

                if (tentativas > 1) {
                    System.err.println("*LIMITE DE TENTATIVAS ALCANÇADA*.");
                    return 3;
                }
                tentativas++;

            }
        }
        return sc.nextInt();
    }

    private static int menuClienteLoginOuCadastro(Scanner sc) {
        System.out.println("""
                _______________________
                [1] FAZER CADASTRO.
                [2] FAZER LOGIN.
                [3] VOLTAR.
                _______________________
                --> Digite o número de sua escolha:
                """);
        if (!sc.hasNextInt()) {
            int tentativas = 0;
            while (!sc.hasNextInt()) {
                System.err.println("A escolha só pode ser um número inteiro! Tente novamente:");
                sc.next();

                if (tentativas > 1) {
                    System.err.println("*LIMITE DE TENTATIVAS ALCANÇADA*.");
                    return 3;
                }
                tentativas++;

            }
        }
        return sc.nextInt();


    }


    private static int menuInicial(Scanner sc) {
        System.out.println("""
                ----------------
                [1] MODO CLIENTE
                [2] MODO GERENTE
                [3] SAIR
                ----------------
                """);
        System.out.println("Digitar sua escolha:");

        if (!sc.hasNextInt()) {
            int tentativas = 0;
            while (!sc.hasNextInt()) {
                System.err.println("A escolha só pode ser um número inteiro! Tente novamente:");
                sc.next();

                if (tentativas > 1) {
                    System.err.println("*LIMITE DE TENTATIVAS ALCANÇADA*.");
                    return 3;
                }
                tentativas++;

            }
        }

        return sc.nextInt();
    }
}

