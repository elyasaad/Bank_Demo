package bank.transactions;

import java.rmi.server.UID;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Transaction {

	
	public Transaction(UID idt, double amount, Type type, Calendar date) {
		

		if (amount == 0) {
			throw new IllegalArgumentException("The Date can not be zero");
		}
		if (type == null) {
			throw new IllegalArgumentException("The Type can not be null");
		}
		if (date == null) {
			throw new IllegalArgumentException("The Date can not be null");
		}
		
		_idt = idt;
		_amount = amount;
		_type = type;
		_transDate = Calendar.getInstance();
		
	}

	public double getAmount() {
		return _amount;
	}

	public Type getType() {
		return _type;
	}

	public Calendar getDate() {
		return _transDate;
	}

	public UID get_idt() {
		return _idt;
	}

	public void set_idt(UID _idt) {
		this._idt = _idt;
	}

	public String toString() {
		String date_format = "MM-dd-yyyy hh:mm:ss";
		String tDate;
		SimpleDateFormat sdf = new SimpleDateFormat(date_format);
		tDate = sdf.format(_transDate.getTime());
		String transInfo = _idt + " " + tDate + " " + _type + " " + String.format("%.2f", _amount);
		return transInfo;
	}

	private UID _idt;
	private Type _type;
	private double _amount;
	private Calendar _transDate;
}