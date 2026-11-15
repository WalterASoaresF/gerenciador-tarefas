package fila;

import modelo.Tarefa;

public class FilaTarefas {
    private NoFila inicio;
    private NoFila fim;
    private int tamanho;

    public FilaTarefas() {
        this.inicio = null;
        this.fim = null;
        this.tamanho = 0;
    }

    public boolean adicionar(Tarefa tarefa) {
        if (tarefa == null) {
            System.out.println("Tarefa inválida.");
            return false;
        }

        if (buscar(tarefa.getId()) != null) {
            System.out.println("Já existe uma tarefa pendente com o ID " + tarefa.getId() + ".");
            return false;
        }

        NoFila novo = new NoFila(tarefa);

        if (estaVazia()) {
            inicio = novo;
        } else {
            fim.setProximo(novo);
        }
        fim = novo;
        tamanho++;
        return true;
    }

    public Tarefa buscar(int id) {
        NoFila atual = inicio;
        while (atual != null) {
            if (atual.getTarefa().getId() == id) {
                return atual.getTarefa();
            }
            atual = atual.getProximo();
        }
        return null;
    }

    public Tarefa remover() {
        if (estaVazia()) {
            return null;
        }
        Tarefa removida = inicio.getTarefa();
        inicio = inicio.getProximo();
        tamanho--;

        if (inicio == null) {
            fim = null;
        }
        return removida;
    }

    public Tarefa removerPorId(int id) {
        if (estaVazia()) {
            return null;
        }

        if (inicio.getTarefa().getId() == id) {
            return remover();
        }

        NoFila anterior = inicio;
        NoFila atual = inicio.getProximo();
        while (atual != null) {
            if (atual.getTarefa().getId() == id) {

                anterior.setProximo(atual.getProximo());

                if (atual == fim) {
                    fim = anterior;
                }
                tamanho--;
                return atual.getTarefa();
            }
            anterior = atual;
            atual = atual.getProximo();
        }
        return null;
    }

    public void listar() {
        if (estaVazia()) {
            System.out.println("Backlog vazio: nenhuma tarefa pendente.");
            return;
        }
        System.out.println("=== Backlog de tarefas pendentes (" + tamanho + ") ===");
        NoFila atual = inicio;
        int posicao = 1;
        while (atual != null) {
            System.out.println(posicao + "º -> " + atual.getTarefa());
            atual = atual.getProximo();
            posicao++;
        }
    }

    public boolean estaVazia() {
        return inicio == null;
    }

    public int getTamanho() {
        return tamanho;
    }
}