package entity;

public class Train {
	private String trainID;
	private String trainNumber;
	private String status;

	public Train(String trainID, String trainNumber, String status) {
		super();
		this.trainID = trainID;
		this.trainNumber = trainNumber;
		this.status = status;
	}

	public String getTrainID() {
		return trainID;
	}

	public void setTrainID(String trainID) {
		this.trainID = trainID;
	}

	public String getTrainNumber() {
		return trainNumber;
	}

	public void setTrainNumber(String trainNumber) {
		this.trainNumber = trainNumber;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Train [trainID=" + trainID + ", trainNumber=" + trainNumber + ", status=" + status + "]";
	}

}
