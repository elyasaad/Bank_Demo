package bank.customer;

public class Person {

	public Person(String personnumber, String adress) {
		_personnumber = personnumber;
		_adress = adress;
	}

	public String get_personnumber() {
		return _personnumber;
	}

	public void set_personnumber(String _personnumber) {
		this._personnumber = _personnumber;
	}

	public String get_adress() {
		return _adress;
	}

	public void set_adress(String _adress) {
		this._adress = _adress;
	}

	private String _personnumber;
	private String _adress;

}