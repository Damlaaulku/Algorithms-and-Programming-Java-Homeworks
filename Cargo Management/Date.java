
public class Date {
	private String day;
	private String mounth;
	private String year;

	public Date(String day, String mounth, String year) {

		this.day = day;
		this.mounth = mounth;
		this.year = year;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getMounth() {
		return mounth;
	}

	public void setMounth(String mounth) {
		this.mounth = mounth;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String Display() {
		return day + " " + mounth + " " + year;
	}

	public void DateControl() {

		if (Integer.parseInt(day) <= 0 || Integer.parseInt(day) > 31) {

			System.out.println("Wrong date!");
		}

		else {
			if ((Integer.parseInt(mounth) == 4 || Integer.parseInt(mounth) == 6 || Integer.parseInt(mounth) == 9
					|| Integer.parseInt(mounth) == 11) && Integer.parseInt(day) >= 31) {
				System.out.println("Wrong date!");
			} else if (Integer.parseInt(mounth) == 2 && Integer.parseInt(year) % 4 != 0
					&& Integer.parseInt(day) >= 29) {
				System.out.println("Wrong date!");
			}
		}
	}
}
