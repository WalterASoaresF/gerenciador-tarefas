package abb;

import modelo.Funcionario;

public class NoABB {
    Funcionario dado;
    NoABB esquerda;
    NoABB direita;

    public NoABB(Funcionario dado) {
        this.dado = dado;
        this.esquerda = null;
        this.direita = null;
    }
}
