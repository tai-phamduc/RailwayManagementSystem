package entity;

import java.time.LocalDateTime;

public class Stop {

	private int stopID;
	private TrainJourney trainJourney;
	private Station station;
	private int stopOrder;
	private int distance;
	private LocalDateTime arrivalTime;
	private LocalDateTime departureTime;

	public Stop(int stopID, TrainJourney trainJourney, Station station, int stopOrder, int distance,
			LocalDateTime arrivalTime, LocalDateTime departureTime) {
			super();
			this.stopID = stopID;
			this.trainJourney = trainJourney;
			this.station = station;
			this.stopOrder = stopOrder;
			this.distance = distance;
			this.arrivalTime = arrivalTime;
			this.departureTime = departureTime;
	}

	public int getStopID() {
		return stopID;
	}

	public void setStopID(int stopID) {
		this.stopID = stopID;
	}

	public TrainJourney getTrainJourney() {
		return trainJourney;
	}

	public void setTrainJourney(TrainJourney trainJourney) {
		this.trainJourney = trainJourney;
	}

	public Station getStation() {
		return station;
	}

	public void setStation(Station station) {
		this.station = station;
	}

	public int getStopOrder() {
		return stopOrder;
	}

	public void setStopOrder(int stopOrder) {
		this.stopOrder = stopOrder;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public LocalDateTime getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(LocalDateTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public LocalDateTime getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(LocalDateTime departureTime) {
		this.departureTime = departureTime;
	}

	@Override
	public String toString() {
		return "Stop [stopID=" + stopID + ", trainJourney=" + trainJourney + ", station=" + station + ", stopOrder="
				+ stopOrder + ", distance=" + distance + ", arrivalTime=" + arrivalTime + ", departureTime="
				+ departureTime + "]";
	}

}
