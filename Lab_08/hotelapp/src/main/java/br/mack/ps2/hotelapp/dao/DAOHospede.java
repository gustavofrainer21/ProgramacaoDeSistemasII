package br.mack.ps2.hotelapp.dao;

import org.springframework.data.repository.CrudRepository;
import br.mack.ps2.hotelapp.model.Hospede;
import java.util.*;

public interface DAOHospede extends CrudRepository<Hospede, Long> {
    public List<Hospede> findByNome(String nome);
} 