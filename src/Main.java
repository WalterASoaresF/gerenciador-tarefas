import abb.ArvoreFuncionarios;
import fila.FilaTarefas;
import modelo.Funcionario;
import modelo.Tarefa;
import pilha.PilhaUndo;

import java.util.Scanner;

public class Main {
    private static final Scanner entrada = new Scanner(System.in);
    private static final ArvoreFuncionarios funcionarios = new ArvoreFuncionarios();
    private static final FilaTarefas backlog = new FilaTarefas();
    private static final PilhaUndo undo = new PilhaUndo();

    public static void main(String[] args) {
        int opcao;
        do {
            exibirMenu();
            opcao = lerInt("Opcao: ");
            executar(opcao);
        } while (opcao != 0);
        System.out.println("Encerrado.");
    }

    private static void exibirMenu() {
        System.out.println();
        System.out.println("===== GERENCIADOR DE TAREFAS CORPORATIVAS =====");
        System.out.println("1  - Cadastrar funcionario");
        System.out.println("2  - Buscar funcionario por ID");
        System.out.println("3  - Remover funcionario");
        System.out.println("4  - Listar funcionarios (percursos)");
        System.out.println("5  - Criar tarefa no backlog");
        System.out.println("6  - Listar backlog");
        System.out.println("7  - Atender proxima tarefa");
        System.out.println("8  - Excluir tarefa do backlog");
        System.out.println("9  - Desfazer exclusao (Undo)");
        System.out.println("10 - Listar tarefas excluidas");
        System.out.println("0  - Sair");
    }

    private static void executar(int opcao) {
        switch (opcao) {
            case 1:
                cadastrarFuncionario();
                break;
            case 2:
                buscarFuncionario();
                break;
            case 3:
                removerFuncionario();
                break;
            case 4:
                funcionarios.percursos();
                break;
            case 5:
                criarTarefa();
                break;
            case 6:
                backlog.listar();
                break;
            case 7:
                atenderProximaTarefa();
                break;
            case 8:
                excluirTarefa();
                break;
            case 9:
                desfazerExclusao();
                break;
            case 10:
                undo.listar();
                break;
            case 0:
                break;
            default:
                System.out.println("Opcao invalida.");
        }
    }

    private static void cadastrarFuncionario() {
        int id = lerInt("ID: ");
        String nome = lerTexto("Nome: ");
        String cargo = lerTexto("Cargo: ");
        if (funcionarios.inserir(new Funcionario(id, nome, cargo))) {
            System.out.println("Funcionario cadastrado.");
        } else {
            System.out.println("ID ja existente.");
        }
    }

    private static void buscarFuncionario() {
        int id = lerInt("ID: ");
        Funcionario f = funcionarios.buscar(id);
        if (f == null) {
            System.out.println("Funcionario nao encontrado.");
        } else {
            System.out.println(f);
        }
    }

    private static void removerFuncionario() {
        int id = lerInt("ID: ");
        if (funcionarios.remover(id)) {
            System.out.println("Funcionario removido.");
        } else {
            System.out.println("Funcionario nao encontrado.");
        }
    }

    private static void criarTarefa() {
        int idResponsavel = lerInt("ID do funcionario responsavel: ");
        if (funcionarios.buscar(idResponsavel) == null) {
            System.out.println("Funcionario nao encontrado. Cadastre-o primeiro.");
            return;
        }
        int id = lerInt("ID da tarefa: ");
        if (backlog.buscar(id) != null || undo.buscar(id) != null) {
            System.out.println("ID de tarefa ja existente.");
            return;
        }
        String titulo = lerTexto("Titulo: ");
        backlog.adicionar(new Tarefa(id, titulo, idResponsavel));
        System.out.println("Tarefa adicionada ao backlog.");
    }

    private static void atenderProximaTarefa() {
        if (backlog.estaVazia()) {
            System.out.println("Backlog vazio.");
            return;
        }
        Tarefa t = backlog.remover();
        t.setStatus("CONCLUIDA");
        System.out.println("Tarefa atendida: " + t);
    }

    private static void excluirTarefa() {
        int id = lerInt("ID da tarefa: ");
        Tarefa t = backlog.removerPorId(id);
        if (t == null) {
            System.out.println("Tarefa nao encontrada no backlog.");
            return;
        }
        t.setStatus("EXCLUIDA");
        undo.empilhar(t);
        System.out.println("Tarefa excluida e guardada para desfazer.");
    }

    private static void desfazerExclusao() {
        if (undo.estaVazia()) {
            System.out.println("Nada para desfazer.");
            return;
        }
        Tarefa t = undo.remover();
        t.setStatus("PENDENTE");
        backlog.adicionar(t);
        System.out.println("Tarefa restaurada: " + t);
    }

    private static int lerInt(String mensagem) {
        while (true) {
            System.out.print(mensagem);
            String linha = entrada.nextLine().trim();
            try {
                return Integer.parseInt(linha);
            } catch (NumberFormatException e) {
                System.out.println("Digite um numero inteiro.");
            }
        }
    }

    private static String lerTexto(String mensagem) {
        System.out.print(mensagem);
        return entrada.nextLine().trim();
    }
}
