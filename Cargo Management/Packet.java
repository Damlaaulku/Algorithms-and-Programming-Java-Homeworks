
public class Packet {
	private int packetID;
	private Date date;
	private int weight;
	private String volume;
	private int status = 0;
	private String sender;
	private String reciever;

	public Packet(int packetID, Date date, int weight, String volume, String sender, String reciever) {

		this.packetID = packetID;
		this.date = date;
		this.weight = weight;
		this.volume = volume;
		this.status = 0;
		this.sender = sender;
		this.reciever = reciever;
	}

	public int getPacketID() {
		return packetID;
	}

	public void setPacketID(int packetID) {
		this.packetID = packetID;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public String getVolume() {
		return volume;
	}

	public void setVolume(String volume) {
		this.volume = volume;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getReciever() {
		return reciever;
	}

	public void setReciever(String reciever) {
		this.reciever = reciever;
	}

	public String Display() {
		return sender + " " + reciever + " " + weight + " " + volume + " " + date.Display();
	}

}
