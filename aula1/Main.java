import model.Assento;
import model.AssentoEconomica;
import model.AssentoExecutivo;
import model.AssentoPrimeiraClasse;
import model.Passageiro;

public class Main {
    public static void main(String[] args) {
        Assento a1 = new AssentoEconomica("Economica", 50.0);
        System.out.println("Valor do Assento: " + a1.calcularPrecoFinal());

        Assento a2 = new AssentoExecutivo("Economica", 50.0);
        System.out.println("Valor do Assento: " + a2.calcularPrecoFinal());

        Assento a3 = new AssentoPrimeiraClasse("Economica", 50.0);
        System.out.println("Valor do Assento: " + a3.calcularPrecoFinal());

        Passageiro p1 = new Passageiro("Gustavo");
        System.out.println("Comprando assento na classe economica");
        p1.setAssento(a1);

        System.out.println("O Assento do Passageiro ["+p1.getNome()+"] custa [R$"+p1.getAssento().calcularPrecoFinal()+"]");

        System.out.println("realizando o upgrade");
        p1.setAssento(a2);
        System.out.println("O Assento do Passageiro ["+p1.getNome()+"] custa [R$"+p1.getAssento().calcularPrecoFinal()+"]");
    }
}