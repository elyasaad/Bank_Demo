package bank.transactions;

import static org.junit.Assert.assertEquals;

import java.rmi.server.UID;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestTransaction {
	UID userId;
	Calendar date;

	@Before
	public void init() {
		userId = new UID();
		date = new GregorianCalendar(2020, 05, 11);
	}

	@Test(expected = IllegalArgumentException.class)
	public void throw_exception_null_date() {
		new Transaction(userId, 10, Type.DEPOSIT, null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void throw_exception_null_type() {
		new Transaction(userId, 10, null, date);
	}

	@Test(expected = IllegalArgumentException.class)
	public void throw_exception_null_amount() {
		new Transaction(userId, 0, Type.DEPOSIT, date);
	}

	@Test
	public void new_transaction_created() {
		Transaction tr = new Transaction(userId, 10, Type.DEPOSIT, date);
		Assert.assertEquals(tr.get_idt(), userId);
		assertEquals(tr.getAmount(), 10,0);
		Assert.assertEquals(tr.getType(), Type.DEPOSIT);
	}

}
