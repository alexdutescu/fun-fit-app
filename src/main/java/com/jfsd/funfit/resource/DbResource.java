package com.jfsd.funfit.resource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbResource {

	private static Connection con = null;

	private DbResource(Connection con) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/funfitdb", "root", "admin");
	}

	public static Connection getDbConnection() {
		try {
			if (con != null && !con.isClosed()) {
				return con;
			} else {
				new DbResource(con);
				return con;
			}
		} catch (Exception e) {
			System.err.println(e);
			return null;
		}
	}
}
