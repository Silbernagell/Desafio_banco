
import java.util.ArrayList;
import java.util.List;

public class Banco {

	private String nome;
	private List<Conta> contas;

	public Banco(String nome){
		this.nome = nome;
		this.contas = new ArrayList<>();
	} 

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Conta> getContas() {
		return contas;
	}

	public void setContas(List<Conta> contas) {
		this.contas = contas;
	}

	public void addContas(Conta conta){
		contas.add(conta);
	}

	public List <String> showClients(List<Conta> contas){
		String nomeCliente;
		List<String> nomesClientes = new ArrayList<>();
		for (Conta conta : contas) {
			nomeCliente = conta.getNomeCliente(conta.getCliente());
			nomesClientes.add(nomeCliente);
		}
		
		return nomesClientes;
	}

}

