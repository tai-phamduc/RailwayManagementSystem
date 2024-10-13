package entity;

public class Coach {

	private String coachID;
	private String coachNumber;
	private String coachType;
	private Train train;

	public Coach(String coachID, String coachNumber, String coachType, Train train) {
		super();
		this.coachID = coachID;
		this.coachNumber = coachNumber;
		this.coachType = coachType;
		this.train = train;
	}

	public String getCoachID() {
		return coachID;
	}

	public void setCoachID(String coachID) {
		this.coachID = coachID;
	}

	public String getCoachNumber() {
		return coachNumber;
	}

	public void setCoachNumber(String coachNumber) {
		this.coachNumber = coachNumber;
	}

	public String getCoachType() {
		return coachType;
	}

	public void setCoachType(String coachType) {
		this.coachType = coachType;
	}

	public Train getTrain() {
		return train;
	}

	public void setTrain(Train train) {
		this.train = train;
	}

	@Override
	public String toString() {
		return "Coach [coachID=" + coachID + ", coachNumber=" + coachNumber + ", coachType=" + coachType + ", train="
				+ train + "]";
	}

}
