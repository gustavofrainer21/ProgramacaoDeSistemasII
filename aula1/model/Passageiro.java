package model;

public class Passageiro {
    private String nome;
    private Assento assento;

    public Passageiro(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
}