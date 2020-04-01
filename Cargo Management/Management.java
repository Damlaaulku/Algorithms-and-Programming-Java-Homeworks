import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Management {
	private Customer[] customers = new Customer[1000];
	private int cusID = 0;
	private Employee[] employees = new Employee[1000];
	private int empID = 0;
	private Office[] offices = new Office[1000];
	private int offID = 0;
	private Packet[] packets = new Packet[1000];
	private int pacID = 0;
	private Date[] dates = new Date[1000];
	private int dateID = 0;
	private Phone[] phones = new Phone[1000];
	private int phoID = 0;
	private Adress[] adresses = new Adress[1000];
	private int adrID = 0;

	public void Command() throws NumberFormatException, IOException {

		File file = new File("C:\\Users\\damla\\Desktop\\input.txt");

		BufferedReader br = new BufferedReader(new FileReader(file));

		String st;
		String[] readArray = null;

		while ((st = br.readLine()) != null) {
			readArray = st.split(";");

			if (readArray[0].equals("addOffice")) {
				adresses[adrID] = new Adress(readArray[2], readArray[3], readArray[4]);
				phones[phoID] = new Phone(readArray[5]);
				offices[offID] = new Office(offID, readArray[1], adresses[adrID], phones[phoID]);
				adrID++;
				phoID++;
				offID++;

			} else if (readArray[0].equals("addEmployee")) {
				adresses[adrID] = new Adress(readArray[6], readArray[7], readArray[8]);
				phones[phoID] = new Phone(readArray[9]);
				dates[dateID] = new Date(readArray[4].substring(0, 2), readArray[4].substring(3, 5),
						readArray[4].substring(6));
				String type = readArray[2];
				int lostpacketnum = 0;

				if (type.equals("officeboy")) {
					employees[empID] = new Employee(offices[offID], readArray[3], dates[dateID], readArray[5],
							adresses[adrID], phones[phoID], readArray[2], empID);
					empID++;
					dateID++;
					phoID++;
					adrID++;
				}
				if (type.equals("servicestaff")) {

					employees[empID] = new Employee(offices[offID], readArray[3], dates[dateID], readArray[5],
							adresses[adrID], phones[phoID], readArray[2], lostpacketnum, empID);
					empID++;
					dateID++;
					phoID++;
					adrID++;
					lostpacketnum++;
				}
			}

			else if (readArray[0].equals("addCustomer")) {
				adresses[adrID] = new Adress(readArray[5], readArray[6], readArray[7]);
				phones[phoID] = new Phone(readArray[8]);
				dates[dateID] = new Date(readArray[2].substring(0, 2), readArray[2].substring(3, 5),
						readArray[2].substring(6));
				customers[cusID] = new Customer(cusID, readArray[1], dates[dateID], readArray[3], readArray[4],
						adresses[adrID], phones[phoID]);
				adrID++;
				phoID++;
				dateID++;
				cusID++;
			} else if (readArray[0].equals("addPacket")) {

				dates[dateID] = new Date(readArray[5].substring(0, 2), readArray[5].substring(3, 5),
						readArray[5].substring(6));
				int weight = Integer.parseInt(readArray[3]);
				String volume = readArray[4];
				packets[pacID] = new Packet(pacID, dates[dateID], weight, volume,
						readArray[1], readArray[3]);
				dateID++;
				pacID++;
			} else if (readArray[0].equals("updateOffice")) {
				if (offices[Integer.parseInt(readArray[1])] == null) {
					System.out.println("This office does not exist");
				} else {
					if (Integer.parseInt(readArray[1]) == offices[Integer.parseInt(readArray[1])].getOfficeID()) {
						adresses[Integer.parseInt(readArray[1])].setAddress(readArray[3]);
						adresses[Integer.parseInt(readArray[1])].setTown(readArray[4]);
						adresses[Integer.parseInt(readArray[1])].setCity(readArray[5]);
						phones[Integer.parseInt(readArray[1])].setPhone(readArray[6]);
						offices[Integer.parseInt(readArray[1])].setName(readArray[2]);
						offices[Integer.parseInt(readArray[1])].setAdress(adresses[Integer.parseInt(readArray[1])]);
						offices[Integer.parseInt(readArray[1])].setPhone(phones[Integer.parseInt(readArray[1])]);
					}
				}
			} else if (readArray[0].equals("updateEmployee")) {
				if (Integer.parseInt(readArray[1]) == employees[Integer.parseInt(readArray[1])].getEmpID()) {
					adresses[Integer.parseInt(readArray[1])].setAddress(readArray[7]);
					adresses[Integer.parseInt(readArray[1])].setTown(readArray[8]);
					adresses[Integer.parseInt(readArray[1])].setCity(readArray[9]);
					phones[Integer.parseInt(readArray[1])].setPhone(readArray[10]);
					dates[Integer.parseInt(readArray[1])].setDay(readArray[5]);
					dates[Integer.parseInt(readArray[1])].setMounth(readArray[5]);
					dates[Integer.parseInt(readArray[1])].setYear(readArray[5]);
					offices[Integer.parseInt(readArray[1])].setOfficeID(Integer.parseInt(readArray[2]));
					employees[Integer.parseInt(readArray[1])].setType(readArray[3]);
					employees[Integer.parseInt(readArray[1])].setName(readArray[4]);
					employees[Integer.parseInt(readArray[1])].setGender(readArray[6]);
					employees[Integer.parseInt(readArray[1])].setAdress(adresses[Integer.parseInt(readArray[1])]);
					employees[Integer.parseInt(readArray[1])].setPhone(phones[Integer.parseInt(readArray[1])]);
					employees[Integer.parseInt(readArray[1])].setBirthdate(dates[Integer.parseInt(readArray[1])]);

				} else {
					System.out.println("This employee does not exist");
				}
			} else if (readArray[0].equals("updateCustomer")) {
				if (Integer.parseInt(readArray[1]) == customers[Integer.parseInt(readArray[1])].getCustomerID()) {
					adresses[Integer.parseInt(readArray[1])].setAddress(readArray[6]);
					adresses[Integer.parseInt(readArray[1])].setTown(readArray[7]);
					adresses[Integer.parseInt(readArray[1])].setCity(readArray[8]);
					phones[Integer.parseInt(readArray[1])].setPhone(readArray[9]);
					dates[Integer.parseInt(readArray[1])].setDay(readArray[3]);
					dates[Integer.parseInt(readArray[1])].setMounth(readArray[3]);
					dates[Integer.parseInt(readArray[1])].setYear(readArray[3]);
					customers[Integer.parseInt(readArray[1])].setName(readArray[2]);
					customers[Integer.parseInt(readArray[1])].setEmail(readArray[5]);
					customers[Integer.parseInt(readArray[1])].setBirthdate(dates[Integer.parseInt(readArray[1])]);
					customers[Integer.parseInt(readArray[1])].setGender(readArray[4]);
					customers[Integer.parseInt(readArray[1])].setAdress(adresses[Integer.parseInt(readArray[1])]);
					customers[Integer.parseInt(readArray[1])].setPhone(phones[Integer.parseInt(readArray[1])]);
				} else {
					System.out.println("This customer does not exist");
				}
			} else if (readArray[0].equals("updatePacket")) {
				if (Integer.parseInt(readArray[1]) == packets[Integer.parseInt(readArray[1])].getPacketID()) {
					dates[Integer.parseInt(readArray[1])].setDay(readArray[6]);
					dates[Integer.parseInt(readArray[1])].setMounth(readArray[6]);
					dates[Integer.parseInt(readArray[1])].setYear(readArray[6]);
					packets[Integer.parseInt(readArray[1])].setSender(readArray[2]);
					customers[Integer.parseInt(readArray[1])].setCustomerID(Integer.parseInt(readArray[3]));
					packets[Integer.parseInt(readArray[1])].setReciever((readArray[3]));
					packets[Integer.parseInt(readArray[1])].setDate(dates[Integer.parseInt(readArray[1])]);
					packets[Integer.parseInt(readArray[1])].setWeight(Integer.parseInt(readArray[4]));
					packets[Integer.parseInt(readArray[1])].setVolume(readArray[5]);
					packets[Integer.parseInt(readArray[1])].setDate(dates[Integer.parseInt(readArray[1])]);
				} else {
					System.out.println("This packet does not exist");
				}
			} else if (readArray[0].equals("deleteEmployee")) {
				if (Integer.parseInt(readArray[1]) == Integer.parseInt(readArray[1])) {
					employees[Integer.parseInt(readArray[1])].setFlag(false);
				} else {
					System.out.println("This employee does not exist");
				}
			} else if (readArray[0].equals("deleteCustomer")) {

				if (customers[Integer.parseInt(readArray[1])] == null) {
					System.out.println("This customer does not exist");
				} else {
					if (Integer.parseInt(readArray[1]) == Integer.parseInt(readArray[1])) {
						customers[Integer.parseInt(readArray[1])].setFlag(false);
					}
				}
			} else if (readArray[0].equals("deliverPacket")) {
				packets[Integer.parseInt(readArray[1])].setStatus(1);

				for (int i = 1; i < packets.length; i++) {
					if (packets[i] == null)
						break;

					if (Integer.parseInt(readArray[1]) == employees[i].getEmpID()) {
						if (employees[i] == null)
							break;

						int sweight;
						sweight = packets[i].getWeight();
						int weight = sweight;

						if (packets[i].getVolume().equals("small") && weight >= 1 && weight <= 5)

						{
							offices[i].setIncome(offices[i].getIncome() + 10);

						}

						if (packets[i].getVolume().equals("medium") && weight >= 1 && weight <= 5) {
							offices[i].setIncome(offices[i].getIncome() + 15);

						}
						if (packets[i].getVolume().equals("large") && weight >= 1 && weight <= 5) {
							offices[i].setIncome(offices[i].getIncome() + 20);

						}
						if (packets[i].getVolume().equals("small") && weight >= 6 && weight <= 10)

						{
							offices[i].setIncome(offices[i].getIncome() + 25);

						}

						if (packets[i].getVolume().equals("medium") && weight >= 6 && weight <= 10) {
							offices[i].setIncome(offices[i].getIncome() + 30);

						}
						if (packets[i].getVolume().equals("large") && weight >= 6 && weight <= 10) {
							offices[i].setIncome(offices[i].getIncome() + 40);

						}
						if (packets[i].getVolume().equals("small") && weight >= 11)

						{
							offices[i].setIncome(offices[i].getIncome() + 45);

						}

						if (packets[i].getVolume().equals("medium") && weight >= 11) {
							offices[i].setIncome(offices[i].getIncome() + 50);

						}
						if (packets[i].getVolume().equals("large") && weight >= 11) {
							offices[i].setIncome(offices[i].getIncome() + 55);

						}
					}
				}
			} else if (readArray[0].equals("lossPacket")) {
				packets[Integer.parseInt(readArray[1])].setStatus(2);
				employees[Integer.parseInt(readArray[2])]
						.setLostpackagenum(employees[Integer.parseInt(readArray[2])].getLostpackagenum() + 1);
				if (employees[Integer.parseInt(readArray[2])].getLostpackagenum() == 3) {
					employees[Integer.parseInt(readArray[2])].setFlag(false);
				}
			} else if (readArray[0].equals("trackPacket")) {
				int status = packets[Integer.parseInt(readArray[1])].getStatus();
				if (status == 0) {
					System.out.println("Package not delivered.");
				} else if (status == 1) {
					System.out.println("Package delivered.");
				} else if (status == 2) {
					System.out.println("Sorry :( We lost your packet.");
				}
			} else if (readArray[0].equals("listOffices")) {
				for (int i = 0; i <= offID; i++) {
					if (offices[i] == null)
						break;
					System.out.println(offices[i].Display());
				}
			} else if (readArray[0].equals("listEmployees")) {
				for (int i = 0; i <= empID; i++) {
					if (employees[i] == null)
						break;
					System.out.println(employees[i].Display());
				}
			} else if (readArray[0].equals("listCustomers")) {
				for (int i = 0; i <= cusID; i++) {
					if (customers[i] == null)
						break;
					System.out.println(customers[i].Display());
				}
			} else if (readArray[0].equals("listPackets")) {
				for (int i = 0; i <= pacID; i++) {
					if (packets[i] == null)
						break;
					System.out.println(packets[i].Display());
				}
			}

			/*
			 if (readArray[0].equals("search")) {
			  
			  }
			  
			  if (readArray[0].equals("top3Customers")) { job count }
			 */

			else if (readArray[0].equals("increaseSalaries")) {
				for (int i = 0; i < employees.length; i++) {
					double para = 0;
					if (employees[i] == null) {
						break;
					} else {
						para = (employees[i].getSalary()) + (employees[i].getSalary() / 10);
						employees[i].setSalary(para);
					}
				}
			} 
			else if (readArray[0].equals("totalIncome")) {
				System.out.println(offices[Integer.parseInt(readArray[1])].getIncome());
			}
		}
	}
}
