
public class Office {
	private int officeID;
	private String name;
	private Adress adress;
	private Phone phone;
	private int income = 0;

	public Office(int officeID, String name, Adress adress, Phone phone) {

		this.officeID = officeID;
		this.name = name;
		this.adress = adress;
		this.phone = phone;
	}

	public int getOfficeID() {
		return officeID;
	}

	public void setOfficeID(int officeID) {
		this.officeID = officeID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Adress getAdress() {
		return adress;
	}

	public void setAdress(Adress adress) {
		this.adress = adress;
	}

	public Phone getPhone() {
		return phone;
	}

	public void setPhone(Phone phone) {
		this.phone = phone;
	}

	public int getIncome() {
		return income;
	}

	public void setIncome(int income) {
		this.income = income;
	}

	public String Display() {
		return name + " " + adress.Display() + " " + phone.Display();
	}
}
