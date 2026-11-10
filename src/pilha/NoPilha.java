package pilha;

import modelo.Tarefa;

public class NoPilha {
    Tarefa dado;
    NoPilha abaixo;

    public NoPilha(Tarefa dado) {
        this.dado = dado;
        this.abaixo = null;
    }
}
