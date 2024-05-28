package com.jfsd.funfit.resource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbResource {

	private static DbResource instance;
	private Connection con;

	private DbResource() throws SQLException {
		try {
			Class.forName("org.postgresql.Driver");
			this.con = DriverManager.getConnection("jdbc:mysql://localhost:3306/funfit", "admin", "admin");
		} catch (ClassNotFoundException ex) {
			System.out.println("Database Connection Creation Failed : " + ex.getMessage());
		}
	}

	public Connection getDbConnection() {
		return this.con;
	}

	public static DbResource GetResource() throws SQLException {
		return (instance == null || instance.getDbConnection().isClosed()) ? new DbResource() : instance;
	}
}
