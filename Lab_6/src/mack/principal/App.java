package mack.principal;

import java.util.List;

import mack.dao.DAOHospede;
import mack.model.Hospede;
import mack.dao.DAOReserva;
import mack.model.Reserva;

public class App {
    public static void main(String[] args) throws Exception {
    //Tabela Hospede
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

        System.out.println();

    //Tabela Reserva
       Reserva r = new Reserva();
       int Id = h.getId().intValue();
       r.setHospede_id(Id);
       r.setData_checkin("19/09/2025");
       DAOReserva daoRes = new DAOReserva();
       daoRes.create(r);

       List<Reserva> list2 = daoRes.listAllReservas();

       for (Reserva reserva : list2) {
            System.out.print(reserva.getHospede_id() + " - ");
            System.out.println(reserva.getData_checkin());
       }
       System.out.println();

       daoRes.update(r, 2, "21/09/2025");
       list2 = daoRes.listAllReservas();
       for (Reserva reserva : list2) {
            System.out.print(reserva.getHospede_id() + " - ");
            System.out.println(reserva.getData_checkin());
       }
       System.out.println();

       daoRes.remove(r);
       list2 = daoRes.listAllReservas();
       for (Reserva reserva : list2) {
            System.out.print(reserva.getHospede_id() + " - ");
            System.out.println(reserva.getData_checkin());
       }
    }
}