package fr.humanbooster.fx.test_technique.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnexionBdd {

	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/business_case?verifyServerCertificate=false&useSSL=true", "root", "");
		return connection;
	}

	public static void close() throws SQLException, ClassNotFoundException {
		getConnection().close();
	}
}