package bank;

import java.rmi.server.UID;
import java.util.ArrayList;
import java.util.Calendar;

import bank.customer.PhysicalPerson;
import bank.exception.BankAccountException;
import bank.transactions.*;

public class BankAccount {

	public BankAccount(PhysicalPerson owner) {
		_owner = owner;
		_transactions = new ArrayList<Transaction>();
	}

	public void makeWithdrawal(double amount) throws BankAccountException {

		if (amount <=0 || amount > getBalance()) {
			double shortBalance = getBalance() - amount;
			throw new BankAccountException("Owner: " + getOwner().toString() + ", Type: " + getType() + ", Balance: "
					+ getBalance() + ", Withdrawal: " + amount + ", Short: " + shortBalance);
		} else {
			Transaction newTrans = new Transaction(idGenerator(), amount, Type.WITHDRAW, Calendar.getInstance());
			_transactions.add(newTrans);
		}
	}

	public void makeDeposit(double amount) throws BankAccountException

	{
		if (amount > 0) {
			Transaction newTrans = new Transaction(idGenerator(), amount, Type.DEPOSIT, Calendar.getInstance());
			_transactions.add(newTrans);
		} else
			throw new BankAccountException("Amount not acceptable");
	}

	public void addTransaction(Transaction trans) {
		_transactions.add(trans);
	}

	public double getBalance() {
		double balance = 0;
		for (int i = 0; i < _transactions.size(); i++) {
			if (_transactions.get(i).getType() == Type.DEPOSIT ) {
				balance = balance + _transactions.get(i).getAmount();
			} else {
				balance = balance - _transactions.get(i).getAmount();
			}

		}

		return balance;
	}

	public int getNumberTrans() {
		return _transactions.size();
	}

	public String printTransactions() {
		String trans = "";

		for (int i = 0; i < _transactions.size(); i++) {
			trans = trans + _transactions.get(i).toString() + "\n";
		}

		return trans;
	}

	public PhysicalPerson getOwner() {
		return _owner;
	}

	public String getType() {
		return null;
	}

	private UID idGenerator() {
		UID userId = new UID();
		return userId;
	}

	private PhysicalPerson _owner;
	private ArrayList<Transaction> _transactions;
}