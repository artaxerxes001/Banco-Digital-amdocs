import java.text.DateFormat;
import java.time.LocalDate;

public class Cliente {

	private String nome;
	private String BI;
	public LocalDate dataNascimento;
	
	
		
	public Cliente(String nome, String bI, int ano, int mes, int dia) {
		super();
		this.nome = nome;
		BI = bI;
		this.dataNascimento = LocalDate.of(ano, mes, dia);
	}

	public String getNome() {
		return nome;
		
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getBI() {
		return BI;
	}

	public void setBI(String bI) {
		BI = bI;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(int ano, int mes, int dia) {
		this.dataNascimento = dataNascimento.of(ano, mes, dia);
	}

	@Override
	public String toString() {
		return "Cliente [nome=" + nome + ", BI=" + BI + ", dataNascimento=" + dataNascimento + "]";
	}
	
}
