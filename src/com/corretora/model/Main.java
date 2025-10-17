package com.corretora.model;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayList<Imovel> listaImoveis = new ArrayList<>();
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);
        int opcao;


        Proprietario p1 = new Proprietario("João Silva", "99999-1111", "123.456.789-00");
        Proprietario p2 = new Proprietario("Maria Oliveira", "98888-2222", "987.654.321-00");
        Proprietario p3 = new Proprietario("Carlos Santos", "97777-3333", "111.222.333-44");

        Casa casa1 = new Casa("Rua das Flores, 101", 1, false, p1, 1500);
        Casa casa2 = new Casa("Rua dos Lírios, 345", 2, true, p2, 2000);

        Apartamento apt1 = new Apartamento("Av. Central, 286", 3, false, p3, 1800);
        Apartamento apt2 = new Apartamento("Av. Central, 950", 4, true, p1, 2200);

        listaImoveis.add(casa1);
        listaImoveis.add(casa2);
        listaImoveis.add(apt1);
        listaImoveis.add(apt2);


        do {
            System.out.println("\n--- Menu Corretora ---");
            System.out.println("1. Cadastrar Casa");
            System.out.println("2. Cadastrar Apartamento");
            System.out.println("3. Deletar Imóvel");
            System.out.println("4. Alugar Imóvel");
            System.out.println("5. Devolver Imóvel");
            System.out.println("6. Calcular Aluguel");
            System.out.println("7. Listar Todos os Imóveis");
            System.out.println("8. Listar Imóveis Disponíveis");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> cadastrarCasa(scanner, listaImoveis);
                case 2 -> cadastrarApartamento(scanner, listaImoveis);
                case 3 -> deletarImovel(scanner, listaImoveis);
                case 4 -> alugarImovel(scanner, listaImoveis);
                case 5 -> devolverImovel(scanner, listaImoveis);
                case 6 -> calcularAluguel(scanner, listaImoveis);
                case 7 -> listarImoveis(listaImoveis, false);
                case 8 -> listarImoveis(listaImoveis, true);
                case 0 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida!");
            }

        } while (opcao != 0);

        scanner.close();
    }


    private static void cadastrarCasa(Scanner sc, ArrayList<Imovel> lista) {
        System.out.print("Endereço: ");
        String endereco = sc.nextLine();
        System.out.print("Número: ");
        int numero = sc.nextInt();
        sc.nextLine();
        System.out.print("Valor mensal: ");
        int valor = sc.nextInt();
        sc.nextLine();
        System.out.print("Nome do proprietário: ");
        String nome = sc.nextLine();
        System.out.print("Telefone do proprietário: ");
        String telefone = sc.nextLine();
        System.out.print("CPF do proprietário: ");
        String cpf = sc.nextLine();

        Proprietario p = new Proprietario(nome, telefone, cpf);
        Casa casa = new Casa(endereco, numero, false, p, valor);
        lista.add(casa);

        System.out.println("Casa cadastrada com sucesso!");
    }

    private static void cadastrarApartamento(Scanner sc, ArrayList<Imovel> lista) {
        System.out.print("Endereço: ");
        String endereco = sc.nextLine();
        System.out.print("Número: ");
        int numero = sc.nextInt();
        sc.nextLine();
        System.out.print("Valor mensal: ");
        int valor = sc.nextInt();
        sc.nextLine();
        System.out.print("Nome do proprietário: ");
        String nome = sc.nextLine();
        System.out.print("Telefone do proprietário: ");
        String telefone = sc.nextLine();
        System.out.print("CPF do proprietário: ");
        String cpf = sc.nextLine();

        Proprietario p = new Proprietario(nome, telefone, cpf);
        Apartamento apt = new Apartamento(endereco, numero, false, p, valor);
        lista.add(apt);

        System.out.println("Apartamento cadastrado com sucesso!");
    }

    private static void deletarImovel(Scanner sc, ArrayList<Imovel> lista) {
        System.out.print("Informe o número do imóvel a deletar: ");
        int numero = sc.nextInt();
        sc.nextLine();

        Imovel encontrado = null;
        for (Imovel i : lista) {
            if (i.getNumero() == numero) {
                encontrado = i;
                break;
            }
        }

        if (encontrado != null) {
            lista.remove(encontrado);
            System.out.println("Imóvel removido com sucesso!");
        } else {
            System.out.println("Imóvel não encontrado.");
        }
    }

    private static void alugarImovel(Scanner sc, ArrayList<Imovel> lista) {
        System.out.print("Informe o número do imóvel a alugar: ");
        int numero = sc.nextInt();
        sc.nextLine();

        for (Imovel i : lista) {
            if (i.getNumero() == numero) {
                if (!i.isAlugado()) {
                    i.setAlugado(true);
                    System.out.println("Imóvel alugado com sucesso!");
                    System.out.println(i.estaAlugado());
                } else {
                    System.out.println("O imóvel já está alugado!");
                }
                return;
            }
        }
        System.out.println("Imóvel não encontrado.");
    }

    private static void devolverImovel(Scanner sc, ArrayList<Imovel> lista) {
        System.out.print("Informe o número do imóvel a devolver: ");
        int numero = sc.nextInt();
        sc.nextLine();

        for (Imovel i : lista) {
            if (i.getNumero() == numero) {
                if (i.isAlugado()) {
                    i.setAlugado(false);
                    System.out.println("Imóvel devolvido e disponível para aluguel!");
                    System.out.println(i.estaAlugado());
                } else {
                    System.out.println("O imóvel já está disponível!");
                }
                return;
            }
        }
        System.out.println("Imóvel não encontrado.");
    }

    private static void calcularAluguel(Scanner sc, ArrayList<Imovel> lista) {
        System.out.print("Informe o número do imóvel: ");
        int numero = sc.nextInt();
        sc.nextLine();
        System.out.print("Informe quantos meses: ");
        int meses = sc.nextInt();
        sc.nextLine();

        for (Imovel i : lista) {
            if (i.getNumero() == numero) {
                int total = i.calcularAluguel(meses);
                System.out.println("Valor total do aluguel: R$ " + total);
                return;
            }
        }
        System.out.println("Imóvel não encontrado.");
    }

    private static void listarImoveis(ArrayList<Imovel> lista, boolean apenasDisponiveis) {
        if (lista.isEmpty()) {
            System.out.println("Nenhum imóvel cadastrado.");
            return;
        }

        for (Imovel i : lista) {
            if (apenasDisponiveis && i.isAlugado()) continue;
            System.out.println("--------------------------------");
            System.out.println(i.estaAlugado());
            System.out.println("Endereço: " + i.getEndereco() + ", Número: " + i.getNumero());
            System.out.println(i.contatoProprietario());
        }
        System.out.println("--------------------------------");
    }
}
