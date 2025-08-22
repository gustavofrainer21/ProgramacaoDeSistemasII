package model;

public class AssentoPrimeiraClasse extends Assento {
    public AssentoPrimeiraClasse(String classe, double precoBase) {
        super(classe, precoBase);
    }

    @Override
    public abstract double calcularPrecoFinal() {
        
    }
}