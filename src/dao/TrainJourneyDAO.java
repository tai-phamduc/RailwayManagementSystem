package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import connectDB.ConnectDB;
import entity.TrainJourneyDetails;

public class TrainJourneyDAO {
	private ConnectDB connectDB;
	
	public TrainJourneyDAO() {
		connectDB = ConnectDB.getInstance();
		connectDB.connect();
	}

	public List<TrainJourneyDetails> getAllTrainJourneyDetails() {
		Connection connection = connectDB.getConnection();
		List<TrainJourneyDetails> trainJourneyDetailsList = new ArrayList<TrainJourneyDetails>();
		ResultSet rs = null;
		try {
			PreparedStatement s = connection.prepareStatement("SELECT trainJourneyID, trainJourneyName, trainNumber, departureStation, arrivalStation, departureTime, arrivalTime, totalDistance, bookedTickets, totalSeats FROM dbo.fn_GetAllTrainJourneyDetails();");
			rs = s.executeQuery();
			while (rs.next()) {
				int trainJourneyID = rs.getInt("trainJourneyID");
				String trainJourneyName = rs.getString("trainJourneyName");
				String trainNumber = rs.getString("trainNumber");
				String departureStation = rs.getString("departureStation");
				String arrivalStation = rs.getString("arrivalStation");
				LocalDateTime departureTime = rs.getTimestamp("departureTime").toLocalDateTime();
				LocalDate departureDate = departureTime.toLocalDate();
				LocalDateTime arrivalTime = rs.getTimestamp("arrivalTime").toLocalDateTime();
				int totalDistance = rs.getInt("totalDistance");
				int bookedTickets = rs.getInt("bookedTickets");
				int totalSeats = rs.getInt("totalSeats");
				
				DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
				
				trainJourneyDetailsList.add(new TrainJourneyDetails(trainJourneyID, trainNumber, trainJourneyName, departureStation + " - " + arrivalStation, departureDate.format(dateFormatter), departureTime.format(formatter) + " - " + arrivalTime.format(formatter), totalDistance, bookedTickets + "/" + totalSeats));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return trainJourneyDetailsList;
	}	
	
}
