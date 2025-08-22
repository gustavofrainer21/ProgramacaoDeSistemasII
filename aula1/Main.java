import model.Assento;
import model.AssentoEconomica;
import model.AssentoExecutivo;
import model.AssentoPrimeiraClasse;
import model.Passageiro;

public class Main {
    public static void main(String[] args) {
        Assento a1 = new AssentoEconomica("Economica", 500.0);
        System.out.println("Valor do Assento da " + a1.getClasse() + ": R$" + a1.calcularPrecoFinal());

        Assento a2 = new AssentoExecutivo("Executiva", 500.0);
        System.out.println("Valor do Assento da " +a2.getClasse() + ": R$" + a2.calcularPrecoFinal());

        Assento a3 = new AssentoPrimeiraClasse("Primeira Classe", 500.0);
        System.out.println("Valor do Assento da " + a3.getClasse() + ": R$" + a3.calcularPrecoFinal());

        Passageiro p1 = new Passageiro("Gustavo");
        System.out.println("Comprando assento na classe economica");
        p1.setAssento(a1);

        System.out.println("O Assento do Passageiro ["+p1.getNome()+"] custa [R$"+p1.getAssento().calcularPrecoFinal()+"]");

        System.out.println("Realizando o upgrade para classe executiva");
        p1.setAssento(a2);
        System.out.println("O Assento do Passageiro ["+p1.getNome()+"] custa [R$"+p1.getAssento().calcularPrecoFinal()+"]");

        System.out.println("Realizando o upgrade para a Primeira Classe");
        p1.setAssento(a3);
        System.out.println("O Assento do Passageiro ["+p1.getNome()+"] custa [R$"+p1.getAssento().calcularPrecoFinal()+"]");
    }
}