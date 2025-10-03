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
public class HotelappApplication implements org.springframework.boot.CommandLineRunner {

	@Autowired
	private DAOHospede hospDAO;
	@Autowired
	private DAOReserva resDAO;

	public static void main(String[] args) {
		SpringApplication.run(HotelappApplication.class, args);
	}

	// Método Listar
	public void listar() {
		Iterable<Hospede> hospedes = hospDAO.findAll();
		Iterable<Reserva> reservas = resDAO.findAll();
		System.out.println("Hóspedes:");
		for(Hospede h : hospedes) {
			System.out.println("ID: " + h.getId());
			System.out.println("Nome: " + h.getNome());
			System.out.println("Telefone: " + h.getTelefone());
			System.out.println("-----------------------\n");
		}
		System.out.println("Reservas:");
		for(Reserva r : reservas) {
			System.out.println("ID: " + r.getId());
			System.out.println("ID do Hóspede: " + r.getHospede_id());
			System.out.println("Data de Check-in: " + r.getData_checkin());
			System.out.println("-----------------------\n");
		}
	}

	// Método Buscar
	public void buscarHospede() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Digite o nome do hóspede: ");
		String nome = sc.nextLine();
		List<Hospede> hospedes = hospDAO.findByNome(nome);
		for(Hospede h : hospedes) {
			System.out.println("ID: " + h.getId());
			System.out.println("Nome: " + h.getNome());
			System.out.println("Telefone: " + h.getTelefone());
			System.out.println("-----------------------\n");
		}
	}
	public void buscarReserva() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Digite o ID do hóspede: ");
		int hospede_id = sc.nextInt();
		/*List<Reserva> reservas = resDAO.findByHospede_id(hospede_id);
		for(Reserva r : reservas) {
			System.out.println("ID: " + r.getId());
			System.out.println("ID do Hóspede: " + r.getHospede_id());
			System.out.println("Data de Check-in: " + r.getData_checkin());
			System.out.println("-----------------------\n");
		}*/
	}

	// Método Criar
	public void criarHospede() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Digite o nome do hóspede: ");
		String nome = sc.nextLine();
		System.out.print("Digite o telefone do hóspede: ");
		String telefone = sc.nextLine();
		Hospede h = new Hospede();
		h.setNome(nome);
		h.setTelefone(telefone);
		hospDAO.save(h);
		System.out.println("Hóspede criado com sucesso!\n");
	}
	public void criarReserva() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Digite o ID do hóspede: ");
		int hospede_id = sc.nextInt();
		sc.nextLine(); // Consumir a quebra de linha
		System.out.print("Digite a data de check-in (formato YYYY-MM-DD): ");
		String data_checkin = sc.nextLine();
		Reserva r = new Reserva();
		r.setHospede_id(hospede_id);
		r.setData_checkin(data_checkin);
		resDAO.save(r);
		System.out.println("Reserva criada com sucesso!\n");
	}

	// Método Alterar
	public void alterarDadosHospede() {
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
			System.out.println("Hóspede alterado com sucesso!\n");
		} else {
			System.out.println("Hóspede não encontrado!\n");
		}
	}
	public void alterarDadosReserva() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Digite o ID da reserva: ");
		Long id = sc.nextLong();
		sc.nextLine(); // Consumir a quebra de linha
		Optional<Reserva> optionalReserva = resDAO.findById(id);
		if(optionalReserva.isPresent()) {
			Reserva r = optionalReserva.get();
			System.out.print("Digite o novo ID do hóspede (atual: " + r.getHospede_id() + "): ");
			int hospede_id = sc.nextInt();
			sc.nextLine(); // Consumir a quebra de linha
			System.out.print("Digite a nova data de check-in (atual: " + r.getData_checkin() + "): ");
			String data_checkin = sc.nextLine();
			r.setHospede_id(hospede_id);
			r.setData_checkin(data_checkin);
			resDAO.save(r);
			System.out.println("Reserva alterada com sucesso!\n");
		} else {
			System.out.println("Reserva não encontrada!\n");
		}
	}

	// Método Deletar
	public void deletarHospede() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Digite o ID do hóspede: ");
		Long id = sc.nextLong();
		Optional<Hospede> optionalHospede = hospDAO.findById(id);
		if(optionalHospede.isPresent()) {
			hospDAO.deleteById(id);
			System.out.println("Hóspede deletado com sucesso!\n");
		} else {
			System.out.println("Hóspede não encontrado!\n");
		}
	}
	public void deletarReserva() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Digite o ID da reserva: ");
		Long id = sc.nextLong();
		Optional<Reserva> optionalReserva = resDAO.findById(id);
		if(optionalReserva.isPresent()) {
			resDAO.deleteById(id);
			System.out.println("Reserva deletada com sucesso!\n");
		} else {
			System.out.println("Reserva não encontrada!\n");
		}
	}

	public void run(String... args) throws Exception {
		boolean saida = false;

		while(!saida) {
			System.out.println("===Menu de Opções===");
			System.out.println("1 - Listar Todos os Hóspedes e Reservas");
			System.out.println("2 - Buscar Hóspede por Nome");
			System.out.println("3 - Buscar Reserva por ID do Hóspede");
			System.out.println("4 - Criar novo Hóspede");
			System.out.println("5 - Criar nova Reserva");
			System.out.println("6 - Alterar dados de um Hóspede");
			System.out.println("7 - Alterar dados de uma Reserva");
			System.out.println("8 - Deletar um Hóspede por ID");
			System.out.println("9 - Deletar uma Reserva por ID");
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
					System.out.println("Buscando Hóspede por Nome:");
					buscarHospede();
					break;
				case 3:
					System.out.println("Buscando Reserva por ID do Hóspede:");
					buscarReserva();
					break;
				case 4:
					System.out.println("Criando novo Hóspede:");
					criarHospede();
					break;
				case 5:
					System.out.println("Criando nova Reserva:");
					criarReserva();
					break;
				case 6:
					System.out.println("Alterando dados de um Hóspede:");
					alterarDadosHospede();
					break;
				case 7:
					System.out.println("Alterando dados de uma Reserva:");
					alterarDadosReserva();
					break;
				case 8:
					System.out.println("Deletando um Hóspede por ID:");
					deletarHospede();
					break;
				case 9:
					System.out.println("Deletando uma Reserva por ID:");
					deletarReserva();
					break;
				case 0:
					System.out.println("Saindo...");
					saida = true;
					System.exit(0);
				default:
					System.out.println("Opção inválida!");
					break;
			}
		}
	}
}