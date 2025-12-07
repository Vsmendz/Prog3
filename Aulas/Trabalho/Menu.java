package Aulas.Trabalho;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    public static void start(ArrayList<Funcionarios> lista_func){
        System.out.println("RH do hh:");
        boolean flag = true;
        Scanner entrada = new Scanner(System.in);
        while (flag) { 
            System.out.println("[0] Registrar funcionario");
            System.out.println("[1] Listar todos");
            System.out.println("[2] Remover funcionario");
            System.out.println("[3] Sair");
            switch (entrada.nextInt()) {
                case 0:
                    System.out.println("[0] Gerente\n[1] Vendedor\n[2] Estagiario");
                    add_func(entrada, lista_func);
                    break;
                case 1:
                    if(lista_func.isEmpty()) {
                        System.out.println("A lista de funcionarios esta vazia!!");
                        break;
                    }
                    for (Funcionarios func : lista_func) {
                    switch (func.getCargo()) {
                        case "Estagiario":
                            System.out.printf("Nome : %s\nCargo : %s\nID : %d\nSalario : %.2f\n\n",
                                    func.getNome(),func.getCargo(),func.getMatricula(),func.calcular_salario()
                            );
                            break;
                        case "Gerente":
                            System.out.printf("Nome : %s\nCargo : %s\nID : %d\nSalario : %.2f\nBonus %.2f\n\n",
                                    func.getNome(),func.getCargo(),func.getMatricula(),func.calcular_salario(),func.getUnique()
                            );
                            break;
                        default:
                            System.out.printf("Nome : %s\nCargo : %s\nID : %d\nSalario : %.2f\nComissao %.2f\n\n",
                                    func.getNome(),func.getCargo(),func.getMatricula(),func.calcular_salario(),func.getUnique()
                            );
                            break;
                        }
                    }
                    break;
                case 2:
                    System.out.printf("Digite o ID do funcionario a remover\n> ");
                    int id_to_remove = entrada.nextInt();
                    if (lista_func.removeIf(func -> func.getMatricula() == id_to_remove)){
                        System.out.println("Funcionario removido com sucesso!!!");
                    }else{
                        System.out.println("Funcionario nao encontrado!");
                    }
                    break;
                case 3:
                    entrada.nextLine();
                    System.out.println("Ate mais!!!!");    
                    flag = false;            
                break;
                default:
                    System.out.println("Opcao invalida!!");    
                   break;
            }
            
        }
    }
    private static void add_func(Scanner entrada,ArrayList<Funcionarios> ls){
        String nome;
        int id;
        double salario;
        double unique;
        switch (entrada.nextInt()) {
            case 0:
                entrada.nextLine();
                System.out.printf("Gerente\nDigite um nome \n> ");
                nome = entrada.nextLine();
                System.out.printf("Digite o ID \n> ");
                id = entrada.nextInt();
                System.out.printf("Digite o salario \n> ");
                salario = entrada.nextDouble();
                System.out.printf("Digite o bonus \n> ");
                unique = entrada.nextDouble();
                ls.add(new Gerente(nome,id,salario,unique));
                break;
            case 1:
                entrada.nextLine();
                System.out.printf("Vendedor\nDigite um nome \n> ");
                nome = entrada.nextLine();
                System.out.printf("Digite o ID \n> ");
                id = entrada.nextInt();
                System.out.printf("Digite o salario \n> ");
                salario = entrada.nextDouble();
                System.out.printf("Digite a comissao \n> ");
                unique = entrada.nextDouble();
                ls.add(new Vendedor(nome,id,salario,unique));
                break;
            case 2:
                entrada.nextLine();
                System.out.printf("Vendedor\nDigite um nome \n> ");
                nome = entrada.nextLine();
                System.out.printf("Digite o ID \n> ");
                id = entrada.nextInt();
                System.out.printf("Digite o salario \n> ");
                salario = entrada.nextDouble();
                ls.add(new Estagiario(nome,id,salario));
                break;
            default:
                System.out.println("Opcao invalida!!\n");
                break;
        }
    }
}
