package gui.application.form.other.train_journey;

import java.time.format.DateTimeFormatter;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import entity.Stop;
import net.miginfocom.swing.MigLayout;

public class StopRow extends JPanel {
	
	public StopRow(Stop stop) {
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("hh:mm");
		
		this.setLayout(new MigLayout("wrap", "[grow][100px][grow][150px][100px][150px]"));
		
		JLabel stopOrderLabel = new JLabel(stop.getStopOrder() + "");
		JLabel stationLabel = new JLabel(stop.getStation().getStationName());
		JLabel distanceLabel = new JLabel(stop.getDistance() + "");
		JTextField departureDateTexField = new JTextField(stop.getDepartureDate().format(dateFormatter));
		JTextField arrivalTimeTextField = new JTextField(stop.getArrivalTime().format(timeFormatter));
		JTextField departureTimeTextField = new JTextField(stop.getDepartureTime().format(timeFormatter));
		
		this.add(stopOrderLabel);
		this.add(stationLabel);
		this.add(distanceLabel);
		this.add(departureDateTexField, "growx");
		this.add(arrivalTimeTextField, "growx");
		this.add(departureTimeTextField, "growx");
		
	}
	
}
