import java.text.ParseException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
/*
	Na classe Main implementei os metodos que instanciam e listão clientes e contas, tambem crie um meno para ser possivel fazer as operações 
	
 */
public class Main {

	static List<Cliente> clientes = new ArrayList<>();
	static List<Conta> contas = new ArrayList<>();

	public static void main(String[] args) throws java.lang.NullPointerException, ParseException {
		boolean continua = true;
		// Menu do programa. Implementado com o uso de um switch
		do {
			Scanner teclado = new Scanner(System.in);
			System.out.println("=====\t MENU \t=====");
			System.out.println("1 - Criar Cleinte\n" + "2 - Criar Conta\n" + "3 - Movimento de conta\n"
					+ "4 - Listar Clientes\n" + "5 - Listar Contas\n" + "6 - Sair");
			System.out.print("Digite aqui: ");
			int opcao = teclado.nextInt();
			switch (opcao) {
			case 1: {
				criarCliente();
				break;
			}
			case 2: {
				criarConta();
				break;
			}
			case 3: {
				movimentarConta();
				break;
			}
			case 4: {
				listarClinetes();
				break;
			}
			case 5: {
				listarContas();
				break;
			}
			case 6: {
				continua = false;
				break;
			}
			default:
				System.out.println("Opção invalida!\nEscolha uma opção valida");
				break;
			}
		} while (continua);
	}

	// metodos do menu
	
	
	public static void criarCliente() {

		boolean continua = true;
		do {
			Scanner teclado = new Scanner(System.in);
			String nome;
			String BI;

			System.out.println("=== CRIANDO CLIENTE ===");

			System.out.print("NOme: ");
			nome = teclado.nextLine();

			System.out.print("Bilhete de Identidade: ");
			BI = teclado.nextLine();

			System.out.println("Data de Nascimento ");

			System.out.print("ano: ");
			int ano = teclado.nextInt();

			System.out.print("mes: ");
			int mes = teclado.nextInt();

			System.out.print("dia: ");
			int dia = teclado.nextInt();

			Cliente cliente = new Cliente(nome, BI, ano, mes, dia);

			clientes.add(cliente);

			System.out.print("Cadastrar um novo cliente? [S/N]: ");
			String c = teclado.next();
			if (c.equalsIgnoreCase("n")) {
				continua = false;
			}
		} while (continua);

	}

	public static void criarConta() {
		
		
		if (!clientes.isEmpty()) {
			listarClinetes();
			Conta conta = null;
			System.out.println("Pode  escolher um cliente apartir da sua posição de 1 à " + (clientes.size()));
			Scanner teclado = new Scanner(System.in);
			System.out.print("Digite aqui: ");
			int posicao = teclado.nextInt();

			System.out.println("==== TIPOS DE CONTA ===\n" + "1 - Conta Corrente\n" + "2 - Conta Poupança\n"
					+ "Escolha qual tipo de conta quer criar");
			System.out.print("Digite aqui: ");
			int tipoConta = teclado.nextInt();
			switch (tipoConta) {
			case 1: {
				conta = new ContaCorrente(clientes.get(posicao - 1));
				break;
			}
			case 2: {
				conta = new ContaPoupanca(clientes.get(posicao - 1));
				break;
			}
			default:
				System.out.println("Posição invalida, não é possivel criar conta");
				break;
			}

			contas.add(conta);
		}else {
			System.out.println("Impossicivel criar conta! Não existe nenhum Cliente Cadastrado\nCadastre cliente para poder criar conta");
		}
		
	}

	public static void listarClinetes() {
		System.out.println("=== LISTA DE CLIENTES ===");
		for (int i = 0; i < clientes.size(); i++) {

			System.out.println((i + 1) + "º\t " + clientes.get(i).getNome());
		}
	}

	public static void listarContas() {
		System.out.println("\n=== LISTA DE CONTAS ===\n");
		for (int i = 0; i < contas.size(); i++) {
			contas.get(i).imprimirExtrato();
			System.out.println("Posição: " + (i + 1));
		}
	}

	public static void movimentarConta() {
		Scanner teclado = new Scanner(System.in);
		System.out.println("\n=== MOVIMENTO DE CONTA ===\n");

		listarContas();
		System.out.println("movimento de conta");
		System.out.println("Digite a posição de Conta: ");
		int posicao = teclado.nextInt();
		System.out.println("--- Opções de movimentação ---");
		System.out.println("1 - Sacar\n" + "2 - Depositar\n" + "3 - Transferir");

		System.out.print("Digite aqui: ");
		int opcao = teclado.nextInt();
		switch (opcao) {
		case 1: {
			contas.get(posicao - 1).sacar();
			break;
		}
		case 2: {
			contas.get(posicao - 1).depositar();
			break;
		}
		case 3: {
			listarContas();
			System.out.print("Digite a posição da conta destino: ");
			int cDestino = teclado.nextInt();
			contas.get(posicao - 1).transferir(contas.get(cDestino - 1));
			break;
		}
		default:
			System.out.println("Opção invalida");
			break;
		}
	}
}
