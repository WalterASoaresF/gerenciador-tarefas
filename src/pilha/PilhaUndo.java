package pilha;

import modelo.Tarefa;

public class PilhaUndo {
    private NoPilha topo;
    private int tamanho;

    public PilhaUndo() {
        this.topo = null;
        this.tamanho = 0;
    }

    public void empilhar(Tarefa tarefa) {
        throw new UnsupportedOperationException("TODO: integrante 3");
    }

    public Tarefa buscar(int id) {
        throw new UnsupportedOperationException("TODO: integrante 3");
    }

    public Tarefa remover() {
        throw new UnsupportedOperationException("TODO: integrante 3");
    }

    public void listar() {
        throw new UnsupportedOperationException("TODO: integrante 3");
    }

    public boolean estaVazia() {
        return topo == null;
    }

    public int getTamanho() {
        return tamanho;
    }
}
