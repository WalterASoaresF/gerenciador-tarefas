package abb;

import modelo.Funcionario;

public class ArvoreFuncionarios {
    private NoABB raiz;

    public ArvoreFuncionarios() {
        this.raiz = null;
    }

    public boolean inserir(Funcionario funcionario) {
        if (funcionario == null) {
            return false;
        }
        if (raiz == null) {
            raiz = new NoABB(funcionario);
            return true;
        }
        return inserirRec(raiz, funcionario);
    }

    private boolean inserirRec(NoABB atual, Funcionario funcionario) {
        if (funcionario.getId() == atual.dado.getId()) {
            return false;
        }
        if (funcionario.getId() < atual.dado.getId()) {
            if (atual.esquerda == null) {
                atual.esquerda = new NoABB(funcionario);
                return true;
            }
            return inserirRec(atual.esquerda, funcionario);
        }
        if (atual.direita == null) {
            atual.direita = new NoABB(funcionario);
            return true;
        }
        return inserirRec(atual.direita, funcionario);
    }

    public Funcionario buscar(int id) {
        NoABB encontrado = buscarNo(raiz, id);
        if (encontrado == null) {
            return null;
        }
        return encontrado.dado;
    }

    private NoABB buscarNo(NoABB atual, int id) {
        if (atual == null) {
            return null;
        }
        if (id == atual.dado.getId()) {
            return atual;
        }
        if (id < atual.dado.getId()) {
            return buscarNo(atual.esquerda, id);
        }
        return buscarNo(atual.direita, id);
    }

    public boolean remover(int id) {
        if (buscarNo(raiz, id) == null) {
            return false;
        }
        raiz = removerRec(raiz, id);
        return true;
    }

    private NoABB removerRec(NoABB atual, int id) {
        if (atual == null) {
            return null;
        }
        if (id < atual.dado.getId()) {
            atual.esquerda = removerRec(atual.esquerda, id);
            return atual;
        }
        if (id > atual.dado.getId()) {
            atual.direita = removerRec(atual.direita, id);
            return atual;
        }
        if (atual.esquerda == null && atual.direita == null) {
            return null;
        }
        if (atual.esquerda == null) {
            return atual.direita;
        }
        if (atual.direita == null) {
            return atual.esquerda;
        }
        NoABB sucessor = minimo(atual.direita);
        atual.dado = sucessor.dado;
        atual.direita = removerRec(atual.direita, sucessor.dado.getId());
        return atual;
    }

    private NoABB minimo(NoABB atual) {
        while (atual.esquerda != null) {
            atual = atual.esquerda;
        }
        return atual;
    }

    public void percursos() {
        if (estaVazia()) {
            System.out.println("Nenhum funcionario cadastrado.");
            return;
        }
        System.out.println("--- Em ordem ---");
        emOrdem();
        System.out.println("--- Pre-ordem ---");
        preOrdem();
        System.out.println("--- Pos-ordem ---");
        posOrdem();
    }

    public void emOrdem() {
        emOrdemRec(raiz);
    }

    private void emOrdemRec(NoABB atual) {
        if (atual != null) {
            emOrdemRec(atual.esquerda);
            System.out.println(atual.dado);
            emOrdemRec(atual.direita);
        }
    }

    public void preOrdem() {
        preOrdemRec(raiz);
    }

    private void preOrdemRec(NoABB atual) {
        if (atual != null) {
            System.out.println(atual.dado);
            preOrdemRec(atual.esquerda);
            preOrdemRec(atual.direita);
        }
    }

    public void posOrdem() {
        posOrdemRec(raiz);
    }

    private void posOrdemRec(NoABB atual) {
        if (atual != null) {
            posOrdemRec(atual.esquerda);
            posOrdemRec(atual.direita);
            System.out.println(atual.dado);
        }
    }

    public boolean estaVazia() {
        return raiz == null;
    }
}
