package model;

public class AssentoPrimeiraClasse extends Assento {
    private double acrecimo = 0.5;

    public AssentoPrimeiraClasse(String classe, double precoBase) {
        super(classe, precoBase);
    }

    @Override
    public double calcularPrecoFinal() {
        return this.getPrecoBase() + (this.getPrecoBase() * this.acrecimo);
    }
}