package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Account;
import entities.Client;

public class Program {

	public static void main(String[] args)  {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Account account;

		try {
		System.out.println("Dados do usuário. ");
		System.out.println("-------------------");

		System.out.print("Nome completo: ");
		String clientName = sc.nextLine();
		System.out.print("Data de nascimento: (DIA/MÊS/ANO) ");
		Date date = sdf.parse(sc.next());
		System.out.println();
		Client client = new Client(clientName, date);
		System.out.println(client);
		System.out.println();

		System.out.println("Dados da conta bancária. ");
		System.out.println("-------------------------");
		System.out.print("Número da conta: ");
		int numberAccount = sc.nextInt();
		System.out.print("Agência: ");
		sc.nextLine();
		String agency = sc.nextLine();
		System.out.print("Deseja efetuar o primeiro deposito ? (s/n)");
		char response = sc.next().charAt(0);

		if (response == 's') {
			System.out.print("Informe o valor de deposito: ");
			double balance = sc.nextDouble();

			account = new Account(numberAccount, agency, client, balance);
		} 
		else {
			account = new Account(numberAccount, agency, client);
		}
		
		System.out.println();
		System.out.println("Dados da conta bancária: ");
		System.out.println(account);
		System.out.println();

		System.out.println("Operação na conta bancária: Deposito [1] || Saque [2]");
		int responseBankAccount = sc.nextInt();
		
			if (responseBankAccount == 1) {
				System.out.println("Informe o valor para deposito: ");
				double balance = sc.nextDouble();
				account.deposit(balance);
			} 
			else if (responseBankAccount == 2) {
				System.out.println("Informe o valor para saque: ");
				double withdraw = sc.nextDouble();
				account.withdraw(withdraw);
			} 
		
		System.out.println();
		System.out.println("Dados atualizados: ");
		System.out.println(account);
		
		}
		
		catch (IllegalStateException e) {
			System.out.println(e.getMessage());
		}
		catch (ParseException e) {
			System.out.println(e.getMessage());
		}
		catch (RuntimeException e) {
			System.out.println("Erro inesperado. ");
		}
		System.out.println();
		System.out.println("Fim do programa.");

		sc.close();
	}
}