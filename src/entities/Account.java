package entities;

public class Account {

	private int numberAccount;
	private String agency;
	private double balance;
	Client client;

	public Account() {

	}

	public Account(int numberAccount, String agency, Client client) {
		this.numberAccount = numberAccount;
		this.agency = agency;
		this.client = client;
	}

	public Account(int numberAccount, String agency, Client client, double initialDeposit) {
		this.numberAccount = numberAccount;
		this.agency = agency;
		this.client = client;
		deposit(initialDeposit);
	}

	public int getNumberAccount() {
		return numberAccount;
	}

	public void setNumberAccount(int numberAccount) {
		this.numberAccount = numberAccount;
	}

	public String getAgency() {
		return agency;
	}

	public void setAgency(String agency) {
		this.agency = agency;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public void deposit(double amount) {
		balance += amount;
	}

	public void withdraw(double amount) {
		withdrawalValidation(amount);
		balance -= amount;
	}
	
	public void withdrawalValidation(double amount) {
		if (amount > balance) {
			throw new IllegalStateException("Erro: quantia é maior que o seu saldo.");
		}
		if (amount > withdrawalaLimit()) {
			throw new IllegalStateException("Erro: quantia é maior que o limite de saque, valor máximo para saque -> " + String.format("%.2f", withdrawalaLimit()));
		}
		
	}
	
	public double withdrawalaLimit() {
		double limit = balance / 2;
		return limit;
	}
	
	@Override
	public String toString () {
		return "Número da conta: "
				+ numberAccount
				+ ", Agência: "
				+ agency
				+ ", saldo: "
				+ String.format("%.2f", balance);
	}
	
	
	
	
	
	

}