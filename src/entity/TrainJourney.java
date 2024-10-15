package entity;

public class TrainJourney {

	private int trainJourneyID;
	private String traInJourneyName;
	private Train train;
	private double basePrice;
	private Line line;

	public TrainJourney(int trainJourneyID, String traInJourneyName, Train train, double basePrice, Line line) {
		super();
		this.trainJourneyID = trainJourneyID;
		this.traInJourneyName = traInJourneyName;
		this.train = train;
		this.basePrice = basePrice;
		this.line = line;
	}

	public int getTrainJourneyID() {
		return trainJourneyID;
	}

	public void setTrainJourneyID(int trainJourneyID) {
		this.trainJourneyID = trainJourneyID;
	}

	public String getTraInJourneyName() {
		return traInJourneyName;
	}

	public void setTraInJourneyName(String traInJourneyName) {
		this.traInJourneyName = traInJourneyName;
	}

	public Train getTrain() {
		return train;
	}

	public void setTrain(Train train) {
		this.train = train;
	}

	public double getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(double basePrice) {
		this.basePrice = basePrice;
	}

	public Line getLine() {
		return line;
	}

	public void setLine(Line line) {
		this.line = line;
	}

	@Override
	public String toString() {
		return "TrainJourney [trainJourneyID=" + trainJourneyID + ", traInJourneyName=" + traInJourneyName + ", train="
				+ train + ", basePrice=" + basePrice + ", line=" + line + "]";
	}

}
