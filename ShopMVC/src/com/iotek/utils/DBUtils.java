package com.iotek.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBUtils {
	private static String DRIVER;
	private static String URL;
	private static String USERNAME;
	private static String PWD;

	static {
		InputStream in = DBUtils.class.getResourceAsStream("/db.properties");
		Properties prop = new Properties();
		try {
			prop.load(in);
			DRIVER = prop.getProperty("mysql.driver");
			URL = prop.getProperty("mysql.url");
			USERNAME = prop.getProperty("mysql.username");
			PWD = prop.getProperty("mysql.pwd");
			Class.forName(DRIVER);
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConn() throws SQLException {
		return DriverManager.getConnection(URL, USERNAME, PWD);
	}

	public static void close(ResultSet rs, Statement stmt, Connection conn) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
			}
		}

		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
			}
		}

		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
			}
		}
	}
}
