package bank;


import bank.customer.PhysicalPerson;
import bank.exception.BankAccountException;

public class Main {

	public static void main(String[] args) throws BankAccountException {
		PhysicalPerson ph_p = new PhysicalPerson("0001", "adress 1", "saad", "saad2");
		BankAccount ba = new BankAccount(ph_p);
		
		System.out.println("Initial balance: " + ba.getBalance());
		ba.makeDeposit(10.55);
		ba.makeDeposit(10);
		ba.makeWithdrawal(5);
		System.out.println("balance: " + ba.getBalance());
		System.out.println(ba.printTransactions());
		

	}

}
