import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Criando um funcionário
        Funcionario funcionario1 = new Funcionario("João", "Desenvolvedor", 5000.0);

        // Criando um projeto
        Projeto projeto1 = new Projeto("Projeto X", LocalDate.of(2024, 12, 31), funcionario1);

        // Validando o prazo do projeto
        if (projeto1.validarPrazo() == false) {
            System.out.println("O prazo do projeto não é válido.");
        }

        // Adicionando um funcionário ao projeto
        Funcionario funcionario2 = new Funcionario("Maria", "Gerente");
        projeto1.adicionarFuncionario(funcionario2);

        // Removendo o funcionário do projeto
        projeto1.removerFuncionario();

        // Criando uma lista de projetos
        List<Projeto> projetos = new ArrayList<Projeto>();
        projetos.add(projeto1);

        // Criando um menu de opções
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Criar novo projeto");
            System.out.println("2. Adicionar funcionário a um projeto");
            System.out.println("3. Remover funcionário de um projeto");
            System.out.println("4. Listar projetos");
            System.out.println("5. Excluir projeto");
            System.out.println("6. Sair");
            System.out.print("Digite a opção desejada: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            switch (opcao) {
                case 1:
                    // Criar novo projeto
                    System.out.print("Digite o nome do projeto: ");
                    String nomeProjeto = scanner.nextLine();
                    System.out.print("Digite o prazo do projeto (AAAA-MM-DD): ");
                    LocalDate prazoProjeto = LocalDate.parse(scanner.nextLine());
                    System.out.print("Digite o nome do responsável: ");
                    String nomeResponsavel = scanner.nextLine();
                    System.out.print("Digite o cargo do responsável: ");
                    String cargoResponsavel = scanner.nextLine();
                    System.out.print("Digite o salário do responsável: ");
                    double salarioResponsavel = scanner.nextDouble();
                    scanner.nextLine(); // Consumir a quebra de linha

                    Funcionario responsavel = new Funcionario(nomeResponsavel, cargoResponsavel, salarioResponsavel);
                    Projeto novoProjeto = new Projeto(nomeProjeto, prazoProjeto, responsavel);
                    projetos.add(novoProjeto);
                    System.out.println("Projeto criado com sucesso!");
                    break;

                case 2:
                    // Adicionar funcionário a um projeto
                    if (projetos.isEmpty()) {
                        System.out.println("Não existem projetos cadastrados.");
                        break;
                    }
                    listarProjetos(projetos);
                    System.out.print("Digite o número do projeto para adicionar o funcionário: ");
                    int numeroProjeto = scanner.nextInt(); // Declare numeroProjeto outside the if block
                    scanner.nextLine(); // Consumir a quebra de linha

                    if (numeroProjeto >= 1 && numeroProjeto <= projetos.size()) {
                        Projeto projeto = projetos.get(numeroProjeto - 1);
                        System.out.print("Digite o nome do funcionário: ");
                        String nomeFuncionario = scanner.nextLine();
                        System.out.print("Digite o cargo do funcionário: ");
                        String cargoFuncionario = scanner.nextLine();
                        System.out.print("Digite o salário do funcionário: ");
                        double salarioFuncionario = scanner.nextDouble();
                        scanner.nextLine(); // Consumir a quebra de linha

                        Funcionario novoFuncionario = new Funcionario(nomeFuncionario, cargoFuncionario, salarioFuncionario);
                        projeto.adicionarFuncionario(novoFuncionario);
                        System.out.println("Funcionário adicionado ao projeto com sucesso!");
                    } else {
                        System.out.println("Número de projeto inválido.");
                    }
                    break;

                case 3:
                    // Remover funcionário de um projeto
                    if (projetos.isEmpty()) {
                        System.out.println("Não existem projetos cadastrados.");
                        break;
                    }
                    listarProjetos(projetos);
                    System.out.print("Digite o número do projeto para remover o funcionário: ");
                    numeroProjeto = scanner.nextInt(); // Reuse numeroProjeto variable
                    scanner.nextLine(); // Consumir a quebra de linha

                    if (numeroProjeto >= 1 && numeroProjeto <= projetos.size()) {
                        Projeto projeto = projetos.get(numeroProjeto - 1);
                        projeto.removerFuncionario();
                        System.out.println("Funcionário removido do projeto com sucesso!");
                    } else {
                        System.out.println("Número de projeto inválido.");
                    }
                    break;

                case 4:
                    // Listar projetos
                    if (projetos.isEmpty()) {
                        System.out.println("Não existem projetos cadastrados.");
                        break;
                    }
                    listarProjetos(projetos);
                    break;
                
                case 5:
                ExcluirProjeto(projetos);
                break;

                case 6:
                    System.out.println("Saindo do programa...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 6);

        scanner.close();
    }

    private static void listarProjetos(List<Projeto> projetos) {
        if (projetos.isEmpty()) {
            System.out.println("Não existem projetos cadastrados.\n");
            return;
        }

        System.out.println("\nProjetos cadastrados:");
        for (int i = 0; i < projetos.size(); i++) {
            Projeto projeto = projetos.get(i);
            System.out.println((i + 1) + ". " + projeto.getNome() + " - Prazo: " + projeto.getPrazo());
            if (projeto.getResponsavel() != null) {
                System.out.println("   Responsável: " + projeto.getResponsavel().getNome() + " (" + projeto.getResponsavel().getCargo() + ")");
            }
        }
    }
    private static void ExcluirProjeto(List<Projeto> projetos) {
        Scanner scanner = new Scanner(System.in);
    
        if (projetos.isEmpty()) {
            System.out.println("Não existem projetos criados.\n");
            return;
        }
    
        System.out.print("Digite o nome do projeto que deseja excluir: \n");
        for (int i = 0; i < projetos.size(); i++) {
            Projeto projeto = projetos.get(i);
            System.out.println((i + 1) + ". " + projeto.getNome() + " - Prazo: " + projeto.getPrazo());
            if (projeto.getResponsavel() != null) {
                System.out.println("   Responsável: " + projeto.getResponsavel().getNome() + " (" + projeto.getResponsavel().getCargo() + ")");
            }
        }
        String nomeProjeto = scanner.nextLine();
    
        boolean projetoEncontrado = false;
        for (int i = 0; i < projetos.size(); i++) {
            if (projetos.get(i).getNome().equals(nomeProjeto)) {
                projetos.remove(i);
                System.out.println("Projeto " + nomeProjeto + " excluído com sucesso.");
                projetoEncontrado = true;
                break;
            }
        }
    
        if (!projetoEncontrado) {
            System.out.println("Projeto não encontrado.");
        }
    }    
}
    
