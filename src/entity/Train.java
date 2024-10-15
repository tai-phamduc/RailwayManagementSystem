package entity;

public class Train {
	private int trainID;
	private String trainNumber;
	private String status;

	public Train(int trainID, String trainNumber, String status) {
		super();
		this.trainID = trainID;
		this.trainNumber = trainNumber;
		this.status = status;
	}

	public Train(String soHieuTau, String trangThai) {
		this.trainNumber = soHieuTau;
		this.status = trangThai;
	}

	public Train(int trainID) {
		this.trainID = trainID;
	}


	public int getTrainID() {
		return trainID;
	}

	public void setTrainID(int trainID) {
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
