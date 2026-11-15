package fila;

import modelo.Tarefa;

public class NoFila {
    private Tarefa tarefa;
    private NoFila proximo;

    public NoFila(Tarefa tarefa) {
        this.tarefa = tarefa;
        this.proximo = null;
    }

    public Tarefa getTarefa() {
        return tarefa;
    }

    public void setTarefa(Tarefa tarefa) {
        this.tarefa = tarefa;
    }

    public NoFila getProximo() {
        return proximo;
    }

    public void setProximo(NoFila proximo) {
        this.proximo = proximo;
    }
}