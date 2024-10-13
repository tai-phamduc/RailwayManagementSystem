package entity;

public class Seat {

	private String seatID;
	private String seatName;
	private String seatType;
	private Coach coach;

	public Seat(String seatID, String seatName, String seatType, Coach coach) {
		super();
		this.seatID = seatID;
		this.seatName = seatName;
		this.seatType = seatType;
		this.coach = coach;
	}

	public String getSeatID() {
		return seatID;
	}

	public void setSeatID(String seatID) {
		this.seatID = seatID;
	}

	public String getSeatName() {
		return seatName;
	}

	public void setSeatName(String seatName) {
		this.seatName = seatName;
	}

	public String getSeatType() {
		return seatType;
	}

	public void setSeatType(String seatType) {
		this.seatType = seatType;
	}

	public Coach getCoach() {
		return coach;
	}

	public void setCoach(Coach coach) {
		this.coach = coach;
	}

	@Override
	public String toString() {
		return "Seat [seatID=" + seatID + ", seatName=" + seatName + ", seatType=" + seatType + ", coach=" + coach
				+ "]";
	}

}
