package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connectDB.ConnectDB;
import entity.TrainDetails;

public class TrainDAO {
	
	private ConnectDB connectDB;
	
	public TrainDAO() {
		connectDB = ConnectDB.getInstance();
		connectDB.connect();
	}

	public List<TrainDetails> getAllTrainDetails() {
		List<TrainDetails> trainDetailsList = new ArrayList<TrainDetails>();
		Connection connection = connectDB.getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		try {
			statement = connection.prepareStatement("SELECT TrainID, TrainNumber, NumberOfCoaches, Capacity, NumberOfCoachTypes, CoachTypes, Status FROM dbo.GetAllTrainDetails()");
			resultSet = statement.executeQuery();
			
			while (resultSet.next()) {
				String trainID = resultSet.getString("TrainID");
				String trainNumber = resultSet.getString("TrainNumber");
				int numberOfCoaches = resultSet.getInt("NumberOfCoaches");
				int capacity = resultSet.getInt("Capacity");
				int numberOfCoachTypes = resultSet.getInt("NumberOfCoachTypes");
				String coachTypes = resultSet.getString("CoachTypes");
				String status = resultSet.getString("Status");
				trainDetailsList.add(new TrainDetails(trainID, trainNumber, numberOfCoaches, capacity, numberOfCoachTypes, coachTypes, status));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return trainDetailsList;
	}
	
	
}
