public class CriterioPrecoMaximo implements CriterioBusca {
    public boolean testar(Produto p, String valor) {
        double valorDouble = Double.parseDouble(valor);
        if (p.getPreco() <= valorDouble) {
            return true;
        }
    }
}