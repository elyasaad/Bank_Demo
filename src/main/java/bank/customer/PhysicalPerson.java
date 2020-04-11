package bank.customer;


public class PhysicalPerson extends Person {

	public PhysicalPerson(String personnumber, String adress, String first, String last) {
		super(personnumber, adress);
		_firstName = first;
		_lastName = last;
	}

	public String getPerson() {
		return _firstName;
	}

	public String getLastName() {
		return _lastName;
	}

	

	public String toString() {
		
		return super.get_personnumber() + " " + super.get_adress() + " " + _firstName + " " + _lastName;
	}

	private String _firstName;
	private String _lastName;

}