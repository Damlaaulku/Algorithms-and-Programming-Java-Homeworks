
public class Employee {
	private Office officeID;
	private String name;
	private Date birthdate;
	private String gender;
	private Adress adress;
	private Phone phone;
	private double salary;
	private boolean flag = true;
	private String type;
	private int lostpackagenum;
	private int empID;

	// office boy
	public Employee(Office officeID, String name, Date birthdate, String gender, Adress adress, Phone phone,
			String type, int empID) {
		this.officeID = officeID;
		this.name = name;
		this.birthdate = birthdate;
		this.gender = gender;
		this.adress = adress;
		this.phone = phone;
		this.salary = 2020.58;
		this.type = type;
		this.empID = empID;
	}

	// service staff
	public Employee(Office officeID, String name, Date birthdate, String gender, Adress adress, Phone phone,
			String type, int lostpackagenum, int empID) {
		this.officeID = officeID;
		this.name = name;
		this.birthdate = birthdate;
		this.gender = gender;
		this.adress = adress;
		this.phone = phone;
		this.salary = 2020.58;
		this.type = type;
		this.lostpackagenum = lostpackagenum;
		this.empID = empID;
	}

	public Office getOfficeID() {
		return officeID;
	}

	public void setOfficeID(Office officeID) {
		this.officeID = officeID;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
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

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getLostpackagenum() {
		return lostpackagenum;
	}

	public void setLostpackagenum(int lostpackagenum) {
		this.lostpackagenum = lostpackagenum;
	}

	public int getEmpID() {
		return empID;
	}

	public void setEmpID(int empID) {
		this.empID = empID;
	}

	public String Display() {
		return officeID + " " + type + " " + name + " " + birthdate.Display() + " " + gender + " " + adress.Display()
				+ " " + phone.Display();
	}
}
