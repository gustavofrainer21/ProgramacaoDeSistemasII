package br.mack.ps2.hotelapp.dao;

import org.springframework.data.repository.CrudRepository;
import br.mack.ps2.hotelapp.model.Reserva;
import java.util.*;

public interface DAOReserva extends CrudRepository<Reserva, Long> {
    public List<Reserva> findByHospede_id(int hospede_id);
} 