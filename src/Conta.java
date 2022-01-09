import java.util.Scanner;

public abstract class Conta implements IConta {

	protected static final int AGENCIA_PADRAO = 1;
	private static int SEQUENCIAL = 1;

	protected int agencia;
	protected int numero;
	protected double saldo;
	private Cliente cliente;

	public Conta(Cliente cliente) {
		this.agencia = Conta.AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++;
		this.cliente = cliente;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public int getAgencia() {
		return agencia;
	}

	public int getNumero() {
		return numero;
	}

	public void sacar() {
		Scanner teclado = new Scanner(System.in);
		System.out.print("Digite o valor: ");
		double valor = teclado.nextDouble();
		if (valor <= this.saldo) {
			this.saldo -= valor;
		} else {
			System.out.println("Operação não autorizado");
		}

	}
	public double sacar(double valor) {
		
		if (valor <= this.saldo) {
			this.saldo -= valor;
			return this.saldo;
		} else {
			System.out.println("Operação não autorizado");
			return 0;
		}

	}

	public void depositar() {
		Scanner teclado = new Scanner(System.in);
		System.out.print("Digite o valor: ");
		double valor = teclado.nextDouble();
		this.saldo += valor;
	}

	public void transferir( Conta contaDestino) {
		Scanner teclado = new Scanner(System.in);
		System.out.print("Digite o valor: ");
		double valor = teclado.nextDouble();
		
		contaDestino.setSaldo(this.sacar(valor));
	}

	public void imprimirDados() {
		System.out.println("=== Cliente: " +cliente.getNome() + " ====");
		System.out.printf("Agencia: %d\n", this.agencia);
		System.out.printf("Numero: %d\n", this.numero);
		System.out.printf("Saldo: %.2f\n", this.saldo);
	}

}
