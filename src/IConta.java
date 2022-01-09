
public interface IConta {
	public void sacar();

	public void depositar();

	public void transferir(Conta contaDestino);

	public void imprimirExtrato();
}
