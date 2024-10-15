package entity;

public class Line {

	private int lineID;
	private String lineName;

	public Line(int lineID, String lineName) {
		super();
		this.lineID = lineID;
		this.lineName = lineName;
	}

	public int getLineID() {
		return lineID;
	}

	public void setLineID(int lineID) {
		this.lineID = lineID;
	}

	public String getLineName() {
		return lineName;
	}

	public void setLineName(String lineName) {
		this.lineName = lineName;
	}

	@Override
	public String toString() {
		return "Line [lineID=" + lineID + ", lineName=" + lineName + "]";
	}

}
