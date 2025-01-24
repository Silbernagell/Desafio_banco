import java.util.Scanner;
import java.util.ArrayList;



public class Menu {

    Scanner scan = new Scanner(System.in);
    private Conta conta; 

    public void Navegar(Conta conta){
        this.conta = conta;

       
        int num;

        do {
            System.out.println("==========MENU==========");
            System.out.println("=Selecione uma opção=");
            System.out.println("[1] depositar");
            System.out.println("[2] Sacar");
            System.out.println("[3] Transferir");
            System.out.println("[4] Consultar extrato");
            System.out.println("[0] Sair");
            System.out.println("");
    
            num = scan.nextInt();
            switch (num) {
                case 1:
                    System.out.println("Selecione o valor do deposito: ");
                    double valorDeposito = scan.nextDouble();
                    conta.depositar(valorDeposito);    
                    break;
                
                case 2 :
                    System.out.println("Selecione o valor do saque: ");
                    double valorSaque = scan.nextDouble();
                    conta.sacar(valorSaque);
                    break;

                case 3 :
                    System.out.println("Selecione o valor da transferência");
                    double valorTransferencia = scan.nextDouble();
                    System.out.println("Selecione o número da conta destino");
                    int numConta = scan.nextInt();
                    Conta contaDestino;
                    ArrayList<Integer> listaNum = new ArrayList(); 
                    for (Conta i : conta.banco.getContas()) {
                        listaNum.add(i.numero);
                        if (i.numero == numConta) {
                            contaDestino = i;
                            conta.transferir(valorTransferencia, contaDestino);
                        }
                        
                    }
                    if (! listaNum.contains(numConta)) {
                        System.out.println("conta inválida");
                    }
                    break;

                case 4 :
                    conta.imprimirInfosComuns();
                    break;

                case 0 :
                    break;
                    
                default:
                    System.out.println("inválido");
                    break;
            }
        } while (num != 0); 
            
        }
    }

