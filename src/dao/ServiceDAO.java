package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connectDB.ConnectDB;
import entity.Service;

public class ServiceDAO {

	private ConnectDB connectDB;

	public ServiceDAO() {
		connectDB = ConnectDB.getInstance();
		connectDB.connect();
	}

	public List<Service> getServiceByType(String type) {
		List<Service> services = new ArrayList<>();
		Connection connection = connectDB.getConnection();
		String querySQL = "SELECT * FROM Service WHERE ServiceType = ?";
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		try {
			statement = connection.prepareStatement(querySQL);
			statement.setString(1, type);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Service service = new Service(resultSet.getString("ServiceID"));

				service.setServiceName(resultSet.getString("ServiceName"));
				service.setPrice(resultSet.getDouble("ServicePrice"));
				service.setImageSource(resultSet.getString("ImageSource"));
				service.setType(type);

				services.add(service);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectDB.close(statement, resultSet);
		}
		return services;
	}

//	public List<Product> getAllProduct() {
//		Connection connection = connectDB.getConnection();
//		List<Product> productList = null;
//		try {
//			PreparedStatement s = connection.prepareStatement("select * from product");
//			ResultSet rs = s.executeQuery();
//			productList = new ArrayList<Product>();
//			while (rs.next()) {
//				String productID = rs.getString(1);
//				String productName = rs.getString(2);
//				double price = rs.getDouble(3);
//				int quantity = rs.getInt(4);
//				double purchasePrice = rs.getDouble(5);
//				String imageSource = rs.getString(6);
//				String productType = rs.getString(7);
//				productList.add(
//						new Product(productID, productName, price, quantity, purchasePrice, imageSource, productType));
//			}
//			return productList;
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return productList;
//	}
//
//	public void updateQtyById(String productID, int quantity) {
//		Connection connection = connectDB.getConnection();
//		PreparedStatement s;
//		try {
//			s = connection.prepareStatement("update product set quantity = quantity - ? where productid = ?");
//			s.setInt(1, quantity);
//			s.setString(2, productID);
//			s.executeUpdate();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//
//	}

	public List<Service> findFoodByName(String serviceName) {
		Connection connection = connectDB.getConnection();
		String querySQL = "SELECT * FROM Service WHERE ServiceName LIKE ? AND ServiceType = 'Food'";
		List<Service> foods = new ArrayList<Service>();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(querySQL);
			preparedStatement.setString(1, "%" + serviceName + "%");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				String id = resultSet.getString("ServiceID");
				String name = resultSet.getString("ServiceName");
				double price = resultSet.getDouble("ServicePrice");
				String type = resultSet.getString("ServiceType");
				String image = resultSet.getString("ImageSource");

				foods.add(new Service(id, name, price, type, image));
			}
			return foods;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<Service> findDrinkByName(String serviceName) {
		Connection connection = connectDB.getConnection();
		String querySQL = "SELECT * FROM Service WHERE ServiceName LIKE ? AND ServiceType = 'Drink'";
		List<Service> drinks = new ArrayList<Service>();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(querySQL);
			preparedStatement.setString(1, "%" + serviceName + "%");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				String id = resultSet.getString("ServiceID");
				String name = resultSet.getString("ServiceName");
				double price = resultSet.getDouble("ServicePrice");
				String image = resultSet.getString("ImageSource");

				drinks.add(new Service(id, name, price, "Drink", image));
			}
			return drinks;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

//	public String addNewProduct(Product newProduct) {
//		Connection connection = null;
//		CallableStatement callableStatement = null;
//		ResultSet rs = null;
//		String productID = null;
//
//		try {
//			connection = connectDB.getConnection();
//			String querySQL = "{CALL AddNewProduct(?, ?, ?, ?, ?, ?)}";
//			callableStatement = connection.prepareCall(querySQL);
//
//			callableStatement.setString(1, newProduct.getProductName());
//			callableStatement.setInt(2, newProduct.getQuantity());
//			callableStatement.setDouble(3, newProduct.getPurchasePrice());
//			callableStatement.setString(4, newProduct.getImageSource());
//			callableStatement.setString(5, newProduct.getProductType());
//			callableStatement.registerOutParameter(6, Types.CHAR);
//
//			callableStatement.execute();
//
//			productID = callableStatement.getString(6);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			connectDB.close(callableStatement, rs);
//		}
//		return productID;
//	}
//
//	public boolean addNewDrink(Product newProduct) {
//		Connection connection = connectDB.getConnection();
//		PreparedStatement preparedStatement = null;
//
//		String querySQL = "INSERT INTO Product (ProductName, Quantity, PurchasePrice, ImageSource, ProductType) VALUES (?, ?, ?, ?, 'Drink')";
//		try {
//			preparedStatement = connection.prepareStatement(querySQL);
//			preparedStatement.setString(1, newProduct.getProductID());
//			preparedStatement.setInt(2, newProduct.getQuantity());
//			preparedStatement.setDouble(3, newProduct.getPurchasePrice());
//			preparedStatement.setString(4, newProduct.getImageSource());
//
//			int rowsAffected = preparedStatement.executeUpdate();
//
//			return rowsAffected > 0;
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			connectDB.close(preparedStatement, null);
//		}
//		return false;
//	}
//
//	public boolean removeProductByID(String productID) {
//		Connection connection = connectDB.getConnection();
//		String deleteSQL = "DELETE FROM Product WHERE ProductID = ?";
//		PreparedStatement preparedStatement = null;
//		try {
//			preparedStatement = connection.prepareStatement(deleteSQL);
//			preparedStatement.setString(1, productID);
//			int rowsAffected = preparedStatement.executeUpdate();
//			return rowsAffected > 0;
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			connectDB.close(preparedStatement, null);
//		}
//		return false;
//	}
//
//	public boolean updateNewProduct(Product newProduct) {
//		Connection connection = connectDB.getConnection();
//		PreparedStatement preparedStatement = null;
//
//		String updateSQL = "UPDATE Product SET ProductName = ?, PurchasePrice = ?, ImageSource = ? WHERE ProductID = ?";
//		try {
//			preparedStatement = connection.prepareStatement(updateSQL);
//			preparedStatement.setString(1, newProduct.getProductName());
//			preparedStatement.setDouble(2, newProduct.getPurchasePrice());
//			preparedStatement.setString(3, newProduct.getImageSource());
//			preparedStatement.setString(4, newProduct.getProductID());
//
//			int rowsAffected = preparedStatement.executeUpdate();
//
//			return rowsAffected > 0;
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			connectDB.close(preparedStatement, null);
//		}
//		return false;
//	}
//
//	public boolean addQuantity(String productID, int qty) {
//		Connection connection = connectDB.getConnection();
//		CallableStatement callableStatement = null;
//
//		try {
//			String querySQL = "{CALL UpdateProductQuantityByID(?, ?)}";
//			callableStatement = connection.prepareCall(querySQL);
//
//			callableStatement.setString(1, productID);
//			callableStatement.setInt(2, qty);
//
//			callableStatement.execute();
//
//			return true;
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			connectDB.close(callableStatement, null);
//		}
//		return false;
//	}

}