# Gerenciador de Tarefas Corporativas

Trabalho Final de Estrutura de Dados 2026.2 - Tema 06.

Aplicacao de console em Java puro. Todas as estruturas sao implementadas manualmente, sem Collections.

## Estruturas

| Estrutura | Uso no sistema | Pacote | Responsavel |
|---|---|---|---|
| Arvore Binaria de Busca | Funcionarios e usuarios (busca por ID) | `abb` | Integrante 1 |
| Fila | Tarefas pendentes no backlog | `fila` | Integrante 2 |
| Pilha | Undo para restaurar tarefas excluidas | `pilha` | Integrante 3 |
| Modelo, Main e integracao | `Tarefa`, `Funcionario`, menu e fluxo | `modelo` e `Main` | Integrante 4 |

## Fluxo

1. Funcionarios sao cadastrados na ABB.
2. Uma tarefa so e criada para um funcionario existente na ABB e entra na fila do backlog.
3. Ao excluir uma tarefa do backlog, ela vai para a pilha de Undo.
4. Ao desfazer, a tarefa sai da pilha e volta para a fila.

## Como compilar e executar

Linux e macOS:

    javac -d out $(find src -name "*.java")
    java -cp out Main

Windows (PowerShell):

    javac -d out (Get-ChildItem -Recurse src -Filter *.java).FullName
    java -cp out Main

## Fluxo de trabalho no Git

- `main`: codigo integrado e compilando.
- Uma branch por integrante: `abb`, `fila`, `pilha`, `integracao`.
- Alteracoes entram na `main` por pull request.

## Regras do trabalho

- Proibido usar estruturas prontas do Java (ArrayList, LinkedList, Stack, Queue etc.).
- Codigo sem comentarios.
- O programa precisa compilar.
