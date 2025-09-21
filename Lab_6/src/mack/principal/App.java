package mack.principal;

import java.util.List;

import mack.dao.DAOHospede;
import mack.model.Hospede;

public class App {
    public static void main(String[] args) throws Exception {
       Hospede h = new Hospede();
       h.setNome("Ronaldo");
       h.setTelefone("(11) 98765-4321");
       DAOHospede daoHosp = new DAOHospede();
       daoHosp.create(h);

       List<Hospede> list = daoHosp.listAllHospedes();

       for (Hospede hospede : list) {
            System.out.print(hospede.getNome() + " - ");
            System.out.println(hospede.getTelefone());
       }
       System.out.println();

       daoHosp.update(h, "Ricardo", "(11) 96123-7126");
       list = daoHosp.listAllHospedes();
       for (Hospede hospede : list) {
            System.out.print(hospede.getNome() + " - ");
            System.out.println(hospede.getTelefone());
       }
       System.out.println();

       daoHosp.remove(h);
       list = daoHosp.listAllHospedes();
       for (Hospede hospede : list) {
            System.out.print(hospede.getNome() + " - ");
            System.out.println(hospede.getTelefone());
       }
    }
}