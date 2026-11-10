package fila;

import modelo.Tarefa;

public class NoFila {
    Tarefa dado;
    NoFila proximo;

    public NoFila(Tarefa dado) {
        this.dado = dado;
        this.proximo = null;
    }
}
