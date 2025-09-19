package mack.model;

public class Hospede {
    private Long id;
    private String nome;
    private String telefone;

    public Hospede(){}

    public Hospede(Long id, String nome, String telefone) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return this.id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getNome() {
        return this.nome;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public String getTelefone() {
        return this.telefone;
    }
}
