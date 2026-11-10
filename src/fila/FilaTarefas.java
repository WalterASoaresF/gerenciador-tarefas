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

    public void adicionar(Tarefa tarefa) {
        throw new UnsupportedOperationException("TODO: integrante 2");
    }

    public Tarefa buscar(int id) {
        throw new UnsupportedOperationException("TODO: integrante 2");
    }

    public Tarefa remover() {
        throw new UnsupportedOperationException("TODO: integrante 2");
    }

    public Tarefa removerPorId(int id) {
        throw new UnsupportedOperationException("TODO: integrante 2");
    }

    public void listar() {
        throw new UnsupportedOperationException("TODO: integrante 2");
    }

    public boolean estaVazia() {
        return inicio == null;
    }

    public int getTamanho() {
        return tamanho;
    }
}
