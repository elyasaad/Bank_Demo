package bank;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import bank.customer.PhysicalPerson;
import bank.exception.BankAccountException;

public class TestBankAccount {

	BankAccount bankAccount;

	@Before
	public void init() {
		PhysicalPerson php = new PhysicalPerson("0001", "adress 1", "saad", "saad2");
		bankAccount = new BankAccount(php);
	}

	@Test
	public void testmakeDeposit_increase_by_10() throws BankAccountException {
		double oldBalance = bankAccount.getBalance();
		bankAccount.makeDeposit(10);
		assertEquals(oldBalance + bankAccount.getBalance(), 10, 0);
	}

	@Test(expected = BankAccountException.class)
	public void testmakeDeposit_0_value() throws BankAccountException {
		bankAccount.makeDeposit(0);
	}

	@Test(expected = BankAccountException.class)
	public void testmakeDeposit_negative_value() throws BankAccountException {
		bankAccount.makeDeposit(-10);
	}

	@Test
	public void testmakeWithdrawal_decrease_by_10() throws BankAccountException {
		double oldBalance = bankAccount.getBalance();
		bankAccount.makeDeposit(20);
		bankAccount.makeWithdrawal(10);
		assertEquals(oldBalance + bankAccount.getBalance(), 10, 0);
	}

	@Test(expected = BankAccountException.class)
	public void testmakeWithdrawal_decrease_by_bigger_value_than_the_current_balance_value()
			throws BankAccountException {

		bankAccount.makeDeposit(10);
		bankAccount.makeWithdrawal(20);
	}

	@Test(expected = BankAccountException.class)
	public void testmakeWithdrawal_decrease_by_negative_value() throws BankAccountException {

		bankAccount.makeWithdrawal(-10);
	}

}
