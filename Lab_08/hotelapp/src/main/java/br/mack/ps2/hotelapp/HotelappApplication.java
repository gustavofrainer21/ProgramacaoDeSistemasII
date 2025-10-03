package br.mack.ps2.hotelapp;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.mack.ps2.hotelapp.model.Hospede;
import br.mack.ps2.hotelapp.dao.DAOHospede;
import br.mack.ps2.hotelapp.model.Reserva;
import br.mack.ps2.hotelapp.dao.DAOReserva;

@SpringBootApplication
public class HotelappApplication {

	@Autowired
	private DAOHospede hospDAO;

	public static void main(String[] args) {
		SpringApplication.run(HotelappApplication.class, args);
	}

	public void listar() {
		Iterable<Hospede> hospedes = hospDAO.findAll();
		for(Hospede h : hospedes) {
			System.out.println("ID: " + h.getId());
			System.out.println("Nome: " + h.getNome());
			System.out.println("Telefone: " + h.getTelefone());
			System.out.println("-----------------------");
		}
	}

	public void buscar() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Digite o nome do hóspede: ");
		String nome = sc.nextLine();
		List<Hospede> hospedes = hospDAO.findByNome(nome);
		for(Hospede h : hospedes) {
			System.out.println("ID: " + h.getId());
			System.out.println("Nome: " + h.getNome());
			System.out.println("Telefone: " + h.getTelefone());
			System.out.println("-----------------------");
		}
	}

	public void criar() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Digite o nome do hóspede: ");
		String nome = sc.nextLine();
		System.out.print("Digite o telefone do hóspede: ");
		String telefone = sc.nextLine();
		Hospede h = new Hospede();
		h.setNome(nome);
		h.setTelefone(telefone);
		hospDAO.save(h);
		System.out.println("Hóspede criado com sucesso!");
	}

	public void alterarDados() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Digite o ID do hóspede: ");
		Long id = sc.nextLong();
		sc.nextLine(); // Consumir a quebra de linha
		Optional<Hospede> optionalHospede = hospDAO.findById(id);
		if(optionalHospede.isPresent()) {
			Hospede h = optionalHospede.get();
			System.out.print("Digite o novo nome do hóspede (atual: " + h.getNome() + "): ");
			String nome = sc.nextLine();
			System.out.print("Digite o novo telefone do hóspede (atual: " + h.getTelefone() + "): ");
			String telefone = sc.nextLine();
			h.setNome(nome);
			h.setTelefone(telefone);
			hospDAO.save(h);
			System.out.println("Hóspede alterado com sucesso!");
		} else {
			System.out.println("Hóspede não encontrado!");
		}
	}

	public void deletar() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Digite o ID do hóspede: ");
		Long id = sc.nextLong();
		Optional<Hospede> optionalHospede = hospDAO.findById(id);
		if(optionalHospede.isPresent()) {
			hospDAO.deleteById(id);
			System.out.println("Hóspede deletado com sucesso!");
		} else {
			System.out.println("Hóspede não encontrado!");
		}
	}

	public void run(String... args) throws Exception {
		System.out.println("===Menu de Opções===");
		System.out.println("1 - Listar Todos os Hóspedes e Reservas");
		System.out.println("2 - Buscar Hóspede por Nome");
		//System.out.println("3 - Buscar Reserva por ID do Hóspede");
		System.out.println("3 - Criar novo Hóspede");
		//System.out.println("  - Criar nova Reserva");
		System.out.println("4 - Alterar dados de um Hóspede");
		//System.out.println("  - Alterar dados de uma Reserva");
		System.out.println("5 - Deletar um Hóspede por ID");
		//System.out.println("  - Deletar uma Reserva por ID");
		System.out.println("0 - Sair");
		System.out.println();
		Scanner sc = new Scanner(System.in);
		System.out.print("Digite a opção desejada: ");
		int opcao = sc.nextInt();

		switch(opcao) {
			case 1:
				System.out.println("Listando Hóspedes e Reservas:");
				listar();
				break;
			case 2:
				System.out.println("Buscando por Nome:");
				buscar();
				break;
			case 3:
				System.out.println("Criando novo Hóspede:");
				criar();
				break;
			case 4:
				System.out.println("Alterando dados de um Hóspede:");
				alterarDados();
				break;
			case 5:
				System.out.println("Deletando um Hóspede por ID:");
				deletar();
				break;
			case 0:
				System.out.println("Saindo...");
				System.exit(0);
			default:
				System.out.println("Opção inválida!");
				break;
		}
	}
}