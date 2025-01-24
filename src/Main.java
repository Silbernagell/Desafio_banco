
public class Main {

	public static void main(String[] args) {
		Banco bradesco = new Banco("Bradesco");

		Cliente venilton = new Cliente();
		venilton.setNome("Venilton");
		Cliente gabriel = new Cliente("Gabriel");
		Cliente james = new Cliente("James");
		
		Conta cc = new ContaCorrente(venilton,bradesco);
		Conta poupanca = new ContaPoupanca(venilton,bradesco);
		Conta cGabriel = new ContaCorrente(gabriel, bradesco);
		Conta cJames = new ContaCorrente(james, bradesco);

		System.out.println(bradesco.getContas());
		System.out.println(bradesco.showClients(bradesco.getContas()));

		Menu men = new Menu();
		//men.Navegar(cc);
	}

}