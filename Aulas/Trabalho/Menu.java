package Aulas.Trabalho;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    public static void start(ArrayList<Funcionarios> lista_func) {
        Scanner entrada = new Scanner(System.in);
        boolean flag = true;

        while (flag) {
            System.out.println("\n=================================");
            System.out.println("        SISTEMA DE RH - HH        ");
            System.out.println("=================================");
            System.out.println("[0] Registrar funcionario");
            System.out.println("[1] Listar funcionarios");
            System.out.println("[2] Remover funcionario");
            System.out.println("[3] Sair");
            System.out.print(">> ");

            switch (entrada.nextInt()) {

                case 0:
                    System.out.println("\n--------- NOVO FUNCIONARIO ---------");
                    System.out.println("[0] Gerente");
                    System.out.println("[1] Vendedor");
                    System.out.println("[2] Estagiario");
                    System.out.println("[3] Diretor");
                    System.out.print(">> ");
                    add_func(entrada, lista_func);
                    break;

                case 1:
                    System.out.println("\n--------- LISTA DE FUNCIONARIOS ---------");

                    if (lista_func.isEmpty()) {
                        System.out.println("Nenhum funcionario cadastrado!");
                        break;
                    }

                    for (Funcionarios func : lista_func) {
                        System.out.println("---------------------------------");
                        System.out.printf("Nome     : %s%n", func.getNome());
                        System.out.printf("Cargo    : %s%n", func.getCargo());
                        System.out.printf("ID       : %d%n", func.getMatricula());
                        System.out.printf("Salario  : %.2f%n", func.calcular_salario());

                        if (!func.getCargo().equals("Estagiario")) {
                            System.out.printf(
                                "%s : %.2f%n",
                                func.getCargo().equals("Gerente") ? "Bonus" : "Comissao",
                                func.getUnique()
                            );
                        }
                    }
                    System.out.println("---------------------------------");
                    break;

                case 2:
                    System.out.println("\n--------- REMOVER FUNCIONARIO ---------");
                    System.out.print("Digite o ID do funcionario: ");
                    int id_to_remove = entrada.nextInt();

                    if (lista_func.removeIf(func -> func.getMatricula() == id_to_remove)) {
                        System.out.println("Funcionario removido com sucesso!");
                    } else {
                        System.out.println("Funcionario nao encontrado!");
                    }
                    break;

                case 3:
                    System.out.println("\nEncerrando o sistema...");
                    System.out.println("Ate mais!");
                    flag = false;
                    break;

                default:
                    System.out.println("Opcao invalida!");
            }
        }
    }

    private static void add_func(Scanner entrada, ArrayList<Funcionarios> ls) {
        String nome;
        int id;
        double salario;
        double unique;

        switch (entrada.nextInt()) {

            case 0:
                entrada.nextLine();
                System.out.println("\n--- Cadastro de Gerente ---");
                System.out.print("Nome: ");
                nome = entrada.nextLine();
                System.out.print("ID: ");
                id = entrada.nextInt();
                System.out.print("Salario: ");
                salario = entrada.nextDouble();
                System.out.print("Bonus: ");
                unique = entrada.nextDouble();
                ls.add(new Gerente(nome, id, salario, unique));
                System.out.println("Gerente cadastrado!");
                break;

            case 1:
                entrada.nextLine();
                System.out.println("\n--- Cadastro de Vendedor ---");
                System.out.print("Nome: ");
                nome = entrada.nextLine();
                System.out.print("ID: ");
                id = entrada.nextInt();
                System.out.print("Salario: ");
                salario = entrada.nextDouble();
                System.out.print("Comissao: ");
                unique = entrada.nextDouble();
                ls.add(new Vendedor(nome, id, salario, unique));
                System.out.println("Vendedor cadastrado!");
                break;

            case 2:
                entrada.nextLine();
                System.out.println("\n--- Cadastro de Estagiario ---");
                System.out.print("Nome: ");
                nome = entrada.nextLine();
                System.out.print("ID: ");
                id = entrada.nextInt();
                System.out.print("Salario: ");
                salario = entrada.nextDouble();
                ls.add(new Estagiario(nome, id, salario));
                System.out.println("Estagiario cadastrado!");
                break;
            case 3:
                entrada.nextLine();
                System.out.println("\n--- Cadastro de Diretor ---");
                System.out.print("Nome: ");
                nome = entrada.nextLine();
                System.out.print("ID: ");
                id = entrada.nextInt();
                System.out.print("Salario: ");
                salario = entrada.nextDouble();
                ls.add(new Estagiario(nome, id, salario));
                System.out.println("Diretor cadastrado!");
                break;
            default:
                System.out.println("Opcao invalida!");
        }
    }
}
