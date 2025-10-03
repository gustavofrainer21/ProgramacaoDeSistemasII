package br.mack.ps2.hotelapp;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.mack.ps2.hotelapp.model.Hospede;
import br.mack.ps2.hotelapp.dao.DAOHospede;

@SpringBootApplication
public class HotelappApplication {

	@Autowired
	private DAOHospede h;

	public static void main(String[] args) {
		SpringApplication.run(HotelappApplication.class, args);
	}

	public void run(String... args) throws Exception {
		System.out.println("===Menu de Opções===");
		System.out.println("1 - Listar Hóspedes");
		System.out.println("2 - Buscar por Nome");
		System.out.println("3 - Criar novo Hóspede");
		System.out.println("4 - Alterar dados de um Hóspede");
		System.out.println("5 - Deletar um Hóspede por ID");
		System.out.println("0 - Sair");
		System.out.println();
		Scanner sc = new Scanner(System.in);
		System.out.print("Digite a opção desejada: ");
		int opcao = sc.nextInt();

		switch(opcao) {
			case 1:
				System.out.println("Listando Hóspedes:");
				break;
			case 2:
				System.out.println("Buscando por Nome:");
				break;
			case 3:
				System.out.println("Criando novo Hóspede:");
				break;
			case 4:
				System.out.println("Alterando dados de um Hóspede:");
				break;
			case 5:
				System.out.println("Deletando um Hóspede por ID:");
				break;
			case 0:
				System.out.println("Saindo...");
				break;
			default:
				System.out.println("Opção inválida!");
				break;
		}
	}

}