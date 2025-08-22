package model;

public class AssentoExecutivo extends Assento {
    private double acrecimo = 0.3;

    public AssentoExecutivo(String classe, double precoBase) {
        super(classe, precoBase);
    }

    @Override
    public abstract double calculaPrecoFinal(); {
        return this.getPrecoBase + (this.getPrecoBase * this.acrecimo);
    }
}