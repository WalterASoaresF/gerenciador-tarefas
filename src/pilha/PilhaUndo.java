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
        NoPilha novo = new NoPilha(tarefa);
        novo.abaixo = topo;
        topo = novo;
        tamanho++;
    }

    public Tarefa buscar(int id) {
        NoPilha atual = topo;
        while (atual != null) {
            if (atual.dado.getId() == id) {
                return atual.dado;
            }
            atual = atual.abaixo;
        }
        return null;
    }

    public Tarefa remover() {
        if (topo == null) {
            return null;
        }
        Tarefa tarefa = topo.dado;
        topo = topo.abaixo;
        tamanho--;
        return tarefa;
    }

    public void listar() {
        if (topo == null) {
            System.out.println("Nenhuma tarefa excluida.");
            return;
        }
        System.out.println("--- Tarefas excluidas (topo -> base) ---");
        NoPilha atual = topo;
        while (atual != null) {
            System.out.println(atual.dado);
            atual = atual.abaixo;
        }
    }

    public boolean estaVazia() {
        return topo == null;
    }

    public int getTamanho() {
        return tamanho;
    }
}
