import java.util.ArrayList;
import java.util.List;

public class Banco {

	private String nome;
	static List<Cliente> clientes = new ArrayList<>();

	public Banco(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public static void listarClinetes() {
		System.out.println("=== Lista de clientes ===");
		for (int i = 0; i < clientes.size(); i++) {

			System.out.println((i + 1) + "º\t " + clientes.get(i).getNome());
		}

	}
}
