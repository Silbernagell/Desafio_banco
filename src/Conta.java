import java.util.ArrayList;
import java.util.List;
import java.util.Calendar;
import java.text.DateFormat;
import java.util.Date;


public abstract class Conta implements IConta {
	
	private static final int AGENCIA_PADRAO = 1;
	private static int SEQUENCIAL = 1;

	protected int agencia;
	protected int numero;
	protected double saldo;
	protected Cliente cliente;
	protected Banco banco;
	protected List<String> transacoes;

	public Conta(Cliente cliente, Banco banco) {
		this.transacoes = new ArrayList<>();
		this.agencia = Conta.AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++;
		this.cliente = cliente;
		this.banco = banco;
		this.banco.addContas(this);
	}

	public String getNomeCliente(Cliente cliente){
		return cliente.getNome();
	}

	@Override
	public void sacar(double valor) {
		saldo -= valor;
		Calendar c = Calendar.getInstance();
        Date data = c.getTime();

        DateFormat dtHora = DateFormat.getDateTimeInstance();
		transacoes.add("Saque de: R$" + Double.toString(valor) + " // " + dtHora.format(data) + "\n");
	}

	@Override
	public void depositar(double valor) {
		saldo += valor;
		Calendar c = Calendar.getInstance();
        Date data = c.getTime();

        DateFormat dtHora = DateFormat.getDateTimeInstance();
		transacoes.add("depósito de: R$" + Double.toString(valor) + " // " + dtHora.format(data) + "\n");
	}

	@Override
	public void transferir(double valor, IConta contaDestino) {
		this.sacar(valor);
		contaDestino.depositar(valor);
		Calendar c = Calendar.getInstance();
        Date data = c.getTime();

        DateFormat dtHora = DateFormat.getDateTimeInstance();
		transacoes.add("Transferência de: R$" + Double.toString(valor) + " para: " + contaDestino.getNomeCliente(getCliente())); // " + dtHora.format(data) + "\n");
	}

	public int getAgencia() {
		return agencia;
	}

	public int getNumero() {
		return numero;
	}

	public double getSaldo() {
		return saldo;
	}

	public Banco getBanco(){
		return this.banco;
	}

	public Cliente getCliente(){
		return cliente;
	}

	protected void imprimirInfosComuns() {
		System.out.println(String.format("Titular: %s", this.cliente.getNome()));
		System.out.println(String.format("Agencia: %d", this.agencia));
		System.out.println(String.format("Numero: %d", this.numero));
		System.out.println(String.format("Saldo: %.2f", this.saldo));
		System.out.println("=====================Transações======================");
		System.out.println("");
		System.out.println(transacoes);
	}
}