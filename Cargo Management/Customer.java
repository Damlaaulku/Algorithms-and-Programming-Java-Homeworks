
public class Customer {
	public int customerID;
	private String name;
	private Date birthdate;
	private String gender;
	private String email;
	private Adress adress;
	private Phone phone;
	private boolean flag = true;
	private int jobcount = 1; //top3 customer

	public Customer(int customerID, String name, Date birthdate, String gender, String email, Adress adress,
			Phone phone) {

		this.customerID = customerID;
		this.name = name;
		this.birthdate = birthdate;
		this.gender = gender;
		this.email = email;
		this.adress = adress;
		this.phone = phone;
	}

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public String isGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public int getJobcount() {
		return jobcount;
	}

	public void setJobcount(int jobcount) {
		this.jobcount = jobcount;
	}

	public String Display() {
		return name + " " + birthdate.Display() + " " + gender + " " + adress.Display() + " " + phone.Display();
	}
}
