package modelo;

public class Tarefa {
    private int id;
    private String titulo;
    private int idResponsavel;
    private String status;

    public Tarefa(int id, String titulo, int idResponsavel) {
        this.id = id;
        this.titulo = titulo;
        this.idResponsavel = idResponsavel;
        this.status = "PENDENTE";
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getIdResponsavel() {
        return idResponsavel;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Tarefa [id=" + id + ", titulo=" + titulo + ", responsavel=" + idResponsavel + ", status=" + status + "]";
    }
}
