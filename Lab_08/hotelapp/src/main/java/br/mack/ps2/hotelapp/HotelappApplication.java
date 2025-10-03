package br.mack.ps2.hotelapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.mack.ps2.hotelapp.model.Hospede;
import br.mack.ps2.hotelapp.dao.DAOHospede;

@SpringBootApplication
public class HotelappApplication {

	@Autowired
	private DAOHospede hospDAO;

	public static void main(String[] args) {
		SpringApplication.run(HotelappApplication.class, args);
	}

	public void run(String... args) throws Exception {
		Hospede h = new Hospede();
		h.setNome("Gustavo");
		h.setTelefone("9128312387");
		//this.DAOHospede;
	}

}